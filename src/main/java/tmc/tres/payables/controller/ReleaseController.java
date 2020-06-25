package tmc.tres.payables.controller;

import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;

import tmc.tres.payables.dao.Disbursement_Repo;
import tmc.tres.payables.dao.Payables_Repo;
import tmc.tres.payables.dao.Payment_Repo;
import tmc.tres.payables.dao.Release_Repo;
import tmc.tres.payables.model.Disbursement;
import tmc.tres.payables.model.Payables;
import tmc.tres.payables.model.PaymentRequest;
import tmc.tres.payables.model.Release;
import tmc.tres.payables.model.Status;

@RestController
public class ReleaseController {

	@Autowired
	Release_Repo release_repo;

	@Autowired
	Disbursement_Repo disbursement_repo;

	@Autowired
	Payables_Repo payables_repo;

	@PostMapping(path = "/release/{disbursementId}/{option}")
	@ResponseBody
	public void Release(@RequestBody Release release, @PathVariable("disbursementId") long disbursementId,
			@PathVariable("option") String opt) {

		// Get Disbursement Entity based from client's disbursement id
		Disbursement disbursement = new Disbursement();

		try {
			disbursement = disbursement_repo.findBydisbursementId(disbursementId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (disbursement == null) {
			throw new MultipartException("Disbursement with id: " + disbursementId + "Doesn't exist.");
		} else {

			Payables payable = new Payables();
			payable = payables_repo.findByDisbursement(disbursement);

			if (payable.getRelease() == null) {
				Release strRelease = new Release();
				strRelease = release_repo.save(release);

				if (release_repo.findByreleaseId(strRelease.getReleaseId()) != null) {

					// Update payable with released disbursed payment
					payable.setRelease(release);

					// Insert Status Assignment Here To be Work 6/5/2020
					Status status = new Status();

					switch (opt) {
					case "onhold":
						status.setStatusId(8);
						break;
					case "cancel":
						status.setStatusId(6);
						release.setDateCancelled(Calendar.getInstance().getTime());
						break;
					case "fund":
						status.setStatusId(9);
						release.setDateFunded(Calendar.getInstance().getTime());
						break;
					case "release":
						status.setStatusId(5);
						release.setDateReleased(Calendar.getInstance().getTime());
						break;
					case "pendingforfund":
						status.setStatusId(4);
						break;
					}

					payable.setStatus(status);
					System.out.println("Status : " + payable.getStatus().getStatusDescription());
					payables_repo.save(payable);

					// Set Release's Assigned Payable
					release.setPayables(payable);
					release_repo.save(release);
				} else {
					throw new MultipartException("Releasing Error");
				}
			} else {
				System.out.println("Disbursed Payment has already released record.");
			}
		}
	}

	@PutMapping(path = "/updateRelease/{option}")
	@ResponseBody
	public void updateRelease(@RequestBody Release release, @PathVariable("option") String opt) {

		Payables payable = new Payables();
		payable = payables_repo.findByRelease(release);

		if (payable.getRelease() != null) {

			Boolean opStatus = true;

			try {
				release_repo.save(release);
			} catch (Exception e) {
				System.out
						.println("Error updating release:" + release.getReleaseId() + " with error: " + e.getMessage());
				opStatus = false;
			}

			if (opStatus == true) {
				Status status = new Status();
				switch (opt) {
				case "onhold":
					status.setStatusId(8);
					break;
				case "cancel":
					status.setStatusId(6);
					release.setDateCancelled(Calendar.getInstance().getTime());
					break;
				case "fund":
					status.setStatusId(9);
					release.setDateFunded(Calendar.getInstance().getTime());
					break;
				case "release":
					status.setStatusId(5);
					release.setDateReleased(Calendar.getInstance().getTime());
					break;
				case "pendingfund":
					status.setStatusId(4);
					break;
				}

				payable.setStatus(status);
				payables_repo.save(payable);

				release.setPayables(payable);
				release_repo.save(release);
			} else {
				System.out.println("Failed Updating Payable, Please Review Updated Data of Release.");
			}

		} else {
			System.out.println("Release with id : " + release.getReleaseId() + "doesn't exist.");
		}

	}

	@RequestMapping("/releases")
	@ResponseBody
	public List<Release> Releases() {
		return release_repo.findAll();
	}

	@RequestMapping("/getRelease/{releaseId}")
	@ResponseBody
	public Release getPaymentRequest(@PathVariable("releaseId") long releaseId) {
		return release_repo.findByreleaseId(releaseId);
	}
}

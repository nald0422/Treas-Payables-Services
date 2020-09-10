package tmc.tres.payables.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Section_Repo;
import tmc.tres.payables.model.Section;

@RestController
public class SectionController {

	@Autowired
	Section_Repo section_repo;
	
	@PostMapping(path="/addSection")
	@ResponseBody
	public void addSection(@RequestBody Section section) {		
		section_repo.save(section);
	}
	
	@PutMapping(path="/updateSection")
	@ResponseBody
	public void updateDesignation(@RequestBody Section section) {
		section_repo.save(section);
	}
	
	@RequestMapping("/removeSection/{sectionId}")
	public void deleteDesignation(@PathVariable("sectionId") int sectionId) {
		section_repo.deleteById(sectionId);
	}
	
	@GetMapping(path="/sections", produces= {"application/json"})
	@ResponseBody
	public List<Section> getSections() {
		return section_repo.findAll();
	}
	
	@GetMapping("/getSection/{sectionId}") 
	@ResponseBody
	public Optional<Section> getSection(@PathVariable("sectionId") int sectionId) {
		return section_repo.findById(sectionId);
	}
}

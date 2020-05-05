package tmc.tres.payables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Release_Repo;

@RestController
public class ReleaseController {

	@Autowired
	Release_Repo release_repo;
}

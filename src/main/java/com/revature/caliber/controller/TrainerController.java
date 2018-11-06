package com.revature.caliber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.pojo.Trainer;
import com.revature.caliber.service.TrainerServiceModel;

@RestController
@CrossOrigin(origins="*")
/**
 * Controller for handling all requests having to do with Trainers
 * @author Ben Nemec
 *
 */
public class TrainerController {
	
	@Autowired
	TrainerServiceModel tsm;
	
	/**
	 * Handles get request for all trainers
	 * @return A response entity with an OK status code and a list of all of the
	 * trainers as a JSON object
	 */
	@GetMapping(value="all/trainer/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainer>> getAllTrainers() {
		return new ResponseEntity<>(tsm.getAllTrainers(), HttpStatus.OK);
	}

}

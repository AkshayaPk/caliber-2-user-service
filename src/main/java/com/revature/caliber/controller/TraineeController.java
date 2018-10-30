package com.revature.caliber.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.pojo.Trainee;
import com.revature.caliber.service.TraineeServiceModel;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="user")
public class TraineeController {
	
	private static final Logger log = LoggerFactory.getLogger(TraineeController.class);
	
	@Autowired
	private TraineeServiceModel tsm;
	
	@GetMapping(value="all/trainee", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainee>> findAllByBatch(
			@RequestParam(required=true) Integer batch){
		log.trace("in all/trainee: Looking for batch: " + batch);
		List<Trainee> trainees = tsm.findAllByBatch(batch);
		//List<Trainee> trainees = new ArrayList<Trainee>();
		//trainees.add(new Trainee("Nemec, Ben", null, "bignems@rocketmail.com", 2200));
		return new ResponseEntity<>(trainees, HttpStatus.OK);
	}

}

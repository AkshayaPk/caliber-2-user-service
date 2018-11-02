package com.revature.caliber.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.pojo.Trainee;
import com.revature.caliber.service.TraineeServiceModel;

/** Controller for handling all requests having to do with trainees.
 * 
 * @author Ben Nemec and Jacques Myette
 *
 */
@RestController
@CrossOrigin(origins="*")
public class TraineeController {
	
	/**
	 * Logger for this class
	 */
	private static final Logger log = LoggerFactory.getLogger(TraineeController.class);
	
	/**
	 * Autowired interface declaration for the trainee service
	 */
	@Autowired
	private TraineeServiceModel tsm;
	
	/**
	 * Handles get request for returning all trainees with the given batch id
	 * as a request parameter
	 * @param batch The batch id representing the batch to get all the trainees from
	 * @return The list of trainees with the correct batch id as well as an ok http status code
	 */
	@GetMapping(value="all/trainee", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainee>> findAllByBatch(
			@RequestParam(required=true) Integer batch){
		log.trace("in all/trainee: Looking for batch: " + batch);
		List<Trainee> trainees = tsm.findAllByBatch(batch);
		System.out.println(trainees.get(0));
		return new ResponseEntity<>(trainees, HttpStatus.OK);
	}
	
	/**
	 * Handles post request for creating a trainee in a batch
	 * @param trainee The trainee form object to make a trainee from 
	 * @return The created trainee as well as an ok http status code
	 */
	@PostMapping(value="all/trainee/create", produces=MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Trainee> createTrainee(@Valid @RequestBody Trainee trainee) {
		log.debug("Saving trainee: " + trainee);
		System.out.println(trainee);
		tsm.save(trainee);
		return new ResponseEntity<>(trainee, HttpStatus.CREATED);
	}
	/**
	 * Handles put request for creating a trainee in a batch
	 * @param trainee The trainee to be updated
	 * @return The updated Trainee object and an accepted http-status code
	 */
	@PutMapping(value="all/trainee/update", produces=MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Trainee> updateTrainee(@Valid @RequestBody Trainee trainee) {
		log.debug("Updating trainee: " + trainee);
		tsm.update(trainee);
		return new ResponseEntity<>(trainee, HttpStatus.ACCEPTED);
	}
	/**
	 * Handles delete request for creating a trainee in a batch
	 * @param id the id of the trainee to be deleted
	 * @return a response entity that has a void value and an http-status of NO_CONTENT.
	 */
	@DeleteMapping(value="all/trainee/delete/{id}")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Void> deleteTrainee(@PathVariable Integer id){
		tsm.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

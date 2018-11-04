package com.revature.caliber.service;

import java.util.List;

import com.revature.caliber.pojo.Trainer;

/**
 * Interface for the service that handles all business logic having to do with
 * trainers
 * @author Ben Nemec
 *
 */
public interface TrainerServiceModel {
	
	/**
	 * Gets all of the trainers in the database
	 * @return A list of all of the trainers in the database
	 */
	public List<Trainer> getAllTrainers();

}

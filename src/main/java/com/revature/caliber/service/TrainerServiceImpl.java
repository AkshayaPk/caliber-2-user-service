package com.revature.caliber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.caliber.dao.TrainerRepository;
import com.revature.caliber.pojo.Trainer;

/**
 * Implementation of the business logic for handling Trainer objects
 * @author Ben Nemec
 *
 */
public class TrainerServiceImpl implements TrainerServiceModel {
	
	@Autowired
	TrainerRepository dao;

	@Override
	public List<Trainer> getAllTrainers() {
		return null;
	}

	@Override
	public Trainer getTrainerById(Integer trainerId) {
		return null;
	}

}

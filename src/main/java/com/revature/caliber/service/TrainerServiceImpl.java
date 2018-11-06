package com.revature.caliber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.dao.TrainerRepository;
import com.revature.caliber.pojo.Trainer;

/**
 * Implementation of the business logic for handling Trainer objects
 * @author Ben Nemec
 *
 */
@Service
public class TrainerServiceImpl implements TrainerServiceModel {
	
	/**
	 * The dao responsible for interacting with the trainer table
	 */
	@Autowired
	TrainerRepository dao;

	@Override
	public List<Trainer> getAllTrainers() {
		return dao.findAll();
	}

}

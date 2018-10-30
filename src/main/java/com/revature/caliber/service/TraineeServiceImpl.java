package com.revature.caliber.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.dao.TraineeRepository;
import com.revature.caliber.pojo.Trainee;

/**Service class for handling business logic of interacting with trainee objects
 * 
 * @author Christian Dawson and Justin Donn
 *
 */
@Service
public class TraineeServiceImpl implements TraineeServiceModel {
	
	/**
	 * Logger for the TraineeServiceImpl class
	 */
	private static final Logger log = LoggerFactory.getLogger(TraineeServiceImpl.class);
	
	/**
	 * The dao responsible for interacting with the trainee table
	 */
	@Autowired 
	TraineeRepository dao;
	
	/**
	 * Creates a trainee in the database
	 * @param trainee The trainee to create in the database
	 */
	@Override
	public void save(Trainee trainee){
		dao.save(trainee);
	}

	/**
	 * Gets all the trainees from a given batch id
	 * @param batchId The id of the batch whose trainees will be retrieved
	 * @return A list of the trainees from the given batch
	 */
	@Override
	public List<Trainee> findAllByBatch(Integer batchId) {
		List<Trainee> trainees = dao.findAll();
		for(int i = 0; i < trainees.size(); i++) {
			if(!trainees.get(i).getBatchId().equals(batchId)) {
				trainees.remove(i);
				i--;
			}
		}
		return trainees;
	}

	/**
	 * Updates the trainee in the database
	 * @param trainee The trainee to update in the database
	 */
	@Override
	public void update(Trainee trainee) {
		dao.save(trainee);
	}

	/**
	 * Removes a trainee from the database
	 * @param trainee The trainee to be removed from the database
	 */
	@Override
	public void delete(Trainee trainee) {
		dao.delete(trainee);
	}

	/**
	 * Switches the batch of a given trainee to the given batch
	 * @param traineeId The id of the trainee that is switching batches
	 * @param batchId The id of the batch that the trainee is being switched to
	 */
	@Override
	public void switchBatch(Integer traineeId, Integer batchId) {
		Trainee trainee = dao.findOne(traineeId);
		if(trainee != null) {
			trainee.setBatchId(batchId);
		}
		dao.save(trainee);
	}
}

package com.revature.caliber.service;

import java.util.List;

import com.revature.caliber.pojo.Trainee;

/**
 * Interface of the service class for handling business logic 
 * of interacting with trainee objects
 * 
 * @author Christian Dawson, and Justin Donn
 *
 */
public interface TraineeServiceModel {
	
	/**
	 * Creates a trainee in the database
	 * @param trainee The trainee to create in the database
	 */
	public void save(Trainee trainee);
	
	/**
	 * Gets all the trainees with a given batch id
	 * @param batchId The id of the batch whose trainees will be retrieved
	 * @return A list of the trainees from the given batch
	 */
	public List<Trainee> findAllByBatch(Integer batchId);
	
	/**
	 * Updates the trainee in the database
	 * @param trainee The trainee to update in the database
	 */
	public void update(Trainee trainee);
	
	/**
	 * Removes a trainee from the database
	 * @param trainee The trainee to be removed from the database
	 */
	public void delete(Integer traineeId);
	
	/**
	 * Switches the batch of a given trainee to the given batch
	 * @param traineeId The id of the trainee that is switching batches
	 * @param batchId The id of the batch that the trainee is being switched to
	 */
	public void switchBatch(Integer traineeId, Integer batchId);

	/**
	 * Finds all the trainees associated with every batch
	 * @param batchIds a list of all batchIds
	 * @return the number of trainees in each batch in a integer double array
	 */
	public Integer[][] createArrayOfTraineeCounts(Integer[] batchIds);
	
}

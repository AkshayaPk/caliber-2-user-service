package com.revature.caliber.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.pojo.Trainee;

/** Handles retrieving trainees from a database
 * @author Christian Dawson, Justin Donn, and Ben Nemec
 * 
 */
@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer> {
	
	/**
	 * Gets all of the Trainees from the database where they have the given batchId
	 * @param batchId The id representing the batch to get all the trainees from
	 * @return A list of all the trainees in the given batch
	 */
	public List<Trainee> findByBatchId(Integer batchId);
	
	/**
	 * Gets the number of trainees in a batch
	 * @param batchId The id representing the batch to count the number of trainees for
	 * @return The number of trainees in the given batch
	 */
	public Long countByBatchId(Integer batchId);

}

package com.revature.caliber.service;

import java.util.List;

import com.revature.caliber.pojo.Trainee;

 /**
 * @author Christian Dawson and Justin Donn
 *
 */
public interface TraineeServiceModel {
	public void save(Trainee trainee);
	public List<Trainee> findAllByBatch(Integer batchId);
	public void update(Trainee trainee);
	public void delete(Trainee trainee);
	public void switchBatch(Integer traineeId, Integer batchId);
}

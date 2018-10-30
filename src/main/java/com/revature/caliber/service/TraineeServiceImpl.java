package com.revature.caliber.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.dao.TraineeRepository;
import com.revature.caliber.pojo.Trainee;

@Service
public class TraineeServiceImpl implements TraineeServiceModel {
	
	private static final Logger log = LoggerFactory.getLogger(TraineeServiceImpl.class);
	
	@Autowired 
	TraineeRepository dao;
	
	@Override
	public void save(Trainee trainee){
		dao.save(trainee);
	}

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

	@Override
	public void update(Trainee trainee) {
		dao.save(trainee);
		
	}

	@Override
	public void delete(Trainee trainee) {
		dao.delete(trainee);
	}

	@Override
	public void switchBatch(Integer traineeId, Integer batchId) {
		Trainee trainee = dao.findOne(traineeId);
		if(trainee != null) {
			trainee.setBatchId(batchId);
		}
		dao.save(trainee);
	}
}

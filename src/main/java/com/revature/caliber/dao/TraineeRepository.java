package com.revature.caliber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.pojo.Trainee;

/** Handles retrieving trainees from a database
 * @author Christian Dawson and Justin Donn
 * 
 */
@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

}

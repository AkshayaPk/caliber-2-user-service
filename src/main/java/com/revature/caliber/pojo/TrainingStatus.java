package com.revature.caliber.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TrainingStatus implements Serializable{
	
	/**
	 * Trainee is Signed (has signed the contract)
	 */
	@JsonProperty("Signed")
	Signed,
	
	/**
	 * Trainee is Selected for training
	 */
	@JsonProperty("Selected")
	Selected,
	
	/**
	 * Trainee is currently in training
	 */
	@JsonProperty("Training")
	Training,
	
	/**
	 * Trainee is marketing
	 */
	@JsonProperty("Marketing")
	Marketing,
	
	/**
	 * Trainee is confirmed for training
	 */
	@JsonProperty("Confirmed")
	Confirmed,
	
	/**
	 * Trainee is employed
	 */
	@JsonProperty("Employed")
	Employed,
	
	/**
	 * Trainee has been dropped
	 */
	@JsonProperty("Dropped")
	Dropped,
	
	/**
	 * Trainee is currently on a project
	 */
	@JsonProperty("Project")
	Project,
	
	/**
	 * Trainee is currently in staging
	 */
	@JsonProperty("Staging")
	Staging
}

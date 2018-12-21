package com.revature.caliber.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Trainer
 */
@Entity
@Table(name = "CALIBER_TRAINER")
public class Trainer implements Serializable {

	/**
	 * The serial version id for the Trainer
	 */
	private static final long serialVersionUID = 7502557717220560864L;
	@Id
	@Column(name = "TRAINER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAINER_ID_SEQUENCE")
	@SequenceGenerator(name = "TRAINER_ID_SEQUENCE", sequenceName = "TRAINER_ID_SEQUENCE")
	@JsonProperty
	private Integer trainerId;

	@NotEmpty
	@Column(name = "NAME", nullable = false)
	@JsonProperty
	private String name;

	@NotEmpty
	@Column(name = "TITLE", nullable = false)
	@JsonProperty
	private String title;

	@NotEmpty
	@Email
	@Column(name = "EMAIL", nullable = false, unique = true, updatable = true)
	@JsonProperty
	private String email;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "TIER")
	private TrainerRole tier;

	@Column(name = "TRAINER_PASSWORD")
	private String password;
	
	public Trainer() {
		super();
	}

	public Trainer(String name, String title, String email, TrainerRole tier) {
		super();
		this.name = name;
		this.title = title;
		this.email = email;
		this.tier = tier;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TrainerRole getTier() {
		return tier;
	}

	public void setTier(TrainerRole tier) {
		this.tier = tier;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", name=" + name + ", title=" + title + ", email=" + email
				+ ", tier=" + tier + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tier == null) ? 0 : tier.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + trainerId;
		return result;
	}

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
}

package com.revature.caliber.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.revature.caliber.pojo.Trainee;
import com.revature.caliber.service.TraineeServiceModel;

@RunWith(MockitoJUnitRunner.class)
public class TraineeControllerTest {
	
	@Mock
	TraineeServiceModel tsm;
	
	@InjectMocks
	TraineeController tc;
	
	private static Trainee traineeOne;
	private static Trainee traineeTwo;
	private static Trainee traineeThree;
	private static Trainee traineeFour;
	private static Trainee traineeFive;
	private static Trainee traineeSix;
	private static Trainee traineeSeven;
	private static Trainee traineeEight;
	private static Trainee traineeNine;
	private static Trainee traineeTen;
	private static List<Trainee> traineesInBatchOne;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		traineesInBatchOne = new ArrayList<>();
		traineeOne = new Trainee("John", null, "John@mail.com", 1);
		traineeTwo = new Trainee("Mathew", null, "Matthew@mail.com", 1);
		traineeThree = new Trainee("George", null, "George@mail.com", 1);
		traineeFour = new Trainee("Gina", null, "Regina@mail.com", 1);
		traineeFive = new Trainee("Kelly", null, "Kelly@mail.com", 1);
		traineeSix = new Trainee("Parker", null, "Parker@mail.com", 1);
		traineeSeven = new Trainee("Joshua", null, "Joshua@mail.com", 1);
		traineeEight = new Trainee("Charlie", null, "Charlie@mail.com", 1);
		traineeNine = new Trainee("Erica", null, "Erica@mail.com", 1);
		traineeTen = new Trainee("Vicky", null, "Vicky@mail.com", 1);
		traineeOne.setTraineeId(1);
		traineeTwo.setTraineeId(2);
		traineeThree.setTraineeId(3);
		traineeFour.setTraineeId(4);
		traineeFive.setTraineeId(5);
		traineeSix.setTraineeId(6);
		traineeSeven.setTraineeId(7);
		traineeEight.setTraineeId(8);
		traineeNine.setTraineeId(9);
		traineeTen.setTraineeId(10);
		traineesInBatchOne.add(traineeOne);
		traineesInBatchOne.add(traineeTwo);
		traineesInBatchOne.add(traineeThree);
		traineesInBatchOne.add(traineeFour);
		traineesInBatchOne.add(traineeFive);
		traineesInBatchOne.add(traineeSix);
		traineesInBatchOne.add(traineeSeven);
		traineesInBatchOne.add(traineeEight);
		traineesInBatchOne.add(traineeNine);
		traineesInBatchOne.add(traineeTen);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		when(tsm.findAllByBatch(1)).thenReturn(traineesInBatchOne);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAllByBatch() {
		assertEquals("Testing finding all trainees by a passed batch id",
				new ResponseEntity<>(traineesInBatchOne, HttpStatus.OK),
				this.tc.findAllByBatch(1));
	}

}

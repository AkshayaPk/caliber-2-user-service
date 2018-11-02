package com.revature.caliber.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
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
import com.revature.caliber.pojo.TrainingStatus;
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
		traineeOne = new Trainee("John", "John@mail.com", TrainingStatus.Confirmed, "999-999-9999", "25",
				"http://test.test", "Mapleton", "USF", "Bachelor's of Science", "Computer Science",
				"Jimmy", "35%");
		traineeTwo = new Trainee("Mathew", "Matthew@mail.com", TrainingStatus.Employed, "999-999-9999", "25",
				"http://test.test", "Mapleton", "USF", "Bachelor's of Science", "Computer Science",
				"Jimmy", "35%");
		traineeThree = new Trainee("George", "George@mail.com", TrainingStatus.Dropped, "999-999-9999", "25",
				"http://test.test", "Mapleton", "USF", "Bachelor's of Science", "Computer Science",
				"Jimmy", "35%");
		traineeFour = new Trainee("Gina", "Regina@mail.com", TrainingStatus.Staging, "999-999-9999", "25",
				"http://test.test", "Mapleton", "USF", "Bachelor's of Science", "Computer Science",
				"Jimmy", "35%");
		traineeFive = new Trainee("Kelly", "Kelly@mail.com", TrainingStatus.Dropped, "999-999-9999", "25",
				"http://test.test", "Mapleton", "USF", "Bachelor's of Science", "Computer Science",
				"Jimmy", "35%");
		traineeSix = new Trainee("Parker", "Parker@mail.com", TrainingStatus.Confirmed, "999-999-9999", "25",
				"http://test.test", "Mapleton", "USF", "Bachelor's of Science", "Computer Science",
				"Jimmy", "35%");
		traineeSeven = new Trainee("Joshua", "Joshua@mail.com", TrainingStatus.Project, "999-999-9999", "25",
				"http://test.test", "Mapleton", "USF", "Bachelor's of Science", "Computer Science",
				"Jimmy", "35%");
		traineeEight = new Trainee("Charlie", "Charlie@mail.com", TrainingStatus.Dropped, "999-999-9999", "25",
				"http://test.test", "Mapleton", "USF", "Bachelor's of Science", "Computer Science",
				"Jimmy", "35%");
		traineeNine = new Trainee("Erica", "Erica@mail.com", TrainingStatus.Training, "999-999-9999", "25",
				"http://test.test", "Mapleton", "USF", "Bachelor's of Science", "Computer Science",
				"Jimmy", "35%");
		traineeTen = new Trainee("Vicky", "Vicky@mail.com", TrainingStatus.Employed, "999-999-9999", "25",
				"http://test.test", "Mapleton", "USF", "Bachelor's of Science", "Computer Science",
				"Jimmy", "35%");
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
	@Test
	public void testCreateTrainee() {
		ResponseEntity<Trainee> trainee = tc.createTrainee(traineeNine);
		verify(tsm).save(traineeNine);
		assertEquals(traineeNine, trainee.getBody());
	}
	@Test
	public void testUpdateTrianee() {
		Trainee changedTrainee = new Trainee();
		changedTrainee.setTraineeId(1);
		changedTrainee.setEmail("updatedEmail");
		ResponseEntity<Trainee> trainee = tc.updateTrainee(changedTrainee);
		verify(tsm).update(changedTrainee);
		assertEquals(changedTrainee, trainee.getBody());
	}
	@Test
	public void testDeleteTrainee() {
		tc.deleteTrainee(4);
		verify(tsm).delete(4);
	}
}

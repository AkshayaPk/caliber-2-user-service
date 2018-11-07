package com.revature.caliber.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.get;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

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
import org.mockito.MockitoAnnotations;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.Application;
import com.revature.caliber.pojo.Trainee;
import com.revature.caliber.service.TraineeServiceModel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TraineeControllerTest {
	       
	@LocalServerPort
	private int port;
	
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
		traineeFour = new Trainee("Gina", null, "Regina@mail.com", 2);
		traineeFive = new Trainee("Kelly", null, "Kelly@mail.com", 2);
		traineeSix = new Trainee("Parker", null, "Parker@mail.com", 3);
		traineeSeven = new Trainee("Joshua", null, "Joshua@mail.com", 3);
		traineeEight = new Trainee("Charlie", null, "Charlie@mail.com", 3);
		traineeNine = new Trainee("Erica", null, "Erica@mail.com", 3);
		traineeTen = new Trainee("Vicky", null, "Vicky@mail.com", 7);
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
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;
		when(tsm.findAllByBatch(1)).thenReturn(traineesInBatchOne);
		when(tsm.createArrayOfTraineeCounts(new Integer[]{1,2,3,7})).thenReturn(new Integer[][]{{1,3},{2,2},{3,4},{7,1}});
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
	
	@Test
	public void testGetAllTraineesForAllBatches() {
		assertArrayEquals("Testing getting counts of all trainees for all batches",
				tc.getAllTraineesForAllBatches(new Integer[] {1,2,3,7}).getBody(),
				new Integer[][]{{1,3},{2,2},{3,4},{7,1}});
	}
	@Test
	public void restAssuredTest() {
		get("all/trainee?batch=2").then().statusCode(200);
	}
}

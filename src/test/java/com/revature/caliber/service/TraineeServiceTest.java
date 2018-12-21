package com.revature.caliber.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.caliber.dao.TraineeRepository;
import com.revature.caliber.pojo.Trainee;

@RunWith(MockitoJUnitRunner.class)
public class TraineeServiceTest {
	
	@Mock
	TraineeRepository tr;
	
	@InjectMocks
	TraineeServiceImpl ts;
	
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

	@Before
	public void setUp() throws Exception {
		when(tr.findByBatchId(1)).thenReturn(traineesInBatchOne);
		when(tr.findOne(3)).thenReturn(traineeThree);
		when(tr.countByBatchId(1)).thenReturn(3l);
		when(tr.countByBatchId(2)).thenReturn(2l);
		when(tr.countByBatchId(3)).thenReturn(4l);
		when(tr.countByBatchId(7)).thenReturn(1l);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		ts.save(traineeOne);
		verify(tr).save(traineeOne);
	}
	
	@Test
	public void testFindAllByBatch() {
		List<Trainee> testList = ts.findAllByBatch(1);
		assertEquals(testList, traineesInBatchOne);
	}
	
	@Test
	public void testUpdate() {
		ts.update(traineeThree);
		verify(tr).save(traineeThree);
	}
	
	@Test
	public void testDelete() {
		ts.delete(6);
		verify(tr).delete(6);
	}
	
	@Test
	public void testSwapTrainee() {
		ts.switchBatch(3, 4);
		verify(tr).findOne(3);
		verify(tr).save(traineeThree);
	}
	
	@Test
	public void testCreateArrayOfTraineeCounts() {
		Integer[][] expected = new Integer[][] {{1,3},{2,2},{3,4},{7,1}};
		assertArrayEquals("Testing making the array of trainee counts", 
				ts.createArrayOfTraineeCounts(new Integer[]{1,2,3,7}),
				expected);
	}
}
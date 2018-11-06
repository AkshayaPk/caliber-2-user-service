package com.revature.caliber.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
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

import com.revature.caliber.dao.TrainerRepository;
import com.revature.caliber.pojo.Trainer;
import com.revature.caliber.pojo.TrainerRole;

@RunWith(MockitoJUnitRunner.class)
public class TrainerServiceTest {
	
	@Mock
	TrainerRepository dao;
	
	@InjectMocks
	TrainerServiceImpl tsi;
	
	private static Trainer trainerOne;
	private static Trainer trainerTwo;
	private static Trainer trainerThree;
	private static Trainer trainerFour;
	private static Trainer trainerFive;
	private static Trainer trainerSix;
	private static Trainer trainerSeven;
	private static Trainer trainerEight;
	private static Trainer trainerNine;
	private static Trainer trainerTen;
	private static List<Trainer> trainers;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		trainers = new ArrayList<Trainer>();
		trainerOne = new Trainer("Nick", "Trainer", "jurczakn@revature.com", TrainerRole.ROLE_TRAINER);
		trainerTwo = new Trainer("Test2", "Head Trainer", "email.head@revature.com", TrainerRole.ROLE_TRAINER);
		trainerThree = new Trainer("Panel Person", "Paneler", "panel@revature.com", TrainerRole.ROLE_PANEL);
		trainerFour = new Trainer("VP", "VP", "vp@revature.com", TrainerRole.ROLE_VP);
		trainerFive = new Trainer("Quality Control", "QC", "qc@revature.com", TrainerRole.ROLE_QC);
		trainerSix = new Trainer("Staging Manager", "Staging Manager", "staging@revature.com", TrainerRole.ROLE_STAGING);
		trainerSeven = new Trainer("Not Active", "Backup Trainer", "inactive@revature.com", TrainerRole.ROLE_INACTIVE);
		trainerEight = new Trainer("Wesley", "Trainer", "singleton@revature.com", TrainerRole.ROLE_TRAINER);
		trainerNine = new Trainer("Pickles", "Trainer", "pickles@revature.com", TrainerRole.ROLE_TRAINER);
		trainerTen = new Trainer("Example", "Example", "example@revature.com", TrainerRole.ROLE_INACTIVE);
		trainerOne.setTrainerId(1);
		trainerTwo.setTrainerId(2);
		trainerThree.setTrainerId(3);
		trainerFour.setTrainerId(4);
		trainerFive.setTrainerId(5);
		trainerSix.setTrainerId(6);
		trainerSeven.setTrainerId(7);
		trainerEight.setTrainerId(8);
		trainerNine.setTrainerId(9);
		trainerTen.setTrainerId(10);
		trainers.add(trainerOne);
		trainers.add(trainerTwo);
		trainers.add(trainerThree);
		trainers.add(trainerFour);
		trainers.add(trainerFive);
		trainers.add(trainerSix);
		trainers.add(trainerSeven);
		trainers.add(trainerEight);
		trainers.add(trainerNine);
		trainers.add(trainerTen);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		when(dao.findAll()).thenReturn(trainers);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllTrainers() {
		assertEquals("Testing get all trainers method", trainers,
				tsi.getAllTrainers());
	}

}

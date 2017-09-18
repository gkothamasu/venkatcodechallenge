package com.gopi.spring.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gopi.spring.DogbreedController;
import com.gopi.spring.model.Dog;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "/servlet-test-context.xml" })
public class DogbreedControllerTest {
	@Resource
	DogbreedController dogbreedController;

	@Test
	public void getDogbyID() {
		
		Dog dogDetails=dogbreedController.DogDetails(1);
		System.out.println("dogDetails"+dogDetails);
		org.junit.Assert.assertNull(dogDetails);

	}
	
	
	@Test
	public void listDogs() {
		String breed = "Beagle";
		
		Map<String, List<Dog>> dogs=dogbreedController.listDogs(breed);
		System.out.println("dogs"+dogs);
		org.junit.Assert.assertEquals(0,dogs.size());

	}

}

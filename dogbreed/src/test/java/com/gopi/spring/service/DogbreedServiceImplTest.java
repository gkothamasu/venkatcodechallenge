package com.gopi.spring.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gopi.spring.DogbreedController;
import com.gopi.spring.dao.DogbreedDAOImpl;
import com.gopi.spring.model.Dog;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "/servlet-test-context.xml" })
public class DogbreedServiceImplTest {

	@Resource
	DogbreedService dogbreedService;

	@Test
	public void addDog() {
		Dog dog = new Dog();
		dogbreedService.addDog(dog);

		org.junit.Assert.assertNotNull(dog);

	}
	
	@Test
	public void getDogbyID() {
		
		Dog dog=dogbreedService.getDogById(1);

		org.junit.Assert.assertNull(dog);

	}
	
	
	@Test
	public void listDogs() {
		String breed = "new Breed";
		
		Map<String, List<Dog>> dogs=dogbreedService.listDogs(breed);

		org.junit.Assert.assertEquals(0, dogs.size());

	}
	
}

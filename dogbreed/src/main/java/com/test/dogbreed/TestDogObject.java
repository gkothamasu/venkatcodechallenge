package com.test.dogbreed;

import org.junit.Assert;
import org.junit.Test;

import com.gopi.spring.model.Dog;

public class TestDogObject {
	@Test
	public void createAndCheckDog(){
		int id = 1; //Given
		Dog dg = new Dog();//When
		dg.setId(id);
		//Then
		Assert.assertTrue(dg.getId() == id);
	}
}

package com.gopi.spring.service;

import java.util.List;
import java.util.Map;

import com.gopi.spring.model.Dog;

public interface DogbreedService {

	public void addDog(Dog p);
	public void updateDog(Dog p);
	public Map<String,List<Dog>> listDogs(String breed);
	public Dog getDogById(int id);
	public void removeDog(int id);
	public void updateFav(int id, int fav);
	public List<String> distinctBreed();
	
}

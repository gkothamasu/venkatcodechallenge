package com.gopi.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gopi.spring.dao.DogbreedDAO;
import com.gopi.spring.model.Dog;

@Service
public class DogbreedServiceImpl implements DogbreedService {
	
	private DogbreedDAO dogbreedDAO;

	public void setdogbreedDAO(DogbreedDAO dogbreedDAO) {
		this.dogbreedDAO = dogbreedDAO;
	}

	@Override
	@Transactional
	public void addDog(Dog p) {
		this.dogbreedDAO.addDog(p);
	}

	@Override
	@Transactional
	public void updateDog(Dog p) {
		this.dogbreedDAO.updateDog(p);
	}

	@Override
	@Transactional
	public Map<String,List<Dog>> listDogs(String breed) {
		return this.dogbreedDAO.listDogs(breed);
	}

	@Override
	@Transactional
	public Dog getDogById(int id) {
		return this.dogbreedDAO.getDogById(id);
	}

	@Override
	@Transactional
	public void removeDog(int id) {
		this.dogbreedDAO.removeDog(id);
	}

	@Override
	@Transactional
	public void updateFav(int id, int fav) {
		this.dogbreedDAO.updateFav(id, fav);
		
	}

	@Override
	@Transactional
	public List<String> distinctBreed() {
		return this.dogbreedDAO.distinctBreed();
	}

}

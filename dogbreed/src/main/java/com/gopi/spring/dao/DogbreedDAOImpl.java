package com.gopi.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.gopi.spring.model.Dog;

@Repository
public class DogbreedDAOImpl implements DogbreedDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DogbreedDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addDog(Dog p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Dog saved successfully, Dog Details="+p);
	}

	@Override
	public void updateDog(Dog p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Dog updated successfully, Dog Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String,List<Dog>> listDogs(String breed) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql= "";
		if(StringUtils.isEmpty(breed)){
			hql = "from Dog dg order by dg.favCount desc";
		}else
		hql = "from Dog dg where dg.breed = '"+breed+"'";
		List<Dog> dogsList = session.createQuery(hql).list();

		//List<Dog> dogsList = session.createQuery("from Dog").list();
		for(Dog p : dogsList){
			logger.info("Dog List::"+p);
		}
		return groupByBreed(dogsList);
	}
	
	public Map<String,List<Dog>> groupByBreed(List<Dog> dogsList){
		Map<String,List<Dog>> hashDog= new TreeMap<String,List<Dog>>();
			
		for(Dog d : dogsList){
			if(hashDog.containsKey(d.getBreed())){
				hashDog.get(d.getBreed()).add(d);
			}
			else{
				List<Dog> grpList = new ArrayList<Dog>();
				grpList.add(d);
				hashDog.put(d.getBreed(), grpList);
			}
			
		}
	return hashDog;
	}
	
	@Override
	public List<String> distinctBreed(){
		List<String> breedList = new ArrayList<String>();
		Session session = this.sessionFactory.getCurrentSession();
		String hql= "select distinct breed from Dog ";
		breedList = session.createQuery(hql).list();
		return breedList;
	}

	@Override
	public Dog getDogById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Dog p = (Dog) session.load(Dog.class, new Integer(id));
		logger.info("Dog loaded successfully, Dog details="+p);
		return p;
	}

	@Override
	public void removeDog(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Dog p = (Dog) session.load(Dog.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Dog deleted successfully, dog details="+p);
	}

	@Override
	public void updateFav(int id, int fav) {
		Session session = this.sessionFactory.getCurrentSession();
		Dog p = (Dog) session.load(Dog.class, new Integer(id));
		if(fav == 1){
			p.setFavCount(p.getFavCount()+1);
		}else if( fav == 0){
			p.setFavCount(p.getFavCount()-1);
		}
		session.update(p);
	}

}

package com.gopi.spring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.spring.model.Dog;
import com.gopi.spring.service.DogbreedService;

@RestController
@RequestMapping("/dogbreed")
public class DogbreedController {
	
	private DogbreedService dogbreedService;
	
	@Autowired(required=true)
	@Qualifier(value="dogbreedService")
	public void setDogService(DogbreedService ps){
		this.dogbreedService = ps;
	}
	
	@RequestMapping(value = "/dogs", method = RequestMethod.GET, headers = "Accept=application/json")
	public Map<String,List<Dog>> listDogs(@RequestParam(value="breed") String breed) {
		Map<String,List<Dog>> result = this.dogbreedService.listDogs(breed);
		return result;
	}
	
	@RequestMapping(value = "/breeds", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<String> listBreed() {
		List<String> breedList = this.dogbreedService.distinctBreed();
		return breedList;
	}
	
	@RequestMapping(value = "/details", method = RequestMethod.GET, headers = "Accept=application/json")
	public Dog DogDetails(@RequestParam(value="id") int id) {
		Dog result = this.dogbreedService.getDogById(id);
		return result;
	}
	
	@RequestMapping(value = "/updateFav/{id}/{fav}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateFav(@PathVariable(value="id") int id,@PathVariable(value="fav") int fav) {
		this.dogbreedService.updateFav(id, fav);
		return "success";
	}

//	@RequestMapping(value= "/dog/add", method = RequestMethod.POST)
//	public String addDog(@ModelAttribute("dog") Dog p) {
//		if (p.getId() == 0) {
//			this.dogbreedService.addDog(p);
//		} else {
//			this.dogbreedService.updateDog(p);
//		}
//		return "redirect:/dogs";
//	}
	
//	@RequestMapping("/remove/{id}")
//    public String removeDog(@PathVariable("id") int id){
//	    this.dogbreedService.removeDog(id);
//        return "redirect:/dogs";
//    }
// 
//    @RequestMapping("/edit/{id}")
//    public String editDog(@PathVariable("id") int id, Model model){
//        model.addAttribute("dog", this.dogbreedService.getDogById(id));
//        return "dog";
//    }
	
}

package com.rl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rl.model1.Person;
import com.rl.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;

	@RequestMapping("/toSave.do")
	public String toSave(){
		return "save";
	}
	
	@RequestMapping("/save.do")
	public String save(Person p){
		personService.save(p);
		return "redirect:selectPersonByCondition.do";
	}
	
	@RequestMapping("/toUpdate.do")
	public String toUpdate(Integer personId, Model model){
		Person p = personService.selectPersonById(personId);
		model.addAttribute("person", p);
		return "update";
	}
	
	@RequestMapping("/update.do")
	public String update(Person p){
		personService.update(p);
		return "redirect:selectPersonByCondition.do";
	}
	
	@RequestMapping("/delete.do")
	public String delete(Integer personId){
		personService.delete(personId);
		return "redirect:selectPersonByCondition.do";
	}
	
	
	
	@RequestMapping("/selectPersonByCondition.do")
	public String selectPersonByCondition(String name, 
			Integer gender, String personAddr, Date birthday, Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("gender", gender);
		map.put("personAddr", personAddr);
		map.put("birthday", birthday);
		List<Person> pList = personService.selectPersonByCondition(map);
		model.addAttribute("pList", pList);
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("personAddr", personAddr);
		model.addAttribute("birthday", birthday);
		return "list";
		
	}
	
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		
	}
}

package com.rl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rl.dao.PersonDao;
import com.rl.model1.Person;
import com.rl.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;
	
	@Override
	public void save(Person p) {
		personDao.save(p);
	}

	@Override
	public Person selectPersonById(Integer personId) {
		return personDao.selectPersonById(personId);
	}

	@Override
	public void update(Person p) {
		personDao.update(p);
	}

	@Override
	public void delete(Integer personId) {
		personDao.delete(personId);
	}

	@Override
	public List<Person> selectPersonByCondition(Map<String, Object> map) {
		return personDao.selectPersonByCondition(map);
	}

}

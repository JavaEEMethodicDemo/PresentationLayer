package com.rl.dao;

import java.util.List;
import java.util.Map;

import com.rl.model1.Person;

public interface PersonDao {
	
	public void save(Person p);
	
	public Person selectPersonById(Integer personId);
	
	public void update(Person p);
	
	public void delete(Integer personId);
	
	public List<Person> selectPersonByCondition(Map<String, Object> map);

}

package com.rl.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.rl.dao.PersonDao;
import com.rl.model1.Person;
@Repository
public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDao {

	String ns = "com.rl.mapper.PersonMapper.";
	@Override
	public void save(Person p) {
		this.getSqlSession().insert(ns+"insert", p);
	}

	@Override
	public Person selectPersonById(Integer personId) {
		return (Person) this.getSqlSession().selectOne(ns+"selectPersonByIdWithRM", personId);
	}

	@Override
	public void update(Person p) {
		this.getSqlSession().update(ns+"dynamicUpdate", p);
	}

	@Override
	public void delete(Integer personId) {
		this.getSqlSession().delete(ns+"delete", personId);
	}

	@Override
	public List<Person> selectPersonByCondition(Map<String, Object> map) {
		return this.getSqlSession().selectList(ns+"selectPersonByCondition", map);
	}

}

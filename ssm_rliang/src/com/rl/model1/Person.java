package com.rl.model1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class Person implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7853448469782055310L;

	private Integer personId;
	
	private String name;
	
	private Integer gender;
	
	private String personAddr;
	
	private Date birthday;
	
	
	
	

	

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPersonAddr() {
		return personAddr;
	}

	public void setPersonAddr(String personAddr) {
		this.personAddr = personAddr;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", gender="
				+ gender + ", personAddr=" + personAddr + ", birthday="
				+ birthday + "]";
	}
	
	
	

}

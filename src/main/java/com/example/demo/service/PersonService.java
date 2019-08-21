package com.example.demo.service;

import com.example.demo.domain.Person;

public interface PersonService {

	void savePerson(Person person);
	
	Person getPerson(Long id);
	
	void updatePerson(Person person);
	
	void deletePerson(Long id);
	
}

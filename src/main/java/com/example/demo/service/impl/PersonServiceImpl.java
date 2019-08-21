package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.PersonDao;
import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDao personDao;
	
	@Transactional(readOnly = false)
	public void savePerson(Person person) {
		personDao.save(person);
	}
	
	@Transactional(readOnly = false)
	public void updatePerson(Person person) {
		Person personss = personDao.getOne(person.getId());
		personss.setNombre(person.getNombre());
		personss.setEstado(person.getEstado());
		personDao.save(personss);
	}
	
	@Transactional(readOnly = false)
	public Person getPerson(Long id) {
		return personDao.getOne(id);
	}
	
	@Transactional(readOnly = false)
	public void deletePerson(Long id) {
		Person personss = personDao.getOne(id);
		personDao.delete(personss);
	}
	
}

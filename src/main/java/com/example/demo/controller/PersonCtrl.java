package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping(value = "/api")
public class PersonCtrl {

	@Autowired
	PersonService personService;
	
	@PostMapping(value = "/person")
	public void save(@RequestBody Person person) {
		personService.savePerson(person);
	}
	
	@GetMapping(value = "/person/{id}")
	public Person get(@PathVariable Long id) {
		return personService.getPerson(id);
	}
	
	@PutMapping(value = "/person/{id}")
	public void update(@PathVariable Long id, @RequestBody Person person) {
		person.setId(id);
		personService.updatePerson(person);
	}
	
	@DeleteMapping(value = "/person/{id}")
	public String delete(@PathVariable Long id) {
		personService.deletePerson(id);
		return "Eliminado como ella te elimino.";
	}
}

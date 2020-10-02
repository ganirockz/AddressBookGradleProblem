package com.cg.addressbook.service;
import com.cg.addressbook.dto.*;
public interface PersonService {
	public PersonContact createPerson();
	public void updatePerson(PersonContact personContact);
	public void displayPerson(PersonContact personContact);
}

package com.cg.addressbook.dto;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private List<PersonContact> personContacts;

	public AddressBook() {
		personContacts = new ArrayList<PersonContact>();
	}

	public void addPersonContact(PersonContact personContact) {
		personContacts.add(personContact);
	}
	public List<PersonContact> getPersonContacts(){
		return personContacts;
	}
	
}

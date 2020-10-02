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
	public void deletePersonContact(String firstName) {
		int flag = 0;
		for(int i=0;i<personContacts.size();i++) {
			if(personContacts.get(i).getFirstName().equals(firstName)) {
				personContacts.remove(i);
				System.out.println("deleted successfully");
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			System.out.println("No contact found with first name:"+firstName);
		}
	}
	
}

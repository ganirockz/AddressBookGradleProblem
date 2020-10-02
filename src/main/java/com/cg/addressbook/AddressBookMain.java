package com.cg.addressbook;

import java.util.*;

import com.cg.addressbook.dto.PersonContact;
import com.cg.addressbook.dto.*;
import com.cg.addressbook.service.impl.*;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of persons you want to add");
		int numberOfPersons = Integer.parseInt(sc.nextLine());
		AddressBook book = new AddressBook();
		PersonServiceImpl person = new PersonServiceImpl(sc);
		while (numberOfPersons-- > 0) {
			PersonContact contact = person.createPerson();
			book.addPersonContact(contact);
			System.out.println("successfully created");
		}
		List<PersonContact> list = book.getPersonContacts();
		for(PersonContact p:list) {
			person.displayPerson(p);
		}
	}

}

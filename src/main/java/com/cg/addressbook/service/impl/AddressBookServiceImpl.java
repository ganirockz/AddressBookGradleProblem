package com.cg.addressbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cg.addressbook.dto.AddressBook;
import com.cg.addressbook.dto.PersonContact;
import java.util.*;
public class AddressBookServiceImpl {
	public AddressBook book;
	public List<PersonContact> list;
	PersonServiceImpl person;
	private Scanner sc;
	public AddressBookServiceImpl(Scanner sc) {
		this.sc = sc;
	}
	public AddressBook showOptionsforAddressBook() {
		book = new AddressBook();
		person = new PersonServiceImpl(sc);
		list = new ArrayList<PersonContact>();
		while (true) {
			System.out.println(
					"Enter the option:\n1)Add a contact\n2)Edit a contact\n3)delete a contact\n4)display contacts\n5)exit");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1: {
				System.out.println("Enter the number of persons you want to add");
				int numberOfPersons = Integer.parseInt(sc.nextLine());
				while (numberOfPersons-- > 0) {
					PersonContact contact = person.createPerson();
					book.addPersonContact(contact);
				}
				break;
			}
			case 2: {
				System.out.println("Enter the first name of person to update the details");
				String firstName = sc.nextLine();
				System.out.println(firstName);
				list = book.getPersonContacts();
				for (PersonContact p : list) {
					if (p.getFirstName().equals(firstName)) {
						person.updatePerson(p);
					}
				}
				break;
			}
			case 3: {
				System.out.println("Enter the first name of person to delete the details");
				String firstName = sc.nextLine();
				book.deletePersonContact(firstName);
				break;
			}
			case 4: {
				list = book.getPersonContacts();
				for (PersonContact p : list) {
					person.displayPerson(p);
				}
				break;
			}
			case 5: {
				System.out.println("Thank you");
				return book;
			}
			default:{
				System.out.println("please enter a valid option");
			}
			}
		}

	}
}

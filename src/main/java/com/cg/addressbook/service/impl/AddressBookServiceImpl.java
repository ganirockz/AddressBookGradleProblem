package com.cg.addressbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cg.addressbook.dto.AddressBook;
import com.cg.addressbook.dto.PersonContact;
import com.cg.addressbook.service.AddressBookService;

import java.util.*;

public class AddressBookServiceImpl implements AddressBookService {
	public AddressBook book;
	public List<PersonContact> list;
	PersonServiceImpl person;
	private Scanner sc;
	AddressBookDBServiceImpl addressBookDBService = null;

	public AddressBookServiceImpl(Scanner sc) {
		this.sc = sc;
	}

	public AddressBookServiceImpl() {
		addressBookDBService = new AddressBookDBServiceImpl();
	}

	public AddressBook showOptionsforAddressBook() {
		book = new AddressBook();
		person = new PersonServiceImpl(sc);
		list = new ArrayList<PersonContact>();
		while (true) {
			System.out.println(
					"Enter the option:\n1)Add a contact\n2)Edit a contact\n3)delete a contact\n4)display contacts\n5)Add to file\n"
							+ "6)print Data in file\n7)Add to CSV File\n8)Read CSV9)Write From CSV To Json\n10)exit");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1: {
				System.out.println("Enter the number of persons you want to add");
				int numberOfPersons = Integer.parseInt(sc.nextLine());
				while (numberOfPersons-- > 0) {
					PersonContact contact = person.createPerson();
					if (book.isUniqueName(contact.getFirstName())) {
						book.addPersonContact(contact);
						System.out.println("Successfully added");
					} else {
						System.out.println("Sorry there is a contact with the same person in our database");
					}
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
				book.writeToFile();
				break;
			}
			case 6: {
				book.readFromFile();
				break;
			}
			case 7: {
				book.writeToCSVFile();
				break;
			}
			case 8: {
				book.readCSVFile();
				break;
			}
			case 9: {
				book.writeCSVtoJSON();
				break;
			}
			case 10: {
				System.out.println("Thank you");
				return book;
			}
			default: {
				System.out.println("please enter a valid option");
			}
			}
		}

	}

	public List<PersonContact> readPersonData() {
		list = addressBookDBService.readDBData();
		return list;
	}
}

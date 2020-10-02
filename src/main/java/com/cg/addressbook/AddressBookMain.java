package com.cg.addressbook;

import java.util.*;

import com.cg.addressbook.dto.PersonContact;
import com.cg.addressbook.dto.*;
import com.cg.addressbook.service.impl.*;

public class AddressBookMain {

	public static void main(String[] args) {
		try {
			System.out.println("Welcome to Address Book");
			Scanner sc = new Scanner(System.in);
			AddressBook book = new AddressBook();
			PersonServiceImpl person = new PersonServiceImpl(sc);
			List<PersonContact> list = new ArrayList<PersonContact>();
			while (true) {
				System.out.println("Enter the option:\n1)Add a contact\n2)Edit a contact\n3)delete a contact\n4)display contacts");
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
				case 4:{
					list = book.getPersonContacts();
					for(PersonContact p:list) {
						person.displayPerson(p);
					}
					break;
				}
				default: {
					System.out.println("Enter valid option");
				}
				}
			}
		} catch (Exception e) {
			System.out.println("Please enter the input correctly");
		}
	}

}

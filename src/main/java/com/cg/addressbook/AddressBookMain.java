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
			while (true) {
				System.out.println("Enter the option:\n1)Add a contact\n2)Edit a contact");
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
				case 2 :{
					System.out.println("Enter the first name of person to update the details");
					String firstName=sc.nextLine();
					System.out.println(firstName);
					List<PersonContact> list= book.getPersonContacts();
					for(PersonContact p:list) {
						if(p.getFirstName().equals(firstName)) {
							person.updatePerson(p);
						}
					}
				}
				}
			}
		} catch (Exception e) {
			System.out.println("Please enter the input correctly");
		}
	}

}

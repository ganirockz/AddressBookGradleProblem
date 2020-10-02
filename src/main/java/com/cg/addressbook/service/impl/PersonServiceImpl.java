package com.cg.addressbook.service.impl;

import com.cg.addressbook.service.*;
import com.cg.addressbook.dto.*;
import java.util.*;

public class PersonServiceImpl implements PersonService {

	private Scanner sc;

	public PersonServiceImpl(Scanner sc) {
		this.sc = sc;
	}

	public PersonContact createPerson() {
		PersonContact personContact = new PersonContact();
		System.out.print("Enter First Name");
		personContact.setFirstName(sc.nextLine());
		System.out.print("Enter Last Name");
		personContact.setLastName(sc.nextLine());
		System.out.print("Enter Address ");
		personContact.setAddress(sc.nextLine());
		System.out.print("Enter City ");
		personContact.setCity(sc.nextLine());
		System.out.print("Enter State");
		personContact.setState(sc.nextLine());
		System.out.print("Enter Zip");
		personContact.setZip(sc.nextLine());
		System.out.print("Enter Phone");
		personContact.setPhone(sc.nextLine());
		System.out.print("Enter Email");
		personContact.setEmail(sc.nextLine());
		return personContact;
	}

	public void displayPerson(PersonContact personContact) {

		if (personContact == null) {
			System.out.println("Persion Not Found");
			return;
		}

		System.out
				.println(String.format(
						"Persion FirstName,%s LastName,%s" + "Address,%s City,%s " + "State,%s Zip,%s "
								+ "Phone %s Email %s",
						personContact.getFirstName(), personContact.getLastName(), personContact.getAddress(),
						personContact.getCity(), personContact.getState(), personContact.getZip(),
						personContact.getPhone(), personContact.getEmail()));
	}
}

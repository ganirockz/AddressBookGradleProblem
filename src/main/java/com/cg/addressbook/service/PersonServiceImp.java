package com.cg.addressbook.service;
import com.cg.addressbook.*;
import com.cg.addressbook.dto.*;
import java.util.*;
public class PersonServiceImp implements PersonService {
	
	private Scanner sc;
	
	
	public PersonServiceImp(Scanner sc ) {
		this.sc= sc;
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
}

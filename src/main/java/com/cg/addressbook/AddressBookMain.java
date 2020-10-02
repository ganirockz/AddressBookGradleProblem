package com.cg.addressbook;
import java.util.*;
import com.cg.addressbook.service.*;
public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book");
		Scanner sc = new Scanner(System.in);
		PersonServiceImp person = new PersonServiceImp(sc);
		person.createPerson();
		System.out.println("successfully created");
	}

}

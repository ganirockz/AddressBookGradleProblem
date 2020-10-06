package com.cg.addressbook;

import java.util.*;

import com.cg.addressbook.dto.*;
import com.cg.addressbook.service.impl.*;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			System.out.println("Welcome to Address Book");
			while (true) {
				System.out.println("Enter the option:1)Add address book\n2)Search persons in a city\n3)Search persons in a state\n4)Show persons by city\n"
						+ "5)Show persons by state\n6)Show count of persons in city\n"
						+ "7)Show count of persons in state \n8)sort based on first name");
				int option = Integer.parseInt(sc.nextLine());
				AddressBooks books = new AddressBooks();
				AddressBookServiceImpl addressbook = new AddressBookServiceImpl(sc);
				switch (option) {
				case 1: {
					System.out.println("Enter the number of address books you want to create:");
					int numberOfBooks = Integer.parseInt(sc.nextLine());
					String name;
					while (numberOfBooks-- > 0) {
						while (true) {
							System.out.println("please enter the name of the address book");
							name = sc.nextLine();
							boolean IsUniqueName = books.uniqueBookName(name);
							if (IsUniqueName) {
								break;
							}
						}
						books.addAddressBook(name, addressbook.showOptionsforAddressBook());
					}
					break;
				}
				case 2:{
					System.out.println("Enter the city you want to search");
					String city = sc.nextLine();
					books.searchPersonsInCity(city);
					break;
				}	
				case 3:{
					System.out.println("Enter the state you want to search");
					String state = sc.nextLine();
					books.searchPersonsInState(state);
					break;
				}
				case 4:{
					books.showPersonsInCity();
					break;
				}
				case 5:{
					books.showPersonsInState();
					break;
				}
				case 6:{
					books.getCountByCity();
					break;
				}
				case 7:{
					books.getCountByState();
					break;
				}
				case 8:{
					books.sortByName();
					break;
				}
				default:{
					System.out.println("Please enter a valid option");
				}
				}
			}
		} catch (Exception e) {
			System.out.println("sorry!! you have entered a wrong input.please try again");
		}
	}

}

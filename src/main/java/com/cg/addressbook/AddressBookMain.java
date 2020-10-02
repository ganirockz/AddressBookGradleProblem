package com.cg.addressbook;

import java.util.*;

import com.cg.addressbook.dto.PersonContact;
import com.cg.addressbook.dto.*;
import com.cg.addressbook.service.impl.*;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			System.out.println("Welcome to Address Book");
			while (true) {
				System.out.println("Enter the option:1)Add address book\n2)display address books");
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
				
				}
			}
		} catch (Exception e) {
			System.out.println("sorry!! you have entered a wrong input.please try again");
		}
	}

}

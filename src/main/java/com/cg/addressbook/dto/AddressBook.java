package com.cg.addressbook.dto;

import com.cg.addressbook.service.*;
import com.cg.addressbook.service.impl.AddressBookFileIOServiceImpl;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private List<PersonContact> personContacts;
	private AddressBookFileIOService addressBookFileIoService = new AddressBookFileIOServiceImpl();

	public AddressBook() {
		personContacts = new ArrayList<PersonContact>();
	}

	public void addPersonContact(PersonContact personContact) {
		personContacts.add(personContact);
	}

	public List<PersonContact> getPersonContacts() {
		return personContacts;
	}

	public boolean isUniqueName(String name) {
		boolean uniqueName = true;
		for (PersonContact p : personContacts) {
			if (p.getFirstName().equals(name)) {
				uniqueName = false;
				break;
			}
		}
		return uniqueName;
	}

	public void deletePersonContact(String firstName) {
		int flag = 0;
		for (int i = 0; i < personContacts.size(); i++) {
			if (personContacts.get(i).getFirstName().equals(firstName)) {
				personContacts.remove(i);
				System.out.println("deleted successfully");
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("No contact found with first name:" + firstName);
		}
	}

	public void writeToFile() {
		addressBookFileIoService.writeData(personContacts);
	}

	public void readFromFile() {
		addressBookFileIoService.printData();
	}

	public void writeToCSVFile() {
		try {
			addressBookFileIoService.writeDataToCSV(personContacts);
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readCSVFile() {
		addressBookFileIoService.readDataFromCSV();
	}
}

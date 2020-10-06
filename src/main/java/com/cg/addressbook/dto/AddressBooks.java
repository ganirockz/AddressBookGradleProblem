package com.cg.addressbook.dto;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class AddressBooks {
	public Map<String, AddressBook> directory;
	List<PersonContact> PersonInCity = new ArrayList<PersonContact>();
	List<PersonContact> PersonInState = new ArrayList<PersonContact>();
	
	public AddressBooks() {
		directory = new HashMap<>();
	}

	public void addAddressBook(String name, AddressBook addressbook) {
		directory.put(name, addressbook);
	}
	public boolean uniqueBookName(String name) {
		for(Map.Entry<String,AddressBook> entry:directory.entrySet()) {
			if(entry.getKey().equals(name)) {
				return false;
			}
		}
		return true;
	}
	public void searchPersonsInCity(String cityName) {
		for(Map.Entry<String,AddressBook> entry:directory.entrySet()) {
			Predicate<PersonContact> isEqual = n -> n.getCity().equals(cityName);
			PersonInCity = entry.getValue().getPersonContacts().stream()
					.filter(isEqual)
					.collect(Collectors.toList());
		}
	}
	public void searchPersonsInState(String stateName) {
		for(Map.Entry<String,AddressBook> entry:directory.entrySet()) {
			Predicate<PersonContact> isEqual = n -> n.getState().equals(stateName);
			PersonInState = entry.getValue().getPersonContacts().stream()
					.filter(isEqual)
					.collect(Collectors.toList());
		}
	}
}

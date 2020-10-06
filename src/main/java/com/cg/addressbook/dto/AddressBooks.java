package com.cg.addressbook.dto;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AddressBooks {
	public Map<String, AddressBook> directory;
	List<PersonContact> PersonInCity = new ArrayList<PersonContact>();
	List<PersonContact> PersonInState = new ArrayList<PersonContact>();
	Map<String, List<PersonContact>> cityMap = new TreeMap<String, List<PersonContact>>();
	Map<String, List<PersonContact>> stateMap = new TreeMap<String, List<PersonContact>>();
	Map<String, Integer> cityCount = new TreeMap<String, Integer>();
	Map<String, Integer> stateCount = new TreeMap<String, Integer>();

	public AddressBooks() {
		directory = new HashMap<>();
	}

	public void addAddressBook(String name, AddressBook addressbook) {
		directory.put(name, addressbook);
	}

	public boolean uniqueBookName(String name) {
		for (Map.Entry<String, AddressBook> entry : directory.entrySet()) {
			if (entry.getKey().equals(name)) {
				return false;
			}
		}
		return true;
	}

	public void searchPersonsInCity(String cityName) {
		for (Map.Entry<String, AddressBook> entry : directory.entrySet()) {
			Predicate<PersonContact> isEqual = n -> n.getCity().equals(cityName);
			PersonInCity = entry.getValue().getPersonContacts().stream().filter(isEqual).collect(Collectors.toList());
		}
		PersonInCity.stream().peek(n -> System.out.println(n));

	}

	public void searchPersonsInState(String stateName) {
		for (Map.Entry<String, AddressBook> entry : directory.entrySet()) {
			Predicate<PersonContact> isEqual = n -> n.getState().equals(stateName);
			PersonInState = entry.getValue().getPersonContacts().stream().filter(isEqual).collect(Collectors.toList());
		}
		PersonInState.stream().peek(n -> System.out.println(n));
	}

	public void showPersonsInCity() {
		for (Map.Entry<String, AddressBook> entry : directory.entrySet()) {
			List<PersonContact> list = entry.getValue().getPersonContacts();
			for (PersonContact p : list) {
				searchPersonsInCity(p.getCity());
				cityMap.put(p.getCity(), PersonInCity);
				int count = (int) PersonInCity.stream().count();
				cityCount.put(p.getCity(), count);
			}
		}
		for (Map.Entry<String, List<PersonContact>> entry : cityMap.entrySet()) {
			System.out.println("The persons in city " + entry.getKey() + " are:");
			entry.getValue().stream().peek(n -> System.out.println(n));
		}
	}

	public void showPersonsInState() {
		for (Map.Entry<String, AddressBook> entry : directory.entrySet()) {
			List<PersonContact> list = entry.getValue().getPersonContacts();
			for (PersonContact p : list) {
				searchPersonsInState(p.getState());
				stateMap.put(p.getState(), PersonInCity);
				int count = (int) PersonInState.stream().count();
				cityCount.put(p.getState(), count);
			}
		}
		for (Map.Entry<String, List<PersonContact>> entry : stateMap.entrySet()) {
			System.out.println("The persons in state " + entry.getKey() + " are:");
			entry.getValue().stream().peek(n -> System.out.println(n));
		}
	}

	public void getCountByCity() {
		for (Map.Entry<String, Integer> entry : cityCount.entrySet()) {
			System.out.println("The number of persons in city " + entry.getKey() + " are:" + entry.getValue());
		}
	}

	public void getCountByState() {
		for (Map.Entry<String, Integer> entry : stateCount.entrySet()) {
			System.out.println("The number of persons in state " + entry.getKey() + " are:" + entry.getValue());
		}
	}

	public void sortByName() {
		for (Map.Entry<String, AddressBook> entry : directory.entrySet()) {
			entry.getValue().getPersonContacts().stream().sorted(Comparator.comparing(PersonContact::getFirstName));
		}
	}

	public void sortByCity() {
		for (Map.Entry<String, AddressBook> entry : directory.entrySet()) {
			entry.getValue().getPersonContacts().stream().sorted(Comparator.comparing(PersonContact::getCity));
		}
	}

	public void sortByState() {
		for (Map.Entry<String, AddressBook> entry : directory.entrySet()) {
			entry.getValue().getPersonContacts().stream().sorted(Comparator.comparing(PersonContact::getState));
		}
	}

	public void sortByZip() {
		for (Map.Entry<String, AddressBook> entry : directory.entrySet()) {
			entry.getValue().getPersonContacts().stream().sorted(Comparator.comparing(PersonContact::getZip));
		}
	}

}

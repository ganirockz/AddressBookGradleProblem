package com.cg.addressbook.dto;

import java.util.*;

import com.cg.addressbook.service.impl.AddressBookServiceImpl;

public class AddressBooks {
	public Map<String, AddressBook> directory;
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
}

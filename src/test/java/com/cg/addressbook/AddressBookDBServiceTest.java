package com.cg.addressbook;

import java.util.List;

import org.junit.*;

import com.cg.addressbook.dto.PersonContact;
import com.cg.addressbook.service.impl.AddressBookServiceImpl;

public class AddressBookDBServiceTest {
	@Test
	public void givenAddressBookInDB_WhenRetrieved_ShouldMatchPersonsCount() {
		AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();
		List<PersonContact> personsData = addressBookService.readPersonData();
		System.out.println(personsData);
		Assert.assertEquals(4, personsData.size());
	}
}

package com.cg.addressbook;
import org.junit.*;

import com.cg.addressbook.dto.AddressBook;
import com.cg.addressbook.dto.PersonContact;
import java.util.*;
public class AddressBookTest {
	@Test
	public void givenContact_whenAdded_returnTrue() {
		PersonContact person = new PersonContact();
		person.setFirstName("Ganesh");
		person.setLastName("Rapeti");
		person.setAddress("1A,sefa");
		person.setCity("Pune");
		person.setState("Maharastra");
		person.setPhone("9866683248");
		person.setZip("531001");
		person.setEmail("abc@yahoo.com");
		AddressBook book = new AddressBook();
		book.addPersonContact(person);
		String firstName = "";
		List<PersonContact> list = book.getPersonContacts();
		for(PersonContact p:list) {
			firstName = p.getFirstName();
		}
		Assert.assertEquals("Ganesh", firstName);
	}
}

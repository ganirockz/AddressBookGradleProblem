package com.cg.addressbook;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

import com.cg.addressbook.dto.PersonContact;
import com.cg.addressbook.service.impl.AddressBookServiceImpl;

public class AddressBookDBServiceTest {

	public void givenAddressBookInDB_WhenRetrieved_ShouldMatchPersonsCount() {
		AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();
		List<PersonContact> personsData = addressBookService.readPersonData();
		System.out.println(personsData);
		Assert.assertEquals(4, personsData.size());
	}

	public void givenAddressBookInDB_WhenUpdated_ShouldMatchPersonsCount() {
		AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();
		List<PersonContact> personsData = addressBookService.readPersonData();
		addressBookService.updatePersonData("Mark", "9866832489");
		boolean result = addressBookService.checkForAvailabiltyOfPerson("Mark");
		Assert.assertTrue(result);
	}

	public void givenAddressBookInDB_WhenRetrievedBasedOnDate_ShouldMatchPersonsCount() {
		AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();
		List<PersonContact> personsData = addressBookService.readPersonData();
		LocalDate date = LocalDate.of(2020, 01, 01);
		List<PersonContact> personDataBasedOnDate = addressBookService.getPersonsJoinedAfterDate(date);
		System.out.println(personDataBasedOnDate);
		Assert.assertEquals(2, personDataBasedOnDate.size());
	}

	public void givenAddressBookInDB_WhenRetrievedBasedOnCity_ShouldMatchPersonsCount() {
		AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();
		List<PersonContact> personsData = addressBookService.readPersonData();
		List<PersonContact> personDataBasedonCity = addressBookService.getPersonsInACity("Lakewood");
		System.out.println(personDataBasedonCity);
		Assert.assertEquals(1, personDataBasedonCity.size());
	}

	public void givenPersonDetails_addToDB_shouldMatchPersonCount() {
		AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();
		List<PersonContact> personsData = addressBookService.readPersonData();
		PersonContact person = new PersonContact();
		person.setFirstName("Ganesh");
		person.setLastName("Rapeti");
		person.setAddress("2124,adfeas");
		person.setCity("Lakewood");
		person.setState("North ros");
		person.setEmail("ganesh@abc.co");
		person.setPhone("9877665678");
		person.setZip("987654");
		addressBookService.addPersonsToDB(person);
		boolean result = addressBookService.checkForAvailabiltyOfPerson("Ganesh");
		Assert.assertTrue(result);
	}

	@Test
	public void givenMultiplePersonDetails_addToDB_shouldMatchPersonCount() {
		AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();
		List<PersonContact> personsData = addressBookService.readPersonData();
		PersonContact person1 = new PersonContact();
		person1.setFirstName("Ramesh");
		person1.setLastName("Rapeti");
		person1.setAddress("12Anad");
		person1.setCity("anaka");
		person1.setState("andhra");
		person1.setZip("123456");
		person1.setPhone("91 9812345678");
		person1.setEmail("gani.abc@bl.co.in");
		PersonContact person2 = new PersonContact();
		person2.setFirstName("Ganish");
		person2.setLastName("Rapti");
		person2.setAddress("12nad");
		person2.setCity("anaa");
		person2.setState("anhra");
		person2.setZip("12356");
		person2.setPhone("919812345678");
		person2.setEmail("gai.abc@bl.co.in");
		PersonContact[] addressBook = { person1, person2 };
		addressBookService.addPersonsDataToDB(Arrays.asList(addressBook));
		personsData = addressBookService.readPersonData();
		Assert.assertEquals(3, personsData.size());
	}
}

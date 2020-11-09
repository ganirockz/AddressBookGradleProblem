package com.cg.addressbook;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.addressbook.dto.PersonContact;
import com.cg.addressbook.service.AddressBookFileIOService;
import com.cg.addressbook.service.impl.AddressBookServiceImpl;
import com.google.gson.Gson;
import com.cg.addressbook.service.impl.AddressBookServiceImpl.*;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddressBookRESTIOTest {
	@Before
	public void Setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3000;
	}

	public void givenEmployeeInJSONServer_whenRetrieved_ShouldMatchTheCount() {
		PersonContact[] arrayOfPersons = getPesonList();
		AddressBookServiceImpl addressBookService;
		addressBookService = new AddressBookServiceImpl(Arrays.asList(arrayOfPersons));
		long entries = addressBookService.countEntries();
		Assert.assertEquals(1, entries);
	}

	private PersonContact[] getPesonList() {
		Response response = RestAssured.get("/persons");
		System.out.println("EMPLOYEE PAYROLL ENTRIES IN JSONServer:\n" + response.asString());
		PersonContact[] arrayOfPersons = new Gson().fromJson(response.asString(), PersonContact[].class);
		return arrayOfPersons;
	}

	public void givenNewPerson_WhenAddedToJSONServer_ShouldMatchWith201StatusCodeAndCount() {
		PersonContact[] arrayOfPersons = getPesonList();
		AddressBookServiceImpl addressBookService;
		addressBookService = new AddressBookServiceImpl(Arrays.asList(arrayOfPersons));
		PersonContact person = new PersonContact(0, "Sai", "Rapeti", "1-51 Ansjs", " Vizag ", "Andhra Pradesh",
				"123457", "9879867708", "sai@abc.com");
		Response response = addPersonToJsonServer(person);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(201, statusCode);
		person = new Gson().fromJson(response.asString(), PersonContact.class);
		addressBookService.addPerson(person);
		long entries = addressBookService.countEntries();
		Assert.assertEquals(2, entries);
	}

	private Response addPersonToJsonServer(PersonContact person) {
		String empJson = new Gson().toJson(person);
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(empJson);
		return request.post("/persons");
	}

	public void givenMultiplePersons_WhenAddedToJSONServer_ShouldMatchWith201ResponseAndCount() {
		PersonContact[] arrayOfPersons = getPesonList();
		AddressBookServiceImpl addressBookService;
		addressBookService = new AddressBookServiceImpl(Arrays.asList(arrayOfPersons));
		PersonContact[] arrayOfNewPersons = {
				new PersonContact(0, "Rahul", "ss", "a3afe", "vissa", "adnasd", "124334", "324545656", "daeas@cs.com"),
				new PersonContact(0, "Rajesh", "ss", "a3afe", "vissa", "adnasd", "124334", "324543656", "daeas@cs.com"),
				new PersonContact(0, "Rakesh", "ss", "a3afe", "vissa", "adnasd", "124334", "3245434656",
						"daeas@cs.com") };
		for (PersonContact person : Arrays.asList(arrayOfNewPersons)) {
			Response response = addPersonToJsonServer(person);
			int statusCode = response.getStatusCode();
			Assert.assertEquals(201, statusCode);
			person = new Gson().fromJson(response.asString(), PersonContact.class);
			addressBookService.addPerson(person);
		}
		long entries = addressBookService.countEntries();
		Assert.assertEquals(7, entries);
	}
	
	@Test
	public void givenNewPhoneNumberOfPerson_WhenUpdated_shouldMatchWith200ResponseAndCount() {
		PersonContact[] arrayOfPersons = getPesonList();
		AddressBookServiceImpl addressBookService;
		addressBookService = new AddressBookServiceImpl(Arrays.asList(arrayOfPersons));
		addressBookService.updatePersonData("Rahul","9876543210",IOService.REST_IO);
		PersonContact personData = addressBookService.getPersonByName("Rahul");
		String empJson = new Gson().toJson(personData);
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(empJson);
		Response response = request.put("/persons/" + personData.id);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
}

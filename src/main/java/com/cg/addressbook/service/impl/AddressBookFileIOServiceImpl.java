package com.cg.addressbook.service.impl;

import com.cg.addressbook.dto.*;
import com.cg.addressbook.service.AddressBookFileIOService;
import com.opencsv.*;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AddressBookFileIOServiceImpl implements AddressBookFileIOService {
	File file = new File("H:\\java-eclipse\\AddressBookGradleProblem\\personList.csv");

	public void writeData(List<PersonContact> personContactList) {
		StringBuffer contactBuffer = new StringBuffer();
		personContactList.forEach(person -> {
			String personData = person.toString().concat("\n");
			contactBuffer.append(personData);
		});
		System.out.println(contactBuffer);
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\ganeshrapeti\\personData.txt");
			fos.write(contactBuffer.toString().getBytes());
			fos.close();
		} catch (IOException e) {
			System.out.println("Exception encountered");
		}
	}

	public void writeDataToCSV(List<PersonContact> personContactList)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			List<String[]> data = new ArrayList<String[]>();
			data.add(new String[] { "FirstName", "LastName", "Address", "City", "State", "zip", "Phone", "Email" });
			for (PersonContact person : personContactList) {
				data.add(new String[] { person.getFirstName(), person.getLastName(), person.getAddress(),
						person.getCity(), person.getState(), person.getZip(), person.getPhone(), person.getEmail() });
			}
			writer.writeAll(data, false);
			writer.close();
		} catch (IOException e) {
			System.out.println("Exception encountered");
		}
	}

	public void readDataFromCSV() {
		String PersonContactCSV = "./personContact.csv";
		try {
			// Reader reader = Files.newBufferedReader(Paths.get(PersonContactCSV));
			FileReader filereader = new FileReader(file);

			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			// CSVReader csvReader = new CSVReader(reader);
			// String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				/*
				 * System.out.print("First Name: " + nextRecord[0]);
				 * System.out.print("Last Name: " + nextRecord[1]); System.out.print("Address:"
				 * + nextRecord[2]); System.out.print("City:" + nextRecord[3]);
				 * System.out.print("State:" + nextRecord[4]); System.out.print("zip:" +
				 * nextRecord[5]); System.out.print("phone:" + nextRecord[6]);
				 * System.out.print("Email:" + nextRecord[7]); System.out.println();
				 */
				for (String cell : nextRecord) { 
	                System.out.print(cell + " "); 
	            } 
	            System.out.println();
			}
			csvReader.close();
		} catch (IOException e) {
			System.out.println("Exception Encountered");
		}
	}

	public void printData() {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\ganeshrapeti\\personData.txt");
			int c;
			while ((c = fis.read()) != -1) {
				System.out.print((char) c);
			}
			fis.close();
		} catch (IOException e) {
			System.out.println("Exception Encountered");
		}
	}
}

package com.cg.addressbook.service.impl;

import com.cg.addressbook.dto.*;
import com.cg.addressbook.service.AddressBookFileIOService;
import com.google.gson.Gson;
import com.opencsv.*;
import com.opencsv.bean.*;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.BufferedReader;
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

	public void writeDataCSVToJson() {
		String personCSVPath = "./personList.csv";
		String personJSONPath = "./personList.json";
		try {
			Reader reader = Files.newBufferedReader(Paths.get(personCSVPath));
			CsvToBeanBuilder<PersonContact> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(PersonContact.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<PersonContact> csvToBean = csvToBeanBuilder.build();
			List<PersonContact> csvUser = csvToBean.parse();
			Gson gson = new Gson();
			String json = gson.toJson(csvUser);
			FileWriter writer = new FileWriter(personJSONPath);
			writer.write(json);
			writer.close();
			BufferedReader br = new BufferedReader(new FileReader(personJSONPath));
			PersonContact[] usrObj = gson.fromJson(br, PersonContact[].class);
			List<PersonContact> csvUserList = Arrays.asList(usrObj);
			br.close();
		} catch (IOException e) {
			System.out.println("Exception Encountered");
		}
	}
}

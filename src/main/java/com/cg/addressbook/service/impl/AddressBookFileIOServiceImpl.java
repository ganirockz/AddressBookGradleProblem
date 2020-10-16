package com.cg.addressbook.service.impl;

import com.cg.addressbook.dto.*;
import com.cg.addressbook.service.AddressBookFileIOService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AddressBookFileIOServiceImpl implements AddressBookFileIOService{

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

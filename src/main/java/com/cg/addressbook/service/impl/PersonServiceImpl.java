package com.cg.addressbook.service.impl;

import com.cg.addressbook.service.*;
import com.cg.addressbook.dto.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonServiceImpl implements PersonService {

	private Scanner sc;

	public PersonServiceImpl(Scanner sc) {
		this.sc = sc;
	}

	public PersonContact createPerson() {
		PersonContact personContact = new PersonContact();
		while (true) {
			System.out.print("Enter First Name");
			String firstName = sc.nextLine();
			Pattern pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
			Matcher matcher = pattern.matcher(firstName);
			if (matcher.find()) {
				personContact.setFirstName(firstName);
				break;
			} else {
				System.out.println("Please enter the correct details");
			}
		}
		while (true) {
			System.out.print("Enter Last Name");
			String lastName = sc.nextLine();
			Pattern pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
			Matcher matcher = pattern.matcher(lastName);
			if (matcher.find()) {
				personContact.setLastName(lastName);
				break;
			} else {
				System.out.println("Please enter the correct details");
			}
		}
		while (true) {
			System.out.print("Enter the address");
			String address = sc.nextLine();
			Pattern pattern = Pattern.compile("[a-zA-Z0-9,]+");
			Matcher matcher = pattern.matcher(address);
			if (matcher.find()) {
				personContact.setLastName(address);
				break;
			} else {
				System.out.println("Please enter the correct details");
			}
		}
		while (true) {
			System.out.print("Enter the city");
			String city = sc.nextLine();
			Pattern pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
			Matcher matcher = pattern.matcher(city);
			if (matcher.find()) {
				personContact.setCity(city);
				break;
			} else {
				System.out.println("Please enter the correct details");
			}
		}
		while (true) {
			System.out.print("Enter the state");
			String state = sc.nextLine();
			Pattern pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
			Matcher matcher = pattern.matcher(state);
			if (matcher.find()) {
				personContact.setState(state);
				break;
			} else {
				System.out.println("Please enter the correct details");
			}
		}
		while (true) {
			System.out.print("Enter the zip");
			String zip = sc.nextLine();
			Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{5}");
			Matcher matcher = pattern.matcher(zip);
			if (matcher.find()) {
				personContact.setZip(zip);
				break;
			} else {
				System.out.println("Please enter the correct details");
			}
		}
		while (true) {
			System.out.print("Enter the phone number");
			String phoneNumber = sc.nextLine();
			Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{9}");
			Matcher matcher = pattern.matcher(phoneNumber);
			if (matcher.find()) {
				personContact.setPhone(phoneNumber);
				break;
			} else {
				System.out.println("Please enter the correct details");
			}
		}
		while (true) {
			System.out.print("Enter the email address");
			String email = sc.nextLine();
			Pattern pattern = Pattern.compile("^([a][b][c])[.]([a-zA-Z]+)[@]([b][l][.][c][o])[.]([a-zA-Z]{2})$");
			Matcher matcher = pattern.matcher(email);
			if (matcher.find()) {
				personContact.setEmail(email);
				break;
			} else {
				System.out.println("Please enter the correct details");
			}
		}

		return personContact;
	}

	public void updatePerson(PersonContact personContact) {

		while (true) {
			System.out.println("1.) FirstName Update");
			System.out.println("2.) LastName Update");
			System.out.println("3.) Address Update");
			System.out.println("4.) City Update");
			System.out.println("5.) State Update");
			System.out.println("6.) Zip Update");
			System.out.println("7.) Phone Update");
			System.out.println("8.) Email Update");
			System.out.println("9.) Exit");
			int options = sc.nextInt();

			switch (options) {
			case 1: {
				while (true) {
					System.out.print("Enter First Name");
					String firstName = sc.nextLine();
					Pattern pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
					Matcher matcher = pattern.matcher(firstName);
					if (matcher.find()) {
						personContact.setFirstName(firstName);
						break;
					} else {
						System.out.println("Please enter the correct details");
					}
				}
				break;
			}
			case 2: {
				while (true) {
					System.out.print("Enter Last Name");
					String lastName = sc.nextLine();
					Pattern pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
					Matcher matcher = pattern.matcher(lastName);
					if (matcher.find()) {
						personContact.setLastName(lastName);
						break;
					} else {
						System.out.println("Please enter the correct details");
					}
				}
				break;
			}

			case 3: {
				while (true) {
					System.out.print("Enter the address");
					String address = sc.nextLine();
					Pattern pattern = Pattern.compile("[a-zA-Z0-9,]+");
					Matcher matcher = pattern.matcher(address);
					if (matcher.find()) {
						personContact.setAddress(address);
						break;
					} else {
						System.out.println("Please enter the correct details");
					}
				}
				break;
			}
			case 4: {
				while (true) {
					System.out.print("Enter the city");
					String city = sc.nextLine();
					Pattern pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
					Matcher matcher = pattern.matcher(city);
					if (matcher.find()) {
						personContact.setCity(city);
						break;
					} else {
						System.out.println("Please enter the correct details");
					}
				}
				break;
			}

			case 5: {
				while (true) {
					System.out.print("Enter the state");
					String state = sc.nextLine();
					Pattern pattern = Pattern.compile("[A-Z]{1}[a-zA-Z]{2,}");
					Matcher matcher = pattern.matcher(state);
					if (matcher.find()) {
						personContact.setState(state);
						break;
					} else {
						System.out.println("Please enter the correct details");
					}
				}
				break;
			}
			case 6: {
				while (true) {
					System.out.print("Enter the zip");
					String zip = sc.nextLine();
					Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{5}");
					Matcher matcher = pattern.matcher(zip);
					if (matcher.find()) {
						personContact.setZip(zip);
						break;
					} else {
						System.out.println("Please enter the correct details");
					}
				}
				break;
			}
			case 7: {
				while (true) {
					System.out.print("Enter the phone number");
					String phoneNumber = sc.nextLine();
					Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{9}");
					Matcher matcher = pattern.matcher(phoneNumber);
					if (matcher.find()) {
						personContact.setPhone(phoneNumber);
						break;
					} else {
						System.out.println("Please enter the correct details");
					}
				}
				break;
			}
			case 8: {
				while (true) {
					System.out.print("Enter the email address");
					String email = sc.nextLine();
					Pattern pattern = Pattern
							.compile("^([a][b][c])[.]([a-zA-Z]+)[@]([b][l][.][c][o])[.]([a-zA-Z]{2})$");
					Matcher matcher = pattern.matcher(email);
					if (matcher.find()) {
						personContact.setEmail(email);
						break;
					} else {
						System.out.println("Please enter the correct details");
					}
				}
				break;
			}
			case 9:
				System.out.println("Exit");
				return;
			default:
				System.out.println("INVALID ENTRY");
				break;
			}
		}

	}

	public void displayPerson(PersonContact personContact) {

		if (personContact == null) {
			System.out.println("Persion Not Found");
			return;
		}

		System.out.println(String.format(
						"Person FirstName,%s LastName,%s" + "Address,%s City,%s " + "State,%s Zip,%s "
								+ "Phone %s Email %s",
						personContact.getFirstName(), personContact.getLastName(), personContact.getAddress(),
						personContact.getCity(), personContact.getState(), personContact.getZip(),
						personContact.getPhone(), personContact.getEmail()));
	}
}

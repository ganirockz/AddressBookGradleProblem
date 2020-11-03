package com.cg.addressbook.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.addressbook.dto.PersonContact;

public class AddressBookDBServiceImpl {

	public List<PersonContact> readDBData() {
		String sql = "select person_contact.first_name,person_contact.last_name,person_contact.phone_number,person_contact.email,person_address.address,person_address.city,person_address.state,person_address.zip from person_contact inner join person_address on person_contact.first_name = person_address.first_name;";
		List<PersonContact> personDataList = new ArrayList<>();
		try (Connection connection = this.getConnection()) {
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					String firstName = result.getString("first_name");
					String lastName = result.getString("last_name");
					String phoneNumber = result.getString("phone_number");
					String email = result.getString("email");
					String address = result.getString("address");
					String city = result.getString("city");
					String state = result.getString("state");
					String zip = result.getString("zip");
					PersonContact personContact = new PersonContact();
					personContact.setFirstName(firstName);
					personContact.setLastName(lastName);
					personContact.setPhone(phoneNumber);
					personContact.setAddress(address);
					personContact.setCity(city);
					personContact.setState(state);
					personContact.setZip(zip);
					personDataList.add(personContact);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personDataList;
	}

	private synchronized Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
		String userName = "root";
		String password = "@GaniMySql02";
		Connection connection = null;
		System.out.println("Connecting to database:" + jdbcURL);
		connection = DriverManager.getConnection(jdbcURL, userName, password);
		System.out.println("Connection is successfull!!!" + connection);
		return connection;
	}

	public int updatePersonContact(String firstName, String phoneNumber) {
		String sql = String.format("update person_contact set phone_number= '%s' where first_name = '%s';", phoneNumber,
				firstName);
		try (Connection connection = this.getConnection()) {
			connection.setAutoCommit(false);
			PreparedStatement stmt = connection.prepareStatement(sql);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<PersonContact> getPersonsBasedOnJoiningDate(LocalDate date) {
		String sql = String.format(
				"select person_contact.first_name,person_contact.last_name,person_contact.phone_number,person_contact.email,person_address.address,person_address.city,person_address.state,person_address.zip from person_contact inner join person_address on person_contact.first_name = person_address.first_name where person_contact.date_added > '%s';",
				date.toString());
		List<PersonContact> personDataList = new ArrayList<>();
		try (Connection connection = this.getConnection()) {
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					String firstName = result.getString("first_name");
					String lastName = result.getString("last_name");
					String phoneNumber = result.getString("phone_number");
					String email = result.getString("email");
					String address = result.getString("address");
					String city = result.getString("city");
					String state = result.getString("state");
					String zip = result.getString("zip");
					PersonContact personContact = new PersonContact();
					personContact.setFirstName(firstName);
					personContact.setLastName(lastName);
					personContact.setPhone(phoneNumber);
					personContact.setAddress(address);
					personContact.setCity(city);
					personContact.setState(state);
					personContact.setZip(zip);
					personDataList.add(personContact);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personDataList;
	}

	public List<PersonContact> getPersonsBasedOnCity(String cityName) {
		String sql = String.format(
				"select person_contact.first_name,person_contact.last_name,person_contact.phone_number,person_contact.email,person_address.address,person_address.city,person_address.state,person_address.zip from person_contact inner join person_address on person_contact.first_name = person_address.first_name where person_address.city = '%s';",
				cityName);
		List<PersonContact> personDataList = new ArrayList<>();
		try (Connection connection = this.getConnection()) {
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			try {
				while (result.next()) {
					String firstName = result.getString("first_name");
					String lastName = result.getString("last_name");
					String phoneNumber = result.getString("phone_number");
					String email = result.getString("email");
					String address = result.getString("address");
					String city = result.getString("city");
					String state = result.getString("state");
					String zip = result.getString("zip");
					PersonContact personContact = new PersonContact();
					personContact.setFirstName(firstName);
					personContact.setLastName(lastName);
					personContact.setPhone(phoneNumber);
					personContact.setAddress(address);
					personContact.setCity(city);
					personContact.setState(state);
					personContact.setZip(zip);
					personDataList.add(personContact);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personDataList;
	}

	public int addPersonToDB(PersonContact person) {
		int empId = -1;

		Connection connection = null;
		try {
			connection = this.getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Statement statement = connection.createStatement()) {
			LocalDate date = LocalDate.now();
			String sql = String.format(
					"insert into person_contact (first_name,last_name,phone_number,email,date_added) values ('%s','%s','%s','%s','%s');",
					person.getFirstName(), person.getLastName(), person.getPhone(), person.getEmail(), date.toString());
			int rowsAffected = statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
				return -1;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		int rowsAffected = 0;
		try (Statement statement = connection.createStatement()) {
			String sql = String.format(
					"insert into person_address (first_name,address,city,state,zip) values ('%s','%s','%s','%s','%s');",
					person.getFirstName(), person.getAddress(), person.getCity(), person.getState(), person.getZip());
			rowsAffected = statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		try {
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rowsAffected;
	}
}

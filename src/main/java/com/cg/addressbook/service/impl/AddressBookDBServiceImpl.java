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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personDataList;
	}	
	
	private Connection getConnection() throws SQLException {
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
		String sql = String.format("update person_contact set phone_number= '%s' where first_name = '%s';", phoneNumber, firstName);
		try (Connection connection = this.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(sql);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

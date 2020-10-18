package AddressBookGradleProblem;

import java.util.Arrays;

import org.junit.*;
import com.cg.addressbook.dto.*;
import com.cg.addressbook.service.*;
import com.cg.addressbook.service.impl.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookFileIoServiceTest {
	@Test
	public void given3PersonsWhenWrittenToFileShouldMatchPersonEntries() {
		PersonContact person1 = new PersonContact();
		person1.setFirstName("Ganesh");
		person1.setLastName("Rapeti");
		person1.setAddress("12Anad");
		person1.setCity("anaka");
		person1.setState("andhra");
		person1.setZip("123456");
		person1.setPhone("91 9812345678");
		person1.setEmail("gani.abc@bl.co.in");
		PersonContact person2 = new PersonContact();
		person2.setFirstName("Gansh");
		person2.setLastName("Rapti");
		person2.setAddress("12nad");
		person2.setCity("anaa");
		person2.setState("anhra");
		person2.setZip("12356");
		person2.setPhone("919812345678");
		person2.setEmail("gai.abc@bl.co.in");
		PersonContact[] addressBook = { person1, person2 };
		AddressBookFileIOService personFileIOService = new AddressBookFileIOServiceImpl();
		try {
			personFileIOService.writeDataToCSV(Arrays.asList(addressBook));
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}
		personFileIOService.readDataFromCSV();
	}
}

package com.cg.addressbook.service;

import com.cg.addressbook.dto.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public interface AddressBookFileIOService {

	public void writeData(List<PersonContact> personContactList) ;

	public void printData();
}

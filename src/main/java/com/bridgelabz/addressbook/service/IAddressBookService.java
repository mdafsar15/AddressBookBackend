package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;

import java.util.List;

public interface IAddressBookService {

	List<AddressBookDTO> getAddress();

	AddressBookDTO addAddressBook(AddressBookDTO addressBookDTO);

	AddressBookDTO updateAddressBook(int id, AddressBookDTO addressBookDTO);

	AddressBookDTO deleteAddressBook(int id);

//    List<StateAndCityDTO> getStateAndCityDetails();

	AddressBookDTO getAddressDetailsByID(int id);
}

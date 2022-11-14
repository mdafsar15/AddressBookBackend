package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBook;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.repository.IAddressBookRepo;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

	@Autowired
	private IAddressBookRepo addressBookRepository;

//    @Autowired
//    private IStateAndCityRepo iStateAndCityRepo;

	@Autowired
	private ModelMapper modelMapper;

	// Ability to fetch data from Address Book.
	@Override
	public List<AddressBookDTO> getAddress() {
		log.info("Inside getAddress()");
		return addressBookRepository.findAll().stream()
				.map(addressBook -> modelMapper.map(addressBook, AddressBookDTO.class)).collect(Collectors.toList());
	}

	// Ability to add data in Address Book.
	@Override
	public AddressBookDTO addAddressBook(AddressBookDTO addressBookDTO) {
		log.info("Inside addAddressBook()");
		AddressBook addAddressRequest = modelMapper.map(addressBookDTO, AddressBook.class);
		addressBookRepository.save(addAddressRequest);
		return addressBookDTO;
	}

	// Ability to update data in Address Book Using Id.
	@Override
	public AddressBookDTO updateAddressBook(int id, AddressBookDTO addressBookDTO) {
		log.info("Inside updateAddressBook()");
		AddressBook updateAddressRequest = findAddressBookById(id);
		String[] ignoreFields = { "id", "name", "createdDate" };
		BeanUtils.copyProperties(addressBookDTO, updateAddressRequest, ignoreFields);
		addressBookRepository.save(updateAddressRequest);
		return addressBookDTO;
	}

	// Ability to Delete data from Address Book using Id.
	@Override
	public AddressBookDTO deleteAddressBook(int id) {
		log.info("Inside deleteAddressBook()");
		AddressBook deleteAddressRequest = findAddressBookById(id);
		addressBookRepository.delete(deleteAddressRequest);
		AddressBookDTO addressBookResponse = modelMapper.map(deleteAddressRequest, AddressBookDTO.class);
		return addressBookResponse;
	}

	// Ability to find Id from AddressBook.
	private AddressBook findAddressBookById(int id) {
		return addressBookRepository.findById(id)
				.orElseThrow(() -> new AddressBookException("No Details found for given id!!!"));
	}

//    @Override
//    public List<StateAndCityDTO> getStateAndCityDetails() {
//        return iStateAndCityRepo.findAll().stream().map(state -> new StateAndCityDTO(state.getId(),
//                state.getState(), state.getCity())).collect(Collectors.toList());
//    }

	@Override
	public AddressBookDTO getAddressDetailsByID(int id) {
		log.info("Inside getAddressDetailsByID()");
		AddressBook addressBook = findAddressBookById(id);
		AddressBookDTO addressBookResponse = modelMapper.map(addressBook, AddressBookDTO.class);
		return addressBookResponse;
	}
}
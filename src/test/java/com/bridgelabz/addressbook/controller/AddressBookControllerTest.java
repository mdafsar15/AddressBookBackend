package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.service.AddressBookService;
import com.bridgelabz.addressbook.service.IAddressBookService;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookControllerTest {

    @InjectMocks
    private AddressBookController addressBookController;

    @Mock
    private IAddressBookService addressBookService;

    //Ability to write Test Case for getAddress()
    @Test
    public void getAddressTest(){
        when(addressBookService.getAddress()).thenReturn(Lists.newArrayList(new AddressBookDTO()));
        ResponseEntity<ResponseDTO> responseEntity = addressBookController.getAddress();
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Fetched Address Book Data", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
    }

    //Ability to write Test Case for addAddressBook()
    @Test
    public void addAddressBookTest(){
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setName("Test");
        addressBookDTO.setAddress("Akola");
        addressBookDTO.setCity("Akola");
        addressBookDTO.setState("Mh");
        addressBookDTO.setZip("444001");
        addressBookDTO.setPhone("9876543210");

        when(addressBookService.addAddressBook(addressBookDTO)).thenReturn(new AddressBookDTO());
        ResponseEntity<ResponseDTO> responseEntity = addressBookController.addAddressBook(addressBookDTO);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Added Address Book Data", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
    }

    //Ability to write Test Case for updateAddressBook()
    @Test
    public void updateAddressBookTest(){
        int id =1;
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setName("Test");
        addressBookDTO.setAddress("Akola");
        addressBookDTO.setCity("Akola");
        addressBookDTO.setState("Mh");
        addressBookDTO.setZip("444001");
        addressBookDTO.setPhone("9876543210");

        when(addressBookService.updateAddressBook(id, addressBookDTO)).thenReturn(new AddressBookDTO());
        ResponseEntity<ResponseDTO> responseEntity = addressBookController.updateAddressBook(id, addressBookDTO);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Updated Address Book Data", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
    }

    //Ability to write Test Case for deleteAddressBook()
    @Test
    public void deleteAddressBookTest(){
        int id=1;
        when(addressBookService.deleteAddressBook(id)).thenReturn(new AddressBookDTO());
        ResponseEntity<ResponseDTO> responseEntity = addressBookController.deleteAddressBook(id);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Deleted Address Book Data", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
    }
}
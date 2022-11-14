package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBook;
import com.bridgelabz.addressbook.repository.IAddressBookRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookServiceTest {

    @InjectMocks
    private AddressBookService addressBookService;

    @Mock
    private IAddressBookRepo addressBookRepo;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void getAddressTest(){

        List<AddressBook> address = new ArrayList<>();

        AddressBook addressBook1 = new AddressBook();
        addressBook1.setName("Divya");
        addressBook1.setAddress("Jatharpeth");
        addressBook1.setCity("Akola");
        addressBook1.setState("Mh");
        addressBook1.setZip("444001");
        addressBook1.setPhone("9876543210");

        AddressBook addressBook2 = new AddressBook();
        addressBook2.setName("Tushar");
        addressBook2.setAddress("Jatharpeth");
        addressBook2.setCity("Akola");
        addressBook2.setState("Mh");
        addressBook2.setZip("444001");
        addressBook2.setPhone("9876543210");

        AddressBookDTO addressBookDTO1 = new AddressBookDTO();
     //   addressBookDTO1.setId(1);
        addressBookDTO1.setName("Divya");
        addressBookDTO1.setAddress("Jatharpeth");
        addressBookDTO1.setCity("Akola");
        addressBookDTO1.setState("Mh");
        addressBookDTO1.setZip("444001");
        addressBookDTO1.setPhone("9876543210");

        AddressBookDTO addressBookDTO2 = new AddressBookDTO();
      //  addressBookDTO2.setId(2);
        addressBookDTO2.setName("Tushar");
        addressBookDTO2.setAddress("Jatharpeth");
        addressBookDTO2.setCity("Akola");
        addressBookDTO2.setState("Mh");
        addressBookDTO2.setZip("444001");
        addressBookDTO2.setPhone("9876543210");

        assertNotNull(address);
        when(addressBookRepo.findAll()).thenReturn(address);
        when(modelMapper.map(address.get(0), AddressBookDTO.class)).thenReturn(addressBookDTO1);
        when(modelMapper.map(address.get(1), AddressBookDTO.class)).thenReturn(addressBookDTO2);

        List<AddressBookDTO> actualAddressBook = addressBookService.getAddress();

//        assertNotNull(actualAddressBook);
//        for (int i = 0; i < address.size(); i++) {
//            assertEquals(i+1, actualAddressBook.get(i).getId());
//        }
        assertEquals("Divya", actualAddressBook.get(0).getName());
        assertEquals("Jatharpeth", actualAddressBook.get(0).getAddress());
        assertEquals("Akola", actualAddressBook.get(0).getCity());
        assertEquals("Akola", actualAddressBook.get(0).getState());

        assertEquals("Tushar", actualAddressBook.get(0).getName());
        assertEquals("Jatharpeth", actualAddressBook.get(0).getAddress());
        assertEquals("Akola", actualAddressBook.get(0).getCity());
        assertEquals("Akola", actualAddressBook.get(0).getState());

    }
}

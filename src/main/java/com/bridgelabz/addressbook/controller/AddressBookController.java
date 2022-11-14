package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService iAddressBookService;

    //Ability to get all data from Address Book.
    @GetMapping(value = "/get")
    public ResponseEntity<ResponseDTO> getAddress() {
        log.info("Inside getAddress()");
        List<AddressBookDTO> addressbookList = iAddressBookService.getAddress();
        ResponseDTO responseDTO = new ResponseDTO("Fetched Address Book Data", addressbookList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Ability to add data in Address Book.
    @PostMapping(value = "/add")
    public ResponseEntity<ResponseDTO> addAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Inside addAddressBook()");
        AddressBookDTO addAddress = iAddressBookService.addAddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added Address Book Data",addAddress);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //Ability to update data in Address Book Using Id.
    @PutMapping(value = "/update")
    public ResponseEntity<ResponseDTO> updateAddressBook(@RequestParam(name = "id") int id,@Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Inside updateAddressBook()");
        AddressBookDTO updateAddress = iAddressBookService.updateAddressBook(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Address Book Data", updateAddress);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    //Ability to Delete data from Address Book  using Id.
    @DeleteMapping(value = "/delete")
    public ResponseEntity<ResponseDTO> deleteAddressBook(@RequestParam(name="id") int id ){
        log.info("Inside deleteAddressBook()");
        AddressBookDTO deleteAddress = iAddressBookService.deleteAddressBook(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Address Book Data",deleteAddress);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/getById")
    public ResponseEntity<ResponseDTO> getAddressDetailsByID(@RequestParam(name = "id") int id) {
        log.info("Inside getAddressDetailsByID()");
        AddressBookDTO addressBookDTO = iAddressBookService.getAddressDetailsByID(id);
        ResponseDTO responseDTO = new ResponseDTO("Fetched Address Book Data by ID", addressBookDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getStateDetails")
    public ResponseEntity<ResponseDTO> getStateDetails(){
        ResponseDTO responseDTO = new ResponseDTO("Fetched all State Details", iAddressBookService.getStateAndCityDetails());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
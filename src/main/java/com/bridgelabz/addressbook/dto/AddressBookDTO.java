package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    private int id;

    @NotEmpty(message = "Name cannot be Null")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$",message = "Invalid Name")
    private String name;

    @NotEmpty(message = "Address cannot be null")
    private String address;

    @NotEmpty(message = "City cannot be null")
    private String city;

    @NotEmpty(message = "State cannot be null")
    private String state;

    @NotEmpty(message = "Phone cannot be null")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid Phone")
    private String phone;

    @NotEmpty(message = "Zip cannot be null")
    private String zip;
}
package com.bridgelabz.addressbook.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"phone"})})
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;
    private String address;
    private String city;
    private String state;
    private String phone;
    private String zip;

    @CreationTimestamp
    private LocalDate createdDate;

    @UpdateTimestamp
    private LocalDate updatedDate;


}

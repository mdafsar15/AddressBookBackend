package com.bridgelabz.addressbook.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class StateAndCity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String state;

	@ElementCollection
	@CollectionTable(name = "state_city", joinColumns = @JoinColumn(name = "id"))
	private List<String> city;
}
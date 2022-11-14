package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.StateAndCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStateAndCityRepo extends JpaRepository<StateAndCity, Integer> {
}

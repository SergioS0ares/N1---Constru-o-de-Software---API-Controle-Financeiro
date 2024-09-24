package com.example.financeiroApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financeiroApp.model.PersonModel;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}

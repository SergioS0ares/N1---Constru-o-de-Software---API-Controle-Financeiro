package com.example.financeiroApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financeiroApp.model.GroupModel;

public interface GroupRepository extends JpaRepository<GroupModel, Long>{
}

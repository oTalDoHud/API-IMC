package com.example.imc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.imc.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Integer>{

}

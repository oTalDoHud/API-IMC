package com.example.imc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.imc.Repositories.OperationRepository;
import com.example.imc.model.Operation;

@Service
public class OperationService {

	@Autowired
	private OperationRepository opRepo;
	
	public String imcResult (Double peso, Double altura) {
		double imc = peso / Math.pow(altura, 2);
		Operation op = new Operation(peso, altura, imc);
		opRepo.save(op);
		
		return String.format("%.2f", imc);
	}

	public Operation findByid(Integer id) {
		Optional<Operation> op = opRepo.findById(id);
		
		return op.get();
	}
}

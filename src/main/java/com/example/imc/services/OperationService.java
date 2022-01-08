package com.example.imc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.imc.Repositories.OperationRepository;
import com.example.imc.model.Operation;

@Service
public class OperationService {

	@Autowired
	private OperationRepository opRepo;
	
	public String imcResult (Double n1, Double n2) {
		double imc = n1 / Math.pow(n2, 2);
		Operation op = new Operation(n1, n2, imc);
		opRepo.save(op);
		
		return String.format("%.2f", imc);
	}
}

package com.example.imc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.imc.Repositories.OperationRepository;
import com.example.imc.model.Operation;

@Service
public class OperationService {

	@Autowired
	private OperationRepository opRepo;
	
	public ResponseEntity<String> imcResult (Double peso, Double altura) {
		
		if(peso < 0 || peso == 0) {
			return ResponseEntity.badRequest()
				.body("Erro! Peso não pode ser menor ou igual a 0.");
		}
		
		if(altura < 0 || altura == 0) {
			return ResponseEntity.badRequest()
				.body("Erro! Altura não pode ser menor ou igual a 0.");
		}
		
		double imc = peso / Math.pow(altura, 2);
		Operation op = new Operation(peso, altura, imc);
		opRepo.save(op);
		String strImc = String.format("%.2f", imc);
		
		return ResponseEntity.ok().body("O seu IMC é: " + strImc);
	}

	public Operation findByid(Integer id) {
		Optional<Operation> op = opRepo.findById(id);
		
		return op.get();
	}
}

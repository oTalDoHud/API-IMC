package com.example.imc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.imc.Repositories.OperationRepository;
import com.example.imc.model.Operation;
import com.example.imc.model.enums.Gender;

@Service
public class OperationService {

	@Autowired
	private OperationRepository opRepo;
	
	public ResponseEntity<String> imcResultMan (Double peso, Double altura) {
		
		if(peso < 0 || peso == 0) {
			return ResponseEntity.badRequest()
				.body("Erro! Peso não pode ser menor ou igual a 0.");
		}
		
		if(altura < 0 || altura == 0) {
			return ResponseEntity.badRequest()
				.body("Erro! Altura não pode ser menor ou igual a 0.");
		}
		
		double imc = peso / Math.pow(altura, 2);
		Operation op = new Operation(peso, altura, imc, Gender.MASCULINO);
		opRepo.save(op);
		String strImc = String.format("%.2f", imc);
		
		if (imc < 18) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com baixo peso, procure um médico.");
		}
		
		if (imc >= 18 && imc <= 25) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com peso normal.");
		}
		
		if (imc > 25 && imc <= 35) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com sobrepeso.");
		}
		
		if (imc > 35 && imc <= 40) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade moderada.");
		}
		
		if (imc > 40 && imc <= 50) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade grave.");
		}
		
		if (imc > 50) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade gravíssima.");
		}
		
		return null;
	}
	
public ResponseEntity<String> imcResultWoman (Double peso, Double altura) {
		
		if(peso < 0 || peso == 0) {
			return ResponseEntity.badRequest()
				.body("Erro! Peso não pode ser menor ou igual a 0.");
		}
		
		if(altura < 0 || altura == 0) {
			return ResponseEntity.badRequest()
				.body("Erro! Altura não pode ser menor ou igual a 0.");
		}
		
		double imc = peso / Math.pow(altura, 2);
		Operation op = new Operation(peso, altura, imc, Gender.FEMININO);
		opRepo.save(op);
		String strImc = String.format("%.2f", imc);
		
		if (imc < 18) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com baixo peso, procure um médico.");
		}
		
		if (imc < 18) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com baixo peso, procure um médico.");
		}
		
		if (imc >= 18 && imc <= 24) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com peso normal.");
		}
		
		if (imc > 24 && imc <= 35) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com sobrepeso.");
		}
		
		if (imc > 35 && imc <= 40) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade moderada.");
		}
		
		if (imc > 40 && imc <= 50) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade grave.");
		}
		
		if (imc > 50) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade gravíssima.");
		}
		
		return null;
	}

	public Operation findByid(Integer id) {
		Optional<Operation> op = opRepo.findById(id);
		
		return op.get();
	}
}

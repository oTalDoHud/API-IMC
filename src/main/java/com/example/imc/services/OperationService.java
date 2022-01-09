package com.example.imc.services;

import java.time.Instant;
import java.util.List;
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
		Operation op = new Operation(peso, altura, imc, Instant.now(), Gender.MASCULINO);
		opRepo.save(op);
		String strImc = String.format("%.1f", imc);
		
		if (imc < 18) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com baixo peso, procure um médico."
					+ "\nO seu IMC ideal é de 18-25");
		}
		
		if (imc >= 18 && imc <= 25) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com peso normal."
					+ "\nO seu IMC ideal é de 18-25");
		}
		
		if (imc > 25 && imc <= 35) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com sobrepeso."
					+ "\nO seu IMC ideal é de 18-25");
		}
		
		if (imc > 35 && imc <= 40) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade moderada."
					+ "\nO seu IMC ideal é de 18-25");
		}
		
		if (imc > 40 && imc <= 50) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade grave."
					+ "\nO seu IMC ideal é de 18-25");
		}
		
		if (imc > 50) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade gravíssima."
					+ "\nO seu IMC ideal é de 18-25");
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
		Operation op = new Operation(peso, altura, imc, Instant.now(), Gender.FEMININO);
		opRepo.save(op);
		String strImc = String.format("%.1f", imc);
		
		if (imc < 18) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com baixo peso, procure um médico."
					+ "\nO seu IMC ideal é de 18-24");
		}
		
		if (imc < 18) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com baixo peso, procure um médico."
					+ "\nO seu IMC ideal é de 18-24");
		}
		
		if (imc >= 18 && imc <= 24) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com peso normal."
					+ "\nO seu IMC ideal é de 18-24");
		}
		
		if (imc > 24 && imc <= 35) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com sobrepeso."
					+ "\nO seu IMC ideal é de 18-24");
		}
		
		if (imc > 35 && imc <= 40) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade moderada."
					+ "\nO seu IMC ideal é de 18-24");
		}
		
		if (imc > 40 && imc <= 50) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade grave."
					+ "\nO seu IMC ideal é de 18-24");
		}
		
		if (imc > 50) {
			return ResponseEntity.ok().body("O seu IMC é: " + strImc 
					+ "\nVocê está com obesidade gravíssima."
					+ "\nO seu IMC ideal é de 18-24");
		}
		
		return null;
	}

	public Operation findByid(Integer id) {
		Optional<Operation> op = opRepo.findById(id);
		
		return op.get();
	}
	
	public List<Operation> findAll() {
		return opRepo.findAll();
	}
}

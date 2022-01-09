package com.example.imc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.imc.model.Operation;
import com.example.imc.services.OperationService;

@RestController
@RequestMapping(path = "/imc")
public class OperationController {

	@Autowired
	private OperationService service;
	
	@PostMapping
	public ResponseEntity<String> imcResult(
			@RequestParam(name = "peso") Double peso, 
			@RequestParam(name = "altura") Double altura) {
		
		return service.imcResult(peso, altura);
	}
	
	@GetMapping(path = "/{id}")
	public Operation imcFindById(@PathVariable Integer id) {
		
		return service.findByid(id);
	}
}

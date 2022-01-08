package com.example.imc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.imc.services.OperationService;

@RestController
@RequestMapping(path = "/imc")
public class OperationController {

	@Autowired
	private OperationService service;
	
	@PostMapping
	public String imcResult(@RequestParam(name = "n1") Double n1, 
			@RequestParam(name = "n2") Double n2) {
		return service.imcResult(n1, n2);
	}
}

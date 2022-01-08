package com.example.imc.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/imc")
public class OperationController {

	@PostMapping
	public Double imcResult(@RequestParam(name = "n1") Double n1, 
			@RequestParam(name = "n2") Double n2) {
		double imc = n1 / Math.pow(n2, 2);
		return imc;
	}
}

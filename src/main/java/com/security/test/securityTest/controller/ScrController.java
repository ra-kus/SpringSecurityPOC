package com.security.test.securityTest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/secure")
public class ScrController {
	
	@GetMapping(value = "/tst")
	ResponseEntity<String> getAll() {
		String testValue = "show value after authentication";
		return new ResponseEntity<String>(testValue, HttpStatus.OK);
	}
}

package com.athenas.appback.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class App {

	@GetMapping("/")
	public ResponseEntity<String> inicio() {
		return ResponseEntity.ok("ok");
	}
}

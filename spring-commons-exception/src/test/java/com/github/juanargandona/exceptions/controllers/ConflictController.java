package com.github.juanargandona.exceptions.controllers;

import com.github.juanargandona.exceptions.impl.ConflictException;
import com.github.juanargandona.exceptions.model.FooObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ConflictController {

	@PostMapping("/conflict")
	private FooObject conflict() throws ConflictException {
		throw new ConflictException("2020", "conflict", Optional.empty());
	}
}

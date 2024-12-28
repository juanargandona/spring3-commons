package com.github.juanargandona.exceptions.controllers;

import com.github.juanargandona.exceptions.impl.BadRequestException;
import com.github.juanargandona.exceptions.model.FooObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BadRequestController {

	@PostMapping("/badrequest")
	private FooObject badRequest() throws BadRequestException {
		throw new BadRequestException("2020", "badrequest", Optional.empty());
	}
}

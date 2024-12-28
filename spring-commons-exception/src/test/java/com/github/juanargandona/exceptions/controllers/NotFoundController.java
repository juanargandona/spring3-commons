package com.github.juanargandona.exceptions.controllers;

import com.github.juanargandona.exceptions.impl.NotFoundException;
import com.github.juanargandona.exceptions.model.FooObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class NotFoundController {

	@PostMapping("/notfound")
	private FooObject badRequest() throws NotFoundException {
		throw new NotFoundException("202", "notfound", Optional.empty());
	}
}

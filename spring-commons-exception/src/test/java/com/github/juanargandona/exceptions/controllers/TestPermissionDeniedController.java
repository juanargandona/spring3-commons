package com.github.juanargandona.exceptions.controllers;

import com.github.juanargandona.exceptions.impl.PermissionDeniedException;
import com.github.juanargandona.exceptions.model.FooObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestPermissionDeniedController {

	@PostMapping("/permissionDenied")
	private FooObject permissionDenied() throws PermissionDeniedException {
		throw new PermissionDeniedException("", "permissionDenied", Optional.empty());
	}

}

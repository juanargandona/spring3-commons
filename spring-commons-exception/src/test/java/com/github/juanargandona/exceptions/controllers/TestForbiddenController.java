package com.github.juanargandona.exceptions.controllers;

import com.github.juanargandona.exceptions.impl.ForbiddenException;
import com.github.juanargandona.exceptions.model.FooObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestForbiddenController {

    @PostMapping("/forbbiden")
    private FooObject forbbiden() throws ForbiddenException {
        throw new ForbiddenException("", "forbbiden", Optional.empty());
    }

}

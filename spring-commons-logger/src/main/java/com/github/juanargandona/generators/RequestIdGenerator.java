package com.github.juanargandona.generators;

import jakarta.servlet.http.HttpServletRequest;

public interface RequestIdGenerator {
    String getRequestId(HttpServletRequest request);
}
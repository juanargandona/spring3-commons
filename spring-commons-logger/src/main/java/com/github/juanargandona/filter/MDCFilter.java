package com.github.juanargandona.filter;

import com.github.juanargandona.configuration.PropertiesLogger;
import com.github.juanargandona.generators.RequestIdGenerator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MDCFilter extends OncePerRequestFilter {

    @Autowired
    private PropertiesLogger properties;

    @Autowired
    private RequestIdGenerator generator;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            // Setup MDC data:
            // Referenced in Spring Boot's logging.pattern.level property
            MDC.put("clientIp", request.getRemoteAddr());
            MDC.put("appName", properties.getAppName());
            if (HttpServletRequest.class.isAssignableFrom(request.getClass())) {
                MDC.put("path", request.getRequestURI());
                MDC.put("requestId", generator.getRequestId(request));
                Enumeration<String> headers = request.getHeaderNames();
                while (headers.hasMoreElements()) {
                    String headerName = headers.nextElement();
                    String headerValue = request.getHeader(headerName);
                    if (headerValue != null && headerName.toUpperCase().startsWith("X-")) {
                        MDC.put(headerName, headerValue);
                    }
                }
            }
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

    @Override
    public void destroy() {
        MDC.clear();
    }

}

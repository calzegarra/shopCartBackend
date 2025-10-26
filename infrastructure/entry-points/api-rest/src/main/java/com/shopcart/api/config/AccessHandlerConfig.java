package com.shopcart.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
public class AccessHandlerConfig implements AccessDeniedHandler {

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, IOException {


        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        String json = "{"
                + "\"status\": false,"
                + "\"code\": 403,"
                + "\"message\": \"El usuario autenticado no tiene privilegios suficientes para acceder a este servicio.\","
                + "\"path\": \"" + request.getRequestURI() + "\""
                + "}";

        response.getWriter().write(json);
    }
}

package com.shopcart.api.auth;

import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.auth.Auth;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthService {
    private final UserUseCase useCase;

    @PostMapping(path = "/profile")
    public ResponseData login(@Validated @RequestBody Auth data) {
        ResponseData responseData = useCase.findByUser(data);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.ACCEPTED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }


    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/session-admin")
    public ResponseEntity<String> adminDashboard() {
        return ResponseEntity.ok("Bienvenido, ADMINISTRADOR.");
    }

    @PreAuthorize("hasRole('EMPLEADO')")
    @GetMapping("/session-employee")
    public ResponseEntity<String> employeeDashboard() {
        return ResponseEntity.ok("Bienvenido, EMPLEADO.");
    }

    @PreAuthorize("hasRole('CLIENTE')")
    @GetMapping("/session-client")
    public ResponseEntity<String> clientDashboard() {
        return ResponseEntity.ok("Bienvenido, CLIENTE.");
    }
}

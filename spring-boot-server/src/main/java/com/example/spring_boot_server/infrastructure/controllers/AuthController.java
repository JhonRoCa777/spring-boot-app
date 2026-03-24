package com.example.spring_boot_server.infrastructure.controllers;

import com.example.spring_boot_server.domain.enums.DocumentTypeEnum;
import com.example.spring_boot_server.domain.enums.RoleEnum;
import com.example.spring_boot_server.infrastructure.models.UserModel;
import com.example.spring_boot_server.infrastructure.adapters.UserRepository;
import com.example.spring_boot_server.infrastructure.utils.JwtUtil;
import com.example.spring_boot_server.infrastructure.validators.UserLoginValidator;
import com.example.spring_boot_server.infrastructure.validators.UserRegisterValidator;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.encoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginValidator request, HttpServletResponse response) {

        Optional<UserModel> userOpt = userRepository.findByDocumentTypeAndDocument(
                DocumentTypeEnum.valueOf(request.documentType()),
                request.document()
        );

        if (userOpt.isEmpty())
            return ResponseEntity.status(401).body(Map.of("message", "Credenciales inválidas"));

        UserModel user = userOpt.get();

        if (!encoder.matches(request.password(), user.getPassword()))
            return ResponseEntity.status(401).body(Map.of("message", "Credenciales inválidas"));

        String token = jwtUtil.generateToken(user.getId());

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(86400);
        response.addCookie(cookie);

        return ResponseEntity.ok(Map.of("message", "Login exitoso"));
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verify(HttpServletRequest request) {

        String token = Arrays.stream(request.getCookies())
                .filter(c -> "token".equals(c.getName()))
                .map(Cookie::getValue)
                .findFirst()
                .orElse(null);

        if (token == null || !jwtUtil.isValid(token))
            return ResponseEntity.status(401).body(Map.of("message", "No autenticado"));

        return ResponseEntity.ok(Map.of(
            "message", "Token válido",
            "userId", jwtUtil.extractUserId(token).toString()
        ));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("token", "");
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return ResponseEntity.ok(Map.of("message", "Logout exitoso"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterValidator request, HttpServletResponse response) {

        Optional<UserModel> existing = userRepository.findByDocumentTypeAndDocument(
                DocumentTypeEnum.valueOf(request.documentType()),
                request.document()
        );

        if (existing.isPresent())
            return ResponseEntity.status(409).body(Map.of("message", "El usuario ya existe"));

        UserModel user = new UserModel();
        user.setDocumentType(DocumentTypeEnum.valueOf(request.documentType()));
        user.setDocument(request.document());
        user.setNames(request.names());
        user.setLastNames(request.lastNames());
        user.setPassword(encoder.encode(request.password()));
        user.setRole(RoleEnum.USER);

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getId());

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(86400);
        response.addCookie(cookie);

        return ResponseEntity.status(201).body(Map.of("message", "Usuario creado exitosamente"));
    }
}
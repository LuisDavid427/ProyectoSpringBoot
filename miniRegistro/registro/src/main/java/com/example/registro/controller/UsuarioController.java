package com.example.registro.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registro.model.UsuarioModel;
import com.example.registro.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@Valid @RequestBody UsuarioModel usuario) {
        try {
            UsuarioModel guardado = usuarioRepository.save(usuario);
            return ResponseEntity.ok(guardado);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "la cedula ya existe o hubo un error en los datos");
            return ResponseEntity.badRequest().body(error);
        }
    }
}
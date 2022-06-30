package com.example.academiaapi.controller;
import com.example.academiaapi.config.AuthService;
import com.example.academiaapi.dto.UserResponseDTO;
import com.example.academiaapi.entity.UserEntity;

import com.example.academiaapi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final AuthService authService;

    private final UserService userService;

    public UserController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> findAllPaged(Pageable pageable) {
        authService.validateAdmin();
        Page<UserResponseDTO> list = userService.findAllPaged(pageable);
        return ResponseEntity.ok(list);

    }



    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        authService.validateSelfOrAdmin(id);
        UserResponseDTO userResponseDTO = userService.findById(id);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> insert(@Valid @RequestBody UserEntity user) {
        authService.validateAdmin();
        UserResponseDTO entity = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id,  @RequestBody UserEntity user) {
        authService.validateAdmin();
        return ResponseEntity.ok(userService.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        authService.validateSelfOrAdmin(id);
        userService.deleteById(id);
        return new ResponseEntity<>("Usuario deletado com sucesso", HttpStatus.OK);
    }




}

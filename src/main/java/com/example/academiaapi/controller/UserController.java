package com.example.academiaapi.controller;
import com.example.academiaapi.dto.UserResposeDTO;
import com.example.academiaapi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserResposeDTO>> findAllPaged(Pageable pageable){
        Page<UserResposeDTO> list = userService.findAllPaged(pageable);
        return ResponseEntity.ok(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResposeDTO> findById(@PathVariable Long id) {
        UserResposeDTO userResposeDTO = userService.findById(id);


        return ResponseEntity.ok(userResposeDTO);
    }




}

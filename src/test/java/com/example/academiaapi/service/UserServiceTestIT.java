package com.example.academiaapi.service;

import com.example.academiaapi.dto.UserResponseDTO;
import com.example.academiaapi.entity.UserEntity;
import com.example.academiaapi.repository.UserRepository;
import com.example.academiaapi.service.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
@Transactional
class UserServiceTestIT {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    private Long existingId;
    private Long nonExistingId;
    private Long countTotalUsers;
    private Pageable pageable;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        countTotalUsers = 1L;
    }

    @Test
    void findAllPagedShouldReturnAllPages() {
        pageable = PageRequest.of(0,10);


        Page<UserResponseDTO> result =  service.findAllPaged(pageable);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(1,result.getTotalElements());

    }

    @Test
    void findByIdShouldReturnUserWhenIdExists() {
       UserResponseDTO user = service.findById(existingId);
       Assertions.assertEquals(1,user.getId());
    }
    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.deleteById(nonExistingId);
        });
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {

        pageable = PageRequest.of(0,10);
        service.deleteById(existingId);
        Assertions.assertEquals(0,service.findAllPaged(pageable).getTotalElements());
    }

    @Test
    void loadUserByUsernameShouldReturnUserWhenUsernameExist() {
       UserDetails entity = service.loadUserByUsername("pabloleal7@hotmail.com");
       Assertions.assertEquals("pabloleal7@hotmail.com", entity.getUsername());

    }
}
package com.example.academiaapi.repository;

import com.example.academiaapi.entity.UserEntity;
import com.example.academiaapi.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalUsers;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        countTotalUsers = 1L;
    }

    @Test
    void findByEmail() {
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {

        UserEntity user= Factory.createUserEntity();
        user.setId(null);

        user = repository.save(user);
        Optional<UserEntity> result = repository.findById(user.getId());

        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals(countTotalUsers + 1L, user.getId());
        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(result.get(), user);
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);

        Optional<UserEntity> result = repository.findById(existingId);

        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }
}
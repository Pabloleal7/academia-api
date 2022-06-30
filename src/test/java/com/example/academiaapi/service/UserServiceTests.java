package com.example.academiaapi.service;

import com.example.academiaapi.dto.UserResponseDTO;
import com.example.academiaapi.entity.UserEntity;
import com.example.academiaapi.repository.UserRepository;
import com.example.academiaapi.service.exceptions.DatabaseException;
import com.example.academiaapi.service.exceptions.ResourceNotFoundException;
import com.example.academiaapi.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class UserServiceTests {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    private long existingId;
    private long nonExistingId;
    private long dependentId;
    private UserEntity user;
    private PageImpl<UserEntity> page;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 2L;
        dependentId = 3L;
        user = Factory.createUserEntity();
        page = new PageImpl<>(List.of(user));

        Mockito.when(repository.findAll((Pageable) ArgumentMatchers.any())).thenReturn(page);

        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(user);

        Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(user));
        Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());

        Mockito.doNothing().when(repository).deleteById(existingId);
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistingId);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentId);
    }

    @Test
    public void findAllPagedShouldReturnPage() {

        Pageable pageable = PageRequest.of(0, 12);

        Page<UserResponseDTO> result = service.findAllPaged(pageable);

        Assertions.assertNotNull(result);

        Mockito.verify(repository, times(1)).findAll(pageable);
    }

    @Test
    public void deleteShouldThrowDatabaseExceptionWhenDependentId() {

        Assertions.assertThrows(DatabaseException.class, () -> {
            service.deleteById(dependentId);
        });

        Mockito.verify(repository, times(1)).deleteById(dependentId);
    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.deleteById(nonExistingId);
        });

        Mockito.verify(repository, times(1)).deleteById(nonExistingId);
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> {
            service.deleteById(existingId);
        });

        Mockito.verify(repository, times(1)).deleteById(existingId);
    }


}

package com.example.academiaapi.controller;

import com.example.academiaapi.dto.UserResponseDTO;
import com.example.academiaapi.service.UserService;
import com.example.academiaapi.service.exceptions.ResourceNotFoundException;
import com.example.academiaapi.tests.Factory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {


// TODO Implementar Token para os testes
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService service;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private Long existingId;
//    private Long nonExistingId;
//
//    private UserResponseDTO userResponseDTO;
//    private PageImpl<UserResponseDTO> page;
//
//    @BeforeEach
//    void setUp() throws Exception {
//
//        existingId = 1L;
//        nonExistingId = 2L;
//
//
//        userResponseDTO = new UserResponseDTO(Factory.createUserEntity());
//        page = new PageImpl<>(List.of(userResponseDTO));
//
//        when(service.findAllPaged(any())).thenReturn(page);
//
//        when(service.findById(existingId)).thenReturn(userResponseDTO);
//        when(service.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);
//
//        when(service.insert(any())).thenReturn(userResponseDTO);
//
//        when(service.update(eq(existingId), any())).thenReturn(userResponseDTO);
//        when(service.update(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);
//
//        doNothing().when(service).deleteById(existingId);
//        doThrow(ResourceNotFoundException.class).when(service).deleteById(nonExistingId);
//    }
//
//    @Test
//    public void deleteShouldReturnNoContentWhenIdExists() throws Exception {
//
//        ResultActions result =
//                mockMvc.perform(delete("/users/{id}", existingId)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void deleteShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
//
//        ResultActions result =
//                mockMvc.perform(delete("/users/{id}", nonExistingId)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void insertShouldReturnProductDTOCreated() throws Exception {
//
//        String jsonBody = objectMapper.writeValueAsString(userResponseDTO);
//
//        ResultActions result =
//                mockMvc.perform(post("/users")
//                        .content(jsonBody)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isCreated());
//        result.andExpect(jsonPath("$.id").exists());
//        result.andExpect(jsonPath("$.nome").exists());
//        result.andExpect(jsonPath("$.email").exists());
//    }
//
//    @Test
//    public void updateShouldReturnUserResponseDTOWhenIdExists() throws Exception {
//
//        String jsonBody = objectMapper.writeValueAsString(userResponseDTO);
//
//        ResultActions result =
//                mockMvc.perform(put("/users/{id}", existingId)
//                        .content(jsonBody)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isOk());
//        result.andExpect(jsonPath("$.id").exists());
//        result.andExpect(jsonPath("$.nome").exists());
//        result.andExpect(jsonPath("$.email").exists());
//    }
//
//    @Test
//    public void updateShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
//
//        String jsonBody = objectMapper.writeValueAsString(userResponseDTO);
//
//        ResultActions result =
//                mockMvc.perform(put("/users/{id}", nonExistingId)
//                        .content(jsonBody)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void findAllShouldReturnPage() throws Exception {
//
//        ResultActions result =
//                mockMvc.perform(get("/users")
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isOk());
//    }
//
//    @Test
//    public void findByIdShouldReturnUserWhenIdExists() throws Exception {
//
//        ResultActions result =
//                mockMvc.perform(get("/users/{id}", existingId)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isOk());
//        result.andExpect(jsonPath("$.id").exists());
//        result.andExpect(jsonPath("$.nome").exists());
//        result.andExpect(jsonPath("$.email").exists());
//    }
//
//    @Test
//    public void findByIdShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
//
//        ResultActions result =
//                mockMvc.perform(get("/users/{id}", nonExistingId)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isNotFound());
//    }
//


}

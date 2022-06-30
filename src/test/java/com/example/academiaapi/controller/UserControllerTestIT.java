package com.example.academiaapi.controller;

import com.example.academiaapi.config.AuthService;
import com.example.academiaapi.dto.UserResponseDTO;
import com.example.academiaapi.repository.UserRepository;
import com.example.academiaapi.service.UserService;
import com.example.academiaapi.tests.Factory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

//
// TODO Token
//
//    @Test
//    public void findAllShouldReturnSortedPageWhenWithoutToken() throws Exception {
//
//        ResultActions result =
//                mockMvc.perform(get("/users")
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().is4xxClientError());
//
//
//    }





}

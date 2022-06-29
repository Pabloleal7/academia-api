package com.example.academiaapi.service;

import com.example.academiaapi.dto.UserResposeDTO;
import com.example.academiaapi.entity.UserEntity;
import com.example.academiaapi.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Page<UserResposeDTO> findAllPaged(Pageable pageable){
        Page<UserEntity> list = userRepository.findAll(pageable);

        return list.map(UserResposeDTO::new);
    }

    public UserResposeDTO findById(Long id) {
        Optional<UserEntity> userResposeDTO = userRepository.findById(id);
        return new UserResposeDTO(userResposeDTO.get());

    }

    public void deleteById(Long id) {
    }
}

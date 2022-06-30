package com.example.academiaapi.service;

import com.example.academiaapi.config.AuthService;
import com.example.academiaapi.dto.UserResponseDTO;
import com.example.academiaapi.entity.FichaEntity;
import com.example.academiaapi.entity.UserEntity;
import com.example.academiaapi.repository.UserRepository;
import com.example.academiaapi.service.exceptions.DatabaseException;

import com.example.academiaapi.service.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {



    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;


    public UserService( UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    public Page<UserResponseDTO> findAllPaged(Pageable pageable) {

        Page<UserEntity> list = userRepository.findAll(pageable);
        return list.map(UserResponseDTO::new);
    }

    public UserResponseDTO findById(Long id) {

        Optional<UserEntity> user = userRepository.findById(id);
        UserEntity entity = user.orElseThrow(() -> new ResourceNotFoundException("Exercicio não encontrado"));
        return new UserResponseDTO(entity);
    }


    public UserResponseDTO insert(UserEntity user) {

        user.setId(null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new UserResponseDTO(userRepository.save(user));
    }

    public UserResponseDTO update(Long id, UserEntity userEntity) {


        Optional<UserEntity> entity = userRepository.findById(id);

        entity.ifPresent(u -> {


            if (userEntity.getNome() != null) {
                u.setNome(userEntity.getNome());
            }
            if (userEntity.getEmail() != null) {
                u.setEmail(userEntity.getEmail());
            }
            if (userEntity.getDataDeNascimento() != null) {
                u.setDataDeNascimento(userEntity.getDataDeNascimento());
            }

            if (userEntity.getPassword() != null) {
                u.setPassword(userEntity.getPassword());
            }
            if (userEntity.getTelefone() != null) {
                u.setTelefone(userEntity.getTelefone());
            }

            Set<FichaEntity> fichas = userEntity.getFichas();

           if(fichas != null){
               u.setFichas(userEntity.getFichas());
           }


        });
        UserEntity user = userRepository.save(entity.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado " + id)));
        return new UserResponseDTO(user);
    }

    public void deleteById(Long id) {

        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id " + id + " não encontrado ");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integridade violada, existe entidades utilizando o exercicio");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(username);
        if (user == null) {
            logger.error("User not found: " + username);

            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + username);

        return user;
    }
}

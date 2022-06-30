package com.example.academiaapi.controller;
import com.example.academiaapi.entity.ExercicioInfoEntity;
import com.example.academiaapi.service.ExercicioInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/exercicioinfo")
public class ExercicioInfoController {
    private final ExercicioInfoService exercicioInfoService;

    public ExercicioInfoController(ExercicioInfoService exercicioInfoService) {
        this.exercicioInfoService = exercicioInfoService;
    }



    @GetMapping
    public ResponseEntity<Page<ExercicioInfoEntity>> findAllPaged(Pageable pageable) {
        Page<ExercicioInfoEntity> list = exercicioInfoService.findAllPaged(pageable);
        return ResponseEntity.ok(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioInfoEntity> findById(@PathVariable Long id) {
        ExercicioInfoEntity entity = exercicioInfoService.findById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<ExercicioInfoEntity> insert(@Valid @RequestBody ExercicioInfoEntity exercicioInfoEntity) {
        ExercicioInfoEntity entity = exercicioInfoService.insert(exercicioInfoEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExercicioInfoEntity> update(@PathVariable Long id, @Valid @RequestBody ExercicioInfoEntity exercicioInfoEntity){

        return ResponseEntity.ok(exercicioInfoService.update(id,exercicioInfoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        exercicioInfoService.deleteById(id);
        return new ResponseEntity<>("Exercicio deletado com sucesso", HttpStatus.OK);
    }
}

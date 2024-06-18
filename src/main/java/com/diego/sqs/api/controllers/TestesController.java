package com.diego.sqs.api.controllers;

import com.diego.sqs.api.requests.TesteRequest;
import com.diego.sqs.api.services.TesteService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/testes")
public class TestesController {

    @Autowired
    TesteService testeService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return new ResponseEntity<>(testeService.listarTodos(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> findByCpf(@Parameter(name = "cpf", description = "Parâmetro referente ao 'cpf' do teste a ser consultada.", required = true) @RequestParam("cpf") String cpf) {
        return new ResponseEntity<>(testeService.buscarPorCpf(cpf), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(testeService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping (value = "")
    public ResponseEntity<?> create (@Valid @RequestBody TesteRequest testeRequest){
        return new ResponseEntity<>(testeService.cadastrar(testeRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "")
    public ResponseEntity<?> delete(@Parameter(name = "id", description = "Parâmetro referente ao id do teste a ser deletado.", required = true) @RequestParam("id") long id) {
        testeService.deletePorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

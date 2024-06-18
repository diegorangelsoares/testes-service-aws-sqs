package com.diego.sqs.api.controllers;

import com.diego.sqs.api.requests.TesteRequest;
import com.diego.sqs.api.services.TesteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/fila")
public class TestesSQSController {

    @Autowired
    TesteService testeService;

    @PostMapping (value = "/send")
    public ResponseEntity<?> sendQueue (@Valid @RequestBody TesteRequest testeRequest){
        log.info("Enviando para fila o texto: "+testeRequest.getTexto());
        testeService.enviaTesteFila( testeRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

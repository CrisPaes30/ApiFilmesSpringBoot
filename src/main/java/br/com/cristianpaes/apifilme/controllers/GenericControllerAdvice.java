package br.com.cristianpaes.apifilme.controllers;


import br.com.cristianpaes.apifilme.exceptions.NoCreatedExceptions;
import br.com.cristianpaes.apifilme.exceptions.NotfoundExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.Provider;

@ControllerAdvice
public class GenericControllerAdvice {

    Logger LOGGER = LoggerFactory.getLogger(GenericControllerAdvice.class);

    @ExceptionHandler({NotfoundExceptions.class})
    public ResponseEntity<String> handle(final NotfoundExceptions e) {
        final String recursoInexistente = "Nome ou Id não encontrado";
        LOGGER.error(recursoInexistente);
        return new ResponseEntity<>(recursoInexistente, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NoCreatedExceptions.class})
    public ResponseEntity<String> handle(final NoCreatedExceptions e){
        final String naoCriado = "Filme não criado: Verificar nome, diretor ou ano se já está add!";
        LOGGER.error(naoCriado);
        return new ResponseEntity<>(naoCriado, HttpStatus.CREATED);
    }
}

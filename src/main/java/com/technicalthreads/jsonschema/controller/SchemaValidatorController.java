package com.technicalthreads.jsonschema.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.technicalthreads.jsonschema.model.Request;
import com.technicalthreads.jsonschema.model.Response;
import com.technicalthreads.jsonschema.service.SchemaValidatorService;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")

public class SchemaValidatorController {

    @Autowired
    SchemaValidatorService schemaValidatorService;

    @PostMapping(value="/validateJson")
    public ResponseEntity<Response> validateJsonSchema(@RequestBody Request request) throws JsonProcessingException{
        return new ResponseEntity<>(schemaValidatorService.validateJsonRequest(request), HttpStatus.OK);
    }
}

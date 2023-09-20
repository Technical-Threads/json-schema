package com.technicalthreads.jsonschema.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.technicalthreads.jsonschema.model.Request;
import com.technicalthreads.jsonschema.model.Response;

public interface SchemaValidatorService {

    Response validateJsonRequest(Request request) throws JsonProcessingException;
}

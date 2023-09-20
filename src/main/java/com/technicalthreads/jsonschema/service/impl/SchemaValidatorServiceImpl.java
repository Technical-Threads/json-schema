package com.technicalthreads.jsonschema.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.technicalthreads.jsonschema.exceptions.SchemaValidationException;
import com.technicalthreads.jsonschema.model.Request;
import com.technicalthreads.jsonschema.model.Response;
import com.technicalthreads.jsonschema.service.SchemaValidatorService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.InputStream;
import java.util.Set;

@Service

public class SchemaValidatorServiceImpl implements SchemaValidatorService {
    @Override
    public Response validateJsonRequest(Request request) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        InputStream validSchemaRules=SchemaValidatorServiceImpl.class.getClassLoader().getResourceAsStream("schema/validSchema.json");
        JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7).getSchema(validSchemaRules);
        String json = objectMapper.writeValueAsString(request);
        Set<ValidationMessage> validationMessages=schema.validate(objectMapper.readTree(json));
        System.out.print(validationMessages.toString());
        if(validationMessages.isEmpty()){
            System.out.println("Hurray Valid Json");
            Response response= new Response(request.getId(),request.getName(),request.getDescription(),request.getObjective(),"Valid Json");
            return response;
        }
        throw new SchemaValidationException(validationMessages.toString());
    }
}

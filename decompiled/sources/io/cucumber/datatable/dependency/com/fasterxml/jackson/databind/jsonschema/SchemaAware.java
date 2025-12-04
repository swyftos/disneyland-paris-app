package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonschema;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public interface SchemaAware {
    JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException;

    JsonNode getSchema(SerializerProvider serializerProvider, Type type, boolean z) throws JsonMappingException;
}

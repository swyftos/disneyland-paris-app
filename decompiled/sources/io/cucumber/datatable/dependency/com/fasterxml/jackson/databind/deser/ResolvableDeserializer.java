package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;

/* loaded from: classes5.dex */
public interface ResolvableDeserializer {
    void resolve(DeserializationContext deserializationContext) throws JsonMappingException;
}

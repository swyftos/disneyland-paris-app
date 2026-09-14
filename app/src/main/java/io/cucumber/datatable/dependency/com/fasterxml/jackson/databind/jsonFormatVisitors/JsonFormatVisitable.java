package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;

/* JADX INFO: loaded from: classes5.dex */
public interface JsonFormatVisitable {
    void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException;
}

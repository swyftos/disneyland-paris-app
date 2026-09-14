package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.AccessPattern;

/* JADX INFO: loaded from: classes5.dex */
public interface NullValueProvider {
    AccessPattern getNullAccessPattern();

    Object getNullValue(DeserializationContext deserializationContext) throws JsonMappingException;
}

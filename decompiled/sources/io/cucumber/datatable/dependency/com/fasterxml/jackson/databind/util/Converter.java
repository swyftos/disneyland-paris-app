package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.TypeFactory;

/* loaded from: classes5.dex */
public interface Converter<IN, OUT> {

    public static abstract class None implements Converter<Object, Object> {
    }

    OUT convert(IN in);

    JavaType getInputType(TypeFactory typeFactory);

    JavaType getOutputType(TypeFactory typeFactory);
}

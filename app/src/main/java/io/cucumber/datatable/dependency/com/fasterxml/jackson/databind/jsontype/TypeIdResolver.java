package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DatabindContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface TypeIdResolver {
    String getDescForKnownTypeIds();

    JsonTypeInfo.EnumC6684Id getMechanism();

    String idFromBaseType();

    String idFromValue(Object obj);

    String idFromValueAndType(Object obj, Class<?> cls);

    void init(JavaType javaType);

    JavaType typeFromId(DatabindContext databindContext, String str) throws IOException;
}

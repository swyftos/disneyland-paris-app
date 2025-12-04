package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonToken;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class DeserializationProblemHandler {
    public static final Object NOT_HANDLED = new Object();

    public JavaType handleMissingTypeId(DeserializationContext deserializationContext, JavaType javaType, TypeIdResolver typeIdResolver, String str) throws IOException {
        return null;
    }

    public boolean handleUnknownProperty(DeserializationContext deserializationContext, JsonParser jsonParser, JsonDeserializer<?> jsonDeserializer, Object obj, String str) throws IOException {
        return false;
    }

    public JavaType handleUnknownTypeId(DeserializationContext deserializationContext, JavaType javaType, String str, TypeIdResolver typeIdResolver, String str2) throws IOException {
        return null;
    }

    public Object handleWeirdKey(DeserializationContext deserializationContext, Class<?> cls, String str, String str2) throws IOException {
        return NOT_HANDLED;
    }

    public Object handleWeirdStringValue(DeserializationContext deserializationContext, Class<?> cls, String str, String str2) throws IOException {
        return NOT_HANDLED;
    }

    public Object handleWeirdNumberValue(DeserializationContext deserializationContext, Class<?> cls, Number number, String str) throws IOException {
        return NOT_HANDLED;
    }

    public Object handleWeirdNativeValue(DeserializationContext deserializationContext, JavaType javaType, Object obj, JsonParser jsonParser) throws IOException {
        return NOT_HANDLED;
    }

    public Object handleUnexpectedToken(DeserializationContext deserializationContext, Class<?> cls, JsonToken jsonToken, JsonParser jsonParser, String str) throws IOException {
        return NOT_HANDLED;
    }

    public Object handleInstantiationProblem(DeserializationContext deserializationContext, Class<?> cls, Object obj, Throwable th) throws IOException {
        return NOT_HANDLED;
    }

    public Object handleMissingInstantiator(DeserializationContext deserializationContext, Class<?> cls, ValueInstantiator valueInstantiator, JsonParser jsonParser, String str) throws IOException {
        return handleMissingInstantiator(deserializationContext, cls, jsonParser, str);
    }

    @Deprecated
    public Object handleMissingInstantiator(DeserializationContext deserializationContext, Class<?> cls, JsonParser jsonParser, String str) throws IOException {
        return NOT_HANDLED;
    }
}

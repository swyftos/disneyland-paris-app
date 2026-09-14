package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.annotation;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JacksonAnnotation;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes5.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonTypeIdResolver {
    Class<? extends TypeIdResolver> value();
}

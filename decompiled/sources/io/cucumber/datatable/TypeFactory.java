package io.cucumber.datatable;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes5.dex */
abstract class TypeFactory {
    private static final io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.TypeFactory typeFactory = io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.TypeFactory.defaultInstance();

    static JavaType aListOf(Type type) {
        io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.TypeFactory typeFactory2 = typeFactory;
        return typeFactory2.constructCollectionType(List.class, typeFactory2.constructType(type));
    }

    static JavaType constructType(Type type) {
        return typeFactory.constructType(type);
    }

    static String typeName(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }
}

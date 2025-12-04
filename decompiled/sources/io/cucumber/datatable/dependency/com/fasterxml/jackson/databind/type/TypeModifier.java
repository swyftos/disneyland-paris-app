package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public abstract class TypeModifier {
    public abstract JavaType modifyType(JavaType javaType, Type type, TypeBindings typeBindings, TypeFactory typeFactory);
}

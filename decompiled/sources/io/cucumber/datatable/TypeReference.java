package io.cucumber.datatable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public abstract class TypeReference<T> {
    private final Type type;

    protected TypeReference() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new CucumberDataTableException("Missing type parameter: " + genericSuperclass);
        }
        this.type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }
}

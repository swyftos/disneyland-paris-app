package gherkin.deps.com.google.gson.internal.bind;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.TypeAdapter;
import gherkin.deps.com.google.gson.TypeAdapterFactory;
import gherkin.deps.com.google.gson.annotations.JsonAdapter;
import gherkin.deps.com.google.gson.internal.ConstructorConstructor;
import gherkin.deps.com.google.gson.reflect.TypeToken;

/* loaded from: classes5.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // gherkin.deps.com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    static TypeAdapter getTypeAdapter(ConstructorConstructor constructorConstructor, Gson gson, TypeToken typeToken, JsonAdapter jsonAdapter) {
        Class<?> clsValue = jsonAdapter.value();
        if (TypeAdapter.class.isAssignableFrom(clsValue)) {
            return (TypeAdapter) constructorConstructor.get(TypeToken.get((Class) clsValue)).construct();
        }
        if (TypeAdapterFactory.class.isAssignableFrom(clsValue)) {
            return ((TypeAdapterFactory) constructorConstructor.get(TypeToken.get((Class) clsValue)).construct()).create(gson, typeToken);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }
}

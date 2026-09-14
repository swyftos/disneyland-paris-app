package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes4.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private static final TypeAdapterFactory TREE_TYPE_CLASS_DUMMY_FACTORY;
    private static final TypeAdapterFactory TREE_TYPE_FIELD_DUMMY_FACTORY;
    private final ConcurrentMap adapterFactoryMap = new ConcurrentHashMap();
    private final ConstructorConstructor constructorConstructor;

    private static class DummyTypeAdapterFactory implements TypeAdapterFactory {
        private DummyTypeAdapterFactory() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            throw new AssertionError("Factory should not be used");
        }
    }

    static {
        TREE_TYPE_CLASS_DUMMY_FACTORY = new DummyTypeAdapterFactory();
        TREE_TYPE_FIELD_DUMMY_FACTORY = new DummyTypeAdapterFactory();
    }

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    private static JsonAdapter getAnnotation(Class cls) {
        return (JsonAdapter) cls.getAnnotation(JsonAdapter.class);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter annotation = getAnnotation(typeToken.getRawType());
        if (annotation == null) {
            return null;
        }
        return getTypeAdapter(this.constructorConstructor, gson, typeToken, annotation, true);
    }

    private static Object createAdapter(ConstructorConstructor constructorConstructor, Class cls) {
        return constructorConstructor.get(TypeToken.get(cls), true).construct();
    }

    private TypeAdapterFactory putFactoryAndGetCurrent(Class cls, TypeAdapterFactory typeAdapterFactory) {
        TypeAdapterFactory typeAdapterFactory2 = (TypeAdapterFactory) this.adapterFactoryMap.putIfAbsent(cls, typeAdapterFactory);
        return typeAdapterFactory2 != null ? typeAdapterFactory2 : typeAdapterFactory;
    }

    TypeAdapter getTypeAdapter(ConstructorConstructor constructorConstructor, Gson gson, TypeToken typeToken, JsonAdapter jsonAdapter, boolean z) {
        TypeAdapterFactory typeAdapterFactory;
        TypeAdapter treeTypeAdapter;
        Object objCreateAdapter = createAdapter(constructorConstructor, jsonAdapter.value());
        boolean zNullSafe = jsonAdapter.nullSafe();
        if (objCreateAdapter instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) objCreateAdapter;
        } else if (objCreateAdapter instanceof TypeAdapterFactory) {
            TypeAdapterFactory typeAdapterFactoryPutFactoryAndGetCurrent = (TypeAdapterFactory) objCreateAdapter;
            if (z) {
                typeAdapterFactoryPutFactoryAndGetCurrent = putFactoryAndGetCurrent(typeToken.getRawType(), typeAdapterFactoryPutFactoryAndGetCurrent);
            }
            treeTypeAdapter = typeAdapterFactoryPutFactoryAndGetCurrent.create(gson, typeToken);
        } else {
            boolean z2 = objCreateAdapter instanceof JsonSerializer;
            if (z2 || (objCreateAdapter instanceof JsonDeserializer)) {
                JsonSerializer jsonSerializer = z2 ? (JsonSerializer) objCreateAdapter : null;
                JsonDeserializer jsonDeserializer = objCreateAdapter instanceof JsonDeserializer ? (JsonDeserializer) objCreateAdapter : null;
                if (z) {
                    typeAdapterFactory = TREE_TYPE_CLASS_DUMMY_FACTORY;
                } else {
                    typeAdapterFactory = TREE_TYPE_FIELD_DUMMY_FACTORY;
                }
                treeTypeAdapter = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, gson, typeToken, typeAdapterFactory, zNullSafe);
                zNullSafe = false;
            } else {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objCreateAdapter.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        return (treeTypeAdapter == null || !zNullSafe) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }

    public boolean isClassJsonAdapterFactory(TypeToken<?> typeToken, TypeAdapterFactory typeAdapterFactory) {
        Objects.requireNonNull(typeToken);
        Objects.requireNonNull(typeAdapterFactory);
        if (typeAdapterFactory == TREE_TYPE_CLASS_DUMMY_FACTORY) {
            return true;
        }
        Class<? super Object> rawType = typeToken.getRawType();
        TypeAdapterFactory typeAdapterFactory2 = (TypeAdapterFactory) this.adapterFactoryMap.get(rawType);
        if (typeAdapterFactory2 != null) {
            return typeAdapterFactory2 == typeAdapterFactory;
        }
        JsonAdapter annotation = getAnnotation(rawType);
        if (annotation == null) {
            return false;
        }
        Class<?> clsValue = annotation.value();
        return TypeAdapterFactory.class.isAssignableFrom(clsValue) && putFactoryAndGetCurrent(rawType, (TypeAdapterFactory) createAdapter(this.constructorConstructor, clsValue)) == typeAdapterFactory;
    }
}

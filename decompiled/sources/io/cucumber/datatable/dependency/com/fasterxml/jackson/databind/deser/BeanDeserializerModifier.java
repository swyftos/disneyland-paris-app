package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanDescription;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.KeyDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.ArrayType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.CollectionLikeType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.CollectionType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.MapLikeType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.MapType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.ReferenceType;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class BeanDeserializerModifier {
    public JsonDeserializer<?> modifyArrayDeserializer(DeserializationConfig deserializationConfig, ArrayType arrayType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyCollectionDeserializer(DeserializationConfig deserializationConfig, CollectionType collectionType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyCollectionLikeDeserializer(DeserializationConfig deserializationConfig, CollectionLikeType collectionLikeType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyDeserializer(DeserializationConfig deserializationConfig, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyEnumDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public KeyDeserializer modifyKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, KeyDeserializer keyDeserializer) {
        return keyDeserializer;
    }

    public JsonDeserializer<?> modifyMapDeserializer(DeserializationConfig deserializationConfig, MapType mapType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyMapLikeDeserializer(DeserializationConfig deserializationConfig, MapLikeType mapLikeType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyReferenceDeserializer(DeserializationConfig deserializationConfig, ReferenceType referenceType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public BeanDeserializerBuilder updateBuilder(DeserializationConfig deserializationConfig, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) {
        return beanDeserializerBuilder;
    }

    public List<BeanPropertyDefinition> updateProperties(DeserializationConfig deserializationConfig, BeanDescription beanDescription, List<BeanPropertyDefinition> list) {
        return list;
    }
}

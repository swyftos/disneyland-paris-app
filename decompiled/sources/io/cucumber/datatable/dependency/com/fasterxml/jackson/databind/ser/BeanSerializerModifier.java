package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanDescription;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializationConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.ArrayType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.CollectionLikeType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.CollectionType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.MapLikeType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.MapType;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class BeanSerializerModifier {
    public List<BeanPropertyWriter> changeProperties(SerializationConfig serializationConfig, BeanDescription beanDescription, List<BeanPropertyWriter> list) {
        return list;
    }

    public JsonSerializer<?> modifyArraySerializer(SerializationConfig serializationConfig, ArrayType arrayType, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
        return jsonSerializer;
    }

    public JsonSerializer<?> modifyCollectionLikeSerializer(SerializationConfig serializationConfig, CollectionLikeType collectionLikeType, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
        return jsonSerializer;
    }

    public JsonSerializer<?> modifyCollectionSerializer(SerializationConfig serializationConfig, CollectionType collectionType, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
        return jsonSerializer;
    }

    public JsonSerializer<?> modifyEnumSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
        return jsonSerializer;
    }

    public JsonSerializer<?> modifyKeySerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
        return jsonSerializer;
    }

    public JsonSerializer<?> modifyMapLikeSerializer(SerializationConfig serializationConfig, MapLikeType mapLikeType, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
        return jsonSerializer;
    }

    public JsonSerializer<?> modifyMapSerializer(SerializationConfig serializationConfig, MapType mapType, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
        return jsonSerializer;
    }

    public JsonSerializer<?> modifySerializer(SerializationConfig serializationConfig, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
        return jsonSerializer;
    }

    public List<BeanPropertyWriter> orderProperties(SerializationConfig serializationConfig, BeanDescription beanDescription, List<BeanPropertyWriter> list) {
        return list;
    }

    public BeanSerializerBuilder updateBuilder(SerializationConfig serializationConfig, BeanDescription beanDescription, BeanSerializerBuilder beanSerializerBuilder) {
        return beanSerializerBuilder;
    }
}

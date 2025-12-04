package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.cfg;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdResolver;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.KeyDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializationConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.Annotated;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Converter;

/* loaded from: classes5.dex */
public abstract class HandlerInstantiator {
    public Converter<?, ?> converterInstance(MapperConfig<?> mapperConfig, Annotated annotated, Class<?> cls) {
        return null;
    }

    public abstract JsonDeserializer<?> deserializerInstance(DeserializationConfig deserializationConfig, Annotated annotated, Class<?> cls);

    public Object includeFilterInstance(SerializationConfig serializationConfig, BeanPropertyDefinition beanPropertyDefinition, Class<?> cls) {
        return null;
    }

    public abstract KeyDeserializer keyDeserializerInstance(DeserializationConfig deserializationConfig, Annotated annotated, Class<?> cls);

    public PropertyNamingStrategy namingStrategyInstance(MapperConfig<?> mapperConfig, Annotated annotated, Class<?> cls) {
        return null;
    }

    public ObjectIdGenerator<?> objectIdGeneratorInstance(MapperConfig<?> mapperConfig, Annotated annotated, Class<?> cls) {
        return null;
    }

    public ObjectIdResolver resolverIdGeneratorInstance(MapperConfig<?> mapperConfig, Annotated annotated, Class<?> cls) {
        return null;
    }

    public abstract JsonSerializer<?> serializerInstance(SerializationConfig serializationConfig, Annotated annotated, Class<?> cls);

    public abstract TypeIdResolver typeIdResolverInstance(MapperConfig<?> mapperConfig, Annotated annotated, Class<?> cls);

    public abstract TypeResolverBuilder<?> typeResolverBuilderInstance(MapperConfig<?> mapperConfig, Annotated annotated, Class<?> cls);

    public ValueInstantiator valueInstantiatorInstance(MapperConfig<?> mapperConfig, Annotated annotated, Class<?> cls) {
        return null;
    }

    public VirtualBeanPropertyWriter virtualPropertyWriterInstance(MapperConfig<?> mapperConfig, Class<?> cls) {
        return null;
    }
}

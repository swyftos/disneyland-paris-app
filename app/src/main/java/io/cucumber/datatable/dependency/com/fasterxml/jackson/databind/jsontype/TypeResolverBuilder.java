package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializationConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
public interface TypeResolverBuilder<T extends TypeResolverBuilder<T>> {
    TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection);

    TypeSerializer buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection);

    T defaultImpl(Class<?> cls);

    Class<?> getDefaultImpl();

    T inclusion(JsonTypeInfo.EnumC6683As enumC6683As);

    T init(JsonTypeInfo.EnumC6684Id enumC6684Id, TypeIdResolver typeIdResolver);

    T typeIdVisibility(boolean z);

    T typeProperty(String str);
}

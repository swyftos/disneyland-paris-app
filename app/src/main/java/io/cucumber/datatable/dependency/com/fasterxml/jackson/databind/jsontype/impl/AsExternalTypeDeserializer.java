package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

/* JADX INFO: loaded from: classes5.dex */
public class AsExternalTypeDeserializer extends AsArrayTypeDeserializer {
    private static final long serialVersionUID = 1;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer
    protected boolean _usesExternalId() {
        return true;
    }

    public AsExternalTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, String str, boolean z, JavaType javaType2) {
        super(javaType, typeIdResolver, str, z, javaType2);
    }

    public AsExternalTypeDeserializer(AsExternalTypeDeserializer asExternalTypeDeserializer, BeanProperty beanProperty) {
        super(asExternalTypeDeserializer, beanProperty);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeDeserializer
    public TypeDeserializer forProperty(BeanProperty beanProperty) {
        return beanProperty == this._property ? this : new AsExternalTypeDeserializer(this, beanProperty);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeDeserializer
    public JsonTypeInfo.EnumC6683As getTypeInclusion() {
        return JsonTypeInfo.EnumC6683As.EXTERNAL_PROPERTY;
    }
}

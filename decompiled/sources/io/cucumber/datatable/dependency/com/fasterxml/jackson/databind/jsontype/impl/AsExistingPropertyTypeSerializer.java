package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

/* loaded from: classes5.dex */
public class AsExistingPropertyTypeSerializer extends AsPropertyTypeSerializer {
    public AsExistingPropertyTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty, str);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public AsExistingPropertyTypeSerializer forProperty(BeanProperty beanProperty) {
        return this._property == beanProperty ? this : new AsExistingPropertyTypeSerializer(this._idResolver, beanProperty, this._typePropertyName);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.TypeSerializerBase, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public JsonTypeInfo.As getTypeInclusion() {
        return JsonTypeInfo.As.EXISTING_PROPERTY;
    }
}

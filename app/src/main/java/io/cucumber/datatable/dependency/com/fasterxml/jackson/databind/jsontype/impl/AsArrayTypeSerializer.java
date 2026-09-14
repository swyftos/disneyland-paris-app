package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

/* JADX INFO: loaded from: classes5.dex */
public class AsArrayTypeSerializer extends TypeSerializerBase {
    public AsArrayTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public AsArrayTypeSerializer forProperty(BeanProperty beanProperty) {
        return this._property == beanProperty ? this : new AsArrayTypeSerializer(this._idResolver, beanProperty);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.impl.TypeSerializerBase, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public JsonTypeInfo.EnumC6683As getTypeInclusion() {
        return JsonTypeInfo.EnumC6683As.WRAPPER_ARRAY;
    }
}

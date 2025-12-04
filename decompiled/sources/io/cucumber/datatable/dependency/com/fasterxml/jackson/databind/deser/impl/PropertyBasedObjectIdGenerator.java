package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.impl;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerators;

/* loaded from: classes5.dex */
public class PropertyBasedObjectIdGenerator extends ObjectIdGenerators.PropertyGenerator {
    private static final long serialVersionUID = 1;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator<Object> newForSerialization(Object obj) {
        return this;
    }

    public PropertyBasedObjectIdGenerator(Class<?> cls) {
        super(cls);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
    public Object generateId(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator<Object> forScope(Class<?> cls) {
        return cls == this._scope ? this : new PropertyBasedObjectIdGenerator(cls);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator.IdKey key(Object obj) {
        if (obj == null) {
            return null;
        }
        return new ObjectIdGenerator.IdKey(getClass(), this._scope, obj);
    }
}

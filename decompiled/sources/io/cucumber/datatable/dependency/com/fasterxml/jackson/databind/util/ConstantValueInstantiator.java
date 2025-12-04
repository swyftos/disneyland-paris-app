package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import java.io.IOException;

/* loaded from: classes5.dex */
public class ConstantValueInstantiator extends ValueInstantiator {
    protected final Object _value;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateUsingDefault() {
        return true;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canInstantiate() {
        return true;
    }

    public ConstantValueInstantiator(Object obj) {
        this._value = obj;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Class<?> getValueClass() {
        return this._value.getClass();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
        return this._value;
    }
}

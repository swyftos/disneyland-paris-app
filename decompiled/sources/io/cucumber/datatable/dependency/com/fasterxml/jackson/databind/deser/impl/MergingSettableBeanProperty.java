package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.impl;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.IOException;

/* loaded from: classes5.dex */
public class MergingSettableBeanProperty extends SettableBeanProperty.Delegating {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMember _accessor;

    protected MergingSettableBeanProperty(SettableBeanProperty settableBeanProperty, AnnotatedMember annotatedMember) {
        super(settableBeanProperty);
        this._accessor = annotatedMember;
    }

    protected MergingSettableBeanProperty(MergingSettableBeanProperty mergingSettableBeanProperty, SettableBeanProperty settableBeanProperty) {
        super(settableBeanProperty);
        this._accessor = mergingSettableBeanProperty._accessor;
    }

    public static MergingSettableBeanProperty construct(SettableBeanProperty settableBeanProperty, AnnotatedMember annotatedMember) {
        return new MergingSettableBeanProperty(settableBeanProperty, annotatedMember);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating
    protected SettableBeanProperty withDelegate(SettableBeanProperty settableBeanProperty) {
        return new MergingSettableBeanProperty(settableBeanProperty, this._accessor);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws UnsupportedOperationException, IOException, IllegalArgumentException {
        Object objDeserializeWith;
        Object value = this._accessor.getValue(obj);
        if (value == null) {
            objDeserializeWith = this.delegate.deserialize(jsonParser, deserializationContext);
        } else {
            objDeserializeWith = this.delegate.deserializeWith(jsonParser, deserializationContext, value);
        }
        if (objDeserializeWith != value) {
            this.delegate.set(obj, objDeserializeWith);
        }
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public Object deserializeSetAndReturn(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws UnsupportedOperationException, IOException, IllegalArgumentException {
        Object objDeserializeWith;
        Object value = this._accessor.getValue(obj);
        if (value == null) {
            objDeserializeWith = this.delegate.deserialize(jsonParser, deserializationContext);
        } else {
            objDeserializeWith = this.delegate.deserializeWith(jsonParser, deserializationContext, value);
        }
        return (objDeserializeWith == value || objDeserializeWith == null) ? obj : this.delegate.setAndReturn(obj, objDeserializeWith);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public void set(Object obj, Object obj2) throws IOException {
        if (obj2 != null) {
            this.delegate.set(obj, obj2);
        }
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public Object setAndReturn(Object obj, Object obj2) throws IOException {
        return obj2 != null ? this.delegate.setAndReturn(obj, obj2) : obj;
    }
}

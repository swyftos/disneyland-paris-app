package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.impl;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.PropertyMetadata;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.PropertyName;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;

/* loaded from: classes5.dex */
public class ValueInjector extends BeanProperty.Std {
    private static final long serialVersionUID = 1;
    protected final Object _valueId;

    public ValueInjector(PropertyName propertyName, JavaType javaType, AnnotatedMember annotatedMember, Object obj) {
        super(propertyName, javaType, null, annotatedMember, PropertyMetadata.STD_OPTIONAL);
        this._valueId = obj;
    }

    @Deprecated
    public ValueInjector(PropertyName propertyName, JavaType javaType, Annotations annotations, AnnotatedMember annotatedMember, Object obj) {
        this(propertyName, javaType, annotatedMember, obj);
    }

    public Object findValue(DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        return deserializationContext.findInjectableValue(this._valueId, this, obj);
    }

    public void inject(DeserializationContext deserializationContext, Object obj) throws UnsupportedOperationException, IOException, IllegalArgumentException {
        this._member.setValue(obj, findValue(deserializationContext, obj));
    }
}

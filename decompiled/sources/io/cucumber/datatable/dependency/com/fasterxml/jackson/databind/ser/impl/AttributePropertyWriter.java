package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.impl;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonInclude;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.cfg.MapperConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations;

/* loaded from: classes5.dex */
public class AttributePropertyWriter extends VirtualBeanPropertyWriter {
    private static final long serialVersionUID = 1;
    protected final String _attrName;

    protected AttributePropertyWriter(String str, BeanPropertyDefinition beanPropertyDefinition, Annotations annotations, JavaType javaType) {
        this(str, beanPropertyDefinition, annotations, javaType, beanPropertyDefinition.findInclusion());
    }

    protected AttributePropertyWriter(String str, BeanPropertyDefinition beanPropertyDefinition, Annotations annotations, JavaType javaType, JsonInclude.Value value) {
        super(beanPropertyDefinition, annotations, javaType, null, null, null, value, null);
        this._attrName = str;
    }

    public static AttributePropertyWriter construct(String str, BeanPropertyDefinition beanPropertyDefinition, Annotations annotations, JavaType javaType) {
        return new AttributePropertyWriter(str, beanPropertyDefinition, annotations, javaType);
    }

    protected AttributePropertyWriter(AttributePropertyWriter attributePropertyWriter) {
        super(attributePropertyWriter);
        this._attrName = attributePropertyWriter._attrName;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter
    public VirtualBeanPropertyWriter withConfig(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, BeanPropertyDefinition beanPropertyDefinition, JavaType javaType) {
        throw new IllegalStateException("Should not be called on this type");
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter
    protected Object value(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        return serializerProvider.getAttribute(this._attrName);
    }
}

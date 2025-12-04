package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes5.dex */
public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> implements ContextualSerializer {
    protected final Boolean _unwrapSingle;

    public abstract JsonSerializer<?> _withResolved(BeanProperty beanProperty, Boolean bool);

    protected abstract void acceptContentVisitor(JsonArrayFormatVisitor jsonArrayFormatVisitor) throws JsonMappingException;

    protected abstract JsonNode contentSchema();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer
    public abstract void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException;

    protected StaticListSerializerBase(Class<?> cls) {
        super(cls, false);
        this._unwrapSingle = null;
    }

    protected StaticListSerializerBase(StaticListSerializerBase<?> staticListSerializerBase, Boolean bool) {
        super(staticListSerializerBase);
        this._unwrapSingle = bool;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.ContextualSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider r6, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty r7) throws io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L18
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.AnnotationIntrospector r1 = r6.getAnnotationIntrospector()
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r7.getMember()
            if (r2 == 0) goto L18
            java.lang.Object r1 = r1.findContentSerializer(r2)
            if (r1 == 0) goto L18
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer r1 = r6.serializerInstance(r2, r1)
            goto L19
        L18:
            r1 = r0
        L19:
            java.lang.Class r2 = r5.handledType()
            io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonFormat$Value r2 = r5.findFormatOverrides(r6, r7, r2)
            if (r2 == 0) goto L2a
            io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonFormat$Feature r3 = io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r2 = r2.getFeature(r3)
            goto L2b
        L2a:
            r2 = r0
        L2b:
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer r1 = r5.findContextualConvertingSerializer(r6, r7, r1)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r1 != 0) goto L37
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer r1 = r6.findValueSerializer(r3, r7)
        L37:
            boolean r4 = r5.isDefaultSerializer(r1)
            if (r4 == 0) goto L47
            java.lang.Boolean r6 = r5._unwrapSingle
            if (r2 != r6) goto L42
            return r5
        L42:
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer r5 = r5._withResolved(r7, r2)
            return r5
        L47:
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.CollectionSerializer r5 = new io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.CollectionSerializer
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType r6 = r6.constructType(r3)
            r7 = 1
            r5.<init>(r6, r7, r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase.createContextual(io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty):io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer");
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer
    public boolean isEmpty(SerializerProvider serializerProvider, T t) {
        return t == null || t.size() == 0;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.StdSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonschema.SchemaAware
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("array", true).set("items", contentSchema());
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.StdSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonArrayFormatVisitor jsonArrayFormatVisitorExpectArrayFormat = jsonFormatVisitorWrapper.expectArrayFormat(javaType);
        if (jsonArrayFormatVisitorExpectArrayFormat != null) {
            acceptContentVisitor(jsonArrayFormatVisitorExpectArrayFormat);
        }
    }
}

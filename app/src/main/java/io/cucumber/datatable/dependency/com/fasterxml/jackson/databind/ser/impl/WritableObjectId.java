package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.impl;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.SerializableString;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class WritableObjectId {
    public final ObjectIdGenerator<?> generator;

    /* JADX INFO: renamed from: id */
    public Object f3823id;
    protected boolean idWritten = false;

    public WritableObjectId(ObjectIdGenerator<?> objectIdGenerator) {
        this.generator = objectIdGenerator;
    }

    public boolean writeAsId(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, ObjectIdWriter objectIdWriter) throws IOException {
        if (this.f3823id == null) {
            return false;
        }
        if (!this.idWritten && !objectIdWriter.alwaysAsId) {
            return false;
        }
        if (jsonGenerator.canWriteObjectId()) {
            jsonGenerator.writeObjectRef(String.valueOf(this.f3823id));
            return true;
        }
        objectIdWriter.serializer.serialize(this.f3823id, jsonGenerator, serializerProvider);
        return true;
    }

    public Object generateId(Object obj) {
        if (this.f3823id == null) {
            this.f3823id = this.generator.generateId(obj);
        }
        return this.f3823id;
    }

    public void writeAsField(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, ObjectIdWriter objectIdWriter) throws IOException {
        this.idWritten = true;
        if (jsonGenerator.canWriteObjectId()) {
            Object obj = this.f3823id;
            jsonGenerator.writeObjectId(obj == null ? null : String.valueOf(obj));
            return;
        }
        SerializableString serializableString = objectIdWriter.propertyName;
        if (serializableString != null) {
            jsonGenerator.writeFieldName(serializableString);
            objectIdWriter.serializer.serialize(this.f3823id, jsonGenerator, serializerProvider);
        }
    }
}

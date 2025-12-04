package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonToken;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.type.WritableTypeId;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.lang.reflect.Type;

@JacksonStdImpl
/* loaded from: classes5.dex */
public class ToStringSerializer extends StdSerializer<Object> {
    public static final ToStringSerializer instance = new ToStringSerializer();

    public ToStringSerializer() {
        super(Object.class);
    }

    public ToStringSerializer(Class<?> cls) {
        super(cls, false);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer
    public boolean isEmpty(SerializerProvider serializerProvider, Object obj) {
        return obj.toString().isEmpty();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.StdSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(obj.toString());
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer
    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdWriteTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(obj, JsonToken.VALUE_STRING));
        serialize(obj, jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffix(jsonGenerator, writableTypeIdWriteTypePrefix);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.StdSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonschema.SchemaAware
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        return createSchemaNode("string", true);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.StdSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        visitStringFormat(jsonFormatVisitorWrapper, javaType);
    }
}

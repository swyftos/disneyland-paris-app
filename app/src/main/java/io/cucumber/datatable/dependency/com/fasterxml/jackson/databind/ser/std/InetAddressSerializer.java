package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonFormat;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonToken;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.type.WritableTypeId;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes5.dex */
public class InetAddressSerializer extends StdScalarSerializer<InetAddress> implements ContextualSerializer {
    protected final boolean _asNumeric;

    public InetAddressSerializer() {
        this(false);
    }

    public InetAddressSerializer(boolean z) {
        super(InetAddress.class);
        this._asNumeric = z;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.ContextualSerializer
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        boolean z;
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, handledType());
        if (valueFindFormatOverrides != null) {
            JsonFormat.Shape shape = valueFindFormatOverrides.getShape();
            if (shape.isNumeric() || shape == JsonFormat.Shape.ARRAY) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        return z != this._asNumeric ? new InetAddressSerializer(z) : this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.StdSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(InetAddress inetAddress, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String strTrim;
        if (this._asNumeric) {
            strTrim = inetAddress.getHostAddress();
        } else {
            strTrim = inetAddress.toString().trim();
            int iIndexOf = strTrim.indexOf(47);
            if (iIndexOf >= 0) {
                if (iIndexOf == 0) {
                    strTrim = strTrim.substring(1);
                } else {
                    strTrim = strTrim.substring(0, iIndexOf);
                }
            }
        }
        jsonGenerator.writeString(strTrim);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer
    public void serializeWithType(InetAddress inetAddress, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdWriteTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(inetAddress, InetAddress.class, JsonToken.VALUE_STRING));
        serialize(inetAddress, jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffix(jsonGenerator, writableTypeIdWriteTypePrefix);
    }
}

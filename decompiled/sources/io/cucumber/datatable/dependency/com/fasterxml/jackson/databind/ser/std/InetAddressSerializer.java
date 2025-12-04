package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonToken;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.type.WritableTypeId;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.net.InetAddress;

/* loaded from: classes5.dex */
public class InetAddressSerializer extends StdScalarSerializer<InetAddress> implements ContextualSerializer {
    protected final boolean _asNumeric;

    public InetAddressSerializer() {
        this(false);
    }

    public InetAddressSerializer(boolean z) {
        super(InetAddress.class);
        this._asNumeric = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.ContextualSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider r2, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty r3) throws io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r1 = this;
            java.lang.Class r0 = r1.handledType()
            io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonFormat$Value r2 = r1.findFormatOverrides(r2, r3, r0)
            if (r2 == 0) goto L1a
            io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonFormat$Shape r2 = r2.getShape()
            boolean r3 = r2.isNumeric()
            if (r3 != 0) goto L18
            io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonFormat$Shape r3 = io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonFormat.Shape.ARRAY
            if (r2 != r3) goto L1a
        L18:
            r2 = 1
            goto L1b
        L1a:
            r2 = 0
        L1b:
            boolean r3 = r1._asNumeric
            if (r2 == r3) goto L24
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.InetAddressSerializer r1 = new io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.InetAddressSerializer
            r1.<init>(r2)
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.InetAddressSerializer.createContextual(io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty):io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer");
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

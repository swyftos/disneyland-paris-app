package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;

@JacksonStdImpl
/* loaded from: classes5.dex */
public class SqlDateSerializer extends DateTimeSerializerBase<Date> {
    public SqlDateSerializer() {
        this(null, null);
    }

    protected SqlDateSerializer(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
    /* renamed from: withFormat, reason: avoid collision after fix types in other method */
    public DateTimeSerializerBase<Date> withFormat2(Boolean bool, DateFormat dateFormat) {
        return new SqlDateSerializer(bool, dateFormat);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
    public long _timestamp(Date date) {
        if (date == null) {
            return 0L;
        }
        return date.getTime();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.std.StdSerializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (_asTimestamp(serializerProvider)) {
            jsonGenerator.writeNumber(_timestamp(date));
        } else if (this._customFormat == null) {
            jsonGenerator.writeString(date.toString());
        } else {
            _serializeAsString(date, jsonGenerator, serializerProvider);
        }
    }
}

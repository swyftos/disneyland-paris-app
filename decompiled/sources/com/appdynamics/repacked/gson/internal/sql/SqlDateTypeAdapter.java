package com.appdynamics.repacked.gson.internal.sql;

import com.appdynamics.repacked.gson.Gson;
import com.appdynamics.repacked.gson.JsonSyntaxException;
import com.appdynamics.repacked.gson.TypeAdapter;
import com.appdynamics.repacked.gson.TypeAdapterFactory;
import com.appdynamics.repacked.gson.reflect.TypeToken;
import com.appdynamics.repacked.gson.stream.JsonReader;
import com.appdynamics.repacked.gson.stream.JsonToken;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes2.dex */
final class SqlDateTypeAdapter extends TypeAdapter {
    static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.appdynamics.repacked.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // com.appdynamics.repacked.gson.TypeAdapterFactory
        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat format;

    private SqlDateTypeAdapter() {
        this.format = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.appdynamics.repacked.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        java.util.Date date;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String strNextString = jsonReader.nextString();
        try {
            synchronized (this) {
                date = this.format.parse(strNextString);
            }
            return new Date(date.getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as SQL Date; at path " + jsonReader.getPreviousPath(), e);
        }
    }

    @Override // com.appdynamics.repacked.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        String str;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            str = this.format.format((java.util.Date) date);
        }
        jsonWriter.value(str);
    }
}

package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonCreator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public enum JsonFormatTypes {
    STRING,
    NUMBER,
    INTEGER,
    BOOLEAN,
    OBJECT,
    ARRAY,
    NULL,
    ANY;

    private static final Map _byLCName = new HashMap();

    static {
        for (JsonFormatTypes jsonFormatTypes : values()) {
            _byLCName.put(jsonFormatTypes.name().toLowerCase(), jsonFormatTypes);
        }
    }

    @JsonValue
    public String value() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static JsonFormatTypes forValue(String str) {
        return (JsonFormatTypes) _byLCName.get(str);
    }
}

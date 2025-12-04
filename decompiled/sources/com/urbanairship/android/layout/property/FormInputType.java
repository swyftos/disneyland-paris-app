package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum FormInputType {
    EMAIL("email", 33),
    NUMBER("number", 2),
    SMS("sms", 2),
    TEXT("text", 49153),
    TEXT_MULTILINE("text_multiline", 180225);

    private final int typeMask;
    private final String value;

    FormInputType(String str, int i) {
        this.value = str;
        this.typeMask = i;
    }

    @NonNull
    public static FormInputType from(@NonNull String str) throws JsonException {
        for (FormInputType formInputType : values()) {
            if (formInputType.value.equals(str.toLowerCase(Locale.ROOT))) {
                return formInputType;
            }
        }
        throw new JsonException("Unknown Form Input Type value: " + str);
    }

    public int getTypeMask() {
        return this.typeMask;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}

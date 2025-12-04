package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum FormBehaviorType {
    SUBMIT_EVENT("submit_event");

    private final String value;

    FormBehaviorType(String str) {
        this.value = str;
    }

    @NonNull
    public static FormBehaviorType from(@NonNull String str) throws JsonException {
        for (FormBehaviorType formBehaviorType : values()) {
            if (formBehaviorType.value.equals(str.toLowerCase(Locale.ROOT))) {
                return formBehaviorType;
            }
        }
        throw new JsonException("Unknown Form Behavior Type value: " + str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}

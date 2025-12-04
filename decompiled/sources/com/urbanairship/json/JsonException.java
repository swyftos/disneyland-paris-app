package com.urbanairship.json;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public class JsonException extends Exception {
    public JsonException(@NonNull String str) {
        super(str);
    }

    public JsonException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
    }
}

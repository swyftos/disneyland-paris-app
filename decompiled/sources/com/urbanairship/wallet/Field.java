package com.urbanairship.wallet;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;

/* loaded from: classes5.dex */
public class Field implements JsonSerializable {
    private final String label;
    private final String name;
    private final Object value;

    Field(Builder builder) {
        this.name = builder.name;
        this.label = builder.label;
        this.value = builder.value;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    String getName() {
        return this.name;
    }

    @NonNull
    public String toString() {
        return toJsonValue().toString();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonMap.newBuilder().putOpt("label", this.label).putOpt("value", this.value).build().toJsonValue();
    }

    public static class Builder {
        private String label;
        private String name;
        private Object value;

        @NonNull
        public Builder setName(@NonNull @Size(min = 1) String str) {
            this.name = str;
            return this;
        }

        @NonNull
        public Builder setLabel(@Nullable String str) {
            this.label = str;
            return this;
        }

        @NonNull
        public Builder setValue(@Nullable String str) {
            this.value = str;
            return this;
        }

        @NonNull
        public Builder setValue(int i) {
            this.value = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Field build() {
            if (TextUtils.isEmpty(this.name) || (this.value == null && TextUtils.isEmpty(this.label))) {
                throw new IllegalStateException("The field must have a name and either a value or label.");
            }
            return new Field(this);
        }
    }
}

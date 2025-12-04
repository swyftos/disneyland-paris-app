package com.contentsquare.android.internal.core.telemetry.event;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Serializable
/* loaded from: classes2.dex */
public final class CustomEvent implements com.contentsquare.android.internal.core.telemetry.event.a {

    @NotNull
    public static final a Companion = new a();

    @NotNull
    public final String a;

    @NotNull
    public final String b;

    public static final class a {
        @NotNull
        public final KSerializer<CustomEvent> serializer() {
            return CustomEvent$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public CustomEvent(int i, String str, String str2) {
        if (3 != (i & 3)) {
            CustomEvent$$serializer.INSTANCE.getClass();
            PluginExceptionsKt.throwMissingFieldException(i, 3, CustomEvent$$serializer.a);
        }
        this.a = str;
        this.b = str2;
    }

    @Override // com.contentsquare.android.internal.core.telemetry.event.a
    public final void a(@NotNull JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        jsonObject.put(this.a, this.b);
    }

    @Override // com.contentsquare.android.internal.core.telemetry.event.a
    @NotNull
    public final String getKey() {
        return this.a;
    }

    public CustomEvent(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = key;
        this.b = value;
    }

    @Override // com.contentsquare.android.internal.core.telemetry.event.a
    public final com.contentsquare.android.internal.core.telemetry.event.a a(com.contentsquare.android.internal.core.telemetry.event.a other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this;
    }
}

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
public final class ApiUsageEvent implements com.contentsquare.android.internal.core.telemetry.event.a {

    @NotNull
    public static final a Companion = new a();

    @NotNull
    public final String a;
    public final long b;

    public static final class a {
        @NotNull
        public final KSerializer<ApiUsageEvent> serializer() {
            return ApiUsageEvent$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public ApiUsageEvent(int i, String str, long j) {
        if (3 != (i & 3)) {
            ApiUsageEvent$$serializer.INSTANCE.getClass();
            PluginExceptionsKt.throwMissingFieldException(i, 3, ApiUsageEvent$$serializer.a);
        }
        this.a = str;
        this.b = j;
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

    public ApiUsageEvent(@NotNull String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.a = key;
        this.b = j;
    }

    @Override // com.contentsquare.android.internal.core.telemetry.event.a
    @NotNull
    public final com.contentsquare.android.internal.core.telemetry.event.a a(@NotNull com.contentsquare.android.internal.core.telemetry.event.a other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other instanceof ApiUsageEvent ? new ApiUsageEvent(this.a, this.b + ((ApiUsageEvent) other).b) : this;
    }
}

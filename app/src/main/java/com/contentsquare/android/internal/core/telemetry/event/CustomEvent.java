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

/* JADX INFO: loaded from: classes2.dex */
@Serializable
public final class CustomEvent implements InterfaceC2421a {

    @NotNull
    public static final C2419a Companion = new C2419a();

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f1270a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f1271b;

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.telemetry.event.CustomEvent$a */
    public static final class C2419a {
        @NotNull
        public final KSerializer<CustomEvent> serializer() {
            return CustomEvent$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public CustomEvent(int i, String str, String str2) {
        if (3 != (i & 3)) {
            CustomEvent$$serializer.INSTANCE.getClass();
            PluginExceptionsKt.throwMissingFieldException(i, 3, CustomEvent$$serializer.f1272a);
        }
        this.f1270a = str;
        this.f1271b = str2;
    }

    @Override // com.contentsquare.android.internal.core.telemetry.event.InterfaceC2421a
    /* JADX INFO: renamed from: a */
    public final void mo840a(@NotNull JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        jsonObject.put(this.f1270a, this.f1271b);
    }

    @Override // com.contentsquare.android.internal.core.telemetry.event.InterfaceC2421a
    @NotNull
    public final String getKey() {
        return this.f1270a;
    }

    public CustomEvent(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f1270a = key;
        this.f1271b = value;
    }

    @Override // com.contentsquare.android.internal.core.telemetry.event.InterfaceC2421a
    /* JADX INFO: renamed from: a */
    public final InterfaceC2421a mo839a(InterfaceC2421a other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this;
    }
}

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
public final class AppLifeCycleEvent implements InterfaceC2421a {

    @NotNull
    public static final C2418a Companion = new C2418a();

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f1267a;

    /* JADX INFO: renamed from: b */
    public final long f1268b;

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.telemetry.event.AppLifeCycleEvent$a */
    public static final class C2418a {
        @NotNull
        public final KSerializer<AppLifeCycleEvent> serializer() {
            return AppLifeCycleEvent$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public AppLifeCycleEvent(int i, String str, long j) {
        if (3 != (i & 3)) {
            AppLifeCycleEvent$$serializer.INSTANCE.getClass();
            PluginExceptionsKt.throwMissingFieldException(i, 3, AppLifeCycleEvent$$serializer.f1269a);
        }
        this.f1267a = str;
        this.f1268b = j;
    }

    @Override // com.contentsquare.android.internal.core.telemetry.event.InterfaceC2421a
    /* JADX INFO: renamed from: a */
    public final void mo840a(@NotNull JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        jsonObject.put(this.f1267a, this.f1268b);
    }

    @Override // com.contentsquare.android.internal.core.telemetry.event.InterfaceC2421a
    @NotNull
    public final String getKey() {
        return this.f1267a;
    }

    public AppLifeCycleEvent(@NotNull String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f1267a = key;
        this.f1268b = j;
    }

    @Override // com.contentsquare.android.internal.core.telemetry.event.InterfaceC2421a
    @NotNull
    /* JADX INFO: renamed from: a */
    public final InterfaceC2421a mo839a(@NotNull InterfaceC2421a other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other instanceof AppLifeCycleEvent ? new AppLifeCycleEvent(this.f1267a, this.f1268b + ((AppLifeCycleEvent) other).f1268b) : this;
    }
}

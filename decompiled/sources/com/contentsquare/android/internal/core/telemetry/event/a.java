package com.contentsquare.android.internal.core.telemetry.event;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Serializable
/* loaded from: classes2.dex */
public interface a {

    @NotNull
    public static final C0042a Companion = C0042a.a;

    /* renamed from: com.contentsquare.android.internal.core.telemetry.event.a$a, reason: collision with other inner class name */
    public static final class C0042a {
        public static final /* synthetic */ C0042a a = new C0042a();

        @NotNull
        public final KSerializer<a> serializer() {
            return new SealedClassSerializer("com.contentsquare.android.internal.core.telemetry.event.TelemetryEvent", Reflection.getOrCreateKotlinClass(a.class), new KClass[]{Reflection.getOrCreateKotlinClass(ApiUsageEvent.class), Reflection.getOrCreateKotlinClass(AppLifeCycleEvent.class), Reflection.getOrCreateKotlinClass(CustomEvent.class)}, new KSerializer[]{ApiUsageEvent$$serializer.INSTANCE, AppLifeCycleEvent$$serializer.INSTANCE, CustomEvent$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    @NotNull
    a a(@NotNull a aVar);

    void a(@NotNull JSONObject jSONObject);

    @NotNull
    String getKey();
}

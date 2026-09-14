package com.contentsquare.android.internal.core.telemetry.event;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.internal.core.telemetry.event.a */
/* JADX INFO: loaded from: classes2.dex */
@Serializable
public interface InterfaceC2421a {

    @NotNull
    public static final a Companion = a.f1281a;

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.telemetry.event.a$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ a f1281a = new a();

        @NotNull
        public final KSerializer<InterfaceC2421a> serializer() {
            return new SealedClassSerializer("com.contentsquare.android.internal.core.telemetry.event.TelemetryEvent", Reflection.getOrCreateKotlinClass(InterfaceC2421a.class), new KClass[]{Reflection.getOrCreateKotlinClass(ApiUsageEvent.class), Reflection.getOrCreateKotlinClass(AppLifeCycleEvent.class), Reflection.getOrCreateKotlinClass(CustomEvent.class)}, new KSerializer[]{ApiUsageEvent$$serializer.INSTANCE, AppLifeCycleEvent$$serializer.INSTANCE, CustomEvent$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    InterfaceC2421a mo839a(@NotNull InterfaceC2421a interfaceC2421a);

    /* JADX INFO: renamed from: a */
    void mo840a(@NotNull JSONObject jSONObject);

    @NotNull
    String getKey();
}

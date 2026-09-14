package com.contentsquare.android.internal.core.logmonitor.processing;

import com.google.firebase.messaging.Constants;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.internal.core.logmonitor.processing.a */
/* JADX INFO: loaded from: classes2.dex */
@Serializable
public enum EnumC2412a {
    WARN,
    ERROR,
    CRITICAL;


    @NotNull
    public static final b Companion = new b();

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Lazy<KSerializer<Object>> f1254a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.contentsquare.android.internal.core.logmonitor.processing.a.a
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return EnumsKt.createAnnotatedEnumSerializer("com.contentsquare.android.internal.core.logmonitor.processing.LogLevel", EnumC2412a.values(), new String[]{"warn", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "critical"}, new Annotation[][]{null, null, null}, null);
        }
    });

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.logmonitor.processing.a$b */
    public static final class b {
        @NotNull
        public final KSerializer<EnumC2412a> serializer() {
            return (KSerializer) EnumC2412a.f1254a.getValue();
        }
    }
}

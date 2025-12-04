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

@Serializable
/* loaded from: classes2.dex */
public enum a {
    WARN,
    ERROR,
    CRITICAL;


    @NotNull
    public static final b Companion = new b();

    @NotNull
    public static final Lazy<KSerializer<Object>> a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.contentsquare.android.internal.core.logmonitor.processing.a.a
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return EnumsKt.createAnnotatedEnumSerializer("com.contentsquare.android.internal.core.logmonitor.processing.LogLevel", a.values(), new String[]{"warn", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "critical"}, new Annotation[][]{null, null, null}, null);
        }
    });

    public static final class b {
        @NotNull
        public final KSerializer<a> serializer() {
            return (KSerializer) a.a.getValue();
        }
    }
}

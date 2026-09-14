package com.contentsquare.android.internal.core.logmonitor.processing;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Serializable
public final class LogXpf {

    @NotNull
    public static final C2411a Companion = new C2411a();

    /* JADX INFO: renamed from: a */
    @Nullable
    public final String f1250a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final String f1251b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final String f1252c;

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.logmonitor.processing.LogXpf$a */
    public static final class C2411a {
        @NotNull
        public final KSerializer<LogXpf> serializer() {
            return LogXpf$$serializer.INSTANCE;
        }
    }

    public LogXpf() {
        this.f1250a = null;
        this.f1251b = null;
        this.f1252c = null;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public LogXpf(int i, String str, String str2, @SerialName("bridge_version") String str3) {
        if ((i & 1) == 0) {
            this.f1250a = null;
        } else {
            this.f1250a = str;
        }
        if ((i & 2) == 0) {
            this.f1251b = null;
        } else {
            this.f1251b = str2;
        }
        if ((i & 4) == 0) {
            this.f1252c = null;
        } else {
            this.f1252c = str3;
        }
    }

    public LogXpf(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.f1250a = str;
        this.f1251b = str2;
        this.f1252c = str3;
    }
}

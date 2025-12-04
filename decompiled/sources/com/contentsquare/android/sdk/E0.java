package com.contentsquare.android.sdk;

import android.os.Process;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nCpuCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpuCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/CpuCollector\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,127:1\n37#2,2:128\n*S KotlinDebug\n*F\n+ 1 CpuCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/CpuCollector\n*L\n118#1:128,2\n*E\n"})
/* loaded from: classes2.dex */
public final class E0 implements Q3<Float> {

    @NotNull
    public static final String g = "/proc/" + Process.myPid() + "/stat";

    @NotNull
    public final String a;
    public float b;
    public float c;

    @NotNull
    public final Lazy d;

    @NotNull
    public final Lazy e;

    @NotNull
    public final Flow<Float> f;

    public E0() {
        String statFilePath = g;
        Intrinsics.checkNotNullParameter(statFilePath, "statFilePath");
        this.a = statFilePath;
        this.b = -1.0f;
        this.c = -1.0f;
        this.d = LazyKt.lazy(D0.a);
        this.e = LazyKt.lazy(B0.a);
        this.f = FlowKt.flow(new C0(this, null));
    }

    @Override // com.contentsquare.android.sdk.Q3
    @NotNull
    public final Flow<Float> a() {
        return this.f;
    }

    @Override // com.contentsquare.android.sdk.Q3
    @NotNull
    public final String getName() {
        return "cpu";
    }
}

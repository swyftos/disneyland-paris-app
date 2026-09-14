package com.contentsquare.android.sdk;

import android.os.Process;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.E0 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nCpuCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpuCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/CpuCollector\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,127:1\n37#2,2:128\n*S KotlinDebug\n*F\n+ 1 CpuCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/CpuCollector\n*L\n118#1:128,2\n*E\n"})
public final class C2477E0 implements InterfaceC2600Q3<Float> {

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final String f1532g = "/proc/" + Process.myPid() + "/stat";

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f1533a;

    /* JADX INFO: renamed from: b */
    public float f1534b;

    /* JADX INFO: renamed from: c */
    public float f1535c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Lazy f1536d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final Lazy f1537e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final Flow<Float> f1538f;

    public C2477E0() {
        String statFilePath = f1532g;
        Intrinsics.checkNotNullParameter(statFilePath, "statFilePath");
        this.f1533a = statFilePath;
        this.f1534b = -1.0f;
        this.f1535c = -1.0f;
        this.f1536d = LazyKt.lazy(C2467D0.f1508a);
        this.f1537e = LazyKt.lazy(C2447B0.f1434a);
        this.f1538f = FlowKt.flow(new C2457C0(this, null));
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2600Q3
    @NotNull
    /* JADX INFO: renamed from: a */
    public final Flow<Float> mo900a() {
        return this.f1538f;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2600Q3
    @NotNull
    public final String getName() {
        return "cpu";
    }
}

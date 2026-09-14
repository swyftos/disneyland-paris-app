package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowCollector;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.C0 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.performance.CpuCollector$dataFlow$1", m1845f = "CpuCollector.kt", m1846i = {0, 1}, m1847l = {68, EACTags.DISPLAY_IMAGE}, m1848m = "invokeSuspend", m1849n = {"$this$flow", "$this$flow"}, m1850s = {"L$0", "L$0"})
@SourceDebugExtension({"SMAP\nCpuCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpuCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/CpuCollector$dataFlow$1\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,127:1\n329#2:128\n*S KotlinDebug\n*F\n+ 1 CpuCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/CpuCollector$dataFlow$1\n*L\n67#1:128\n*E\n"})
public final class C2457C0 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public int f1453a;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ Object f1454b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C2477E0 f1455c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2457C0(C2477E0 c2477e0, Continuation<? super C2457C0> continuation) {
        super(2, continuation);
        this.f1455c = c2477e0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C2457C0 c2457c0 = new C2457C0(this.f1455c, continuation);
        c2457c0.f1454b = obj;
        return c2457c0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        C2457C0 c2457c0 = new C2457C0(this.f1455c, continuation);
        c2457c0.f1454b = flowCollector;
        return c2457c0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0046 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0063 A[Catch: all -> 0x007f, TryCatch #2 {all -> 0x007f, blocks: (B:19:0x005d, B:21:0x0063, B:23:0x0069, B:26:0x0082), top: B:51:0x005d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:41:0x012d  */
    /* JADX WARN: Code duplicated, block: B:44:0x013d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x013e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x013e -> B:12:0x0030). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C2457C0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

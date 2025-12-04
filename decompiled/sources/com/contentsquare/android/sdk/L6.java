package com.contentsquare.android.sdk;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.internal.features.srm.StaticResourceManager$processResources$1", f = "StaticResourceManager.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nStaticResourceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaticResourceManager.kt\ncom/contentsquare/android/internal/features/srm/StaticResourceManager$processResources$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,133:1\n1549#2:134\n1620#2,3:135\n766#2:138\n857#2,2:139\n*S KotlinDebug\n*F\n+ 1 StaticResourceManager.kt\ncom/contentsquare/android/internal/features/srm/StaticResourceManager$processResources$1\n*L\n65#1:134\n65#1:135,3\n81#1:138\n81#1:139,2\n*E\n"})
/* loaded from: classes2.dex */
public final class L6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ M6 b;
    public final /* synthetic */ List<G6> c;
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L6(M6 m6, List<G6> list, int i, Continuation<? super L6> continuation) {
        super(2, continuation);
        this.b = m6;
        this.c = list;
        this.d = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new L6(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((L6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0118  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.L6.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

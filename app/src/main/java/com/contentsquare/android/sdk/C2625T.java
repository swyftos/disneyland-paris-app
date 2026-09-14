package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.T */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.internal.features.sessionreplay.processing.batch.BatchStorageProcessor$getBatchesFromStorage$1", m1845f = "BatchStorageProcessor.kt", m1846i = {0}, m1847l = {41}, m1848m = "invokeSuspend", m1849n = {"$this$sequence"}, m1850s = {"L$0"})
@SourceDebugExtension({"SMAP\nBatchStorageProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BatchStorageProcessor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/batch/BatchStorageProcessor$getBatchesFromStorage$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,55:1\n1855#2,2:56\n*S KotlinDebug\n*F\n+ 1 BatchStorageProcessor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/batch/BatchStorageProcessor$getBatchesFromStorage$1\n*L\n36#1:56,2\n*E\n"})
public final class C2625T extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Pair<? extends Long, ? extends C2632T6>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public C2635U f2131a;

    /* JADX INFO: renamed from: b */
    public Iterator f2132b;

    /* JADX INFO: renamed from: c */
    public int f2133c;

    /* JADX INFO: renamed from: d */
    public /* synthetic */ Object f2134d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C2635U f2135e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2625T(C2635U c2635u, Continuation<? super C2625T> continuation) {
        super(2, continuation);
        this.f2135e = c2635u;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C2625T c2625t = new C2625T(this.f2135e, continuation);
        c2625t.f2134d = obj;
        return c2625t;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Pair<? extends Long, ? extends C2632T6>> sequenceScope, Continuation<? super Unit> continuation) {
        C2625T c2625t = new C2625T(this.f2135e, continuation);
        c2625t.f2134d = sequenceScope;
        return c2625t.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        SequenceScope sequenceScope;
        C2635U c2635u;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2133c;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.f2134d;
            C2645V c2645v = this.f2135e.f2166a;
            c2645v.getClass();
            ArrayList arrayList = new ArrayList();
            String[] strArrListFolder = c2645v.f2185a.listFolder(c2645v.f2189e);
            if (strArrListFolder == null) {
                c2645v.f2187c.m834w("error while listing folder, returning an empty array.");
            } else {
                Iterator it2 = ArrayIteratorKt.iterator(strArrListFolder);
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    try {
                        arrayList.add(Long.valueOf(Long.parseLong(str)));
                    } catch (NumberFormatException e) {
                        C2599Q2.m1011a(c2645v.f2187c, "Failed to parse the file name " + str + " to Long", e);
                    }
                }
                CollectionsKt.sort(arrayList);
            }
            c2635u = this.f2135e;
            it = arrayList.iterator();
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = this.f2132b;
            c2635u = this.f2131a;
            sequenceScope = (SequenceScope) this.f2134d;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            C2645V c2645v2 = c2635u.f2166a;
            c2645v2.f2187c.m827d("Retrieving file content for id " + jLongValue);
            byte[] bytes = c2645v2.f2185a.readFileContentAsBytes(c2645v2.f2189e + File.separator + jLongValue);
            Logger logger = C2632T6.f2153c;
            C2632T6 c2632t6 = null;
            if (bytes != null) {
                if (bytes.length <= 4) {
                    C2632T6.f2153c.m829e("couldn't transform bytes because data is too small");
                } else {
                    int iM1036a = C2632T6.a.m1036a(bytes, 0);
                    if (iM1036a == 1) {
                        try {
                            int iM1036a2 = C2632T6.a.m1036a(bytes, 4);
                            String strM1037b = C2632T6.a.m1037b(bytes, iM1036a2);
                            int iM1036a3 = C2632T6.a.m1036a(bytes, iM1036a2 + 8);
                            Intrinsics.checkNotNullParameter(bytes, "bytes");
                            byte[] bArr = new byte[iM1036a3];
                            System.arraycopy(bytes, iM1036a2 + 12, bArr, 0, iM1036a3);
                            c2632t6 = new C2632T6(strM1037b, bArr);
                        } catch (Exception e2) {
                            C2599Q2.m1011a(C2632T6.f2153c, "couldn't transform bytes because of an unexpected error", e2);
                        }
                    } else {
                        C2632T6.f2153c.m829e("couldn't transform bytes because version " + iM1036a + " is unknown");
                    }
                }
            }
            if (c2632t6 == null) {
                c2635u.m1039a(jLongValue);
            } else {
                Pair pair = new Pair(Boxing.boxLong(jLongValue), c2632t6);
                this.f2134d = sequenceScope;
                this.f2131a = c2635u;
                this.f2132b = it;
                this.f2133c = 1;
                if (sequenceScope.yield(pair, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}

package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.T6;
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

@DebugMetadata(c = "com.contentsquare.android.internal.features.sessionreplay.processing.batch.BatchStorageProcessor$getBatchesFromStorage$1", f = "BatchStorageProcessor.kt", i = {0}, l = {41}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nBatchStorageProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BatchStorageProcessor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/batch/BatchStorageProcessor$getBatchesFromStorage$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,55:1\n1855#2,2:56\n*S KotlinDebug\n*F\n+ 1 BatchStorageProcessor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/batch/BatchStorageProcessor$getBatchesFromStorage$1\n*L\n36#1:56,2\n*E\n"})
/* loaded from: classes2.dex */
public final class T extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Pair<? extends Long, ? extends T6>>, Continuation<? super Unit>, Object> {
    public U a;
    public Iterator b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ U e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(U u, Continuation<? super T> continuation) {
        super(2, continuation);
        this.e = u;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        T t = new T(this.e, continuation);
        t.d = obj;
        return t;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Pair<? extends Long, ? extends T6>> sequenceScope, Continuation<? super Unit> continuation) {
        T t = new T(this.e, continuation);
        t.d = sequenceScope;
        return t.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        SequenceScope sequenceScope;
        U u;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.c;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.d;
            V v = this.e.a;
            v.getClass();
            ArrayList arrayList = new ArrayList();
            String[] strArrListFolder = v.a.listFolder(v.e);
            if (strArrListFolder == null) {
                v.c.w("error while listing folder, returning an empty array.");
            } else {
                Iterator it2 = ArrayIteratorKt.iterator(strArrListFolder);
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    try {
                        arrayList.add(Long.valueOf(Long.parseLong(str)));
                    } catch (NumberFormatException e) {
                        Q2.a(v.c, "Failed to parse the file name " + str + " to Long", e);
                    }
                }
                CollectionsKt.sort(arrayList);
            }
            u = this.e;
            it = arrayList.iterator();
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = this.b;
            u = this.a;
            sequenceScope = (SequenceScope) this.d;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            V v2 = u.a;
            v2.c.d("Retrieving file content for id " + jLongValue);
            byte[] bytes = v2.a.readFileContentAsBytes(v2.e + File.separator + jLongValue);
            Logger logger = T6.c;
            T6 t6 = null;
            if (bytes != null) {
                if (bytes.length <= 4) {
                    T6.c.e("couldn't transform bytes because data is too small");
                } else {
                    int iA = T6.a.a(bytes, 0);
                    if (iA == 1) {
                        try {
                            int iA2 = T6.a.a(bytes, 4);
                            String strB = T6.a.b(bytes, iA2);
                            int iA3 = T6.a.a(bytes, iA2 + 8);
                            Intrinsics.checkNotNullParameter(bytes, "bytes");
                            byte[] bArr = new byte[iA3];
                            System.arraycopy(bytes, iA2 + 12, bArr, 0, iA3);
                            t6 = new T6(strB, bArr);
                        } catch (Exception e2) {
                            Q2.a(T6.c, "couldn't transform bytes because of an unexpected error", e2);
                        }
                    } else {
                        T6.c.e("couldn't transform bytes because version " + iA + " is unknown");
                    }
                }
            }
            if (t6 == null) {
                u.a(jLongValue);
            } else {
                Pair pair = new Pair(Boxing.boxLong(jLongValue), t6);
                this.d = sequenceScope;
                this.a = u;
                this.b = it;
                this.c = 1;
                if (sequenceScope.yield(pair, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}

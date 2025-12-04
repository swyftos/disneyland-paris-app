package com.contentsquare.android.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSnapshotPausingController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotPausingController.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/SnapshotPausingController\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,68:1\n120#2,10:69\n*S KotlinDebug\n*F\n+ 1 SnapshotPausingController.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/SnapshotPausingController\n*L\n65#1:69,10\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.e6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0667e6 {

    @NotNull
    public final Mutex a = MutexKt.Mutex(false);

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.SnapshotPausingController", f = "SnapshotPausingController.kt", i = {0}, l = {EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY}, m = "waitIfPaused", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    /* renamed from: com.contentsquare.android.sdk.e6$a */
    public static final class a extends ContinuationImpl {
        public Mutex a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return C0667e6.this.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.contentsquare.android.sdk.C0667e6.a
            if (r0 == 0) goto L13
            r0 = r7
            com.contentsquare.android.sdk.e6$a r0 = (com.contentsquare.android.sdk.C0667e6.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.e6$a r0 = new com.contentsquare.android.sdk.e6$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlinx.coroutines.sync.Mutex r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.a
            boolean r7 = r7.isLocked()
            if (r7 == 0) goto L5a
            r6.invoke()
            kotlinx.coroutines.sync.Mutex r5 = r5.a
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = r5.lock(r4, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L55
            r5.unlock(r4)
            return r6
        L55:
            r6 = move-exception
            r5.unlock(r4)
            throw r6
        L5a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0667e6.a(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

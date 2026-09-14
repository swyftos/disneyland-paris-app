package com.contentsquare.android.sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.e6 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSnapshotPausingController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotPausingController.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/SnapshotPausingController\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,68:1\n120#2,10:69\n*S KotlinDebug\n*F\n+ 1 SnapshotPausingController.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/SnapshotPausingController\n*L\n65#1:69,10\n*E\n"})
public final class C2737e6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Mutex f2579a = MutexKt.Mutex(false);

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.e6$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.SnapshotPausingController", m1845f = "SnapshotPausingController.kt", m1846i = {0}, m1847l = {EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY}, m1848m = "waitIfPaused", m1849n = {"$this$withLock_u24default$iv"}, m1850s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public Mutex f2580a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ Object f2581b;

        /* JADX INFO: renamed from: d */
        public int f2583d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2581b = obj;
            this.f2583d |= Integer.MIN_VALUE;
            return C2737e6.this.m1123a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m1123a(@NotNull Function0<Unit> function0, @NotNull Continuation<? super Unit> continuation) {
        a aVar;
        Mutex mutex;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f2583d;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f2583d = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.f2581b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f2583d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.f2579a.isLocked()) {
                return Unit.INSTANCE;
            }
            function0.invoke();
            mutex = this.f2579a;
            aVar.f2580a = mutex;
            aVar.f2583d = 1;
            if (mutex.lock(null, aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = aVar.f2580a;
            ResultKt.throwOnFailure(obj);
        }
        try {
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }
}

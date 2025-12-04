package com.contentsquare.android.sdk;

import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class C4 {

    public static final class a {

        @NotNull
        public final WeakReference<RecyclerView> a;

        @Nullable
        public final Parcelable b;

        public a(@NotNull WeakReference<RecyclerView> recyclerViewRef, @Nullable Parcelable parcelable) {
            Intrinsics.checkNotNullParameter(recyclerViewRef, "recyclerViewRef");
            this.a = recyclerViewRef;
            this.b = parcelable;
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RecyclerViewScroller", f = "RecyclerViewScroller.kt", i = {0}, l = {36, 38}, m = "scrollByAndWait", n = {"delayAfterScrollMilliseconds"}, s = {"I$0"})
    public static final class b extends ContinuationImpl {
        public int a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return C4.this.a(null, 0, 0, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r5, int r6, int r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.contentsquare.android.sdk.C4.b
            if (r0 == 0) goto L13
            r0 = r8
            com.contentsquare.android.sdk.C4$b r0 = (com.contentsquare.android.sdk.C4.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.C4$b r0 = new com.contentsquare.android.sdk.C4$b
            r0.<init>(r8)
        L18:
            java.lang.Object r4 = r0.b
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2c
            kotlin.ResultKt.throwOnFailure(r4)
            goto L62
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            int r7 = r0.a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L4f
        L3a:
            kotlin.ResultKt.throwOnFailure(r4)
            r4 = 0
            r5.scrollBy(r4, r6)
            r5.requestLayout()
            r0.a = r7
            r0.d = r3
            java.lang.Object r4 = com.contentsquare.android.sdk.C0759n8.a(r5, r0)
            if (r4 != r8) goto L4f
            return r8
        L4f:
            if (r7 <= 0) goto L65
            kotlin.time.Duration$Companion r4 = kotlin.time.Duration.INSTANCE
            kotlin.time.DurationUnit r4 = kotlin.time.DurationUnit.MILLISECONDS
            long r4 = kotlin.time.DurationKt.toDuration(r7, r4)
            r0.d = r2
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.m3608delayVtjQ1oo(r4, r0)
            if (r4 != r8) goto L62
            return r8
        L62:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L65:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C4.a(androidx.recyclerview.widget.RecyclerView, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r5, int r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.contentsquare.android.sdk.D4
            if (r0 == 0) goto L13
            r0 = r7
            com.contentsquare.android.sdk.D4 r0 = (com.contentsquare.android.sdk.D4) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.D4 r0 = new com.contentsquare.android.sdk.D4
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r4 = r0.b
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2c
            kotlin.ResultKt.throwOnFailure(r4)
            goto L5f
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            int r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L4c
        L3a:
            kotlin.ResultKt.throwOnFailure(r4)
            r4 = 0
            r5.scrollToPosition(r4)
            r0.a = r6
            r0.d = r3
            java.lang.Object r4 = com.contentsquare.android.sdk.C0759n8.a(r5, r0)
            if (r4 != r7) goto L4c
            return r7
        L4c:
            if (r6 <= 0) goto L62
            kotlin.time.Duration$Companion r4 = kotlin.time.Duration.INSTANCE
            kotlin.time.DurationUnit r4 = kotlin.time.DurationUnit.MILLISECONDS
            long r4 = kotlin.time.DurationKt.toDuration(r6, r4)
            r0.d = r2
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.m3608delayVtjQ1oo(r4, r0)
            if (r4 != r7) goto L5f
            return r7
        L5f:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L62:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C4.a(androidx.recyclerview.widget.RecyclerView, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

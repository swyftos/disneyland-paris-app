package com.contentsquare.android.sdk;

import android.view.ViewGroup;
import com.contentsquare.android.api.model.CustomVar;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class X4 {

    @NotNull
    public final K1 a;

    @NotNull
    public final MutableStateFlow<Z4> b;

    @NotNull
    public final H7 c;

    @NotNull
    public final C0669e8 d;

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.ScreenGraphProducer", f = "ScreenGraphProducer.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {43}, m = "obtain", n = {"this", "rootView", "url", "screenName", "customVars", "screenGraphCallbackListener", "composeScreenGraphGenerator"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
    public static final class a extends ContinuationImpl {
        public X4 a;
        public ViewGroup b;
        public String c;
        public String d;
        public CustomVar[] e;
        public N0 f;
        public Function2 g;
        public /* synthetic */ Object h;
        public int j;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return X4.this.a(null, null, null, null, null, null, this);
        }
    }

    public X4(@NotNull K1 externalViewsProcessor, @NotNull MutableStateFlow<Z4> snapshotStateFlow, @NotNull H7 treeTraverser, @NotNull C0669e8 viewBitmapProviderFactory) {
        Intrinsics.checkNotNullParameter(externalViewsProcessor, "externalViewsProcessor");
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(treeTraverser, "treeTraverser");
        Intrinsics.checkNotNullParameter(viewBitmapProviderFactory, "viewBitmapProviderFactory");
        this.a = externalViewsProcessor;
        this.b = snapshotStateFlow;
        this.c = treeTraverser;
        this.d = viewBitmapProviderFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull android.view.ViewGroup r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull com.contentsquare.android.api.model.CustomVar[] r12, @org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.N0 r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super android.view.View, ? super com.contentsquare.android.sdk.InterfaceC0679f8, ? extends com.contentsquare.android.sdk.AbstractC0645c4> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r8 = this;
            boolean r0 = r15 instanceof com.contentsquare.android.sdk.X4.a
            if (r0 == 0) goto L13
            r0 = r15
            com.contentsquare.android.sdk.X4$a r0 = (com.contentsquare.android.sdk.X4.a) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.X4$a r0 = new com.contentsquare.android.sdk.X4$a
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.j
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            kotlin.jvm.functions.Function2 r14 = r0.g
            com.contentsquare.android.sdk.N0 r13 = r0.f
            com.contentsquare.android.api.model.CustomVar[] r12 = r0.e
            java.lang.String r11 = r0.d
            java.lang.String r10 = r0.c
            android.view.ViewGroup r9 = r0.b
            com.contentsquare.android.sdk.X4 r8 = r0.a
            kotlin.ResultKt.throwOnFailure(r15)
        L36:
            r1 = r9
            r2 = r12
            r6 = r14
            goto L6a
        L3a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L42:
            kotlin.ResultKt.throwOnFailure(r15)
            com.contentsquare.android.sdk.e8 r15 = r8.d
            com.contentsquare.android.sdk.h8 r2 = new com.contentsquare.android.sdk.h8
            com.contentsquare.android.sdk.S3 r4 = new com.contentsquare.android.sdk.S3
            r4.<init>()
            com.contentsquare.android.sdk.M2 r15 = r15.a
            r2.<init>(r4, r15)
            r0.a = r8
            r0.b = r9
            r0.c = r10
            r0.d = r11
            r0.e = r12
            r0.f = r13
            r0.g = r14
            r0.j = r3
            java.lang.Object r15 = r2.a(r0)
            if (r15 != r1) goto L36
            return r1
        L6a:
            r9 = r15
            com.contentsquare.android.sdk.f8 r9 = (com.contentsquare.android.sdk.InterfaceC0679f8) r9
            java.lang.String r12 = r9.a(r1)
            kotlinx.coroutines.flow.MutableStateFlow<com.contentsquare.android.sdk.Z4> r14 = r8.b
            com.contentsquare.android.sdk.Z4$f r15 = com.contentsquare.android.sdk.Z4.f.a
            r14.tryEmit(r15)
            com.contentsquare.android.sdk.H7 r0 = r8.c
            com.contentsquare.android.sdk.K1 r3 = r8.a
            com.contentsquare.android.sdk.W4 r5 = new com.contentsquare.android.sdk.W4
            boolean r14 = r9.a()
            r5.<init>(r1, r14)
            com.contentsquare.android.sdk.I7$b r7 = com.contentsquare.android.sdk.I7.a
            r4 = r9
            com.contentsquare.android.sdk.U4 r3 = r0.a(r1, r2, r3, r4, r5, r6, r7)
            r3.a = r10
            java.lang.String r10 = "<set-?>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r10)
            r3.b = r11
            com.contentsquare.android.sdk.K1 r10 = r8.a
            boolean r10 = r10.b()
            if (r10 == 0) goto La8
            com.contentsquare.android.sdk.K1 r2 = r8.a
            kotlinx.coroutines.flow.MutableStateFlow<com.contentsquare.android.sdk.Z4> r7 = r8.b
            r4 = r12
            r5 = r9
            r6 = r13
            r2.a(r3, r4, r5, r6, r7)
            goto Lb6
        La8:
            kotlinx.coroutines.flow.MutableStateFlow<com.contentsquare.android.sdk.Z4> r8 = r8.b
            com.contentsquare.android.sdk.Z4$g r10 = com.contentsquare.android.sdk.Z4.g.a
            r8.tryEmit(r10)
            boolean r8 = r9.a()
            r13.a(r3, r12, r8)
        Lb6:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.X4.a(android.view.ViewGroup, java.lang.String, java.lang.String, com.contentsquare.android.api.model.CustomVar[], com.contentsquare.android.sdk.N0, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

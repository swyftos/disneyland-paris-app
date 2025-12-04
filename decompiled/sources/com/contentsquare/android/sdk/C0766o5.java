package com.contentsquare.android.sdk;

import android.graphics.Point;
import com.contentsquare.android.sdk.AbstractC0844w5;
import com.contentsquare.android.sdk.C0828u8;
import com.contentsquare.android.sdk.C0865z;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.o5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0766o5 {

    @NotNull
    public final C0659d8 a;

    @NotNull
    public final C0828u8 b;

    @NotNull
    public final Y2 c;

    @NotNull
    public final C0865z d;

    @Nullable
    public d e;

    @Nullable
    public C0865z.a f;

    @Nullable
    public C0828u8.a g;

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.ScrollViewCaptureUseCase", f = "ScrollViewCaptureUseCase.kt", i = {0, 0, 0, 0, 0, 0}, l = {185, 196}, m = "onScrollCalculated", n = {"this", "config", "snapshotId", "coordinates", "snapshotIndex", "numberOfSnapshots"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"})
    /* renamed from: com.contentsquare.android.sdk.o5$a */
    public static final class a extends ContinuationImpl {
        public C0766o5 a;
        public AbstractC0844w5 b;
        public String c;
        public Point d;
        public int e;
        public int f;
        public /* synthetic */ Object g;
        public int i;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return C0766o5.this.a(null, null, null, 0, 0, this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.ScrollViewCaptureUseCase", f = "ScrollViewCaptureUseCase.kt", i = {0}, l = {56}, m = "restoreInitialScrollState", n = {"this"}, s = {"L$0"})
    /* renamed from: com.contentsquare.android.sdk.o5$b */
    public static final class b extends ContinuationImpl {
        public C0766o5 a;
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
            return C0766o5.this.a(this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.ScrollViewCaptureUseCase", f = "ScrollViewCaptureUseCase.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, l = {144, 163, 166}, m = "scrollView", n = {"this", "snapshotId", "snapshotConfig", "$this$scrollView_u24lambda_u241", "numberOfSnapshots", "scrollContainerLength", "singleTargetCoordinate", "page", "this", "throwable"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "L$0", "L$2"})
    /* renamed from: com.contentsquare.android.sdk.o5$c */
    public static final class c extends ContinuationImpl {
        public C0766o5 a;
        public Object b;
        public Object c;
        public C0766o5 d;
        public int e;
        public int f;
        public int g;
        public int h;
        public /* synthetic */ Object i;
        public int k;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.i = obj;
            this.k |= Integer.MIN_VALUE;
            return C0766o5.this.a(0, 0, 0, 0, null, null, this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.ScrollViewCaptureUseCase$scrollView$2$1", f = "ScrollViewCaptureUseCase.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.sdk.o5$d */
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ String g;
        public final /* synthetic */ AbstractC0844w5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, int i2, int i3, int i4, String str, AbstractC0844w5 abstractC0844w5, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = str;
            this.h = abstractC0844w5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return C0766o5.this.new d(this.c, this.d, this.e, this.f, this.g, this.h, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0766o5 c0766o5 = C0766o5.this;
                int i2 = this.c + 1;
                int i3 = this.d;
                int i4 = this.e;
                int i5 = this.f;
                String str = this.g;
                AbstractC0844w5 abstractC0844w5 = this.h;
                this.a = 1;
                if (c0766o5.a(i2, i3, i4, i5, str, abstractC0844w5, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public C0766o5(C0659d8 verticalScrollViewScreenRecorder, C0828u8 viewScroller, Y2 pauseStateSetter) {
        C0865z appBarHandler = new C0865z();
        Intrinsics.checkNotNullParameter(verticalScrollViewScreenRecorder, "verticalScrollViewScreenRecorder");
        Intrinsics.checkNotNullParameter(viewScroller, "viewScroller");
        Intrinsics.checkNotNullParameter(pauseStateSetter, "pauseStateSetter");
        Intrinsics.checkNotNullParameter(appBarHandler, "appBarHandler");
        this.a = verticalScrollViewScreenRecorder;
        this.b = viewScroller;
        this.c = pauseStateSetter;
        this.d = appBarHandler;
    }

    public static final Object a(C0766o5 c0766o5, Point point, AbstractC0844w5 abstractC0844w5, Continuation continuation) {
        int height;
        int i;
        boolean z = abstractC0844w5 instanceof AbstractC0844w5.a;
        if (z) {
            height = ((AbstractC0844w5.a) abstractC0844w5).a.getWidth();
        } else {
            if (!(abstractC0844w5 instanceof AbstractC0844w5.b ? true : abstractC0844w5 instanceof AbstractC0844w5.c)) {
                throw new NoWhenBranchMatchedException();
            }
            height = abstractC0844w5.a().getHeight();
        }
        int i2 = height;
        if (z) {
            i = point.x;
        } else {
            if (!(abstractC0844w5 instanceof AbstractC0844w5.b ? true : abstractC0844w5 instanceof AbstractC0844w5.c)) {
                throw new NoWhenBranchMatchedException();
            }
            i = point.y;
        }
        int i3 = i;
        float f = i2;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        Object objA = c0766o5.a(0, (int) Math.ceil((i3 + f) / f), i2, i3, string, abstractC0844w5, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.contentsquare.android.sdk.AbstractC0844w5 r15, java.lang.String r16, android.graphics.Point r17, int r18, int r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r14 = this;
            r0 = r14
            r1 = r17
            r2 = r20
            boolean r3 = r2 instanceof com.contentsquare.android.sdk.C0766o5.a
            if (r3 == 0) goto L18
            r3 = r2
            com.contentsquare.android.sdk.o5$a r3 = (com.contentsquare.android.sdk.C0766o5.a) r3
            int r4 = r3.i
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L18
            int r4 = r4 - r5
            r3.i = r4
            goto L1d
        L18:
            com.contentsquare.android.sdk.o5$a r3 = new com.contentsquare.android.sdk.o5$a
            r3.<init>(r2)
        L1d:
            java.lang.Object r2 = r3.g
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.i
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L4f
            if (r5 == r7) goto L3a
            if (r5 != r6) goto L32
            kotlin.ResultKt.throwOnFailure(r2)
            goto Lb9
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            int r0 = r3.f
            int r1 = r3.e
            android.graphics.Point r5 = r3.d
            java.lang.String r7 = r3.c
            com.contentsquare.android.sdk.w5 r8 = r3.b
            com.contentsquare.android.sdk.o5 r9 = r3.a
            kotlin.ResultKt.throwOnFailure(r2)
            r13 = r0
            r12 = r1
            r1 = r5
            r11 = r7
            r10 = r8
            goto L88
        L4f:
            kotlin.ResultKt.throwOnFailure(r2)
            com.contentsquare.android.sdk.u8 r2 = r0.b
            android.view.View r5 = r15.a()
            int r8 = r1.x
            int r9 = r1.y
            r3.a = r0
            r10 = r15
            r3.b = r10
            r11 = r16
            r3.c = r11
            r3.d = r1
            r12 = r18
            r3.e = r12
            r13 = r19
            r3.f = r13
            r3.i = r7
            r2.getClass()
            r5.scrollTo(r8, r9)
            java.lang.Object r2 = com.contentsquare.android.sdk.C0759n8.a(r5, r3)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r2 != r5) goto L82
            goto L84
        L82:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L84:
            if (r2 != r4) goto L87
            return r4
        L87:
            r9 = r0
        L88:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.view.View r2 = r10.a()
            r2.getGlobalVisibleRect(r0)
            com.contentsquare.android.sdk.d6$e r2 = new com.contentsquare.android.sdk.d6$e
            r14 = r2
            r15 = r11
            r16 = r1
            r17 = r0
            r18 = r12
            r19 = r13
            r20 = r10
            r14.<init>(r15, r16, r17, r18, r19, r20)
            com.contentsquare.android.sdk.d8 r0 = r9.a
            r1 = 0
            r3.a = r1
            r3.b = r1
            r3.c = r1
            r3.d = r1
            r3.i = r6
            java.lang.Object r0 = r0.a(r2, r3)
            if (r0 != r4) goto Lb9
            return r4
        Lb9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0766o5.a(com.contentsquare.android.sdk.w5, java.lang.String, android.graphics.Point, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.contentsquare.android.sdk.C0766o5.b
            if (r0 == 0) goto L13
            r0 = r12
            com.contentsquare.android.sdk.o5$b r0 = (com.contentsquare.android.sdk.C0766o5.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.o5$b r0 = new com.contentsquare.android.sdk.o5$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            com.contentsquare.android.sdk.o5 r11 = r0.a
            kotlin.ResultKt.throwOnFailure(r12)
            goto L7d
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L34:
            kotlin.ResultKt.throwOnFailure(r12)
            com.contentsquare.android.sdk.z r8 = r11.d
            com.contentsquare.android.sdk.z$a r7 = r11.f
            r0.a = r11
            r0.d = r3
            r8.getClass()
            if (r7 == 0) goto L50
            java.lang.ref.WeakReference<android.view.View> r12 = r7.a
            if (r12 == 0) goto L50
            java.lang.Object r12 = r12.get()
            android.view.View r12 = (android.view.View) r12
            r9 = r12
            goto L51
        L50:
            r9 = r4
        L51:
            if (r7 == 0) goto L5f
            java.lang.ref.WeakReference<android.view.View> r12 = r7.b
            if (r12 == 0) goto L5f
            java.lang.Object r12 = r12.get()
            android.view.View r12 = (android.view.View) r12
            r6 = r12
            goto L60
        L5f:
            r6 = r4
        L60:
            if (r9 == 0) goto L78
            if (r6 == 0) goto L78
            kotlinx.coroutines.CoroutineDispatcher r12 = r8.a
            com.contentsquare.android.sdk.B r2 = new com.contentsquare.android.sdk.B
            r10 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r12, r2, r0)
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r12 != r0) goto L78
            goto L7a
        L78:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
        L7a:
            if (r12 != r1) goto L7d
            return r1
        L7d:
            r11.f = r4
            com.contentsquare.android.sdk.u8 r12 = r11.b
            com.contentsquare.android.sdk.u8$a r0 = r11.g
            r12.getClass()
            if (r0 == 0) goto L8b
            android.graphics.Point r12 = r0.b
            goto L8c
        L8b:
            r12 = r4
        L8c:
            if (r12 == 0) goto La1
            java.lang.ref.WeakReference<android.view.View> r12 = r0.a
            java.lang.Object r12 = r12.get()
            android.view.View r12 = (android.view.View) r12
            if (r12 == 0) goto La1
            android.graphics.Point r0 = r0.b
            int r1 = r0.x
            int r0 = r0.y
            r12.scrollTo(r1, r0)
        La1:
            r11.g = r4
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0766o5.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f1 A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0101 A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0118 A[Catch: all -> 0x00ff, TRY_LEAVE, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0158 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00db -> B:73:0x00e7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(int r24, int r25, int r26, int r27, java.lang.String r28, com.contentsquare.android.sdk.AbstractC0844w5 r29, kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0766o5.a(int, int, int, int, java.lang.String, com.contentsquare.android.sdk.w5, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

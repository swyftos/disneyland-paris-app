package com.contentsquare.android.sdk;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import java.lang.ref.WeakReference;
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
import kotlinx.coroutines.BuildersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.o5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2836o5 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2729d8 f2939a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2899u8 f2940b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2675Y2 f2941c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2940z f2942d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public d f2943e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public C2940z.a f2944f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public C2899u8.a f2945g;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.o5$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.ScrollViewCaptureUseCase", m1845f = "ScrollViewCaptureUseCase.kt", m1846i = {0, 0, 0, 0, 0, 0}, m1847l = {185, 196}, m1848m = "onScrollCalculated", m1849n = {"this", "config", "snapshotId", "coordinates", "snapshotIndex", "numberOfSnapshots"}, m1850s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2836o5 f2946a;

        /* JADX INFO: renamed from: b */
        public AbstractC2916w5 f2947b;

        /* JADX INFO: renamed from: c */
        public String f2948c;

        /* JADX INFO: renamed from: d */
        public Point f2949d;

        /* JADX INFO: renamed from: e */
        public int f2950e;

        /* JADX INFO: renamed from: f */
        public int f2951f;

        /* JADX INFO: renamed from: g */
        public /* synthetic */ Object f2952g;

        /* JADX INFO: renamed from: i */
        public int f2954i;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2952g = obj;
            this.f2954i |= Integer.MIN_VALUE;
            return C2836o5.this.m1188a(null, null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.o5$b */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.ScrollViewCaptureUseCase", m1845f = "ScrollViewCaptureUseCase.kt", m1846i = {0}, m1847l = {56}, m1848m = "restoreInitialScrollState", m1849n = {"this"}, m1850s = {"L$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2836o5 f2955a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ Object f2956b;

        /* JADX INFO: renamed from: d */
        public int f2958d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2956b = obj;
            this.f2958d |= Integer.MIN_VALUE;
            return C2836o5.this.m1189a(this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.o5$c */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.ScrollViewCaptureUseCase", m1845f = "ScrollViewCaptureUseCase.kt", m1846i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, m1847l = {144, 163, 166}, m1848m = "scrollView", m1849n = {"this", "snapshotId", "snapshotConfig", "$this$scrollView_u24lambda_u241", "numberOfSnapshots", "scrollContainerLength", "singleTargetCoordinate", "page", "this", "throwable"}, m1850s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "L$0", "L$2"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2836o5 f2959a;

        /* JADX INFO: renamed from: b */
        public Object f2960b;

        /* JADX INFO: renamed from: c */
        public Object f2961c;

        /* JADX INFO: renamed from: d */
        public C2836o5 f2962d;

        /* JADX INFO: renamed from: e */
        public int f2963e;

        /* JADX INFO: renamed from: f */
        public int f2964f;

        /* JADX INFO: renamed from: g */
        public int f2965g;

        /* JADX INFO: renamed from: h */
        public int f2966h;

        /* JADX INFO: renamed from: i */
        public /* synthetic */ Object f2967i;

        /* JADX INFO: renamed from: k */
        public int f2969k;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2967i = obj;
            this.f2969k |= Integer.MIN_VALUE;
            return C2836o5.this.m1187a(0, 0, 0, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.o5$d */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.ScrollViewCaptureUseCase$scrollView$2$1", m1845f = "ScrollViewCaptureUseCase.kt", m1846i = {}, m1847l = {150}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f2970a;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ int f2972c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ int f2973d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ int f2974e;

        /* JADX INFO: renamed from: f */
        public final /* synthetic */ int f2975f;

        /* JADX INFO: renamed from: g */
        public final /* synthetic */ String f2976g;

        /* JADX INFO: renamed from: h */
        public final /* synthetic */ AbstractC2916w5 f2977h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, int i2, int i3, int i4, String str, AbstractC2916w5 abstractC2916w5, Continuation<? super d> continuation) {
            super(1, continuation);
            this.f2972c = i;
            this.f2973d = i2;
            this.f2974e = i3;
            this.f2975f = i4;
            this.f2976g = str;
            this.f2977h = abstractC2916w5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return C2836o5.this.new d(this.f2972c, this.f2973d, this.f2974e, this.f2975f, this.f2976g, this.f2977h, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2970a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C2836o5 c2836o5 = C2836o5.this;
                int i2 = this.f2972c + 1;
                int i3 = this.f2973d;
                int i4 = this.f2974e;
                int i5 = this.f2975f;
                String str = this.f2976g;
                AbstractC2916w5 abstractC2916w5 = this.f2977h;
                this.f2970a = 1;
                if (c2836o5.m1187a(i2, i3, i4, i5, str, abstractC2916w5, this) == coroutine_suspended) {
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

    public C2836o5(C2729d8 verticalScrollViewScreenRecorder, C2899u8 viewScroller, C2675Y2 pauseStateSetter) {
        C2940z appBarHandler = new C2940z();
        Intrinsics.checkNotNullParameter(verticalScrollViewScreenRecorder, "verticalScrollViewScreenRecorder");
        Intrinsics.checkNotNullParameter(viewScroller, "viewScroller");
        Intrinsics.checkNotNullParameter(pauseStateSetter, "pauseStateSetter");
        Intrinsics.checkNotNullParameter(appBarHandler, "appBarHandler");
        this.f2939a = verticalScrollViewScreenRecorder;
        this.f2940b = viewScroller;
        this.f2941c = pauseStateSetter;
        this.f2942d = appBarHandler;
    }

    /* JADX INFO: renamed from: a */
    public static final Object m1186a(C2836o5 c2836o5, Point point, AbstractC2916w5 abstractC2916w5, Continuation continuation) {
        int height;
        int i;
        boolean z = abstractC2916w5 instanceof AbstractC2916w5.a;
        if (z) {
            height = ((AbstractC2916w5.a) abstractC2916w5).f3211a.getWidth();
        } else {
            if (!(abstractC2916w5 instanceof AbstractC2916w5.b ? true : abstractC2916w5 instanceof AbstractC2916w5.c)) {
                throw new NoWhenBranchMatchedException();
            }
            height = abstractC2916w5.mo1226a().getHeight();
        }
        int i2 = height;
        if (z) {
            i = point.x;
        } else {
            if (!(abstractC2916w5 instanceof AbstractC2916w5.b ? true : abstractC2916w5 instanceof AbstractC2916w5.c)) {
                throw new NoWhenBranchMatchedException();
            }
            i = point.y;
        }
        int i3 = i;
        float f = i2;
        int iCeil = (int) Math.ceil((i3 + f) / f);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        Object objM1187a = c2836o5.m1187a(0, iCeil, i2, i3, string, abstractC2916w5, continuation);
        return objM1187a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM1187a : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX INFO: renamed from: a */
    public final Object m1188a(AbstractC2916w5 abstractC2916w5, String str, Point point, int i, int i2, Continuation<? super Unit> continuation) {
        a aVar;
        AbstractC2916w5 abstractC2916w6;
        String str2;
        int i3;
        int i4;
        C2836o5 c2836o5;
        Point point2 = point;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i5 = aVar.f2954i;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                aVar.f2954i = i5 - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.f2952g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = aVar.f2954i;
        if (i6 != 0) {
            if (i6 == 1) {
                int i7 = aVar.f2951f;
                int i8 = aVar.f2950e;
                Point point3 = aVar.f2949d;
                String str3 = aVar.f2948c;
                AbstractC2916w5 abstractC2916w7 = aVar.f2947b;
                c2836o5 = aVar.f2946a;
                ResultKt.throwOnFailure(obj);
                i4 = i7;
                i3 = i8;
                point2 = point3;
                str2 = str3;
                abstractC2916w6 = abstractC2916w7;
            } else {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        C2899u8 c2899u8 = this.f2940b;
        View viewMo1226a = abstractC2916w5.mo1226a();
        int i9 = point2.x;
        int i10 = point2.y;
        aVar.f2946a = this;
        abstractC2916w6 = abstractC2916w5;
        aVar.f2947b = abstractC2916w6;
        str2 = str;
        aVar.f2948c = str2;
        aVar.f2949d = point2;
        i3 = i;
        aVar.f2950e = i3;
        i4 = i2;
        aVar.f2951f = i4;
        aVar.f2954i = 1;
        c2899u8.getClass();
        viewMo1226a.scrollTo(i9, i10);
        Object objM1181a = C2829n8.m1181a(viewMo1226a, aVar);
        if (objM1181a != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objM1181a = Unit.INSTANCE;
        }
        if (objM1181a == coroutine_suspended) {
            return coroutine_suspended;
        }
        c2836o5 = this;
        Rect rect = new Rect();
        abstractC2916w6.mo1226a().getGlobalVisibleRect(rect);
        AbstractC2727d6.e eVar = new AbstractC2727d6.e(str2, point2, rect, i3, i4, abstractC2916w6);
        C2729d8 c2729d8 = c2836o5.f2939a;
        aVar.f2946a = null;
        aVar.f2947b = null;
        aVar.f2948c = null;
        aVar.f2949d = null;
        aVar.f2954i = 2;
        if (c2729d8.m1086a(eVar, (Continuation<? super Unit>) aVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    public final Object m1189a(Continuation<? super Unit> continuation) {
        b bVar;
        Object objWithContext;
        WeakReference<View> weakReference;
        WeakReference<View> weakReference2;
        View view;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.f2958d;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.f2958d = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.f2956b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.f2958d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C2940z c2940z = this.f2942d;
            C2940z.a aVar = this.f2944f;
            bVar.f2955a = this;
            bVar.f2958d = 1;
            c2940z.getClass();
            View view2 = (aVar == null || (weakReference2 = aVar.f3282a) == null) ? null : weakReference2.get();
            View view3 = (aVar == null || (weakReference = aVar.f3283b) == null) ? null : weakReference.get();
            if (view2 == null || view3 == null || (objWithContext = BuildersKt.withContext(c2940z.f3281a, new C2446B(view3, aVar, c2940z, view2, null), bVar)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objWithContext = Unit.INSTANCE;
            }
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = bVar.f2955a;
            ResultKt.throwOnFailure(obj);
        }
        this.f2944f = null;
        C2899u8 c2899u8 = this.f2940b;
        C2899u8.a aVar2 = this.f2945g;
        c2899u8.getClass();
        if ((aVar2 != null ? aVar2.f3161b : null) != null && (view = aVar2.f3160a.get()) != null) {
            Point point = aVar2.f3161b;
            view.scrollTo(point.x, point.y);
        }
        this.f2945g = null;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x008b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0090  */
    /* JADX WARN: Code duplicated, block: B:29:0x0092  */
    /* JADX WARN: Code duplicated, block: B:33:0x009f A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5 A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00af A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00da A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00db  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f1 A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0101 A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0112 A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0118 A[Catch: all -> 0x00ff, TRY_LEAVE, TryCatch #2 {all -> 0x00ff, blocks: (B:44:0x00e7, B:46:0x00f1, B:50:0x0101, B:31:0x009b, B:33:0x009f, B:40:0x00b4, B:34:0x00a5, B:39:0x00af, B:52:0x0112, B:53:0x0117, B:37:0x00ab, B:30:0x0097, B:54:0x0118), top: B:73:0x00e7 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0131  */
    /* JADX WARN: Code duplicated, block: B:62:0x0141 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0158 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00db -> B:73:0x00e7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: a */
    public final java.lang.Object m1187a(int r24, int r25, int r26, int r27, java.lang.String r28, com.contentsquare.android.sdk.AbstractC2916w5 r29, kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C2836o5.m1187a(int, int, int, int, java.lang.String, com.contentsquare.android.sdk.w5, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

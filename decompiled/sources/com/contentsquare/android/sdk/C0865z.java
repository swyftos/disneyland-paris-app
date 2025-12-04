package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import com.contentsquare.android.core.features.logging.Logger;
import java.lang.ref.WeakReference;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0865z {

    @NotNull
    public static final Logger b = new Logger("AppBarHandler");

    @NotNull
    public final CoroutineDispatcher a;

    /* renamed from: com.contentsquare.android.sdk.z$a */
    public static final class a {

        @NotNull
        public final WeakReference<View> a;

        @NotNull
        public final WeakReference<View> b;
        public final int c;

        public a(@NotNull WeakReference<View> appBarLayout, @NotNull WeakReference<View> scrollContainer, int i) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
            this.a = appBarLayout;
            this.b = scrollContainer;
            this.c = i;
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.AppBarHandler$prepareAppBar$2", f = "AppBarHandler.kt", i = {0, 0, 1, 1}, l = {44, 49}, m = "invokeSuspend", n = {"uiState", "scrollContainerYBefore", "uiState", "scrollContainerDeltaY"}, s = {"L$0", "F$0", "L$0", "I$0"})
    /* renamed from: com.contentsquare.android.sdk.z$b */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a>, Object> {
        public a a;
        public float b;
        public int c;
        public int d;
        public final /* synthetic */ View e;
        public final /* synthetic */ View f;
        public final /* synthetic */ C0865z g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, View view2, C0865z c0865z, Continuation<? super b> continuation) {
            super(2, continuation);
            this.e = view;
            this.f = view2;
            this.g = c0865z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.e, this.f, this.g, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super a> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a aVar;
            float y;
            int i;
            a aVar2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.d;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                aVar = new a(new WeakReference(this.e), new WeakReference(this.f), this.f.getLayoutParams().height);
                y = this.f.getY();
                C0865z.a(this.g, this.e, true);
                View view = this.e;
                this.a = aVar;
                this.b = y;
                this.d = 1;
                if (C0759n8.a(view, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = this.c;
                    aVar2 = this.a;
                    ResultKt.throwOnFailure(obj);
                    this.f.scrollBy(0, i);
                    return aVar2;
                }
                y = this.b;
                a aVar3 = this.a;
                ResultKt.throwOnFailure(obj);
                aVar = aVar3;
            }
            int y2 = (int) (this.f.getY() - y);
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            layoutParams.height = this.f.getHeight() - y2;
            this.f.setLayoutParams(layoutParams);
            View view2 = this.f;
            this.a = aVar;
            this.c = y2;
            this.d = 2;
            if (C0759n8.a(view2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = y2;
            aVar2 = aVar;
            this.f.scrollBy(0, i);
            return aVar2;
        }
    }

    public C0865z() {
        MainCoroutineDispatcher dispatcherMain = Dispatchers.getMain();
        Intrinsics.checkNotNullParameter(dispatcherMain, "dispatcherMain");
        this.a = dispatcherMain;
    }

    public static final void a(C0865z c0865z, View view, boolean z) {
        c0865z.getClass();
        if (Intrinsics.areEqual(view.getClass().getName(), "com.google.android.material.appbar.AppBarLayout")) {
            try {
                Class<?> cls = view.getClass();
                Class cls2 = Boolean.TYPE;
                cls.getMethod("setExpanded", cls2, cls2).invoke(view, Boolean.valueOf(z), Boolean.FALSE);
            } catch (NoSuchMethodException | SecurityException e) {
                Q2.a(b, "Error while expanding/collapsing AppBarLayout", e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.AbstractC0844w5 r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.contentsquare.android.sdk.C0865z.a> r6) {
        /*
            r4 = this;
            android.view.View r5 = r5.a()
            android.view.ViewParent r0 = r5.getParent()
            java.lang.String r1 = "view.parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "CoordinatorLayout"
            boolean r0 = com.contentsquare.android.core.utils.ExtensionsKt.isDerivedInstanceOf(r0, r1)
            r1 = 0
            if (r0 == 0) goto L3a
            android.view.ViewParent r0 = r5.getParent()
            boolean r2 = r0 instanceof android.view.ViewGroup
            if (r2 == 0) goto L22
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L23
        L22:
            r0 = r1
        L23:
            if (r0 == 0) goto L3a
            kotlin.sequences.Sequence r0 = androidx.core.view.ViewGroupKt.getChildren(r0)
            if (r0 == 0) goto L3a
            com.contentsquare.android.sdk.A r2 = com.contentsquare.android.sdk.A.a
            kotlin.sequences.Sequence r0 = kotlin.sequences.SequencesKt.filter(r0, r2)
            if (r0 == 0) goto L3a
            java.lang.Object r0 = kotlin.sequences.SequencesKt.firstOrNull(r0)
            android.view.View r0 = (android.view.View) r0
            goto L3b
        L3a:
            r0 = r1
        L3b:
            if (r0 == 0) goto L52
            kotlinx.coroutines.CoroutineDispatcher r2 = r4.a
            com.contentsquare.android.sdk.z$b r3 = new com.contentsquare.android.sdk.z$b
            r3.<init>(r0, r5, r4, r1)
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.withContext(r2, r3, r6)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L4f
            return r4
        L4f:
            r1 = r4
            com.contentsquare.android.sdk.z$a r1 = (com.contentsquare.android.sdk.C0865z.a) r1
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0865z.a(com.contentsquare.android.sdk.w5, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

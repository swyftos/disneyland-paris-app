package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.ExtensionsKt;
import java.lang.ref.WeakReference;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.z */
/* JADX INFO: loaded from: classes2.dex */
public final class C2940z {

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final Logger f3280b = new Logger("AppBarHandler");

    /* JADX INFO: renamed from: a */
    @NotNull
    public final CoroutineDispatcher f3281a;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.z$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final WeakReference<View> f3282a;

        /* JADX INFO: renamed from: b */
        @NotNull
        public final WeakReference<View> f3283b;

        /* JADX INFO: renamed from: c */
        public final int f3284c;

        public a(@NotNull WeakReference<View> appBarLayout, @NotNull WeakReference<View> scrollContainer, int i) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
            this.f3282a = appBarLayout;
            this.f3283b = scrollContainer;
            this.f3284c = i;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.z$b */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.AppBarHandler$prepareAppBar$2", m1845f = "AppBarHandler.kt", m1846i = {0, 0, 1, 1}, m1847l = {44, 49}, m1848m = "invokeSuspend", m1849n = {"uiState", "scrollContainerYBefore", "uiState", "scrollContainerDeltaY"}, m1850s = {"L$0", "F$0", "L$0", "I$0"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a>, Object> {

        /* JADX INFO: renamed from: a */
        public a f3285a;

        /* JADX INFO: renamed from: b */
        public float f3286b;

        /* JADX INFO: renamed from: c */
        public int f3287c;

        /* JADX INFO: renamed from: d */
        public int f3288d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ View f3289e;

        /* JADX INFO: renamed from: f */
        public final /* synthetic */ View f3290f;

        /* JADX INFO: renamed from: g */
        public final /* synthetic */ C2940z f3291g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, View view2, C2940z c2940z, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f3289e = view;
            this.f3290f = view2;
            this.f3291g = c2940z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.f3289e, this.f3290f, this.f3291g, continuation);
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
            int i2 = this.f3288d;
            if (i2 != 0) {
                if (i2 == 1) {
                    y = this.f3286b;
                    a aVar3 = this.f3285a;
                    ResultKt.throwOnFailure(obj);
                    aVar = aVar3;
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = this.f3287c;
                    aVar2 = this.f3285a;
                    ResultKt.throwOnFailure(obj);
                }
                this.f3290f.scrollBy(0, i);
                return aVar2;
            }
            ResultKt.throwOnFailure(obj);
            aVar = new a(new WeakReference(this.f3289e), new WeakReference(this.f3290f), this.f3290f.getLayoutParams().height);
            y = this.f3290f.getY();
            C2940z.m1239a(this.f3291g, this.f3289e, true);
            View view = this.f3289e;
            this.f3285a = aVar;
            this.f3286b = y;
            this.f3288d = 1;
            if (C2829n8.m1182a(view, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            int y2 = (int) (this.f3290f.getY() - y);
            ViewGroup.LayoutParams layoutParams = this.f3290f.getLayoutParams();
            layoutParams.height = this.f3290f.getHeight() - y2;
            this.f3290f.setLayoutParams(layoutParams);
            View view2 = this.f3290f;
            this.f3285a = aVar;
            this.f3287c = y2;
            this.f3288d = 2;
            if (C2829n8.m1182a(view2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = y2;
            aVar2 = aVar;
            this.f3290f.scrollBy(0, i);
            return aVar2;
        }
    }

    public C2940z() {
        MainCoroutineDispatcher dispatcherMain = Dispatchers.getMain();
        Intrinsics.checkNotNullParameter(dispatcherMain, "dispatcherMain");
        this.f3281a = dispatcherMain;
    }

    /* JADX INFO: renamed from: a */
    public static final void m1239a(C2940z c2940z, View view, boolean z) {
        c2940z.getClass();
        if (Intrinsics.areEqual(view.getClass().getName(), "com.google.android.material.appbar.AppBarLayout")) {
            try {
                Class<?> cls = view.getClass();
                Class cls2 = Boolean.TYPE;
                cls.getMethod("setExpanded", cls2, cls2).invoke(view, Boolean.valueOf(z), Boolean.FALSE);
            } catch (NoSuchMethodException | SecurityException e) {
                C2599Q2.m1011a(f3280b, "Error while expanding/collapsing AppBarLayout", e);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m1240a(@NotNull AbstractC2916w5 abstractC2916w5, @NotNull Continuation<? super a> continuation) {
        View view;
        Sequence<View> children;
        Sequence sequenceFilter;
        View viewMo1226a = abstractC2916w5.mo1226a();
        ViewParent parent = viewMo1226a.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "view.parent");
        if (ExtensionsKt.isDerivedInstanceOf(parent, "CoordinatorLayout")) {
            ViewParent parent2 = viewMo1226a.getParent();
            ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null || (sequenceFilter = SequencesKt.filter(children, C2436A.f1368a)) == null) {
                view = null;
            } else {
                view = (View) SequencesKt.firstOrNull(sequenceFilter);
            }
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        Object objWithContext = BuildersKt.withContext(this.f3281a, new b(view, viewMo1226a, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : (a) objWithContext;
    }
}

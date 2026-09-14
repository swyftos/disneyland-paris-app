package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewTreeObserver;
import com.contentsquare.android.core.utils.Debouncer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.q5 */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewTreeObserverOnScrollChangedListenerC2856q5 extends AbstractC2720d<View> implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.q5$a */
    public static final class a extends Lambda implements Function1<View, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(View view) {
            View forView = view;
            Intrinsics.checkNotNullParameter(forView, "$this$forView");
            forView.getViewTreeObserver().removeOnScrollChangedListener(ViewTreeObserverOnScrollChangedListenerC2856q5.this);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.q5$b */
    public static final class b extends Lambda implements Function1<View, Integer> {

        /* JADX INFO: renamed from: a */
        public static final b f3033a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(View view) {
            View forView = view;
            Intrinsics.checkNotNullParameter(forView, "$this$forView");
            return Integer.valueOf(forView.getScrollX());
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.q5$c */
    public static final class c extends Lambda implements Function1<View, Integer> {

        /* JADX INFO: renamed from: a */
        public static final c f3034a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(View view) {
            View forView = view;
            Intrinsics.checkNotNullParameter(forView, "$this$forView");
            return Integer.valueOf(forView.getScrollY());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewTreeObserverOnScrollChangedListenerC2856q5(@NotNull final View view, @NotNull Debouncer debouncer) {
        super(view, debouncer);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(debouncer, "debouncer");
        view.post(new Runnable() { // from class: com.contentsquare.android.sdk.q5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ViewTreeObserverOnScrollChangedListenerC2856q5.m1194a(view, this);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static final void m1194a(View view, ViewTreeObserverOnScrollChangedListenerC2856q5 this$0) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.getViewTreeObserver().addOnScrollChangedListener(this$0);
        this$0.getClass();
        this$0.m1113a(new C2710c(this$0));
    }

    @Override // com.contentsquare.android.sdk.AbstractC2720d
    /* JADX INFO: renamed from: b */
    public final int mo880b() {
        Integer num = (Integer) m1113a(c.f3034a);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2866r5
    public final void clear() {
        m1113a(new a());
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        m1113a(new C2710c(this));
    }

    @Override // com.contentsquare.android.sdk.AbstractC2720d
    /* JADX INFO: renamed from: a */
    public final int mo879a() {
        Integer num = (Integer) m1113a(b.f3033a);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}

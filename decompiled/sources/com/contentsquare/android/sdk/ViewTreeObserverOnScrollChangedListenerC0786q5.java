package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewTreeObserver;
import com.contentsquare.android.core.utils.Debouncer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.q5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewTreeObserverOnScrollChangedListenerC0786q5 extends AbstractC0650d<View> implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: com.contentsquare.android.sdk.q5$a */
    public static final class a extends Lambda implements Function1<View, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(View view) {
            View forView = view;
            Intrinsics.checkNotNullParameter(forView, "$this$forView");
            forView.getViewTreeObserver().removeOnScrollChangedListener(ViewTreeObserverOnScrollChangedListenerC0786q5.this);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.q5$b */
    public static final class b extends Lambda implements Function1<View, Integer> {
        public static final b a = new b();

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

    /* renamed from: com.contentsquare.android.sdk.q5$c */
    public static final class c extends Lambda implements Function1<View, Integer> {
        public static final c a = new c();

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
    public ViewTreeObserverOnScrollChangedListenerC0786q5(@NotNull final View view, @NotNull Debouncer debouncer) {
        super(view, debouncer);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(debouncer, "debouncer");
        view.post(new Runnable() { // from class: com.contentsquare.android.sdk.q5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ViewTreeObserverOnScrollChangedListenerC0786q5.a(view, this);
            }
        });
    }

    public static final void a(View view, ViewTreeObserverOnScrollChangedListenerC0786q5 this$0) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.getViewTreeObserver().addOnScrollChangedListener(this$0);
        this$0.getClass();
        this$0.a(new C0640c(this$0));
    }

    @Override // com.contentsquare.android.sdk.AbstractC0650d
    public final int b() {
        Integer num = (Integer) a(c.a);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0795r5
    public final void clear() {
        a(new a());
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        a(new C0640c(this));
    }

    @Override // com.contentsquare.android.sdk.AbstractC0650d
    public final int a() {
        Integer num = (Integer) a(b.a);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}

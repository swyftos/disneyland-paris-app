package com.contentsquare.android.sdk;

import android.view.View;
import android.webkit.WebView;
import com.contentsquare.android.core.utils.ExtensionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* renamed from: com.contentsquare.android.sdk.t5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0815t5 extends Lambda implements Function1<View, Boolean> {
    public final /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC0825u5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0815t5(ViewTreeObserverOnGlobalLayoutListenerC0825u5 viewTreeObserverOnGlobalLayoutListenerC0825u5) {
        super(1);
        this.a = viewTreeObserverOnGlobalLayoutListenerC0825u5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(View view) {
        View view2 = view;
        Intrinsics.checkNotNullParameter(view2, "it");
        this.a.getClass();
        boolean z = false;
        if (ViewTreeObserverOnGlobalLayoutListenerC0825u5.c(view2)) {
            this.a.getClass();
            Intrinsics.checkNotNullParameter(view2, "view");
            if (!(view2 instanceof WebView) && !ExtensionsKt.isDerivedInstanceOf(view2, "NavigationMenuView") && !StringsKt.startsWith$default("javaClass", "androidx.viewpager2.widget.ViewPager2", false, 2, (Object) null)) {
                this.a.getClass();
                if (!ViewTreeObserverOnGlobalLayoutListenerC0825u5.b(view2)) {
                    z = true;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}

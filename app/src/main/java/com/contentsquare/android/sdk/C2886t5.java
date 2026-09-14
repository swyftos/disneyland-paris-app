package com.contentsquare.android.sdk;

import android.view.View;
import android.webkit.WebView;
import com.contentsquare.android.core.utils.ExtensionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.t5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2886t5 extends Lambda implements Function1<View, Boolean> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC2896u5 f3111a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2886t5(ViewTreeObserverOnGlobalLayoutListenerC2896u5 viewTreeObserverOnGlobalLayoutListenerC2896u5) {
        super(1);
        this.f3111a = viewTreeObserverOnGlobalLayoutListenerC2896u5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(View view) {
        View view2 = view;
        Intrinsics.checkNotNullParameter(view2, "it");
        this.f3111a.getClass();
        boolean z = false;
        if (ViewTreeObserverOnGlobalLayoutListenerC2896u5.m1211c(view2)) {
            this.f3111a.getClass();
            Intrinsics.checkNotNullParameter(view2, "view");
            if (!(view2 instanceof WebView) && !ExtensionsKt.isDerivedInstanceOf(view2, "NavigationMenuView") && !StringsKt.startsWith$default("javaClass", "androidx.viewpager2.widget.ViewPager2", false, 2, (Object) null)) {
                this.f3111a.getClass();
                if (!ViewTreeObserverOnGlobalLayoutListenerC2896u5.m1210b(view2)) {
                    z = true;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}

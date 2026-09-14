package com.contentsquare.android.sdk;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.H2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2509H2 {
    @JvmStatic
    @NotNull
    /* JADX INFO: renamed from: a */
    public static final C2499G2 m931a(@NotNull View view, @NotNull InterfaceC2749f8 viewBitmapProviderResult, @NotNull C2659W4 screenGraphParameters, @Nullable ComposeInterface composeInterface) {
        C2499G2.a aVar;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewBitmapProviderResult, "viewBitmapProviderResult");
        Intrinsics.checkNotNullParameter(screenGraphParameters, "screenGraphParameters");
        C2520I3 c2520i3 = new C2520I3(new C2530J3());
        String simpleName = view.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "view.javaClass.simpleName");
        boolean zAreEqual = false;
        C2469D2 c2469d2 = new C2469D2(0, simpleName, c2520i3.m939a(view));
        if (composeInterface == null || !composeInterface.isComposeRootView(view)) {
            aVar = (composeInterface == null || !composeInterface.isAndroidViewsHandler(view)) ? C2499G2.a.VIEW : C2499G2.a.ANDROID_VIEWS_HANDLER;
        } else {
            aVar = C2499G2.a.ANDROID_COMPOSE_VIEW;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        C2489F2 c2489f2 = new C2489F2(view.getWidth(), view.getHeight(), iArr[0], iArr[1], view.getZ(), null, null, false, BitmapDescriptorFactory.HUE_RED, 992);
        c2489f2.f1602h = view.getVisibility() == 0;
        if (screenGraphParameters.f2211a) {
            zAreEqual = Intrinsics.areEqual(view, screenGraphParameters.f2213c);
        } else if (!(view instanceof ViewGroup) || (view.getBackground() instanceof LayerDrawable) || (view instanceof WebView) || ExtensionsKt.isDerivedInstanceOf(view, "CollapsingToolbarLayout")) {
            zAreEqual = true;
        }
        if (zAreEqual) {
            c2489f2.f1600f = viewBitmapProviderResult.mo1137b(view);
        } else if (screenGraphParameters.f2212b) {
            Intrinsics.checkNotNullParameter(view, "view");
            Drawable background = view.getBackground();
            c2489f2.f1601g = background instanceof ColorDrawable ? ExtensionsKt.toColorHex(((ColorDrawable) background).getColor()) : "#00FFFFFF";
            Intrinsics.checkNotNullParameter(view, "view");
            c2489f2.f1603i = ((view instanceof ViewGroup) && (view.getBackground() instanceof ColorDrawable)) ? view.getAlpha() : 1.0f;
        }
        if (aVar == C2499G2.a.ANDROID_VIEWS_HANDLER) {
            c2489f2.f1604j = Boolean.FALSE;
        }
        String strM942a = C2521I4.m942a(view, "null");
        Intrinsics.checkNotNullExpressionValue(strM942a, "getResourceEntryName(vie…urceUtils.NULL_STRING_ID)");
        C2499G2 c2499g2 = new C2499G2();
        JSONObject jSONObjectM916a = c2489f2.m916a();
        Intrinsics.checkNotNullParameter(jSONObjectM916a, "<set-?>");
        c2499g2.f1642f = jSONObjectM916a;
        JSONObject jSONObjectM897a = c2469d2.m897a();
        Intrinsics.checkNotNullParameter(jSONObjectM897a, "<set-?>");
        c2499g2.f1638b = jSONObjectM897a;
        Intrinsics.checkNotNullParameter(strM942a, "<set-?>");
        c2499g2.f1637a = strM942a;
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        c2499g2.f1644h = aVar;
        return c2499g2;
    }
}

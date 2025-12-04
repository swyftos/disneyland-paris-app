package com.contentsquare.android.sdk;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.sdk.G2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class H2 {
    @JvmStatic
    @NotNull
    public static final G2 a(@NotNull View view, @NotNull InterfaceC0679f8 viewBitmapProviderResult, @NotNull W4 screenGraphParameters, @Nullable ComposeInterface composeInterface) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewBitmapProviderResult, "viewBitmapProviderResult");
        Intrinsics.checkNotNullParameter(screenGraphParameters, "screenGraphParameters");
        I3 i3 = new I3(new J3());
        String simpleName = view.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "view.javaClass.simpleName");
        boolean zAreEqual = false;
        D2 d2 = new D2(0, simpleName, i3.a(view));
        G2.a aVar = (composeInterface == null || !composeInterface.isComposeRootView(view)) ? (composeInterface == null || !composeInterface.isAndroidViewsHandler(view)) ? G2.a.VIEW : G2.a.ANDROID_VIEWS_HANDLER : G2.a.ANDROID_COMPOSE_VIEW;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        F2 f2 = new F2(view.getWidth(), view.getHeight(), iArr[0], iArr[1], view.getZ(), null, null, false, BitmapDescriptorFactory.HUE_RED, 992);
        f2.h = view.getVisibility() == 0;
        if (screenGraphParameters.a) {
            zAreEqual = Intrinsics.areEqual(view, screenGraphParameters.c);
        } else if (!(view instanceof ViewGroup) || (view.getBackground() instanceof LayerDrawable) || (view instanceof WebView) || ExtensionsKt.isDerivedInstanceOf(view, "CollapsingToolbarLayout")) {
            zAreEqual = true;
        }
        if (zAreEqual) {
            f2.f = viewBitmapProviderResult.b(view);
        } else if (screenGraphParameters.b) {
            Intrinsics.checkNotNullParameter(view, "view");
            Drawable background = view.getBackground();
            f2.g = background instanceof ColorDrawable ? ExtensionsKt.toColorHex(((ColorDrawable) background).getColor()) : "#00FFFFFF";
            Intrinsics.checkNotNullParameter(view, "view");
            f2.i = ((view instanceof ViewGroup) && (view.getBackground() instanceof ColorDrawable)) ? view.getAlpha() : 1.0f;
        }
        if (aVar == G2.a.ANDROID_VIEWS_HANDLER) {
            f2.j = Boolean.FALSE;
        }
        String strA = I4.a(view, "null");
        Intrinsics.checkNotNullExpressionValue(strA, "getResourceEntryName(vie…urceUtils.NULL_STRING_ID)");
        G2 g2 = new G2();
        JSONObject jSONObjectA = f2.a();
        Intrinsics.checkNotNullParameter(jSONObjectA, "<set-?>");
        g2.f = jSONObjectA;
        JSONObject jSONObjectA2 = d2.a();
        Intrinsics.checkNotNullParameter(jSONObjectA2, "<set-?>");
        g2.b = jSONObjectA2;
        Intrinsics.checkNotNullParameter(strA, "<set-?>");
        g2.a = strA;
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        g2.h = aVar;
        return g2;
    }
}

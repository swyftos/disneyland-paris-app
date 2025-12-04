package com.swmansion.rnscreens.utils;

import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a.\u0010\u0004\u001a\u00060\u0001j\u0002`\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001*\n\u0010\u0002\"\u00020\u00032\u00020\u0003¨\u0006\r"}, d2 = {"InsetsCompat", "Landroidx/core/graphics/Insets;", "InsetsPlatform", "Landroid/graphics/Insets;", "resolveInsetsOrZero", "Lcom/swmansion/rnscreens/utils/InsetsCompat;", "Landroid/view/View;", "insetType", "", "sourceWindowInsets", "Landroid/view/WindowInsets;", "ignoreVisibility", "", "react-native-screens_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InsetsKtKt {
    public static /* synthetic */ Insets resolveInsetsOrZero$default(View view, int i, WindowInsets windowInsets, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            windowInsets = view.getRootWindowInsets();
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return resolveInsetsOrZero(view, i, windowInsets, z);
    }

    @NotNull
    public static final Insets resolveInsetsOrZero(@NotNull View view, int i, @Nullable WindowInsets windowInsets, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (windowInsets == null) {
            Insets NONE = Insets.NONE;
            Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            return NONE;
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(...)");
        if (!z) {
            Insets insets = windowInsetsCompat.getInsets(i);
            Intrinsics.checkNotNull(insets);
            return insets;
        }
        Insets insetsIgnoringVisibility = windowInsetsCompat.getInsetsIgnoringVisibility(i);
        Intrinsics.checkNotNull(insetsIgnoringVisibility);
        return insetsIgnoringVisibility;
    }
}

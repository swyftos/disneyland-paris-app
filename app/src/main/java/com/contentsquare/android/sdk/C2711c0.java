package com.contentsquare.android.sdk;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.c0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2711c0 {
    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m1100a(@NotNull byte[] imageByteArray) {
        Intrinsics.checkNotNullParameter(imageByteArray, "imageByteArray");
        String strEncodeToString = Base64.encodeToString(imageByteArray, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(imageByteArray, Base64.NO_WRAP)");
        return strEncodeToString;
    }
}

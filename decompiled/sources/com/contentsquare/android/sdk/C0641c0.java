package com.contentsquare.android.sdk;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.c0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0641c0 {
    @NotNull
    public static String a(@NotNull byte[] imageByteArray) {
        Intrinsics.checkNotNullParameter(imageByteArray, "imageByteArray");
        String strEncodeToString = Base64.encodeToString(imageByteArray, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(imageByteArray, Base64.NO_WRAP)");
        return strEncodeToString;
    }
}

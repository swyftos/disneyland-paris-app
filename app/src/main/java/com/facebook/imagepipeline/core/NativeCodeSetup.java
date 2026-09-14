package com.facebook.imagepipeline.core;

import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class NativeCodeSetup {
    private static boolean sUseNativeCode = true;

    public static void setUseNativeCode(boolean z) {
        sUseNativeCode = z;
    }

    public static boolean getUseNativeCode() {
        return sUseNativeCode;
    }
}

package com.facebook.soloader;

/* loaded from: classes3.dex */
abstract class MergedSoMapping {
    static String mapLibName(String str) {
        return null;
    }

    static void invokeJniOnload(String str) {
        throw new IllegalArgumentException("Unknown library: " + str);
    }
}

package com.appdynamics.repacked.gson.internal;

/* JADX INFO: renamed from: com.appdynamics.repacked.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final class C$Gson$Preconditions {
    @Deprecated
    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}

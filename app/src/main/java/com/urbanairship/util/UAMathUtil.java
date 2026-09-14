package com.urbanairship.util;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class UAMathUtil {
    public static int constrain(int i, int i2, int i3) {
        return i > i3 ? i3 : Math.max(i, i2);
    }
}

package com.urbanairship.util;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class UAMathUtil {
    public static int constrain(int i, int i2, int i3) {
        return i > i3 ? i3 : Math.max(i, i2);
    }
}

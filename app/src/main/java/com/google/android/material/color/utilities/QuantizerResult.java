package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerResult {
    public final Map<Integer, Integer> colorToCount;

    QuantizerResult(Map map) {
        this.colorToCount = map;
    }
}

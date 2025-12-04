package com.urbanairship.util;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class ViewUtils {
    public static void applyTextStyle(@NonNull Context context, @NonNull TextView textView, @StyleRes int i) {
        if (i != 0) {
            textView.setTextAppearance(i);
        }
    }
}

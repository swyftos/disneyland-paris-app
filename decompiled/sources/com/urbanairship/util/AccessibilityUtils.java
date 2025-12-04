package com.urbanairship.util;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* loaded from: classes5.dex */
public final class AccessibilityUtils {
    public static void setClickActionLabel(@NonNull View view, @NonNull String str) {
        ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK, str, null);
    }

    public static void setClickActionLabel(@NonNull View view, @StringRes int i) {
        setClickActionLabel(view, view.getResources().getString(i));
    }
}

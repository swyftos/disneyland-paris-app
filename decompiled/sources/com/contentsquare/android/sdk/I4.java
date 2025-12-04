package com.contentsquare.android.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class I4 {
    @NonNull
    public static String a(@NonNull View view, String str) {
        Context context = view.getContext();
        int id = view.getId();
        long j = id;
        if (j == 16777215 || j == 0 || id == -1) {
            return str;
        }
        try {
            return context.getResources().getResourceEntryName(id);
        } catch (Resources.NotFoundException | NullPointerException unused) {
            return str;
        }
    }
}

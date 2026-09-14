package com.urbanairship.android.layout.util;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InitialMargins extends InitialSpacing {
    public InitialMargins(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }
}

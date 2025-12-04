package com.urbanairship.android.layout.util;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class InitialMargins extends InitialSpacing {
    public InitialMargins(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }
}

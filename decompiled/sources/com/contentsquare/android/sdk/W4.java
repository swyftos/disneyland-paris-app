package com.contentsquare.android.sdk;

import android.view.View;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class W4 {
    public final boolean a;
    public final boolean b;

    @Nullable
    public final View c;

    public W4(@Nullable View view, boolean z) {
        this.a = z;
        if (z) {
            this.b = false;
        } else {
            this.b = true;
            view = null;
        }
        this.c = view;
    }
}

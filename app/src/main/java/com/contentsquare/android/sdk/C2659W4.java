package com.contentsquare.android.sdk;

import android.view.View;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.W4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2659W4 {

    /* JADX INFO: renamed from: a */
    public final boolean f2211a;

    /* JADX INFO: renamed from: b */
    public final boolean f2212b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final View f2213c;

    public C2659W4(@Nullable View view, boolean z) {
        this.f2211a = z;
        if (z) {
            this.f2212b = false;
        } else {
            this.f2212b = true;
            view = null;
        }
        this.f2213c = view;
    }
}

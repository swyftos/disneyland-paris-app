package com.contentsquare.android.sdk;

import android.graphics.Paint;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.s4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2875s4 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2541K4 f3098a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final ArrayList f3099b;

    /* JADX INFO: renamed from: c */
    public int f3100c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Paint f3101d;

    public C2875s4() {
        C2541K4 reusableBitmapProvider = new C2541K4();
        Intrinsics.checkNotNullParameter(reusableBitmapProvider, "reusableBitmapProvider");
        this.f3098a = reusableBitmapProvider;
        this.f3099b = new ArrayList();
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        this.f3101d = paint;
    }
}

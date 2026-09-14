package com.contentsquare.android.sdk;

import androidx.annotation.FloatRange;
import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.e0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2731e0 {

    /* JADX INFO: renamed from: a */
    public final int f2567a;

    /* JADX INFO: renamed from: b */
    public final int f2568b;

    /* JADX INFO: renamed from: c */
    public final float f2569c;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.e0$a */
    public static final class a {
    }

    public C2731e0(@NotNull int[] pixels, int i, int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, m3to = 1.0d) float f) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        this.f2567a = i;
        this.f2568b = i2;
        this.f2569c = f;
    }
}

package com.contentsquare.android.sdk;

import androidx.annotation.FloatRange;
import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.e0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0661e0 {
    public final int a;
    public final int b;
    public final float c;

    /* renamed from: com.contentsquare.android.sdk.e0$a */
    public static final class a {
    }

    public C0661e0(@NotNull int[] pixels, int i, int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        this.a = i;
        this.b = i2;
        this.c = f;
    }
}

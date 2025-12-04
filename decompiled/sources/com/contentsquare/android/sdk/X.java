package com.contentsquare.android.sdk;

import android.util.SparseIntArray;
import androidx.annotation.FloatRange;
import androidx.camera.video.AudioStats;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class X {

    @NotNull
    public final SparseIntArray a = new SparseIntArray();

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float b;
}

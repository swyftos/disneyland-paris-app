package androidx.camera.video.internal.audio;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
interface AudioStreamFactory {
    AudioStream create(AudioSettings audioSettings, Context context);
}

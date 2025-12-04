package androidx.camera.video.internal.audio;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class AudioSourceAccessException extends Exception {
    public AudioSourceAccessException(@Nullable String str) {
        super(str);
    }

    public AudioSourceAccessException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public AudioSourceAccessException(@Nullable Throwable th) {
        super(th);
    }
}

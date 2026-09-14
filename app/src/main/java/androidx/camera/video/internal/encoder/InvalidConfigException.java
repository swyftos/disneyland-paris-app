package androidx.camera.video.internal.encoder;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class InvalidConfigException extends Exception {
    public InvalidConfigException(@Nullable String str) {
        super(str);
    }

    public InvalidConfigException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public InvalidConfigException(@Nullable Throwable th) {
        super(th);
    }
}

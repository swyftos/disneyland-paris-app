package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class MimeInfo {

    public static abstract class Builder<B> {
        @NonNull
        public abstract MimeInfo build();

        @NonNull
        protected abstract B setMimeType(@NonNull String str);

        @NonNull
        public abstract B setProfile(int i);
    }

    @NonNull
    public abstract String getMimeType();

    public abstract int getProfile();
}

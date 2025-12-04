package com.urbanairship.images;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface ImageLoader {

    public interface ImageLoadedCallback {
        void onImageLoaded(boolean z);
    }

    @MainThread
    void load(@NonNull Context context, @NonNull ImageView imageView, @NonNull ImageRequestOptions imageRequestOptions);
}

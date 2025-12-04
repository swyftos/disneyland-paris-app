package com.urbanairship.images;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.images.ImageLoader;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class ImageRequestOptions {
    private final ImageLoader.ImageLoadedCallback callback;
    private final ImageSizeResolver imageSizeResolver;
    private final int placeHolder;
    private final String url;

    private ImageRequestOptions(Builder builder) {
        this.url = builder.url;
        this.placeHolder = builder.placeHolder;
        this.callback = builder.callback;
        this.imageSizeResolver = builder.imageSizeResolver;
    }

    @DrawableRes
    public int getPlaceHolder() {
        return this.placeHolder;
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    @Nullable
    public ImageLoader.ImageLoadedCallback getCallback() {
        return this.callback;
    }

    @Nullable
    public ImageSizeResolver getImageSizeResolver() {
        return this.imageSizeResolver;
    }

    @NonNull
    public static Builder newBuilder(@Nullable String str) {
        return new Builder(str);
    }

    public static final class Builder {
        private ImageLoader.ImageLoadedCallback callback;
        private ImageSizeResolver imageSizeResolver;
        private int placeHolder;
        private final String url;

        private Builder(String str) {
            this.url = str;
        }

        @NonNull
        public Builder setPlaceHolder(@DrawableRes int i) {
            this.placeHolder = i;
            return this;
        }

        @NonNull
        public Builder setImageLoadedCallback(ImageLoader.ImageLoadedCallback imageLoadedCallback) {
            this.callback = imageLoadedCallback;
            return this;
        }

        @NonNull
        public Builder setImageSizeResolver(ImageSizeResolver imageSizeResolver) {
            this.imageSizeResolver = imageSizeResolver;
            return this;
        }

        @NonNull
        public ImageRequestOptions build() {
            return new ImageRequestOptions(this);
        }
    }
}

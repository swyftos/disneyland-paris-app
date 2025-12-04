package com.urbanairship.config;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class UrlBuilder {
    public final String baseUrl;
    private Uri.Builder uriBuilder;

    public UrlBuilder(@Nullable String str) {
        this.baseUrl = str;
        if (str != null) {
            this.uriBuilder = Uri.parse(str).buildUpon();
        }
    }

    @NonNull
    public UrlBuilder appendEncodedPath(@NonNull String str) {
        Uri.Builder builder = this.uriBuilder;
        if (builder != null) {
            builder.appendEncodedPath(str);
        }
        return this;
    }

    @NonNull
    public UrlBuilder appendPath(@NonNull String str) {
        Uri.Builder builder = this.uriBuilder;
        if (builder != null) {
            builder.appendPath(str);
        }
        return this;
    }

    @NonNull
    public UrlBuilder appendQueryParameter(@NonNull String str, @NonNull String str2) {
        Uri.Builder builder = this.uriBuilder;
        if (builder != null) {
            builder.appendQueryParameter(str, str2);
        }
        return this;
    }

    @Nullable
    public Uri build() {
        Uri.Builder builder = this.uriBuilder;
        if (builder == null) {
            return null;
        }
        return builder.build();
    }
}

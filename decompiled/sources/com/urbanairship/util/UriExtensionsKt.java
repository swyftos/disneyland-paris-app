package com.urbanairship.util;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0002H\u0007\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"toURI", "Ljava/net/URI;", "Landroid/net/Uri;", "toURIOrNull", "toURL", "Ljava/net/URL;", "toURLOrNull", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UriExtensionsKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final URI toURI(@NotNull Uri uri) throws URISyntaxException {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return new URI(uri.toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final URL toURL(@NotNull Uri uri) throws MalformedURLException {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return new URL(uri.toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final URI toURIOrNull(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        try {
            return toURI(uri);
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final URL toURLOrNull(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        try {
            return toURL(uri);
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}

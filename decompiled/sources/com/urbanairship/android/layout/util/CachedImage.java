package com.urbanairship.android.layout.util;

import android.util.Size;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/android/layout/util/CachedImage;", "", "path", "", TCEventPropertiesNames.TCP_SIZE, "Landroid/util/Size;", "(Ljava/lang/String;Landroid/util/Size;)V", "getPath", "()Ljava/lang/String;", "getSize", "()Landroid/util/Size;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class CachedImage {
    private final String path;
    private final Size size;

    public static /* synthetic */ CachedImage copy$default(CachedImage cachedImage, String str, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cachedImage.path;
        }
        if ((i & 2) != 0) {
            size = cachedImage.size;
        }
        return cachedImage.copy(str, size);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    @NotNull
    public final CachedImage copy(@NotNull String path, @Nullable Size size) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new CachedImage(path, size);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CachedImage)) {
            return false;
        }
        CachedImage cachedImage = (CachedImage) other;
        return Intrinsics.areEqual(this.path, cachedImage.path) && Intrinsics.areEqual(this.size, cachedImage.size);
    }

    public int hashCode() {
        int iHashCode = this.path.hashCode() * 31;
        Size size = this.size;
        return iHashCode + (size == null ? 0 : size.hashCode());
    }

    @NotNull
    public String toString() {
        return "CachedImage(path=" + this.path + ", size=" + this.size + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public CachedImage(@NotNull String path, @Nullable Size size) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.size = size;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final Size getSize() {
        return this.size;
    }
}

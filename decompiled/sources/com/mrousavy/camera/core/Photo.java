package com.mrousavy.camera.core;

import com.mrousavy.camera.core.types.Orientation;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/mrousavy/camera/core/Photo;", "", "path", "", "width", "", "height", "orientation", "Lcom/mrousavy/camera/core/types/Orientation;", "isMirrored", "", "<init>", "(Ljava/lang/String;IILcom/mrousavy/camera/core/types/Orientation;Z)V", "getPath", "()Ljava/lang/String;", "getWidth", "()I", "getHeight", "getOrientation", "()Lcom/mrousavy/camera/core/types/Orientation;", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Photo {
    private final int height;
    private final boolean isMirrored;
    private final Orientation orientation;
    private final String path;
    private final int width;

    public static /* synthetic */ Photo copy$default(Photo photo, String str, int i, int i2, Orientation orientation, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = photo.path;
        }
        if ((i3 & 2) != 0) {
            i = photo.width;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = photo.height;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            orientation = photo.orientation;
        }
        Orientation orientation2 = orientation;
        if ((i3 & 16) != 0) {
            z = photo.isMirrored;
        }
        return photo.copy(str, i4, i5, orientation2, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsMirrored() {
        return this.isMirrored;
    }

    @NotNull
    public final Photo copy(@NotNull String path, int width, int height, @NotNull Orientation orientation, boolean isMirrored) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return new Photo(path, width, height, orientation, isMirrored);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Photo)) {
            return false;
        }
        Photo photo = (Photo) other;
        return Intrinsics.areEqual(this.path, photo.path) && this.width == photo.width && this.height == photo.height && this.orientation == photo.orientation && this.isMirrored == photo.isMirrored;
    }

    public int hashCode() {
        return (((((((this.path.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + this.orientation.hashCode()) * 31) + Boolean.hashCode(this.isMirrored);
    }

    @NotNull
    public String toString() {
        return "Photo(path=" + this.path + ", width=" + this.width + ", height=" + this.height + ", orientation=" + this.orientation + ", isMirrored=" + this.isMirrored + ")";
    }

    public Photo(@NotNull String path, int i, int i2, @NotNull Orientation orientation, boolean z) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.path = path;
        this.width = i;
        this.height = i2;
        this.orientation = orientation;
        this.isMirrored = z;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isMirrored() {
        return this.isMirrored;
    }
}

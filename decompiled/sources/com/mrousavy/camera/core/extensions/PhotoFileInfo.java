package com.mrousavy.camera.core.extensions;

import androidx.camera.core.ImageCapture;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/mrousavy/camera/core/extensions/PhotoFileInfo;", "", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Ljava/net/URI;", "metadata", "Landroidx/camera/core/ImageCapture$Metadata;", "<init>", "(Ljava/net/URI;Landroidx/camera/core/ImageCapture$Metadata;)V", "getUri", "()Ljava/net/URI;", "getMetadata", "()Landroidx/camera/core/ImageCapture$Metadata;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PhotoFileInfo {
    private final ImageCapture.Metadata metadata;
    private final URI uri;

    public static /* synthetic */ PhotoFileInfo copy$default(PhotoFileInfo photoFileInfo, URI uri, ImageCapture.Metadata metadata, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = photoFileInfo.uri;
        }
        if ((i & 2) != 0) {
            metadata = photoFileInfo.metadata;
        }
        return photoFileInfo.copy(uri, metadata);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final URI getUri() {
        return this.uri;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ImageCapture.Metadata getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final PhotoFileInfo copy(@NotNull URI uri, @NotNull ImageCapture.Metadata metadata) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new PhotoFileInfo(uri, metadata);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhotoFileInfo)) {
            return false;
        }
        PhotoFileInfo photoFileInfo = (PhotoFileInfo) other;
        return Intrinsics.areEqual(this.uri, photoFileInfo.uri) && Intrinsics.areEqual(this.metadata, photoFileInfo.metadata);
    }

    public int hashCode() {
        return (this.uri.hashCode() * 31) + this.metadata.hashCode();
    }

    @NotNull
    public String toString() {
        return "PhotoFileInfo(uri=" + this.uri + ", metadata=" + this.metadata + ")";
    }

    public PhotoFileInfo(@NotNull URI uri, @NotNull ImageCapture.Metadata metadata) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.uri = uri;
        this.metadata = metadata;
    }

    @NotNull
    public final ImageCapture.Metadata getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final URI getUri() {
        return this.uri;
    }
}

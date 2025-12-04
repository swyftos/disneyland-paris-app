package com.mrousavy.camera.core.types;

import android.util.Size;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/mrousavy/camera/core/types/Video;", "", "path", "", "durationMs", "", TCEventPropertiesNames.TCP_SIZE, "Landroid/util/Size;", "<init>", "(Ljava/lang/String;JLandroid/util/Size;)V", "getPath", "()Ljava/lang/String;", "getDurationMs", "()J", "getSize", "()Landroid/util/Size;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Video {
    private final long durationMs;
    private final String path;
    private final Size size;

    public static /* synthetic */ Video copy$default(Video video, String str, long j, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            str = video.path;
        }
        if ((i & 2) != 0) {
            j = video.durationMs;
        }
        if ((i & 4) != 0) {
            size = video.size;
        }
        return video.copy(str, j, size);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    @NotNull
    public final Video copy(@NotNull String path, long durationMs, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(size, "size");
        return new Video(path, durationMs, size);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Video)) {
            return false;
        }
        Video video = (Video) other;
        return Intrinsics.areEqual(this.path, video.path) && this.durationMs == video.durationMs && Intrinsics.areEqual(this.size, video.size);
    }

    public int hashCode() {
        return (((this.path.hashCode() * 31) + Long.hashCode(this.durationMs)) * 31) + this.size.hashCode();
    }

    @NotNull
    public String toString() {
        return "Video(path=" + this.path + ", durationMs=" + this.durationMs + ", size=" + this.size + ")";
    }

    public Video(@NotNull String path, long j, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(size, "size");
        this.path = path;
        this.durationMs = j;
        this.size = size;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final Size getSize() {
        return this.size;
    }
}

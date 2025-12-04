package com.brentvatne.exoplayer;

import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import com.brentvatne.common.api.BufferConfig;
import com.brentvatne.common.api.Source;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/brentvatne/exoplayer/ConfigurationUtils;", "", "<init>", "()V", "getLiveConfiguration", "Landroidx/media3/common/MediaItem$LiveConfiguration$Builder;", "bufferConfig", "Lcom/brentvatne/common/api/BufferConfig;", "buildCustomMetadata", "Landroidx/media3/common/MediaMetadata;", "metadata", "Lcom/brentvatne/common/api/Source$Metadata;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigurationUtils {

    @NotNull
    public static final ConfigurationUtils INSTANCE = new ConfigurationUtils();

    private ConfigurationUtils() {
    }

    @JvmStatic
    @NotNull
    public static final MediaItem.LiveConfiguration.Builder getLiveConfiguration(@NotNull BufferConfig bufferConfig) {
        Intrinsics.checkNotNullParameter(bufferConfig, "bufferConfig");
        MediaItem.LiveConfiguration.Builder builder = new MediaItem.LiveConfiguration.Builder();
        BufferConfig.Live live = bufferConfig.getLive();
        if (bufferConfig.getLive().getMaxOffsetMs() >= 0) {
            builder.setMaxOffsetMs(live.getMaxOffsetMs());
        }
        if (bufferConfig.getLive().getMaxPlaybackSpeed() >= BitmapDescriptorFactory.HUE_RED) {
            builder.setMaxPlaybackSpeed(live.getMaxPlaybackSpeed());
        }
        if (bufferConfig.getLive().getTargetOffsetMs() >= 0) {
            builder.setTargetOffsetMs(live.getTargetOffsetMs());
        }
        if (bufferConfig.getLive().getMinOffsetMs() >= 0) {
            builder.setMinOffsetMs(live.getMinOffsetMs());
        }
        if (bufferConfig.getLive().getMinPlaybackSpeed() >= BitmapDescriptorFactory.HUE_RED) {
            builder.setMinPlaybackSpeed(live.getMinPlaybackSpeed());
        }
        return builder;
    }

    @JvmStatic
    @Nullable
    public static final MediaMetadata buildCustomMetadata(@Nullable Source.Metadata metadata) {
        if (metadata != null) {
            return new MediaMetadata.Builder().setTitle(metadata.getTitle()).setSubtitle(metadata.getSubtitle()).setDescription(metadata.getDescription()).setArtist(metadata.getArtist()).setArtworkUri(metadata.getImageUri()).build();
        }
        return null;
    }
}

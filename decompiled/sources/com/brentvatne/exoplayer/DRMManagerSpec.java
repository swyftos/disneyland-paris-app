package com.brentvatne.exoplayer;

import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import com.brentvatne.common.api.DRMProps;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/brentvatne/exoplayer/DRMManagerSpec;", "", "buildDrmSessionManager", "Landroidx/media3/exoplayer/drm/DrmSessionManager;", "uuid", "Ljava/util/UUID;", "drmProps", "Lcom/brentvatne/common/api/DRMProps;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DRMManagerSpec {
    @Nullable
    DrmSessionManager buildDrmSessionManager(@NotNull UUID uuid, @NotNull DRMProps drmProps) throws UnsupportedDrmException;
}

package com.brentvatne.exoplayer;

import android.os.Binder;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/brentvatne/exoplayer/PlaybackServiceBinder;", "Landroid/os/Binder;", NotificationCompat.CATEGORY_SERVICE, "Lcom/brentvatne/exoplayer/VideoPlaybackService;", "<init>", "(Lcom/brentvatne/exoplayer/VideoPlaybackService;)V", "getService", "()Lcom/brentvatne/exoplayer/VideoPlaybackService;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PlaybackServiceBinder extends Binder {
    private final VideoPlaybackService service;

    public PlaybackServiceBinder(@NotNull VideoPlaybackService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
    }

    @NotNull
    public final VideoPlaybackService getService() {
        return this.service;
    }
}

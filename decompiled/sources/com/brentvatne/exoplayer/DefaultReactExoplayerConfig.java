package com.brentvatne.exoplayer;

import android.content.Context;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/brentvatne/exoplayer/DefaultReactExoplayerConfig;", "Lcom/brentvatne/exoplayer/ReactExoplayerConfig;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "bandWidthMeter", "Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "disableDisconnectError", "", "getDisableDisconnectError", "()Z", "setDisableDisconnectError", "(Z)V", "bandwidthMeter", "getBandwidthMeter", "()Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "buildLoadErrorHandlingPolicy", "Landroidx/media3/exoplayer/upstream/LoadErrorHandlingPolicy;", "minLoadRetryCount", "", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultReactExoplayerConfig implements ReactExoplayerConfig {
    private DefaultBandwidthMeter bandWidthMeter;
    private boolean disableDisconnectError;

    public DefaultReactExoplayerConfig(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DefaultBandwidthMeter defaultBandwidthMeterBuild = new DefaultBandwidthMeter.Builder(context).build();
        Intrinsics.checkNotNullExpressionValue(defaultBandwidthMeterBuild, "build(...)");
        this.bandWidthMeter = defaultBandwidthMeterBuild;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public boolean getDisableDisconnectError() {
        return this.disableDisconnectError;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public void setDisableDisconnectError(boolean z) {
        this.disableDisconnectError = z;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    @NotNull
    /* renamed from: getBandwidthMeter, reason: from getter */
    public DefaultBandwidthMeter getBandWidthMeter() {
        return this.bandWidthMeter;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    @NotNull
    public LoadErrorHandlingPolicy buildLoadErrorHandlingPolicy(int minLoadRetryCount) {
        if (getDisableDisconnectError()) {
            return new ReactExoplayerLoadErrorHandlingPolicy(minLoadRetryCount);
        }
        return new DefaultLoadErrorHandlingPolicy(minLoadRetryCount);
    }
}

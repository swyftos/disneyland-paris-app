package com.brentvatne.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import com.brentvatne.react.RNVPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/brentvatne/exoplayer/RNVExoplayerPlugin;", "Lcom/brentvatne/react/RNVPlugin;", "getDRMManager", "Lcom/brentvatne/exoplayer/DRMManagerSpec;", "onInstanceCreated", "", "id", "", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "onInstanceRemoved", "", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface RNVExoplayerPlugin extends RNVPlugin {
    @Nullable
    DRMManagerSpec getDRMManager();

    void onInstanceCreated(@NotNull String id, @NotNull ExoPlayer player);

    @Override // com.brentvatne.react.RNVPlugin
    void onInstanceCreated(@NotNull String id, @NotNull Object player);

    void onInstanceRemoved(@NotNull String id, @NotNull ExoPlayer player);

    @Override // com.brentvatne.react.RNVPlugin
    void onInstanceRemoved(@NotNull String id, @NotNull Object player);

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        public static DRMManagerSpec getDRMManager(@NotNull RNVExoplayerPlugin rNVExoplayerPlugin) {
            return null;
        }

        public static void onInstanceCreated(@NotNull RNVExoplayerPlugin rNVExoplayerPlugin, @NotNull String id, @NotNull Object player) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(player, "player");
            if (player instanceof ExoPlayer) {
                rNVExoplayerPlugin.onInstanceCreated(id, (ExoPlayer) player);
            }
        }

        public static void onInstanceRemoved(@NotNull RNVExoplayerPlugin rNVExoplayerPlugin, @NotNull String id, @NotNull Object player) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(player, "player");
            if (player instanceof ExoPlayer) {
                rNVExoplayerPlugin.onInstanceRemoved(id, (ExoPlayer) player);
            }
        }
    }
}

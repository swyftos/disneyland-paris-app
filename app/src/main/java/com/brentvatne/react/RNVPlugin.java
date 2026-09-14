package com.brentvatne.react;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&¨\u0006\b"}, m1836d2 = {"Lcom/brentvatne/react/RNVPlugin;", "", "onInstanceCreated", "", "id", "", "player", "onInstanceRemoved", "react-native-video_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface RNVPlugin {
    void onInstanceCreated(@NotNull String id, @NotNull Object player);

    void onInstanceRemoved(@NotNull String id, @NotNull Object player);
}

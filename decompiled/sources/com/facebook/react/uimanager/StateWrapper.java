package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000bH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/StateWrapper;", "", "stateDataMapBuffer", "Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer;", "getStateDataMapBuffer", "()Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer;", "stateData", "Lcom/facebook/react/bridge/ReadableNativeMap;", "getStateData", "()Lcom/facebook/react/bridge/ReadableNativeMap;", "updateState", "", "map", "Lcom/facebook/react/bridge/WritableMap;", "destroyState", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface StateWrapper {
    void destroyState();

    @Nullable
    ReadableNativeMap getStateData();

    @Nullable
    ReadableMapBuffer getStateDataMapBuffer();

    void updateState(@NotNull WritableMap map);
}

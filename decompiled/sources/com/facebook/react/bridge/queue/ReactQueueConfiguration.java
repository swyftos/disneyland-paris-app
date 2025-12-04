package com.facebook.react.bridge.queue;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/bridge/queue/ReactQueueConfiguration;", "", "getUIQueueThread", "Lcom/facebook/react/bridge/queue/MessageQueueThread;", "getNativeModulesQueueThread", "getJSQueueThread", "destroy", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ReactQueueConfiguration {
    void destroy();

    @NotNull
    MessageQueueThread getJSQueueThread();

    @NotNull
    MessageQueueThread getNativeModulesQueueThread();

    @NotNull
    MessageQueueThread getUIQueueThread();
}

package com.swmansion.worklets;

import com.facebook.proguard.annotations.DoNotStrip;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
public class WorkletsMessageQueueThread extends WorkletsMessageQueueThreadBase {
    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public boolean runOnQueue(Runnable runnable) {
        return this.messageQueueThread.runOnQueue(runnable);
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public boolean isIdle() {
        return this.messageQueueThread.isIdle();
    }
}

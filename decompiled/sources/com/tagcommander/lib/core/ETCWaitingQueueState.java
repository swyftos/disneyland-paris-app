package com.tagcommander.lib.core;

/* loaded from: classes4.dex */
enum ETCWaitingQueueState {
    WAITING(1),
    EXECUTING(2),
    OFFLINE(3);

    private final int value;

    ETCWaitingQueueState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}

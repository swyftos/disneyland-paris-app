package com.tagcommander.lib.core;

/* loaded from: classes4.dex */
public enum ETCConsentState {
    WAITING_FOR_CONSENT(0),
    ENABLED(1),
    DISABLED(2);

    private final int value;

    ETCConsentState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}

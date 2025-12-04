package com.tagcommander.lib.core;

/* loaded from: classes4.dex */
public enum ETCConsentBehaviour {
    PB_DEFAULT_BEHAVIOUR(1),
    PB_ALWAYS_ENABLED(2),
    PB_DISABLED_BY_DEFAULT(3);

    private final int value;

    ETCConsentBehaviour(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}

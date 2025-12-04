package com.tagcommander.lib.serverside;

/* loaded from: classes4.dex */
public enum ETCApplicationState {
    FOREGROUND(1),
    BACKGROUND(2);

    private final int value;

    ETCApplicationState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}

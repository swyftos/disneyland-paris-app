package com.swmansion.reanimated.keyboard;

/* loaded from: classes4.dex */
public enum KeyboardState {
    UNKNOWN(0),
    OPENING(1),
    OPEN(2),
    CLOSING(3),
    CLOSED(4);

    private final int mValue;

    KeyboardState(int i) {
        this.mValue = i;
    }

    public int asInt() {
        return this.mValue;
    }
}

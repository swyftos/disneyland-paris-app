package com.allegion.core.enums;

/* loaded from: classes2.dex */
public enum ProtocolBlockType {
    ENGAGE(1),
    SENSE(2),
    SAPPHIRE(3),
    SIG_AUTH(4),
    IOT_NATIVE(5);

    private final int value;

    ProtocolBlockType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}

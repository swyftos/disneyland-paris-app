package com.contentsquare.rn.externalbridge;

/* loaded from: classes3.dex */
enum XpfInterfaceChannel {
    REGISTER_EXTERNAL_BRIDGE("registerExternalBridge"),
    UNREGISTER_EXTERNAL_BRIDGE("unregisterExternalBridge");

    private final String value;

    XpfInterfaceChannel(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}

package com.contentsquare.rn.externalbridge;

import com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface;

/* loaded from: classes3.dex */
public interface XpfInterfaceBridge {
    void registerExternalBridge(ExternalBridgeInterface externalBridgeInterface);

    void unregisterExternalBridge(ExternalBridgeInterface externalBridgeInterface);

    public static class Factory {
        public static XpfInterfaceBridge defaultInstance() {
            return new XpfInterfaceBridgeImpl();
        }
    }
}

package com.contentsquare.p025rn.externalbridge;

import android.util.Log;
import com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface;
import com.contentsquare.android.api.bridge.xpf.XpfInterface;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
class XpfInterfaceBridgeImpl implements XpfInterfaceBridge {
    private final String objectInstanceName = "INSTANCE";

    XpfInterfaceBridgeImpl() {
    }

    @Override // com.contentsquare.p025rn.externalbridge.XpfInterfaceBridge
    public void registerExternalBridge(ExternalBridgeInterface externalBridgeInterface) {
        try {
            Object obj = XpfInterface.class.getDeclaredField("INSTANCE").get(null);
            Method declaredMethod = XpfInterface.class.getDeclaredMethod(XpfInterfaceChannel.REGISTER_EXTERNAL_BRIDGE.getValue(), ExternalBridgeInterface.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, externalBridgeInterface);
        } catch (Exception e) {
            Log.e("CSLIB", "Error invoking method", e);
        }
    }

    @Override // com.contentsquare.p025rn.externalbridge.XpfInterfaceBridge
    public void unregisterExternalBridge(ExternalBridgeInterface externalBridgeInterface) {
        try {
            XpfInterface.class.getDeclaredMethod(XpfInterfaceChannel.UNREGISTER_EXTERNAL_BRIDGE.getValue(), ExternalBridgeInterface.class).invoke(XpfInterface.class.getDeclaredField("INSTANCE").get(null), externalBridgeInterface);
        } catch (Exception e) {
            Log.e("CSLIB", "Error invoking method", e);
        }
    }
}

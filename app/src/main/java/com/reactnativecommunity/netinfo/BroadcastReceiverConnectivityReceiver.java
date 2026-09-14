package com.reactnativecommunity.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;

/* JADX INFO: loaded from: classes4.dex */
public class BroadcastReceiverConnectivityReceiver extends ConnectivityReceiver {
    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    private final ConnectivityBroadcastReceiver mConnectivityBroadcastReceiver;

    public BroadcastReceiverConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mConnectivityBroadcastReceiver = new ConnectivityBroadcastReceiver();
    }

    @Override // com.reactnativecommunity.netinfo.ConnectivityReceiver
    public void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CONNECTIVITY_ACTION);
        NetInfoUtils.compatRegisterReceiver(getReactContext(), this.mConnectivityBroadcastReceiver, intentFilter, false);
        this.mConnectivityBroadcastReceiver.setRegistered(true);
        updateAndSendConnectionType();
    }

    @Override // com.reactnativecommunity.netinfo.ConnectivityReceiver
    public void unregister() {
        if (this.mConnectivityBroadcastReceiver.isRegistered()) {
            getReactContext().unregisterReceiver(this.mConnectivityBroadcastReceiver);
            this.mConnectivityBroadcastReceiver.setRegistered(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0043 A[Catch: SecurityException -> 0x004d, TryCatch #0 {SecurityException -> 0x004d, blocks: (B:3:0x0004, B:5:0x000e, B:8:0x0015, B:23:0x0034, B:24:0x0037, B:25:0x003a, B:26:0x003d, B:27:0x0040, B:28:0x0043, B:29:0x004a), top: B:35:0x0004 }] */
    public void updateAndSendConnectionType() {
        ConnectionType connectionType = ConnectionType.UNKNOWN;
        CellularGeneration cellularGenerationFromNetworkInfo = null;
        boolean zIsConnected = false;
        try {
            NetworkInfo activeNetworkInfo = getConnectivityManager().getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                connectionType = ConnectionType.NONE;
            } else {
                zIsConnected = activeNetworkInfo.isConnected();
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    connectionType = ConnectionType.CELLULAR;
                    cellularGenerationFromNetworkInfo = CellularGeneration.fromNetworkInfo(activeNetworkInfo);
                } else if (type == 1) {
                    connectionType = ConnectionType.WIFI;
                } else if (type == 4) {
                    connectionType = ConnectionType.CELLULAR;
                    cellularGenerationFromNetworkInfo = CellularGeneration.fromNetworkInfo(activeNetworkInfo);
                } else if (type == 9) {
                    connectionType = ConnectionType.ETHERNET;
                } else if (type == 17) {
                    connectionType = ConnectionType.VPN;
                } else if (type == 6) {
                    connectionType = ConnectionType.WIMAX;
                } else if (type == 7) {
                    connectionType = ConnectionType.BLUETOOTH;
                }
            }
        } catch (SecurityException unused) {
            connectionType = ConnectionType.UNKNOWN;
        }
        updateConnectivity(connectionType, cellularGenerationFromNetworkInfo, zIsConnected);
    }

    private class ConnectivityBroadcastReceiver extends BroadcastReceiver {
        private boolean isRegistered;

        private ConnectivityBroadcastReceiver() {
            this.isRegistered = false;
        }

        public void setRegistered(boolean z) {
            this.isRegistered = z;
        }

        public boolean isRegistered() {
            return this.isRegistered;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null || !action.equals(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION)) {
                return;
            }
            BroadcastReceiverConnectivityReceiver.this.updateAndSendConnectionType();
        }
    }
}

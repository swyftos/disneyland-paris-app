package com.reactnativecommunity.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.react.bridge.ReactApplicationContext;

/* loaded from: classes4.dex */
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
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043 A[Catch: SecurityException -> 0x004d, TryCatch #0 {SecurityException -> 0x004d, blocks: (B:3:0x0004, B:5:0x000e, B:8:0x0015, B:23:0x0034, B:24:0x0037, B:25:0x003a, B:26:0x003d, B:27:0x0040, B:28:0x0043, B:29:0x004a), top: B:35:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateAndSendConnectionType() {
        /*
            r6 = this;
            com.reactnativecommunity.netinfo.types.ConnectionType r0 = com.reactnativecommunity.netinfo.types.ConnectionType.UNKNOWN
            r1 = 0
            r2 = 0
            android.net.ConnectivityManager r3 = r6.getConnectivityManager()     // Catch: java.lang.SecurityException -> L4d
            android.net.NetworkInfo r3 = r3.getActiveNetworkInfo()     // Catch: java.lang.SecurityException -> L4d
            if (r3 == 0) goto L4a
            boolean r4 = r3.isConnected()     // Catch: java.lang.SecurityException -> L4d
            if (r4 != 0) goto L15
            goto L4a
        L15:
            boolean r2 = r3.isConnected()     // Catch: java.lang.SecurityException -> L4d
            int r4 = r3.getType()     // Catch: java.lang.SecurityException -> L4d
            if (r4 == 0) goto L43
            r5 = 1
            if (r4 == r5) goto L40
            r5 = 4
            if (r4 == r5) goto L43
            r3 = 9
            if (r4 == r3) goto L3d
            r3 = 17
            if (r4 == r3) goto L3a
            r3 = 6
            if (r4 == r3) goto L37
            r3 = 7
            if (r4 == r3) goto L34
            goto L4f
        L34:
            com.reactnativecommunity.netinfo.types.ConnectionType r0 = com.reactnativecommunity.netinfo.types.ConnectionType.BLUETOOTH     // Catch: java.lang.SecurityException -> L4d
            goto L4f
        L37:
            com.reactnativecommunity.netinfo.types.ConnectionType r0 = com.reactnativecommunity.netinfo.types.ConnectionType.WIMAX     // Catch: java.lang.SecurityException -> L4d
            goto L4f
        L3a:
            com.reactnativecommunity.netinfo.types.ConnectionType r0 = com.reactnativecommunity.netinfo.types.ConnectionType.VPN     // Catch: java.lang.SecurityException -> L4d
            goto L4f
        L3d:
            com.reactnativecommunity.netinfo.types.ConnectionType r0 = com.reactnativecommunity.netinfo.types.ConnectionType.ETHERNET     // Catch: java.lang.SecurityException -> L4d
            goto L4f
        L40:
            com.reactnativecommunity.netinfo.types.ConnectionType r0 = com.reactnativecommunity.netinfo.types.ConnectionType.WIFI     // Catch: java.lang.SecurityException -> L4d
            goto L4f
        L43:
            com.reactnativecommunity.netinfo.types.ConnectionType r0 = com.reactnativecommunity.netinfo.types.ConnectionType.CELLULAR     // Catch: java.lang.SecurityException -> L4d
            com.reactnativecommunity.netinfo.types.CellularGeneration r1 = com.reactnativecommunity.netinfo.types.CellularGeneration.fromNetworkInfo(r3)     // Catch: java.lang.SecurityException -> L4d
            goto L4f
        L4a:
            com.reactnativecommunity.netinfo.types.ConnectionType r0 = com.reactnativecommunity.netinfo.types.ConnectionType.NONE     // Catch: java.lang.SecurityException -> L4d
            goto L4f
        L4d:
            com.reactnativecommunity.netinfo.types.ConnectionType r0 = com.reactnativecommunity.netinfo.types.ConnectionType.UNKNOWN
        L4f:
            r6.updateConnectivity(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver.updateAndSendConnectionType():void");
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

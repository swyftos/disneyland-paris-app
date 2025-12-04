package com.tagcommander.lib.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.tagcommander.lib.core.TCEventManager;

/* loaded from: classes4.dex */
public class TCNetworkReceiver extends BroadcastReceiver implements TCEventManager.TCServerSideStateListener {
    private final Context appContext;
    private String connectionType;
    private Boolean forceOffline;
    private ConnectivityManager.NetworkCallback networkCallback;
    Boolean oldReachability;
    private Boolean registered;

    public TCNetworkReceiver(Context context) {
        Boolean bool = Boolean.FALSE;
        this.forceOffline = bool;
        this.networkCallback = null;
        this.appContext = context.getApplicationContext();
        TCEventManager.getInstance().registerServerSideStateListener(this);
        setOldReachability(bool);
        this.registered = bool;
        this.connectionType = "Connection Type Unavailable";
    }

    public void forceOffline(Boolean bool) {
        this.forceOffline = bool;
    }

    public void registerReceiver() {
        try {
            if (this.registered.booleanValue()) {
                return;
            }
            registerNetworkCallbacks();
            this.registered = Boolean.TRUE;
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("Unable to register Network Receiver : " + e.getMessage(), 6);
        }
    }

    private void registerNetworkCallbacks() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.appContext.getSystemService("connectivity");
        if (this.networkCallback == null) {
            this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.tagcommander.lib.core.TCNetworkReceiver.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    NetworkCapabilities networkCapabilities = ((ConnectivityManager) TCNetworkReceiver.this.appContext.getSystemService("connectivity")).getNetworkCapabilities(network);
                    if (networkCapabilities != null) {
                        TCNetworkReceiver.this.fillTCNetwork(networkCapabilities);
                        TCNetworkReceiver tCNetworkReceiver = TCNetworkReceiver.this;
                        tCNetworkReceiver.treatConnectivity(true, tCNetworkReceiver.getNetworkTypeName(networkCapabilities));
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    TCNetworkReceiver.this.fillTCNetwork(((ConnectivityManager) TCNetworkReceiver.this.appContext.getSystemService("connectivity")).getNetworkCapabilities(network));
                    TCNetworkReceiver.this.treatConnectivity(false, "");
                }
            };
        }
        connectivityManager.registerDefaultNetworkCallback(this.networkCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillTCNetwork(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            TCNetwork.getInstance().bluetooth = Boolean.valueOf(networkCapabilities.hasTransport(2));
            TCNetwork.getInstance().wifi = Boolean.valueOf(networkCapabilities.hasTransport(1));
            TCNetwork.getInstance().cellular = Boolean.valueOf(networkCapabilities.hasTransport(0));
            if (!TCNetwork.getInstance().cellular.booleanValue()) {
                TCNetwork.getInstance().carrier = "";
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) this.appContext.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            TCNetwork.getInstance().carrier = telephonyManager.getNetworkOperatorName();
            return;
        }
        TCNetwork tCNetwork = TCNetwork.getInstance();
        Boolean bool = Boolean.FALSE;
        tCNetwork.bluetooth = bool;
        TCNetwork.getInstance().wifi = bool;
        TCNetwork.getInstance().cellular = bool;
        TCNetwork.getInstance().carrier = "";
    }

    private void fillTCNetwork(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            TCNetwork.getInstance().bluetooth = Boolean.valueOf(networkInfo.getType() == 7);
            TCNetwork.getInstance().wifi = Boolean.valueOf(networkInfo.getType() == 1);
            TCNetwork.getInstance().cellular = Boolean.valueOf(networkInfo.getType() == 0);
            if (!TCNetwork.getInstance().cellular.booleanValue()) {
                TCNetwork.getInstance().carrier = "";
                return;
            } else {
                TCNetwork.getInstance().carrier = ((TelephonyManager) this.appContext.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkOperatorName();
                return;
            }
        }
        TCNetwork tCNetwork = TCNetwork.getInstance();
        Boolean bool = Boolean.FALSE;
        tCNetwork.bluetooth = bool;
        TCNetwork.getInstance().wifi = bool;
        TCNetwork.getInstance().cellular = bool;
        TCNetwork.getInstance().carrier = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getNetworkTypeName(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            if (networkCapabilities.hasTransport(1)) {
                return "WIFI";
            }
            if (networkCapabilities.hasTransport(0)) {
                return "MOBILE";
            }
            return "";
        }
        return "";
    }

    public void unregisterReceiver() {
        if (this.registered.booleanValue()) {
            ((ConnectivityManager) this.appContext.getSystemService("connectivity")).unregisterNetworkCallback(this.networkCallback);
            this.registered = Boolean.FALSE;
        }
    }

    private void sendInternetUpNotification() {
        TCEventManager.getInstance().callInternetUp();
    }

    private void sendInternetDownNotification() {
        TCEventManager.getInstance().callInternetDown();
    }

    public void treatConnectivity(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            treatConnectivity(networkInfo.isConnected(), networkInfo.getTypeName());
        } else {
            treatConnectivity(false, "");
        }
    }

    public void treatConnectivity(boolean z, String str) {
        if (str != null && !str.equals("")) {
            this.connectionType = str;
        }
        if (z) {
            if (this.oldReachability.booleanValue()) {
                return;
            }
            sendInternetUpNotification();
            setOldReachability(Boolean.TRUE);
            return;
        }
        if (this.oldReachability.booleanValue()) {
            sendInternetDownNotification();
            setOldReachability(Boolean.FALSE);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        fillTCNetwork(activeNetworkInfo);
        treatConnectivity(activeNetworkInfo);
    }

    public String getConnectionType() {
        return this.connectionType;
    }

    public void setOldReachability(Boolean bool) {
        this.oldReachability = bool;
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCServerSideStateListener
    public void onEnablingTheServerSide() {
        registerReceiver();
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCServerSideStateListener
    public void onStoppingTheServerSide() {
        unregisterReceiver();
    }
}

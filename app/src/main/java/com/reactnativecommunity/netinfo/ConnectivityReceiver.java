package com.reactnativecommunity.netinfo;

import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;
import javax.annotation.Nullable;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ConnectivityReceiver {
    private final ConnectivityManager mConnectivityManager;
    private Boolean mIsInternetReachableOverride;
    private final ReactApplicationContext mReactContext;
    private final TelephonyManager mTelephonyManager;
    private final WifiManager mWifiManager;
    public boolean hasListener = false;
    private ConnectionType mConnectionType = ConnectionType.UNKNOWN;
    private CellularGeneration mCellularGeneration = null;
    private boolean mIsInternetReachable = false;

    public abstract void register();

    public abstract void unregister();

    private static String getSubnet(InetAddress inetAddress) {
        short networkPrefixLength;
        for (InterfaceAddress interfaceAddress : NetworkInterface.getByInetAddress(inetAddress).getInterfaceAddresses()) {
            if (interfaceAddress.getAddress().getAddress().length == 4) {
                networkPrefixLength = interfaceAddress.getNetworkPrefixLength();
                int i = (-1) << (32 - networkPrefixLength);
                return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((i >> 24) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf(i & 255));
            }
        }
        networkPrefixLength = 0;
        int i2 = (-1) << (32 - networkPrefixLength);
        return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((i2 >> 24) & 255), Integer.valueOf((i2 >> 16) & 255), Integer.valueOf((i2 >> 8) & 255), Integer.valueOf(i2 & 255));
    }

    ConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
        this.mConnectivityManager = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
        this.mWifiManager = (WifiManager) reactApplicationContext.getApplicationContext().getSystemService("wifi");
        this.mTelephonyManager = (TelephonyManager) reactApplicationContext.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
    }

    public void getCurrentState(@Nullable String str, Promise promise) {
        promise.resolve(createConnectivityEventMap(str));
    }

    public void setIsInternetReachableOverride(boolean z) {
        this.mIsInternetReachableOverride = Boolean.valueOf(z);
        updateConnectivity(this.mConnectionType, this.mCellularGeneration, this.mIsInternetReachable);
    }

    public void clearIsInternetReachableOverride() {
        this.mIsInternetReachableOverride = null;
    }

    ReactApplicationContext getReactContext() {
        return this.mReactContext;
    }

    ConnectivityManager getConnectivityManager() {
        return this.mConnectivityManager;
    }

    void updateConnectivity(ConnectionType connectionType, CellularGeneration cellularGeneration, boolean z) {
        Boolean bool = this.mIsInternetReachableOverride;
        if (bool != null) {
            z = bool.booleanValue();
        }
        boolean z2 = connectionType != this.mConnectionType;
        boolean z3 = cellularGeneration != this.mCellularGeneration;
        boolean z4 = z != this.mIsInternetReachable;
        if (z2 || z3 || z4) {
            this.mConnectionType = connectionType;
            this.mCellularGeneration = cellularGeneration;
            this.mIsInternetReachable = z;
            if (this.hasListener) {
                sendConnectivityChangedEvent();
            }
        }
    }

    protected void sendConnectivityChangedEvent() {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("netInfo.networkStatusDidChange", createConnectivityEventMap(null));
    }

    protected WritableMap createConnectivityEventMap(@Nullable String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        boolean z = false;
        if (NetInfoUtils.isAccessWifiStatePermissionGranted(getReactContext())) {
            WifiManager wifiManager = this.mWifiManager;
            writableMapCreateMap.putBoolean("isWifiEnabled", wifiManager != null ? wifiManager.isWifiEnabled() : false);
        }
        writableMapCreateMap.putString("type", str != null ? str : this.mConnectionType.label);
        boolean z2 = (this.mConnectionType.equals(ConnectionType.NONE) || this.mConnectionType.equals(ConnectionType.UNKNOWN)) ? false : true;
        writableMapCreateMap.putBoolean("isConnected", z2);
        if (this.mIsInternetReachable && (str == null || str.equals(this.mConnectionType.label))) {
            z = true;
        }
        writableMapCreateMap.putBoolean("isInternetReachable", z);
        if (str == null) {
            str = this.mConnectionType.label;
        }
        WritableMap writableMapCreateDetailsMap = createDetailsMap(str);
        if (z2) {
            writableMapCreateDetailsMap.putBoolean("isConnectionExpensive", getConnectivityManager() != null ? getConnectivityManager().isActiveNetworkMetered() : true);
        }
        writableMapCreateMap.putMap(ErrorBundle.DETAIL_ENTRY, writableMapCreateDetailsMap);
        return writableMapCreateMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private WritableMap createDetailsMap(String str) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        WritableMap writableMapCreateMap = Arguments.createMap();
        str.hashCode();
        switch (str) {
            case "ethernet":
                try {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    while (networkInterfaces.hasMoreElements()) {
                        Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                                writableMapCreateMap.putString("ipAddress", inetAddressNextElement.getHostAddress());
                                writableMapCreateMap.putString("subnet", getSubnet(inetAddressNextElement));
                                return writableMapCreateMap;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return writableMapCreateMap;
            case "cellular":
                CellularGeneration cellularGeneration = this.mCellularGeneration;
                if (cellularGeneration != null) {
                    writableMapCreateMap.putString("cellularGeneration", cellularGeneration.label);
                }
                String networkOperatorName = this.mTelephonyManager.getNetworkOperatorName();
                if (networkOperatorName != null) {
                    writableMapCreateMap.putString("carrier", networkOperatorName);
                }
                return writableMapCreateMap;
            case "wifi":
                if (NetInfoUtils.isAccessWifiStatePermissionGranted(getReactContext()) && (wifiManager = this.mWifiManager) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    try {
                        String ssid = connectionInfo.getSSID();
                        if (ssid != null && !ssid.contains("<unknown ssid>")) {
                            writableMapCreateMap.putString("ssid", ssid.replace("\"", ""));
                        }
                        break;
                    } catch (Exception unused) {
                    }
                    try {
                        String bssid = connectionInfo.getBSSID();
                        if (bssid != null) {
                            writableMapCreateMap.putString("bssid", bssid);
                        }
                        break;
                    } catch (Exception unused2) {
                    }
                    try {
                        writableMapCreateMap.putInt("strength", WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 100));
                        break;
                    } catch (Exception unused3) {
                    }
                    try {
                        writableMapCreateMap.putInt("frequency", connectionInfo.getFrequency());
                        break;
                    } catch (Exception unused4) {
                    }
                    try {
                        byte[] byteArray = BigInteger.valueOf(connectionInfo.getIpAddress()).toByteArray();
                        NetInfoUtils.reverseByteArray(byteArray);
                        writableMapCreateMap.putString("ipAddress", InetAddress.getByAddress(byteArray).getHostAddress());
                        break;
                    } catch (Exception unused5) {
                    }
                    try {
                        byte[] byteArray2 = BigInteger.valueOf(connectionInfo.getIpAddress()).toByteArray();
                        NetInfoUtils.reverseByteArray(byteArray2);
                        writableMapCreateMap.putString("subnet", getSubnet(InetAddress.getByAddress(byteArray2)));
                        break;
                    } catch (Exception unused6) {
                    }
                    try {
                        writableMapCreateMap.putInt("linkSpeed", connectionInfo.getLinkSpeed());
                        break;
                    } catch (Exception unused7) {
                    }
                    try {
                        writableMapCreateMap.putInt("rxLinkSpeed", connectionInfo.getRxLinkSpeedMbps());
                        break;
                    } catch (Exception unused8) {
                    }
                    try {
                        writableMapCreateMap.putInt("txLinkSpeed", connectionInfo.getTxLinkSpeedMbps());
                        break;
                    } catch (Exception unused9) {
                    }
                }
                return writableMapCreateMap;
            default:
                return writableMapCreateMap;
        }
    }
}

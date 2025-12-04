package com.pusherman.networkinfo;

import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class RNNetworkInfo extends ReactContextBaseJavaModule {
    public static List<String> DSLITE_LIST = Arrays.asList("192.0.0.0", "192.0.0.1", "192.0.0.2", "192.0.0.3", "192.0.0.4", "192.0.0.5", "192.0.0.6", "192.0.0.7");
    public static final String TAG = "RNNetworkInfo";
    WifiManager wifi;

    public RNNetworkInfo(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.wifi = (WifiManager) reactApplicationContext.getApplicationContext().getSystemService("wifi");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void getSSID(final Promise promise) throws Exception {
        new Thread(new Runnable() { // from class: com.pusherman.networkinfo.RNNetworkInfo.1
            @Override // java.lang.Runnable
            public void run() {
                String ssid;
                try {
                    WifiInfo connectionInfo = RNNetworkInfo.this.wifi.getConnectionInfo();
                    if (connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        ssid = connectionInfo.getSSID();
                        if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
                            ssid = ssid.substring(1, ssid.length() - 1);
                        }
                    } else {
                        ssid = null;
                    }
                    promise.resolve(ssid);
                } catch (Exception unused) {
                    promise.resolve(null);
                }
            }
        }).start();
    }

    @ReactMethod
    public void getBSSID(final Promise promise) throws Exception {
        new Thread(new Runnable() { // from class: com.pusherman.networkinfo.RNNetworkInfo.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    promise.resolve(RNNetworkInfo.this.wifi.getConnectionInfo().getSupplicantState() == SupplicantState.COMPLETED ? RNNetworkInfo.this.wifi.getConnectionInfo().getBSSID() : null);
                } catch (Exception unused) {
                    promise.resolve(null);
                }
            }
        }).start();
    }

    @ReactMethod
    public void getBroadcast(final Promise promise) throws Exception {
        new Thread(new Runnable() { // from class: com.pusherman.networkinfo.RNNetworkInfo.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String string = null;
                    for (InterfaceAddress interfaceAddress : RNNetworkInfo.this.getInetAddresses()) {
                        if (!interfaceAddress.getAddress().isLoopbackAddress()) {
                            string = interfaceAddress.getBroadcast().toString();
                        }
                    }
                    promise.resolve(string);
                } catch (Exception unused) {
                    promise.resolve(null);
                }
            }
        }).start();
    }

    @ReactMethod
    public void getIPAddress(final Promise promise) throws Exception {
        new Thread(new Runnable() { // from class: com.pusherman.networkinfo.RNNetworkInfo.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str = null;
                    for (InterfaceAddress interfaceAddress : RNNetworkInfo.this.getInetAddresses()) {
                        if (!interfaceAddress.getAddress().isLoopbackAddress()) {
                            String string = interfaceAddress.getAddress().getHostAddress().toString();
                            if (!RNNetworkInfo.this.inDSLITERange(string).booleanValue()) {
                                str = string;
                            }
                        }
                    }
                    promise.resolve(str);
                } catch (Exception unused) {
                    promise.resolve(null);
                }
            }
        }).start();
    }

    @ReactMethod
    public void getIPV4Address(final Promise promise) throws Exception {
        new Thread(new Runnable() { // from class: com.pusherman.networkinfo.RNNetworkInfo.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str = null;
                    for (InterfaceAddress interfaceAddress : RNNetworkInfo.this.getInetAddresses()) {
                        if (!interfaceAddress.getAddress().isLoopbackAddress() && (interfaceAddress.getAddress() instanceof Inet4Address)) {
                            String string = interfaceAddress.getAddress().getHostAddress().toString();
                            if (!RNNetworkInfo.this.inDSLITERange(string).booleanValue()) {
                                str = string;
                            }
                        }
                    }
                    promise.resolve(str);
                } catch (Exception unused) {
                    promise.resolve(null);
                }
            }
        }).start();
    }

    @ReactMethod
    public void getWIFIIPV4Address(final Promise promise) throws Exception {
        new Thread(new Runnable() { // from class: com.pusherman.networkinfo.RNNetworkInfo.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int ipAddress = RNNetworkInfo.this.wifi.getConnectionInfo().getIpAddress();
                    promise.resolve(String.format("%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)));
                } catch (Exception unused) {
                    promise.resolve(null);
                }
            }
        }).start();
    }

    @ReactMethod
    public void getSubnet(final Promise promise) throws Exception {
        new Thread(new Runnable() { // from class: com.pusherman.networkinfo.RNNetworkInfo.7
            @Override // java.lang.Runnable
            public void run() throws SocketException {
                try {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    while (networkInterfaces.hasMoreElements()) {
                        NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                        if (!networkInterfaceNextElement.isLoopback() && networkInterfaceNextElement.isUp()) {
                            Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                            for (InterfaceAddress interfaceAddress : networkInterfaceNextElement.getInterfaceAddresses()) {
                                if (!(inetAddresses.nextElement() instanceof Inet6Address)) {
                                    promise.resolve(RNNetworkInfo.this.intToIP(interfaceAddress.getNetworkPrefixLength()));
                                    return;
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                    promise.resolve("0.0.0.0");
                }
            }
        }).start();
    }

    @ReactMethod
    public void getGatewayIPAddress(final Promise promise) throws Exception {
        new Thread(new Runnable() { // from class: com.pusherman.networkinfo.RNNetworkInfo.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i = RNNetworkInfo.this.wifi.getDhcpInfo().gateway;
                    promise.resolve(String.format("%d.%d.%d.%d", Integer.valueOf(i & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 24) & 255)));
                } catch (Exception unused) {
                    promise.resolve(null);
                }
            }
        }).start();
    }

    @ReactMethod
    public void getFrequency(final Promise promise) throws Exception {
        new Thread(new Runnable() { // from class: com.pusherman.networkinfo.RNNetworkInfo.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    promise.resolve(Float.valueOf(RNNetworkInfo.this.wifi.getConnectionInfo().getFrequency()));
                } catch (Exception unused) {
                    promise.resolve(null);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String intToIP(int i) {
        String[] strArr = new String[4];
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "";
        strArr[3] = "";
        int i2 = 1;
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 0; i4 < 8; i4++) {
                if (i2 <= i) {
                    strArr[i3] = strArr[i3] + "1";
                } else {
                    strArr[i3] = strArr[i3] + "0";
                }
                i2++;
            }
        }
        return Integer.parseInt(strArr[0], 2) + InstructionFileId.DOT + Integer.parseInt(strArr[1], 2) + InstructionFileId.DOT + Integer.parseInt(strArr[2], 2) + InstructionFileId.DOT + Integer.parseInt(strArr[3], 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean inDSLITERange(String str) {
        return Boolean.valueOf(DSLITE_LIST.contains(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<InterfaceAddress> getInetAddresses() throws SocketException {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Iterator<InterfaceAddress> it = networkInterfaces.nextElement().getInterfaceAddresses().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return arrayList;
    }
}

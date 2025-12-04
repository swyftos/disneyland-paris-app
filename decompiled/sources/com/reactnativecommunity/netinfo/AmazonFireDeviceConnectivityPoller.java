package com.reactnativecommunity.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;

/* loaded from: classes4.dex */
public class AmazonFireDeviceConnectivityPoller {
    private final ConnectivityChangedCallback callback;
    private final Runnable checker;
    private final Context context;
    private Handler handler;
    private boolean pollerRunning = false;
    private final Receiver receiver;

    public interface ConnectivityChangedCallback {
        void onAmazonFireDeviceConnectivityChanged(boolean z);
    }

    AmazonFireDeviceConnectivityPoller(Context context, ConnectivityChangedCallback connectivityChangedCallback) {
        this.receiver = new Receiver();
        this.checker = new PollerTask();
        this.context = context;
        this.callback = connectivityChangedCallback;
    }

    public void register() {
        if (isFireOsDevice()) {
            registerReceiver();
            startPoller();
        }
    }

    public void unregister() {
        if (isFireOsDevice()) {
            stopPoller();
            unregisterReceiver();
        }
    }

    private boolean isFireOsDevice() {
        if (Build.MANUFACTURER.equals("Amazon")) {
            String str = Build.MODEL;
            if (str.startsWith("AF") || str.startsWith("KF")) {
                return true;
            }
        }
        return false;
    }

    private void registerReceiver() {
        if (this.receiver.registered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.amazon.tv.networkmonitor.INTERNET_DOWN");
        intentFilter.addAction("com.amazon.tv.networkmonitor.INTERNET_UP");
        NetInfoUtils.compatRegisterReceiver(this.context, this.receiver, intentFilter, false);
        this.receiver.registered = true;
    }

    private void startPoller() {
        if (this.pollerRunning) {
            return;
        }
        Handler handler = new Handler();
        this.handler = handler;
        this.pollerRunning = true;
        handler.post(this.checker);
    }

    private void unregisterReceiver() {
        Receiver receiver = this.receiver;
        if (receiver.registered) {
            this.context.unregisterReceiver(receiver);
            this.receiver.registered = false;
        }
    }

    private void stopPoller() {
        if (this.pollerRunning) {
            this.pollerRunning = false;
            this.handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
    }

    private class Receiver extends BroadcastReceiver {
        private Boolean lastIsConnected;
        boolean registered;

        private Receiver() {
            this.registered = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z;
            String action = intent == null ? null : intent.getAction();
            if ("com.amazon.tv.networkmonitor.INTERNET_DOWN".equals(action)) {
                z = false;
            } else if (!"com.amazon.tv.networkmonitor.INTERNET_UP".equals(action)) {
                return;
            } else {
                z = true;
            }
            Boolean bool = this.lastIsConnected;
            if (bool == null || bool.booleanValue() != z) {
                this.lastIsConnected = Boolean.valueOf(z);
                AmazonFireDeviceConnectivityPoller.this.callback.onAmazonFireDeviceConnectivityChanged(z);
            }
        }
    }

    private class PollerTask implements Runnable {
        private PollerTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AmazonFireDeviceConnectivityPoller.this.pollerRunning) {
                AmazonFireDeviceConnectivityPoller.this.context.sendBroadcast(new Intent("com.amazon.tv.networkmonitor.CONNECTIVITY_CHECK"));
                AmazonFireDeviceConnectivityPoller.this.handler.postDelayed(AmazonFireDeviceConnectivityPoller.this.checker, 10000L);
            }
        }
    }
}

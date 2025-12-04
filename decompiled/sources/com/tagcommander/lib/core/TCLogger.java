package com.tagcommander.lib.core;

import android.util.Log;
import com.tagcommander.lib.core.TCEventManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCLogger implements TCEventManager.TCConfigurationListener, TCEventManager.TCHTTPListener, TCEventManager.TCNetworkListener, TCEventManager.TCLocationListener, TCEventManager.TCLifecycleListener, TCEventManager.TCServerSideStateListener {
    private static volatile TCLogger INSTANCE;
    public Boolean logNotification = Boolean.FALSE;

    @Override // com.tagcommander.lib.core.TCEventManager.TCHTTPListener
    public void onHTTPRequest(String str, String str2, String str3) {
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCHTTPListener
    public void onHTTPRequestError(String str) {
    }

    private TCLogger() {
        TCEventManager tCEventManager = TCEventManager.getInstance();
        tCEventManager.registerConfigurationListener(this);
        tCEventManager.registerHttpListener(this);
        tCEventManager.registerNetworkListener(this);
        tCEventManager.registerLocationListener(this);
        tCEventManager.registerLifecycleListener(this);
        tCEventManager.registerServerSideStateListener(this);
    }

    public static TCLogger getInstance() {
        if (INSTANCE == null) {
            synchronized (TCLogger.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCLogger();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    private void logToConsole(String str, int i) {
        for (String str2 : str.split("\n")) {
            Log.println(i, TCCoreConstants.kTCLogTag, str2);
        }
    }

    public void logMessage(String str, int i) {
        if (i >= TCDebug.getLogLevel()) {
            logToConsole(str, i);
        }
    }

    public void logEvent(String str, int i) throws JSONException {
        if (TCDebug.isPrettyFormatEnabled()) {
            try {
                str = new JSONObject(str).toString(4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        getInstance().logMessage(str, i);
    }

    public void setLogNotification(Boolean bool) {
        this.logNotification = bool;
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCConfigurationListener
    public void onConfigurationRequest(String str, String str2) {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onConfigurationRequest for '" + str + "' with url: " + str2, 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCConfigurationListener
    public void onConfigurationResponse(String str, String str2) {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onConfigurationResponse for '" + str + "'", 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCConfigurationListener
    public void onConfigurationChanged(String str, Boolean bool, Boolean bool2) {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onConfigurationChanged for '" + str + "'", 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCHTTPListener
    public void onHTTPResponse(String str) {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onHTTPResponse", 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCNetworkListener
    public void onInternetUp() {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onInternetUp", 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCNetworkListener
    public void onInternetDown() {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onInternetDown", 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCLocationListener
    public void onLocationAvailable() {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onLocationAvailable", 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCLocationListener
    public void onLocationUnavailable() {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onLocationUnavailable", 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCLifecycleListener
    public void onGoingBackground() {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onGoingBackground", 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCLifecycleListener
    public void onGoingForeground() {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onGoingForeground", 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCServerSideStateListener
    public void onEnablingTheServerSide() {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onEnablingTheServerSide", 4);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCServerSideStateListener
    public void onStoppingTheServerSide() {
        if (this.logNotification.booleanValue()) {
            logMessage("Notification: onStoppingTheServerSide", 4);
        }
    }
}

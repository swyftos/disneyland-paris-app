package com.tagcommander.lib.core;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.UUID;

/* loaded from: classes4.dex */
public class TCCoreVariables implements ITCDynamicStore {
    private static volatile TCCoreVariables INSTANCE;
    private Context appContext;
    public TCDynamicStore dynStore = new TCDynamicStore();
    public boolean enableHTTPInBG = false;

    private TCCoreVariables() {
        TCLogger.getInstance().logMessage("Commanders Act Core module version: 5.4.6", 4);
    }

    public static TCCoreVariables getInstance() {
        if (INSTANCE == null) {
            synchronized (TCCoreVariables.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCCoreVariables();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public void setContext(Context context) {
        if (this.appContext == null) {
            this.appContext = context;
            initializeAllCoreVariables();
        }
    }

    void initializeAllCoreVariables() {
        initUserAgent();
        initSDKID();
    }

    private void initSDKID() {
        String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences(TCCoreConstants.kTCPredefinedVariable_SDKID, this.appContext);
        if (strRetrieveInfoFromSharedPreferences == null || strRetrieveInfoFromSharedPreferences.isEmpty()) {
            strRetrieveInfoFromSharedPreferences = UUID.randomUUID().toString();
            TCSharedPreferences.saveInfoToSharedPreferences(TCCoreConstants.kTCPredefinedVariable_SDKID, strRetrieveInfoFromSharedPreferences, this.appContext);
        }
        addData(TCCoreConstants.kTCPredefinedVariable_SDKID, strRetrieveInfoFromSharedPreferences);
    }

    private void initUserAgent() {
        try {
            addData(TCCoreConstants.kTCPredefinedVariable_UserAgent, WebSettings.getDefaultUserAgent(this.appContext));
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("Error in getting UserAgent: " + e.getMessage(), 6);
        }
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public void addData(TCDynamicStore tCDynamicStore) {
        this.dynStore.addData(tCDynamicStore);
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public void addData(String str, String str2) {
        this.dynStore.addData(str, str2);
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public String getData(String str) {
        return this.dynStore.getData(str);
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public String removeData(String str) {
        return this.dynStore.removeData(str);
    }
}

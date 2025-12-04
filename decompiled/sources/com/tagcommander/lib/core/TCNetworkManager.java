package com.tagcommander.lib.core;

import android.content.Context;
import android.webkit.URLUtil;
import com.tagcommander.lib.core.TCEventManager;
import com.tagcommander.lib.core.TCHTTPOperationInformation;
import java.io.IOException;

/* loaded from: classes4.dex */
public class TCNetworkManager implements TCEventManager.TCHTTPListener, TCEventManager.TCPartnersListener, TCEventManager.TCConfigurationListener {
    private static volatile TCNetworkManager INSTANCE;
    private volatile Context appContext;
    private TCNetworkReceiver networkReceiver;
    public TCWaitingQueue queue;

    @Override // com.tagcommander.lib.core.TCEventManager.TCConfigurationListener
    public void onConfigurationChanged(String str, Boolean bool, Boolean bool2) {
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCConfigurationListener
    public void onConfigurationResponse(String str, String str2) {
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCHTTPListener
    public void onHTTPRequestError(String str) {
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCHTTPListener
    public void onHTTPResponse(String str) {
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCPartnersListener
    public void onPartnerResponse(String str, String str2) {
    }

    private TCNetworkManager() {
    }

    public static TCNetworkManager getInstance() {
        if (INSTANCE == null) {
            synchronized (TCNetworkManager.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCNetworkManager();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public static Boolean isValidURL(String str) {
        return Boolean.valueOf(URLUtil.isValidUrl(str));
    }

    public void registerContextAndListeners(Context context) {
        if (this.appContext == null) {
            this.appContext = context.getApplicationContext();
            this.queue = new TCWaitingQueue(this.appContext);
            TCNetworkReceiver tCNetworkReceiver = new TCNetworkReceiver(this.appContext);
            this.networkReceiver = tCNetworkReceiver;
            tCNetworkReceiver.registerReceiver();
            TCEventManager.getInstance().registerHttpListener(this);
            TCEventManager.getInstance().registerPartnersListener(this);
            TCEventManager.getInstance().registerConfigurationListener(this);
        }
    }

    public TCNetworkReceiver getNetworkReceiver() {
        return this.networkReceiver;
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCHTTPListener
    public void onHTTPRequest(String str, String str2, String str3) throws IOException {
        if (isValidURL(str).booleanValue()) {
            TCHTTPOperation tCHTTPOperation = new TCHTTPOperation(str, this.appContext, "");
            if (str2 != null) {
                tCHTTPOperation.addPostData(str2);
            }
            if (str3 != null) {
                this.queue.addConsent(tCHTTPOperation);
            } else {
                this.queue.add(tCHTTPOperation);
            }
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCPartnersListener
    public void onPartnerRequest(String str, String str2) {
        if (isValidURL(str2).booleanValue()) {
            TCHTTPOperation tCHTTPOperation = new TCHTTPOperation(str2, this.appContext, "");
            TCHTTPOperationInformation tCHTTPOperationInformation = tCHTTPOperation.information;
            tCHTTPOperationInformation.partner = str;
            tCHTTPOperationInformation.hitType = TCHTTPOperationInformation.EType.PARTNER;
            this.queue.addConsent(tCHTTPOperation);
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCConfigurationListener
    public void onConfigurationRequest(String str, String str2) {
        if (isValidURL(str2).booleanValue()) {
            TCHTTPOperation tCHTTPOperation = new TCHTTPOperation(str2, this.appContext, "");
            tCHTTPOperation.information.hitType = str.startsWith(TCCoreConstants.kTCIABDisclosuresJsonPrefix) ? TCHTTPOperationInformation.EType.VENDOR_DISCLOSURE : TCHTTPOperationInformation.EType.CONFIGURATION;
            tCHTTPOperation.information.partner = str;
            this.queue.addConsent(tCHTTPOperation);
        }
    }
}

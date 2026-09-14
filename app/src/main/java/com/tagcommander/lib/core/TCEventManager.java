package com.tagcommander.lib.core;

import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCEventManager {
    private static volatile TCEventManager INSTANCE;
    CopyOnWriteArrayList configurationListeners;
    CopyOnWriteArrayList consentListeners;
    private ETCConsentBehaviour defaultBehaviour;
    CopyOnWriteArrayList executeListeners;
    CopyOnWriteArrayList httpListeners;
    Boolean internetUp;
    Boolean isForeground;
    CopyOnWriteArrayList lcListeners;
    CopyOnWriteArrayList locationListeners;
    CopyOnWriteArrayList networkListeners;
    CopyOnWriteArrayList partnersListeners;
    ETCConsentState serverSideState;
    CopyOnWriteArrayList serverSideStateListeners;

    public interface TCConfigurationListener {
        void onConfigurationChanged(String str, Boolean bool, Boolean bool2);

        void onConfigurationRequest(String str, String str2);

        void onConfigurationResponse(String str, String str2);
    }

    public interface TCConsentListener {
        void onFirebaseConsentEvent(Map<ETCGoogleConsentCategories, ETCGoogleConsentType> map);

        void onPolicySpecificationUpgrade();
    }

    public interface TCExecuteListener {
        void onExecuteEvent(String str, JSONObject jSONObject);
    }

    public interface TCHTTPListener {
        void onHTTPRequest(String str, String str2, String str3);

        void onHTTPRequestError(String str);

        void onHTTPResponse(String str);
    }

    public interface TCLifecycleListener {
        void onGoingBackground();

        void onGoingForeground();
    }

    public interface TCLocationListener {
        void onLocationAvailable();

        void onLocationUnavailable();
    }

    public interface TCNetworkListener {
        void onInternetDown();

        void onInternetUp();
    }

    public interface TCPartnersListener {
        void onPartnerRequest(String str, String str2);

        void onPartnerResponse(String str, String str2);
    }

    public interface TCServerSideStateListener {
        void onEnablingTheServerSide();

        void onStoppingTheServerSide();
    }

    private TCEventManager() {
        Boolean bool = Boolean.FALSE;
        this.internetUp = bool;
        this.isForeground = bool;
        this.serverSideState = ETCConsentState.WAITING_FOR_CONSENT;
        this.networkListeners = new CopyOnWriteArrayList();
        this.lcListeners = new CopyOnWriteArrayList();
        this.serverSideStateListeners = new CopyOnWriteArrayList();
        this.locationListeners = new CopyOnWriteArrayList();
        this.httpListeners = new CopyOnWriteArrayList();
        this.partnersListeners = new CopyOnWriteArrayList();
        this.configurationListeners = new CopyOnWriteArrayList();
        this.consentListeners = new CopyOnWriteArrayList();
        this.executeListeners = new CopyOnWriteArrayList();
    }

    public static TCEventManager getInstance() {
        if (INSTANCE == null) {
            synchronized (TCEventManager.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCEventManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return INSTANCE;
    }

    public void registerNetworkListener(TCNetworkListener tCNetworkListener) {
        if (tCNetworkListener != null) {
            this.networkListeners.add(tCNetworkListener);
        }
    }

    public void registerLifecycleListener(TCLifecycleListener tCLifecycleListener) {
        if (tCLifecycleListener != null) {
            this.lcListeners.add(tCLifecycleListener);
        }
    }

    public void registerServerSideStateListener(TCServerSideStateListener tCServerSideStateListener) {
        if (tCServerSideStateListener != null) {
            this.serverSideStateListeners.add(tCServerSideStateListener);
        }
    }

    public void registerLocationListener(TCLocationListener tCLocationListener) {
        if (tCLocationListener != null) {
            this.locationListeners.add(tCLocationListener);
        }
    }

    public void registerHttpListener(TCHTTPListener tCHTTPListener) {
        if (tCHTTPListener != null) {
            this.httpListeners.add(tCHTTPListener);
        }
    }

    public void registerPartnersListener(TCPartnersListener tCPartnersListener) {
        if (tCPartnersListener != null) {
            this.partnersListeners.add(tCPartnersListener);
        }
    }

    public void registerConfigurationListener(TCConfigurationListener tCConfigurationListener) {
        if (tCConfigurationListener != null) {
            this.configurationListeners.add(tCConfigurationListener);
        }
    }

    public void registerConsentListener(TCConsentListener tCConsentListener) {
        if (tCConsentListener != null) {
            this.consentListeners.add(tCConsentListener);
        }
    }

    public void registerExecuteListener(TCExecuteListener tCExecuteListener) {
        if (tCExecuteListener != null) {
            this.executeListeners.add(tCExecuteListener);
        }
    }

    public void callInternetUp() {
        this.internetUp = Boolean.TRUE;
        for (TCNetworkListener tCNetworkListener : this.networkListeners) {
            if (tCNetworkListener != null) {
                tCNetworkListener.onInternetUp();
            }
        }
    }

    public void callInternetDown() {
        this.internetUp = Boolean.FALSE;
        for (TCNetworkListener tCNetworkListener : this.networkListeners) {
            if (tCNetworkListener != null) {
                tCNetworkListener.onInternetDown();
            }
        }
    }

    public void callOnForeground() {
        this.isForeground = Boolean.TRUE;
        for (TCLifecycleListener tCLifecycleListener : this.lcListeners) {
            if (tCLifecycleListener != null) {
                tCLifecycleListener.onGoingForeground();
            }
        }
    }

    public void callOnBackground() {
        this.isForeground = Boolean.FALSE;
        for (TCLifecycleListener tCLifecycleListener : this.lcListeners) {
            if (tCLifecycleListener != null) {
                tCLifecycleListener.onGoingBackground();
            }
        }
    }

    public void callOnEnablingTheServerSide() {
        setServerSideState(ETCConsentState.ENABLED);
        for (TCServerSideStateListener tCServerSideStateListener : this.serverSideStateListeners) {
            if (tCServerSideStateListener != null) {
                tCServerSideStateListener.onEnablingTheServerSide();
            }
        }
    }

    public void callOnStoppingTheServerSide() {
        if (this.defaultBehaviour == ETCConsentBehaviour.PB_ALWAYS_ENABLED) {
            return;
        }
        setServerSideState(ETCConsentState.DISABLED);
        for (TCServerSideStateListener tCServerSideStateListener : this.serverSideStateListeners) {
            if (tCServerSideStateListener != null) {
                tCServerSideStateListener.onStoppingTheServerSide();
            }
        }
    }

    public void callOnLocationAvailable() {
        for (TCLocationListener tCLocationListener : this.locationListeners) {
            if (tCLocationListener != null) {
                tCLocationListener.onLocationAvailable();
            }
        }
    }

    public void callOnLocationUnavailable() {
        for (TCLocationListener tCLocationListener : this.locationListeners) {
            if (tCLocationListener != null) {
                tCLocationListener.onLocationUnavailable();
            }
        }
    }

    public void callOnHttpRequest(String str, String str2, String str3) {
        for (TCHTTPListener tCHTTPListener : this.httpListeners) {
            if (tCHTTPListener != null) {
                tCHTTPListener.onHTTPRequest(str, str2, str3);
            }
        }
    }

    public void callOnHttpRequestError(String str) {
        for (TCHTTPListener tCHTTPListener : this.httpListeners) {
            if (tCHTTPListener != null) {
                tCHTTPListener.onHTTPRequestError(str);
            }
        }
    }

    public void callOnHttpResponse(String str) {
        for (TCHTTPListener tCHTTPListener : this.httpListeners) {
            if (tCHTTPListener != null) {
                tCHTTPListener.onHTTPResponse(str);
            }
        }
    }

    public void callOnPartnerRequest(String str, String str2) {
        for (TCPartnersListener tCPartnersListener : this.partnersListeners) {
            if (tCPartnersListener != null) {
                tCPartnersListener.onPartnerRequest(str, str2);
            }
        }
    }

    public void callOnPartnerResponse(String str, String str2) {
        for (TCPartnersListener tCPartnersListener : this.partnersListeners) {
            if (tCPartnersListener != null) {
                tCPartnersListener.onPartnerResponse(str, str2);
            }
        }
    }

    public void callOnConfigurationRequest(String str, String str2) {
        for (TCConfigurationListener tCConfigurationListener : this.configurationListeners) {
            if (tCConfigurationListener != null) {
                tCConfigurationListener.onConfigurationRequest(str, str2);
            }
        }
    }

    public void callOnConfigurationResponse(String str, String str2) {
        for (TCConfigurationListener tCConfigurationListener : this.configurationListeners) {
            if (tCConfigurationListener != null) {
                tCConfigurationListener.onConfigurationResponse(str, str2);
            }
        }
    }

    public void callOnConfigurationChanged(String str, Boolean bool, Boolean bool2) {
        for (TCConfigurationListener tCConfigurationListener : this.configurationListeners) {
            if (tCConfigurationListener != null) {
                tCConfigurationListener.onConfigurationChanged(str, bool, bool2);
            }
        }
    }

    public void callOnPolicySpeceficationUpgrade() {
        for (TCConsentListener tCConsentListener : this.consentListeners) {
            if (tCConsentListener != null) {
                tCConsentListener.onPolicySpecificationUpgrade();
            }
        }
    }

    public void callOnFirebaseConsent(Map<ETCGoogleConsentCategories, ETCGoogleConsentType> map) {
        for (TCConsentListener tCConsentListener : this.consentListeners) {
            if (tCConsentListener != null) {
                tCConsentListener.onFirebaseConsentEvent(map);
            }
        }
    }

    public void callOnExecuteEvent(String str, JSONObject jSONObject) {
        for (TCExecuteListener tCExecuteListener : this.executeListeners) {
            if (tCExecuteListener != null) {
                tCExecuteListener.onExecuteEvent(str, jSONObject);
            }
        }
    }

    public ETCConsentBehaviour getDefaultBehaviour() {
        return this.defaultBehaviour;
    }

    public void setDefaultBehaviour(ETCConsentBehaviour eTCConsentBehaviour) {
        this.defaultBehaviour = eTCConsentBehaviour;
    }

    public synchronized ETCConsentState getServerSideState() {
        return this.serverSideState;
    }

    private synchronized void setServerSideState(ETCConsentState eTCConsentState) {
        this.serverSideState = eTCConsentState;
    }
}

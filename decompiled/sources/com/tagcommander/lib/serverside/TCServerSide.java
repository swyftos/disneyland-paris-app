package com.tagcommander.lib.serverside;

import android.content.Context;
import androidx.ads.identifier.AdvertisingIdClient;
import androidx.ads.identifier.AdvertisingIdInfo;
import androidx.annotation.NonNull;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.tagcommander.lib.core.ETCConsentBehaviour;
import com.tagcommander.lib.core.ETCConsentState;
import com.tagcommander.lib.core.TCCoreConstants;
import com.tagcommander.lib.core.TCCoreVariables;
import com.tagcommander.lib.core.TCDynamicStore;
import com.tagcommander.lib.core.TCEventManager;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCNetworkManager;
import com.tagcommander.lib.serverside.events.base.TCEvent;
import com.tagcommander.lib.serverside.schemas.TCDevice;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class TCServerSide implements TCEventManager.TCServerSideStateListener {
    private final Context appContext;
    int numberOfProducts;
    private String url;
    private boolean firebaseEnabled = false;
    final TCDynamicStore permanentStore = new TCDynamicStore();

    public TCServerSide(int i, String str, Context context) throws ClassNotFoundException {
        this.appContext = context.getApplicationContext();
        initTagCommander(i, str, context, ETCConsentBehaviour.PB_DEFAULT_BEHAVIOUR);
    }

    public TCServerSide(int i, String str, Context context, ETCConsentBehaviour eTCConsentBehaviour) throws ClassNotFoundException {
        this.appContext = context.getApplicationContext();
        initTagCommander(i, str, context, eTCConsentBehaviour);
    }

    void initTagCommander(int i, String str, Context context, ETCConsentBehaviour eTCConsentBehaviour) throws ClassNotFoundException {
        new TCInitialisation(this.appContext);
        TCLogger.getInstance().logMessage("Server-Side SDK init with version: 5.5.7", 4);
        if (i != 0) {
            TCLogger.getInstance().logMessage("Server-Side SDK init with siteID " + i, 4);
        }
        TCEventManager.getInstance().setDefaultBehaviour(eTCConsentBehaviour);
        int i2 = AnonymousClass2.$SwitchMap$com$tagcommander$lib$core$ETCConsentBehaviour[eTCConsentBehaviour.ordinal()];
        if (i2 == 1) {
            try {
                Class.forName("com.tagcommander.lib.consent.TCConsent");
            } catch (ClassNotFoundException unused) {
                TCEventManager.getInstance().callOnEnablingTheServerSide();
            }
        } else if (i2 == 2) {
            TCEventManager.getInstance().callOnEnablingTheServerSide();
            TCLogger.getInstance().logMessage("Starting Server-Side SDK as 'Always Enabled'", 3);
        } else if (i2 == 3) {
            TCEventManager.getInstance().callOnStoppingTheServerSide();
            TCLogger.getInstance().logMessage("Starting Server-Side SDK as 'Disabled by default'", 3);
        }
        TCNetworkManager.getInstance().queue.serverSideState = TCEventManager.getInstance().getServerSideState();
        TCEventManager.getInstance().registerServerSideStateListener(this);
        String str2 = "https://collect.commander1.com/events?tc_firsttime=1&tc_s=%d&token=" + str;
        this.url = str2;
        this.url = str2.replace("%d", "" + i);
        this.numberOfProducts = 0;
        try {
            Class.forName("com.tagcommander.lib.firebasedestination.TCFirebase");
            this.firebaseEnabled = true;
        } catch (ClassNotFoundException unused2) {
        }
    }

    /* renamed from: com.tagcommander.lib.serverside.TCServerSide$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tagcommander$lib$core$ETCConsentBehaviour;

        static {
            int[] iArr = new int[ETCConsentBehaviour.values().length];
            $SwitchMap$com$tagcommander$lib$core$ETCConsentBehaviour = iArr;
            try {
                iArr[ETCConsentBehaviour.PB_DEFAULT_BEHAVIOUR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tagcommander$lib$core$ETCConsentBehaviour[ETCConsentBehaviour.PB_ALWAYS_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tagcommander$lib$core$ETCConsentBehaviour[ETCConsentBehaviour.PB_DISABLED_BY_DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void execute(@NonNull TCEvent tCEvent) throws JSONException {
        if (TCEventManager.getInstance().getServerSideState() == ETCConsentState.DISABLED) {
            return;
        }
        TCPredefinedVariables.getInstance().firstExecute();
        TCPredefinedVariables.getInstance().computeTimeChangingVariables();
        TCLogger.getInstance().logMessage("Server-Side SDK sending event: " + tCEvent.getName(), 4);
        synchronized (this.permanentStore) {
            tCEvent.addAdditionalProperty(this.permanentStore);
        }
        String postParameters = TCPostData.getPostParameters(tCEvent, TCEventManager.getInstance().getServerSideState());
        TCLogger.getInstance().logMessage("Event payload: ", 2);
        TCLogger.getInstance().logEvent(postParameters, 2);
        TCEventManager.getInstance().callOnHttpRequest(this.url, postParameters, null);
        TCPredefinedVariables.getInstance().resetNewSession();
        if (this.firebaseEnabled) {
            TCEventManager.getInstance().callOnExecuteEvent(tCEvent.getName(), tCEvent.getJsonObject());
        }
    }

    public void enableRunningInBackground() {
        TCCoreVariables.getInstance().enableHTTPInBG = true;
        TCLogger.getInstance().logMessage("Server-Side SDK is enabled to run in background", 3);
    }

    public void addPermanentData(String str, String str2) {
        synchronized (this.permanentStore) {
            this.permanentStore.addData(str, str2);
        }
    }

    public String getPermanentData(String str) {
        return this.permanentStore.getData(str);
    }

    public String removePermanentData(String str) {
        String strRemoveData;
        synchronized (this.permanentStore) {
            strRemoveData = this.permanentStore.removeData(str);
        }
        return strRemoveData;
    }

    public void disableServerSide() {
        if (TCEventManager.getInstance().getDefaultBehaviour() == ETCConsentBehaviour.PB_ALWAYS_ENABLED) {
            return;
        }
        TCEventManager.getInstance().callOnStoppingTheServerSide();
    }

    public void enableServerSide() {
        TCEventManager.getInstance().callOnEnablingTheServerSide();
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCServerSideStateListener
    public void onEnablingTheServerSide() {
        TCLogger.getInstance().logMessage("ServerSide is now activated", 3);
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCServerSideStateListener
    public void onStoppingTheServerSide() {
        if (TCEventManager.getInstance().getDefaultBehaviour() == ETCConsentBehaviour.PB_ALWAYS_ENABLED) {
            return;
        }
        TCLogger.getInstance().logMessage("ServerSide is now deactivated", 3);
    }

    public void addAdvertisingID() {
        if (AdvertisingIdClient.isAdvertisingIdProviderAvailable(this.appContext)) {
            ListenableFuture<AdvertisingIdInfo> advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.appContext);
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            MoreExecutors.listeningDecorator(executorServiceNewSingleThreadExecutor);
            Futures.addCallback(advertisingIdInfo, new FutureCallback() { // from class: com.tagcommander.lib.serverside.TCServerSide.1
                @Override // com.google.common.util.concurrent.FutureCallback
                public void onSuccess(AdvertisingIdInfo advertisingIdInfo2) {
                    String id = advertisingIdInfo2.getId();
                    boolean z = !advertisingIdInfo2.isLimitAdTrackingEnabled();
                    TCCoreVariables.getInstance().addData(TCCoreConstants.kTCPredefinedVariable_IDFA, id);
                    TCCoreVariables.getInstance().addData(TCCoreConstants.kTCPredefinedVariable_AddTrackingEnabled, z + "");
                    TCDevice.getInstance().setAdvertisingIds();
                }

                @Override // com.google.common.util.concurrent.FutureCallback
                public void onFailure(Throwable th) {
                    TCLogger.getInstance().logMessage("Failed to retreive AAID", 6);
                }
            }, executorServiceNewSingleThreadExecutor);
        }
    }
}

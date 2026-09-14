package com.dlp;

import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.tagcommander.lib.core.TCCoreConstants;
import com.tagcommander.lib.p193serverside.TCPredefinedVariables;
import com.tagcommander.lib.p193serverside.TCServerSide;
import com.tagcommander.lib.p193serverside.events.TCCustomEvent;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TCWrapper extends ReactContextBaseJavaModule {
    static final String TAG = "TCWrapper";

    /* JADX INFO: renamed from: TC */
    TCServerSide f3346TC;

    public TCWrapper(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.f3346TC = null;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    private boolean sanityCheck() {
        if (this.f3346TC != null) {
            return true;
        }
        Log.e(TAG, "Error, the TagCommander instance was not instantiated.\nPlease call initTagCommander(int siteID, int containerID)");
        return false;
    }

    @ReactMethod
    public void initTagCommander(int i, String str) {
        TCServerSide tCServerSide = new TCServerSide(i, str, getReactApplicationContext());
        this.f3346TC = tCServerSide;
        tCServerSide.addPermanentData("#TC_IP#", "0");
    }

    @ReactMethod
    public void sendEvent(String str, ReadableMap readableMap) {
        TCCustomEvent tCCustomEvent = new TCCustomEvent(str);
        Iterator<Map.Entry<String, Object>> entryIterator = readableMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            try {
                Map.Entry<String, Object> next = entryIterator.next();
                tCCustomEvent.addAdditionalProperty(next.getKey(), next.getValue().toString());
            } catch (Exception e) {
                Log.w(TAG, "Error adding eventData to event");
                Log.d(TAG, "Raw exception received:", e);
            }
        }
        this.f3346TC.execute(tCCustomEvent);
    }

    @ReactMethod
    public void addPermanentData(String str, String str2) {
        if (sanityCheck()) {
            this.f3346TC.addPermanentData(str, str2);
        }
    }

    @ReactMethod
    public void getUniqueId(Promise promise) {
        if (!sanityCheck()) {
            promise.reject("Setup error", "TagCommander instance was not instantiated.\nPlease call initTagCommander(int siteID, int containerID)");
            return;
        }
        String data = TCPredefinedVariables.getInstance().getData(TCCoreConstants.kTCPredefinedVariable_SDKID);
        Log.i(TAG, data);
        promise.resolve(data);
    }

    @ReactMethod
    public void disableSDK() {
        if (sanityCheck()) {
            this.f3346TC.disableServerSide();
        }
    }

    @ReactMethod
    public void enableSDK() {
        if (sanityCheck()) {
            this.f3346TC.enableServerSide();
        }
    }
}

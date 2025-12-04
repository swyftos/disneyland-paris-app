package com.dlp;

import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.tagcommander.lib.serverside.TCPredefinedVariables;
import com.tagcommander.lib.serverside.TCServerSide;
import com.tagcommander.lib.serverside.TCServerSideConstants;
import com.tagcommander.lib.serverside.events.TCCustomEvent;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class TCWrapper extends ReactContextBaseJavaModule {
    static final String TAG = "TCWrapper";
    TCServerSide TC;

    public TCWrapper(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.TC = null;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    private boolean sanityCheck() {
        if (this.TC != null) {
            return true;
        }
        Log.e(TAG, "Error, the TagCommander instance was not instantiated.\nPlease call initTagCommander(int siteID, int containerID)");
        return false;
    }

    @ReactMethod
    public void initTagCommander(int i, String str) {
        TCServerSide tCServerSide = new TCServerSide(i, str, getReactApplicationContext());
        this.TC = tCServerSide;
        tCServerSide.addPermanentData("#TC_IP#", "0");
    }

    @ReactMethod
    public void sendEvent(String str, ReadableMap readableMap) throws JSONException {
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
        this.TC.execute(tCCustomEvent);
    }

    @ReactMethod
    public void addPermanentData(String str, String str2) {
        if (sanityCheck()) {
            this.TC.addPermanentData(str, str2);
        }
    }

    @ReactMethod
    public void getUniqueId(Promise promise) {
        if (!sanityCheck()) {
            promise.reject("Setup error", "TagCommander instance was not instantiated.\nPlease call initTagCommander(int siteID, int containerID)");
            return;
        }
        String data = TCPredefinedVariables.getInstance().getData(TCServerSideConstants.kTCPredefinedVariable_UniqueID);
        Log.i(TAG, data);
        promise.resolve(data);
    }

    @ReactMethod
    public void disableSDK() {
        if (sanityCheck()) {
            this.TC.disableServerSide();
        }
    }

    @ReactMethod
    public void enableSDK() {
        if (sanityCheck()) {
            this.TC.enableServerSide();
        }
    }
}

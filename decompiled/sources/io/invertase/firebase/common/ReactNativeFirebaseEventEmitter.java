package io.invertase.firebase.common;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.contentsquare.android.core.utils.UriBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import io.invertase.firebase.interfaces.NativeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ReactNativeFirebaseEventEmitter {
    private static ReactNativeFirebaseEventEmitter sharedInstance = new ReactNativeFirebaseEventEmitter();
    private int jsListenerCount;
    private ReactContext reactContext;
    private final List queuedEvents = new ArrayList();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final HashMap jsListeners = new HashMap();
    private Boolean jsReady = Boolean.FALSE;

    public static ReactNativeFirebaseEventEmitter getSharedInstance() {
        return sharedInstance;
    }

    public void attachReactContext(final ReactContext reactContext) {
        this.handler.post(new Runnable() { // from class: io.invertase.firebase.common.ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$attachReactContext$0(reactContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$attachReactContext$0(ReactContext reactContext) {
        this.reactContext = reactContext;
        sendQueuedEvents();
    }

    public void notifyJsReady(final Boolean bool) {
        this.handler.post(new Runnable() { // from class: io.invertase.firebase.common.ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$notifyJsReady$1(bool);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyJsReady$1(Boolean bool) {
        this.jsReady = bool;
        sendQueuedEvents();
    }

    public void sendEvent(final NativeEvent nativeEvent) {
        this.handler.post(new Runnable() { // from class: io.invertase.firebase.common.ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendEvent$2(nativeEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendEvent$2(NativeEvent nativeEvent) {
        synchronized (this.jsListeners) {
            try {
                if (!this.jsListeners.containsKey(nativeEvent.getEventName()) || !emit(nativeEvent)) {
                    this.queuedEvents.add(nativeEvent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addListener(String str) {
        synchronized (this.jsListeners) {
            try {
                this.jsListenerCount++;
                if (!this.jsListeners.containsKey(str)) {
                    this.jsListeners.put(str, 1);
                } else {
                    this.jsListeners.put(str, Integer.valueOf(((Integer) this.jsListeners.get(str)).intValue() + 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.handler.post(new Runnable() { // from class: io.invertase.firebase.common.ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.sendQueuedEvents();
            }
        });
    }

    public void removeListener(String str, Boolean bool) {
        synchronized (this.jsListeners) {
            try {
                if (this.jsListeners.containsKey(str)) {
                    int iIntValue = ((Integer) this.jsListeners.get(str)).intValue();
                    if (iIntValue <= 1 || bool.booleanValue()) {
                        this.jsListeners.remove(str);
                    } else {
                        this.jsListeners.put(str, Integer.valueOf(iIntValue - 1));
                    }
                    int i = this.jsListenerCount;
                    if (!bool.booleanValue()) {
                        iIntValue = 1;
                    }
                    this.jsListenerCount = i - iIntValue;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public WritableMap getListenersMap() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap.putInt("listeners", this.jsListenerCount);
        writableMapCreateMap.putInt("queued", this.queuedEvents.size());
        synchronized (this.jsListeners) {
            try {
                for (Map.Entry entry : this.jsListeners.entrySet()) {
                    writableMapCreateMap2.putInt((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        writableMapCreateMap.putMap(UriBuilder.ANALYTICS_EVENT_ENDPOINT, writableMapCreateMap2);
        return writableMapCreateMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendQueuedEvents() {
        synchronized (this.jsListeners) {
            try {
                Iterator it = new ArrayList(this.queuedEvents).iterator();
                while (it.hasNext()) {
                    NativeEvent nativeEvent = (NativeEvent) it.next();
                    if (this.jsListeners.containsKey(nativeEvent.getEventName())) {
                        this.queuedEvents.remove(nativeEvent);
                        sendEvent(nativeEvent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean emit(NativeEvent nativeEvent) {
        ReactContext reactContext;
        if (this.jsReady.booleanValue() && (reactContext = this.reactContext) != null && reactContext.hasActiveCatalystInstance()) {
            try {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("rnfb_" + nativeEvent.getEventName(), nativeEvent.getEventBody());
                return true;
            } catch (Exception e) {
                Log.wtf("RNFB_EMITTER", "Error sending Event " + nativeEvent.getEventName(), e);
            }
        }
        return false;
    }
}

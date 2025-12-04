package com.reactlibrary.sqlcipher;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* loaded from: classes4.dex */
public class CallbackContext {
    private Callback errorCallback;
    private Callback successCallback;

    public CallbackContext(Callback callback, Callback callback2) {
        this.successCallback = callback;
        this.errorCallback = callback2;
    }

    public void success(WritableMap writableMap) {
        this.successCallback.invoke(writableMap);
    }

    public void success(String str) {
        this.successCallback.invoke(str);
    }

    public void success(WritableArray writableArray) {
        this.successCallback.invoke(writableArray);
    }

    public void success() {
        this.successCallback.invoke("Success");
    }

    public void error(WritableMap writableMap) {
        this.errorCallback.invoke(writableMap);
    }

    public void error(String str) {
        this.errorCallback.invoke(str);
    }
}

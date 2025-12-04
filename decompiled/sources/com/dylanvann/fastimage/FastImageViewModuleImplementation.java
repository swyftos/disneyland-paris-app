package com.dylanvann.fastimage;

import android.app.Activity;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.BaseRequestOptions;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes3.dex */
class FastImageViewModuleImplementation {
    ReactApplicationContext reactContext;

    FastImageViewModuleImplementation(ReactApplicationContext reactApplicationContext) {
        this.reactContext = reactApplicationContext;
    }

    private Activity getCurrentActivity() {
        return this.reactContext.getCurrentActivity();
    }

    public void preload(final ReadableArray readableArray) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.dylanvann.fastimage.FastImageViewModuleImplementation.1
            @Override // java.lang.Runnable
            public void run() {
                Object uri;
                for (int i = 0; i < readableArray.size(); i++) {
                    ReadableMap map = readableArray.getMap(i);
                    FastImageSource imageSource = FastImageViewConverter.getImageSource(currentActivity, map);
                    if (map == null || !map.hasKey(ReactNativeBlobUtilConst.DATA_ENCODE_URI) || map.getString(ReactNativeBlobUtilConst.DATA_ENCODE_URI).isEmpty()) {
                        System.out.println("Source is null or URI is empty");
                    } else {
                        RequestManager requestManagerWith = Glide.with(currentActivity.getApplicationContext());
                        if (imageSource.isBase64Resource()) {
                            uri = imageSource.getSource();
                        } else {
                            uri = imageSource.isResource() ? imageSource.getUri() : imageSource.getGlideUrl();
                        }
                        requestManagerWith.mo723load(uri).apply((BaseRequestOptions<?>) FastImageViewConverter.getOptions(currentActivity, imageSource, map)).preload();
                    }
                }
            }
        });
    }

    public void clearMemoryCache(final Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.resolve(null);
        } else {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.dylanvann.fastimage.FastImageViewModuleImplementation.2
                @Override // java.lang.Runnable
                public void run() {
                    Glide.get(currentActivity.getApplicationContext()).clearMemory();
                    promise.resolve(null);
                }
            });
        }
    }

    public void clearDiskCache(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.resolve(null);
        } else {
            Glide.get(currentActivity.getApplicationContext()).clearDiskCache();
            promise.resolve(null);
        }
    }
}

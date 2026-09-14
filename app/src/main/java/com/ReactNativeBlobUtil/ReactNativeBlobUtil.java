package com.ReactNativeBlobUtil;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.facebook.fbreact.specs.NativeBlobUtilsSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ReactNativeBlobUtil extends NativeBlobUtilsSpec {
    private final ReactNativeBlobUtilImpl delegate;

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void emitExpiredEvent(Callback callback) {
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void excludeFromBackupKey(String str, Promise promise) {
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void getEnvironmentDirs(Callback callback) {
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void pathForAppGroup(String str, Promise promise) {
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void presentOpenInMenu(String str, String str2, Promise promise) {
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void presentOptionsMenu(String str, String str2, Promise promise) {
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void presentPreview(String str, String str2, Promise promise) {
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    @ReactMethod
    public void removeListeners(double d) {
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public String syncPathAppGroup(String str) {
        return null;
    }

    public ReactNativeBlobUtil(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new ReactNativeBlobUtilImpl(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    protected Map<String, Object> getTypedExportedConstants() {
        HashMap map = new HashMap();
        map.putAll(ReactNativeBlobUtilFS.getSystemfolders(getReactApplicationContext()));
        map.putAll(ReactNativeBlobUtilFS.getLegacySystemfolders(getReactApplicationContext()));
        return map;
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec, com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return NativeBlobUtilsSpec.NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void fetchBlobForm(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, ReadableArray readableArray, Callback callback) {
        this.delegate.fetchBlobForm(readableMap, str, str2, str3, readableMap2, readableArray, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void fetchBlob(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, Callback callback) {
        this.delegate.fetchBlob(readableMap, str, str2, str3, readableMap2, str4, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void createFile(String str, String str2, String str3, Promise promise) {
        this.delegate.createFile(str, str2, str3, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        this.delegate.createFileASCII(str, readableArray, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void exists(String str, Callback callback) {
        this.delegate.exists(str, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void writeFile(String str, String str2, String str3, boolean z, boolean z2, Promise promise) {
        this.delegate.writeFile(str, str2, str3, z, z2, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void writeFileArray(String str, ReadableArray readableArray, boolean z, Promise promise) {
        this.delegate.writeFileArray(str, readableArray, z, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void writeStream(String str, String str2, boolean z, Callback callback) {
        this.delegate.writeStream(str, str2, z, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        this.delegate.writeArrayChunk(str, readableArray, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void writeChunk(String str, String str2, Callback callback) {
        this.delegate.writeChunk(str, str2, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void closeStream(String str, Callback callback) {
        this.delegate.closeStream(str, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void unlink(String str, Callback callback) {
        this.delegate.unlink(str, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void removeSession(ReadableArray readableArray, Callback callback) {
        this.delegate.removeSession(readableArray, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    /* JADX INFO: renamed from: ls */
    public void mo422ls(String str, Promise promise) {
        this.delegate.m430ls(str, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void stat(String str, Callback callback) {
        this.delegate.stat(str, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void lstat(String str, Callback callback) {
        this.delegate.lstat(str, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    /* JADX INFO: renamed from: cp */
    public void mo420cp(String str, String str2, Callback callback) {
        this.delegate.m428cp(str, str2, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    /* JADX INFO: renamed from: mv */
    public void mo423mv(String str, String str2, Callback callback) {
        this.delegate.m431mv(str, str2, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void mkdir(String str, Promise promise) {
        this.delegate.mkdir(str, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void readFile(String str, String str2, boolean z, Promise promise) {
        this.delegate.readFile(str, str2, z, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void hash(String str, String str2, Promise promise) {
        this.delegate.hash(str, str2, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void readStream(String str, String str2, double d, double d2, String str3) {
        this.delegate.readStream(str, str2, (int) d, (int) d2, str3);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void cancelRequest(String str, Callback callback) {
        this.delegate.cancelRequest(str, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void enableProgressReport(String str, double d, double d2) {
        this.delegate.enableProgressReport(str, (int) d, (int) d2);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void enableUploadProgressReport(String str, double d, double d2) {
        this.delegate.enableUploadProgressReport(str, (int) d, (int) d2);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void slice(String str, String str2, double d, double d2, Promise promise) {
        this.delegate.slice(str, str2, (long) d, (long) d2, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    /* JADX INFO: renamed from: df */
    public void mo421df(Callback callback) {
        this.delegate.m429df(callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void actionViewIntent(String str, String str2, String str3, Promise promise) {
        this.delegate.actionViewIntent(str, str2, str3, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void addCompleteDownload(ReadableMap readableMap, Promise promise) {
        this.delegate.addCompleteDownload(readableMap, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    @RequiresApi(api = 29)
    public void copyToInternal(String str, String str2, Promise promise) {
        this.delegate.copyToInternal(str, str2, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void copyToMediaStore(ReadableMap readableMap, String str, String str2, Promise promise) {
        this.delegate.copyToMediaStore(readableMap, str, str2, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void createMediaFile(ReadableMap readableMap, String str, Promise promise) {
        this.delegate.createMediaFile(readableMap, str, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    @RequiresApi(api = 29)
    public void getBlob(String str, String str2, Promise promise) {
        this.delegate.getBlob(str, str2, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void getContentIntent(String str, Promise promise) {
        this.delegate.getContentIntent(str, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void getSDCardDir(Promise promise) {
        this.delegate.getSDCardDir(promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void getSDCardApplicationDir(Promise promise) {
        this.delegate.getSDCardApplicationDir(promise);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void scanFile(ReadableArray readableArray, Callback callback) {
        this.delegate.scanFile(readableArray, callback);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobUtilsSpec
    public void writeToMediaFile(String str, String str2, boolean z, Promise promise) {
        this.delegate.writeToMediaFile(str, str2, z, promise);
    }
}

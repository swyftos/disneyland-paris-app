package com.ReactNativeBlobUtil;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.SparseArray;
import androidx.core.content.FileProvider;
import com.ReactNativeBlobUtil.Utils.FileDescription;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes2.dex */
class ReactNativeBlobUtilImpl {
    private static boolean ActionViewVisible;
    static ReactApplicationContext RCTContext;
    static LinkedBlockingQueue fsTaskQueue;
    private static final ThreadPoolExecutor fsThreadPool;
    private static final SparseArray promiseTable;
    private static final LinkedBlockingQueue taskQueue;
    private static final ThreadPoolExecutor threadPool;
    private final OkHttpClient mClient;

    static {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        taskQueue = linkedBlockingQueue;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        threadPool = new ThreadPoolExecutor(5, 10, 5000L, timeUnit, linkedBlockingQueue);
        fsTaskQueue = new LinkedBlockingQueue();
        fsThreadPool = new ThreadPoolExecutor(2, 10, 5000L, timeUnit, linkedBlockingQueue);
        ActionViewVisible = false;
        promiseTable = new SparseArray();
    }

    public ReactNativeBlobUtilImpl(ReactApplicationContext reactApplicationContext) {
        OkHttpClient okHttpClient = OkHttpClientProvider.getOkHttpClient();
        this.mClient = okHttpClient;
        ((CookieJarContainer) okHttpClient.cookieJar()).setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler(reactApplicationContext)));
        RCTContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(new ActivityEventListener() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.1
            @Override // com.facebook.react.bridge.ActivityEventListener
            public void onNewIntent(Intent intent) {
            }

            @Override // com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                Integer num = ReactNativeBlobUtilConst.GET_CONTENT_INTENT;
                if (i == num.intValue() && i2 == -1) {
                    ((Promise) ReactNativeBlobUtilImpl.promiseTable.get(num.intValue())).resolve(intent.getData().toString());
                    ReactNativeBlobUtilImpl.promiseTable.remove(num.intValue());
                }
            }
        });
    }

    public void createFile(final String str, final String str2, final String str3, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.2
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.createFile(str, str2, str3, promise);
            }
        });
    }

    public void createFileASCII(final String str, final ReadableArray readableArray, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.3
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.createFileASCII(str, readableArray, promise);
            }
        });
    }

    public void actionViewIntent(String str, String str2, String str3, final Promise promise) {
        Uri uriForFile;
        try {
            if (!ReactNativeBlobUtilUtils.isContentUri(str)) {
                uriForFile = FileProvider.getUriForFile(RCTContext, RCTContext.getPackageName() + ".provider", new File(str));
            } else {
                uriForFile = Uri.parse(str);
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriForFile, str2);
            intent.setFlags(1);
            intent.addFlags(268435456);
            if (str3 != null) {
                intent = Intent.createChooser(intent, str3);
            }
            try {
                RCTContext.startActivity(intent);
                promise.resolve(Boolean.TRUE);
            } catch (ActivityNotFoundException unused) {
                promise.reject("ENOAPP", "No app installed for " + str2);
            }
            ActionViewVisible = true;
            RCTContext.addLifecycleEventListener(new LifecycleEventListener() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.4
                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostDestroy() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostPause() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostResume() {
                    if (ReactNativeBlobUtilImpl.ActionViewVisible) {
                        promise.resolve(null);
                    }
                    ReactNativeBlobUtilImpl.RCTContext.removeLifecycleEventListener(this);
                }
            });
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    public void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        ReactNativeBlobUtilStream.writeArrayChunk(str, readableArray, callback);
    }

    public void unlink(String str, Callback callback) {
        ReactNativeBlobUtilFS.unlink(str, callback);
    }

    public void mkdir(String str, Promise promise) {
        ReactNativeBlobUtilFS.mkdir(str, promise);
    }

    public void exists(String str, Callback callback) {
        ReactNativeBlobUtilFS.exists(str, callback);
    }

    /* JADX INFO: renamed from: cp */
    public void m428cp(final String str, final String str2, final Callback callback) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.5
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.m424cp(str, str2, callback);
            }
        });
    }

    /* JADX INFO: renamed from: mv */
    public void m431mv(String str, String str2, Callback callback) {
        ReactNativeBlobUtilFS.m427mv(str, str2, callback);
    }

    /* JADX INFO: renamed from: ls */
    public void m430ls(String str, Promise promise) {
        ReactNativeBlobUtilFS.m426ls(str, promise);
    }

    public void writeStream(String str, String str2, boolean z, Callback callback) {
        new ReactNativeBlobUtilStream(RCTContext).writeStream(str, str2, z, callback);
    }

    public void writeChunk(String str, String str2, Callback callback) {
        ReactNativeBlobUtilStream.writeChunk(str, str2, callback);
    }

    public void closeStream(String str, Callback callback) {
        ReactNativeBlobUtilStream.closeStream(str, callback);
    }

    public void removeSession(ReadableArray readableArray, Callback callback) {
        ReactNativeBlobUtilFS.removeSession(readableArray, callback);
    }

    public void readFile(final String str, final String str2, final boolean z, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.6
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.readFile(str, str2, z, promise);
            }
        });
    }

    public void writeFileArray(final String str, final ReadableArray readableArray, final boolean z, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.7
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.writeFile(str, readableArray, z, promise);
            }
        });
    }

    public void writeFile(final String str, final String str2, final String str3, final boolean z, final boolean z2, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.8
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.writeFile(str, str2, str3, z, z2, promise);
            }
        });
    }

    public void lstat(String str, Callback callback) {
        ReactNativeBlobUtilFS.lstat(str, callback);
    }

    public void stat(String str, Callback callback) {
        ReactNativeBlobUtilFS.stat(str, callback);
    }

    public void scanFile(final ReadableArray readableArray, final Callback callback) {
        final ReactApplicationContext reactApplicationContext = RCTContext;
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.9
            @Override // java.lang.Runnable
            public void run() {
                int size = readableArray.size();
                String[] strArr = new String[size];
                String[] strArr2 = new String[size];
                for (int i = 0; i < size; i++) {
                    ReadableMap map = readableArray.getMap(i);
                    if (map.hasKey("path")) {
                        strArr[i] = map.getString("path");
                        if (map.hasKey("mime")) {
                            strArr2[i] = map.getString("mime");
                        } else {
                            strArr2[i] = null;
                        }
                    }
                }
                new ReactNativeBlobUtilFS(reactApplicationContext).scanFile(strArr, strArr2, callback);
            }
        });
    }

    public void hash(final String str, final String str2, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.10
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.hash(str, str2, promise);
            }
        });
    }

    public void readStream(final String str, final String str2, final int i, final int i2, final String str3) {
        final ReactApplicationContext reactApplicationContext = RCTContext;
        fsThreadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.11
            @Override // java.lang.Runnable
            public void run() {
                new ReactNativeBlobUtilStream(reactApplicationContext).readStream(str, str2, i, i2, str3, ReactNativeBlobUtilImpl.RCTContext);
            }
        });
    }

    public void cancelRequest(String str, Callback callback) {
        try {
            ReactNativeBlobUtilReq.cancelTask(str);
            callback.invoke(null, str);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    public void slice(String str, String str2, long j, long j2, Promise promise) {
        ReactNativeBlobUtilFS.slice(str, str2, j, j2, "", promise);
    }

    public void enableProgressReport(String str, int i, int i2) {
        ReactNativeBlobUtilReq.progressReport.put(str, new ReactNativeBlobUtilProgressConfig(true, i, i2, ReactNativeBlobUtilProgressConfig.ReportType.Download));
    }

    /* JADX INFO: renamed from: df */
    public void m429df(final Callback callback) {
        fsThreadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.12
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.m425df(callback, ReactNativeBlobUtilImpl.RCTContext);
            }
        });
    }

    public void enableUploadProgressReport(String str, int i, int i2) {
        ReactNativeBlobUtilReq.uploadProgressReport.put(str, new ReactNativeBlobUtilProgressConfig(true, i, i2, ReactNativeBlobUtilProgressConfig.ReportType.Upload));
    }

    public void fetchBlob(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, Callback callback) {
        new ReactNativeBlobUtilReq(readableMap, str, str2, str3, readableMap2, str4, null, this.mClient, callback).run();
    }

    public void fetchBlobForm(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, ReadableArray readableArray, Callback callback) {
        new ReactNativeBlobUtilReq(readableMap, str, str2, str3, readableMap2, null, readableArray, this.mClient, callback).run();
    }

    public void getContentIntent(String str, Promise promise) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        if (str != null) {
            intent.setType(str);
        } else {
            intent.setType("*/*");
        }
        SparseArray sparseArray = promiseTable;
        Integer num = ReactNativeBlobUtilConst.GET_CONTENT_INTENT;
        sparseArray.put(num.intValue(), promise);
        RCTContext.startActivityForResult(intent, num.intValue(), null);
    }

    public void addCompleteDownload(ReadableMap readableMap, Promise promise) {
        DownloadManager downloadManager = (DownloadManager) RCTContext.getSystemService("download");
        if (readableMap == null || !readableMap.hasKey("path")) {
            promise.reject("EINVAL", "ReactNativeBlobUtil.addCompleteDownload config or path missing.");
            return;
        }
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(readableMap.getString("path"));
        if (strNormalizePath == null) {
            promise.reject("EINVAL", "ReactNativeBlobUtil.addCompleteDownload can not resolve URI:" + readableMap.getString("path"));
            return;
        }
        try {
            downloadManager.addCompletedDownload(readableMap.hasKey("title") ? readableMap.getString("title") : "", readableMap.hasKey("description") ? readableMap.getString("description") : "", true, readableMap.hasKey("mime") ? readableMap.getString("mime") : null, strNormalizePath, Long.valueOf(ReactNativeBlobUtilFS.statFile(strNormalizePath).getString(TCEventPropertiesNames.TCP_SIZE)).longValue(), readableMap.hasKey("showNotification") && readableMap.getBoolean("showNotification"));
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    public void getSDCardDir(Promise promise) {
        ReactNativeBlobUtilFS.getSDCardDir(RCTContext, promise);
    }

    public void getSDCardApplicationDir(Promise promise) {
        ReactNativeBlobUtilFS.getSDCardApplicationDir(RCTContext, promise);
    }

    public void createMediaFile(ReadableMap readableMap, String str, Promise promise) {
        if (!readableMap.hasKey("name") || !readableMap.hasKey("parentFolder") || !readableMap.hasKey("mimeType")) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid filedata: " + readableMap.toString());
            return;
        }
        if (str == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid mediatype");
        }
        Uri uriCreateNewMediaFile = ReactNativeBlobUtilMediaCollection.createNewMediaFile(new FileDescription(readableMap.getString("name"), readableMap.getString("mimeType"), readableMap.getString("parentFolder")), ReactNativeBlobUtilMediaCollection.MediaType.valueOf(str), RCTContext);
        if (uriCreateNewMediaFile != null) {
            promise.resolve(uriCreateNewMediaFile.toString());
        } else {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "File could not be created");
        }
    }

    public void writeToMediaFile(String str, String str2, boolean z, Promise promise) {
        if (ReactNativeBlobUtilMediaCollection.writeToMediaFile(Uri.parse(str), str2, z, promise, RCTContext)) {
            promise.resolve("Success");
        }
    }

    public void copyToInternal(String str, String str2, Promise promise) {
        ReactNativeBlobUtilMediaCollection.copyToInternal(Uri.parse(str), str2, promise);
    }

    public void getBlob(String str, String str2, Promise promise) {
        ReactNativeBlobUtilMediaCollection.getBlob(Uri.parse(str), str2, promise);
    }

    public void copyToMediaStore(ReadableMap readableMap, String str, String str2, Promise promise) {
        if (!readableMap.hasKey("name") || !readableMap.hasKey("parentFolder") || !readableMap.hasKey("mimeType")) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid filedata: " + readableMap.toString());
            return;
        }
        if (str == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid mediatype");
            return;
        }
        if (str2 == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid path");
            return;
        }
        Uri uriCreateNewMediaFile = ReactNativeBlobUtilMediaCollection.createNewMediaFile(new FileDescription(readableMap.getString("name"), readableMap.getString("mimeType"), readableMap.getString("parentFolder")), ReactNativeBlobUtilMediaCollection.MediaType.valueOf(str), RCTContext);
        if (uriCreateNewMediaFile == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "File could not be created");
        } else if (ReactNativeBlobUtilMediaCollection.writeToMediaFile(uriCreateNewMediaFile, str2, false, promise, RCTContext)) {
            promise.resolve(uriCreateNewMediaFile.toString());
        }
    }
}

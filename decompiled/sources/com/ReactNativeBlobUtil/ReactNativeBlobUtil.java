package com.ReactNativeBlobUtil;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.SparseArray;
import androidx.core.content.FileProvider;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilProgressConfig;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.io.File;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public class ReactNativeBlobUtil extends ReactContextBaseJavaModule {
    private static boolean ActionViewVisible;
    static ReactApplicationContext RCTContext;
    static LinkedBlockingQueue<Runnable> fsTaskQueue;
    private static final ThreadPoolExecutor fsThreadPool;
    private static final SparseArray<Promise> promiseTable;
    private static final LinkedBlockingQueue<Runnable> taskQueue;
    private static final ThreadPoolExecutor threadPool;
    private final OkHttpClient mClient;

    static {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        taskQueue = linkedBlockingQueue;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        threadPool = new ThreadPoolExecutor(5, 10, 5000L, timeUnit, linkedBlockingQueue);
        fsTaskQueue = new LinkedBlockingQueue<>();
        fsThreadPool = new ThreadPoolExecutor(2, 10, 5000L, timeUnit, linkedBlockingQueue);
        ActionViewVisible = false;
        promiseTable = new SparseArray<>();
    }

    public ReactNativeBlobUtil(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        OkHttpClient okHttpClient = OkHttpClientProvider.getOkHttpClient();
        this.mClient = okHttpClient;
        ((CookieJarContainer) okHttpClient.cookieJar()).setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler(reactApplicationContext)));
        RCTContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(new ActivityEventListener() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.1
            @Override // com.facebook.react.bridge.ActivityEventListener
            public void onNewIntent(Intent intent) {
            }

            @Override // com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                Integer num = ReactNativeBlobUtilConst.GET_CONTENT_INTENT;
                if (i == num.intValue() && i2 == -1) {
                    ((Promise) ReactNativeBlobUtil.promiseTable.get(num.intValue())).resolve(intent.getData().toString());
                    ReactNativeBlobUtil.promiseTable.remove(num.intValue());
                }
            }
        });
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ReactNativeBlobUtil";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return ReactNativeBlobUtilFS.getSystemfolders(getReactApplicationContext());
    }

    @ReactMethod
    public void createFile(final String str, final String str2, final String str3, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.2
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.createFile(str, str2, str3, promise);
            }
        });
    }

    @ReactMethod
    public void createFileASCII(final String str, final ReadableArray readableArray, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.3
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.createFileASCII(str, readableArray, promise);
            }
        });
    }

    @ReactMethod
    public void actionViewIntent(String str, String str2, @Nullable String str3, final Promise promise) {
        try {
            Uri uriForFile = FileProvider.getUriForFile(getReactApplicationContext(), getReactApplicationContext().getPackageName() + ".provider", new File(str));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriForFile, str2);
            intent.setFlags(1);
            intent.addFlags(268435456);
            if (str3 != null) {
                intent = Intent.createChooser(intent, str3);
            }
            try {
                getReactApplicationContext().startActivity(intent);
                promise.resolve(Boolean.TRUE);
            } catch (ActivityNotFoundException unused) {
                promise.reject("ENOAPP", "No app installed for " + str2);
            }
            ActionViewVisible = true;
            RCTContext.addLifecycleEventListener(new LifecycleEventListener() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.4
                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostDestroy() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostPause() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostResume() {
                    if (ReactNativeBlobUtil.ActionViewVisible) {
                        promise.resolve(null);
                    }
                    ReactNativeBlobUtil.RCTContext.removeLifecycleEventListener(this);
                }
            });
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        ReactNativeBlobUtilFS.writeArrayChunk(str, readableArray, callback);
    }

    @ReactMethod
    public void unlink(String str, Callback callback) {
        ReactNativeBlobUtilFS.unlink(str, callback);
    }

    @ReactMethod
    public void mkdir(String str, Promise promise) {
        ReactNativeBlobUtilFS.mkdir(str, promise);
    }

    @ReactMethod
    public void exists(String str, Callback callback) {
        ReactNativeBlobUtilFS.exists(str, callback);
    }

    @ReactMethod
    public void cp(final String str, final String str2, final Callback callback) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.5
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.cp(str, str2, callback);
            }
        });
    }

    @ReactMethod
    public void mv(String str, String str2, Callback callback) {
        ReactNativeBlobUtilFS.mv(str, str2, callback);
    }

    @ReactMethod
    public void ls(String str, Promise promise) {
        ReactNativeBlobUtilFS.ls(str, promise);
    }

    @ReactMethod
    public void writeStream(String str, String str2, boolean z, Callback callback) {
        new ReactNativeBlobUtilFS(getReactApplicationContext()).writeStream(str, str2, z, callback);
    }

    @ReactMethod
    public void writeChunk(String str, String str2, Callback callback) {
        ReactNativeBlobUtilFS.writeChunk(str, str2, callback);
    }

    @ReactMethod
    public void closeStream(String str, Callback callback) {
        ReactNativeBlobUtilFS.closeStream(str, callback);
    }

    @ReactMethod
    public void removeSession(ReadableArray readableArray, Callback callback) {
        ReactNativeBlobUtilFS.removeSession(readableArray, callback);
    }

    @ReactMethod
    public void readFile(final String str, final String str2, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.6
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.readFile(str, str2, promise);
            }
        });
    }

    @ReactMethod
    public void writeFileArray(final String str, final ReadableArray readableArray, final boolean z, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.7
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.writeFile(str, readableArray, z, promise);
            }
        });
    }

    @ReactMethod
    public void writeFile(final String str, final String str2, final String str3, final boolean z, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.8
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.writeFile(str, str2, str3, z, promise);
            }
        });
    }

    @ReactMethod
    public void lstat(String str, Callback callback) {
        ReactNativeBlobUtilFS.lstat(str, callback);
    }

    @ReactMethod
    public void stat(String str, Callback callback) {
        ReactNativeBlobUtilFS.stat(str, callback);
    }

    @ReactMethod
    public void scanFile(final ReadableArray readableArray, final Callback callback) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.9
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

    @ReactMethod
    public void hash(final String str, final String str2, final Promise promise) {
        threadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.10
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.hash(str, str2, promise);
            }
        });
    }

    @ReactMethod
    public void readStream(final String str, final String str2, final int i, final int i2, final String str3) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        fsThreadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.11
            @Override // java.lang.Runnable
            public void run() {
                new ReactNativeBlobUtilFS(reactApplicationContext).readStream(str, str2, i, i2, str3);
            }
        });
    }

    @ReactMethod
    public void cancelRequest(String str, Callback callback) {
        try {
            ReactNativeBlobUtilReq.cancelTask(str);
            callback.invoke(null, str);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    @ReactMethod
    public void slice(String str, String str2, int i, int i2, Promise promise) {
        ReactNativeBlobUtilFS.slice(str, str2, i, i2, "", promise);
    }

    @ReactMethod
    public void enableProgressReport(String str, int i, int i2) {
        ReactNativeBlobUtilReq.progressReport.put(str, new ReactNativeBlobUtilProgressConfig(true, i, i2, ReactNativeBlobUtilProgressConfig.ReportType.Download));
    }

    @ReactMethod
    public void df(final Callback callback) {
        fsThreadPool.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtil.12
            @Override // java.lang.Runnable
            public void run() {
                ReactNativeBlobUtilFS.df(callback, ReactNativeBlobUtil.this.getReactApplicationContext());
            }
        });
    }

    @ReactMethod
    public void enableUploadProgressReport(String str, int i, int i2) {
        ReactNativeBlobUtilReq.uploadProgressReport.put(str, new ReactNativeBlobUtilProgressConfig(true, i, i2, ReactNativeBlobUtilProgressConfig.ReportType.Upload));
    }

    @ReactMethod
    public void fetchBlob(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, Callback callback) {
        new ReactNativeBlobUtilReq(readableMap, str, str2, str3, readableMap2, str4, null, this.mClient, callback).run();
    }

    @ReactMethod
    public void fetchBlobForm(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, ReadableArray readableArray, Callback callback) {
        new ReactNativeBlobUtilReq(readableMap, str, str2, str3, readableMap2, null, readableArray, this.mClient, callback).run();
    }

    @ReactMethod
    public void getContentIntent(String str, Promise promise) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        if (str != null) {
            intent.setType(str);
        } else {
            intent.setType("*/*");
        }
        SparseArray<Promise> sparseArray = promiseTable;
        Integer num = ReactNativeBlobUtilConst.GET_CONTENT_INTENT;
        sparseArray.put(num.intValue(), promise);
        getReactApplicationContext().startActivityForResult(intent, num.intValue(), null);
    }

    @ReactMethod
    public void addCompleteDownload(ReadableMap readableMap, Promise promise) {
        DownloadManager downloadManager = (DownloadManager) RCTContext.getSystemService("download");
        if (readableMap == null || !readableMap.hasKey("path")) {
            promise.reject("EINVAL", "ReactNativeBlobUtil.addCompleteDownload config or path missing.");
            return;
        }
        String strNormalizePath = ReactNativeBlobUtilFS.normalizePath(readableMap.getString("path"));
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

    @ReactMethod
    public void getSDCardDir(Promise promise) {
        ReactNativeBlobUtilFS.getSDCardDir(getReactApplicationContext(), promise);
    }

    @ReactMethod
    public void getSDCardApplicationDir(Promise promise) {
        ReactNativeBlobUtilFS.getSDCardApplicationDir(getReactApplicationContext(), promise);
    }
}

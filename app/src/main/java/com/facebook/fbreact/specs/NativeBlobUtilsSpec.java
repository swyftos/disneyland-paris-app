package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeBlobUtilsSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "ReactNativeBlobUtil";

    @DoNotStrip
    @ReactMethod
    public abstract void actionViewIntent(String str, String str2, String str3, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void addCompleteDownload(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void cancelRequest(String str, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void closeStream(String str, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void copyToInternal(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void copyToMediaStore(ReadableMap readableMap, String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    /* JADX INFO: renamed from: cp */
    public abstract void mo420cp(String str, String str2, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void createFile(String str, String str2, String str3, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void createFileASCII(String str, ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void createMediaFile(ReadableMap readableMap, String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    /* JADX INFO: renamed from: df */
    public abstract void mo421df(Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void emitExpiredEvent(Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void enableProgressReport(String str, double d, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void enableUploadProgressReport(String str, double d, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void excludeFromBackupKey(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void exists(String str, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void fetchBlob(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void fetchBlobForm(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, ReadableArray readableArray, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void getBlob(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getContentIntent(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getEnvironmentDirs(Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void getSDCardApplicationDir(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getSDCardDir(Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @DoNotStrip
    @ReactMethod
    public abstract void hash(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    /* JADX INFO: renamed from: ls */
    public abstract void mo422ls(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void lstat(String str, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void mkdir(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    /* JADX INFO: renamed from: mv */
    public abstract void mo423mv(String str, String str2, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void pathForAppGroup(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void presentOpenInMenu(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void presentOptionsMenu(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void presentPreview(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void readFile(String str, String str2, boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void readStream(String str, String str2, double d, double d2, String str3);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void removeSession(ReadableArray readableArray, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void scanFile(ReadableArray readableArray, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void slice(String str, String str2, double d, double d2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void stat(String str, Callback callback);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String syncPathAppGroup(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void unlink(String str, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void writeArrayChunk(String str, ReadableArray readableArray, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void writeChunk(String str, String str2, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void writeFile(String str, String str2, String str3, boolean z, boolean z2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void writeFileArray(String str, ReadableArray readableArray, boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void writeStream(String str, String str2, boolean z, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void writeToMediaFile(String str, String str2, boolean z, Promise promise);

    public NativeBlobUtilsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @DoNotStrip
    @Nullable
    public final Map<String, Object> getConstants() {
        Map<String, Object> typedExportedConstants = getTypedExportedConstants();
        if (ReactBuildConfig.DEBUG || ReactBuildConfig.IS_INTERNAL_BUILD) {
            HashSet hashSet = new HashSet(Arrays.asList("ApplicationSupportDir", "CacheDir", "DCIMDir", "DocumentDir", "DownloadDir", "LegacyDCIMDir", "LegacyDownloadDir", "LegacyMovieDir", "LegacyMusicDir", "LegacyPictureDir", "LegacyRingtoneDir", "LegacySDCardDir", "LibraryDir", "MainBundleDir", "MovieDir", "MusicDir", "PictureDir", "RingtoneDir", "SDCardApplicationDir", "SDCardDir"));
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet(typedExportedConstants.keySet());
            hashSet3.removeAll(hashSet);
            hashSet3.removeAll(hashSet2);
            if (!hashSet3.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module Flow doesn't declare constants: %s", hashSet3));
            }
            hashSet.removeAll(typedExportedConstants.keySet());
            if (!hashSet.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module doesn't fill in constants: %s", hashSet));
            }
        }
        return typedExportedConstants;
    }
}

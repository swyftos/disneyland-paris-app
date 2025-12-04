package io.invertase.firebase.utils;

import android.app.Activity;
import android.content.IntentSender;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.messaging.Constants;
import io.invertase.firebase.app.ReactNativeFirebaseApp;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.picocontainer.Characteristics;

/* loaded from: classes5.dex */
public class ReactNativeFirebaseUtilsModule extends ReactNativeFirebaseModule {
    private static final String FIREBASE_TEST_LAB = "firebase.test.lab";
    private static final String KEY_CACHE_DIRECTORY = "CACHES_DIRECTORY";
    private static final String KEY_DOCUMENT_DIRECTORY = "DOCUMENT_DIRECTORY";
    private static final String KEY_EXTERNAL_DIRECTORY = "EXTERNAL_DIRECTORY";
    private static final String KEY_EXT_STORAGE_DIRECTORY = "EXTERNAL_STORAGE_DIRECTORY";
    private static final String KEY_LIBRARY_DIRECTORY = "LIBRARY_DIRECTORY";
    private static final String KEY_MAIN_BUNDLE = "MAIN_BUNDLE";
    private static final String KEY_MOVIES_DIRECTORY = "MOVIES_DIRECTORY";
    private static final String KEY_PICS_DIRECTORY = "PICTURES_DIRECTORY";
    private static final String KEY_TEMP_DIRECTORY = "TEMP_DIRECTORY";
    private static final String TAG = "Utils";

    public ReactNativeFirebaseUtilsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
    }

    private static Boolean isRunningInTestLab() {
        return Boolean.valueOf(Characteristics.TRUE.equals(Settings.System.getString(ReactNativeFirebaseApp.getApplicationContext().getContentResolver(), FIREBASE_TEST_LAB)));
    }

    @ReactMethod
    public void androidGetPlayServicesStatus(Promise promise) {
        promise.resolve(getPlayServicesStatusMap());
    }

    @ReactMethod
    public void androidPromptForPlayServices() {
        Activity activity;
        int iIsGooglePlayServicesAvailable = isGooglePlayServicesAvailable();
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (iIsGooglePlayServicesAvailable == 0 || !googleApiAvailability.isUserResolvableError(iIsGooglePlayServicesAvailable) || (activity = getActivity()) == null) {
            return;
        }
        googleApiAvailability.getErrorDialog(activity, iIsGooglePlayServicesAvailable, iIsGooglePlayServicesAvailable).show();
    }

    @ReactMethod
    public void androidResolutionForPlayServices() {
        Activity activity;
        int iIsGooglePlayServicesAvailable = isGooglePlayServicesAvailable();
        ConnectionResult connectionResult = new ConnectionResult(iIsGooglePlayServicesAvailable);
        if (connectionResult.isSuccess() || !connectionResult.hasResolution() || (activity = getActivity()) == null) {
            return;
        }
        try {
            connectionResult.startResolutionForResult(activity, iIsGooglePlayServicesAvailable);
        } catch (IntentSender.SendIntentException e) {
            Log.d(TAG, "resolutionForPlayServices", e);
        }
    }

    @ReactMethod
    public void androidMakePlayServicesAvailable() {
        Activity activity;
        if (isGooglePlayServicesAvailable() == 0 || (activity = getActivity()) == null) {
            return;
        }
        GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(activity);
    }

    private int isGooglePlayServicesAvailable() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getContext());
    }

    private WritableMap getPlayServicesStatusMap() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(getContext());
        writableMapCreateMap.putInt("status", iIsGooglePlayServicesAvailable);
        if (iIsGooglePlayServicesAvailable == 0) {
            writableMapCreateMap.putBoolean("isAvailable", true);
        } else {
            writableMapCreateMap.putBoolean("isAvailable", false);
            writableMapCreateMap.putString(Constants.IPC_BUNDLE_KEY_SEND_ERROR, googleApiAvailability.getErrorString(iIsGooglePlayServicesAvailable));
            writableMapCreateMap.putBoolean("isUserResolvableError", googleApiAvailability.isUserResolvableError(iIsGooglePlayServicesAvailable));
            writableMapCreateMap.putBoolean("hasResolution", new ConnectionResult(iIsGooglePlayServicesAvailable).hasResolution());
        }
        return writableMapCreateMap;
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("isRunningInTestLab", isRunningInTestLab());
        map.put("androidPlayServices", getPlayServicesStatusMap());
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        map.put(KEY_MAIN_BUNDLE, "");
        map.put(KEY_LIBRARY_DIRECTORY, reactApplicationContext.getFilesDir().getAbsolutePath());
        map.put(KEY_TEMP_DIRECTORY, reactApplicationContext.getCacheDir().getAbsolutePath());
        map.put(KEY_CACHE_DIRECTORY, reactApplicationContext.getCacheDir().getAbsolutePath());
        map.put(KEY_DOCUMENT_DIRECTORY, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath());
        map.put(KEY_PICS_DIRECTORY, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        map.put(KEY_MOVIES_DIRECTORY, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            map.put(KEY_EXT_STORAGE_DIRECTORY, externalStorageDirectory.getAbsolutePath());
        }
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            map.put(KEY_EXTERNAL_DIRECTORY, externalFilesDir.getAbsolutePath());
        }
        return map;
    }
}

package com.contentsquare.android.core.features.config.network;

import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.allegion.accesssdk.BuildConfig;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.http.HttpResponse;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.BuildConfigInstantiable;
import com.contentsquare.android.core.utils.UriBuilder;
import java.util.HashMap;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public class ConfigRetrieverTask extends AsyncTask<String, Void, Void> {
    private static final int EXPONENTIAL_BACKOFF_MSEC_INIT = 1000;
    private static final String HEADER_USER_ID = "uid";
    private static final int MAX_FETCH_TRY = 4;

    @NonNull
    private final BuildConfigInstantiable mBuildConfig;

    @NonNull
    private final ConfigProviderCallback mCallback;

    @NonNull
    private final Configuration mConfiguration;

    @NonNull
    private final HttpConnection mHttpConnection;

    @Nullable
    private final String mUserId;
    private int mMaxFetchTry = 4;
    private int mExponentialBackOffMsecInit = 1000;

    @NonNull
    private final Logger mLogger = new Logger("ConfigRetrieverTask");
    private boolean mUseCallBackDuringOnPostExecute = false;

    public interface ConfigProviderCallback {
        void processConfig();
    }

    public ConfigRetrieverTask(String str, Configuration configuration, ConfigProviderCallback configProviderCallback, HttpConnection httpConnection, BuildConfigInstantiable buildConfigInstantiable) {
        this.mConfiguration = configuration;
        this.mCallback = configProviderCallback;
        this.mHttpConnection = httpConnection;
        this.mUserId = str;
        this.mBuildConfig = buildConfigInstantiable;
    }

    @Nullable
    private String fetchConfig(String str, String str2, int i) throws InterruptedException {
        HashMap map = new HashMap();
        if (this.mUserId != null && this.mBuildConfig.getBuildType().equals(BuildConfig.FLAVOR)) {
            map.put(HEADER_USER_ID, this.mUserId);
        }
        if (!this.mConfiguration.getLastETag().isEmpty()) {
            map.put("If-None-Match", this.mConfiguration.getLastETag());
        }
        HttpResponse httpResponsePerformHttpGet = this.mHttpConnection.performHttpGet(str, map);
        if (httpResponsePerformHttpGet.success()) {
            this.mLogger.d("Got HTTP_OK for endpoint: " + str);
            String stringResponse = httpResponsePerformHttpGet.getStringResponse();
            if (!TextUtils.isEmpty(stringResponse)) {
                List<String> list = httpResponsePerformHttpGet.getHeaders().get("ETag");
                this.mConfiguration.setLastETag((list == null || list.isEmpty()) ? "" : list.get(0));
                this.mLogger.d("Got remote config " + stringResponse);
                return stringResponse;
            }
        } else if (httpResponsePerformHttpGet.getStatus() == 304) {
            this.mLogger.d("Got HTTP Not-Modified: current config still valid, do nothing.");
            return null;
        }
        if (httpResponsePerformHttpGet.getStatus() == 404) {
            this.mLogger.e("Got HTTP_NOT_FOUND for endpoint " + str);
            this.mLogger.p("Config for package name '" + str2 + "' could not be retrieved. A Contentsquare project might not have been created for you yet. Send your package name to your Contentsquare contact.");
        }
        if (httpResponsePerformHttpGet.getStatus() >= 400) {
            this.mLogger.i("Failed to fetch config for " + str2 + ". Network error: " + httpResponsePerformHttpGet.getStatus());
        }
        int i2 = i - 1;
        int i3 = this.mMaxFetchTry - i2;
        if (i2 <= 0) {
            return null;
        }
        this.mLogger.w("retrying the conf fetch for the " + i3 + "th time");
        try {
            int iPow = (int) (this.mExponentialBackOffMsecInit * Math.pow(i3, 2.0d));
            this.mLogger.d("sleeping " + iPow + " msec before the next retry");
            Thread.sleep((long) iPow);
        } catch (InterruptedException e) {
            this.mLogger.e(e, "Config fetch interrupted.");
        }
        return fetchConfig(str, str2, i2);
    }

    public void setExponentialBackoffMsecInit(int i) {
        this.mExponentialBackOffMsecInit = i;
    }

    public void setMaxFetchTry(int i) {
        this.mMaxFetchTry = i;
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(String... strArr) throws InterruptedException {
        String str = strArr[0];
        String strFetchConfig = fetchConfig(UriBuilder.buildProjectConfigUrl(str), str, this.mMaxFetchTry);
        JsonConfig.RootConfig rootConfigDecodeFromString = !TextUtils.isEmpty(strFetchConfig) ? JsonConfig.decodeFromString(strFetchConfig) : null;
        if (rootConfigDecodeFromString == null || !this.mConfiguration.hasConfigChanged(rootConfigDecodeFromString)) {
            this.mLogger.d("The config fetched from CS servers is the same as the one saved in the device");
        } else {
            this.mConfiguration.saveToStorage(strFetchConfig);
            this.mUseCallBackDuringOnPostExecute = true;
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Void r1) {
        if (!this.mUseCallBackDuringOnPostExecute) {
            this.mLogger.d("callback not called");
        } else {
            this.mUseCallBackDuringOnPostExecute = false;
            this.mCallback.processConfig();
        }
    }
}

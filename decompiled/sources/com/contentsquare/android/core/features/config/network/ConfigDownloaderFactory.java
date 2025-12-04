package com.contentsquare.android.core.features.config.network;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.network.ConfigRetrieverTask;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.utils.BuildConfigInstantiable;

/* loaded from: classes2.dex */
public class ConfigDownloaderFactory {

    @NonNull
    private final HttpConnection mHttpConnection;

    public ConfigDownloaderFactory() {
        this.mHttpConnection = new HttpConnection();
    }

    @NonNull
    public ConfigurationDownloader produceConfigDownloader(Configuration configuration) {
        return new ConfigurationDownloader(configuration, this.mHttpConnection, new BuildConfigInstantiable());
    }

    @NonNull
    public ConfigRetrieverTask produceConfigRetrieverTask(String str, Configuration configuration, ConfigRetrieverTask.ConfigProviderCallback configProviderCallback) {
        return new ConfigRetrieverTask(str, configuration, configProviderCallback, this.mHttpConnection, new BuildConfigInstantiable());
    }

    @VisibleForTesting
    public ConfigDownloaderFactory(HttpConnection httpConnection) {
        this.mHttpConnection = httpConnection;
    }
}

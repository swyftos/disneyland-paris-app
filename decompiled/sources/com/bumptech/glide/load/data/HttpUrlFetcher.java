package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes2.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private final int timeout;
    private HttpURLConnection urlConnection;

    interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url);
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this(glideUrl, i, DEFAULT_CONNECTION_FACTORY);
    }

    HttpUrlFetcher(GlideUrl glideUrl, int i, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl;
        this.timeout = i;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long logTime = LogTime.getLogTime();
        try {
            try {
                dataCallback.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                dataCallback.onLoadFailed(e);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.getElapsedMillis(logTime));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(logTime));
            }
            throw th;
        }
    }

    private InputStream loadDataWithRedirects(URL url, int i, URL url2, Map map) throws IOException {
        if (i >= 5) {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionBuildAndConfigureConnection = buildAndConfigureConnection(url, map);
        this.urlConnection = httpURLConnectionBuildAndConfigureConnection;
        try {
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionBuildAndConfigureConnection);
            try {
                httpURLConnectionBuildAndConfigureConnection.connect();
                InstrumentationCallbacks.requestSent(httpURLConnectionBuildAndConfigureConnection);
                this.stream = InstrumentationCallbacks.getInputStream(this.urlConnection);
                if (this.isCancelled) {
                    return null;
                }
                int httpStatusCodeOrInvalid = getHttpStatusCodeOrInvalid(this.urlConnection);
                if (isHttpOk(httpStatusCodeOrInvalid)) {
                    return getStreamForSuccessfulRequest(this.urlConnection);
                }
                if (!isHttpRedirect(httpStatusCodeOrInvalid)) {
                    if (httpStatusCodeOrInvalid == -1) {
                        throw new HttpException(httpStatusCodeOrInvalid);
                    }
                    try {
                        HttpURLConnection httpURLConnection = this.urlConnection;
                        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                        try {
                            String responseMessage = httpURLConnection.getResponseMessage();
                            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                            throw new HttpException(responseMessage, httpStatusCodeOrInvalid);
                        } catch (IOException e) {
                            InstrumentationCallbacks.networkError(httpURLConnection, e);
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw new HttpException("Failed to get a response message", httpStatusCodeOrInvalid, e2);
                    }
                }
                HttpURLConnection httpURLConnection2 = this.urlConnection;
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
                try {
                    String headerField = httpURLConnection2.getHeaderField("Location");
                    InstrumentationCallbacks.requestHarvestable(httpURLConnection2);
                    if (TextUtils.isEmpty(headerField)) {
                        throw new HttpException("Received empty or null redirect url", httpStatusCodeOrInvalid);
                    }
                    try {
                        URL url3 = new URL(url, headerField);
                        cleanup();
                        return loadDataWithRedirects(url3, i + 1, url, map);
                    } catch (MalformedURLException e3) {
                        throw new HttpException("Bad redirect url: " + headerField, httpStatusCodeOrInvalid, e3);
                    }
                } catch (IOException e4) {
                    InstrumentationCallbacks.networkError(httpURLConnection2, e4);
                    throw e4;
                }
            } catch (IOException e5) {
                InstrumentationCallbacks.networkError(httpURLConnectionBuildAndConfigureConnection, e5);
                throw e5;
            }
        } catch (IOException e6) {
            throw new HttpException("Failed to connect or obtain data", getHttpStatusCodeOrInvalid(this.urlConnection), e6);
        }
    }

    private static int getHttpStatusCodeOrInvalid(HttpURLConnection httpURLConnection) throws IOException {
        try {
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                return responseCode;
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(httpURLConnection, e);
                throw e;
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e2);
            return -1;
        }
    }

    private HttpURLConnection buildAndConfigureConnection(URL url, Map map) throws HttpException {
        try {
            HttpURLConnection httpURLConnectionBuild = this.connectionFactory.build(url);
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnectionBuild.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnectionBuild.setConnectTimeout(this.timeout);
            httpURLConnectionBuild.setReadTimeout(this.timeout);
            httpURLConnectionBuild.setUseCaches(false);
            httpURLConnectionBuild.setDoInput(true);
            httpURLConnectionBuild.setInstanceFollowRedirects(false);
            return httpURLConnectionBuild;
        } catch (IOException e) {
            throw new HttpException("URL.openConnection threw", 0, e);
        }
    }

    private static boolean isHttpOk(int i) {
        return i / 100 == 2;
    }

    private static boolean isHttpRedirect(int i) {
        return i / 100 == 3;
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws IOException {
        try {
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                String contentEncoding = httpURLConnection.getContentEncoding();
                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                if (TextUtils.isEmpty(contentEncoding)) {
                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                    try {
                        int contentLength = httpURLConnection.getContentLength();
                        InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                        this.stream = ContentLengthInputStream.obtain(InstrumentationCallbacks.getInputStream(httpURLConnection), contentLength);
                    } catch (IOException e) {
                        InstrumentationCallbacks.networkError(httpURLConnection, e);
                        throw e;
                    }
                } else {
                    if (Log.isLoggable("HttpUrlFetcher", 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Got non empty content encoding: ");
                        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                        try {
                            String contentEncoding2 = httpURLConnection.getContentEncoding();
                            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                            sb.append(contentEncoding2);
                            Log.d("HttpUrlFetcher", sb.toString());
                        } catch (IOException e2) {
                            InstrumentationCallbacks.networkError(httpURLConnection, e2);
                            throw e2;
                        }
                    }
                    this.stream = InstrumentationCallbacks.getInputStream(httpURLConnection);
                }
                return this.stream;
            } catch (IOException e3) {
                InstrumentationCallbacks.networkError(httpURLConnection, e3);
                throw e3;
            }
        } catch (IOException e4) {
            throw new HttpException("Failed to obtain InputStream", getHttpStatusCodeOrInvalid(httpURLConnection), e4);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() throws IOException {
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.urlConnection = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection build(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }
}

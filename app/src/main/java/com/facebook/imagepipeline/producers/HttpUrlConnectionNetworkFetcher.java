package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.common.internal.Objects;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<HttpUrlConnectionNetworkFetchState> {
    public static final int HTTP_DEFAULT_TIMEOUT = 30000;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    private final ExecutorService mExecutorService;
    private int mHttpConnectionTimeout;
    private final MonotonicClock mMonotonicClock;
    private final Map mRequestHeaders;
    private String mUserAgent;

    private static boolean isHttpRedirect(int i) {
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    private static boolean isHttpSuccess(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ FetchState createFetchState(Consumer consumer, ProducerContext producerContext) {
        return createFetchState((Consumer<EncodedImage>) consumer, producerContext);
    }

    public static class HttpUrlConnectionNetworkFetchState extends FetchState {
        private long fetchCompleteTime;
        private long responseTime;
        private long submitTime;

        public HttpUrlConnectionNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public HttpUrlConnectionNetworkFetcher() {
        this((String) null, (Map) null, RealtimeSinceBootClock.get());
    }

    public HttpUrlConnectionNetworkFetcher(int i) {
        this((String) null, (Map) null, RealtimeSinceBootClock.get());
        this.mHttpConnectionTimeout = i;
    }

    public HttpUrlConnectionNetworkFetcher(String str, int i) {
        this(str, (Map) null, RealtimeSinceBootClock.get());
        this.mHttpConnectionTimeout = i;
    }

    public HttpUrlConnectionNetworkFetcher(String str, @Nullable Map<String, String> map, int i) {
        this(str, map, RealtimeSinceBootClock.get());
        this.mHttpConnectionTimeout = i;
    }

    HttpUrlConnectionNetworkFetcher(String str, Map map, MonotonicClock monotonicClock) {
        this.mExecutorService = Executors.newFixedThreadPool(3);
        this.mMonotonicClock = monotonicClock;
        this.mRequestHeaders = map;
        this.mUserAgent = str;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public HttpUrlConnectionNetworkFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new HttpUrlConnectionNetworkFetchState(consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(final HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, final NetworkFetcher.Callback callback) {
        httpUrlConnectionNetworkFetchState.submitTime = this.mMonotonicClock.now();
        final Future<?> futureSubmit = this.mExecutorService.submit(new Runnable() { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                HttpUrlConnectionNetworkFetcher.this.fetchSync(httpUrlConnectionNetworkFetchState, callback);
            }
        });
        httpUrlConnectionNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (futureSubmit.cancel(false)) {
                    callback.onCancellation();
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0045  */
    /* JADX WARN: Code duplicated, block: B:38:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:? A[SYNTHETIC] */
    void fetchSync(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, NetworkFetcher.Callback callback) throws Throwable {
        HttpURLConnection httpURLConnectionDownloadFrom;
        InputStream inputStream = null;
        try {
            httpURLConnectionDownloadFrom = downloadFrom(httpUrlConnectionNetworkFetchState.getUri(), 5);
            try {
                try {
                    httpUrlConnectionNetworkFetchState.responseTime = this.mMonotonicClock.now();
                    if (httpURLConnectionDownloadFrom != null) {
                        inputStream = InstrumentationCallbacks.getInputStream(httpURLConnectionDownloadFrom);
                        callback.onResponse(inputStream, -1);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (httpURLConnectionDownloadFrom == null) {
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (httpURLConnectionDownloadFrom != null) {
                        httpURLConnectionDownloadFrom.disconnect();
                        throw th;
                    }
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                callback.onFailure(e);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (httpURLConnectionDownloadFrom == null) {
                    return;
                }
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnectionDownloadFrom = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionDownloadFrom = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnectionDownloadFrom != null) {
                httpURLConnectionDownloadFrom.disconnect();
                throw th;
            }
            throw th;
        }
        httpURLConnectionDownloadFrom.disconnect();
    }

    private HttpURLConnection downloadFrom(Uri uri, int i) throws IOException {
        String strError;
        HttpURLConnection httpURLConnectionOpenConnectionTo = openConnectionTo(uri);
        String str = this.mUserAgent;
        if (str != null) {
            httpURLConnectionOpenConnectionTo.setRequestProperty("User-Agent", str);
        }
        Map map = this.mRequestHeaders;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnectionOpenConnectionTo.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        httpURLConnectionOpenConnectionTo.setConnectTimeout(this.mHttpConnectionTimeout);
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionOpenConnectionTo);
        try {
            int responseCode = httpURLConnectionOpenConnectionTo.getResponseCode();
            InstrumentationCallbacks.requestHarvestable(httpURLConnectionOpenConnectionTo);
            if (isHttpSuccess(responseCode)) {
                return httpURLConnectionOpenConnectionTo;
            }
            if (isHttpRedirect(responseCode)) {
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionOpenConnectionTo);
                try {
                    String headerField = httpURLConnectionOpenConnectionTo.getHeaderField("Location");
                    InstrumentationCallbacks.requestHarvestable(httpURLConnectionOpenConnectionTo);
                    httpURLConnectionOpenConnectionTo.disconnect();
                    Uri uri2 = headerField == null ? null : Uri.parse(headerField);
                    String scheme = uri.getScheme();
                    if (i > 0 && uri2 != null && !Objects.equal(uri2.getScheme(), scheme)) {
                        return downloadFrom(uri2, i - 1);
                    }
                    if (i == 0) {
                        strError = error("URL %s follows too many redirects", uri.toString());
                    } else {
                        strError = error("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode));
                    }
                    throw new IOException(strError);
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(httpURLConnectionOpenConnectionTo, e);
                    throw e;
                }
            }
            httpURLConnectionOpenConnectionTo.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        } catch (IOException e2) {
            InstrumentationCallbacks.networkError(httpURLConnectionOpenConnectionTo, e2);
            throw e2;
        }
    }

    static HttpURLConnection openConnectionTo(Uri uri) {
        return (HttpURLConnection) UriUtil.uriToUrl(uri).openConnection();
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public void onFetchCompletion(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, int i) {
        httpUrlConnectionNetworkFetchState.fetchCompleteTime = this.mMonotonicClock.now();
    }

    private static String error(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public Map<String, String> getExtraMap(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, int i) {
        HashMap map = new HashMap(4);
        map.put("queue_time", Long.toString(httpUrlConnectionNetworkFetchState.responseTime - httpUrlConnectionNetworkFetchState.submitTime));
        map.put("fetch_time", Long.toString(httpUrlConnectionNetworkFetchState.fetchCompleteTime - httpUrlConnectionNetworkFetchState.responseTime));
        map.put("total_time", Long.toString(httpUrlConnectionNetworkFetchState.fetchCompleteTime - httpUrlConnectionNetworkFetchState.submitTime));
        map.put("image_size", Integer.toString(i));
        return map;
    }
}

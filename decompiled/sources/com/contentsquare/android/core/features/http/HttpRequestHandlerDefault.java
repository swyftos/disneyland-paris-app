package com.contentsquare.android.core.features.http;

import androidx.annotation.VisibleForTesting;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/contentsquare/android/core/features/http/HttpRequestHandlerDefault;", "Lcom/contentsquare/android/core/features/http/HttpRequestHandler;", "()V", "handleGet", "Lcom/contentsquare/android/core/features/http/HttpResponse;", "options", "Lcom/contentsquare/android/core/features/http/RequestOptions;", "handlePost", "data", "", "openConnection", "Ljava/net/HttpURLConnection;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHttpRequestHandlerDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestHandlerDefault.kt\ncom/contentsquare/android/core/features/http/HttpRequestHandlerDefault\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,92:1\n1#2:93\n215#3,2:94\n*S KotlinDebug\n*F\n+ 1 HttpRequestHandlerDefault.kt\ncom/contentsquare/android/core/features/http/HttpRequestHandlerDefault\n*L\n86#1:94,2\n*E\n"})
/* loaded from: classes2.dex */
public final class HttpRequestHandlerDefault implements HttpRequestHandler {
    @Override // com.contentsquare.android.core.features.http.HttpRequestHandler
    @NotNull
    public HttpResponse handleGet(RequestOptions options) throws Throwable {
        HttpURLConnection httpURLConnectionOpenConnection;
        Intrinsics.checkNotNullParameter(options, "options");
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setEndpoint(options.getEndpoint());
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnectionOpenConnection = openConnection(options);
                try {
                    httpURLConnectionOpenConnection.setRequestMethod("GET");
                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionOpenConnection);
                } catch (Exception e) {
                    e = e;
                    httpURLConnection = httpURLConnectionOpenConnection;
                    httpResponse.setException(e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return httpResponse;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnectionOpenConnection;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                httpURLConnectionOpenConnection.connect();
                InstrumentationCallbacks.requestSent(httpURLConnectionOpenConnection);
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionOpenConnection);
                try {
                    int responseCode = httpURLConnectionOpenConnection.getResponseCode();
                    InstrumentationCallbacks.requestHarvestable(httpURLConnectionOpenConnection);
                    httpResponse.setStatus(responseCode);
                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionOpenConnection);
                    try {
                        Map<String, List<String>> headerFields = httpURLConnectionOpenConnection.getHeaderFields();
                        InstrumentationCallbacks.requestHarvestable(httpURLConnectionOpenConnection);
                        Intrinsics.checkNotNullExpressionValue(headerFields, "connection.headerFields");
                        httpResponse.setHeaders(headerFields);
                        InputStream inputStream = InstrumentationCallbacks.getInputStream(httpURLConnectionOpenConnection);
                        Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), 8192);
                        try {
                            String text = TextStreamsKt.readText(bufferedReader);
                            CloseableKt.closeFinally(bufferedReader, null);
                            httpResponse.setStringResponse(text);
                            httpURLConnectionOpenConnection.disconnect();
                            return httpResponse;
                        } finally {
                        }
                    } catch (IOException e3) {
                        InstrumentationCallbacks.networkError(httpURLConnectionOpenConnection, e3);
                        throw e3;
                    }
                } catch (IOException e4) {
                    InstrumentationCallbacks.networkError(httpURLConnectionOpenConnection, e4);
                    throw e4;
                }
            } catch (IOException e5) {
                InstrumentationCallbacks.networkError(httpURLConnectionOpenConnection, e5);
                throw e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.contentsquare.android.core.features.http.HttpRequestHandler
    @NotNull
    public HttpResponse handlePost(RequestOptions options, byte[] data) throws Throwable {
        HttpURLConnection httpURLConnectionOpenConnection;
        long jCurrentTimeMillis;
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(data, "data");
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setEndpoint(options.getEndpoint());
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnectionOpenConnection = openConnection(options);
                try {
                    httpURLConnectionOpenConnection.setRequestMethod("POST");
                    httpURLConnectionOpenConnection.setDoOutput(true);
                    jCurrentTimeMillis = System.currentTimeMillis();
                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionOpenConnection);
                    try {
                        OutputStream outputStream = httpURLConnectionOpenConnection.getOutputStream();
                        InstrumentationCallbacks.requestSent(httpURLConnectionOpenConnection);
                        outputStream.write(data);
                        outputStream.flush();
                        outputStream.close();
                        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionOpenConnection);
                    } catch (IOException e) {
                        InstrumentationCallbacks.networkError(httpURLConnectionOpenConnection, e);
                        throw e;
                    }
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnectionOpenConnection;
                    httpResponse.setException(e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return httpResponse;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnectionOpenConnection;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
            try {
                int responseCode = httpURLConnectionOpenConnection.getResponseCode();
                InstrumentationCallbacks.requestHarvestable(httpURLConnectionOpenConnection);
                httpResponse.setStatus(responseCode);
                httpResponse.setDataSentBytes(data.length);
                httpResponse.setTimeSpentMsec(System.currentTimeMillis() - jCurrentTimeMillis);
                InputStream inputStream = InstrumentationCallbacks.getInputStream(httpURLConnectionOpenConnection);
                Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    httpResponse.setStringResponse(text);
                    httpURLConnectionOpenConnection.disconnect();
                    return httpResponse;
                } finally {
                }
            } catch (IOException e4) {
                InstrumentationCallbacks.networkError(httpURLConnectionOpenConnection, e4);
                throw e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @VisibleForTesting
    @NotNull
    public final HttpURLConnection openConnection(RequestOptions options) throws IOException {
        Intrinsics.checkNotNullParameter(options, "options");
        URLConnection uRLConnectionOpenConnection = new URL(options.getEndpoint()).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestProperty("Charset", Charsets.UTF_8.name());
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setConnectTimeout(options.getTimeoutConnect());
        httpURLConnection.setReadTimeout(options.getTimeoutRead());
        for (Map.Entry<String, String> entry : options.getHeaders().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }
}

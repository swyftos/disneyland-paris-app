package com.urbanairship.http;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.disney.id.android.tracker.OneIDTracker;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.RateAppAction;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.ConnectionUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JX\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0011H\u0016J.\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u000bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/http/DefaultHttpClient;", "Lcom/urbanairship/http/HttpClient;", "()V", "execute", "Lcom/urbanairship/http/Response;", ExifInterface.GPS_DIRECTION_TRUE, "url", "Landroid/net/Uri;", "method", "", "headers", "", RateAppAction.BODY_KEY, "Lcom/urbanairship/http/RequestBody;", "followRedirects", "", "parser", "Lcom/urbanairship/http/ResponseParser;", "mapHeaders", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultHttpClient.kt\ncom/urbanairship/http/DefaultHttpClient\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,122:1\n215#2,2:123\n1#3:125\n453#4:126\n403#4:127\n1238#5,4:128\n*S KotlinDebug\n*F\n+ 1 DefaultHttpClient.kt\ncom/urbanairship/http/DefaultHttpClient\n*L\n48#1:123,2\n91#1:126\n91#1:127\n91#1:128,4\n*E\n"})
/* loaded from: classes5.dex */
public final class DefaultHttpClient implements HttpClient {
    @Override // com.urbanairship.http.HttpClient
    @NotNull
    public <T> Response<T> execute(@NotNull Uri url, @NotNull String method, @NotNull Map<String, String> headers, @Nullable RequestBody body, boolean followRedirects, @NotNull ResponseParser<T> parser) throws Throwable {
        String fully;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parser, "parser");
        try {
            URL url2 = new URL(url.toString());
            HttpURLConnection httpURLConnection = null;
            String fully2 = null;
            try {
                URLConnection uRLConnectionOpenSecureConnection = ConnectionUtils.openSecureConnection(UAirship.getApplicationContext(), url2);
                Intrinsics.checkNotNull(uRLConnectionOpenSecureConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenSecureConnection;
                try {
                    httpURLConnection2.setRequestMethod(method);
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setConnectTimeout(OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC);
                    httpURLConnection2.setReadTimeout(OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC);
                    httpURLConnection2.setAllowUserInteraction(false);
                    httpURLConnection2.setInstanceFollowRedirects(followRedirects);
                    for (Map.Entry<String, String> entry : headers.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    if (body != null) {
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setRequestProperty("Content-Type", body.getContentType());
                        if (body.getCompress()) {
                            httpURLConnection2.setRequestProperty("Content-Encoding", "gzip");
                        }
                        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
                        try {
                            OutputStream outputStream = httpURLConnection2.getOutputStream();
                            InstrumentationCallbacks.requestSent(httpURLConnection2);
                            try {
                                Intrinsics.checkNotNull(outputStream);
                                DefaultHttpClientKt.write(outputStream, body.getContent(), body.getCompress());
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(outputStream, null);
                            } finally {
                            }
                        } catch (IOException e) {
                            InstrumentationCallbacks.networkError(httpURLConnection2, e);
                            throw e;
                        }
                    }
                    try {
                        InputStream inputStream = InstrumentationCallbacks.getInputStream(httpURLConnection2);
                        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                        fully2 = DefaultHttpClientKt.readFully(inputStream);
                    } catch (IOException unused) {
                        InputStream errorStream = InstrumentationCallbacks.getErrorStream(httpURLConnection2);
                        if (errorStream == null || (fully = DefaultHttpClientKt.readFully(errorStream)) == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Error stream was null for response code: ");
                            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
                            try {
                                int responseCode = httpURLConnection2.getResponseCode();
                                InstrumentationCallbacks.requestHarvestable(httpURLConnection2);
                                sb.append(responseCode);
                                UALog.e(sb.toString(), new Object[0]);
                            } catch (IOException e2) {
                                InstrumentationCallbacks.networkError(httpURLConnection2, e2);
                                throw e2;
                            }
                        } else {
                            fully2 = fully;
                        }
                    }
                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
                    try {
                        Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                        InstrumentationCallbacks.requestHarvestable(httpURLConnection2);
                        Intrinsics.checkNotNullExpressionValue(headerFields, "getHeaderFields(...)");
                        Map<String, String> mapMapHeaders = mapHeaders(headerFields);
                        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
                        try {
                            int responseCode2 = httpURLConnection2.getResponseCode();
                            InstrumentationCallbacks.requestHarvestable(httpURLConnection2);
                            T response = parser.parseResponse(responseCode2, mapMapHeaders, fully2);
                            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
                            try {
                                int responseCode3 = httpURLConnection2.getResponseCode();
                                InstrumentationCallbacks.requestHarvestable(httpURLConnection2);
                                Response<T> response2 = new Response<>(responseCode3, response, fully2, mapMapHeaders);
                                httpURLConnection2.disconnect();
                                return response2;
                            } catch (IOException e3) {
                                InstrumentationCallbacks.networkError(httpURLConnection2, e3);
                                throw e3;
                            }
                        } catch (IOException e4) {
                            InstrumentationCallbacks.networkError(httpURLConnection2, e4);
                            throw e4;
                        }
                    } catch (IOException e5) {
                        InstrumentationCallbacks.networkError(httpURLConnection2, e5);
                        throw e5;
                    }
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (MalformedURLException e6) {
            throw new RequestException("Failed to build URL", e6);
        }
    }

    private final Map mapHeaders(Map headers) {
        String string;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(headers.size()));
        for (Map.Entry entry : headers.entrySet()) {
            Object key = entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                string = "";
            } else if (list.size() > 1) {
                string = JsonValue.wrapOpt(list).toString();
                Intrinsics.checkNotNull(string);
            } else {
                string = (String) CollectionsKt.first(list);
            }
            linkedHashMap.put(key, string);
        }
        return linkedHashMap;
    }
}

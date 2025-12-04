package com.contentsquare.android.error.analysis.network;

import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.communication.error.analysis.NetworkEventBuilder;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0001J\u001f\u0010\u001b\u001a\u00020\u00012\u0012\u0010\u001c\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e\u0018\u00010\u001d¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u0004\u0018\u00010\u0011J\u0006\u0010!\u001a\u00020\u001aJ\u0006\u0010\"\u001a\u00020\fJ\b\u0010#\u001a\u0004\u0018\u00010\u0011J\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\u0016J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0016J\b\u0010(\u001a\u0004\u0018\u00010)J\u0006\u0010*\u001a\u00020\fJ\u0010\u0010+\u001a\u0004\u0018\u00010\u00112\u0006\u0010,\u001a\u00020\u001aJ\u0012\u0010+\u001a\u0004\u0018\u00010\u00112\b\u0010-\u001a\u0004\u0018\u00010\u0011J\u0018\u0010.\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u00112\u0006\u0010/\u001a\u00020\fJ\u0018\u00100\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010\u00112\u0006\u00101\u001a\u00020\u001aJ\u0010\u00102\u001a\u0004\u0018\u00010\u00112\u0006\u0010,\u001a\u00020\u001aJ\u0018\u00103\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u00112\u0006\u00104\u001a\u00020\fJ\u0018\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110706J\u0006\u00108\u001a\u00020\fJ\b\u00109\u001a\u0004\u0018\u00010)J\u0006\u0010:\u001a\u00020\u0016J\u0006\u0010;\u001a\u00020\fJ\b\u0010<\u001a\u0004\u0018\u00010=J\b\u0010>\u001a\u0004\u0018\u00010?J\u0006\u0010@\u001a\u00020\u001aJ\b\u0010A\u001a\u0004\u0018\u00010\u0011J\u0018\u0010B\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110706J\u0012\u0010C\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010D\u001a\u00020\u001aJ\u0006\u0010E\u001a\u00020\u0011J\u0006\u0010F\u001a\u00020GJ\u0006\u0010H\u001a\u00020\u0016J\b\u0010I\u001a\u00020\u001aH\u0016J\u000e\u0010J\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u0016J\u000e\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u001aJ\u000e\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u001aJ\u000e\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u0016J\u000e\u0010R\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\u0016J\u000e\u0010T\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020\u0016J\u000e\u0010V\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\u001aJ\u000e\u0010V\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\fJ\u000e\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u0016J\u000e\u0010\\\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u001aJ\u0010\u0010]\u001a\u00020\u000f2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u001a\u0010_\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\u0016J\b\u0010b\u001a\u00020\u0011H\u0016J\b\u0010c\u001a\u00020\u000fH\u0002J\u0006\u0010d\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/contentsquare/android/error/analysis/network/InstrURLConnectionBase;", "", "urlConnection", "Ljava/net/HttpURLConnection;", "builder", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;", "errorAnalysis", "Lcom/contentsquare/android/error/analysis/ErrorAnalysis;", "(Ljava/net/HttpURLConnection;Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;Lcom/contentsquare/android/error/analysis/ErrorAnalysis;)V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "timeRequestedInMicros", "", "timeToResponseInitiatedInMicros", "addRequestProperty", "", "key", "", "value", "connect", "disconnect", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "getAllowUserInteraction", "getConnectTimeout", "", "getContent", "classes", "", "Ljava/lang/Class;", "([Ljava/lang/Class;)Ljava/lang/Object;", "getContentEncoding", "getContentLength", "getContentLengthLong", "getContentType", "getDate", "getDefaultUseCaches", "getDoInput", "getDoOutput", "getErrorStream", "Ljava/io/InputStream;", "getExpiration", "getHeaderField", "index", "name", "getHeaderFieldDate", "defaultDate", "getHeaderFieldInt", "defaultInt", "getHeaderFieldKey", "getHeaderFieldLong", "defaultLong", "getHeaderFields", "", "", "getIfModifiedSince", "getInputStream", "getInstanceFollowRedirects", "getLastModified", "getOutputStream", "Ljava/io/OutputStream;", "getPermission", "Ljava/security/Permission;", "getReadTimeout", "getRequestMethod", "getRequestProperties", "getRequestProperty", "getResponseCode", "getResponseMessage", "getURL", "Ljava/net/URL;", "getUseCaches", "hashCode", "setAllowUserInteraction", "allowuserinteraction", "setChunkedStreamingMode", "chunklen", "setConnectTimeout", "timeout", "setDefaultUseCaches", "defaultusecaches", "setDoInput", "doinput", "setDoOutput", "dooutput", "setFixedLengthStreamingMode", "contentLength", "setIfModifiedSince", "ifmodifiedsince", "setInstanceFollowRedirects", "followRedirects", "setReadTimeout", "setRequestMethod", "method", "setRequestProperty", "setUseCaches", "usecaches", "toString", "updateRequestInfo", "usingProxy", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInstrURLConnectionBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InstrURLConnectionBase.kt\ncom/contentsquare/android/error/analysis/network/InstrURLConnectionBase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,433:1\n1#2:434\n*E\n"})
/* loaded from: classes2.dex */
public final class InstrURLConnectionBase {

    @NotNull
    private final NetworkEventBuilder builder;

    @NotNull
    private final ErrorAnalysis errorAnalysis;

    @NotNull
    private final Logger logger;
    private long timeRequestedInMicros;
    private long timeToResponseInitiatedInMicros;

    @NotNull
    private final HttpURLConnection urlConnection;

    public InstrURLConnectionBase(HttpURLConnection urlConnection, NetworkEventBuilder builder, ErrorAnalysis errorAnalysis) {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(errorAnalysis, "errorAnalysis");
        this.urlConnection = urlConnection;
        this.builder = builder;
        this.errorAnalysis = errorAnalysis;
        this.timeRequestedInMicros = -1L;
        this.timeToResponseInitiatedInMicros = -1L;
        this.logger = new Logger("Error");
        builder.setUrl(urlConnection.getURL().toString());
    }

    private final void updateRequestInfo() {
        NetworkEventBuilder networkEventBuilder;
        if (this.timeRequestedInMicros == -1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.timeRequestedInMicros = jCurrentTimeMillis;
            this.builder.setRequestStartTimeMillis(jCurrentTimeMillis);
        }
        String requestMethod = getRequestMethod();
        if (requestMethod != null) {
            networkEventBuilder = this.builder;
        } else {
            boolean doOutput = getDoOutput();
            networkEventBuilder = this.builder;
            requestMethod = doOutput ? "POST" : "GET";
        }
        networkEventBuilder.setHttpMethod(requestMethod);
    }

    public final void addRequestProperty(String key, String value) {
        this.urlConnection.addRequestProperty(key, value);
    }

    public final void connect() throws IOException {
        if (this.timeRequestedInMicros == -1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.timeRequestedInMicros = jCurrentTimeMillis;
            this.builder.setRequestStartTimeMillis(jCurrentTimeMillis);
        }
        try {
            HttpURLConnection httpURLConnection = this.urlConnection;
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                httpURLConnection.connect();
                InstrumentationCallbacks.requestSent(httpURLConnection);
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(httpURLConnection, e);
                throw e;
            }
        } catch (IOException e2) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e2;
        }
    }

    public final void disconnect() {
        this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
        NetworkEvent networkEventBuild = this.builder.build();
        if (networkEventBuild != null) {
            this.errorAnalysis.sendEvent(networkEventBuild);
        }
        this.urlConnection.disconnect();
    }

    public boolean equals(Object other) {
        return Intrinsics.areEqual(this.urlConnection, other);
    }

    public final boolean getAllowUserInteraction() {
        return this.urlConnection.getAllowUserInteraction();
    }

    public final int getConnectTimeout() {
        return this.urlConnection.getConnectTimeout();
    }

    @NotNull
    public final Object getContent() throws IOException {
        updateRequestInfo();
        NetworkEventBuilder networkEventBuilder = this.builder;
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            int responseCode = httpURLConnection.getResponseCode();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            networkEventBuilder.setHttpResponseCode(responseCode);
            try {
                HttpURLConnection httpURLConnection2 = this.urlConnection;
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
                try {
                    Object content = httpURLConnection2.getContent();
                    InstrumentationCallbacks.requestHarvestable(httpURLConnection2);
                    Intrinsics.checkNotNullExpressionValue(content, "try {\n            urlCon…        throw e\n        }");
                    if (content instanceof InputStream) {
                        return new InstrHttpInputStream((InputStream) content, this.builder, this.errorAnalysis);
                    }
                    this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
                    NetworkEvent networkEventBuild = this.builder.build();
                    if (networkEventBuild == null) {
                        return content;
                    }
                    this.errorAnalysis.sendEvent(networkEventBuild);
                    return content;
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(httpURLConnection2, e);
                    throw e;
                }
            } catch (IOException e2) {
                this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
                NetworkEvent networkEventBuild2 = this.builder.build();
                if (networkEventBuild2 != null) {
                    this.errorAnalysis.sendEvent(networkEventBuild2);
                }
                throw e2;
            }
        } catch (IOException e3) {
            InstrumentationCallbacks.networkError(httpURLConnection, e3);
            throw e3;
        }
    }

    @Nullable
    public final String getContentEncoding() throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            String contentEncoding = httpURLConnection.getContentEncoding();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return contentEncoding;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    public final int getContentLength() throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            int contentLength = httpURLConnection.getContentLength();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return contentLength;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    public final long getContentLengthLong() {
        updateRequestInfo();
        return this.urlConnection.getContentLengthLong();
    }

    @Nullable
    public final String getContentType() throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            String contentType = httpURLConnection.getContentType();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return contentType;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    public final long getDate() throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            long date = httpURLConnection.getDate();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return date;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    public final boolean getDefaultUseCaches() {
        return this.urlConnection.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.urlConnection.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.urlConnection.getDoOutput();
    }

    @Nullable
    public final InputStream getErrorStream() throws IOException {
        updateRequestInfo();
        try {
            NetworkEventBuilder networkEventBuilder = this.builder;
            HttpURLConnection httpURLConnection = this.urlConnection;
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                networkEventBuilder.setHttpResponseCode(responseCode);
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(httpURLConnection, e);
                throw e;
            }
        } catch (IOException e2) {
            this.logger.d(e2, "IOException thrown trying to obtain the response code");
        }
        InputStream errorStream = InstrumentationCallbacks.getErrorStream(this.urlConnection);
        if (errorStream != null) {
            return new InstrHttpInputStream(errorStream, this.builder, this.errorAnalysis);
        }
        return null;
    }

    public final long getExpiration() throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            long expiration = httpURLConnection.getExpiration();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return expiration;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    @Nullable
    public final String getHeaderField(int index) throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            String headerField = httpURLConnection.getHeaderField(index);
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return headerField;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    public final long getHeaderFieldDate(String name, long defaultDate) throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            long headerFieldDate = httpURLConnection.getHeaderFieldDate(name, defaultDate);
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return headerFieldDate;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    public final int getHeaderFieldInt(String name, int defaultInt) throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            int headerFieldInt = httpURLConnection.getHeaderFieldInt(name, defaultInt);
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return headerFieldInt;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    @Nullable
    public final String getHeaderFieldKey(int index) throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(index);
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return headerFieldKey;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    public final long getHeaderFieldLong(String name, long defaultLong) {
        updateRequestInfo();
        return this.urlConnection.getHeaderFieldLong(name, defaultLong);
    }

    @NotNull
    public final Map<String, List<String>> getHeaderFields() throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            Intrinsics.checkNotNullExpressionValue(headerFields, "urlConnection.headerFields");
            return headerFields;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    public final long getIfModifiedSince() {
        return this.urlConnection.getIfModifiedSince();
    }

    @Nullable
    public final InputStream getInputStream() throws IOException {
        updateRequestInfo();
        NetworkEventBuilder networkEventBuilder = this.builder;
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            int responseCode = httpURLConnection.getResponseCode();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            networkEventBuilder.setHttpResponseCode(responseCode);
            try {
                InputStream inputStream = InstrumentationCallbacks.getInputStream(this.urlConnection);
                if (inputStream != null) {
                    return new InstrHttpInputStream(inputStream, this.builder, this.errorAnalysis);
                }
                return null;
            } catch (IOException e) {
                this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
                NetworkEvent networkEventBuild = this.builder.build();
                if (networkEventBuild != null) {
                    this.errorAnalysis.sendEvent(networkEventBuild);
                }
                throw e;
            }
        } catch (IOException e2) {
            InstrumentationCallbacks.networkError(httpURLConnection, e2);
            throw e2;
        }
    }

    public final boolean getInstanceFollowRedirects() {
        return this.urlConnection.getInstanceFollowRedirects();
    }

    public final long getLastModified() throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            long lastModified = httpURLConnection.getLastModified();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return lastModified;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    @Nullable
    public final OutputStream getOutputStream() throws IOException {
        try {
            HttpURLConnection httpURLConnection = this.urlConnection;
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                InstrumentationCallbacks.requestSent(httpURLConnection);
                if (outputStream != null) {
                    return new InstrHttpOutputStream(outputStream, this.builder, this.errorAnalysis);
                }
                return null;
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(httpURLConnection, e);
                throw e;
            }
        } catch (IOException e2) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e2;
        }
    }

    @Nullable
    public final Permission getPermission() throws IOException {
        try {
            return this.urlConnection.getPermission();
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    public final int getReadTimeout() {
        return this.urlConnection.getReadTimeout();
    }

    @Nullable
    public final String getRequestMethod() {
        return this.urlConnection.getRequestMethod();
    }

    @NotNull
    public final Map<String, List<String>> getRequestProperties() {
        Map<String, List<String>> requestProperties = this.urlConnection.getRequestProperties();
        Intrinsics.checkNotNullExpressionValue(requestProperties, "urlConnection.requestProperties");
        return requestProperties;
    }

    @Nullable
    public final String getRequestProperty(String key) {
        return this.urlConnection.getRequestProperty(key);
    }

    public final int getResponseCode() throws IOException {
        updateRequestInfo();
        if (this.timeToResponseInitiatedInMicros == -1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.timeToResponseInitiatedInMicros = jCurrentTimeMillis;
            this.builder.setTimeToResponseInitiatedMillis(jCurrentTimeMillis);
        }
        try {
            HttpURLConnection httpURLConnection = this.urlConnection;
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                this.builder.setHttpResponseCode(responseCode);
                NetworkEvent networkEventBuild = this.builder.build();
                if (networkEventBuild != null) {
                    this.errorAnalysis.sendEvent(networkEventBuild);
                }
                return responseCode;
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(httpURLConnection, e);
                throw e;
            }
        } catch (IOException e2) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild2 = this.builder.build();
            if (networkEventBuild2 != null) {
                this.errorAnalysis.sendEvent(networkEventBuild2);
            }
            throw e2;
        }
    }

    @NotNull
    public final String getResponseMessage() throws IOException {
        updateRequestInfo();
        if (this.timeToResponseInitiatedInMicros == -1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.timeToResponseInitiatedInMicros = jCurrentTimeMillis;
            this.builder.setTimeToResponseInitiatedMillis(jCurrentTimeMillis);
        }
        try {
            HttpURLConnection httpURLConnection = this.urlConnection;
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                String responseMessage = httpURLConnection.getResponseMessage();
                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                NetworkEventBuilder networkEventBuilder = this.builder;
                HttpURLConnection httpURLConnection2 = this.urlConnection;
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
                try {
                    int responseCode = httpURLConnection2.getResponseCode();
                    InstrumentationCallbacks.requestHarvestable(httpURLConnection2);
                    networkEventBuilder.setHttpResponseCode(responseCode);
                    Intrinsics.checkNotNullExpressionValue(responseMessage, "{\n            val messag…        message\n        }");
                    return responseMessage;
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(httpURLConnection2, e);
                    throw e;
                }
            } catch (IOException e2) {
                InstrumentationCallbacks.networkError(httpURLConnection, e2);
                throw e2;
            }
        } catch (IOException e3) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e3;
        }
    }

    @NotNull
    public final URL getURL() {
        URL url = this.urlConnection.getURL();
        Intrinsics.checkNotNullExpressionValue(url, "urlConnection.url");
        return url;
    }

    public final boolean getUseCaches() {
        return this.urlConnection.getUseCaches();
    }

    public int hashCode() {
        return this.urlConnection.hashCode();
    }

    public final void setAllowUserInteraction(boolean allowuserinteraction) {
        this.urlConnection.setAllowUserInteraction(allowuserinteraction);
    }

    public final void setChunkedStreamingMode(int chunklen) {
        this.urlConnection.setChunkedStreamingMode(chunklen);
    }

    public final void setConnectTimeout(int timeout) {
        this.urlConnection.setConnectTimeout(timeout);
    }

    public final void setDefaultUseCaches(boolean defaultusecaches) {
        this.urlConnection.setDefaultUseCaches(defaultusecaches);
    }

    public final void setDoInput(boolean doinput) {
        this.urlConnection.setDoInput(doinput);
    }

    public final void setDoOutput(boolean dooutput) {
        this.urlConnection.setDoOutput(dooutput);
    }

    public final void setFixedLengthStreamingMode(int contentLength) {
        this.urlConnection.setFixedLengthStreamingMode(contentLength);
    }

    public final void setIfModifiedSince(long ifmodifiedsince) {
        this.urlConnection.setIfModifiedSince(ifmodifiedsince);
    }

    public final void setInstanceFollowRedirects(boolean followRedirects) {
        this.urlConnection.setInstanceFollowRedirects(followRedirects);
    }

    public final void setReadTimeout(int timeout) {
        this.urlConnection.setReadTimeout(timeout);
    }

    public final void setRequestMethod(String method) throws ProtocolException {
        this.urlConnection.setRequestMethod(method);
    }

    public final void setRequestProperty(String key, String value) {
        this.urlConnection.setRequestProperty(key, value);
    }

    public final void setUseCaches(boolean usecaches) {
        this.urlConnection.setUseCaches(usecaches);
    }

    @NotNull
    public String toString() {
        String string = this.urlConnection.toString();
        Intrinsics.checkNotNullExpressionValue(string, "urlConnection.toString()");
        return string;
    }

    public final boolean usingProxy() {
        return this.urlConnection.usingProxy();
    }

    @NotNull
    public final Object getContent(Class<?>[] classes) throws IOException {
        updateRequestInfo();
        NetworkEventBuilder networkEventBuilder = this.builder;
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            int responseCode = httpURLConnection.getResponseCode();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            networkEventBuilder.setHttpResponseCode(responseCode);
            try {
                HttpURLConnection httpURLConnection2 = this.urlConnection;
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
                try {
                    Object content = httpURLConnection2.getContent(classes);
                    InstrumentationCallbacks.requestHarvestable(httpURLConnection2);
                    Intrinsics.checkNotNullExpressionValue(content, "try {\n            urlCon…        throw e\n        }");
                    if (content instanceof InputStream) {
                        return new InstrHttpInputStream((InputStream) content, this.builder, this.errorAnalysis);
                    }
                    this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
                    NetworkEvent networkEventBuild = this.builder.build();
                    if (networkEventBuild == null) {
                        return content;
                    }
                    this.errorAnalysis.sendEvent(networkEventBuild);
                    return content;
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(httpURLConnection2, e);
                    throw e;
                }
            } catch (IOException e2) {
                this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
                NetworkEvent networkEventBuild2 = this.builder.build();
                if (networkEventBuild2 != null) {
                    this.errorAnalysis.sendEvent(networkEventBuild2);
                }
                throw e2;
            }
        } catch (IOException e3) {
            InstrumentationCallbacks.networkError(httpURLConnection, e3);
            throw e3;
        }
    }

    @Nullable
    public final String getHeaderField(String name) throws IOException {
        updateRequestInfo();
        HttpURLConnection httpURLConnection = this.urlConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            String headerField = httpURLConnection.getHeaderField(name);
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return headerField;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    public final void setFixedLengthStreamingMode(long contentLength) {
        this.urlConnection.setFixedLengthStreamingMode(contentLength);
    }
}

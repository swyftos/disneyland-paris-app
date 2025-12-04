package com.contentsquare.android.error.analysis.network;

import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.communication.error.analysis.NetworkEventBuilder;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import com.contentsquare.android.error.analysis.util.URLWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\bJ1\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0007J'\u0010\u0003\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nH\u0007¢\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0007J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0019J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u001a"}, d2 = {"Lcom/contentsquare/android/error/analysis/network/ErrorUrlConnection;", "", "()V", "getContent", "wrapper", "Lcom/contentsquare/android/error/analysis/util/URLWrapper;", "errorAnalysis", "Lcom/contentsquare/android/error/analysis/ErrorAnalysis;", "getContent$error_analysis_release", "types", "", "Ljava/lang/Class;", "(Lcom/contentsquare/android/error/analysis/util/URLWrapper;[Ljava/lang/Class;Lcom/contentsquare/android/error/analysis/ErrorAnalysis;)Ljava/lang/Object;", "url", "Ljava/net/URL;", "(Ljava/net/URL;[Ljava/lang/Class;)Ljava/lang/Object;", "getInstrumentedClass", "Ljava/net/HttpURLConnection;", "connection", "Ljava/net/URLConnection;", "builder", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;", "instrument", "openStream", "Ljava/io/InputStream;", "openStream$error_analysis_release", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nErrorUrlConnection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErrorUrlConnection.kt\ncom/contentsquare/android/error/analysis/network/ErrorUrlConnection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,232:1\n1#2:233\n*E\n"})
/* loaded from: classes2.dex */
public final class ErrorUrlConnection {

    @NotNull
    public static final ErrorUrlConnection INSTANCE = new ErrorUrlConnection();

    private ErrorUrlConnection() {
    }

    @JvmStatic
    @NotNull
    public static final Object getContent(URL url) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        ErrorAnalysis.Companion companion = ErrorAnalysis.INSTANCE;
        if (companion.getInstance().isEnabled()) {
            return INSTANCE.getContent$error_analysis_release(new URLWrapper(url), companion.getInstance());
        }
        Object content = url.getContent();
        Intrinsics.checkNotNullExpressionValue(content, "{\n            url.content\n        }");
        return content;
    }

    private final HttpURLConnection getInstrumentedClass(URLConnection connection, NetworkEventBuilder builder, ErrorAnalysis errorAnalysis) {
        if (connection instanceof HttpsURLConnection) {
            return new InstrHttpsURLConnection((HttpsURLConnection) connection, builder, errorAnalysis);
        }
        if (connection instanceof HttpURLConnection) {
            return new InstrHttpURLConnection((HttpURLConnection) connection, builder, errorAnalysis);
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final Object instrument(Object connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        ErrorAnalysis.Companion companion = ErrorAnalysis.INSTANCE;
        if (companion.getInstance().isEnabled()) {
            if (connection instanceof HttpsURLConnection) {
                return new InstrHttpsURLConnection((HttpsURLConnection) connection, NetworkEventBuilder.INSTANCE.builder(), companion.getInstance());
            }
            if (connection instanceof HttpURLConnection) {
                return new InstrHttpURLConnection((HttpURLConnection) connection, NetworkEventBuilder.INSTANCE.builder(), companion.getInstance());
            }
        }
        return connection;
    }

    @JvmStatic
    @Nullable
    public static final InputStream openStream(URL url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ErrorAnalysis.Companion companion = ErrorAnalysis.INSTANCE;
        return companion.getInstance().isEnabled() ? INSTANCE.openStream$error_analysis_release(new URLWrapper(url), companion.getInstance()) : url.openStream();
    }

    @NotNull
    public final Object getContent$error_analysis_release(URLWrapper wrapper, ErrorAnalysis errorAnalysis) throws IOException {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        Intrinsics.checkNotNullParameter(errorAnalysis, "errorAnalysis");
        long jCurrentTimeMillis = System.currentTimeMillis();
        NetworkEventBuilder networkEventBuilderBuilder = NetworkEventBuilder.INSTANCE.builder();
        try {
            URLConnection uRLConnectionOpenConnection = wrapper.openConnection();
            HttpURLConnection instrumentedClass = getInstrumentedClass(uRLConnectionOpenConnection, networkEventBuilderBuilder, errorAnalysis);
            if (instrumentedClass != null) {
                uRLConnectionOpenConnection = instrumentedClass;
            }
            InstrumentationCallbacks.requestAboutToBeSent(uRLConnectionOpenConnection);
            try {
                Object content = uRLConnectionOpenConnection.getContent();
                InstrumentationCallbacks.requestHarvestable(uRLConnectionOpenConnection);
                Intrinsics.checkNotNullExpressionValue(content, "instrumentedClass.content");
                return content;
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(uRLConnectionOpenConnection, e);
                throw e;
            }
        } catch (IOException e2) {
            networkEventBuilderBuilder.setRequestStartTimeMillis(jCurrentTimeMillis);
            networkEventBuilderBuilder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            networkEventBuilderBuilder.setUrl(wrapper.toString());
            NetworkEvent networkEventBuild = networkEventBuilderBuilder.build();
            if (networkEventBuild != null) {
                errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e2;
        }
    }

    @Nullable
    public final InputStream openStream$error_analysis_release(URLWrapper wrapper, ErrorAnalysis errorAnalysis) throws IOException {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        Intrinsics.checkNotNullParameter(errorAnalysis, "errorAnalysis");
        long jCurrentTimeMillis = System.currentTimeMillis();
        NetworkEventBuilder networkEventBuilderBuilder = NetworkEventBuilder.INSTANCE.builder();
        try {
            URLConnection uRLConnectionOpenConnection = wrapper.openConnection();
            return uRLConnectionOpenConnection instanceof HttpsURLConnection ? new InstrHttpsURLConnection((HttpsURLConnection) uRLConnectionOpenConnection, networkEventBuilderBuilder, errorAnalysis).getInputStream() : uRLConnectionOpenConnection instanceof HttpURLConnection ? new InstrHttpURLConnection((HttpURLConnection) uRLConnectionOpenConnection, networkEventBuilderBuilder, errorAnalysis).getInputStream() : InstrumentationCallbacks.getInputStream(uRLConnectionOpenConnection);
        } catch (IOException e) {
            networkEventBuilderBuilder.setRequestStartTimeMillis(jCurrentTimeMillis);
            networkEventBuilderBuilder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            networkEventBuilderBuilder.setUrl(wrapper.toString());
            NetworkEvent networkEventBuild = networkEventBuilderBuilder.build();
            if (networkEventBuild != null) {
                errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    @JvmStatic
    @NotNull
    public static final Object getContent(URL url, Class<?>[] types) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(types, "types");
        ErrorAnalysis.Companion companion = ErrorAnalysis.INSTANCE;
        if (companion.getInstance().isEnabled()) {
            return INSTANCE.getContent$error_analysis_release(new URLWrapper(url), types, companion.getInstance());
        }
        Object content = url.getContent(types);
        Intrinsics.checkNotNullExpressionValue(content, "{\n            url.getContent(types)\n        }");
        return content;
    }

    @NotNull
    public final Object getContent$error_analysis_release(URLWrapper wrapper, Class<?>[] types, ErrorAnalysis errorAnalysis) throws IOException {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(errorAnalysis, "errorAnalysis");
        long jCurrentTimeMillis = System.currentTimeMillis();
        NetworkEventBuilder networkEventBuilderBuilder = NetworkEventBuilder.INSTANCE.builder();
        try {
            URLConnection uRLConnectionOpenConnection = wrapper.openConnection();
            HttpURLConnection instrumentedClass = getInstrumentedClass(uRLConnectionOpenConnection, networkEventBuilderBuilder, errorAnalysis);
            if (instrumentedClass != null) {
                uRLConnectionOpenConnection = instrumentedClass;
            }
            InstrumentationCallbacks.requestAboutToBeSent(uRLConnectionOpenConnection);
            try {
                Object content = uRLConnectionOpenConnection.getContent(types);
                InstrumentationCallbacks.requestHarvestable(uRLConnectionOpenConnection);
                Intrinsics.checkNotNullExpressionValue(content, "instrumentedClass.getContent(types)");
                return content;
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(uRLConnectionOpenConnection, e);
                throw e;
            }
        } catch (IOException e2) {
            networkEventBuilderBuilder.setRequestStartTimeMillis(jCurrentTimeMillis);
            networkEventBuilderBuilder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            networkEventBuilderBuilder.setUrl(wrapper.toString());
            NetworkEvent networkEventBuild = networkEventBuilderBuilder.build();
            if (networkEventBuild != null) {
                errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e2;
        }
    }
}

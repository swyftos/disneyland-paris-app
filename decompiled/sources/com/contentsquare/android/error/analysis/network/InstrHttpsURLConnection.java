package com.contentsquare.android.error.analysis.network;

import com.contentsquare.android.core.communication.error.analysis.NetworkEventBuilder;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J!\u0010\u0019\u001a\u00020\u00142\u0012\u0010\u001a\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001dJ\n\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u0012H\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020!H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010\r2\u0006\u0010+\u001a\u00020\u0018H\u0016J\u0014\u0010*\u001a\u0004\u0018\u00010\r2\b\u0010,\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010-\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020!H\u0016J\u001a\u0010/\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u00100\u001a\u00020\u0018H\u0016J\u0012\u00101\u001a\u0004\u0018\u00010\r2\u0006\u0010+\u001a\u00020\u0018H\u0016J\u001a\u00102\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u00103\u001a\u00020!H\u0016J\u001a\u00104\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0605H\u0016J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020!H\u0016J\n\u0010:\u001a\u0004\u0018\u00010(H\u0016J\b\u0010;\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020!H\u0016J\u0013\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u001bH\u0016¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020AH\u0016J\n\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u00020AH\u0016J\n\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020\u0018H\u0016J\n\u0010H\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010I\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0605H\u0016J\u0014\u0010J\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010K\u001a\u00020\u0018H\u0016J\b\u0010L\u001a\u00020\rH\u0016J\b\u0010M\u001a\u00020NH\u0016J\u0013\u0010O\u001a\b\u0012\u0004\u0012\u00020>0\u001bH\u0016¢\u0006\u0002\u0010?J\b\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020\u0012H\u0016J\b\u0010S\u001a\u00020\u0018H\u0016J\u0010\u0010T\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u0012H\u0016J\u0010\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u0018H\u0016J\u0010\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u0018H\u0016J\u0010\u0010Z\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020\u0012H\u0016J\u0010\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u0012H\u0016J\u0010\u0010^\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u0012H\u0016J\u0010\u0010`\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020\u0018H\u0016J\u0010\u0010`\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020!H\u0016J\u0012\u0010b\u001a\u00020\u000b2\b\u0010c\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010d\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020!H\u0016J\u0010\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u0012H\u0016J\u0010\u0010h\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u0018H\u0016J\u0012\u0010i\u001a\u00020\u000b2\b\u0010j\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010k\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020NH\u0016J\u0010\u0010n\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020\u0012H\u0016J\b\u0010p\u001a\u00020\rH\u0016J\b\u0010q\u001a\u00020\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/contentsquare/android/error/analysis/network/InstrHttpsURLConnection;", "Ljavax/net/ssl/HttpsURLConnection;", "urlConnection", "builder", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;", "errorAnalysis", "Lcom/contentsquare/android/error/analysis/ErrorAnalysis;", "(Ljavax/net/ssl/HttpsURLConnection;Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;Lcom/contentsquare/android/error/analysis/ErrorAnalysis;)V", "delegate", "Lcom/contentsquare/android/error/analysis/network/InstrURLConnectionBase;", "addRequestProperty", "", "key", "", "value", "connect", "disconnect", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "getAllowUserInteraction", "getCipherSuite", "getConnectTimeout", "", "getContent", "classes", "", "Ljava/lang/Class;", "([Ljava/lang/Class;)Ljava/lang/Object;", "getContentEncoding", "getContentLength", "getContentLengthLong", "", "getContentType", "getDate", "getDefaultUseCaches", "getDoInput", "getDoOutput", "getErrorStream", "Ljava/io/InputStream;", "getExpiration", "getHeaderField", "index", "name", "getHeaderFieldDate", "defaultDate", "getHeaderFieldInt", "defaultInt", "getHeaderFieldKey", "getHeaderFieldLong", "defaultLong", "getHeaderFields", "", "", "getHostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "getIfModifiedSince", "getInputStream", "getInstanceFollowRedirects", "getLastModified", "getLocalCertificates", "Ljava/security/cert/Certificate;", "()[Ljava/security/cert/Certificate;", "getLocalPrincipal", "Ljava/security/Principal;", "getOutputStream", "Ljava/io/OutputStream;", "getPeerPrincipal", "getPermission", "Ljava/security/Permission;", "getReadTimeout", "getRequestMethod", "getRequestProperties", "getRequestProperty", "getResponseCode", "getResponseMessage", "getSSLSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "getServerCertificates", "getURL", "Ljava/net/URL;", "getUseCaches", "hashCode", "setAllowUserInteraction", "allowuserinteraction", "setChunkedStreamingMode", "chunklen", "setConnectTimeout", "timeout", "setDefaultUseCaches", "defaultusecaches", "setDoInput", "doinput", "setDoOutput", "dooutput", "setFixedLengthStreamingMode", "contentLength", "setHostnameVerifier", "verifier", "setIfModifiedSince", "ifmodifiedsince", "setInstanceFollowRedirects", "followRedirects", "setReadTimeout", "setRequestMethod", "method", "setRequestProperty", "setSSLSocketFactory", "factory", "setUseCaches", "usecaches", "toString", "usingProxy", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InstrHttpsURLConnection extends HttpsURLConnection {

    @NotNull
    private final InstrURLConnectionBase delegate;

    @NotNull
    private final HttpsURLConnection urlConnection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstrHttpsURLConnection(HttpsURLConnection urlConnection, NetworkEventBuilder builder, ErrorAnalysis errorAnalysis) {
        super(urlConnection.getURL());
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(errorAnalysis, "errorAnalysis");
        this.urlConnection = urlConnection;
        this.delegate = new InstrURLConnectionBase(urlConnection, builder, errorAnalysis);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String key, String value) {
        this.delegate.addRequestProperty(key, value);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        this.delegate.connect();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.delegate.disconnect();
    }

    public boolean equals(Object other) {
        return Intrinsics.areEqual(this.delegate, other);
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.delegate.getAllowUserInteraction();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    @Nullable
    public String getCipherSuite() {
        return this.urlConnection.getCipherSuite();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.delegate.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    @NotNull
    public Object getContent() {
        return this.delegate.getContent();
    }

    @Override // java.net.URLConnection
    @Nullable
    public String getContentEncoding() {
        return this.delegate.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return this.delegate.getContentLength();
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        return this.delegate.getContentLengthLong();
    }

    @Override // java.net.URLConnection
    @Nullable
    public String getContentType() {
        return this.delegate.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return this.delegate.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.delegate.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.delegate.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    @Nullable
    public InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return this.delegate.getExpiration();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    @Nullable
    public String getHeaderField(int index) {
        return this.delegate.getHeaderField(index);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String name, long defaultDate) {
        return this.delegate.getHeaderFieldDate(name, defaultDate);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String name, int defaultInt) {
        return this.delegate.getHeaderFieldInt(name, defaultInt);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    @Nullable
    public String getHeaderFieldKey(int index) {
        return this.delegate.getHeaderFieldKey(index);
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldLong(String name, long defaultLong) {
        return this.delegate.getHeaderFieldLong(name, defaultLong);
    }

    @Override // java.net.URLConnection
    @NotNull
    public Map<String, List<String>> getHeaderFields() {
        return this.delegate.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    @NotNull
    public HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = this.urlConnection.getHostnameVerifier();
        Intrinsics.checkNotNullExpressionValue(hostnameVerifier, "urlConnection.hostnameVerifier");
        return hostnameVerifier;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.delegate.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    @Nullable
    public InputStream getInputStream() {
        return this.delegate.getInputStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.delegate.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    @NotNull
    public Certificate[] getLocalCertificates() {
        Certificate[] localCertificates = this.urlConnection.getLocalCertificates();
        Intrinsics.checkNotNullExpressionValue(localCertificates, "urlConnection.localCertificates");
        return localCertificates;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    @NotNull
    public Principal getLocalPrincipal() {
        Principal localPrincipal = this.urlConnection.getLocalPrincipal();
        Intrinsics.checkNotNullExpressionValue(localPrincipal, "urlConnection.localPrincipal");
        return localPrincipal;
    }

    @Override // java.net.URLConnection
    @Nullable
    public OutputStream getOutputStream() {
        return this.delegate.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    @NotNull
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal peerPrincipal = this.urlConnection.getPeerPrincipal();
        Intrinsics.checkNotNullExpressionValue(peerPrincipal, "urlConnection.peerPrincipal");
        return peerPrincipal;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    @Nullable
    public Permission getPermission() {
        return this.delegate.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.delegate.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    @Nullable
    public String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }

    @Override // java.net.URLConnection
    @NotNull
    public Map<String, List<String>> getRequestProperties() {
        return this.delegate.getRequestProperties();
    }

    @Override // java.net.URLConnection
    @Nullable
    public String getRequestProperty(String key) {
        return this.delegate.getRequestProperty(key);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() {
        return this.delegate.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    @NotNull
    public String getResponseMessage() {
        return this.delegate.getResponseMessage();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    @NotNull
    public SSLSocketFactory getSSLSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.urlConnection.getSSLSocketFactory();
        Intrinsics.checkNotNullExpressionValue(sSLSocketFactory, "urlConnection.sslSocketFactory");
        return sSLSocketFactory;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    @NotNull
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] serverCertificates = this.urlConnection.getServerCertificates();
        Intrinsics.checkNotNullExpressionValue(serverCertificates, "urlConnection.serverCertificates");
        return serverCertificates;
    }

    @Override // java.net.URLConnection
    @NotNull
    public URL getURL() {
        return this.delegate.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.delegate.getUseCaches();
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean allowuserinteraction) {
        this.delegate.setAllowUserInteraction(allowuserinteraction);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int chunklen) {
        this.delegate.setChunkedStreamingMode(chunklen);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int timeout) {
        this.delegate.setConnectTimeout(timeout);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean defaultusecaches) {
        this.delegate.setDefaultUseCaches(defaultusecaches);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean doinput) {
        this.delegate.setDoInput(doinput);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean dooutput) {
        this.delegate.setDoOutput(dooutput);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int contentLength) {
        this.delegate.setFixedLengthStreamingMode(contentLength);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier verifier) {
        this.urlConnection.setHostnameVerifier(verifier);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long ifmodifiedsince) {
        this.delegate.setIfModifiedSince(ifmodifiedsince);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean followRedirects) {
        this.delegate.setInstanceFollowRedirects(followRedirects);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int timeout) {
        this.delegate.setReadTimeout(timeout);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String method) throws ProtocolException {
        this.delegate.setRequestMethod(method);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String key, String value) {
        this.delegate.setRequestProperty(key, value);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.urlConnection.setSSLSocketFactory(factory);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean usecaches) {
        this.delegate.setUseCaches(usecaches);
    }

    @Override // java.net.URLConnection
    @NotNull
    public String toString() {
        return this.delegate.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.delegate.usingProxy();
    }

    @Override // java.net.URLConnection
    @NotNull
    public Object getContent(Class<?>[] classes) {
        return this.delegate.getContent(classes);
    }

    @Override // java.net.URLConnection
    @Nullable
    public String getHeaderField(String name) {
        return this.delegate.getHeaderField(name);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long contentLength) {
        this.delegate.setFixedLengthStreamingMode(contentLength);
    }
}

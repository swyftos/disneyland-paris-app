package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.datasource.HttpDataSource;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.animated.InterpolationAnimatedNode;
import com.google.common.base.Predicate;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.io.ByteStreams;
import com.google.common.net.HttpHeaders;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {

    @UnstableApi
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;

    @UnstableApi
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesToRead;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private final Predicate contentTypePredicate;
    private final boolean crossProtocolRedirectsForceOriginal;
    private DataSpec dataSpec;
    private final HttpDataSource.RequestProperties defaultRequestProperties;
    private InputStream inputStream;
    private final boolean keepPostFor302Redirects;
    private boolean opened;
    private final int readTimeoutMillis;
    private final HttpDataSource.RequestProperties requestProperties;
    private int responseCode;
    private final String userAgent;

    public static final class Factory implements HttpDataSource.Factory {
        private boolean allowCrossProtocolRedirects;
        private Predicate contentTypePredicate;
        private boolean crossProtocolRedirectsForceOriginal;
        private boolean keepPostFor302Redirects;
        private TransferListener transferListener;
        private String userAgent;
        private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();
        private int connectTimeoutMs = 8000;
        private int readTimeoutMs = 8000;

        @Override // androidx.media3.datasource.HttpDataSource.Factory
        @CanIgnoreReturnValue
        @UnstableApi
        public /* bridge */ /* synthetic */ HttpDataSource.Factory setDefaultRequestProperties(Map map) {
            return setDefaultRequestProperties((Map<String, String>) map);
        }

        @Override // androidx.media3.datasource.HttpDataSource.Factory
        @CanIgnoreReturnValue
        @UnstableApi
        public Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Factory setUserAgent(@Nullable String str) {
            this.userAgent = str;
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Factory setConnectTimeoutMs(int i) {
            this.connectTimeoutMs = i;
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Factory setReadTimeoutMs(int i) {
            this.readTimeoutMs = i;
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Factory setAllowCrossProtocolRedirects(boolean z) {
            this.allowCrossProtocolRedirects = z;
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Factory setCrossProtocolRedirectsForceOriginal(boolean z) {
            this.crossProtocolRedirectsForceOriginal = z;
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Factory setContentTypePredicate(@Nullable Predicate<String> predicate) {
            this.contentTypePredicate = predicate;
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Factory setTransferListener(@Nullable TransferListener transferListener) {
            this.transferListener = transferListener;
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Factory setKeepPostFor302Redirects(boolean z) {
            this.keepPostFor302Redirects = z;
            return this;
        }

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        @UnstableApi
        public DefaultHttpDataSource createDataSource() {
            DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.userAgent, this.connectTimeoutMs, this.readTimeoutMs, this.allowCrossProtocolRedirects, this.crossProtocolRedirectsForceOriginal, this.defaultRequestProperties, this.contentTypePredicate, this.keepPostFor302Redirects);
            TransferListener transferListener = this.transferListener;
            if (transferListener != null) {
                defaultHttpDataSource.addTransferListener(transferListener);
            }
            return defaultHttpDataSource;
        }
    }

    private DefaultHttpDataSource(String str, int i, int i2, boolean z, boolean z2, HttpDataSource.RequestProperties requestProperties, Predicate predicate, boolean z3) {
        super(true);
        this.userAgent = str;
        this.connectTimeoutMillis = i;
        this.readTimeoutMillis = i2;
        this.allowCrossProtocolRedirects = z;
        this.crossProtocolRedirectsForceOriginal = z2;
        if (z && z2) {
            throw new IllegalArgumentException("crossProtocolRedirectsForceOriginal should not be set if allowCrossProtocolRedirects is true");
        }
        this.defaultRequestProperties = requestProperties;
        this.contentTypePredicate = predicate;
        this.requestProperties = new HttpDataSource.RequestProperties();
        this.keepPostFor302Redirects = z3;
    }

    @Override // androidx.media3.datasource.DataSource
    @Nullable
    @UnstableApi
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // androidx.media3.datasource.HttpDataSource
    @UnstableApi
    public int getResponseCode() {
        int i;
        if (this.connection == null || (i = this.responseCode) <= 0) {
            return -1;
        }
        return i;
    }

    @Override // androidx.media3.datasource.DataSource
    @UnstableApi
    public Map<String, List<String>> getResponseHeaders() throws IOException {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return ImmutableMap.of();
        }
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return new NullFilteringHeadersMap(headerFields);
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    @Override // androidx.media3.datasource.HttpDataSource
    @UnstableApi
    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.requestProperties.set(str, str2);
    }

    @Override // androidx.media3.datasource.HttpDataSource
    @UnstableApi
    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.requestProperties.remove(str);
    }

    @Override // androidx.media3.datasource.HttpDataSource
    @UnstableApi
    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    @Override // androidx.media3.datasource.DataSource
    @UnstableApi
    public long open(DataSpec dataSpec) throws IOException, NumberFormatException {
        byte[] byteArray;
        this.dataSpec = dataSpec;
        long j = 0;
        this.bytesRead = 0L;
        this.bytesToRead = 0L;
        transferInitializing(dataSpec);
        try {
            HttpURLConnection httpURLConnectionMakeConnection = makeConnection(dataSpec);
            this.connection = httpURLConnectionMakeConnection;
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionMakeConnection);
            try {
                int responseCode = httpURLConnectionMakeConnection.getResponseCode();
                InstrumentationCallbacks.requestHarvestable(httpURLConnectionMakeConnection);
                this.responseCode = responseCode;
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionMakeConnection);
                try {
                    String responseMessage = httpURLConnectionMakeConnection.getResponseMessage();
                    InstrumentationCallbacks.requestHarvestable(httpURLConnectionMakeConnection);
                    int i = this.responseCode;
                    if (i < 200 || i > 299) {
                        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionMakeConnection);
                        try {
                            Map<String, List<String>> headerFields = httpURLConnectionMakeConnection.getHeaderFields();
                            InstrumentationCallbacks.requestHarvestable(httpURLConnectionMakeConnection);
                            if (this.responseCode == 416) {
                                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionMakeConnection);
                                try {
                                    String headerField = httpURLConnectionMakeConnection.getHeaderField("Content-Range");
                                    InstrumentationCallbacks.requestHarvestable(httpURLConnectionMakeConnection);
                                    if (dataSpec.position == HttpUtil.getDocumentSize(headerField)) {
                                        this.opened = true;
                                        transferStarted(dataSpec);
                                        long j2 = dataSpec.length;
                                        if (j2 != -1) {
                                            return j2;
                                        }
                                        return 0L;
                                    }
                                } catch (IOException e) {
                                    InstrumentationCallbacks.networkError(httpURLConnectionMakeConnection, e);
                                    throw e;
                                }
                            }
                            InputStream errorStream = InstrumentationCallbacks.getErrorStream(httpURLConnectionMakeConnection);
                            try {
                                byteArray = errorStream != null ? ByteStreams.toByteArray(errorStream) : Util.EMPTY_BYTE_ARRAY;
                            } catch (IOException unused) {
                                byteArray = Util.EMPTY_BYTE_ARRAY;
                            }
                            byte[] bArr = byteArray;
                            closeConnectionQuietly();
                            throw new HttpDataSource.InvalidResponseCodeException(this.responseCode, responseMessage, this.responseCode == 416 ? new DataSourceException(2008) : null, headerFields, dataSpec, bArr);
                        } catch (IOException e2) {
                            InstrumentationCallbacks.networkError(httpURLConnectionMakeConnection, e2);
                            throw e2;
                        }
                    }
                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionMakeConnection);
                    try {
                        String contentType = httpURLConnectionMakeConnection.getContentType();
                        InstrumentationCallbacks.requestHarvestable(httpURLConnectionMakeConnection);
                        Predicate predicate = this.contentTypePredicate;
                        if (predicate != null && !predicate.apply(contentType)) {
                            closeConnectionQuietly();
                            throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
                        }
                        if (this.responseCode == 200) {
                            long j3 = dataSpec.position;
                            if (j3 != 0) {
                                j = j3;
                            }
                        }
                        boolean zIsCompressed = isCompressed(httpURLConnectionMakeConnection);
                        if (!zIsCompressed) {
                            long j4 = dataSpec.length;
                            if (j4 != -1) {
                                this.bytesToRead = j4;
                            } else {
                                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionMakeConnection);
                                try {
                                    String headerField2 = httpURLConnectionMakeConnection.getHeaderField("Content-Length");
                                    InstrumentationCallbacks.requestHarvestable(httpURLConnectionMakeConnection);
                                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionMakeConnection);
                                    try {
                                        String headerField3 = httpURLConnectionMakeConnection.getHeaderField("Content-Range");
                                        InstrumentationCallbacks.requestHarvestable(httpURLConnectionMakeConnection);
                                        long contentLength = HttpUtil.getContentLength(headerField2, headerField3);
                                        this.bytesToRead = contentLength != -1 ? contentLength - j : -1L;
                                    } catch (IOException e3) {
                                        InstrumentationCallbacks.networkError(httpURLConnectionMakeConnection, e3);
                                        throw e3;
                                    }
                                } catch (IOException e4) {
                                    InstrumentationCallbacks.networkError(httpURLConnectionMakeConnection, e4);
                                    throw e4;
                                }
                            }
                        } else {
                            this.bytesToRead = dataSpec.length;
                        }
                        try {
                            this.inputStream = InstrumentationCallbacks.getInputStream(httpURLConnectionMakeConnection);
                            if (zIsCompressed) {
                                this.inputStream = new GZIPInputStream(this.inputStream);
                            }
                            this.opened = true;
                            transferStarted(dataSpec);
                            try {
                                skipFully(j, dataSpec);
                                return this.bytesToRead;
                            } catch (IOException e5) {
                                closeConnectionQuietly();
                                if (e5 instanceof HttpDataSource.HttpDataSourceException) {
                                    throw ((HttpDataSource.HttpDataSourceException) e5);
                                }
                                throw new HttpDataSource.HttpDataSourceException(e5, dataSpec, 2000, 1);
                            }
                        } catch (IOException e6) {
                            closeConnectionQuietly();
                            throw new HttpDataSource.HttpDataSourceException(e6, dataSpec, 2000, 1);
                        }
                    } catch (IOException e7) {
                        InstrumentationCallbacks.networkError(httpURLConnectionMakeConnection, e7);
                        throw e7;
                    }
                } catch (IOException e8) {
                    InstrumentationCallbacks.networkError(httpURLConnectionMakeConnection, e8);
                    throw e8;
                }
            } catch (IOException e9) {
                InstrumentationCallbacks.networkError(httpURLConnectionMakeConnection, e9);
                throw e9;
            }
        } catch (IOException e10) {
            closeConnectionQuietly();
            throw HttpDataSource.HttpDataSourceException.createForIOException(e10, dataSpec, 1);
        }
    }

    @Override // androidx.media3.common.DataReader
    @UnstableApi
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            return readInternal(bArr, i, i2);
        } catch (IOException e) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e, (DataSpec) Util.castNonNull(this.dataSpec), 2);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    @UnstableApi
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            InputStream inputStream = this.inputStream;
            if (inputStream != null) {
                long j = this.bytesToRead;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.bytesRead;
                }
                maybeTerminateInputStream(this.connection, j2);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new HttpDataSource.HttpDataSourceException(e, (DataSpec) Util.castNonNull(this.dataSpec), 2000, 3);
                }
            }
        } finally {
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        }
    }

    private HttpURLConnection makeConnection(DataSpec dataSpec) throws IOException {
        HttpURLConnection httpURLConnectionMakeConnection;
        URL url = new URL(dataSpec.uri.toString());
        int i = dataSpec.httpMethod;
        byte[] bArr = dataSpec.httpBody;
        long j = dataSpec.position;
        long j2 = dataSpec.length;
        boolean zIsFlagSet = dataSpec.isFlagSet(1);
        if (!this.allowCrossProtocolRedirects && !this.crossProtocolRedirectsForceOriginal && !this.keepPostFor302Redirects) {
            return makeConnection(url, i, bArr, j, j2, zIsFlagSet, true, dataSpec.httpRequestHeaders);
        }
        int i2 = 0;
        URL urlHandleRedirect = url;
        int i3 = i;
        byte[] bArr2 = bArr;
        while (true) {
            int i4 = i2 + 1;
            if (i2 <= 20) {
                long j3 = j;
                long j4 = j;
                int i5 = i3;
                URL url2 = urlHandleRedirect;
                long j5 = j2;
                httpURLConnectionMakeConnection = makeConnection(urlHandleRedirect, i3, bArr2, j3, j2, zIsFlagSet, false, dataSpec.httpRequestHeaders);
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionMakeConnection);
                try {
                    int responseCode = httpURLConnectionMakeConnection.getResponseCode();
                    InstrumentationCallbacks.requestHarvestable(httpURLConnectionMakeConnection);
                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionMakeConnection);
                    try {
                        String headerField = httpURLConnectionMakeConnection.getHeaderField("Location");
                        InstrumentationCallbacks.requestHarvestable(httpURLConnectionMakeConnection);
                        if ((i5 == 1 || i5 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                            httpURLConnectionMakeConnection.disconnect();
                            urlHandleRedirect = handleRedirect(url2, headerField, dataSpec);
                            i3 = i5;
                        } else {
                            if (i5 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                                break;
                            }
                            httpURLConnectionMakeConnection.disconnect();
                            if (this.keepPostFor302Redirects && responseCode == 302) {
                                i3 = i5;
                            } else {
                                bArr2 = null;
                                i3 = 1;
                            }
                            urlHandleRedirect = handleRedirect(url2, headerField, dataSpec);
                        }
                        i2 = i4;
                        j = j4;
                        j2 = j5;
                    } catch (IOException e) {
                        InstrumentationCallbacks.networkError(httpURLConnectionMakeConnection, e);
                        throw e;
                    }
                } catch (IOException e2) {
                    InstrumentationCallbacks.networkError(httpURLConnectionMakeConnection, e2);
                    throw e2;
                }
            } else {
                throw new HttpDataSource.HttpDataSourceException(new NoRouteToHostException("Too many redirects: " + i4), dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
            }
        }
        return httpURLConnectionMakeConnection;
    }

    private HttpURLConnection makeConnection(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) throws IOException {
        HttpURLConnection httpURLConnectionOpenConnection = openConnection(url);
        httpURLConnectionOpenConnection.setConnectTimeout(this.connectTimeoutMillis);
        httpURLConnectionOpenConnection.setReadTimeout(this.readTimeoutMillis);
        HashMap map2 = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.defaultRequestProperties;
        if (requestProperties != null) {
            map2.putAll(requestProperties.getSnapshot());
        }
        map2.putAll(this.requestProperties.getSnapshot());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionOpenConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strBuildRangeRequestHeader = HttpUtil.buildRangeRequestHeader(j, j2);
        if (strBuildRangeRequestHeader != null) {
            httpURLConnectionOpenConnection.setRequestProperty("Range", strBuildRangeRequestHeader);
        }
        String str = this.userAgent;
        if (str != null) {
            httpURLConnectionOpenConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, z ? "gzip" : InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        httpURLConnectionOpenConnection.setInstanceFollowRedirects(z2);
        httpURLConnectionOpenConnection.setDoOutput(bArr != null);
        httpURLConnectionOpenConnection.setRequestMethod(DataSpec.getStringForHttpMethod(i));
        if (bArr != null) {
            httpURLConnectionOpenConnection.setFixedLengthStreamingMode(bArr.length);
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionOpenConnection);
            try {
                httpURLConnectionOpenConnection.connect();
                InstrumentationCallbacks.requestSent(httpURLConnectionOpenConnection);
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionOpenConnection);
                try {
                    OutputStream outputStream = httpURLConnectionOpenConnection.getOutputStream();
                    InstrumentationCallbacks.requestSent(httpURLConnectionOpenConnection);
                    outputStream.write(bArr);
                    outputStream.close();
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(httpURLConnectionOpenConnection, e);
                    throw e;
                }
            } catch (IOException e2) {
                InstrumentationCallbacks.networkError(httpURLConnectionOpenConnection, e2);
                throw e2;
            }
        } else {
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnectionOpenConnection);
            try {
                httpURLConnectionOpenConnection.connect();
                InstrumentationCallbacks.requestSent(httpURLConnectionOpenConnection);
            } catch (IOException e3) {
                InstrumentationCallbacks.networkError(httpURLConnectionOpenConnection, e3);
                throw e3;
            }
        }
        return httpURLConnectionOpenConnection;
    }

    HttpURLConnection openConnection(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    private URL handleRedirect(URL url, String str, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        if (str == null) {
            throw new HttpDataSource.HttpDataSourceException("Null location redirect", dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new HttpDataSource.HttpDataSourceException("Unsupported protocol redirect: " + protocol, dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
            }
            if (this.allowCrossProtocolRedirects || protocol.equals(url.getProtocol())) {
                return url2;
            }
            if (!this.crossProtocolRedirectsForceOriginal) {
                throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
            }
            try {
                return new URL(url2.toString().replaceFirst(protocol, url.getProtocol()));
            } catch (MalformedURLException e) {
                throw new HttpDataSource.HttpDataSourceException(e, dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
            }
        } catch (MalformedURLException e2) {
            throw new HttpDataSource.HttpDataSourceException(e2, dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
        }
    }

    private void skipFully(long j, DataSpec dataSpec) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int i = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, 0, (int) Math.min(j, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource.HttpDataSourceException(new InterruptedIOException(), dataSpec, 2000, 1);
            }
            if (i == -1) {
                throw new HttpDataSource.HttpDataSourceException(dataSpec, 2008, 1);
            }
            j -= i;
            bytesTransferred(i);
        }
    }

    private int readInternal(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesToRead;
        if (j != -1) {
            long j2 = j - this.bytesRead;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.bytesRead += i3;
        bytesTransferred(i3);
        return i3;
    }

    private static void maybeTerminateInputStream(HttpURLConnection httpURLConnection, long j) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (httpURLConnection == null || Util.SDK_INT > 20) {
            return;
        }
        try {
            InputStream inputStream = InstrumentationCallbacks.getInputStream(httpURLConnection);
            if (j == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) Assertions.checkNotNull(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    private void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.connection = null;
        }
    }

    private static boolean isCompressed(HttpURLConnection httpURLConnection) throws IOException {
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            String headerField = httpURLConnection.getHeaderField("Content-Encoding");
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return "gzip".equalsIgnoreCase(headerField);
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class NullFilteringHeadersMap extends ForwardingMap {
        private final Map headers;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$keySet$0(String str) {
            return str != null;
        }

        public NullFilteringHeadersMap(Map map) {
            this.headers = map;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map delegate() {
            return this.headers;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public List get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set keySet() {
            return Sets.filter(super.keySet(), new Predicate() { // from class: androidx.media3.datasource.DefaultHttpDataSource$NullFilteringHeadersMap$$ExternalSyntheticLambda1
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return DefaultHttpDataSource.NullFilteringHeadersMap.lambda$keySet$0((String) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$entrySet$1(Map.Entry entry) {
            return entry.getKey() != null;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set entrySet() {
            return Sets.filter(super.entrySet(), new Predicate() { // from class: androidx.media3.datasource.DefaultHttpDataSource$NullFilteringHeadersMap$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return DefaultHttpDataSource.NullFilteringHeadersMap.lambda$entrySet$1((Map.Entry) obj);
                }
            });
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean containsValue(Object obj) {
            return super.standardContainsValue(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean equals(Object obj) {
            return obj != null && super.standardEquals(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public int hashCode() {
            return super.standardHashCode();
        }
    }
}

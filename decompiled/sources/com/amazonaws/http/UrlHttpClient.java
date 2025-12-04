package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* loaded from: classes2.dex */
public class UrlHttpClient implements HttpClient {
    private static final Log log = LogFactory.getLog(UrlHttpClient.class);
    private final ClientConfiguration config;
    private SSLContext sc = null;

    @Override // com.amazonaws.http.HttpClient
    public void shutdown() {
    }

    public UrlHttpClient(ClientConfiguration clientConfiguration) {
        this.config = clientConfiguration;
    }

    @Override // com.amazonaws.http.HttpClient
    public HttpResponse execute(HttpRequest httpRequest) throws NoSuchAlgorithmException, IOException, KeyManagementException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.getUri().toURL().openConnection();
        CurlBuilder curlBuilder = this.config.isCurlLogging() ? new CurlBuilder(httpRequest.getUri().toURL()) : null;
        configureConnection(httpRequest, httpURLConnection);
        applyHeadersAndMethod(httpRequest, httpURLConnection, curlBuilder);
        writeContentToConnection(httpRequest, httpURLConnection, curlBuilder);
        if (curlBuilder != null) {
            if (curlBuilder.isValid()) {
                printToLog(curlBuilder.build());
            } else {
                printToLog("Failed to create curl, content too long");
            }
        }
        return createHttpResponse(httpRequest, httpURLConnection);
    }

    HttpResponse createHttpResponse(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws IOException {
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            String responseMessage = httpURLConnection.getResponseMessage();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                InputStream errorStream = InstrumentationCallbacks.getErrorStream(httpURLConnection);
                if (errorStream == null && !"HEAD".equals(httpRequest.getMethod())) {
                    try {
                        errorStream = InstrumentationCallbacks.getInputStream(httpURLConnection);
                    } catch (IOException unused) {
                    }
                }
                HttpResponse.Builder builderContent = HttpResponse.builder().statusCode(responseCode).statusText(responseMessage).content(errorStream);
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                try {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                    for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                        if (entry.getKey() != null) {
                            builderContent.header(entry.getKey(), entry.getValue().get(0));
                        }
                    }
                    return builderContent.build();
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(httpURLConnection, e);
                    throw e;
                }
            } catch (IOException e2) {
                InstrumentationCallbacks.networkError(httpURLConnection, e2);
                throw e2;
            }
        } catch (IOException e3) {
            InstrumentationCallbacks.networkError(httpURLConnection, e3);
            throw e3;
        }
    }

    void writeContentToConnection(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws IOException {
        ByteBuffer byteBufferAllocate;
        if (httpRequest.getContent() == null || httpRequest.getContentLength() < 0) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        if (!httpRequest.isStreaming()) {
            httpURLConnection.setFixedLengthStreamingMode((int) httpRequest.getContentLength());
        }
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            InstrumentationCallbacks.requestSent(httpURLConnection);
            if (curlBuilder == null) {
                byteBufferAllocate = null;
            } else if (httpRequest.getContentLength() < 2147483647L) {
                byteBufferAllocate = ByteBuffer.allocate((int) httpRequest.getContentLength());
            } else {
                curlBuilder.setContentOverflow(true);
                byteBufferAllocate = null;
            }
            write(httpRequest.getContent(), outputStream, curlBuilder, byteBufferAllocate);
            if (curlBuilder != null && byteBufferAllocate != null && byteBufferAllocate.position() != 0) {
                curlBuilder.setContent(new String(byteBufferAllocate.array(), "UTF-8"));
            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    HttpURLConnection applyHeadersAndMethod(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws ProtocolException {
        if (httpRequest.getHeaders() != null && !httpRequest.getHeaders().isEmpty()) {
            if (curlBuilder != null) {
                curlBuilder.setHeaders(httpRequest.getHeaders());
            }
            for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
                String key = entry.getKey();
                if (!key.equals("Content-Length") && !key.equals("Host")) {
                    key.equals("Expect");
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        String method = httpRequest.getMethod();
        httpURLConnection.setRequestMethod(method);
        if (curlBuilder != null) {
            curlBuilder.setMethod(method);
        }
        return httpURLConnection;
    }

    protected void printToLog(String str) {
        log.debug(str);
    }

    protected HttpURLConnection getUrlConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private void write(InputStream inputStream, OutputStream outputStream, CurlBuilder curlBuilder, ByteBuffer byteBuffer) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            }
            if (byteBuffer != null) {
                try {
                    byteBuffer.put(bArr, 0, i);
                } catch (BufferOverflowException unused) {
                    curlBuilder.setContentOverflow(true);
                }
            }
            outputStream.write(bArr, 0, i);
        }
    }

    void configureConnection(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws NoSuchAlgorithmException, KeyManagementException {
        httpURLConnection.setConnectTimeout(this.config.getConnectionTimeout());
        httpURLConnection.setReadTimeout(this.config.getSocketTimeout());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        if (httpRequest.isStreaming()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            if (this.config.getTrustManager() != null) {
                enableCustomTrustManager(httpsURLConnection);
            }
        }
    }

    private void enableCustomTrustManager(HttpsURLConnection httpsURLConnection) throws NoSuchAlgorithmException, KeyManagementException {
        if (this.sc == null) {
            TrustManager[] trustManagerArr = {this.config.getTrustManager()};
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                this.sc = sSLContext;
                sSLContext.init(null, trustManagerArr, null);
            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e);
            }
        }
        httpsURLConnection.setSSLSocketFactory(this.sc.getSocketFactory());
    }

    protected final class CurlBuilder {
        private final URL url;
        private String method = null;
        private final HashMap headers = new HashMap();
        private String content = null;
        private boolean contentOverflow = false;

        public CurlBuilder(URL url) {
            if (url == null) {
                throw new IllegalArgumentException("Must have a valid url");
            }
            this.url = url;
        }

        public CurlBuilder setMethod(String str) {
            this.method = str;
            return this;
        }

        public CurlBuilder setHeaders(Map<String, String> map) {
            this.headers.clear();
            this.headers.putAll(map);
            return this;
        }

        public CurlBuilder setContent(String str) {
            this.content = str;
            return this;
        }

        public CurlBuilder setContentOverflow(boolean z) {
            this.contentOverflow = z;
            return this;
        }

        public boolean isValid() {
            return !this.contentOverflow;
        }

        public String build() {
            if (!isValid()) {
                throw new IllegalStateException("Invalid state, cannot create curl command");
            }
            StringBuilder sb = new StringBuilder("curl");
            if (this.method != null) {
                sb.append(" -X ");
                sb.append(this.method);
            }
            for (Map.Entry entry : this.headers.entrySet()) {
                sb.append(" -H \"");
                sb.append((String) entry.getKey());
                sb.append(":");
                sb.append((String) entry.getValue());
                sb.append("\"");
            }
            if (this.content != null) {
                sb.append(" -d '");
                sb.append(this.content);
                sb.append("'");
            }
            sb.append(" ");
            sb.append(this.url.toString());
            return sb.toString();
        }
    }
}

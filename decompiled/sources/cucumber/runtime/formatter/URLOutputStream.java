package cucumber.runtime.formatter;

import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.firebase.messaging.Constants;
import cucumber.util.FixJava;
import gherkin.deps.com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes5.dex */
class URLOutputStream extends OutputStream {
    private final int expectedResponseCode;
    private final String method;
    private final OutputStream out;
    private final URL url;
    private final HttpURLConnection urlConnection;

    URLOutputStream(URL url) {
        this(url, "PUT", Collections.emptyMap(), 200);
    }

    private URLOutputStream(URL url, String str, Map map, int i) throws IOException {
        this.url = url;
        this.method = str;
        this.expectedResponseCode = i;
        if (url.getProtocol().equals("file")) {
            File file = new File(url.getFile());
            ensureParentDirExists(file);
            this.out = new FileOutputStream(file);
            this.urlConnection = null;
            return;
        }
        if (url.getProtocol().startsWith("http")) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            this.urlConnection = httpURLConnection;
            httpURLConnection.setRequestMethod(str);
            httpURLConnection.setDoOutput(true);
            for (Map.Entry entry : map.entrySet()) {
                this.urlConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            HttpURLConnection httpURLConnection2 = this.urlConnection;
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
            try {
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                InstrumentationCallbacks.requestSent(httpURLConnection2);
                this.out = outputStream;
                return;
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(httpURLConnection2, e);
                throw e;
            }
        }
        throw new IllegalArgumentException("URL Scheme must be one of file,http,https. " + url.toExternalForm());
    }

    private void ensureParentDirExists(File file) throws IOException {
        if (file.getParentFile() == null || file.getParentFile().isDirectory() || file.getParentFile().mkdirs() || file.getParentFile().isDirectory()) {
            return;
        }
        throw new IOException("Failed to create directory " + file.getParentFile().getAbsolutePath());
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            HttpURLConnection httpURLConnection = this.urlConnection;
            if (httpURLConnection != null) {
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                    if (responseCode != this.expectedResponseCode) {
                        try {
                            InstrumentationCallbacks.getInputStream(this.urlConnection).close();
                            throw new IOException(String.format("Expected response code: %d. Got: %d", Integer.valueOf(this.expectedResponseCode), Integer.valueOf(responseCode)));
                        } catch (IOException e) {
                            InputStream errorStream = InstrumentationCallbacks.getErrorStream(this.urlConnection);
                            if (errorStream != null) {
                                String reader = FixJava.readReader(new InputStreamReader(errorStream, "UTF-8"));
                                HttpURLConnection httpURLConnection2 = this.urlConnection;
                                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection2);
                                try {
                                    String headerField = httpURLConnection2.getHeaderField("Content-Type");
                                    InstrumentationCallbacks.requestHarvestable(httpURLConnection2);
                                    throw new ResponseException(reader, e, responseCode, headerField == null ? "text/plain" : headerField);
                                } catch (IOException e2) {
                                    InstrumentationCallbacks.networkError(httpURLConnection2, e2);
                                    throw e2;
                                }
                            }
                            throw e;
                        }
                    }
                } catch (IOException e3) {
                    InstrumentationCallbacks.networkError(httpURLConnection, e3);
                    throw e3;
                }
            }
        } finally {
            this.out.close();
        }
    }

    public class ResponseException extends IOException {
        private final String contentType;
        private final Gson gson;
        private final int responseCode;

        public ResponseException(String str, IOException iOException, int i, String str2) {
            super(str, iOException);
            this.gson = new Gson();
            this.responseCode = i;
            this.contentType = str2;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            if (this.contentType.equals("application/json")) {
                Map map = (Map) this.gson.fromJson(super.getMessage(), Map.class);
                if (map.containsKey(Constants.IPC_BUNDLE_KEY_SEND_ERROR)) {
                    return getMessage0(map.get(Constants.IPC_BUNDLE_KEY_SEND_ERROR).toString());
                }
                return getMessage0(super.getMessage());
            }
            return getMessage0(super.getMessage());
        }

        private String getMessage0(String str) {
            return String.format("%s %s\nHTTP %d\n%s", URLOutputStream.this.method, URLOutputStream.this.url, Integer.valueOf(this.responseCode), str);
        }
    }
}

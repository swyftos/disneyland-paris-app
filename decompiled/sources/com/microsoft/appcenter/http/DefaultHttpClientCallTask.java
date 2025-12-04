package com.microsoft.appcenter.http;

import android.net.TrafficStats;
import android.os.AsyncTask;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* loaded from: classes4.dex */
class DefaultHttpClientCallTask extends AsyncTask {
    private final HttpClient.CallTemplate mCallTemplate;
    private final boolean mCompressionEnabled;
    private final Map mHeaders;
    private final String mMethod;
    private final ServiceCallback mServiceCallback;
    private final Tracker mTracker;
    private final String mUrl;
    private static final Pattern TOKEN_REGEX_URL_ENCODED = Pattern.compile("token=[^&]+");
    private static final Pattern TOKEN_REGEX_JSON = Pattern.compile("token\":\"[^\"]+\"");
    private static final Pattern REDIRECT_URI_REGEX_JSON = Pattern.compile("redirect_uri\":\"[^\"]+\"");

    interface Tracker {
        void onFinish(DefaultHttpClientCallTask defaultHttpClientCallTask);

        void onStart(DefaultHttpClientCallTask defaultHttpClientCallTask);
    }

    DefaultHttpClientCallTask(String str, String str2, Map map, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback, Tracker tracker, boolean z) {
        this.mUrl = str;
        this.mMethod = str2;
        this.mHeaders = map;
        this.mCallTemplate = callTemplate;
        this.mServiceCallback = serviceCallback;
        this.mTracker = tracker;
        this.mCompressionEnabled = z;
    }

    private static InputStream getInputStream(HttpsURLConnection httpsURLConnection) throws IOException {
        InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnection);
        try {
            int responseCode = httpsURLConnection.getResponseCode();
            InstrumentationCallbacks.requestHarvestable(httpsURLConnection);
            if (responseCode >= 200 && responseCode < 400) {
                return InstrumentationCallbacks.getInputStream(httpsURLConnection);
            }
            return InstrumentationCallbacks.getErrorStream(httpsURLConnection);
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpsURLConnection, e);
            throw e;
        }
    }

    private void writePayload(OutputStream outputStream, byte[] bArr) throws IOException {
        for (int i = 0; i < bArr.length; i += 1024) {
            outputStream.write(bArr, i, Math.min(bArr.length - i, 1024));
            if (isCancelled()) {
                return;
            }
        }
    }

    private String readResponse(HttpsURLConnection httpsURLConnection) throws IOException {
        InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnection);
        try {
            int contentLength = httpsURLConnection.getContentLength();
            InstrumentationCallbacks.requestHarvestable(httpsURLConnection);
            StringBuilder sb = new StringBuilder(Math.max(contentLength, 16));
            InputStream inputStream = getInputStream(httpsURLConnection);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                char[] cArr = new char[1024];
                do {
                    int i = inputStreamReader.read(cArr);
                    if (i <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, i);
                } while (!isCancelled());
                String string = sb.toString();
                inputStream.close();
                return string;
            } catch (Throwable th) {
                inputStream.close();
                throw th;
            }
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpsURLConnection, e);
            throw e;
        }
    }

    private HttpResponse doHttpCall() throws IOException {
        String strReplaceAll;
        byte[] byteArray;
        HttpClient.CallTemplate callTemplate;
        URL url = new URL(this.mUrl);
        HttpsURLConnection httpsURLConnectionCreateHttpsConnection = HttpUtils.createHttpsConnection(url);
        try {
            httpsURLConnectionCreateHttpsConnection.setRequestMethod(this.mMethod);
            boolean z = false;
            if (!this.mMethod.equals("POST") || (callTemplate = this.mCallTemplate) == null) {
                strReplaceAll = null;
                byteArray = null;
            } else {
                strReplaceAll = callTemplate.buildRequestBody();
                byteArray = strReplaceAll.getBytes("UTF-8");
                if (this.mCompressionEnabled && byteArray.length >= 1400) {
                    z = true;
                }
                if (!this.mHeaders.containsKey("Content-Type")) {
                    this.mHeaders.put("Content-Type", "application/json");
                }
            }
            if (z) {
                this.mHeaders.put("Content-Encoding", "gzip");
            }
            for (Map.Entry entry : this.mHeaders.entrySet()) {
                httpsURLConnectionCreateHttpsConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            if (isCancelled()) {
                httpsURLConnectionCreateHttpsConnection.disconnect();
                return null;
            }
            HttpClient.CallTemplate callTemplate2 = this.mCallTemplate;
            if (callTemplate2 != null) {
                callTemplate2.onBeforeCalling(url, this.mHeaders);
            }
            if (byteArray != null) {
                if (AppCenterLog.getLogLevel() <= 2) {
                    if (strReplaceAll.length() < 4096) {
                        strReplaceAll = TOKEN_REGEX_URL_ENCODED.matcher(strReplaceAll).replaceAll("token=***");
                        if ("application/json".equals(this.mHeaders.get("Content-Type"))) {
                            strReplaceAll = new JSONObject(strReplaceAll).toString(2);
                        }
                    }
                    AppCenterLog.verbose("AppCenter", strReplaceAll);
                }
                if (z) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(byteArray.length);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(byteArray);
                    gZIPOutputStream.close();
                    byteArray = byteArrayOutputStream.toByteArray();
                }
                httpsURLConnectionCreateHttpsConnection.setDoOutput(true);
                httpsURLConnectionCreateHttpsConnection.setFixedLengthStreamingMode(byteArray.length);
                InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnectionCreateHttpsConnection);
                try {
                    OutputStream outputStream = httpsURLConnectionCreateHttpsConnection.getOutputStream();
                    InstrumentationCallbacks.requestSent(httpsURLConnectionCreateHttpsConnection);
                    try {
                        writePayload(outputStream, byteArray);
                        outputStream.close();
                    } catch (Throwable th) {
                        outputStream.close();
                        throw th;
                    }
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(httpsURLConnectionCreateHttpsConnection, e);
                    throw e;
                }
            }
            if (isCancelled()) {
                httpsURLConnectionCreateHttpsConnection.disconnect();
                return null;
            }
            InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnectionCreateHttpsConnection);
            try {
                int responseCode = httpsURLConnectionCreateHttpsConnection.getResponseCode();
                InstrumentationCallbacks.requestHarvestable(httpsURLConnectionCreateHttpsConnection);
                String response = readResponse(httpsURLConnectionCreateHttpsConnection);
                if (AppCenterLog.getLogLevel() <= 2) {
                    InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnectionCreateHttpsConnection);
                    try {
                        String headerField = httpsURLConnectionCreateHttpsConnection.getHeaderField("Content-Type");
                        InstrumentationCallbacks.requestHarvestable(httpsURLConnectionCreateHttpsConnection);
                        AppCenterLog.verbose("AppCenter", "HTTP response status=" + responseCode + " payload=" + ((headerField == null || headerField.startsWith("text/") || headerField.startsWith("application/")) ? REDIRECT_URI_REGEX_JSON.matcher(TOKEN_REGEX_JSON.matcher(response).replaceAll("token\":\"***\"")).replaceAll("redirect_uri\":\"***\"") : "<binary>"));
                    } catch (IOException e2) {
                        InstrumentationCallbacks.networkError(httpsURLConnectionCreateHttpsConnection, e2);
                        throw e2;
                    }
                }
                HashMap map = new HashMap();
                InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnectionCreateHttpsConnection);
                try {
                    Map<String, List<String>> headerFields = httpsURLConnectionCreateHttpsConnection.getHeaderFields();
                    InstrumentationCallbacks.requestHarvestable(httpsURLConnectionCreateHttpsConnection);
                    for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                        map.put(entry2.getKey(), entry2.getValue().iterator().next());
                    }
                    HttpResponse httpResponse = new HttpResponse(responseCode, response, map);
                    if (responseCode < 200 || responseCode >= 300) {
                        throw new HttpException(httpResponse);
                    }
                    httpsURLConnectionCreateHttpsConnection.disconnect();
                    return httpResponse;
                } catch (IOException e3) {
                    InstrumentationCallbacks.networkError(httpsURLConnectionCreateHttpsConnection, e3);
                    throw e3;
                }
            } catch (IOException e4) {
                InstrumentationCallbacks.networkError(httpsURLConnectionCreateHttpsConnection, e4);
                throw e4;
            }
        } catch (Throwable th2) {
            httpsURLConnectionCreateHttpsConnection.disconnect();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Object doInBackground(Void... voidArr) {
        TrafficStats.setThreadStatsTag(HttpUtils.THREAD_STATS_TAG);
        try {
            return doHttpCall();
        } catch (Exception e) {
            return e;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.mTracker.onStart(this);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object obj) {
        this.mTracker.onFinish(this);
        if (obj instanceof Exception) {
            this.mServiceCallback.onCallFailed((Exception) obj);
        } else {
            this.mServiceCallback.onCallSucceeded((HttpResponse) obj);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled(Object obj) {
        if ((obj instanceof HttpResponse) || (obj instanceof HttpException)) {
            onPostExecute(obj);
        } else {
            this.mTracker.onFinish(this);
        }
    }
}

package com.tagcommander.lib.core;

import android.content.Context;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.tagcommander.lib.core.TCHTTPOperationInformation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.lang3.time.TimeZones;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCHTTPOperation {
    private final Context appContext;
    public final TCHTTPOperationInformation information;
    private final ScheduledThreadPoolExecutor tcAsyncLoader = new ScheduledThreadPoolExecutor(2);

    public TCHTTPOperation(String str, Context context, String str2) {
        TCHTTPOperationInformation tCHTTPOperationInformation = new TCHTTPOperationInformation();
        this.information = tCHTTPOperationInformation;
        tCHTTPOperationInformation.url = str;
        tCHTTPOperationInformation.postData = str2;
        tCHTTPOperationInformation.timestamp = System.currentTimeMillis();
        this.appContext = context;
    }

    public TCHTTPOperation(TCHTTPOperationInformation tCHTTPOperationInformation, Context context) {
        TCHTTPOperationInformation tCHTTPOperationInformation2 = new TCHTTPOperationInformation();
        this.information = tCHTTPOperationInformation2;
        tCHTTPOperationInformation2.url = tCHTTPOperationInformation.url;
        tCHTTPOperationInformation2.postData = tCHTTPOperationInformation.postData;
        tCHTTPOperationInformation2.timestamp = tCHTTPOperationInformation.timestamp;
        tCHTTPOperationInformation2.hitType = tCHTTPOperationInformation.hitType;
        this.appContext = context;
    }

    public void addPostData(String str) {
        StringBuilder sb = new StringBuilder();
        TCHTTPOperationInformation tCHTTPOperationInformation = this.information;
        sb.append(tCHTTPOperationInformation.postData);
        sb.append(str);
        tCHTTPOperationInformation.postData = sb.toString();
    }

    public void addTCUserData(JSONObject jSONObject) {
        TCHTTPOperationInformation tCHTTPOperationInformation = this.information;
        tCHTTPOperationInformation.postData = tCHTTPOperationInformation.postData.replace("\"{waiting_for_consent}\"", jSONObject.toString());
    }

    int treatOperation() throws JSONException {
        try {
            makeRequest();
            return 0;
        } catch (SocketTimeoutException unused) {
            TCLogger.getInstance().logMessage("TCHTTPOperation timeout", 6);
            sendHTTPError(0);
            return -1;
        } catch (IOException e) {
            TCLogger.getInstance().logMessage("TCHTTPOperation exception: " + e.getMessage(), 6);
            sendHTTPError(0);
            return -1;
        }
    }

    public void treatOperationAsync() {
        this.tcAsyncLoader.execute(new Runnable() { // from class: com.tagcommander.lib.core.TCHTTPOperation.1
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                TCHTTPOperation.this.treatOperation();
            }
        });
    }

    void makeRequest() throws JSONException, IOException {
        TCLogger.getInstance().logMessage("sending: " + URLDecoder.decode(this.information.url, "utf-8"), 3);
        if (this.information.hasPostData()) {
            TCLogger.getInstance().logMessage("with POST data: ", 3);
            TCLogger.getInstance().logEvent(this.information.postData, 3);
        }
        if (TCDebug.areHitBlocked()) {
            return;
        }
        if (this.information.hasPostData()) {
            makePostRequest();
        } else {
            makeGetRequest();
        }
    }

    void makePostRequest() throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(this.information.url).openConnection();
        InputStream inputStream = null;
        try {
            httpsURLConnection.setReadTimeout(5000);
            httpsURLConnection.setConnectTimeout(5000);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnection);
            try {
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                InstrumentationCallbacks.requestSent(httpsURLConnection);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                bufferedWriter.write(this.information.postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnection);
                try {
                    httpsURLConnection.connect();
                    InstrumentationCallbacks.requestSent(httpsURLConnection);
                    InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnection);
                    try {
                        int responseCode = httpsURLConnection.getResponseCode();
                        InstrumentationCallbacks.requestHarvestable(httpsURLConnection);
                        if (responseCode > 199 && responseCode < 400) {
                            inputStream = InstrumentationCallbacks.getInputStream(httpsURLConnection);
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                            StringBuilder sb = new StringBuilder(inputStream.available());
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                } else {
                                    sb.append(line);
                                }
                            }
                            sendResponse(sb.toString());
                        } else {
                            TCLogger.getInstance().logMessage("TCHTTPOperation error: " + responseCode, 6);
                            sendHTTPError(responseCode);
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        httpsURLConnection.disconnect();
                    } catch (IOException e) {
                        InstrumentationCallbacks.networkError(httpsURLConnection, e);
                        throw e;
                    }
                } catch (IOException e2) {
                    InstrumentationCallbacks.networkError(httpsURLConnection, e2);
                    throw e2;
                }
            } catch (IOException e3) {
                InstrumentationCallbacks.networkError(httpsURLConnection, e3);
                throw e3;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                inputStream.close();
            }
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            throw th;
        }
    }

    void makeGetRequest() throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(this.information.url).openConnection();
        InputStream inputStream = null;
        try {
            httpsURLConnection.setReadTimeout(5000);
            httpsURLConnection.setConnectTimeout(5000);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setDoInput(true);
            TCHTTPOperationInformation.EType eType = this.information.hitType;
            TCHTTPOperationInformation.EType eType2 = TCHTTPOperationInformation.EType.CONFIGURATION;
            if (eType == eType2) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
                String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences(TCCoreConstants.kTCConfigurationFilesLastUpdated + this.information.partner, this.appContext);
                httpsURLConnection.addRequestProperty("If-Modified-Since", simpleDateFormat.format(new Date(!strRetrieveInfoFromSharedPreferences.equals("") ? Long.parseLong(strRetrieveInfoFromSharedPreferences) : 0L)));
            }
            InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnection);
            try {
                httpsURLConnection.connect();
                InstrumentationCallbacks.requestSent(httpsURLConnection);
                InstrumentationCallbacks.requestAboutToBeSent(httpsURLConnection);
                try {
                    int responseCode = httpsURLConnection.getResponseCode();
                    InstrumentationCallbacks.requestHarvestable(httpsURLConnection);
                    if (responseCode > 199 && responseCode < 400) {
                        if (this.information.hitType == eType2) {
                            if (responseCode != 304) {
                                TCSharedPreferences.saveInfoToSharedPreferences(TCCoreConstants.kTCConfigurationFilesLastUpdated + this.information.partner, "" + System.currentTimeMillis(), this.appContext);
                            } else {
                                httpsURLConnection.disconnect();
                                return;
                            }
                        }
                        inputStream = InstrumentationCallbacks.getInputStream(httpsURLConnection);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder sb = new StringBuilder(inputStream.available());
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                sb.append(line);
                            }
                        }
                        sendResponse(sb.toString());
                    } else {
                        TCLogger.getInstance().logMessage("TCHTTPOperation error: " + responseCode, 6);
                        sendHTTPError(responseCode);
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    httpsURLConnection.disconnect();
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(httpsURLConnection, e);
                    throw e;
                }
            } catch (IOException e2) {
                InstrumentationCallbacks.networkError(httpsURLConnection, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                inputStream.close();
            }
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: com.tagcommander.lib.core.TCHTTPOperation$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tagcommander$lib$core$TCHTTPOperationInformation$EType;

        static {
            int[] iArr = new int[TCHTTPOperationInformation.EType.values().length];
            $SwitchMap$com$tagcommander$lib$core$TCHTTPOperationInformation$EType = iArr;
            try {
                iArr[TCHTTPOperationInformation.EType.HTTP_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tagcommander$lib$core$TCHTTPOperationInformation$EType[TCHTTPOperationInformation.EType.CONFIGURATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tagcommander$lib$core$TCHTTPOperationInformation$EType[TCHTTPOperationInformation.EType.VENDOR_DISCLOSURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tagcommander$lib$core$TCHTTPOperationInformation$EType[TCHTTPOperationInformation.EType.PARTNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void sendResponse(String str) {
        int i = AnonymousClass2.$SwitchMap$com$tagcommander$lib$core$TCHTTPOperationInformation$EType[this.information.hitType.ordinal()];
        if (i == 1) {
            TCEventManager.getInstance().callOnHttpResponse(str);
            return;
        }
        if (i == 2 || i == 3) {
            TCEventManager.getInstance().callOnConfigurationResponse(this.information.partner, str);
        } else {
            if (i != 4) {
                return;
            }
            TCEventManager.getInstance().callOnPartnerResponse(this.information.partner, str);
        }
    }

    private void sendHTTPError(int i) {
        TCEventManager.getInstance().callOnHttpRequestError("" + i);
    }
}

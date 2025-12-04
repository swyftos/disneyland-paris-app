package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.hermes.intl.Constants;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.backend.cct.BuildConfig;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.common.net.HttpHeaders;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.util.Attributes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
final class CctTransportBackend implements TransportBackend {
    private final Context applicationContext;
    private final ConnectivityManager connectivityManager;
    private final DataEncoder dataEncoder;
    final URL endPoint;
    private final int readTimeout;
    private final Clock uptimeClock;
    private final Clock wallTimeClock;

    private static URL parseUrlOrThrow(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2, int i) {
        this.dataEncoder = BatchedLogRequest.createDataEncoder();
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
        this.readTimeout = i;
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, 40000);
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
    }

    private static int getPackageVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.e("CctTransportBackend", "Unable to find version code for package", e);
            return -1;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public EventInternal decorate(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        return eventInternal.toBuilder().addMetadata("sdk-version", Build.VERSION.SDK_INT).addMetadata(TCEventPropertiesNames.TCD_MODEL, Build.MODEL).addMetadata("hardware", Build.HARDWARE).addMetadata("device", Build.DEVICE).addMetadata(TCEventPropertiesNames.TCI_PRODUCT, Build.PRODUCT).addMetadata("os-uild", Build.ID).addMetadata(TCEventPropertiesNames.TCD_MANUFACTURER, Build.MANUFACTURER).addMetadata("fingerprint", Build.FINGERPRINT).addMetadata("tz-offset", getTzOffset()).addMetadata("net-type", getNetTypeValue(activeNetworkInfo)).addMetadata("mobile-subtype", getNetSubtypeValue(activeNetworkInfo)).addMetadata(Attributes.COUNTRY, Locale.getDefault().getCountry()).addMetadata(Constants.LOCALE, Locale.getDefault().getLanguage()).addMetadata("mcc_mnc", getTelephonyManager(this.applicationContext).getSimOperator()).addMetadata("application_build", Integer.toString(getPackageVersionCode(this.applicationContext))).build();
    }

    private static int getNetTypeValue(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.getValue();
        }
        return networkInfo.getType();
    }

    private static int getNetSubtypeValue(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private BatchedLogRequest getRequestBody(BackendRequest backendRequest) {
        LogEvent.Builder builderProtoBuilder;
        HashMap map = new HashMap();
        for (EventInternal eventInternal : backendRequest.getEvents()) {
            String transportName = eventInternal.getTransportName();
            if (!map.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                map.put(transportName, arrayList);
            } else {
                ((List) map.get(transportName)).add(eventInternal);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder clientInfo = LogRequest.builder().setQosTier(QosTier.DEFAULT).setRequestTimeMs(this.wallTimeClock.getTime()).setRequestUptimeMs(this.uptimeClock.getTime()).setClientInfo(ClientInfo.builder().setClientType(ClientInfo.ClientType.ANDROID_FIREBASE).setAndroidClientInfo(AndroidClientInfo.builder().setSdkVersion(Integer.valueOf(eventInternal2.getInteger("sdk-version"))).setModel(eventInternal2.get(TCEventPropertiesNames.TCD_MODEL)).setHardware(eventInternal2.get("hardware")).setDevice(eventInternal2.get("device")).setProduct(eventInternal2.get(TCEventPropertiesNames.TCI_PRODUCT)).setOsBuild(eventInternal2.get("os-uild")).setManufacturer(eventInternal2.get(TCEventPropertiesNames.TCD_MANUFACTURER)).setFingerprint(eventInternal2.get("fingerprint")).setCountry(eventInternal2.get(Attributes.COUNTRY)).setLocale(eventInternal2.get(Constants.LOCALE)).setMccMnc(eventInternal2.get("mcc_mnc")).setApplicationBuild(eventInternal2.get("application_build")).build()).build());
            try {
                clientInfo.setSource(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                clientInfo.setSource((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal3 : (List) entry.getValue()) {
                EncodedPayload encodedPayload = eventInternal3.getEncodedPayload();
                Encoding encoding = encodedPayload.getEncoding();
                if (encoding.equals(Encoding.of("proto"))) {
                    builderProtoBuilder = LogEvent.protoBuilder(encodedPayload.getBytes());
                } else if (encoding.equals(Encoding.of("json"))) {
                    builderProtoBuilder = LogEvent.jsonBuilder(new String(encodedPayload.getBytes(), Charset.forName("UTF-8")));
                } else {
                    Logging.w("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                builderProtoBuilder.setEventTimeMs(eventInternal3.getEventMillis()).setEventUptimeMs(eventInternal3.getUptimeMillis()).setTimezoneOffsetSeconds(eventInternal3.getLong("tz-offset")).setNetworkConnectionInfo(NetworkConnectionInfo.builder().setNetworkType(NetworkConnectionInfo.NetworkType.forNumber(eventInternal3.getInteger("net-type"))).setMobileSubtype(NetworkConnectionInfo.MobileSubtype.forNumber(eventInternal3.getInteger("mobile-subtype"))).build());
                if (eventInternal3.getCode() != null) {
                    builderProtoBuilder.setEventCode(eventInternal3.getCode());
                }
                arrayList3.add(builderProtoBuilder.build());
            }
            clientInfo.setLogEvents(arrayList3);
            arrayList2.add(clientInfo.build());
        }
        return BatchedLogRequest.create(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpResponse doSend(HttpRequest httpRequest) throws IOException {
        Logging.d("CctTransportBackend", "Making request to: %s", httpRequest.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.readTimeout);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", BuildConfig.VERSION_NAME));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
        String str = httpRequest.apiKey;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            try {
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    InstrumentationCallbacks.requestSent(httpURLConnection);
                    try {
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                        try {
                            this.dataEncoder.encode(httpRequest.requestBody, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                            gZIPOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                            try {
                                int responseCode = httpURLConnection.getResponseCode();
                                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                                Logging.i("CctTransportBackend", "Status Code: " + responseCode);
                                StringBuilder sb = new StringBuilder();
                                sb.append("Content-Type: ");
                                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                                try {
                                    String headerField = httpURLConnection.getHeaderField("Content-Type");
                                    InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                                    sb.append(headerField);
                                    Logging.i("CctTransportBackend", sb.toString());
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Content-Encoding: ");
                                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                                    try {
                                        String headerField2 = httpURLConnection.getHeaderField("Content-Encoding");
                                        InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                                        sb2.append(headerField2);
                                        Logging.i("CctTransportBackend", sb2.toString());
                                        if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                                            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                                            try {
                                                String headerField3 = httpURLConnection.getHeaderField("Location");
                                                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                                                return new HttpResponse(responseCode, new URL(headerField3), 0L);
                                            } catch (IOException e) {
                                                InstrumentationCallbacks.networkError(httpURLConnection, e);
                                                throw e;
                                            }
                                        }
                                        if (responseCode != 200) {
                                            return new HttpResponse(responseCode, null, 0L);
                                        }
                                        InputStream inputStream = InstrumentationCallbacks.getInputStream(httpURLConnection);
                                        try {
                                            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                                            try {
                                                String headerField4 = httpURLConnection.getHeaderField("Content-Encoding");
                                                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                                                InputStream inputStreamMaybeUnGzip = maybeUnGzip(inputStream, headerField4);
                                                try {
                                                    HttpResponse httpResponse = new HttpResponse(responseCode, null, LogResponse.fromJson(new BufferedReader(new InputStreamReader(inputStreamMaybeUnGzip))).getNextRequestWaitMillis());
                                                    if (inputStreamMaybeUnGzip != null) {
                                                        inputStreamMaybeUnGzip.close();
                                                    }
                                                    if (inputStream != null) {
                                                        inputStream.close();
                                                    }
                                                    return httpResponse;
                                                } catch (Throwable th) {
                                                    if (inputStreamMaybeUnGzip != null) {
                                                        try {
                                                            inputStreamMaybeUnGzip.close();
                                                        } catch (Throwable unused) {
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            } catch (IOException e2) {
                                                InstrumentationCallbacks.networkError(httpURLConnection, e2);
                                                throw e2;
                                            }
                                        } catch (Throwable th2) {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            throw th2;
                                        }
                                    } catch (IOException e3) {
                                        InstrumentationCallbacks.networkError(httpURLConnection, e3);
                                        throw e3;
                                    }
                                } catch (IOException e4) {
                                    InstrumentationCallbacks.networkError(httpURLConnection, e4);
                                    throw e4;
                                }
                            } catch (IOException e5) {
                                InstrumentationCallbacks.networkError(httpURLConnection, e5);
                                throw e5;
                            }
                        } catch (Throwable th3) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        throw th4;
                    }
                } catch (IOException e6) {
                    InstrumentationCallbacks.networkError(httpURLConnection, e6);
                    throw e6;
                }
            } catch (ConnectException | UnknownHostException e7) {
                Logging.e("CctTransportBackend", "Couldn't open connection, returning with 500", e7);
                return new HttpResponse(500, null, 0L);
            }
        } catch (EncodingException | IOException e8) {
            Logging.e("CctTransportBackend", "Couldn't encode request, returning with 400", e8);
            return new HttpResponse(400, null, 0L);
        }
    }

    private static InputStream maybeUnGzip(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public BackendResponse send(BackendRequest backendRequest) {
        BatchedLogRequest requestBody = getRequestBody(backendRequest);
        URL urlOrThrow = this.endPoint;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination cCTDestinationFromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                aPIKey = cCTDestinationFromByteArray.getAPIKey() != null ? cCTDestinationFromByteArray.getAPIKey() : null;
                if (cCTDestinationFromByteArray.getEndPoint() != null) {
                    urlOrThrow = parseUrlOrThrow(cCTDestinationFromByteArray.getEndPoint());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.fatalError();
            }
        }
        try {
            HttpResponse httpResponse = (HttpResponse) Retries.retry(5, new HttpRequest(urlOrThrow, requestBody, aPIKey), CctTransportBackend$$Lambda$1.lambdaFactory$(this), CctTransportBackend$$Lambda$4.instance);
            int i = httpResponse.code;
            if (i == 200) {
                return BackendResponse.ok(httpResponse.nextRequestMillis);
            }
            if (i < 500 && i != 404) {
                return BackendResponse.fatalError();
            }
            return BackendResponse.transientError();
        } catch (IOException e) {
            Logging.e("CctTransportBackend", "Could not make request to the backend", e);
            return BackendResponse.transientError();
        }
    }

    static /* synthetic */ HttpRequest lambda$send$0(HttpRequest httpRequest, HttpResponse httpResponse) {
        URL url = httpResponse.redirectUrl;
        if (url == null) {
            return null;
        }
        Logging.d("CctTransportBackend", "Following redirect to: %s", url);
        return httpRequest.withUrl(httpResponse.redirectUrl);
    }

    static long getTzOffset() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    static final class HttpResponse {
        final int code;
        final long nextRequestMillis;
        final URL redirectUrl;

        HttpResponse(int i, URL url, long j) {
            this.code = i;
            this.redirectUrl = url;
            this.nextRequestMillis = j;
        }
    }

    static final class HttpRequest {
        final String apiKey;
        final BatchedLogRequest requestBody;
        final URL url;

        HttpRequest(URL url, BatchedLogRequest batchedLogRequest, String str) {
            this.url = url;
            this.requestBody = batchedLogRequest;
            this.apiKey = str;
        }

        HttpRequest withUrl(URL url) {
            return new HttpRequest(url, this.requestBody, this.apiKey);
        }
    }
}

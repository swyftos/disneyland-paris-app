package com.appdynamics.eumagent.runtime;

import android.os.SystemClock;
import android.webkit.JavascriptInterface;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p192private.C2063am;
import com.appdynamics.eumagent.runtime.p192private.C2080bc;
import com.appdynamics.eumagent.runtime.p192private.C2123cs;
import com.appdynamics.eumagent.runtime.p192private.C2138q;
import com.appdynamics.repacked.gson.stream.JsonReader;
import java.io.StringReader;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
@DontObfuscate
public class JSAgentCallback {
    private static final String APPD_JSAGENT = "AppDynamics.JSAgent";
    private static final String EVENTS = "events";
    private static final String EVENT_TYPE = "eventType";
    private static final String EVENT_URL = "eventUrl";
    private static final String FET = "FET";
    public static final int JSAGENT_BASE_PAGE = 0;
    public static final int JSAGENT_IFRAME = 1;
    public static final int JSAGENT_PAGE_ERROR = 4;
    public static final int JSAGENT_VIRTUAL_PAGE = 3;
    public static final int JSAGENT_XHR = 2;
    private static final String METRICS = "metrics";
    private static final String PLT = "PLT";
    private static final String TIMESTAMP = "timestamp";
    private static final String XHR_STATUS = "xhrStatus";

    @JavascriptInterface
    public void postMessage(String str) {
        try {
            ADLog.logVerbose("Callback from JS Agent:".concat(String.valueOf(str)));
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation == null) {
                return;
            }
            C2063am c2063am = Instrumentation.f398a;
            C2138q c2138q = instrumentation.f415l;
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            int i = 1;
            jsonReader.setLenient(true);
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if ("events".equalsIgnoreCase(jsonReader.nextName())) {
                    jsonReader.beginArray();
                    long jNextLong = -1;
                    int iNextLong = -1;
                    int i2 = -1;
                    String str2 = null;
                    long jNextLong2 = -1;
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        int iNextLong2 = i2;
                        String strNextString = str2;
                        while (jsonReader.hasNext()) {
                            String strNextName = jsonReader.nextName();
                            if (EVENT_TYPE.equalsIgnoreCase(strNextName)) {
                                iNextLong = (int) jsonReader.nextLong();
                            } else if (EVENT_URL.equalsIgnoreCase(strNextName)) {
                                strNextString = jsonReader.nextString();
                            } else if (XHR_STATUS.equalsIgnoreCase(strNextName)) {
                                iNextLong2 = (int) jsonReader.nextLong();
                            } else if ("timestamp".equalsIgnoreCase(strNextName)) {
                                jNextLong = jsonReader.nextLong();
                            } else if (METRICS.equalsIgnoreCase(strNextName)) {
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String strNextName2 = jsonReader.nextName();
                                    if (PLT.equalsIgnoreCase(strNextName2)) {
                                        jNextLong2 = jsonReader.nextLong();
                                    } else if (FET.equalsIgnoreCase(strNextName2)) {
                                        jNextLong2 = jsonReader.nextLong();
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                }
                                jsonReader.endObject();
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        if (iNextLong == 0 || iNextLong == i || (iNextLong == 2 ? !(!c2138q.f903b.jsAgentInjectionEnabled || !c2138q.f902a.f910e.booleanValue() || !c2138q.f903b.jsAgentAjaxEnabled || !c2138q.f902a.f911f.booleanValue()) : iNextLong == 3)) {
                            long j = jNextLong + jNextLong2;
                            c2063am.m562a(new C2080bc(new URL(strNextString), new C2123cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - jNextLong), jNextLong), new C2123cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j), iNextLong2, null, null, -1L, -1L, APPD_JSAGENT, null));
                        }
                        i2 = iNextLong2;
                        str2 = strNextString;
                        i = 1;
                    }
                    jsonReader.endArray();
                } else {
                    jsonReader.skipValue();
                }
                i = 1;
            }
            jsonReader.endObject();
        } catch (Throwable th) {
            ADLog.logAgentError("Failed to transform JS Agent beacons", th);
        }
    }
}

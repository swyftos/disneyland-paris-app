package com.appdynamics.eumagent.runtime.p192private;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.media3.exoplayer.upstream.CmcdData;
import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonReader;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bz */
/* JADX INFO: loaded from: classes2.dex */
public final class C2103bz {

    /* JADX INFO: renamed from: a */
    public String f743a;

    /* JADX INFO: renamed from: b */
    public Long f744b;

    /* JADX INFO: renamed from: c */
    public String f745c;

    /* JADX INFO: renamed from: d */
    public C2140s f746d;

    /* JADX INFO: renamed from: a */
    static Object m624a(Object obj, String str) {
        Field declaredField;
        if (obj == null) {
            return null;
        }
        try {
            declaredField = AdapterView.class.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            declaredField = null;
        }
        if (declaredField == null) {
            return null;
        }
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    /* JADX INFO: renamed from: a */
    public static String m625a() {
        return "00-" + m633b() + "-" + m634c() + "-01";
    }

    /* JADX INFO: renamed from: b */
    private static String m633b() {
        String strM626a = m626a(32);
        while (true) {
            for (int i = 0; i < strM626a.length(); i++) {
                if (strM626a.charAt(i) != '0') {
                    return strM626a;
                }
            }
            strM626a = m626a(32);
        }
    }

    /* JADX INFO: renamed from: c */
    private static String m634c() {
        String strM626a = m626a(16);
        while (true) {
            for (int i = 0; i < strM626a.length(); i++) {
                if (strM626a.charAt(i) != '0') {
                    return strM626a;
                }
            }
            strM626a = m626a(16);
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m626a(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < i) {
            sb.append(Integer.toHexString(random.nextInt()));
        }
        return sb.substring(0, i);
    }

    /* JADX INFO: renamed from: a */
    public static C2103bz m623a(JsonReader jsonReader) throws IOException {
        C2103bz c2103bz = new C2103bz();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("command".equals(strNextName)) {
                c2103bz.f743a = jsonReader.nextString();
            } else if ("until".equals(strNextName)) {
                c2103bz.f744b = Long.valueOf(jsonReader.nextLong());
            } else if ("mat".equals(strNextName)) {
                c2103bz.f745c = jsonReader.nextString();
            } else if ("agentConfig".equals(strNextName)) {
                c2103bz.f746d = C2140s.m711a(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return c2103bz;
    }

    public final String toString() {
        return "CollectorResponse{command='" + this.f743a + CoreConstants.SINGLE_QUOTE_CHAR + ", commandUntil=" + this.f744b + ", mobileAgentToken='" + this.f745c + CoreConstants.SINGLE_QUOTE_CHAR + ", agentConfig=" + this.f746d + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }

    /* JADX INFO: renamed from: a */
    public static void m630a(JsonWriter jsonWriter, StackTraceElement[] stackTraceElementArr) throws IOException {
        if (20 < stackTraceElementArr.length) {
            jsonWriter.beginArray();
            m631a(jsonWriter, stackTraceElementArr, 0, 5);
            jsonWriter.beginObject().name("o").value(stackTraceElementArr.length - 20).endObject();
            m631a(jsonWriter, stackTraceElementArr, stackTraceElementArr.length - 15, 15);
            jsonWriter.endArray();
            return;
        }
        jsonWriter.beginArray();
        m631a(jsonWriter, stackTraceElementArr, 0, stackTraceElementArr.length);
        jsonWriter.endArray();
    }

    /* JADX INFO: renamed from: a */
    private static void m631a(JsonWriter jsonWriter, StackTraceElement[] stackTraceElementArr, int i, int i2) throws IOException {
        for (int i3 = i; i3 < i + i2; i3++) {
            jsonWriter.beginObject().name("c").value(stackTraceElementArr[i3].getClassName()).name("m").value(stackTraceElementArr[i3].getMethodName()).name("f").value(stackTraceElementArr[i3].getFileName()).name(CmcdData.Factory.STREAM_TYPE_LIVE).value(stackTraceElementArr[i3].getLineNumber()).endObject();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m628a(JsonWriter jsonWriter, Throwable th, boolean z) throws IOException {
        m629a(jsonWriter, th, z, 0);
    }

    /* JADX INFO: renamed from: a */
    private static void m629a(JsonWriter jsonWriter, Throwable th, boolean z, int i) throws IOException {
        if (i > 4) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        if (th instanceof C2122cr) {
            jsonWriter.name("exceptionClassName").value(((C2122cr) th).f816a);
        } else {
            jsonWriter.name("exceptionClassName").value(th.getClass().getName());
        }
        jsonWriter.name("message").value(th.getMessage());
        jsonWriter.name("stackTraceElements");
        if (th instanceof StackOverflowError) {
            StackTraceElement[] stackTraceElementArr = null;
            try {
                Method declaredMethod = Throwable.class.getDeclaredMethod("getInternalStackTrace", new Class[0]);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    stackTraceElementArr = (StackTraceElement[]) declaredMethod.invoke(th, new Object[0]);
                }
            } catch (Throwable th2) {
                ADLog.logAgentError("Failed to capture stack trace", th2);
            }
            if (stackTraceElementArr != null) {
                m630a(jsonWriter, stackTraceElementArr);
            } else {
                jsonWriter.beginArray();
                jsonWriter.beginObject().name("o").value(-1L).endObject();
                jsonWriter.endArray();
            }
        } else {
            StackTraceElement[] stackTrace = th.getStackTrace();
            jsonWriter.beginArray();
            m631a(jsonWriter, stackTrace, 0, stackTrace.length);
            jsonWriter.endArray();
        }
        if (th.getCause() != null && i <= 4) {
            jsonWriter.name("cause");
            m629a(jsonWriter, th.getCause(), z, i + 1);
        }
        if (z) {
            Throwable[] thArrM667a = C2124ct.m667a(th);
            if (thArrM667a.length > 0) {
                jsonWriter.name("suppressed").beginArray();
                for (Throwable th3 : thArrM667a) {
                    m629a(jsonWriter, th3, false, 0);
                }
                jsonWriter.endArray();
            }
        }
        jsonWriter.endObject();
    }

    /* JADX INFO: renamed from: a */
    public static void m627a(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj instanceof Number) {
            try {
                jsonWriter.value((Number) obj);
            } catch (IllegalArgumentException unused) {
                jsonWriter.value(obj.toString());
            }
        } else if (obj == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(obj.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    private static int m632b(Activity activity) {
        try {
            return activity.getClass().getField("FLUTTER_VIEW_ID").getInt(null);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: a */
    public static View m622a(Activity activity) {
        int iM632b = m632b(activity);
        if (iM632b != -1) {
            View viewFindViewById = activity.findViewById(iM632b);
            if (viewFindViewById == null) {
                return null;
            }
            if (!(viewFindViewById instanceof ViewGroup)) {
                return viewFindViewById;
            }
            ViewGroup viewGroup = (ViewGroup) viewFindViewById;
            if (viewGroup.getChildCount() > 0) {
                return viewGroup.getChildAt(0);
            }
        }
        if (activity.getWindow() != null) {
            return activity.getWindow().getDecorView().getRootView();
        }
        return null;
    }
}

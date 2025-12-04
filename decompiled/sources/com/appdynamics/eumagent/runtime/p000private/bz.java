package com.appdynamics.eumagent.runtime.p000private;

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

/* loaded from: classes2.dex */
public final class bz {
    public String a;
    public Long b;
    public String c;
    public s d;

    static Object a(Object obj, String str) throws NoSuchFieldException, SecurityException {
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

    public static String a() {
        return "00-" + b() + "-" + c() + "-01";
    }

    private static String b() {
        String strA = a(32);
        while (true) {
            for (int i = 0; i < strA.length(); i++) {
                if (strA.charAt(i) != '0') {
                    return strA;
                }
            }
            strA = a(32);
        }
    }

    private static String c() {
        String strA = a(16);
        while (true) {
            for (int i = 0; i < strA.length(); i++) {
                if (strA.charAt(i) != '0') {
                    return strA;
                }
            }
            strA = a(16);
        }
    }

    private static String a(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < i) {
            sb.append(Integer.toHexString(random.nextInt()));
        }
        return sb.substring(0, i);
    }

    public static bz a(JsonReader jsonReader) throws IOException {
        bz bzVar = new bz();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("command".equals(strNextName)) {
                bzVar.a = jsonReader.nextString();
            } else if ("until".equals(strNextName)) {
                bzVar.b = Long.valueOf(jsonReader.nextLong());
            } else if ("mat".equals(strNextName)) {
                bzVar.c = jsonReader.nextString();
            } else if ("agentConfig".equals(strNextName)) {
                bzVar.d = s.a(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return bzVar;
    }

    public final String toString() {
        return "CollectorResponse{command='" + this.a + CoreConstants.SINGLE_QUOTE_CHAR + ", commandUntil=" + this.b + ", mobileAgentToken='" + this.c + CoreConstants.SINGLE_QUOTE_CHAR + ", agentConfig=" + this.d + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }

    public static void a(JsonWriter jsonWriter, StackTraceElement[] stackTraceElementArr) throws IOException {
        if (20 < stackTraceElementArr.length) {
            jsonWriter.beginArray();
            a(jsonWriter, stackTraceElementArr, 0, 5);
            jsonWriter.beginObject().name("o").value(stackTraceElementArr.length - 20).endObject();
            a(jsonWriter, stackTraceElementArr, stackTraceElementArr.length - 15, 15);
            jsonWriter.endArray();
            return;
        }
        jsonWriter.beginArray();
        a(jsonWriter, stackTraceElementArr, 0, stackTraceElementArr.length);
        jsonWriter.endArray();
    }

    private static void a(JsonWriter jsonWriter, StackTraceElement[] stackTraceElementArr, int i, int i2) throws IOException {
        for (int i3 = i; i3 < i + i2; i3++) {
            jsonWriter.beginObject().name("c").value(stackTraceElementArr[i3].getClassName()).name("m").value(stackTraceElementArr[i3].getMethodName()).name("f").value(stackTraceElementArr[i3].getFileName()).name(CmcdData.Factory.STREAM_TYPE_LIVE).value(stackTraceElementArr[i3].getLineNumber()).endObject();
        }
    }

    public static void a(JsonWriter jsonWriter, Throwable th, boolean z) throws IOException {
        a(jsonWriter, th, z, 0);
    }

    private static void a(JsonWriter jsonWriter, Throwable th, boolean z, int i) throws IOException {
        if (i > 4) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        if (th instanceof cr) {
            jsonWriter.name("exceptionClassName").value(((cr) th).a);
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
                a(jsonWriter, stackTraceElementArr);
            } else {
                jsonWriter.beginArray();
                jsonWriter.beginObject().name("o").value(-1L).endObject();
                jsonWriter.endArray();
            }
        } else {
            StackTraceElement[] stackTrace = th.getStackTrace();
            jsonWriter.beginArray();
            a(jsonWriter, stackTrace, 0, stackTrace.length);
            jsonWriter.endArray();
        }
        if (th.getCause() != null && i <= 4) {
            jsonWriter.name("cause");
            a(jsonWriter, th.getCause(), z, i + 1);
        }
        if (z) {
            Throwable[] thArrA = ct.a(th);
            if (thArrA.length > 0) {
                jsonWriter.name("suppressed").beginArray();
                for (Throwable th3 : thArrA) {
                    a(jsonWriter, th3, false, 0);
                }
                jsonWriter.endArray();
            }
        }
        jsonWriter.endObject();
    }

    public static void a(JsonWriter jsonWriter, Object obj) throws IOException {
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

    private static int b(Activity activity) {
        try {
            return activity.getClass().getField("FLUTTER_VIEW_ID").getInt(null);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static View a(Activity activity) {
        int iB = b(activity);
        if (iB != -1) {
            View viewFindViewById = activity.findViewById(iB);
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

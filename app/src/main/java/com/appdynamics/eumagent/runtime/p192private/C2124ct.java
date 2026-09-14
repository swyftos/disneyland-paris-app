package com.appdynamics.eumagent.runtime.p192private;

import android.os.SystemClock;
import android.util.Base64;
import com.amazonaws.services.p017s3.model.InstructionFileId;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import com.google.common.base.Ascii;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ct */
/* JADX INFO: loaded from: classes2.dex */
public final class C2124ct {

    /* JADX INFO: renamed from: b */
    private static final char[] f820b = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: c */
    private static final Method f821c = m661a((Class<?>) Throwable.class, "getSuppressed");

    /* JADX INFO: renamed from: a */
    public static Comparator<File> f819a = new Comparator<File>() { // from class: com.appdynamics.eumagent.runtime.private.ct.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            long jLastModified = file.lastModified();
            long jLastModified2 = file2.lastModified();
            if (jLastModified == jLastModified2) {
                return 0;
            }
            return jLastModified > jLastModified2 ? 1 : -1;
        }
    };

    /* JADX INFO: renamed from: d */
    private static long f822d = 0;

    /* JADX INFO: renamed from: a */
    public static String m657a() {
        return DateFormat.getTimeInstance(0).format(new Date());
    }

    /* JADX INFO: renamed from: a */
    public static boolean m666a(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX INFO: renamed from: a */
    public static Throwable[] m667a(Throwable th) {
        Method method = f821c;
        if (method != null) {
            try {
                return (Throwable[]) method.invoke(th, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return new Throwable[0];
    }

    /* JADX INFO: renamed from: a */
    private static Method m661a(Class<?> cls, String str) {
        try {
            Method method = cls.getMethod(str, new Class[0]);
            if (method != null) {
                method.setAccessible(true);
            }
            return method;
        } catch (Throwable unused) {
            ADLog.logVerbose("Agent couldn't find method " + cls.getName() + InstructionFileId.DOT + str);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m671c(String str) {
        if (str == null) {
            return "null";
        }
        return str.trim().isEmpty() ? "empty" : str;
    }

    /* JADX INFO: renamed from: e */
    public static String m673e(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() <= 2048) {
            return str;
        }
        return str.substring(0, 2045) + "...";
    }

    /* JADX INFO: renamed from: a */
    public static void m663a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                ADLog.logAppError("Error closing input stream", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static StringBuilder m660a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return new StringBuilder();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return sb;
            }
            sb.append(line);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m664a(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                } else {
                    inputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m670b(InputStream inputStream) throws IOException {
        inputStream.mark(1);
        if (inputStream.read(new byte[1]) == -1) {
            return false;
        }
        inputStream.reset();
        return true;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m674f(String str) {
        if (str == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = true;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (z2) {
                if (!m665a(Character.valueOf(cCharAt))) {
                    return false;
                }
                z2 = false;
            } else if (!m665a(Character.valueOf(cCharAt)) && !Character.isDigit(cCharAt) && cCharAt != '_') {
                if (cCharAt != '.' || i == str.length() - 1) {
                    return false;
                }
                z = true;
                z2 = true;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m665a(Character ch2) {
        if (ch2.charValue() < 'a' || ch2.charValue() > 'z') {
            return ch2.charValue() >= 'A' && ch2.charValue() <= 'Z';
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static String m659a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length << 1);
        for (byte b : bArr) {
            char[] cArr = f820b;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & Ascii.f3531SI]);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static String m658a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer("javascript:(function() {  var config = document.createElement('script');  config.type = 'text/javascript'; config.innerHTML = window.atob('");
        stringBuffer.append(Base64.encodeToString(("window['adrum-start-time'] = new Date().getTime();(function(config){   config.spa = {   'spa2': " + z + "   };   config.fetch = true;     config.isZonePromise = true;     config.resTiming = {       sampler: 'TopN',       maxNum: 0   };})(window['adrum-config'] || (window['adrum-config'] = {}));").getBytes(), 0));
        stringBuffer.append("');  document.body.appendChild(config); var script = document.createElement('script');  script.type = 'text/javascript'; script.innerHTML = window.atob('");
        stringBuffer.append(C2067aq.f566a);
        stringBuffer.append("') +                     window.atob('");
        stringBuffer.append(C2067aq.f567b);
        stringBuffer.append("') +                     window.atob('");
        stringBuffer.append(C2067aq.f568c);
        stringBuffer.append("') +  window.atob('");
        stringBuffer.append(C2067aq.f569d);
        stringBuffer.append("');  document.body.appendChild(script); })()");
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    public static void m662a(JsonWriter jsonWriter, Map<Class, Map<String, Object>> map) throws IOException {
        String str;
        for (Map.Entry<Class, Map<String, Object>> entry : map.entrySet()) {
            Class key = entry.getKey();
            Map<String, Object> value = entry.getValue();
            if (!value.isEmpty()) {
                if (key.equals(String.class)) {
                    str = "userdata";
                } else if (key.equals(Long.class)) {
                    str = "userdataLong";
                } else if (key.equals(Boolean.class)) {
                    str = "userdataBoolean";
                } else if (key.equals(Double.class)) {
                    str = "userdataDouble";
                } else if (key.equals(Date.class)) {
                    str = "userdataDateTimestampMs";
                } else {
                    ADLog.logVerbose("Cannot write userdata type " + key.getSimpleName());
                    str = null;
                }
                if (str != null) {
                    jsonWriter.name(str).beginObject();
                    for (Map.Entry<String, Object> entry2 : value.entrySet()) {
                        Object value2 = entry2.getValue();
                        if (value2 instanceof String) {
                            jsonWriter.name(entry2.getKey()).value((String) value2);
                        } else if (value2 instanceof Long) {
                            jsonWriter.name(entry2.getKey()).value((Long) value2);
                        } else if (value2 instanceof Boolean) {
                            jsonWriter.name(entry2.getKey()).value((Boolean) value2);
                        } else if (value2 instanceof Double) {
                            jsonWriter.name(entry2.getKey()).value((Double) value2);
                        } else {
                            ADLog.logVerbose("Cannot write userdata value ".concat(String.valueOf(value2)));
                        }
                    }
                    jsonWriter.endObject();
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m668b(String str) {
        String str2;
        String str3;
        if (str == null) {
            str2 = "null";
        } else {
            str2 = str.trim().isEmpty() ? "empty" : str;
        }
        if (!str2.equals(str)) {
            return str2;
        }
        int length = str.length();
        StringBuilder sb = null;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && !Character.isWhitespace(cCharAt) && !Character.valueOf(cCharAt).equals('|')) {
                if (sb == null) {
                    sb = new StringBuilder(str.substring(0, i));
                }
                if (cCharAt > 255) {
                    str3 = "%04X";
                } else {
                    str3 = "%02X";
                }
                sb.append(String.format(str3, Integer.valueOf(cCharAt)));
            } else if (sb != null) {
                sb.append(cCharAt);
            }
        }
        return sb != null ? sb.toString() : str;
    }

    /* JADX INFO: renamed from: d */
    public static String m672d(String str) {
        String str2;
        if (str == null) {
            str2 = "null";
        } else {
            str2 = str.trim().isEmpty() ? "empty" : str;
        }
        return !str2.equals(str) ? str2 : m673e(str);
    }

    /* JADX INFO: renamed from: b */
    public static String m669b(Throwable th) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (f822d + 60000 > jUptimeMillis) {
            return "Unknown";
        }
        f822d = jUptimeMillis;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        if (th == null) {
            return "Unknown";
        }
        th.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}

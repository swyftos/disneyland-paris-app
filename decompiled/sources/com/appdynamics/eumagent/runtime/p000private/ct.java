package com.appdynamics.eumagent.runtime.p000private;

import android.os.SystemClock;
import android.util.Base64;
import com.amazonaws.services.s3.model.InstructionFileId;
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

/* loaded from: classes2.dex */
public final class ct {
    private static final char[] b = "0123456789abcdef".toCharArray();
    private static final Method c = a((Class<?>) Throwable.class, "getSuppressed");
    public static Comparator<File> a = new Comparator<File>() { // from class: com.appdynamics.eumagent.runtime.private.ct.1
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
    private static long d = 0;

    public static String a() {
        return DateFormat.getTimeInstance(0).format(new Date());
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static Throwable[] a(Throwable th) {
        Method method = c;
        if (method != null) {
            try {
                return (Throwable[]) method.invoke(th, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return new Throwable[0];
    }

    private static Method a(Class<?> cls, String str) {
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

    public static String c(String str) {
        if (str == null) {
            return "null";
        }
        return str.trim().isEmpty() ? "empty" : str;
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() <= 2048) {
            return str;
        }
        return str.substring(0, 2045) + "...";
    }

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                ADLog.logAppError("Error closing input stream", e);
            }
        }
    }

    public static StringBuilder a(InputStream inputStream) throws IOException {
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

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i);
                }
            }
        } finally {
            inputStream.close();
        }
    }

    public static boolean b(InputStream inputStream) throws IOException {
        inputStream.mark(1);
        if (inputStream.read(new byte[1]) == -1) {
            return false;
        }
        inputStream.reset();
        return true;
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = true;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (z2) {
                if (!a(Character.valueOf(cCharAt))) {
                    return false;
                }
                z2 = false;
            } else if (!a(Character.valueOf(cCharAt)) && !Character.isDigit(cCharAt) && cCharAt != '_') {
                if (cCharAt != '.' || i == str.length() - 1) {
                    return false;
                }
                z = true;
                z2 = true;
            }
        }
        return z;
    }

    private static boolean a(Character ch2) {
        if (ch2.charValue() < 'a' || ch2.charValue() > 'z') {
            return ch2.charValue() >= 'A' && ch2.charValue() <= 'Z';
        }
        return true;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length << 1);
        for (byte b2 : bArr) {
            char[] cArr = b;
            sb.append(cArr[(b2 >> 4) & 15]);
            sb.append(cArr[b2 & Ascii.SI]);
        }
        return sb.toString();
    }

    public static String a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer("javascript:(function() {  var config = document.createElement('script');  config.type = 'text/javascript'; config.innerHTML = window.atob('");
        stringBuffer.append(Base64.encodeToString(("window['adrum-start-time'] = new Date().getTime();(function(config){   config.spa = {   'spa2': " + z + "   };   config.fetch = true;     config.isZonePromise = true;     config.resTiming = {       sampler: 'TopN',       maxNum: 0   };})(window['adrum-config'] || (window['adrum-config'] = {}));").getBytes(), 0));
        stringBuffer.append("');  document.body.appendChild(config); var script = document.createElement('script');  script.type = 'text/javascript'; script.innerHTML = window.atob('");
        stringBuffer.append(aq.a);
        stringBuffer.append("') +                     window.atob('");
        stringBuffer.append(aq.b);
        stringBuffer.append("') +                     window.atob('");
        stringBuffer.append(aq.c);
        stringBuffer.append("') +  window.atob('");
        stringBuffer.append(aq.d);
        stringBuffer.append("');  document.body.appendChild(script); })()");
        return stringBuffer.toString();
    }

    public static void a(JsonWriter jsonWriter, Map<Class, Map<String, Object>> map) throws IOException {
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

    public static String b(String str) {
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

    public static String d(String str) {
        String str2;
        if (str == null) {
            str2 = "null";
        } else {
            str2 = str.trim().isEmpty() ? "empty" : str;
        }
        return !str2.equals(str) ? str2 : e(str);
    }

    public static String b(Throwable th) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (d + 60000 > jUptimeMillis) {
            return "Unknown";
        }
        d = jUptimeMillis;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        if (th == null) {
            return "Unknown";
        }
        th.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}

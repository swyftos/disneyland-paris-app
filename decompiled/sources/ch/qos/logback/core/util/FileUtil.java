package ch.qos.logback.core.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes2.dex */
public class FileUtil extends ContextAwareBase {
    public FileUtil(Context context) {
        setContext(context);
    }

    public static boolean createMissingParentDirectories(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return true;
        }
        parentFile.mkdirs();
        return parentFile.exists();
    }

    public static URL fileToURL(File file) {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unexpected exception on file [" + file + "]", e);
        }
    }

    public static String prefixRelativePath(String str, String str2) {
        if (str == null || OptionHelper.isEmpty(str.trim()) || new File(str2).isAbsolute()) {
            return str2;
        }
        return str + "/" + str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void copy(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r3 = 32768(0x8000, float:4.5918E-41)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
        L1a:
            int r4 = r1.read(r3)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            r5 = -1
            if (r4 == r5) goto L2b
            r5 = 0
            r2.write(r3, r5, r4)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            goto L1a
        L26:
            r7 = move-exception
        L27:
            r0 = r1
            goto L6e
        L29:
            r0 = move-exception
            goto L47
        L2b:
            r1.close()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            r2.close()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            return
        L32:
            r7 = move-exception
            goto L6e
        L34:
            r1 = move-exception
            r6 = r1
            r1 = r0
        L37:
            r0 = r6
            goto L47
        L39:
            r7 = move-exception
            r2 = r0
            goto L27
        L3c:
            r2 = move-exception
            r6 = r2
            r2 = r0
            goto L37
        L40:
            r7 = move-exception
            r2 = r0
            goto L6e
        L43:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L47:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26
            r3.<init>()     // Catch: java.lang.Throwable -> L26
            java.lang.String r4 = "Failed to copy ["
            r3.append(r4)     // Catch: java.lang.Throwable -> L26
            r3.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = "] to ["
            r3.append(r8)     // Catch: java.lang.Throwable -> L26
            r3.append(r9)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = "]"
            r3.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L26
            r7.addError(r8, r0)     // Catch: java.lang.Throwable -> L26
            ch.qos.logback.core.rolling.RolloverFailure r7 = new ch.qos.logback.core.rolling.RolloverFailure     // Catch: java.lang.Throwable -> L26
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L26
            throw r7     // Catch: java.lang.Throwable -> L26
        L6e:
            if (r0 == 0) goto L73
            r0.close()     // Catch: java.io.IOException -> L73
        L73:
            if (r2 == 0) goto L78
            r2.close()     // Catch: java.io.IOException -> L78
        L78:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.util.FileUtil.copy(java.lang.String, java.lang.String):void");
    }
}

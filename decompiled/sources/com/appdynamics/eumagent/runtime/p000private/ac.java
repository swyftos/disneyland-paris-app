package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.crashes.ProcMapInfo;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.aa;
import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ac {
    private final Map<String, aa> a = new HashMap();

    private aa a(ProcMapInfo.FileInfo fileInfo) {
        aa aaVar;
        aa aaVar2 = this.a.get(fileInfo.b);
        if (aaVar2 != null) {
            return aaVar2;
        }
        File file = null;
        if (BigInteger.ZERO.equals(fileInfo.a)) {
            fileInfo.d = Boolean.FALSE;
        } else {
            Boolean bool = fileInfo.d;
            if (bool != null) {
                if (bool.booleanValue()) {
                    file = new File(fileInfo.b);
                }
            } else if (fileInfo.c) {
                fileInfo.d = Boolean.FALSE;
            } else {
                String strSubstring = fileInfo.b;
                while (strSubstring.length() > 0) {
                    ADLog.log(1, "Looking for: %s", strSubstring);
                    File file2 = new File(strSubstring);
                    if (!file2.isFile()) {
                        ADLog.log(1, "Does not exist: %s", strSubstring);
                    } else if (!file2.canRead()) {
                        ADLog.log(1, "Is not readable: %s", strSubstring);
                    } else if (!fileInfo.a(strSubstring)) {
                        ADLog.log(1, "Mismatched file stats: %s", strSubstring);
                    } else {
                        fileInfo.b = strSubstring;
                        fileInfo.d = Boolean.TRUE;
                        file = file2;
                        break;
                    }
                    int iLastIndexOf = strSubstring.lastIndexOf(32);
                    if (iLastIndexOf == -1) {
                        break;
                    }
                    strSubstring = strSubstring.substring(0, iLastIndexOf);
                }
                ADLog.log(1, "Giving up on: %s", fileInfo.b);
                fileInfo.d = Boolean.FALSE;
            }
        }
        if (file == null) {
            return aaVar2;
        }
        try {
            aaVar = new aa(file);
        } catch (aa.b e) {
            e = e;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.a.put(fileInfo.b, aaVar);
            return aaVar;
        } catch (aa.b e2) {
            e = e2;
            aaVar2 = aaVar;
            ADLog.log(1, "File [%s] not and ELF file: %s", fileInfo.b, e);
            return aaVar2;
        } catch (Throwable th2) {
            th = th2;
            aaVar2 = aaVar;
            ADLog.log(1, "ELF File [%s] had parsing error: %s", fileInfo.b, th);
            return aaVar2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.appdynamics.eumagent.runtime.p000private.ab r12) {
        /*
            r11 = this;
            com.appdynamics.eumagent.runtime.private.ab$a[] r12 = r12.a
            int r0 = r12.length
            r1 = 0
            r2 = r1
            r3 = r2
        L6:
            r4 = 2
            if (r2 >= r0) goto L5e
            r5 = r12[r2]
            com.appdynamics.eumagent.runtime.crashes.ProcMapInfo$a r6 = r5.b     // Catch: java.lang.Throwable -> L1f
            if (r6 == 0) goto L4f
            com.appdynamics.eumagent.runtime.crashes.ProcMapInfo$FileInfo r6 = r6.c     // Catch: java.lang.Throwable -> L1f
            if (r6 != 0) goto L14
            goto L4f
        L14:
            com.appdynamics.eumagent.runtime.private.aa r6 = r11.a(r6)     // Catch: java.lang.Throwable -> L1f
            if (r6 == 0) goto L21
            com.appdynamics.eumagent.runtime.private.ab$b r6 = r6.a(r5)     // Catch: java.lang.Throwable -> L1f
            goto L22
        L1f:
            r5 = move-exception
            goto L52
        L21:
            r6 = 0
        L22:
            r5.d = r6     // Catch: java.lang.Throwable -> L1f
            if (r6 == 0) goto L4f
            boolean r6 = com.appdynamics.eumagent.runtime.logging.ADLog.isVerboseLoggingEnabled()     // Catch: java.lang.Throwable -> L1f
            r7 = 1
            if (r6 == 0) goto L50
            java.lang.String r6 = "Found symbol for frame: %s"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r8.<init>()     // Catch: java.lang.Throwable -> L1f
            com.appdynamics.eumagent.runtime.private.ab$b r9 = r5.d     // Catch: java.lang.Throwable -> L1f
            java.lang.String r9 = r9.a     // Catch: java.lang.Throwable -> L1f
            r8.append(r9)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r9 = "+"
            r8.append(r9)     // Catch: java.lang.Throwable -> L1f
            com.appdynamics.eumagent.runtime.private.ab$b r5 = r5.d     // Catch: java.lang.Throwable -> L1f
            long r9 = r5.b     // Catch: java.lang.Throwable -> L1f
            r8.append(r9)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r5 = r8.toString()     // Catch: java.lang.Throwable -> L1f
            com.appdynamics.eumagent.runtime.logging.ADLog.log(r7, r6, r5)     // Catch: java.lang.Throwable -> L1f
            goto L50
        L4f:
            r7 = r1
        L50:
            int r3 = r3 + r7
            goto L5b
        L52:
            java.lang.String r6 = "Unable to symbolicate stack frame: %s"
            java.lang.String r5 = r5.toString()
            com.appdynamics.eumagent.runtime.logging.ADLog.log(r4, r6, r5)
        L5b:
            int r2 = r2 + 1
            goto L6
        L5e:
            java.lang.String r11 = "Native Stack frames symbolicated: %d"
            com.appdynamics.eumagent.runtime.logging.ADLog.log(r4, r11, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.p000private.ac.a(com.appdynamics.eumagent.runtime.private.ab):int");
    }

    public final void a() {
        Iterator<Map.Entry<String, aa>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().a.close();
            } catch (Throwable unused) {
            }
        }
    }
}

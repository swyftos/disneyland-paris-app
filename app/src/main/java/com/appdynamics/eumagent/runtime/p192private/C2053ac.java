package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.crashes.ProcMapInfo;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.Marker;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ac */
/* JADX INFO: loaded from: classes2.dex */
public final class C2053ac {

    /* JADX INFO: renamed from: a */
    private final Map<String, C2051aa> f504a = new HashMap();

    /* JADX INFO: renamed from: a */
    private C2051aa m522a(ProcMapInfo.FileInfo fileInfo) {
        C2051aa c2051aa = this.f504a.get(fileInfo.f452b);
        if (c2051aa != null) {
            return c2051aa;
        }
        File file = null;
        if (BigInteger.ZERO.equals(fileInfo.f451a)) {
            fileInfo.f454d = Boolean.FALSE;
        } else {
            Boolean bool = fileInfo.f454d;
            if (bool != null) {
                if (bool.booleanValue()) {
                    file = new File(fileInfo.f452b);
                }
            } else if (fileInfo.f453c) {
                fileInfo.f454d = Boolean.FALSE;
            } else {
                String strSubstring = fileInfo.f452b;
                while (true) {
                    if (strSubstring.length() > 0) {
                        ADLog.log(1, "Looking for: %s", strSubstring);
                        File file2 = new File(strSubstring);
                        if (!file2.isFile()) {
                            ADLog.log(1, "Does not exist: %s", strSubstring);
                        } else if (!file2.canRead()) {
                            ADLog.log(1, "Is not readable: %s", strSubstring);
                        } else if (!fileInfo.m499a(strSubstring)) {
                            ADLog.log(1, "Mismatched file stats: %s", strSubstring);
                        } else {
                            fileInfo.f452b = strSubstring;
                            fileInfo.f454d = Boolean.TRUE;
                            file = file2;
                            break;
                        }
                        int iLastIndexOf = strSubstring.lastIndexOf(32);
                        if (iLastIndexOf != -1) {
                            strSubstring = strSubstring.substring(0, iLastIndexOf);
                        }
                    }
                    ADLog.log(1, "Giving up on: %s", fileInfo.f452b);
                    fileInfo.f454d = Boolean.FALSE;
                    break;
                }
            }
        }
        if (file == null) {
            return c2051aa;
        }
        try {
            C2051aa c2051aa2 = new C2051aa(file);
            try {
                this.f504a.put(fileInfo.f452b, c2051aa2);
                return c2051aa2;
            } catch (C2051aa.b e) {
                e = e;
                c2051aa = c2051aa2;
                ADLog.log(1, "File [%s] not and ELF file: %s", fileInfo.f452b, e);
                return c2051aa;
            } catch (Throwable th) {
                th = th;
                c2051aa = c2051aa2;
                ADLog.log(1, "ELF File [%s] had parsing error: %s", fileInfo.f452b, th);
                return c2051aa;
            }
        } catch (C2051aa.b e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004f  */
    /* JADX INFO: renamed from: a */
    public final int m523a(C2052ab c2052ab) {
        int i;
        ProcMapInfo.FileInfo fileInfo;
        int i2 = 0;
        for (C2052ab.a aVar : c2052ab.f496a) {
            try {
                ProcMapInfo.C2048a c2048a = aVar.f499b;
                if (c2048a == null || (fileInfo = c2048a.f459c) == null) {
                    i = 0;
                } else {
                    C2051aa c2051aaM522a = m522a(fileInfo);
                    C2052ab.b bVarM520a = c2051aaM522a != null ? c2051aaM522a.m520a(aVar) : null;
                    aVar.f501d = bVarM520a;
                    if (bVarM520a != null) {
                        i = 1;
                        if (ADLog.isVerboseLoggingEnabled()) {
                            ADLog.log(1, "Found symbol for frame: %s", aVar.f501d.f502a + Marker.ANY_NON_NULL_MARKER + aVar.f501d.f503b);
                        }
                    } else {
                        i = 0;
                    }
                }
                i2 += i;
            } catch (Throwable th) {
                ADLog.log(2, "Unable to symbolicate stack frame: %s", th.toString());
            }
        }
        ADLog.log(2, "Native Stack frames symbolicated: %d", i2);
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m524a() {
        Iterator<Map.Entry<String, C2051aa>> it = this.f504a.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().f467a.close();
            } catch (Throwable unused) {
            }
        }
    }
}

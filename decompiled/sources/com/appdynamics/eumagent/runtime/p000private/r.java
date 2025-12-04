package com.appdynamics.eumagent.runtime.p000private;

import androidx.media3.common.C;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class r {
    private File a;

    public r(File file) {
        this.a = file;
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Writer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean a(com.appdynamics.eumagent.runtime.p000private.s r4) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.String r0 = "Failed to close config file writer"
            java.io.File r1 = new java.io.File
            java.io.File r3 = r3.a
            java.lang.String r2 = "adeum-config"
            r1.<init>(r3, r2)
            r3 = 0
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L2b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L2b
            com.appdynamics.repacked.gson.stream.JsonWriter r3 = new com.appdynamics.repacked.gson.stream.JsonWriter     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L25
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L25
            r4.a(r3)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L25
            r2.close()     // Catch: java.io.IOException -> L1d
            goto L21
        L1d:
            r3 = move-exception
            com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r0, r3)
        L21:
            r3 = 1
            return r3
        L23:
            r3 = move-exception
            goto L3f
        L25:
            r3 = move-exception
            goto L2e
        L27:
            r4 = move-exception
            r2 = r3
            r3 = r4
            goto L3f
        L2b:
            r4 = move-exception
            r2 = r3
            r3 = r4
        L2e:
            java.lang.String r4 = "Failed to write config file"
            com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r4, r3)     // Catch: java.lang.Throwable -> L23
            if (r2 == 0) goto L3d
            r2.close()     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r3 = move-exception
            com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r0, r3)
        L3d:
            r3 = 0
            return r3
        L3f:
            if (r2 == 0) goto L49
            r2.close()     // Catch: java.io.IOException -> L45
            goto L49
        L45:
            r4 = move-exception
            com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r0, r4)
        L49:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.p000private.r.a(com.appdynamics.eumagent.runtime.private.s):boolean");
    }

    final s a() throws Throwable {
        FileReader fileReader = null;
        try {
            try {
                FileReader fileReader2 = new FileReader(new File(this.a, "adeum-config"));
                try {
                    s sVarA = s.a(new JsonReader(fileReader2));
                    try {
                        fileReader2.close();
                        return sVarA;
                    } catch (IOException e) {
                        ADLog.logAgentError("Failed to close config file reader", e);
                        return sVarA;
                    }
                } catch (IOException unused) {
                    fileReader = fileReader2;
                    ADLog.logVerbose("Failed to read config file");
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            ADLog.logAgentError("Failed to close config file reader", e2);
                        }
                    }
                    s sVar = new s();
                    Boolean bool = Boolean.FALSE;
                    sVar.a = bool;
                    sVar.c = bool;
                    sVar.b = bool;
                    Boolean bool2 = Boolean.TRUE;
                    sVar.f = bool2;
                    sVar.g = bool2;
                    sVar.e = bool2;
                    sVar.d = 0L;
                    sVar.i = Long.valueOf(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    sVar.k = bool;
                    sVar.j = bool;
                    sVar.l = bool;
                    sVar.m = 2;
                    sVar.n = 90;
                    sVar.o = 90;
                    sVar.p = 90;
                    return sVar;
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e3) {
                            ADLog.logAgentError("Failed to close config file reader", e3);
                        }
                    }
                    s sVar2 = new s();
                    Boolean bool3 = Boolean.FALSE;
                    sVar2.a = bool3;
                    sVar2.c = bool3;
                    sVar2.b = bool3;
                    Boolean bool4 = Boolean.TRUE;
                    sVar2.f = bool4;
                    sVar2.g = bool4;
                    sVar2.e = bool4;
                    sVar2.d = 0L;
                    sVar2.i = Long.valueOf(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    sVar2.k = bool3;
                    sVar2.j = bool3;
                    sVar2.l = bool3;
                    sVar2.m = 2;
                    sVar2.n = 90;
                    sVar2.o = 90;
                    sVar2.p = 90;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused2) {
        }
    }
}

package com.appdynamics.eumagent.runtime.p192private;

import androidx.media3.common.C0740C;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonReader;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.r */
/* JADX INFO: loaded from: classes2.dex */
public final class C2139r {

    /* JADX INFO: renamed from: a */
    private File f905a;

    public C2139r(File file) {
        this.f905a = file;
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Writer] */
    /* JADX INFO: renamed from: a */
    final boolean m710a(C2140s c2140s) {
        Throwable th;
        FileWriter fileWriter;
        IOException e;
        ?? r2 = "adeum-config";
        try {
            try {
                fileWriter = new FileWriter(new File(this.f905a, "adeum-config"));
                try {
                    c2140s.m712a(new JsonWriter(fileWriter));
                    try {
                        fileWriter.close();
                        return true;
                    } catch (IOException e2) {
                        ADLog.logAgentError("Failed to close config file writer", e2);
                        return true;
                    }
                } catch (IOException e3) {
                    e = e3;
                    ADLog.logAgentError("Failed to write config file", e);
                    if (fileWriter == null) {
                        return false;
                    }
                    try {
                        fileWriter.close();
                        return false;
                    } catch (IOException e4) {
                        ADLog.logAgentError("Failed to close config file writer", e4);
                        return false;
                    }
                }
            } catch (IOException e5) {
                fileWriter = null;
                e = e5;
            } catch (Throwable th2) {
                r2 = 0;
                th = th2;
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e6) {
                        ADLog.logAgentError("Failed to close config file writer", e6);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    final C2140s m709a() throws Throwable {
        FileReader fileReader = null;
        try {
            try {
                FileReader fileReader2 = new FileReader(new File(this.f905a, "adeum-config"));
                try {
                    C2140s c2140sM711a = C2140s.m711a(new JsonReader(fileReader2));
                    try {
                        fileReader2.close();
                        return c2140sM711a;
                    } catch (IOException e) {
                        ADLog.logAgentError("Failed to close config file reader", e);
                        return c2140sM711a;
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
                    C2140s c2140s = new C2140s();
                    Boolean bool = Boolean.FALSE;
                    c2140s.f906a = bool;
                    c2140s.f908c = bool;
                    c2140s.f907b = bool;
                    Boolean bool2 = Boolean.TRUE;
                    c2140s.f911f = bool2;
                    c2140s.f912g = bool2;
                    c2140s.f910e = bool2;
                    c2140s.f909d = 0L;
                    c2140s.f914i = Long.valueOf(C0740C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    c2140s.f916k = bool;
                    c2140s.f915j = bool;
                    c2140s.f917l = bool;
                    c2140s.f918m = 2;
                    c2140s.f919n = 90;
                    c2140s.f920o = 90;
                    c2140s.f921p = 90;
                    return c2140s;
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
                    C2140s c2140s2 = new C2140s();
                    Boolean bool3 = Boolean.FALSE;
                    c2140s2.f906a = bool3;
                    c2140s2.f908c = bool3;
                    c2140s2.f907b = bool3;
                    Boolean bool4 = Boolean.TRUE;
                    c2140s2.f911f = bool4;
                    c2140s2.f912g = bool4;
                    c2140s2.f910e = bool4;
                    c2140s2.f909d = 0L;
                    c2140s2.f914i = Long.valueOf(C0740C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    c2140s2.f916k = bool3;
                    c2140s2.f915j = bool3;
                    c2140s2.f917l = bool3;
                    c2140s2.f918m = 2;
                    c2140s2.f919n = 90;
                    c2140s2.f920o = 90;
                    c2140s2.f921p = 90;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused2) {
        }
    }
}

package com.appdynamics.eumagent.runtime.p192private;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.o */
/* JADX INFO: loaded from: classes2.dex */
public class C2136o extends AbstractC2129h {

    /* JADX INFO: renamed from: b */
    private String f900b;

    public C2136o(long j, String str) {
        super(j);
        this.f900b = str;
    }

    public String toString() {
        return "SerializedBeacon{\"contents\":{" + this.f900b + "}}";
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2129h
    /* JADX INFO: renamed from: a */
    public final void mo693a(Writer writer) throws IOException {
        writer.append((CharSequence) this.f900b);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2129h
    /* JADX INFO: renamed from: a */
    public final String mo692a() {
        return this.f900b;
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.o$a */
    public static class a {
        /* JADX INFO: renamed from: a */
        public C2136o mo525a(long j, String str) {
            return new C2136o(j, str);
        }
    }
}

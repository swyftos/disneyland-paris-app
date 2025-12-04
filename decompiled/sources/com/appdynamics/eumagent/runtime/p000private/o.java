package com.appdynamics.eumagent.runtime.p000private;

import java.io.IOException;
import java.io.Writer;

/* loaded from: classes2.dex */
public class o extends h {
    private String b;

    public o(long j, String str) {
        super(j);
        this.b = str;
    }

    public String toString() {
        return "SerializedBeacon{\"contents\":{" + this.b + "}}";
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.h
    public final void a(Writer writer) throws IOException {
        writer.append((CharSequence) this.b);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.h
    public final String a() {
        return this.b;
    }

    public static class a {
        public o a(long j, String str) {
            return new o(j, str);
        }
    }
}

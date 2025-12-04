package com.appdynamics.eumagent.runtime.p000private;

/* loaded from: classes2.dex */
public class bw {
    public final String a;
    public final boolean b;
    public final cs c;

    public bw(String str, boolean z, cs csVar) {
        this.a = str;
        this.b = z;
        this.c = csVar;
    }

    public String toString() {
        return "TimerCall{\"name\":\"" + this.a + "\",\"stop\":" + this.b + '}';
    }
}

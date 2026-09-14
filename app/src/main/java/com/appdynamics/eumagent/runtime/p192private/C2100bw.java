package com.appdynamics.eumagent.runtime.p192private;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bw */
/* JADX INFO: loaded from: classes2.dex */
public class C2100bw {

    /* JADX INFO: renamed from: a */
    public final String f731a;

    /* JADX INFO: renamed from: b */
    public final boolean f732b;

    /* JADX INFO: renamed from: c */
    public final C2123cs f733c;

    public C2100bw(String str, boolean z, C2123cs c2123cs) {
        this.f731a = str;
        this.f732b = z;
        this.f733c = c2123cs;
    }

    public String toString() {
        return "TimerCall{\"name\":\"" + this.f731a + "\",\"stop\":" + this.f732b + '}';
    }
}

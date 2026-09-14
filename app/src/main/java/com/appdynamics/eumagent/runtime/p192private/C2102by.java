package com.appdynamics.eumagent.runtime.p192private;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.by */
/* JADX INFO: loaded from: classes2.dex */
public class C2102by {

    /* JADX INFO: renamed from: a */
    public final int f740a;

    /* JADX INFO: renamed from: b */
    public final String f741b;

    /* JADX INFO: renamed from: c */
    public final C2123cs f742c = new C2123cs();

    public C2102by(String str, int i) {
        this.f741b = str;
        this.f740a = i;
    }

    public String toString() {
        return "ActivityLifecycleEvent{\"step\":\"" + this.f740a + "\",\"className\":\"" + this.f741b + "\",\"timestamp\":" + this.f742c + '}';
    }
}

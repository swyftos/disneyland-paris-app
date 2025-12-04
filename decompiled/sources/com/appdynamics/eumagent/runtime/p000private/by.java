package com.appdynamics.eumagent.runtime.p000private;

/* loaded from: classes2.dex */
public class by {
    public final int a;
    public final String b;
    public final cs c = new cs();

    public by(String str, int i) {
        this.b = str;
        this.a = i;
    }

    public String toString() {
        return "ActivityLifecycleEvent{\"step\":\"" + this.a + "\",\"className\":\"" + this.b + "\",\"timestamp\":" + this.c + '}';
    }
}

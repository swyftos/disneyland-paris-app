package com.appdynamics.eumagent.runtime.p000private;

/* loaded from: classes2.dex */
public class d {
    private String a;
    private String b;

    public d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String toString() {
        return "AppKeyChangedEvent{\"oldAppKey\":\"" + this.a + "\",\"newAppKey\":\"" + this.b + "\"}";
    }
}

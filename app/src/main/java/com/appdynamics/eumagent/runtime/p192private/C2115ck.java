package com.appdynamics.eumagent.runtime.p192private;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ck */
/* JADX INFO: loaded from: classes2.dex */
public class C2115ck {

    /* JADX INFO: renamed from: a */
    public final String f806a;

    /* JADX INFO: renamed from: b */
    public final Object f807b;

    /* JADX INFO: renamed from: c */
    public final Class f808c;

    public C2115ck(String str, Object obj, Class cls) {
        this.f806a = str;
        this.f807b = obj;
        this.f808c = cls;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SetUserDataCall{\"key\":\"");
        sb.append(this.f806a);
        sb.append("\",\"value\":");
        Object obj = this.f807b;
        if (obj instanceof String) {
            sb.append("\"");
            sb.append(this.f807b);
            sb.append('\"');
        } else {
            sb.append(obj);
        }
        sb.append('}');
        return sb.toString();
    }
}

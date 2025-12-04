package com.appdynamics.eumagent.runtime.p000private;

/* loaded from: classes2.dex */
public class ck {
    public final String a;
    public final Object b;
    public final Class c;

    public ck(String str, Object obj, Class cls) {
        this.a = str;
        this.b = obj;
        this.c = cls;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SetUserDataCall{\"key\":\"");
        sb.append(this.a);
        sb.append("\",\"value\":");
        Object obj = this.b;
        if (obj instanceof String) {
            sb.append("\"");
            sb.append(this.b);
            sb.append('\"');
        } else {
            sb.append(obj);
        }
        sb.append('}');
        return sb.toString();
    }
}

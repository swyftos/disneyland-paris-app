package com.appdynamics.eumagent.runtime.p192private;

import ch.qos.logback.core.CoreConstants;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.j */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2131j extends AbstractC2129h {

    /* JADX INFO: renamed from: b */
    public long f869b;

    /* JADX INFO: renamed from: c */
    public C2126e f870c;

    /* JADX INFO: renamed from: d */
    public Boolean f871d;

    /* JADX INFO: renamed from: e */
    public long f872e;

    /* JADX INFO: renamed from: f */
    public Map<Class, Map<String, Object>> f873f;

    /* JADX INFO: renamed from: g */
    public final C2123cs f874g;

    /* JADX INFO: renamed from: h */
    public final C2123cs f875h;

    /* JADX INFO: renamed from: i */
    private String f876i;

    /* JADX INFO: renamed from: j */
    private String f877j;

    /* JADX INFO: renamed from: a */
    protected abstract void mo500a(JsonWriter jsonWriter);

    public AbstractC2131j(String str, C2123cs c2123cs) {
        this(str, c2123cs, null);
    }

    public AbstractC2131j(String str, C2123cs c2123cs, C2123cs c2123cs2) {
        this(str, c2123cs, c2123cs2, UUID.randomUUID().toString());
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2129h
    /* JADX INFO: renamed from: a */
    public final String mo692a() throws IOException {
        StringWriter stringWriter = new StringWriter();
        m695b(new JsonWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2129h
    /* JADX INFO: renamed from: a */
    public final void mo693a(Writer writer) throws IOException {
        m695b(new JsonWriter(writer));
    }

    /* JADX INFO: renamed from: b */
    public final void m695b(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("type").value(this.f877j);
        jsonWriter.name("ec").value(this.f869b);
        jsonWriter.name("eid").value(this.f876i);
        jsonWriter.name("sessionCounter").value(this.f872e);
        if (this.f874g != null) {
            jsonWriter.name("st").value(this.f874g.f818b);
            jsonWriter.name("sut").value(this.f874g.f817a);
        }
        if (this.f875h != null) {
            jsonWriter.name("et").value(this.f875h.f818b);
            jsonWriter.name("eut").value(this.f875h.f817a);
        }
        if (this.f871d != null) {
            jsonWriter.name("bkgd").value(this.f871d);
        }
        mo500a(jsonWriter);
        C2126e c2126e = this.f870c;
        if (c2126e != null) {
            c2126e.m676a(jsonWriter, this.f873f);
        } else {
            Map<Class, Map<String, Object>> map = this.f873f;
            if (map != null) {
                C2124ct.m662a(jsonWriter, map);
            }
        }
        jsonWriter.endObject();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BeaconEvent(");
        sb.append(this.f877j);
        sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.beginObject();
            mo500a(jsonWriter);
            C2126e c2126e = this.f870c;
            if (c2126e != null) {
                c2126e.m676a(jsonWriter, this.f873f);
            } else {
                Map<Class, Map<String, Object>> map = this.f873f;
                if (map != null) {
                    C2124ct.m662a(jsonWriter, map);
                }
            }
            jsonWriter.endObject();
            sb.append(stringWriter.toString());
        } catch (IOException unused) {
            sb.append("{ Error serializing }");
        }
        return sb.toString();
    }

    public AbstractC2131j(String str, C2123cs c2123cs, C2123cs c2123cs2, String str2) {
        super(System.currentTimeMillis());
        this.f877j = str;
        this.f874g = c2123cs;
        this.f875h = c2123cs2;
        this.f876i = str2;
    }
}

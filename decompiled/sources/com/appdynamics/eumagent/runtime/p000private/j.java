package com.appdynamics.eumagent.runtime.p000private;

import ch.qos.logback.core.CoreConstants;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class j extends h {
    public long b;
    public e c;
    public Boolean d;
    public long e;
    public Map<Class, Map<String, Object>> f;
    public final cs g;
    public final cs h;
    private String i;
    private String j;

    protected abstract void a(JsonWriter jsonWriter);

    public j(String str, cs csVar) {
        this(str, csVar, null);
    }

    public j(String str, cs csVar, cs csVar2) {
        this(str, csVar, csVar2, UUID.randomUUID().toString());
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.h
    public final String a() throws IOException {
        StringWriter stringWriter = new StringWriter();
        b(new JsonWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.h
    public final void a(Writer writer) throws IOException {
        b(new JsonWriter(writer));
    }

    public final void b(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("type").value(this.j);
        jsonWriter.name("ec").value(this.b);
        jsonWriter.name("eid").value(this.i);
        jsonWriter.name("sessionCounter").value(this.e);
        if (this.g != null) {
            jsonWriter.name("st").value(this.g.b);
            jsonWriter.name("sut").value(this.g.a);
        }
        if (this.h != null) {
            jsonWriter.name("et").value(this.h.b);
            jsonWriter.name("eut").value(this.h.a);
        }
        if (this.d != null) {
            jsonWriter.name("bkgd").value(this.d);
        }
        a(jsonWriter);
        e eVar = this.c;
        if (eVar != null) {
            eVar.a(jsonWriter, this.f);
        } else {
            Map<Class, Map<String, Object>> map = this.f;
            if (map != null) {
                ct.a(jsonWriter, map);
            }
        }
        jsonWriter.endObject();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BeaconEvent(");
        sb.append(this.j);
        sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.beginObject();
            a(jsonWriter);
            e eVar = this.c;
            if (eVar != null) {
                eVar.a(jsonWriter, this.f);
            } else {
                Map<Class, Map<String, Object>> map = this.f;
                if (map != null) {
                    ct.a(jsonWriter, map);
                }
            }
            jsonWriter.endObject();
            sb.append(stringWriter.toString());
        } catch (IOException unused) {
            sb.append("{ Error serializing }");
        }
        return sb.toString();
    }

    public j(String str, cs csVar, cs csVar2, String str2) {
        super(System.currentTimeMillis());
        this.j = str;
        this.g = csVar;
        this.h = csVar2;
        this.i = str2;
    }
}

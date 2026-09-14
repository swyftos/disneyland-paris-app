package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.al */
/* JADX INFO: loaded from: classes2.dex */
public class C2062al extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private final int f532i;

    /* JADX INFO: renamed from: j */
    private final Throwable f533j;

    /* JADX INFO: renamed from: k */
    private final String f534k;

    public C2062al(Throwable th, int i, String str) {
        super(Constants.IPC_BUNDLE_KEY_SEND_ERROR, new C2123cs());
        this.f533j = th;
        this.f532i = i;
        this.f534k = str;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        String str;
        JsonWriter jsonWriterName = jsonWriter.name("sev");
        int i = this.f532i;
        if (i == 0) {
            str = OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO;
        } else if (i == 2) {
            str = "critical";
        } else {
            str = "warning";
        }
        jsonWriterName.value(str);
        if (this.f534k != null) {
            try {
                m557a(new JSONObject(this.f534k), jsonWriter);
            } catch (JSONException unused) {
                ADLog.logAgentError("Hybrid Exception Data from Hybrid Agent is malformed");
            }
        }
        if (this.f533j != null) {
            jsonWriter.name("javaThrowable");
            C2103bz.m628a(jsonWriter, this.f533j, false);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m557a(JSONObject jSONObject, JsonWriter jsonWriter) throws JSONException, IOException {
        jsonWriter.name("hed").beginObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof String) {
                jsonWriter.name(next).value(jSONObject.getString(next));
            } else if (obj instanceof Boolean) {
                jsonWriter.name(next).value(jSONObject.getBoolean(next));
            } else if (obj instanceof Long) {
                jsonWriter.name(next).value(jSONObject.getLong(next));
            } else if (obj instanceof Integer) {
                jsonWriter.name(next).value(jSONObject.getInt(next));
            } else if (obj instanceof Double) {
                jsonWriter.name(next).value(jSONObject.getDouble(next));
            }
        }
        jsonWriter.endObject();
    }
}

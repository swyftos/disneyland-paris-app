package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class al extends j {
    private final int i;
    private final Throwable j;
    private final String k;

    public al(Throwable th, int i, String str) {
        super(Constants.IPC_BUNDLE_KEY_SEND_ERROR, new cs());
        this.j = th;
        this.i = i;
        this.k = str;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        String str;
        JsonWriter jsonWriterName = jsonWriter.name("sev");
        int i = this.i;
        if (i == 0) {
            str = OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO;
        } else if (i == 2) {
            str = "critical";
        } else {
            str = "warning";
        }
        jsonWriterName.value(str);
        if (this.k != null) {
            try {
                a(new JSONObject(this.k), jsonWriter);
            } catch (JSONException unused) {
                ADLog.logAgentError("Hybrid Exception Data from Hybrid Agent is malformed");
            }
        }
        if (this.j != null) {
            jsonWriter.name("javaThrowable");
            bz.a(jsonWriter, this.j, false);
        }
    }

    private static void a(JSONObject jSONObject, JsonWriter jsonWriter) throws JSONException, IOException {
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

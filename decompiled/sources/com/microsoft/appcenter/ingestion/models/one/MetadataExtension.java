package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes4.dex */
public class MetadataExtension implements Model {
    private JSONObject mMetadata = new JSONObject();

    public JSONObject getMetadata() {
        return this.mMetadata;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Model
    public void read(JSONObject jSONObject) {
        this.mMetadata = jSONObject;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Model
    public void write(JSONStringer jSONStringer) throws JSONException {
        Iterator<String> itKeys = this.mMetadata.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONStringer.key(next).value(this.mMetadata.get(next));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mMetadata.toString().equals(((MetadataExtension) obj).mMetadata.toString());
    }

    public int hashCode() {
        return this.mMetadata.toString().hashCode();
    }
}

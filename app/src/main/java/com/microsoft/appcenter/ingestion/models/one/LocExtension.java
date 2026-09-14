package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* JADX INFO: loaded from: classes4.dex */
public class LocExtension implements Model {

    /* JADX INFO: renamed from: tz */
    private String f3668tz;

    public String getTz() {
        return this.f3668tz;
    }

    public void setTz(String str) {
        this.f3668tz = str;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Model
    public void read(JSONObject jSONObject) {
        setTz(jSONObject.optString("tz", null));
    }

    @Override // com.microsoft.appcenter.ingestion.models.Model
    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONUtils.write(jSONStringer, "tz", getTz());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocExtension locExtension = (LocExtension) obj;
        String str = this.f3668tz;
        if (str != null) {
            return str.equals(locExtension.f3668tz);
        }
        return locExtension.f3668tz == null;
    }

    public int hashCode() {
        String str = this.f3668tz;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}

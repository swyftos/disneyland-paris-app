package com.microsoft.appcenter.analytics.ingestion.models;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedPropertyUtils;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* JADX INFO: loaded from: classes4.dex */
public class EventLog extends LogWithNameAndProperties {
    public static final String TYPE = "event";

    /* JADX INFO: renamed from: id */
    private UUID f3658id;
    private List typedProperties;

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public String getType() {
        return "event";
    }

    public UUID getId() {
        return this.f3658id;
    }

    public void setId(UUID uuid) {
        this.f3658id = uuid;
    }

    public List<TypedProperty> getTypedProperties() {
        return this.typedProperties;
    }

    public void setTypedProperties(List<TypedProperty> list) {
        this.typedProperties = list;
    }

    @Override // com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties, com.microsoft.appcenter.ingestion.models.LogWithProperties, com.microsoft.appcenter.ingestion.models.AbstractLog, com.microsoft.appcenter.ingestion.models.Model
    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        setId(UUID.fromString(jSONObject.getString("id")));
        setTypedProperties(TypedPropertyUtils.read(jSONObject));
    }

    @Override // com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties, com.microsoft.appcenter.ingestion.models.LogWithProperties, com.microsoft.appcenter.ingestion.models.AbstractLog, com.microsoft.appcenter.ingestion.models.Model
    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        jSONStringer.key("id").value(getId());
        JSONUtils.writeArray(jSONStringer, CommonProperties.TYPED_PROPERTIES, getTypedProperties());
    }

    @Override // com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties, com.microsoft.appcenter.ingestion.models.LogWithProperties, com.microsoft.appcenter.ingestion.models.AbstractLog
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        EventLog eventLog = (EventLog) obj;
        UUID uuid = this.f3658id;
        if (uuid == null ? eventLog.f3658id != null : !uuid.equals(eventLog.f3658id)) {
            return false;
        }
        List list = this.typedProperties;
        if (list != null) {
            return list.equals(eventLog.typedProperties);
        }
        return eventLog.typedProperties == null;
    }

    @Override // com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties, com.microsoft.appcenter.ingestion.models.LogWithProperties, com.microsoft.appcenter.ingestion.models.AbstractLog
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        UUID uuid = this.f3658id;
        int iHashCode2 = (iHashCode + (uuid != null ? uuid.hashCode() : 0)) * 31;
        List list = this.typedProperties;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }
}

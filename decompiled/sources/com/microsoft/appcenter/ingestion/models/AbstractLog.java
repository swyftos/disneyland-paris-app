package com.microsoft.appcenter.ingestion.models;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes4.dex */
public abstract class AbstractLog implements Log {
    private Device device;
    private String distributionGroupId;
    private UUID sid;
    private Object tag;
    private Date timestamp;
    private final Set transmissionTargetTokens = new LinkedHashSet();
    private String userId;

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public Date getTimestamp() {
        return this.timestamp;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public UUID getSid() {
        return this.sid;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public void setSid(UUID uuid) {
        this.sid = uuid;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public String getDistributionGroupId() {
        return this.distributionGroupId;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public void setDistributionGroupId(String str) {
        this.distributionGroupId = str;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public String getUserId() {
        return this.userId;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public void setUserId(String str) {
        this.userId = str;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public Device getDevice() {
        return this.device;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public void setDevice(Device device) {
        this.device = device;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public Object getTag() {
        return this.tag;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public void setTag(Object obj) {
        this.tag = obj;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public synchronized void addTransmissionTarget(String str) {
        this.transmissionTargetTokens.add(str);
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public synchronized Set<String> getTransmissionTargetTokens() {
        return Collections.unmodifiableSet(this.transmissionTargetTokens);
    }

    @Override // com.microsoft.appcenter.ingestion.models.Model
    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONUtils.write(jSONStringer, "type", getType());
        jSONStringer.key("timestamp").value(JSONDateUtils.toString(getTimestamp()));
        JSONUtils.write(jSONStringer, CmcdConfiguration.KEY_SESSION_ID, getSid());
        JSONUtils.write(jSONStringer, "distributionGroupId", getDistributionGroupId());
        JSONUtils.write(jSONStringer, "userId", getUserId());
        if (getDevice() != null) {
            jSONStringer.key("device").object();
            getDevice().write(jSONStringer);
            jSONStringer.endObject();
        }
    }

    @Override // com.microsoft.appcenter.ingestion.models.Model
    public void read(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.getString("type").equals(getType())) {
            throw new JSONException("Invalid type");
        }
        setTimestamp(JSONDateUtils.toDate(jSONObject.getString("timestamp")));
        if (jSONObject.has(CmcdConfiguration.KEY_SESSION_ID)) {
            setSid(UUID.fromString(jSONObject.getString(CmcdConfiguration.KEY_SESSION_ID)));
        }
        setDistributionGroupId(jSONObject.optString("distributionGroupId", null));
        setUserId(jSONObject.optString("userId", null));
        if (jSONObject.has("device")) {
            Device device = new Device();
            device.read(jSONObject.getJSONObject("device"));
            setDevice(device);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractLog abstractLog = (AbstractLog) obj;
        if (!this.transmissionTargetTokens.equals(abstractLog.transmissionTargetTokens)) {
            return false;
        }
        Date date = this.timestamp;
        if (date == null ? abstractLog.timestamp != null : !date.equals(abstractLog.timestamp)) {
            return false;
        }
        UUID uuid = this.sid;
        if (uuid == null ? abstractLog.sid != null : !uuid.equals(abstractLog.sid)) {
            return false;
        }
        String str = this.distributionGroupId;
        if (str == null ? abstractLog.distributionGroupId != null : !str.equals(abstractLog.distributionGroupId)) {
            return false;
        }
        String str2 = this.userId;
        if (str2 == null ? abstractLog.userId != null : !str2.equals(abstractLog.userId)) {
            return false;
        }
        Device device = this.device;
        if (device == null ? abstractLog.device != null : !device.equals(abstractLog.device)) {
            return false;
        }
        Object obj2 = this.tag;
        return obj2 != null ? obj2.equals(abstractLog.tag) : abstractLog.tag == null;
    }

    public int hashCode() {
        int iHashCode = this.transmissionTargetTokens.hashCode() * 31;
        Date date = this.timestamp;
        int iHashCode2 = (iHashCode + (date != null ? date.hashCode() : 0)) * 31;
        UUID uuid = this.sid;
        int iHashCode3 = (iHashCode2 + (uuid != null ? uuid.hashCode() : 0)) * 31;
        String str = this.distributionGroupId;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.userId;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Device device = this.device;
        int iHashCode6 = (iHashCode5 + (device != null ? device.hashCode() : 0)) * 31;
        Object obj = this.tag;
        return iHashCode6 + (obj != null ? obj.hashCode() : 0);
    }
}

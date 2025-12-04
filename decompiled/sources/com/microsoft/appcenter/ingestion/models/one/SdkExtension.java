package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import com.microsoft.appcenter.utils.PrefStorageConstants;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes4.dex */
public class SdkExtension implements Model {
    private String epoch;
    private UUID installId;
    private String libVer;
    private Long seq;

    public String getLibVer() {
        return this.libVer;
    }

    public void setLibVer(String str) {
        this.libVer = str;
    }

    public String getEpoch() {
        return this.epoch;
    }

    public void setEpoch(String str) {
        this.epoch = str;
    }

    public Long getSeq() {
        return this.seq;
    }

    public void setSeq(Long l) {
        this.seq = l;
    }

    public UUID getInstallId() {
        return this.installId;
    }

    public void setInstallId(UUID uuid) {
        this.installId = uuid;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Model
    public void read(JSONObject jSONObject) throws JSONException {
        setLibVer(jSONObject.optString("libVer", null));
        setEpoch(jSONObject.optString("epoch", null));
        setSeq(JSONUtils.readLong(jSONObject, "seq"));
        if (jSONObject.has(PrefStorageConstants.KEY_INSTALL_ID)) {
            setInstallId(UUID.fromString(jSONObject.getString(PrefStorageConstants.KEY_INSTALL_ID)));
        }
    }

    @Override // com.microsoft.appcenter.ingestion.models.Model
    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONUtils.write(jSONStringer, "libVer", getLibVer());
        JSONUtils.write(jSONStringer, "epoch", getEpoch());
        JSONUtils.write(jSONStringer, "seq", getSeq());
        JSONUtils.write(jSONStringer, PrefStorageConstants.KEY_INSTALL_ID, getInstallId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SdkExtension sdkExtension = (SdkExtension) obj;
        String str = this.libVer;
        if (str == null ? sdkExtension.libVer != null : !str.equals(sdkExtension.libVer)) {
            return false;
        }
        String str2 = this.epoch;
        if (str2 == null ? sdkExtension.epoch != null : !str2.equals(sdkExtension.epoch)) {
            return false;
        }
        Long l = this.seq;
        if (l == null ? sdkExtension.seq != null : !l.equals(sdkExtension.seq)) {
            return false;
        }
        UUID uuid = this.installId;
        return uuid != null ? uuid.equals(sdkExtension.installId) : sdkExtension.installId == null;
    }

    public int hashCode() {
        String str = this.libVer;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.epoch;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.seq;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        UUID uuid = this.installId;
        return iHashCode3 + (uuid != null ? uuid.hashCode() : 0);
    }
}

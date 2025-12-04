package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class GetKeyRotationStatusRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GetKeyRotationStatusRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getKeyId() == null ? 0 : getKeyId().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetKeyRotationStatusRequest)) {
            return false;
        }
        GetKeyRotationStatusRequest getKeyRotationStatusRequest = (GetKeyRotationStatusRequest) obj;
        if ((getKeyRotationStatusRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        return getKeyRotationStatusRequest.getKeyId() == null || getKeyRotationStatusRequest.getKeyId().equals(getKeyId());
    }
}

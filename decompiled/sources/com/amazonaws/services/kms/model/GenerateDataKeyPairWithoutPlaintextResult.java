package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class GenerateDataKeyPairWithoutPlaintextResult implements Serializable {
    private String keyId;
    private String keyPairSpec;
    private ByteBuffer privateKeyCiphertextBlob;
    private ByteBuffer publicKey;

    public ByteBuffer getPrivateKeyCiphertextBlob() {
        return this.privateKeyCiphertextBlob;
    }

    public void setPrivateKeyCiphertextBlob(ByteBuffer byteBuffer) {
        this.privateKeyCiphertextBlob = byteBuffer;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withPrivateKeyCiphertextBlob(ByteBuffer byteBuffer) {
        this.privateKeyCiphertextBlob = byteBuffer;
        return this;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public void setKeyPairSpec(String str) {
        this.keyPairSpec = str;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyPairSpec(String str) {
        this.keyPairSpec = str;
        return this;
    }

    public void setKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPrivateKeyCiphertextBlob() != null) {
            sb.append("PrivateKeyCiphertextBlob: " + getPrivateKeyCiphertextBlob() + ",");
        }
        if (getPublicKey() != null) {
            sb.append("PublicKey: " + getPublicKey() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getKeyPairSpec() != null) {
            sb.append("KeyPairSpec: " + getKeyPairSpec());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getPrivateKeyCiphertextBlob() == null ? 0 : getPrivateKeyCiphertextBlob().hashCode()) + 31) * 31) + (getPublicKey() == null ? 0 : getPublicKey().hashCode())) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getKeyPairSpec() != null ? getKeyPairSpec().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyPairWithoutPlaintextResult)) {
            return false;
        }
        GenerateDataKeyPairWithoutPlaintextResult generateDataKeyPairWithoutPlaintextResult = (GenerateDataKeyPairWithoutPlaintextResult) obj;
        if ((generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob() == null) ^ (getPrivateKeyCiphertextBlob() == null)) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob() != null && !generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob().equals(getPrivateKeyCiphertextBlob())) {
            return false;
        }
        if ((generateDataKeyPairWithoutPlaintextResult.getPublicKey() == null) ^ (getPublicKey() == null)) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getPublicKey() != null && !generateDataKeyPairWithoutPlaintextResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if ((generateDataKeyPairWithoutPlaintextResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getKeyId() != null && !generateDataKeyPairWithoutPlaintextResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec() == null) ^ (getKeyPairSpec() == null)) {
            return false;
        }
        return generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec() == null || generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec().equals(getKeyPairSpec());
    }
}

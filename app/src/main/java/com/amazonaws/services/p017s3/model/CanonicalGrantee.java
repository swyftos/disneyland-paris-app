package com.amazonaws.services.p017s3.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class CanonicalGrantee implements Grantee, Serializable {

    /* JADX INFO: renamed from: id */
    private String f382id = null;
    private String displayName = null;

    @Override // com.amazonaws.services.p017s3.model.Grantee
    public String getTypeIdentifier() {
        return "id";
    }

    public CanonicalGrantee(String str) {
        setIdentifier(str);
    }

    @Override // com.amazonaws.services.p017s3.model.Grantee
    public void setIdentifier(String str) {
        this.f382id = str;
    }

    @Override // com.amazonaws.services.p017s3.model.Grantee
    public String getIdentifier() {
        return this.f382id;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CanonicalGrantee) {
            return this.f382id.equals(((CanonicalGrantee) obj).f382id);
        }
        return false;
    }

    public int hashCode() {
        return this.f382id.hashCode();
    }
}

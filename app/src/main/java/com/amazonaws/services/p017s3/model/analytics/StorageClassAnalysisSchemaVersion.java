package com.amazonaws.services.p017s3.model.analytics;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public enum StorageClassAnalysisSchemaVersion implements Serializable {
    V_1("V_1");

    private final String version;

    StorageClassAnalysisSchemaVersion(String str) {
        this.version = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.version;
    }
}

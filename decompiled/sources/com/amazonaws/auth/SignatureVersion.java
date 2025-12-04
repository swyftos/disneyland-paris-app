package com.amazonaws.auth;

import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes2.dex */
public enum SignatureVersion {
    V1("1"),
    V2(ExifInterface.GPS_MEASUREMENT_2D);

    private String value;

    SignatureVersion(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}

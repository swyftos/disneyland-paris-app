package com.facebook.soloader;

@DoNotStripAny
/* loaded from: classes3.dex */
public class SoLoaderULError extends UnsatisfiedLinkError {
    private String mSoName;

    public SoLoaderULError(String str, String str2) {
        super(str2);
        this.mSoName = str;
    }

    public SoLoaderULError(String str) {
        this.mSoName = str;
    }

    public String getSoName() {
        return this.mSoName;
    }
}

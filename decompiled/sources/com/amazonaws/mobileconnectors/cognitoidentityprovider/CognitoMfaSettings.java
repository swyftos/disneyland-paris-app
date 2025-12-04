package com.amazonaws.mobileconnectors.cognitoidentityprovider;

/* loaded from: classes2.dex */
public class CognitoMfaSettings {
    public static final String SMS_MFA = "SMS_MFA";
    public static final String TOTP_MFA = "TOTP_MFA";
    private String mfaName;
    private boolean enabled = false;
    private boolean preferred = false;

    public CognitoMfaSettings(String str) {
        this.mfaName = str;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public boolean isPreferred() {
        return this.preferred;
    }

    public void setPreferred(boolean z) {
        this.preferred = z;
    }

    public String getMfaName() {
        return this.mfaName;
    }
}

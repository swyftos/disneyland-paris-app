package org.bouncycastle.cert.crmf;

/* loaded from: classes6.dex */
public interface EncryptedValuePadder {
    byte[] getPaddedData(byte[] bArr);

    byte[] getUnpaddedData(byte[] bArr);
}

package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public class SignerUserID extends SignatureSubpacket {
    public SignerUserID(boolean z, String str) {
        super(28, z, false, Strings.toUTF8ByteArray(str));
    }

    public SignerUserID(boolean z, boolean z2, byte[] bArr) {
        super(28, z, z2, bArr);
    }

    public String getID() {
        return Strings.fromUTF8ByteArray(this.data);
    }

    public byte[] getRawID() {
        return Arrays.clone(this.data);
    }
}

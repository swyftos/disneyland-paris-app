package org.bouncycastle.crypto;

/* loaded from: classes6.dex */
public interface Committer {
    Commitment commit(byte[] bArr);

    boolean isRevealed(Commitment commitment, byte[] bArr);
}

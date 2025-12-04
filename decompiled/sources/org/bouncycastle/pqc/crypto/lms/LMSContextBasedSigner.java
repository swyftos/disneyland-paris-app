package org.bouncycastle.pqc.crypto.lms;

/* loaded from: classes6.dex */
public interface LMSContextBasedSigner {
    LMSContext generateLMSContext();

    byte[] generateSignature(LMSContext lMSContext);

    long getUsagesRemaining();
}

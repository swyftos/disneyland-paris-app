package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;

/* JADX INFO: loaded from: classes6.dex */
public interface AEADBlockCipher extends AEADCipher {
    BlockCipher getUnderlyingCipher();
}

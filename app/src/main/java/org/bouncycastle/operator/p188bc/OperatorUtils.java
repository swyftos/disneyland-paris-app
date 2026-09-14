package org.bouncycastle.operator.p188bc;

import java.security.Key;
import org.bouncycastle.operator.GenericKey;

/* JADX INFO: loaded from: classes6.dex */
abstract class OperatorUtils {
    static byte[] getKeyBytes(GenericKey genericKey) {
        if (genericKey.getRepresentation() instanceof Key) {
            return ((Key) genericKey.getRepresentation()).getEncoded();
        }
        if (genericKey.getRepresentation() instanceof byte[]) {
            return (byte[]) genericKey.getRepresentation();
        }
        throw new IllegalArgumentException("unknown generic key type");
    }
}

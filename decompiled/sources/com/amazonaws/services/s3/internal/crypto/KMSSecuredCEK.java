package com.amazonaws.services.s3.internal.crypto;

import java.util.Map;

@Deprecated
/* loaded from: classes2.dex */
final class KMSSecuredCEK extends SecuredCEK {
    KMSSecuredCEK(byte[] bArr, Map map) {
        super(bArr, "kms", map);
    }

    public static boolean isKMSKeyWrapped(String str) {
        return "kms".equals(str);
    }
}

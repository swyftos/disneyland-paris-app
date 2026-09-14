package com.amazonaws.services.p017s3.internal.crypto;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
final class KMSSecuredCEK extends SecuredCEK {
    KMSSecuredCEK(byte[] bArr, Map map) {
        super(bArr, "kms", map);
    }

    public static boolean isKMSKeyWrapped(String str) {
        return "kms".equals(str);
    }
}

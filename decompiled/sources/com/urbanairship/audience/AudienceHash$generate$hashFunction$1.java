package com.urbanairship.audience;

import com.urbanairship.util.FarmHashFingerprint64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
/* synthetic */ class AudienceHash$generate$hashFunction$1 extends FunctionReferenceImpl implements Function1 {
    public static final AudienceHash$generate$hashFunction$1 INSTANCE = new AudienceHash$generate$hashFunction$1();

    AudienceHash$generate$hashFunction$1() {
        super(1, FarmHashFingerprint64.class, "fingerprint", "fingerprint(Ljava/lang/String;)J", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Long invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Long.valueOf(FarmHashFingerprint64.fingerprint(p0));
    }
}

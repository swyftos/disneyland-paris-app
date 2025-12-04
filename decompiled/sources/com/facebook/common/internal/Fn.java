package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.Nullable;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public interface Fn<A, R> {
    @Nullable
    R apply(A a);
}

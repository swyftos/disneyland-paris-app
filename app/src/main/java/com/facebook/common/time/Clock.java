package com.facebook.common.time;

import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
@Nullsafe(Nullsafe.Mode.LOCAL)
public interface Clock {
    public static final long MAX_TIME = Long.MAX_VALUE;

    long now();
}

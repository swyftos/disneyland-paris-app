package com.facebook.common.time;

import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class CurrentThreadTimeClock implements Clock {
    @Override // com.facebook.common.time.Clock
    public long now() {
        return android.os.SystemClock.currentThreadTimeMillis();
    }
}

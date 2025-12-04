package com.facebook.common.disk;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public interface DiskTrimmable {
    void trimToMinimum();

    void trimToNothing();
}

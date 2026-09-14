package com.facebook.common.disk;

import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public interface DiskTrimmableRegistry {
    void registerDiskTrimmable(DiskTrimmable diskTrimmable);

    void unregisterDiskTrimmable(DiskTrimmable diskTrimmable);
}

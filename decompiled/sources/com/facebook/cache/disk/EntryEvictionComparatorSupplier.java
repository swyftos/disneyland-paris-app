package com.facebook.cache.disk;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public interface EntryEvictionComparatorSupplier {
    EntryEvictionComparator get();
}

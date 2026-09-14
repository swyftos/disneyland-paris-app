package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes4.dex */
@GwtCompatible
public interface Weigher<K, V> {
    int weigh(K k, V v);
}

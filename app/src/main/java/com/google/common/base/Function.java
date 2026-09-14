package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes4.dex */
@GwtCompatible
public interface Function<F, T> {
    T apply(F f);

    boolean equals(@CheckForNull Object obj);
}

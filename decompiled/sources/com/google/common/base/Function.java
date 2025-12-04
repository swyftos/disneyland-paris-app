package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes4.dex */
public interface Function<F, T> {
    T apply(F f);

    boolean equals(@CheckForNull Object obj);
}

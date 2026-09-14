package com.google.common.p036io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
@J2ktIncompatible
@GwtIncompatible
public interface LineProcessor<T> {
    T getResult();

    @CanIgnoreReturnValue
    boolean processLine(String str) throws IOException;
}

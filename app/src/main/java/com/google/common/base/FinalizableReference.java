package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: loaded from: classes4.dex */
@DoNotMock("Use an instance of one of the Finalizable*Reference classes")
@J2ktIncompatible
@GwtIncompatible
public interface FinalizableReference {
    void finalizeReferent();
}

package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: loaded from: classes4.dex */
@DoNotMock("Use Interners.new*Interner")
@J2ktIncompatible
@GwtIncompatible
public interface Interner<E> {
    E intern(E e);
}

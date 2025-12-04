package com.urbanairship.base;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@FunctionalInterface
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface Extender<T> {
    @NonNull
    T extend(@NonNull T t);
}

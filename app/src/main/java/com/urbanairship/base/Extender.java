package com.urbanairship.base;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface Extender<T> {
    @NonNull
    T extend(@NonNull T t);
}

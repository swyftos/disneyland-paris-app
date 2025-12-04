package com.contentsquare.android.sdk;

import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class x8<E> {

    @Nullable
    public a<E> a;

    @Nullable
    public a<E> b;

    public static final class a<T> {

        @NotNull
        public final WeakReference<T> a;

        @Nullable
        public a<T> b;

        @Nullable
        public a<T> c;

        public a(@Nullable T t) {
            this.a = new WeakReference<>(t);
        }
    }
}

package com.contentsquare.android.sdk;

import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.x8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2929x8<E> {

    /* JADX INFO: renamed from: a */
    @Nullable
    public a<E> f3247a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public a<E> f3248b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.x8$a */
    public static final class a<T> {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final WeakReference<T> f3249a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public a<T> f3250b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public a<T> f3251c;

        public a(@Nullable T t) {
            this.f3249a = new WeakReference<>(t);
        }
    }
}

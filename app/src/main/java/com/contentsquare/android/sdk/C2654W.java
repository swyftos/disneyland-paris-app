package com.contentsquare.android.sdk;

import androidx.collection.LongSparseArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.W */
/* JADX INFO: loaded from: classes2.dex */
public final class C2654W {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final LongSparseArray<C2691a0> f2196a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final LongSparseArray<C2691a0> f2197b;

    public C2654W(int i) {
        LongSparseArray<C2691a0> previousFrameBitmapHashes = new LongSparseArray<>();
        LongSparseArray<C2691a0> nextFrameBitmapHashes = new LongSparseArray<>();
        Intrinsics.checkNotNullParameter(previousFrameBitmapHashes, "previousFrameBitmapHashes");
        Intrinsics.checkNotNullParameter(nextFrameBitmapHashes, "nextFrameBitmapHashes");
        this.f2196a = previousFrameBitmapHashes;
        this.f2197b = nextFrameBitmapHashes;
    }
}

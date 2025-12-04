package com.contentsquare.android.sdk;

import androidx.collection.LongSparseArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class W {

    @NotNull
    public final LongSparseArray<C0621a0> a;

    @NotNull
    public final LongSparseArray<C0621a0> b;

    public W(int i) {
        LongSparseArray<C0621a0> previousFrameBitmapHashes = new LongSparseArray<>();
        LongSparseArray<C0621a0> nextFrameBitmapHashes = new LongSparseArray<>();
        Intrinsics.checkNotNullParameter(previousFrameBitmapHashes, "previousFrameBitmapHashes");
        Intrinsics.checkNotNullParameter(nextFrameBitmapHashes, "nextFrameBitmapHashes");
        this.a = previousFrameBitmapHashes;
        this.b = nextFrameBitmapHashes;
    }
}

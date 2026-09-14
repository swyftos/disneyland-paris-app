package androidx.media3.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.SniffFailure;
import com.google.common.primitives.ImmutableIntArray;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class UnsupportedBrandsSniffFailure implements SniffFailure {
    public final ImmutableIntArray compatibleBrands;
    public final int majorBrand;

    public UnsupportedBrandsSniffFailure(int i, @Nullable int[] iArr) {
        ImmutableIntArray immutableIntArrayM1651of;
        this.majorBrand = i;
        if (iArr != null) {
            immutableIntArrayM1651of = ImmutableIntArray.copyOf(iArr);
        } else {
            immutableIntArrayM1651of = ImmutableIntArray.m1651of();
        }
        this.compatibleBrands = immutableIntArrayM1651of;
    }
}

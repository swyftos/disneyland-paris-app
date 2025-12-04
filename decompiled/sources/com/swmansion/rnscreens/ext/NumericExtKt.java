package com.swmansion.rnscreens.ext;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"equalWithRespectToEps", "", "", ETCPaymentMethod.OTHER, "eps", "react-native-screens_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NumericExtKt {
    public static /* synthetic */ boolean equalWithRespectToEps$default(float f, float f2, float f3, int i, Object obj) {
        if ((i & 2) != 0) {
            f3 = 1.0E-4f;
        }
        return equalWithRespectToEps(f, f2, f3);
    }

    public static final boolean equalWithRespectToEps(float f, float f2, float f3) {
        return Math.abs(f - f2) <= f3;
    }
}

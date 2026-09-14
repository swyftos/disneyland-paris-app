package org.bouncycastle.math.p183ec.endo;

import org.bouncycastle.math.p183ec.ECPointMap;

/* JADX INFO: loaded from: classes6.dex */
public interface ECEndomorphism {
    ECPointMap getPointMap();

    boolean hasEfficientPointMap();
}

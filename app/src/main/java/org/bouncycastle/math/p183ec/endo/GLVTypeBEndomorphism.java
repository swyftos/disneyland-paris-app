package org.bouncycastle.math.p183ec.endo;

import java.math.BigInteger;
import org.bouncycastle.math.p183ec.ECCurve;
import org.bouncycastle.math.p183ec.ECPointMap;
import org.bouncycastle.math.p183ec.ScaleXPointMap;

/* JADX INFO: loaded from: classes6.dex */
public class GLVTypeBEndomorphism implements GLVEndomorphism {
    protected final GLVTypeBParameters parameters;
    protected final ECPointMap pointMap;

    public GLVTypeBEndomorphism(ECCurve eCCurve, GLVTypeBParameters gLVTypeBParameters) {
        this.parameters = gLVTypeBParameters;
        this.pointMap = new ScaleXPointMap(eCCurve.fromBigInteger(gLVTypeBParameters.getBeta()));
    }

    @Override // org.bouncycastle.math.p183ec.endo.GLVEndomorphism
    public BigInteger[] decomposeScalar(BigInteger bigInteger) {
        return EndoUtil.decomposeScalar(this.parameters.getSplitParams(), bigInteger);
    }

    @Override // org.bouncycastle.math.p183ec.endo.ECEndomorphism
    public ECPointMap getPointMap() {
        return this.pointMap;
    }

    @Override // org.bouncycastle.math.p183ec.endo.ECEndomorphism
    public boolean hasEfficientPointMap() {
        return true;
    }
}

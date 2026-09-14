package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda31 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ boolean[] f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda31(boolean[] zArr) {
        this.f$0 = zArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return ArrayUtils.toObject(this.f$0);
    }
}

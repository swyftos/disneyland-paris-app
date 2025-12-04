package com.facebook.common.references;

import com.facebook.infer.annotation.Nullsafe;
import java.lang.ref.SoftReference;
import javax.annotation.Nullable;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public class OOMSoftReference<T> {
    SoftReference softRef1 = null;
    SoftReference softRef2 = null;
    SoftReference softRef3 = null;

    public void set(T t) {
        this.softRef1 = new SoftReference(t);
        this.softRef2 = new SoftReference(t);
        this.softRef3 = new SoftReference(t);
    }

    @Nullable
    public T get() {
        SoftReference softReference = this.softRef1;
        if (softReference == null) {
            return null;
        }
        return (T) softReference.get();
    }

    public void clear() {
        SoftReference softReference = this.softRef1;
        if (softReference != null) {
            softReference.clear();
            this.softRef1 = null;
        }
        SoftReference softReference2 = this.softRef2;
        if (softReference2 != null) {
            softReference2.clear();
            this.softRef2 = null;
        }
        SoftReference softReference3 = this.softRef3;
        if (softReference3 != null) {
            softReference3.clear();
            this.softRef3 = null;
        }
    }
}

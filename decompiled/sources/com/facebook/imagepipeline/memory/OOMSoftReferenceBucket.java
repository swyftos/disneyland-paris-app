package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.OOMSoftReference;
import java.util.LinkedList;

/* loaded from: classes3.dex */
class OOMSoftReferenceBucket extends Bucket {
    private LinkedList mSpareReferences;

    public OOMSoftReferenceBucket(int i, int i2, int i3) {
        super(i, i2, i3, false);
        this.mSpareReferences = new LinkedList();
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public Object pop() {
        OOMSoftReference oOMSoftReference = (OOMSoftReference) this.mFreeList.poll();
        Preconditions.checkNotNull(oOMSoftReference);
        Object obj = oOMSoftReference.get();
        oOMSoftReference.clear();
        this.mSpareReferences.add(oOMSoftReference);
        return obj;
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    void addToFreeList(Object obj) {
        OOMSoftReference oOMSoftReference = (OOMSoftReference) this.mSpareReferences.poll();
        if (oOMSoftReference == null) {
            oOMSoftReference = new OOMSoftReference();
        }
        oOMSoftReference.set(obj);
        this.mFreeList.add(oOMSoftReference);
    }
}

package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$UnsafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public final /* synthetic */ class zzec {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j, Object obj2, Object obj3) {
        while (!AbstractFuture$UnsafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(unsafe, obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}

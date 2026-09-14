package org.apache.commons.lang3.function;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableIntToFloatFunction<E extends Throwable> {
    public static final FailableIntToFloatFunction NOP = new FailableIntToFloatFunction() { // from class: org.apache.commons.lang3.function.FailableIntToFloatFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableIntToFloatFunction
        public final float applyAsFloat(int i) {
            return BitmapDescriptorFactory.HUE_RED;
        }
    };

    float applyAsFloat(int i) throws Throwable;

    static <E extends Throwable> FailableIntToFloatFunction<E> nop() {
        return NOP;
    }
}

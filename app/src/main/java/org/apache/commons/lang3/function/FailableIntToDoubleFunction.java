package org.apache.commons.lang3.function;

import androidx.camera.video.AudioStats;
import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableIntToDoubleFunction<E extends Throwable> {
    public static final FailableIntToDoubleFunction NOP = new FailableIntToDoubleFunction() { // from class: org.apache.commons.lang3.function.FailableIntToDoubleFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableIntToDoubleFunction
        public final double applyAsDouble(int i) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    };

    double applyAsDouble(int i) throws Throwable;

    static <E extends Throwable> FailableIntToDoubleFunction<E> nop() {
        return NOP;
    }
}

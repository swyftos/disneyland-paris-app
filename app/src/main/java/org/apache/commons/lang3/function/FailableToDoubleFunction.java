package org.apache.commons.lang3.function;

import androidx.camera.video.AudioStats;
import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableToDoubleFunction<T, E extends Throwable> {
    public static final FailableToDoubleFunction NOP = new FailableToDoubleFunction() { // from class: org.apache.commons.lang3.function.FailableToDoubleFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableToDoubleFunction
        public final double applyAsDouble(Object obj) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    };

    double applyAsDouble(T t) throws Throwable;

    static <T, E extends Throwable> FailableToDoubleFunction<T, E> nop() {
        return NOP;
    }
}

package org.apache.commons.lang3.function;

import androidx.camera.video.AudioStats;
import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableLongToDoubleFunction<E extends Throwable> {
    public static final FailableLongToDoubleFunction NOP = new FailableLongToDoubleFunction() { // from class: org.apache.commons.lang3.function.FailableLongToDoubleFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableLongToDoubleFunction
        public final double applyAsDouble(long j) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    };

    double applyAsDouble(long j) throws Throwable;

    static <E extends Throwable> FailableLongToDoubleFunction<E> nop() {
        return NOP;
    }
}

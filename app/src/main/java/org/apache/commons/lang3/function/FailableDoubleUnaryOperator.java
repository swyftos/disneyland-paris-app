package org.apache.commons.lang3.function;

import androidx.camera.video.AudioStats;
import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public interface FailableDoubleUnaryOperator<E extends Throwable> {
    public static final FailableDoubleUnaryOperator NOP = new FailableDoubleUnaryOperator() { // from class: org.apache.commons.lang3.function.FailableDoubleUnaryOperator$$ExternalSyntheticLambda1
        @Override // org.apache.commons.lang3.function.FailableDoubleUnaryOperator
        public final double applyAsDouble(double d) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ double lambda$identity$0(double d) {
        return d;
    }

    double applyAsDouble(double d) throws Throwable;

    static <E extends Throwable> FailableDoubleUnaryOperator<E> identity() {
        return new FailableDoubleUnaryOperator() { // from class: org.apache.commons.lang3.function.FailableDoubleUnaryOperator$$ExternalSyntheticLambda0
            @Override // org.apache.commons.lang3.function.FailableDoubleUnaryOperator
            public final double applyAsDouble(double d) {
                return FailableDoubleUnaryOperator.lambda$identity$0(d);
            }
        };
    }

    static <E extends Throwable> FailableDoubleUnaryOperator<E> nop() {
        return NOP;
    }

    default FailableDoubleUnaryOperator<E> andThen(final FailableDoubleUnaryOperator<E> failableDoubleUnaryOperator) {
        Objects.requireNonNull(failableDoubleUnaryOperator);
        return new FailableDoubleUnaryOperator() { // from class: org.apache.commons.lang3.function.FailableDoubleUnaryOperator$$ExternalSyntheticLambda3
            @Override // org.apache.commons.lang3.function.FailableDoubleUnaryOperator
            public final double applyAsDouble(double d) {
                return this.f$0.lambda$andThen$0(failableDoubleUnaryOperator, d);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default double lambda$andThen$0(FailableDoubleUnaryOperator failableDoubleUnaryOperator, double d) {
        return failableDoubleUnaryOperator.applyAsDouble(applyAsDouble(d));
    }

    default FailableDoubleUnaryOperator<E> compose(final FailableDoubleUnaryOperator<E> failableDoubleUnaryOperator) {
        Objects.requireNonNull(failableDoubleUnaryOperator);
        return new FailableDoubleUnaryOperator() { // from class: org.apache.commons.lang3.function.FailableDoubleUnaryOperator$$ExternalSyntheticLambda2
            @Override // org.apache.commons.lang3.function.FailableDoubleUnaryOperator
            public final double applyAsDouble(double d) {
                return this.f$0.lambda$compose$0(failableDoubleUnaryOperator, d);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default double lambda$compose$0(FailableDoubleUnaryOperator failableDoubleUnaryOperator, double d) {
        return applyAsDouble(failableDoubleUnaryOperator.applyAsDouble(d));
    }
}

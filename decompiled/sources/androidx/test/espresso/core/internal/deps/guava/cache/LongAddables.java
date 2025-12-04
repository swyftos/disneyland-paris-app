package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
abstract class LongAddables {
    private static final Supplier SUPPLIER;

    private static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LongAddable
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LongAddables.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Supplier
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LongAddables.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Supplier
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        SUPPLIER = supplier;
    }

    public static LongAddable create() {
        return (LongAddable) SUPPLIER.get();
    }
}

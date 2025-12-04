package androidx.test.espresso.core.internal.deps.guava.cache;

/* loaded from: classes2.dex */
public enum RemovalCause {
    EXPLICIT { // from class: androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.1
        @Override // androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause
        boolean wasEvicted() {
            return false;
        }
    },
    REPLACED { // from class: androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.2
        @Override // androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause
        boolean wasEvicted() {
            return false;
        }
    },
    COLLECTED { // from class: androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.3
        @Override // androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }
    },
    EXPIRED { // from class: androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.4
        @Override // androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }
    },
    SIZE { // from class: androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.5
        @Override // androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }
    };

    abstract boolean wasEvicted();
}

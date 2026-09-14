package org.apache.commons.lang3.function;

import java.util.function.Supplier;

/* JADX INFO: loaded from: classes6.dex */
public class Suppliers {
    private static Supplier NUL = new Supplier() { // from class: org.apache.commons.lang3.function.Suppliers$$ExternalSyntheticLambda0
        @Override // java.util.function.Supplier
        public final Object get() {
            return Suppliers.lambda$static$0();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$0() {
        return null;
    }

    public static <T> T get(Supplier<T> supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier.get();
    }

    public static <T> Supplier<T> nul() {
        return NUL;
    }

    @Deprecated
    public Suppliers() {
    }
}

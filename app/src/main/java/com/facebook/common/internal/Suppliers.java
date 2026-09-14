package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class Suppliers {
    public static final Supplier<Boolean> BOOLEAN_TRUE = new Supplier() { // from class: com.facebook.common.internal.Suppliers.2
        @Override // com.facebook.common.internal.Supplier
        public Boolean get() {
            return Boolean.TRUE;
        }
    };
    public static final Supplier<Boolean> BOOLEAN_FALSE = new Supplier() { // from class: com.facebook.common.internal.Suppliers.3
        @Override // com.facebook.common.internal.Supplier
        public Boolean get() {
            return Boolean.FALSE;
        }
    };
    public static final Supplier<String> STRING_EMPTY = new Supplier() { // from class: com.facebook.common.internal.Suppliers.4
        @Override // com.facebook.common.internal.Supplier
        public String get() {
            return "";
        }
    };

    /* JADX INFO: renamed from: of */
    public static <T> Supplier<T> m1270of(final T t) {
        return new Supplier() { // from class: com.facebook.common.internal.Suppliers.1
            @Override // com.facebook.common.internal.Supplier
            public Object get() {
                return t;
            }
        };
    }
}

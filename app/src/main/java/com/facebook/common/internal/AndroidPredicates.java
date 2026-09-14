package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class AndroidPredicates {
    public static <T> Predicate<T> True() {
        return new Predicate() { // from class: com.facebook.common.internal.AndroidPredicates.1
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(Object obj) {
                return true;
            }
        };
    }

    public static <T> Predicate<T> False() {
        return new Predicate() { // from class: com.facebook.common.internal.AndroidPredicates.2
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(Object obj) {
                return false;
            }
        };
    }
}

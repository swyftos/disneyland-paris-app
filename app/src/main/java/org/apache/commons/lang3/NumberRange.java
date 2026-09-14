package org.apache.commons.lang3;

import java.lang.Number;
import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public class NumberRange<N extends Number> extends Range<N> {
    private static final long serialVersionUID = 1;

    public NumberRange(N n, N n2, Comparator<N> comparator) {
        super(n, n2, comparator);
    }
}

package org.apache.commons.lang3.tuple;

import com.facebook.react.uimanager.ViewProps;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class MutablePair<L, R> extends Pair<L, R> {
    public static final MutablePair<?, ?>[] EMPTY_ARRAY = new MutablePair[0];
    private static final long serialVersionUID = 4954918890077093841L;
    public L left;
    public R right;

    /* JADX WARN: Multi-variable type inference failed */
    public static <L, R> MutablePair<L, R>[] emptyArray() {
        return (MutablePair<L, R>[]) EMPTY_ARRAY;
    }

    /* JADX INFO: renamed from: of */
    public static <L, R> MutablePair<L, R> m1979of(L l, R r) {
        return new MutablePair<>(l, r);
    }

    /* JADX INFO: renamed from: of */
    public static <L, R> MutablePair<L, R> m1980of(Map.Entry<L, R> entry) {
        L key;
        R value;
        if (entry != null) {
            key = entry.getKey();
            value = entry.getValue();
        } else {
            key = null;
            value = null;
        }
        return new MutablePair<>(key, value);
    }

    public static <L, R> MutablePair<L, R> ofNonNull(L l, R r) {
        Objects.requireNonNull(l, ViewProps.LEFT);
        Objects.requireNonNull(r, ViewProps.RIGHT);
        return m1979of((Object) l, (Object) r);
    }

    public static <L, R> MutablePair<L, R> ofNonNull(Map.Entry<L, R> entry) {
        Objects.requireNonNull(entry, "pair");
        return m1980of((Map.Entry) entry);
    }

    public MutablePair() {
    }

    public MutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    public void setLeft(L l) {
        this.left = l;
    }

    public void setRight(R r) {
        this.right = r;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r) {
        R right = getRight();
        setRight(r);
        return right;
    }
}

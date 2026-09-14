package org.apache.commons.lang3.builder;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface Diffable<T> {
    DiffResult<T> diff(T t);
}

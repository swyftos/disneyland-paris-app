package io.cucumber.datatable.dependency.difflib;

import java.util.List;

/* loaded from: classes5.dex */
public interface DiffAlgorithm<T> {
    Patch<T> diff(List<T> list, List<T> list2);

    Patch<T> diff(T[] tArr, T[] tArr2);
}

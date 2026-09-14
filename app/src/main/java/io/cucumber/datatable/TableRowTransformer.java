package io.cucumber.datatable;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface TableRowTransformer<T> {
    T transform(List<String> list) throws Throwable;
}

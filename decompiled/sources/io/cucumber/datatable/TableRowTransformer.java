package io.cucumber.datatable;

import java.util.List;

/* loaded from: classes5.dex */
public interface TableRowTransformer<T> {
    T transform(List<String> list) throws Throwable;
}

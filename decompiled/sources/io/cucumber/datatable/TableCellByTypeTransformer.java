package io.cucumber.datatable;

/* loaded from: classes5.dex */
public interface TableCellByTypeTransformer {
    <T> T transform(String str, Class<T> cls) throws Throwable;
}

package io.cucumber.datatable;

/* JADX INFO: loaded from: classes5.dex */
public interface TableCellByTypeTransformer {
    <T> T transform(String str, Class<T> cls) throws Throwable;
}

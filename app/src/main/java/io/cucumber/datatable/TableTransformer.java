package io.cucumber.datatable;

/* JADX INFO: loaded from: classes5.dex */
public interface TableTransformer<T> {
    T transform(DataTable dataTable) throws Throwable;
}

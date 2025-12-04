package io.cucumber.datatable;

import java.util.Map;

/* loaded from: classes5.dex */
public interface TableEntryByTypeTransformer {
    <T> T transform(Map<String, String> map, Class<T> cls, TableCellByTypeTransformer tableCellByTypeTransformer) throws Throwable;
}

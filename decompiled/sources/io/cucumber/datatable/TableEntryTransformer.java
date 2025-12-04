package io.cucumber.datatable;

import java.util.Map;

/* loaded from: classes5.dex */
public interface TableEntryTransformer<T> {
    T transform(Map<String, String> map) throws Throwable;
}

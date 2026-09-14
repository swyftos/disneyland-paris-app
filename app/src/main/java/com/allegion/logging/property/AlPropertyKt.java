package com.allegion.logging.property;

import com.allegion.logging.entry.IAlEntry;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1834bv = {1, 0, 3}, m1835d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1836d2 = {"consolidate", "", "", "Ljava/io/Serializable;", "", "Lcom/allegion/logging/property/AlProperty;", "entry", "Lcom/allegion/logging/entry/IAlEntry;", "AlLogging_release"}, m1837k = 2, m1838mv = {1, 1, 15})
public final class AlPropertyKt {
    @NotNull
    public static final Map<String, Serializable> consolidate(@NotNull Set<AlProperty> consolidate, @NotNull IAlEntry entry) {
        Intrinsics.checkParameterIsNotNull(consolidate, "$this$consolidate");
        Intrinsics.checkParameterIsNotNull(entry, "entry");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AlProperty alProperty : consolidate) {
            if (alProperty.getAppliesToEntry().invoke(entry).booleanValue()) {
                for (Map.Entry<String, Serializable> entry2 : alProperty.getPairs().entrySet()) {
                    linkedHashMap.put(entry2.getKey(), entry2.getValue());
                }
            }
        }
        return linkedHashMap;
    }
}

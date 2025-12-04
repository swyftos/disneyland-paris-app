package com.allegion.logging.property;

import com.allegion.logging.entry.IAlEntry;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/allegion/logging/property/AlProperty;", "", "pairs", "", "", "Ljava/io/Serializable;", "appliesToEntry", "Lkotlin/Function1;", "Lcom/allegion/logging/entry/IAlEntry;", "", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "getAppliesToEntry", "()Lkotlin/jvm/functions/Function1;", "getPairs", "()Ljava/util/Map;", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlProperty {

    @NotNull
    private final Function1<IAlEntry, Boolean> appliesToEntry;

    @NotNull
    private final Map<String, Serializable> pairs;

    /* JADX WARN: Multi-variable type inference failed */
    public AlProperty(@NotNull Map<String, ? extends Serializable> pairs, @NotNull Function1<? super IAlEntry, Boolean> appliesToEntry) {
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        Intrinsics.checkParameterIsNotNull(appliesToEntry, "appliesToEntry");
        this.pairs = pairs;
        this.appliesToEntry = appliesToEntry;
    }

    @NotNull
    public final Map<String, Serializable> getPairs() {
        return this.pairs;
    }

    @NotNull
    public final Function1<IAlEntry, Boolean> getAppliesToEntry() {
        return this.appliesToEntry;
    }
}

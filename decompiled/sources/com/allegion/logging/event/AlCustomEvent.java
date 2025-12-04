package com.allegion.logging.event;

import androidx.core.util.Pair;
import com.urbanairship.analytics.CustomEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012.\u0010\u0007\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\b\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR,\u0010\u0007\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/allegion/logging/event/AlCustomEvent;", "Lcom/allegion/logging/event/IAlCustomEvent;", "type", "Lcom/allegion/logging/event/AlEventType;", "category", "", "action", CustomEvent.PROPERTIES, "", "Landroidx/core/util/Pair;", "", "(Lcom/allegion/logging/event/AlEventType;Ljava/lang/String;Ljava/lang/String;[Landroidx/core/util/Pair;)V", "getAction", "()Ljava/lang/String;", "getCategory", "getProperties", "()[Landroidx/core/util/Pair;", "[Landroidx/core/util/Pair;", "getType", "()Lcom/allegion/logging/event/AlEventType;", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlCustomEvent implements IAlCustomEvent {

    @NotNull
    private final String action;

    @NotNull
    private final String category;

    @NotNull
    private final Pair<String, Object>[] properties;

    @NotNull
    private final AlEventType type;

    public AlCustomEvent(@NotNull AlEventType type, @NotNull String category, @NotNull String action, @NotNull Pair<String, Object>... properties) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(properties, "properties");
        this.type = type;
        this.category = category;
        this.action = action;
        this.properties = properties;
    }

    @Override // com.allegion.logging.event.IAlCustomEvent
    @NotNull
    public AlEventType getType() {
        return this.type;
    }

    @Override // com.allegion.logging.entry.IAlEntry
    @NotNull
    public String getCategory() {
        return this.category;
    }

    @Override // com.allegion.logging.entry.IAlEntry
    @NotNull
    public String getAction() {
        return this.action;
    }

    @Override // com.allegion.logging.event.IAlCustomEvent
    @NotNull
    public Pair<String, Object>[] getProperties() {
        return this.properties;
    }
}

package com.allegion.logging.event;

import androidx.core.util.Pair;
import com.urbanairship.analytics.CustomEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R(\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/allegion/logging/event/IAlCustomEvent;", "Lcom/allegion/logging/event/IAlEvent;", CustomEvent.PROPERTIES, "", "Landroidx/core/util/Pair;", "", "", "getProperties", "()[Landroidx/core/util/Pair;", "type", "Lcom/allegion/logging/event/AlEventType;", "getType", "()Lcom/allegion/logging/event/AlEventType;", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlCustomEvent extends IAlEvent {
    @NotNull
    Pair<String, Object>[] getProperties();

    @NotNull
    AlEventType getType();
}

package com.allegion.logging.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/allegion/logging/event/IAlActionEvent;", "Lcom/allegion/logging/event/IAlEvent;", "args", "", "", "getArgs", "()[Ljava/lang/Object;", "type", "Lcom/allegion/logging/event/AlActionType;", "getType", "()Lcom/allegion/logging/event/AlActionType;", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlActionEvent extends IAlEvent {
    @NotNull
    Object[] getArgs();

    @NotNull
    AlActionType getType();
}

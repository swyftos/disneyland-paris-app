package com.allegion.logging.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/allegion/logging/event/AlActionEvent;", "Lcom/allegion/logging/event/IAlActionEvent;", "type", "Lcom/allegion/logging/event/AlActionType;", "category", "", "action", "args", "", "", "(Lcom/allegion/logging/event/AlActionType;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "getAction", "()Ljava/lang/String;", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getCategory", "getType", "()Lcom/allegion/logging/event/AlActionType;", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlActionEvent implements IAlActionEvent {

    @NotNull
    private final String action;

    @NotNull
    private final Object[] args;

    @NotNull
    private final String category;

    @NotNull
    private final AlActionType type;

    public AlActionEvent(@NotNull AlActionType type, @NotNull String category, @NotNull String action, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        this.type = type;
        this.category = category;
        this.action = action;
        this.args = args;
    }

    @Override // com.allegion.logging.event.IAlActionEvent
    @NotNull
    public AlActionType getType() {
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

    @Override // com.allegion.logging.event.IAlActionEvent
    @NotNull
    public Object[] getArgs() {
        return this.args;
    }
}

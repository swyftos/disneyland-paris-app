package com.allegion.logging.entry;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/allegion/logging/entry/AlLogEntry;", "Lcom/allegion/logging/entry/IAlLogEntry;", "level", "Lcom/allegion/logging/entry/AlLoggingLevel;", "category", "", "action", "message", "args", "", "", "(Lcom/allegion/logging/entry/AlLoggingLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "getAction", "()Ljava/lang/String;", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getCategory", "getLevel", "()Lcom/allegion/logging/entry/AlLoggingLevel;", "getMessage", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlLogEntry implements IAlLogEntry {

    @NotNull
    private final String action;

    @NotNull
    private final Object[] args;

    @NotNull
    private final String category;

    @NotNull
    private final AlLoggingLevel level;

    @NotNull
    private final String message;

    public AlLogEntry(@NotNull AlLoggingLevel level, @NotNull String category, @NotNull String action, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(level, "level");
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        this.level = level;
        this.category = category;
        this.action = action;
        this.message = message;
        this.args = args;
    }

    @Override // com.allegion.logging.entry.IAlLogEntry
    @NotNull
    public AlLoggingLevel getLevel() {
        return this.level;
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

    @Override // com.allegion.logging.entry.IAlLogEntry
    @NotNull
    public String getMessage() {
        return this.message;
    }

    @Override // com.allegion.logging.entry.IAlLogEntry
    @NotNull
    public Object[] getArgs() {
        return this.args;
    }
}

package com.allegion.logging.entry;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/allegion/logging/entry/AlExceptionEntry;", "Lcom/allegion/logging/entry/IAlExceptionEntry;", "level", "Lcom/allegion/logging/entry/AlLoggingLevel;", "category", "", "action", "exception", "", "(Lcom/allegion/logging/entry/AlLoggingLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getAction", "()Ljava/lang/String;", "getCategory", "getException", "()Ljava/lang/Throwable;", "getLevel", "()Lcom/allegion/logging/entry/AlLoggingLevel;", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlExceptionEntry implements IAlExceptionEntry {

    @NotNull
    private final String action;

    @NotNull
    private final String category;

    @Nullable
    private final Throwable exception;

    @NotNull
    private final AlLoggingLevel level;

    public AlExceptionEntry(@NotNull AlLoggingLevel level, @NotNull String category, @NotNull String action, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(level, "level");
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        this.level = level;
        this.category = category;
        this.action = action;
        this.exception = th;
    }

    @Override // com.allegion.logging.entry.IAlExceptionEntry
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

    @Override // com.allegion.logging.entry.IAlExceptionEntry
    @Nullable
    public Throwable getException() {
        return this.exception;
    }
}

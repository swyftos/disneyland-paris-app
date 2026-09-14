package com.allegion.logging.entry;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1834bv = {1, 0, 3}, m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1836d2 = {"Lcom/allegion/logging/entry/IAlExceptionEntry;", "Lcom/allegion/logging/entry/IAlEntry;", "exception", "", "getException", "()Ljava/lang/Throwable;", "level", "Lcom/allegion/logging/entry/AlLoggingLevel;", "getLevel", "()Lcom/allegion/logging/entry/AlLoggingLevel;", "AlLogging_release"}, m1837k = 1, m1838mv = {1, 1, 15})
public interface IAlExceptionEntry extends IAlEntry {
    @Nullable
    Throwable getException();

    @NotNull
    AlLoggingLevel getLevel();
}

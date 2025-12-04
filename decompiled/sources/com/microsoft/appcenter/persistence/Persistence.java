package com.microsoft.appcenter.persistence;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import java.io.Closeable;
import java.util.Collection;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class Persistence implements Closeable {
    private LogSerializer mLogSerializer;

    public abstract void clearPendingLogState();

    public abstract int countLogs(@NonNull String str);

    public abstract void deleteLogs(String str);

    public abstract void deleteLogs(@NonNull String str, @NonNull String str2);

    @Nullable
    public abstract String getLogs(@NonNull String str, @NonNull Collection<String> collection, @IntRange(from = 0) int i, @NonNull List<Log> list);

    public abstract long putLog(@NonNull Log log, @NonNull String str, @IntRange(from = 1, to = 2) int i) throws PersistenceException;

    public abstract boolean setMaxStorageSize(long j);

    LogSerializer getLogSerializer() {
        LogSerializer logSerializer = this.mLogSerializer;
        if (logSerializer != null) {
            return logSerializer;
        }
        throw new IllegalStateException("logSerializer not configured");
    }

    public void setLogSerializer(@NonNull LogSerializer logSerializer) {
        this.mLogSerializer = logSerializer;
    }

    public static class PersistenceException extends Exception {
        public PersistenceException(String str, Throwable th) {
            super(str, th);
        }

        PersistenceException(String str) {
            super(str);
        }
    }
}

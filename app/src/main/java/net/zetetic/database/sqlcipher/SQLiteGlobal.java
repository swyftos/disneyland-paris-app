package net.zetetic.database.sqlcipher;

import android.os.StatFs;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteGlobal {
    private static int sDefaultPageSize = 4096;
    private static final Object sLock = new Object();
    private static int sWALConnectionPoolSize = 10;

    public static int getJournalSizeLimit() {
        return 10000;
    }

    private static native int nativeReleaseMemory();

    public static int releaseMemory() {
        return nativeReleaseMemory();
    }

    public static int getDefaultPageSize() {
        synchronized (sLock) {
            try {
                if (sDefaultPageSize == 0) {
                    sDefaultPageSize = new StatFs("/data").getBlockSize();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 4096;
    }

    public static String getDefaultJournalMode() {
        return "delete";
    }

    public static String getDefaultSyncMode() {
        return "normal";
    }

    public static String getWALSyncMode() {
        return "normal";
    }

    public static int getWALAutoCheckpoint() {
        return Math.max(1, 1000);
    }

    public static void setWALConnectionPoolSize(int i) {
        sWALConnectionPoolSize = i;
    }

    public static int getWALConnectionPoolSize() {
        return sWALConnectionPoolSize;
    }
}

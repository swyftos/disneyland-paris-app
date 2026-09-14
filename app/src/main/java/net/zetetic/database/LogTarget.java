package net.zetetic.database;

/* JADX INFO: loaded from: classes6.dex */
public interface LogTarget {
    boolean isLoggable(String str, int i);

    void log(int i, String str, String str2, Throwable th);
}

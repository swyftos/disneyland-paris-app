package net.zetetic.database;

/* JADX INFO: loaded from: classes6.dex */
public class NoopTarget implements LogTarget {
    @Override // net.zetetic.database.LogTarget
    public boolean isLoggable(String str, int i) {
        return false;
    }

    @Override // net.zetetic.database.LogTarget
    public void log(int i, String str, String str2, Throwable th) {
    }
}

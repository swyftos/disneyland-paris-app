package net.zetetic.database;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class LogcatTarget implements LogTarget {
    @Override // net.zetetic.database.LogTarget
    public boolean isLoggable(String str, int i) {
        return Log.isLoggable(str, i);
    }

    @Override // net.zetetic.database.LogTarget
    public void log(int i, String str, String str2, Throwable th) {
        switch (i) {
            case 2:
                Log.v(str, str2, th);
                break;
            case 3:
                Log.d(str, str2, th);
                break;
            case 4:
                Log.i(str, str2, th);
                break;
            case 5:
                Log.w(str, str2, th);
                break;
            case 6:
                Log.e(str, str2, th);
                break;
            case 7:
                Log.wtf(str, str2, th);
                break;
        }
    }
}

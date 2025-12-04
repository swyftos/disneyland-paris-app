package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes4.dex */
class HeartBeatInfoStorage {
    private static HeartBeatInfoStorage instance;
    private final SharedPreferences sharedPreferences;

    private HeartBeatInfoStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    static synchronized HeartBeatInfoStorage getInstance(Context context) {
        try {
            if (instance == null) {
                instance = new HeartBeatInfoStorage(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    synchronized boolean shouldSendSdkHeartBeat(String str, long j) {
        if (!this.sharedPreferences.contains(str)) {
            this.sharedPreferences.edit().putLong(str, j).apply();
            return true;
        }
        if (j - this.sharedPreferences.getLong(str, -1L) < 86400000) {
            return false;
        }
        this.sharedPreferences.edit().putLong(str, j).apply();
        return true;
    }

    synchronized boolean shouldSendGlobalHeartBeat(long j) {
        return shouldSendSdkHeartBeat("fire-global", j);
    }
}

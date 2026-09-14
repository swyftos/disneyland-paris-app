package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.Module;

/* JADX INFO: loaded from: classes3.dex */
@Module
public abstract class TimeModule {
    static Clock eventClock() {
        return new WallTimeClock();
    }

    static Clock uptimeClock() {
        return new UptimeClock();
    }
}

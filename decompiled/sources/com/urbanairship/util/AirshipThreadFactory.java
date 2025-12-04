package com.urbanairship.util;

import android.net.TrafficStats;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import gherkin.GherkinLanguageConstants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class AirshipThreadFactory implements ThreadFactory {
    public static final int THREAD_STATS_TAG = 11797;
    private final String threadNamePrefix;
    public static final AirshipThreadFactory DEFAULT_THREAD_FACTORY = new AirshipThreadFactory("UrbanAirship");
    private static final AtomicInteger count = new AtomicInteger(1);

    public AirshipThreadFactory(@NonNull String str) {
        this.threadNamePrefix = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @NonNull
    public Thread newThread(@Nullable final Runnable runnable) {
        Thread thread = new Thread(new Runnable() { // from class: com.urbanairship.util.AirshipThreadFactory.1
            @Override // java.lang.Runnable
            public void run() {
                TrafficStats.setThreadStatsTag(AirshipThreadFactory.THREAD_STATS_TAG);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }, this.threadNamePrefix + GherkinLanguageConstants.COMMENT_PREFIX + count.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}

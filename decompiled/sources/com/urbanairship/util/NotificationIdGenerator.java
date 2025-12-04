package com.urbanairship.util;

import android.content.SharedPreferences;
import androidx.annotation.IntRange;
import com.contentsquare.android.error.analysis.apierror.v2.EventProcessorPerformanceManager;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;

/* loaded from: classes5.dex */
public class NotificationIdGenerator {
    private static int range = 40;
    private static int start = 1000;

    private static SharedPreferences getPreferences() {
        return UAirship.getApplicationContext().getSharedPreferences("com.urbanairship.notificationidgenerator", 0);
    }

    private static void putInt(String str, int i) {
        SharedPreferences.Editor editorEdit = getPreferences().edit();
        editorEdit.putInt(str, i);
        editorEdit.apply();
    }

    private static int getInt(String str, int i) {
        return getPreferences().getInt(str, i);
    }

    public static void setStart(int i) {
        putInt("count", i);
        start = i;
    }

    public static void setRange(@IntRange(from = 0, to = EventProcessorPerformanceManager.PROCESSING_TIME_THRESHOLD_MS) int i) {
        if (i > 50) {
            UALog.e("The maximum number of notifications allowed is %s. Limiting alert id range to conform.", 50);
            i = 50;
        }
        putInt("count", start);
        range = i;
    }

    public static int getStart() {
        return start;
    }

    public static int getRange() {
        return range;
    }

    public static int nextID() {
        int i = getInt("count", start) + 1;
        if (i < start + range) {
            UALog.v("Incrementing notification ID count", new Object[0]);
            putInt("count", i);
        } else {
            UALog.v("Resetting notification ID count", new Object[0]);
            putInt("count", start);
        }
        UALog.v("Notification ID: %s", Integer.valueOf(i));
        return i;
    }
}

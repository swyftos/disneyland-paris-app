package com.michaelflisar.lumberjack;

import ch.qos.logback.core.joran.action.ActionConst;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class T {
    private static HashMap mTimers = new HashMap();
    private static final TimerData mEmptyData = new TimerData();

    public static void start(Object obj) {
        clear(obj);
        mTimers.put(obj, new TimerData().start());
    }

    public static Long lap(Object obj) {
        return getTimer(obj).lap();
    }

    public static Long stop(Object obj) {
        return getTimer(obj).stop();
    }

    public static void clear(Object obj) {
        mTimers.remove(obj);
    }

    public static boolean exists(Object obj) {
        return mTimers.containsKey(obj);
    }

    public static String printAndLap(Object obj) {
        Long lLap = lap(obj);
        if (lLap == null) {
            return ActionConst.NULL;
        }
        return "Lap = " + lLap + "ms";
    }

    public static String printAndStop(Object obj) {
        Long lStop = stop(obj);
        if (lStop == null) {
            return ActionConst.NULL;
        }
        return "Total = " + lStop + "ms";
    }

    public static String printAndLapTotal(Object obj) {
        Long lLap = lap(obj);
        if (lLap == null) {
            return ActionConst.NULL;
        }
        return "Total = " + getTimer(obj).getLastLapTotal().longValue() + "ms | Lap = " + lLap + "ms";
    }

    public static Long getStart(Object obj) {
        return ((TimerData) mTimers.get(obj)).getStart();
    }

    public static List<Long> getLaps(Object obj) {
        return ((TimerData) mTimers.get(obj)).getLaps();
    }

    public static Long getEnd(Object obj) {
        return ((TimerData) mTimers.get(obj)).getEnd();
    }

    private static final TimerData getTimer(Object obj) {
        TimerData timerData = (TimerData) mTimers.get(obj);
        return timerData == null ? mEmptyData : timerData;
    }
}

package ch.qos.logback.core.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.status.StatusListener;

/* loaded from: classes2.dex */
public class StatusListenerConfigHelper {
    public static void addOnConsoleListenerInstance(Context context, OnConsoleStatusListener onConsoleStatusListener) {
        onConsoleStatusListener.setContext(context);
        if (context.getStatusManager().add(onConsoleStatusListener)) {
            onConsoleStatusListener.start();
        }
    }

    private static void addStatusListener(Context context, String str) {
        initAndAddListener(context, createListenerPerClassName(context, str));
    }

    private static StatusListener createListenerPerClassName(Context context, String str) {
        try {
            return (StatusListener) OptionHelper.instantiateByClassName(str, (Class<?>) StatusListener.class, context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void initAndAddListener(Context context, StatusListener statusListener) {
        if (statusListener != null) {
            if (statusListener instanceof ContextAware) {
                ((ContextAware) statusListener).setContext(context);
            }
            if (context.getStatusManager().add(statusListener) && (statusListener instanceof LifeCycle)) {
                ((LifeCycle) statusListener).start();
            }
        }
    }

    public static void installIfAsked(Context context) {
        String systemProperty = OptionHelper.getSystemProperty(CoreConstants.STATUS_LISTENER_CLASS);
        if (OptionHelper.isEmpty(systemProperty)) {
            return;
        }
        addStatusListener(context, systemProperty);
    }
}

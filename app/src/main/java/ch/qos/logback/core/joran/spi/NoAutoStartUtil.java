package ch.qos.logback.core.joran.spi;

/* JADX INFO: loaded from: classes2.dex */
public class NoAutoStartUtil {
    public static boolean notMarkedWithNoAutoStart(Object obj) {
        return obj != null && ((NoAutoStart) obj.getClass().getAnnotation(NoAutoStart.class)) == null;
    }
}

package coil3.content;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0086\b\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0086\b¨\u0006\u000b"}, m1836d2 = {"log", "", "Lcoil3/util/Logger;", "tag", "", "throwable", "", "message", "Lkotlin/Function0;", "level", "Lcoil3/util/Logger$Level;", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class LoggingKt {
    public static final void log(@NotNull Logger logger, @NotNull String str, @NotNull Throwable th) {
        Logger.Level minLevel = logger.getMinLevel();
        Logger.Level level = Logger.Level.Error;
        if (minLevel.compareTo(level) <= 0) {
            logger.log(str, level, null, th);
        }
    }

    public static final void log(@NotNull Logger logger, @NotNull String str, @NotNull Throwable th, @NotNull Function0<String> function0) {
        Logger.Level minLevel = logger.getMinLevel();
        Logger.Level level = Logger.Level.Error;
        if (minLevel.compareTo(level) <= 0) {
            logger.log(str, level, function0.invoke(), th);
        }
    }

    public static final void log(@NotNull Logger logger, @NotNull String str, @NotNull Logger.Level level, @NotNull Function0<String> function0) {
        if (logger.getMinLevel().compareTo(level) <= 0) {
            logger.log(str, level, function0.invoke(), null);
        }
    }
}

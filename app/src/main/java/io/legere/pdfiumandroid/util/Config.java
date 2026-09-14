package io.legere.pdfiumandroid.util;

import androidx.annotation.Keep;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import io.legere.pdfiumandroid.DefaultLogger;
import io.legere.pdfiumandroid.LoggerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1836d2 = {"Lio/legere/pdfiumandroid/util/Config;", "", "logger", "Lio/legere/pdfiumandroid/LoggerInterface;", "alreadyClosedBehavior", "Lio/legere/pdfiumandroid/util/AlreadyClosedBehavior;", "<init>", "(Lio/legere/pdfiumandroid/LoggerInterface;Lio/legere/pdfiumandroid/util/AlreadyClosedBehavior;)V", "getLogger", "()Lio/legere/pdfiumandroid/LoggerInterface;", "getAlreadyClosedBehavior", "()Lio/legere/pdfiumandroid/util/AlreadyClosedBehavior;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class Config {

    @NotNull
    private final AlreadyClosedBehavior alreadyClosedBehavior;

    @NotNull
    private final LoggerInterface logger;

    public Config() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Config copy$default(Config config, LoggerInterface loggerInterface, AlreadyClosedBehavior alreadyClosedBehavior, int i, Object obj) {
        if ((i & 1) != 0) {
            loggerInterface = config.logger;
        }
        if ((i & 2) != 0) {
            alreadyClosedBehavior = config.alreadyClosedBehavior;
        }
        return config.copy(loggerInterface, alreadyClosedBehavior);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LoggerInterface getLogger() {
        return this.logger;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AlreadyClosedBehavior getAlreadyClosedBehavior() {
        return this.alreadyClosedBehavior;
    }

    @NotNull
    public final Config copy(@NotNull LoggerInterface logger, @NotNull AlreadyClosedBehavior alreadyClosedBehavior) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(alreadyClosedBehavior, "alreadyClosedBehavior");
        return new Config(logger, alreadyClosedBehavior);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Config)) {
            return false;
        }
        Config config = (Config) other;
        return Intrinsics.areEqual(this.logger, config.logger) && this.alreadyClosedBehavior == config.alreadyClosedBehavior;
    }

    public int hashCode() {
        return (this.logger.hashCode() * 31) + this.alreadyClosedBehavior.hashCode();
    }

    @NotNull
    public String toString() {
        return "Config(logger=" + this.logger + ", alreadyClosedBehavior=" + this.alreadyClosedBehavior + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Config(@NotNull LoggerInterface logger, @NotNull AlreadyClosedBehavior alreadyClosedBehavior) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(alreadyClosedBehavior, "alreadyClosedBehavior");
        this.logger = logger;
        this.alreadyClosedBehavior = alreadyClosedBehavior;
    }

    public /* synthetic */ Config(LoggerInterface loggerInterface, AlreadyClosedBehavior alreadyClosedBehavior, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultLogger() : loggerInterface, (i & 2) != 0 ? AlreadyClosedBehavior.EXCEPTION : alreadyClosedBehavior);
    }

    @NotNull
    public final LoggerInterface getLogger() {
        return this.logger;
    }

    @NotNull
    public final AlreadyClosedBehavior getAlreadyClosedBehavior() {
        return this.alreadyClosedBehavior;
    }
}

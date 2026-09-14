package io.legere.pdfiumandroid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1836d2 = {"Lio/legere/pdfiumandroid/Logger;", "Lio/legere/pdfiumandroid/LoggerInterface;", "<init>", "()V", "logger", "d", "", "tag", "", "message", "e", "t", "", "setLogger", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class Logger implements LoggerInterface {

    @NotNull
    public static final Logger INSTANCE = new Logger();

    @Nullable
    private static LoggerInterface logger;

    private Logger() {
    }

    @Override // io.legere.pdfiumandroid.LoggerInterface
    /* JADX INFO: renamed from: d */
    public void mo1818d(@NotNull String tag, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerInterface loggerInterface = logger;
        if (loggerInterface != null) {
            loggerInterface.mo1818d(tag, message);
        }
    }

    @Override // io.legere.pdfiumandroid.LoggerInterface
    /* JADX INFO: renamed from: e */
    public void mo1819e(@NotNull String tag, @Nullable Throwable t, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerInterface loggerInterface = logger;
        if (loggerInterface != null) {
            loggerInterface.mo1819e(tag, t, message);
        }
    }

    public final void setLogger(@NotNull LoggerInterface logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        logger = logger2;
    }
}

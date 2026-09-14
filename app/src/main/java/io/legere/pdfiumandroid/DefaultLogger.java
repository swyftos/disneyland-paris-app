package io.legere.pdfiumandroid;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\f"}, m1836d2 = {"Lio/legere/pdfiumandroid/DefaultLogger;", "Lio/legere/pdfiumandroid/LoggerInterface;", "<init>", "()V", "d", "", "tag", "", "message", "e", "t", "", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Logger.kt\nio/legere/pdfiumandroid/DefaultLogger\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1#2:63\n*E\n"})
public final class DefaultLogger implements LoggerInterface {
    @Override // io.legere.pdfiumandroid.LoggerInterface
    /* JADX INFO: renamed from: d */
    public void mo1818d(@NotNull String tag, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (message != null) {
            Log.d(tag, message);
        }
    }

    @Override // io.legere.pdfiumandroid.LoggerInterface
    /* JADX INFO: renamed from: e */
    public void mo1819e(@NotNull String tag, @Nullable Throwable t, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Log.e(tag, message, t);
    }
}

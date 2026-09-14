package io.legere.pdfiumandroid.util;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\t"}, m1836d2 = {"pdfiumConfig", "Lio/legere/pdfiumandroid/util/Config;", "getPdfiumConfig", "()Lio/legere/pdfiumandroid/util/Config;", "setPdfiumConfig", "(Lio/legere/pdfiumandroid/util/Config;)V", "handleAlreadyClosed", "", "isClosed", "pdfiumandroid_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ConfigKt {

    @NotNull
    private static Config pdfiumConfig = new Config(null, null, 3, null);

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlreadyClosedBehavior.values().length];
            try {
                iArr[AlreadyClosedBehavior.EXCEPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AlreadyClosedBehavior.IGNORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final Config getPdfiumConfig() {
        return pdfiumConfig;
    }

    public static final void setPdfiumConfig(@NotNull Config config) {
        Intrinsics.checkNotNullParameter(config, "<set-?>");
        pdfiumConfig = config;
    }

    public static final boolean handleAlreadyClosed(boolean z) {
        if (z) {
            int i = WhenMappings.$EnumSwitchMapping$0[pdfiumConfig.getAlreadyClosedBehavior().ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Already closed");
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            pdfiumConfig.getLogger().mo1818d("PdfiumCore", "Already closed");
        }
        return z;
    }
}

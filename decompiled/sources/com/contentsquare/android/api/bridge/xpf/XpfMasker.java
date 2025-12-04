package com.contentsquare.android.api.bridge.xpf;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/contentsquare/android/api/bridge/xpf/XpfMasker;", "", "()V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "maskedViewsCount", "", "addMaskedView", "", "isForceMaskEnabled", "", "removeMaskedView", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class XpfMasker {

    @NotNull
    public static final XpfMasker INSTANCE = new XpfMasker();

    @NotNull
    private static final Logger logger = new Logger("XpfMasker");
    private static int maskedViewsCount;

    private XpfMasker() {
    }

    public final synchronized void addMaskedView() {
        maskedViewsCount++;
    }

    public final synchronized boolean isForceMaskEnabled() {
        return maskedViewsCount > 0;
    }

    public final synchronized void removeMaskedView() {
        maskedViewsCount--;
    }
}

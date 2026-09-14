package coil3.content;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1836d2 = {"HardwareBitmapService", "Lcoil3/util/HardwareBitmapService;", "logger", "Lcoil3/util/Logger;", "IS_DEVICE_BLOCKED", "", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class HardwareBitmapsKt {
    private static final boolean IS_DEVICE_BLOCKED = false;

    @NotNull
    public static final HardwareBitmapService HardwareBitmapService(@Nullable Logger logger) {
        return IS_DEVICE_BLOCKED ? new ImmutableHardwareBitmapService(false) : new ImmutableHardwareBitmapService(true);
    }
}

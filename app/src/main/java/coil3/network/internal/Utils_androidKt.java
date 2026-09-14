package coil3.network.internal;

import android.content.Context;
import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, m1836d2 = {"assertNotOnMainThread", "", "isPermissionGranted", "", "Landroid/content/Context;", "permission", "", "coil-network-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class Utils_androidKt {
    public static final void assertNotOnMainThread() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new NetworkOnMainThreadException();
        }
    }

    public static final boolean isPermissionGranted(@NotNull Context context, @NotNull String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }
}

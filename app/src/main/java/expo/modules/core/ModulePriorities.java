package expo.modules.core;

import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1836d2 = {"Lexpo/modules/core/ModulePriorities;", "", "<init>", "()V", "get", "", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "", "SUPPORTED_MODULES", "", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ModulePriorities {

    @NotNull
    public static final ModulePriorities INSTANCE = new ModulePriorities();
    private static final Map SUPPORTED_MODULES = MapsKt.mapOf(TuplesKt.m1842to("host.exp.exponent.experience.splashscreen.legacy.SplashScreenPackage", 11), TuplesKt.m1842to("expo.modules.updates.UpdatesPackage", 10));

    private ModulePriorities() {
    }

    public final int get(@Nullable String packageName) {
        Integer num;
        if (packageName == null || (num = (Integer) SUPPORTED_MODULES.get(packageName)) == null) {
            return 0;
        }
        return num.intValue();
    }
}

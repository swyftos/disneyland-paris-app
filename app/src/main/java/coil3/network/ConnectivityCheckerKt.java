package coil3.network;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.core.content.ContextCompat;
import coil3.network.internal.Utils_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, m1836d2 = {"ConnectivityChecker", "Lcoil3/network/ConnectivityChecker;", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "coil-network-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nConnectivityChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectivityChecker.kt\ncoil3/network/ConnectivityCheckerKt\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,53:1\n31#2:54\n*S KotlinDebug\n*F\n+ 1 ConnectivityChecker.kt\ncoil3/network/ConnectivityCheckerKt\n*L\n15#1:54\n*E\n"})
public final class ConnectivityCheckerKt {
    @NotNull
    public static final ConnectivityChecker ConnectivityChecker(@NotNull Context context) {
        Context applicationContext = context.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(applicationContext, ConnectivityManager.class);
        if (connectivityManager == null || !Utils_androidKt.isPermissionGranted(applicationContext, "android.permission.ACCESS_NETWORK_STATE")) {
            return ConnectivityChecker.ONLINE;
        }
        try {
            return new ConnectivityCheckerApi23(connectivityManager);
        } catch (Exception unused) {
            return ConnectivityChecker.ONLINE;
        }
    }
}

package coil3.network;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: classes2.dex */
final class ConnectivityCheckerApi23 implements ConnectivityChecker {
    private final ConnectivityManager connectivityManager;

    public ConnectivityCheckerApi23(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    @Override // coil3.network.ConnectivityChecker
    public boolean isOnline() {
        NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(this.connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }
}

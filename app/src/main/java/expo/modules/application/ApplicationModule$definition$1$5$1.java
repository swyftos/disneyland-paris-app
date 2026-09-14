package expo.modules.application;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, m1836d2 = {"expo/modules/application/ApplicationModule$definition$1$5$1", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "onInstallReferrerSetupFinished", "", "responseCode", "", "onInstallReferrerServiceDisconnected", "expo-application_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ApplicationModule$definition$1$5$1 implements InstallReferrerStateListener {
    final /* synthetic */ StringBuilder $installReferrer;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ InstallReferrerClient $referrerClient;

    ApplicationModule$definition$1$5$1(InstallReferrerClient installReferrerClient, StringBuilder sb, Promise promise) {
        this.$referrerClient = installReferrerClient;
        this.$installReferrer = sb;
        this.$promise = promise;
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerSetupFinished(int responseCode) {
        if (responseCode == 0) {
            try {
                this.$installReferrer.append(this.$referrerClient.getInstallReferrer().getInstallReferrer());
                Promise promise = this.$promise;
                String string = this.$installReferrer.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                promise.resolve(string);
            } catch (RemoteException e) {
                this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER_REMOTE_EXCEPTION", "RemoteException getting install referrer information. This may happen if the process hosting the remote object is no longer available.", e);
                return;
            }
        } else if (responseCode == 1) {
            this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER", "General error retrieving the install referrer: response code " + responseCode, null);
        } else if (responseCode == 2) {
            this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER_UNAVAILABLE", "The current Play Store app doesn't provide the installation referrer API, or the Play Store may not be installed.", null);
        } else {
            this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER", "General error retrieving the install referrer: response code " + responseCode, null);
        }
        this.$referrerClient.endConnection();
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerServiceDisconnected() {
        this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER_SERVICE_DISCONNECTED", "Connection to install referrer service was lost.", null);
    }
}

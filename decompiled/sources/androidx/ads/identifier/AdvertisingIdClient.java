package androidx.ads.identifier;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.RemoteException;
import androidx.ads.identifier.internal.BlockingServiceConnection;
import androidx.ads.identifier.provider.IAdvertisingIdService;
import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class AdvertisingIdClient {
    static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    private ComponentName mComponentName;
    private BlockingServiceConnection mConnection;
    private final Context mContext;
    private IAdvertisingIdService mService;

    AdvertisingIdClient(Context context) {
        Preconditions.checkNotNull(context);
        this.mContext = context.getApplicationContext();
    }

    private void start() throws IOException {
        if (this.mConnection == null) {
            this.mComponentName = getProviderComponentName(this.mContext);
            BlockingServiceConnection serviceConnection = getServiceConnection();
            this.mConnection = serviceConnection;
            this.mService = getAdvertisingIdService(serviceConnection);
        }
    }

    AdvertisingIdInfo getInfoInternal() throws AdvertisingIdNotAvailableException, IOException {
        if (this.mConnection == null) {
            start();
        }
        try {
            String id = this.mService.getId();
            if (id == null || id.trim().isEmpty()) {
                throw new AdvertisingIdNotAvailableException("Advertising ID Provider does not returns an Advertising ID.");
            }
            return AdvertisingIdInfo.builder().setId(normalizeId(id)).setProviderPackageName(this.mComponentName.getPackageName()).setLimitAdTrackingEnabled(this.mService.isLimitAdTrackingEnabled()).build();
        } catch (RemoteException e) {
            throw new IOException("Remote exception", e);
        } catch (RuntimeException e2) {
            throw new AdvertisingIdNotAvailableException("Advertising ID Provider throws a exception.", e2);
        }
    }

    static String normalizeId(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        return isUuidFormat(lowerCase) ? lowerCase : UUID.nameUUIDFromBytes(str.getBytes(Charset.forName("UTF-8"))).toString();
    }

    private static boolean isUuidFormat(String str) {
        try {
            return str.equals(UUID.fromString(str).toString());
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    void finish() {
        BlockingServiceConnection blockingServiceConnection = this.mConnection;
        if (blockingServiceConnection == null) {
            return;
        }
        this.mContext.unbindService(blockingServiceConnection);
        this.mComponentName = null;
        this.mConnection = null;
        this.mService = null;
    }

    private static ComponentName getProviderComponentName(Context context) throws PackageManager.NameNotFoundException, AdvertisingIdNotAvailableException {
        PackageManager packageManager = context.getPackageManager();
        ServiceInfo serviceInfoSelectServiceByPriority = AdvertisingIdUtils.selectServiceByPriority(AdvertisingIdUtils.getAdvertisingIdProviderServices(packageManager), packageManager);
        if (serviceInfoSelectServiceByPriority == null) {
            throw new AdvertisingIdNotAvailableException("No Advertising ID Provider available.");
        }
        return new ComponentName(serviceInfoSelectServiceByPriority.packageName, serviceInfoSelectServiceByPriority.name);
    }

    BlockingServiceConnection getServiceConnection() throws IOException {
        Intent intent = new Intent(AdvertisingIdUtils.GET_AD_ID_ACTION);
        intent.setComponent(this.mComponentName);
        BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        if (this.mContext.bindService(intent, blockingServiceConnection, 1)) {
            return blockingServiceConnection;
        }
        throw new IOException("Connection failure");
    }

    IAdvertisingIdService getAdvertisingIdService(BlockingServiceConnection blockingServiceConnection) {
        return IAdvertisingIdService.Stub.asInterface(blockingServiceConnection.getServiceWithTimeout(10L, TimeUnit.SECONDS));
    }

    public static boolean isAdvertisingIdProviderAvailable(@NonNull Context context) {
        return !AdvertisingIdUtils.getAdvertisingIdProviderServices(context.getPackageManager()).isEmpty();
    }

    @NonNull
    public static ListenableFuture<AdvertisingIdInfo> getAdvertisingIdInfo(@NonNull final Context context) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.ads.identifier.AdvertisingIdClient$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return AdvertisingIdClient.lambda$getAdvertisingIdInfo$1(context, completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getAdvertisingIdInfo$1(final Context context, final CallbackToFutureAdapter.Completer completer) {
        EXECUTOR_SERVICE.execute(new Runnable() { // from class: androidx.ads.identifier.AdvertisingIdClient$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AdvertisingIdClient.lambda$null$0(context, completer);
            }
        });
        return "getAdvertisingIdInfo";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$0(Context context, CallbackToFutureAdapter.Completer completer) {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context);
        try {
            try {
                completer.set(advertisingIdClient.getInfoInternal());
            } catch (AdvertisingIdNotAvailableException | IOException | InterruptedException | TimeoutException e) {
                completer.setException(e);
            }
        } finally {
            advertisingIdClient.finish();
        }
    }
}

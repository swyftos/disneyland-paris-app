package com.urbanairship.push.fcm;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.messaging.RemoteMessage;
import com.urbanairship.PendingResult;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.PushProviderBridge;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

/* loaded from: classes5.dex */
public class AirshipFirebaseIntegration {
    @NonNull
    public static Future<Void> processMessage(@NonNull Context context, @NonNull RemoteMessage remoteMessage) throws ExecutionException, InterruptedException, TimeoutException {
        final PendingResult pendingResult = new PendingResult();
        PushProviderBridge.processPush(FcmPushProvider.class, new PushMessage(remoteMessage.getData())).execute(context, new Runnable() { // from class: com.urbanairship.push.fcm.AirshipFirebaseIntegration.1
            @Override // java.lang.Runnable
            public void run() {
                pendingResult.setResult(null);
            }
        });
        return pendingResult;
    }

    public static void processMessageSync(@NonNull Context context, @NonNull RemoteMessage remoteMessage) throws ExecutionException, InterruptedException, TimeoutException {
        PushProviderBridge.processPush(FcmPushProvider.class, new PushMessage(remoteMessage.getData())).executeSync(context);
    }

    public static void processNewToken(@NonNull Context context, @Nullable String str) {
        PushProviderBridge.requestRegistrationUpdate(context, FcmPushProvider.class, str);
    }

    public static boolean isAirshipPush(@NonNull RemoteMessage remoteMessage) {
        return new PushMessage(remoteMessage.getData()).isAirshipPush();
    }
}

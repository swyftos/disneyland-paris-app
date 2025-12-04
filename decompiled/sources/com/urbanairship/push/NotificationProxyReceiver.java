package com.urbanairship.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.Autopilot;
import com.urbanairship.PendingResult;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NotificationProxyReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        Autopilot.automaticTakeOff(context);
        if (!UAirship.isTakingOff() && !UAirship.isFlying()) {
            UALog.e("NotificationProxyReceiver - unable to receive intent, takeOff not called.", new Object[0]);
            return;
        }
        if (intent == null || intent.getAction() == null) {
            return;
        }
        UALog.v("Received intent: %s", intent.getAction());
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        final PendingResult pendingResultProcess = new NotificationIntentProcessor(context, intent).process();
        AirshipExecutors.threadPoolExecutor().execute(new Runnable() { // from class: com.urbanairship.push.NotificationProxyReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UALog.v("Finished processing notification intent with result %s.", (Boolean) pendingResultProcess.get(9L, TimeUnit.SECONDS));
                } catch (InterruptedException | ExecutionException e) {
                    UALog.e(e, "NotificationProxyReceiver - Exception when processing notification intent.", new Object[0]);
                    Thread.currentThread().interrupt();
                } catch (TimeoutException unused) {
                    UALog.e("NotificationProxyReceiver - Application took too long to process notification intent.", new Object[0]);
                }
                pendingResultGoAsync.finish();
            }
        });
    }
}

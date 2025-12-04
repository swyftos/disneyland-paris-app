package com.urbanairship.push;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.urbanairship.Autopilot;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.push.IncomingPushRunnable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes5.dex */
public abstract class PushProviderBridge {
    public static void requestRegistrationUpdate(@NonNull Context context, @NonNull final Class<? extends PushProvider> cls, @Nullable final String str) {
        Autopilot.automaticTakeOff(context);
        if (UAirship.isFlying() || UAirship.isTakingOff()) {
            UAirship.shared(new UAirship.OnReadyCallback() { // from class: com.urbanairship.push.PushProviderBridge.1
                @Override // com.urbanairship.UAirship.OnReadyCallback
                public void onAirshipReady(UAirship uAirship) {
                    uAirship.getPushManager().onTokenChanged(cls, str);
                }
            });
        }
    }

    @NonNull
    @WorkerThread
    public static ProcessPushRequest processPush(@NonNull Class<? extends PushProvider> cls, @NonNull PushMessage pushMessage) {
        return new ProcessPushRequest(cls, pushMessage);
    }

    public static class ProcessPushRequest {
        private long maxCallbackWaitTime;
        private final Class provider;
        private final PushMessage pushMessage;

        private ProcessPushRequest(Class cls, PushMessage pushMessage) {
            this.provider = cls;
            this.pushMessage = pushMessage;
        }

        @NonNull
        public ProcessPushRequest setMaxCallbackWaitTime(long j) {
            this.maxCallbackWaitTime = j;
            return this;
        }

        public void execute(@NonNull Context context) throws ExecutionException, InterruptedException, TimeoutException {
            execute(context, null);
        }

        public void execute(@NonNull Context context, @Nullable Runnable runnable) throws ExecutionException, InterruptedException, TimeoutException {
            Future<?> futureSubmit = PushManager.PUSH_EXECUTOR.submit(new IncomingPushRunnable.Builder(context).setMessage(this.pushMessage).setProviderClass(this.provider.toString()).build());
            try {
                long j = this.maxCallbackWaitTime;
                if (j > 0) {
                    futureSubmit.get(j, TimeUnit.MILLISECONDS);
                } else {
                    futureSubmit.get();
                }
            } catch (TimeoutException unused) {
                UALog.e("Application took too long to process push. App may get closed.", new Object[0]);
            } catch (Exception e) {
                UALog.e(e, "Failed to wait for notification", new Object[0]);
            }
            if (runnable != null) {
                runnable.run();
            }
        }

        @WorkerThread
        public void executeSync(@NonNull Context context) throws ExecutionException, InterruptedException, TimeoutException {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            execute(context, new Runnable() { // from class: com.urbanairship.push.PushProviderBridge.ProcessPushRequest.1
                @Override // java.lang.Runnable
                public void run() {
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                UALog.e(e, "Failed to wait for push.", new Object[0]);
                Thread.currentThread().interrupt();
            }
        }
    }
}

package com.urbanairship.push.notifications;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.UALog;
import com.urbanairship.util.ImageUtils;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NotificationUtils {
    @Nullable
    public static Bitmap fetchBigImage(@NonNull final Context context, @NonNull final URL url) {
        UALog.d("Fetching notification image at URL: %s", url);
        final int iMax = (int) (Math.max(r0.widthPixels, r0.heightPixels) * 0.75d);
        final int iApplyDimension = (int) TypedValue.applyDimension(1, 240.0f, context.getResources().getDisplayMetrics());
        Future futureSubmit = AirshipExecutors.threadPoolExecutor().submit(new Callable() { // from class: com.urbanairship.push.notifications.NotificationUtils.1
            @Override // java.util.concurrent.Callable
            public Bitmap call() {
                return ImageUtils.fetchScaledBitmap(context, url, iMax, iApplyDimension);
            }
        });
        try {
            return (Bitmap) futureSubmit.get(7L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            UALog.e("Failed to create big picture style, unable to fetch image: %s", e);
            return null;
        } catch (TimeoutException unused) {
            futureSubmit.cancel(true);
            UALog.e("Big picture took longer than %s seconds to fetch.", 7L);
            return null;
        }
    }
}

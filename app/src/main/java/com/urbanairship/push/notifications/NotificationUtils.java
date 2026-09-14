package com.urbanairship.push.notifications;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
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

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NotificationUtils {
    @Nullable
    public static Bitmap fetchBigImage(@NonNull final Context context, @NonNull final URL url) {
        UALog.m1741d("Fetching notification image at URL: %s", url);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final int iMax = (int) (((double) Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)) * 0.75d);
        final int iApplyDimension = (int) TypedValue.applyDimension(1, 240.0f, displayMetrics);
        Future futureSubmit = AirshipExecutors.threadPoolExecutor().submit(new Callable() { // from class: com.urbanairship.push.notifications.NotificationUtils.1
            @Override // java.util.concurrent.Callable
            public Bitmap call() {
                return ImageUtils.fetchScaledBitmap(context, url, iMax, iApplyDimension);
            }
        });
        try {
            return (Bitmap) futureSubmit.get(7L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            UALog.m1744e("Failed to create big picture style, unable to fetch image: %s", e);
            return null;
        } catch (TimeoutException unused) {
            futureSubmit.cancel(true);
            UALog.m1744e("Big picture took longer than %s seconds to fetch.", 7L);
            return null;
        }
    }
}

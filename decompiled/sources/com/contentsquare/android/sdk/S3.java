package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.Window;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class S3 {
    @RequiresApi(api = 26)
    public static void a(@NotNull SurfaceView source, @NotNull Bitmap dest, @NotNull PixelCopy.OnPixelCopyFinishedListener listener, @Nullable Handler handler) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (handler == null) {
            throw new IllegalArgumentException("surface is not drawn yet");
        }
        PixelCopy.request(source, dest, listener, handler);
    }

    @RequiresApi(api = 26)
    public static void a(@NotNull Window source, @NotNull Bitmap dest, @NotNull PixelCopy.OnPixelCopyFinishedListener listener, @Nullable Handler handler) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (handler == null) {
            throw new IllegalArgumentException("window is not drawn yet");
        }
        PixelCopy.request(source, (Rect) null, dest, listener, handler);
    }
}

package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.os.Build;
import com.contentsquare.android.core.features.logging.Logger;
import java.io.ByteArrayOutputStream;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class Z {

    @NotNull
    public final Logger a = new Logger("BitmapCompressorReusable");

    public static void a(Bitmap bitmap, int i, ByteArrayOutputStream byteArrayOutputStream) {
        bitmap.compress(Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP, i, byteArrayOutputStream);
    }
}

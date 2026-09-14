package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.os.Build;
import com.contentsquare.android.core.features.logging.Logger;
import java.io.ByteArrayOutputStream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Z */
/* JADX INFO: loaded from: classes2.dex */
public final class C2681Z {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Logger f2312a = new Logger("BitmapCompressorReusable");

    /* JADX INFO: renamed from: a */
    public static void m1075a(Bitmap bitmap, int i, ByteArrayOutputStream byteArrayOutputStream) {
        bitmap.compress(Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP, i, byteArrayOutputStream);
    }
}

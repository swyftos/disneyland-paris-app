package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nBitmapHash.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BitmapHash.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/viewappearance/BitmapHash\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,106:1\n117#2:107\n125#2:108\n133#2:109\n141#2:110\n*S KotlinDebug\n*F\n+ 1 BitmapHash.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/viewappearance/BitmapHash\n*L\n101#1:107\n102#1:108\n103#1:109\n104#1:110\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.a0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0621a0 {

    @NotNull
    public final M3 a;
    public final int b;
    public final int c;
    public final boolean d;

    @NotNull
    public final String e;

    @NotNull
    public final String f;

    @NotNull
    public final String g;

    public C0621a0(@NotNull M3 perceptualHash, @NotNull ViewLight viewLight, @NotNull Bitmap viewBitmap) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(perceptualHash, "perceptualHash");
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        Intrinsics.checkNotNullParameter(viewBitmap, "viewBitmap");
        this.a = perceptualHash;
        boolean isMasked = viewLight.getIsMasked();
        this.d = isMasked;
        int width = viewBitmap.getWidth();
        this.b = width;
        int height = viewBitmap.getHeight();
        this.c = height;
        String hexString = Integer.toHexString((((((perceptualHash.hashCode() * 31) + width) * 31) + height) * 31) + (isMasked ? 1 : 0));
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        byte b = viewLight.getVisibilityPercentage() == 1.0f ? (byte) 1 : (byte) 2;
        if (b == 1) {
            str = "wpm";
        } else {
            if (b != 2) {
                throw null;
            }
            str = "wpl";
        }
        this.e = str;
        CharSequence text = viewLight.getText();
        String string = text != null ? text.toString() : null;
        string = string == null ? "" : string;
        this.f = string;
        if (string.length() == 0) {
            str2 = hexString + '.' + str;
        } else {
            str2 = hexString + '.' + str + '.' + Integer.toHexString(string.hashCode());
        }
        this.g = str2;
    }
}

package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.f2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0673f2 {
    public boolean a;
    public int b;

    @Nullable
    public Y6 c;
    public int d;
    public double e;
    public double f;
    public double g;
    public double h;
    public int i;
    public int j;

    @Nullable
    public x8<View> k;

    /* renamed from: com.contentsquare.android.sdk.f2$a */
    public static final class a {
        public static boolean a(@NotNull String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            return StringsKt.contains$default((CharSequence) path, (CharSequence) ">WebView", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) path, (CharSequence) ">RNCWebView", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) path, (CharSequence) ">CapacitorWebView", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) path, (CharSequence) ">SystemWebView", false, 2, (Object) null) || (StringsKt.contains$default((CharSequence) path, (CharSequence) ">FlutterView", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) path, (CharSequence) ">PlatformViewWrapper", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) path, (CharSequence) "WebView", false, 2, (Object) null));
        }
    }

    @NotNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("GestureResult{unresponsive=");
        sb.append(this.a);
        sb.append(", gesture=");
        sb.append(this.b);
        sb.append(", pathDescriptor=");
        Y6 y6 = this.c;
        sb.append(y6 != null ? y6.a() : null);
        sb.append(", fingerDirection=");
        sb.append(this.d);
        sb.append(", gestureDistance=");
        sb.append(this.e);
        sb.append(", gestureVelocity=");
        sb.append(this.f);
        sb.append('}');
        return sb.toString();
    }
}

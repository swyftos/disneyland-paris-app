package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.f2 */
/* JADX INFO: loaded from: classes2.dex */
public class C2743f2 {

    /* JADX INFO: renamed from: a */
    public boolean f2600a;

    /* JADX INFO: renamed from: b */
    public int f2601b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public InterfaceC2679Y6 f2602c;

    /* JADX INFO: renamed from: d */
    public int f2603d;

    /* JADX INFO: renamed from: e */
    public double f2604e;

    /* JADX INFO: renamed from: f */
    public double f2605f;

    /* JADX INFO: renamed from: g */
    public double f2606g;

    /* JADX INFO: renamed from: h */
    public double f2607h;

    /* JADX INFO: renamed from: i */
    public int f2608i;

    /* JADX INFO: renamed from: j */
    public int f2609j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public C2929x8<View> f2610k;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.f2$a */
    public static final class a {
        /* JADX INFO: renamed from: a */
        public static boolean m1126a(@NotNull String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            return StringsKt.contains$default((CharSequence) path, (CharSequence) ">WebView", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) path, (CharSequence) ">RNCWebView", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) path, (CharSequence) ">CapacitorWebView", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) path, (CharSequence) ">SystemWebView", false, 2, (Object) null) || (StringsKt.contains$default((CharSequence) path, (CharSequence) ">FlutterView", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) path, (CharSequence) ">PlatformViewWrapper", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) path, (CharSequence) "WebView", false, 2, (Object) null));
        }
    }

    @NotNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("GestureResult{unresponsive=");
        sb.append(this.f2600a);
        sb.append(", gesture=");
        sb.append(this.f2601b);
        sb.append(", pathDescriptor=");
        InterfaceC2679Y6 interfaceC2679Y6 = this.f2602c;
        sb.append(interfaceC2679Y6 != null ? interfaceC2679Y6.mo1022a() : null);
        sb.append(", fingerDirection=");
        sb.append(this.f2603d);
        sb.append(", gestureDistance=");
        sb.append(this.f2604e);
        sb.append(", gestureVelocity=");
        sb.append(this.f2605f);
        sb.append('}');
        return sb.toString();
    }
}

package com.contentsquare.android.sdk;

import android.R;
import android.app.Activity;
import android.view.Window;
import android.widget.FrameLayout;
import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.a */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nAScreenChangedCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AScreenChangedCallback.kt\ncom/contentsquare/android/analytics/internal/features/screenview/AScreenChangedCallback\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,136:1\n26#2:137\n*S KotlinDebug\n*F\n+ 1 AScreenChangedCallback.kt\ncom/contentsquare/android/analytics/internal/features/screenview/AScreenChangedCallback\n*L\n22#1:137\n*E\n"})
public abstract class AbstractC2690a {

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final CustomVar[] f2345e = new CustomVar[0];

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2550L3 f2346a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f2347b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final InterfaceC2903v2 f2348c;

    /* JADX INFO: renamed from: d */
    public boolean f2349d;

    public AbstractC2690a(@NotNull C2550L3 pathGenerator, @NotNull Logger logger, @NotNull InterfaceC2903v2 glassPane) {
        Intrinsics.checkNotNullParameter(pathGenerator, "pathGenerator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        this.f2346a = pathGenerator;
        this.f2347b = logger;
        this.f2348c = glassPane;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo1078a(int i, @Nullable String str, @Nullable String str2, @NotNull CustomVar[] customVarArr, boolean z, @Nullable Long l, @Nullable String str3);

    /* JADX INFO: renamed from: a */
    public final void m1080a(Activity activity, Function1 function1, C2608R2 c2608r2, String str, CustomVar[] customVarArr, boolean z, Long l) {
        Window window = activity.getWindow();
        if (window == null) {
            this.f2347b.m834w("[handleScreenChanged]: Was called for activity: [" + activity.getClass().getSimpleName() + "], but the activity did not have a Window");
        } else {
            String str2 = (String) function1.invoke((FrameLayout) window.findViewById(R.id.content));
            if (str2 != null) {
                C2793k2 c2793k2 = (C2793k2) this.f2348c;
                String str3 = c2793k2.f2809d;
                c2793k2.f2809d = str2;
                c2793k2.f2810e = str;
                Intrinsics.checkNotNullParameter(customVarArr, "<set-?>");
                c2793k2.f2811f = customVarArr;
                mo1078a((int) Math.max(Math.min(1L, 2147483647L), -2147483648L), str, str2, customVarArr, z, l, str3);
                this.f2347b.m827d((String) c2608r2.get());
            }
        }
        this.f2349d = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m1079a(@NotNull Activity activity, @NotNull String webViewUrl) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webViewUrl, "webViewUrl");
        m1080a(activity, (Function1) new C2576O(this.f2349d, ((C2793k2) this.f2348c).f2809d, new C2740f(activity, webViewUrl, this.f2346a)), new C2608R2(activity, null, 6), webViewUrl, f2345e, false, (Long) null);
    }
}

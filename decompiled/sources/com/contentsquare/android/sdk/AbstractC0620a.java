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

@SourceDebugExtension({"SMAP\nAScreenChangedCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AScreenChangedCallback.kt\ncom/contentsquare/android/analytics/internal/features/screenview/AScreenChangedCallback\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,136:1\n26#2:137\n*S KotlinDebug\n*F\n+ 1 AScreenChangedCallback.kt\ncom/contentsquare/android/analytics/internal/features/screenview/AScreenChangedCallback\n*L\n22#1:137\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0620a {

    @NotNull
    public static final CustomVar[] e = new CustomVar[0];

    @NotNull
    public final L3 a;

    @NotNull
    public final Logger b;

    @NotNull
    public final InterfaceC0832v2 c;
    public boolean d;

    public AbstractC0620a(@NotNull L3 pathGenerator, @NotNull Logger logger, @NotNull InterfaceC0832v2 glassPane) {
        Intrinsics.checkNotNullParameter(pathGenerator, "pathGenerator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        this.a = pathGenerator;
        this.b = logger;
        this.c = glassPane;
    }

    public abstract void a(int i, @Nullable String str, @Nullable String str2, @NotNull CustomVar[] customVarArr, boolean z, @Nullable Long l, @Nullable String str3);

    public final void a(Activity activity, Function1 function1, R2 r2, String str, CustomVar[] customVarArr, boolean z, Long l) {
        Window window = activity.getWindow();
        if (window == null) {
            this.b.w("[handleScreenChanged]: Was called for activity: [" + activity.getClass().getSimpleName() + "], but the activity did not have a Window");
        } else {
            String str2 = (String) function1.invoke((FrameLayout) window.findViewById(R.id.content));
            if (str2 != null) {
                C0723k2 c0723k2 = (C0723k2) this.c;
                String str3 = c0723k2.d;
                c0723k2.d = str2;
                c0723k2.e = str;
                Intrinsics.checkNotNullParameter(customVarArr, "<set-?>");
                c0723k2.f = customVarArr;
                a((int) Math.max(Math.min(1L, 2147483647L), -2147483648L), str, str2, customVarArr, z, l, str3);
                this.b.d((String) r2.get());
            }
        }
        this.d = false;
    }

    public final void a(@NotNull Activity activity, @NotNull String webViewUrl) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webViewUrl, "webViewUrl");
        a(activity, (Function1) new O(this.d, ((C0723k2) this.c).d, new C0670f(activity, webViewUrl, this.a)), new R2(activity, null, 6), webViewUrl, e, false, (Long) null);
    }
}

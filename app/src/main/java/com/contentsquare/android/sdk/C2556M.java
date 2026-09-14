package com.contentsquare.android.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.M */
/* JADX INFO: loaded from: classes2.dex */
public final class C2556M {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Lazy f1840a = LazyKt.lazy(a.f1841a);

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.M$a */
    public static final class a extends Lambda implements Function0<Logger> {

        /* JADX INFO: renamed from: a */
        public static final a f1841a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Logger invoke() {
            return new Logger("AutoStartHelper");
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m980a(@NotNull Context context) {
        Boolean boolValueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ApplicationInfo applicationInfo = Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L)) : context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "if (Build.VERSION.SDK_IN…_META_DATA)\n            }");
            Bundle bundle = applicationInfo.metaData;
            boolean zContainsKey = bundle != null ? bundle.containsKey("com.contentsquare.android.autostart") : false;
            Lazy lazy = f1840a;
            ((Logger) lazy.getValue()).m831i("Is Contentsquare meta-data present in the manifest: " + zContainsKey);
            if (zContainsKey) {
                Bundle bundle2 = applicationInfo.metaData;
                boolValueOf = bundle2 != null ? Boolean.valueOf(bundle2.getBoolean("com.contentsquare.android.autostart")) : null;
                ((Logger) lazy.getValue()).m831i("Contentsquare meta-data value in the manifest is: " + boolValueOf);
            } else {
                boolValueOf = Boolean.TRUE;
            }
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
            return true;
        } catch (Exception e) {
            ((Logger) f1840a.getValue()).m831i("Failed to get meta-data in the manifest: " + e);
            return true;
        }
    }
}

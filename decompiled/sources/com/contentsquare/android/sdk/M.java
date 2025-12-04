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

/* loaded from: classes2.dex */
public final class M {

    @NotNull
    public static final Lazy a = LazyKt.lazy(a.a);

    public static final class a extends Lambda implements Function0<Logger> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Logger invoke() {
            return new Logger("AutoStartHelper");
        }
    }

    public static boolean a(@NotNull Context context) {
        Boolean boolValueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ApplicationInfo applicationInfo = Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L)) : context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "if (Build.VERSION.SDK_IN…_META_DATA)\n            }");
            Bundle bundle = applicationInfo.metaData;
            boolean zContainsKey = bundle != null ? bundle.containsKey("com.contentsquare.android.autostart") : false;
            Lazy lazy = a;
            ((Logger) lazy.getValue()).i("Is Contentsquare meta-data present in the manifest: " + zContainsKey);
            if (zContainsKey) {
                Bundle bundle2 = applicationInfo.metaData;
                boolValueOf = bundle2 != null ? Boolean.valueOf(bundle2.getBoolean("com.contentsquare.android.autostart")) : null;
                ((Logger) lazy.getValue()).i("Contentsquare meta-data value in the manifest is: " + boolValueOf);
            } else {
                boolValueOf = Boolean.TRUE;
            }
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
            return true;
        } catch (Exception e) {
            ((Logger) a.getValue()).i("Failed to get meta-data in the manifest: " + e);
            return true;
        }
    }
}

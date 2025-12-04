package com.urbanairship.android.framework.proxy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class ExtenderProvider {
    private static final Companion Companion = new Companion(null);
    private boolean created;
    private AirshipPluginExtender extender;

    public final AirshipPluginExtender get(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.created) {
            this.extender = createExtender(context);
        }
        return this.extender;
    }

    public final void reset() {
        this.created = false;
        this.extender = null;
    }

    private final AirshipPluginExtender createExtender(Context context) throws IllegalAccessException, PackageManager.NameNotFoundException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        String string;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null || (string = bundle.getString("com.urbanairship.plugin.extender")) == null) {
                return null;
            }
            try {
                Object objNewInstance = Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.urbanairship.android.framework.proxy.AirshipPluginExtender");
                return (AirshipPluginExtender) objNewInstance;
            } catch (Exception e) {
                ProxyLogger.error(e, "Unable to create extender: " + string, new Object[0]);
                return null;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

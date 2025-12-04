package com.urbanairship.android.framework.proxy;

import android.content.Context;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UAirship;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/framework/proxy/AirshipPluginExtender;", "", "extendConfig", "Lcom/urbanairship/AirshipConfigOptions$Builder;", "context", "Landroid/content/Context;", "configBuilder", "onAirshipReady", "", "airship", "Lcom/urbanairship/UAirship;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AirshipPluginExtender {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static AirshipConfigOptions.Builder extendConfig(@NotNull AirshipPluginExtender airshipPluginExtender, @NotNull Context context, @NotNull AirshipConfigOptions.Builder configBuilder) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(configBuilder, "configBuilder");
            return configBuilder;
        }
    }

    @NotNull
    AirshipConfigOptions.Builder extendConfig(@NotNull Context context, @NotNull AirshipConfigOptions.Builder configBuilder);

    void onAirshipReady(@NotNull Context context, @NotNull UAirship airship);
}

package com.urbanairship.reactnative;

import android.content.Context;
import com.urbanairship.UAirship;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "Use com.urbanairship.android.framework.proxy.AirshipPluginExtender instead and register it under the manifest key `com.urbanairship.plugin.extender`")
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1836d2 = {"Lcom/urbanairship/reactnative/AirshipExtender;", "", "onAirshipReady", "", "context", "Landroid/content/Context;", "airship", "Lcom/urbanairship/UAirship;", "ua_react-native-airship_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface AirshipExtender {
    void onAirshipReady(@NotNull Context context, @NotNull UAirship airship);
}

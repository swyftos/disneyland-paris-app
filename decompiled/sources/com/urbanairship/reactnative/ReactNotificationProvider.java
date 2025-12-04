package com.urbanairship.reactnative;

import android.content.Context;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.android.framework.proxy.BaseNotificationProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/reactnative/ReactNotificationProvider;", "Lcom/urbanairship/android/framework/proxy/BaseNotificationProvider;", "context", "Landroid/content/Context;", "configOptions", "Lcom/urbanairship/AirshipConfigOptions;", "<init>", "(Landroid/content/Context;Lcom/urbanairship/AirshipConfigOptions;)V", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ReactNotificationProvider extends BaseNotificationProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNotificationProvider(@NotNull Context context, @NotNull AirshipConfigOptions configOptions) {
        super(context, configOptions);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configOptions, "configOptions");
    }
}

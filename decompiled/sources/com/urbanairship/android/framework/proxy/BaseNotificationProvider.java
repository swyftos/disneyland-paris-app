package com.urbanairship.android.framework.proxy;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.preferencecenter.PreferenceCenter;
import com.urbanairship.push.notifications.AirshipNotificationProvider;
import com.urbanairship.push.notifications.NotificationArguments;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0017J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0017J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/android/framework/proxy/BaseNotificationProvider;", "Lcom/urbanairship/push/notifications/AirshipNotificationProvider;", "context", "Landroid/content/Context;", "configOptions", "Lcom/urbanairship/AirshipConfigOptions;", "(Landroid/content/Context;Lcom/urbanairship/AirshipConfigOptions;)V", "getContext$airship_framework_proxy_release", "()Landroid/content/Context;", "notificationConfig", "Lcom/urbanairship/android/framework/proxy/NotificationConfig;", "getNotificationConfig", "()Lcom/urbanairship/android/framework/proxy/NotificationConfig;", PreferenceCenter.DEEP_LINK_HOST, "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "getPreferences", "()Lcom/urbanairship/android/framework/proxy/ProxyStore;", "preferences$delegate", "Lkotlin/Lazy;", "getDefaultAccentColor", "", "getDefaultNotificationChannelId", "", "getLargeIcon", "getSmallIcon", "onExtendBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "builder", "arguments", "Lcom/urbanairship/push/notifications/NotificationArguments;", "Companion", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class BaseNotificationProvider extends AirshipNotificationProvider {

    @NotNull
    public static final String PUSH_MESSAGE_BUNDLE_EXTRA = "com.urbanairship.push_bundle";
    private final Context context;

    /* renamed from: preferences$delegate, reason: from kotlin metadata */
    private final Lazy preferences;

    @NotNull
    /* renamed from: getContext$airship_framework_proxy_release, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNotificationProvider(@NotNull Context context, @NotNull AirshipConfigOptions configOptions) {
        super(context, configOptions);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configOptions, "configOptions");
        this.context = context;
        this.preferences = LazyKt.lazy(new Function0() { // from class: com.urbanairship.android.framework.proxy.BaseNotificationProvider$preferences$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ProxyStore invoke() {
                return ProxyStore.INSTANCE.shared(this.this$0.getContext());
            }
        });
    }

    private final ProxyStore getPreferences() {
        return (ProxyStore) this.preferences.getValue();
    }

    private final NotificationConfig getNotificationConfig() {
        return getPreferences().getNotificationConfig();
    }

    @Override // com.urbanairship.push.notifications.AirshipNotificationProvider
    @NotNull
    public String getDefaultNotificationChannelId() {
        String defaultChannelId;
        NotificationConfig notificationConfig = getNotificationConfig();
        if (notificationConfig != null && (defaultChannelId = notificationConfig.getDefaultChannelId()) != null) {
            return defaultChannelId;
        }
        String defaultNotificationChannelId = super.getDefaultNotificationChannelId();
        Intrinsics.checkNotNullExpressionValue(defaultNotificationChannelId, "getDefaultNotificationChannelId(...)");
        return defaultNotificationChannelId;
    }

    @Override // com.urbanairship.push.notifications.AirshipNotificationProvider
    @DrawableRes
    public int getSmallIcon() {
        int namedResource;
        NotificationConfig notificationConfig = getNotificationConfig();
        String icon = notificationConfig != null ? notificationConfig.getIcon() : null;
        return (icon == null || (namedResource = Utils.getNamedResource(this.context, icon, "drawable")) <= 0) ? super.getSmallIcon() : namedResource;
    }

    @Override // com.urbanairship.push.notifications.AirshipNotificationProvider
    @DrawableRes
    public int getLargeIcon() {
        int namedResource;
        NotificationConfig notificationConfig = getNotificationConfig();
        String largeIcon = notificationConfig != null ? notificationConfig.getLargeIcon() : null;
        return (largeIcon == null || (namedResource = Utils.getNamedResource(this.context, largeIcon, "drawable")) <= 0) ? super.getLargeIcon() : namedResource;
    }

    @Override // com.urbanairship.push.notifications.AirshipNotificationProvider
    @ColorInt
    public int getDefaultAccentColor() {
        NotificationConfig notificationConfig = getNotificationConfig();
        String accentColor = notificationConfig != null ? notificationConfig.getAccentColor() : null;
        if (accentColor != null) {
            return Utils.getHexColor(accentColor, super.getDefaultAccentColor());
        }
        return super.getDefaultAccentColor();
    }

    @Override // com.urbanairship.push.notifications.AirshipNotificationProvider
    @NotNull
    protected NotificationCompat.Builder onExtendBuilder(@NotNull Context context, @NotNull NotificationCompat.Builder builder, @NotNull NotificationArguments arguments) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        builder.getExtras().putBundle(PUSH_MESSAGE_BUNDLE_EXTRA, arguments.getMessage().getPushBundle());
        NotificationCompat.Builder builderOnExtendBuilder = super.onExtendBuilder(context, builder, arguments);
        Intrinsics.checkNotNullExpressionValue(builderOnExtendBuilder, "onExtendBuilder(...)");
        return builderOnExtendBuilder;
    }
}

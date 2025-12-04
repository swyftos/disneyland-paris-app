package com.urbanairship.remotedata;

import android.net.Uri;
import android.os.Build;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.facebook.hermes.intl.Constants;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.PushProviders;
import com.urbanairship.UAirship;
import com.urbanairship.base.Supplier;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.config.UrlBuilder;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.push.PushProvider;
import com.urbanairship.util.Attributes;
import com.urbanairship.util.UAStringUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J \u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/remotedata/RemoteDataUrlFactory;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "pushProvidersSupplier", "Lcom/urbanairship/base/Supplier;", "Lcom/urbanairship/PushProviders;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/base/Supplier;)V", TCEventPropertiesNames.TCD_MANUFACTURER, "", "getManufacturer", "()Ljava/lang/String;", DeferredApiClient.KEY_PLATFORM, "getPlatform", "pushProviders", "getPushProviders", "createAppUrl", "Landroid/net/Uri;", Constants.LOCALE, "Ljava/util/Locale;", "randomValue", "", "createContactUrl", "contactID", "createUrl", "path", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RemoteDataUrlFactory {
    private static final Companion Companion = new Companion(null);
    private static final List MANUFACTURERS_ALLOWED = CollectionsKt.listOf("huawei");
    private final Supplier pushProvidersSupplier;
    private final AirshipRuntimeConfig runtimeConfig;

    public RemoteDataUrlFactory(@NotNull AirshipRuntimeConfig runtimeConfig, @NotNull Supplier<PushProviders> pushProvidersSupplier) {
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(pushProvidersSupplier, "pushProvidersSupplier");
        this.runtimeConfig = runtimeConfig;
        this.pushProvidersSupplier = pushProvidersSupplier;
    }

    private final String getPlatform() {
        return this.runtimeConfig.getPlatform() == 1 ? "amazon" : "android";
    }

    private final String getManufacturer() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = "";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final String getPushProviders() {
        HashSet hashSet = new HashSet();
        PushProviders pushProviders = (PushProviders) this.pushProvidersSupplier.get();
        if (pushProviders == null) {
            return null;
        }
        Iterator<PushProvider> it = pushProviders.getAvailableProviders().iterator();
        while (it.hasNext()) {
            String deliveryType = it.next().getDeliveryType();
            Intrinsics.checkNotNullExpressionValue(deliveryType, "getDeliveryType(...)");
            hashSet.add(deliveryType);
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        return UAStringUtil.join(hashSet, ",");
    }

    @Nullable
    public final Uri createContactUrl(@NotNull String contactID, @NotNull Locale locale, int randomValue) {
        Intrinsics.checkNotNullParameter(contactID, "contactID");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return createUrl("api/remote-data-contact/" + getPlatform() + '/' + contactID, locale, randomValue);
    }

    @Nullable
    public final Uri createAppUrl(@NotNull Locale locale, int randomValue) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return createUrl("api/remote-data/app/" + this.runtimeConfig.getConfigOptions().appKey + '/' + getPlatform(), locale, randomValue);
    }

    private final Uri createUrl(String path, Locale locale, int randomValue) {
        UrlBuilder urlBuilderAppendQueryParameter = this.runtimeConfig.getRemoteDataUrl().appendEncodedPath(path).appendQueryParameter(OneIDTrackerEvent.EVENT_PARAM_SDK_VERSION, UAirship.getVersion()).appendQueryParameter("random_value", String.valueOf(randomValue));
        Intrinsics.checkNotNullExpressionValue(urlBuilderAppendQueryParameter, "appendQueryParameter(...)");
        if (MANUFACTURERS_ALLOWED.contains(getManufacturer())) {
            urlBuilderAppendQueryParameter.appendQueryParameter(TCEventPropertiesNames.TCD_MANUFACTURER, getManufacturer());
        }
        String pushProviders = getPushProviders();
        if (pushProviders != null) {
            urlBuilderAppendQueryParameter.appendQueryParameter("push_providers", pushProviders);
        }
        if (!UAStringUtil.isEmpty(locale.getLanguage())) {
            urlBuilderAppendQueryParameter.appendQueryParameter(TCEventPropertiesNames.TCD_LANGUAGE, locale.getLanguage());
        }
        if (!UAStringUtil.isEmpty(locale.getCountry())) {
            urlBuilderAppendQueryParameter.appendQueryParameter(Attributes.COUNTRY, locale.getCountry());
        }
        return urlBuilderAppendQueryParameter.build();
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

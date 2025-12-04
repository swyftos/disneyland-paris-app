package com.urbanairship;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import com.urbanairship.base.Supplier;
import com.urbanairship.google.PlayServicesUtils;
import com.urbanairship.push.PushProvider;
import com.urbanairship.util.PlatformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0002H\u0002J\r\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/DeferredPlatformProvider;", "Lcom/urbanairship/Provider;", "", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "pushProviders", "Lcom/urbanairship/base/Supplier;", "Lcom/urbanairship/PushProviders;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/base/Supplier;)V", "determinePlatform", "get", "()Ljava/lang/Integer;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public final class DeferredPlatformProvider implements Provider<Integer> {
    private final Context context;
    private final PreferenceDataStore dataStore;
    private final PrivacyManager privacyManager;
    private final Supplier pushProviders;

    public DeferredPlatformProvider(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull PrivacyManager privacyManager, @NotNull Supplier<PushProviders> pushProviders) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(pushProviders, "pushProviders");
        this.context = context;
        this.dataStore = dataStore;
        this.privacyManager = privacyManager;
        this.pushProviders = pushProviders;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.urbanairship.Provider
    @NotNull
    public Integer get() {
        int iDeterminePlatform = -1;
        int platform = PlatformUtils.parsePlatform(this.dataStore.getInt("com.urbanairship.application.device.PLATFORM", -1));
        if (platform != -1) {
            iDeterminePlatform = platform;
        } else if (this.privacyManager.isAnyFeatureEnabled()) {
            iDeterminePlatform = determinePlatform();
            this.dataStore.put("com.urbanairship.application.device.PLATFORM", iDeterminePlatform);
        }
        return Integer.valueOf(iDeterminePlatform);
    }

    private final int determinePlatform() {
        Object obj = this.pushProviders.get();
        Intrinsics.checkNotNull(obj);
        PushProvider bestProvider = ((PushProviders) obj).getBestProvider();
        if (bestProvider != null) {
            int platform = PlatformUtils.parsePlatform(bestProvider.getPlatform());
            String strAsString = PlatformUtils.asString(platform);
            Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            UALog.i("Setting platform to %s for push provider: %s", strAsString, bestProvider);
            return platform;
        }
        if (PlayServicesUtils.isGooglePlayStoreAvailable(this.context)) {
            UALog.i("Google Play Store available. Setting platform to Android.", new Object[0]);
        } else {
            if (StringsKt.equals("amazon", Build.MANUFACTURER, true)) {
                UALog.i("Build.MANUFACTURER is AMAZON. Setting platform to Amazon.", new Object[0]);
                return 1;
            }
            UALog.i("Defaulting platform to Android.", new Object[0]);
        }
        return 2;
    }
}

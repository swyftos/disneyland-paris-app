package com.urbanairship.android.framework.proxy.proxies;

import com.urbanairship.PrivacyManager;
import com.urbanairship.android.framework.proxy.Utils;
import com.urbanairship.json.JsonValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u000e\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u0012\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/PrivacyManagerProxy;", "", "privacyManagerProvider", "Lkotlin/Function0;", "Lcom/urbanairship/PrivacyManager;", "(Lkotlin/jvm/functions/Function0;)V", "disableFeatures", "", "features", "Lcom/urbanairship/PrivacyManager$Feature;", "featureNames", "Lcom/urbanairship/json/JsonValue;", "", "", "enableFeatures", "getFeatureNames", "isFeatureEnabled", "", "setEnabledFeatures", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PrivacyManagerProxy {
    private final Function0 privacyManagerProvider;

    public PrivacyManagerProxy(@NotNull Function0<PrivacyManager> privacyManagerProvider) {
        Intrinsics.checkNotNullParameter(privacyManagerProvider, "privacyManagerProvider");
        this.privacyManagerProvider = privacyManagerProvider;
    }

    public final void setEnabledFeatures(@NotNull List<String> featureNames) {
        Intrinsics.checkNotNullParameter(featureNames, "featureNames");
        JsonValue jsonValueWrapOpt = JsonValue.wrapOpt(featureNames);
        Intrinsics.checkNotNullExpressionValue(jsonValueWrapOpt, "wrapOpt(...)");
        setEnabledFeatures(jsonValueWrapOpt);
    }

    public final void setEnabledFeatures(@NotNull JsonValue featureNames) {
        Intrinsics.checkNotNullParameter(featureNames, "featureNames");
        setEnabledFeatures(Utils.INSTANCE.parseFeatures(featureNames));
    }

    public final void setEnabledFeatures(@NotNull PrivacyManager.Feature features) {
        Intrinsics.checkNotNullParameter(features, "features");
        ((PrivacyManager) this.privacyManagerProvider.invoke()).setEnabledFeatures(features);
    }

    @NotNull
    public final List<String> getFeatureNames() {
        return Utils.featureNames(((PrivacyManager) this.privacyManagerProvider.invoke()).getEnabledFeatures());
    }

    public final void enableFeatures(@NotNull List<String> featureNames) {
        Intrinsics.checkNotNullParameter(featureNames, "featureNames");
        JsonValue jsonValueWrapOpt = JsonValue.wrapOpt(featureNames);
        Intrinsics.checkNotNullExpressionValue(jsonValueWrapOpt, "wrapOpt(...)");
        enableFeatures(jsonValueWrapOpt);
    }

    public final void enableFeatures(@NotNull JsonValue featureNames) {
        Intrinsics.checkNotNullParameter(featureNames, "featureNames");
        enableFeatures(Utils.INSTANCE.parseFeatures(featureNames));
    }

    public final void enableFeatures(@NotNull PrivacyManager.Feature features) {
        Intrinsics.checkNotNullParameter(features, "features");
        ((PrivacyManager) this.privacyManagerProvider.invoke()).enable(features);
    }

    public final void disableFeatures(@NotNull List<String> featureNames) {
        Intrinsics.checkNotNullParameter(featureNames, "featureNames");
        JsonValue jsonValueWrapOpt = JsonValue.wrapOpt(featureNames);
        Intrinsics.checkNotNullExpressionValue(jsonValueWrapOpt, "wrapOpt(...)");
        disableFeatures(jsonValueWrapOpt);
    }

    public final void disableFeatures(@NotNull JsonValue featureNames) {
        Intrinsics.checkNotNullParameter(featureNames, "featureNames");
        disableFeatures(Utils.INSTANCE.parseFeatures(featureNames));
    }

    public final void disableFeatures(@NotNull PrivacyManager.Feature features) {
        Intrinsics.checkNotNullParameter(features, "features");
        ((PrivacyManager) this.privacyManagerProvider.invoke()).disable(features);
    }

    public final boolean isFeatureEnabled(@NotNull List<String> featureNames) {
        Intrinsics.checkNotNullParameter(featureNames, "featureNames");
        JsonValue jsonValueWrapOpt = JsonValue.wrapOpt(featureNames);
        Intrinsics.checkNotNullExpressionValue(jsonValueWrapOpt, "wrapOpt(...)");
        return isFeatureEnabled(jsonValueWrapOpt);
    }

    public final boolean isFeatureEnabled(@NotNull JsonValue featureNames) {
        Intrinsics.checkNotNullParameter(featureNames, "featureNames");
        return isFeatureEnabled(Utils.INSTANCE.parseFeatures(featureNames));
    }

    public final boolean isFeatureEnabled(@NotNull PrivacyManager.Feature features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return ((PrivacyManager) this.privacyManagerProvider.invoke()).isEnabled(features);
    }
}

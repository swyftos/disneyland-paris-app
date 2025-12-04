package com.urbanairship.android.framework.proxy.proxies;

import com.urbanairship.android.framework.proxy.ProxyStore;
import com.urbanairship.json.JsonValue;
import com.urbanairship.preferencecenter.PreferenceCenter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/PreferenceCenterProxy;", "", "proxyStore", "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "preferenceCenterProvider", "Lkotlin/Function0;", "Lcom/urbanairship/preferencecenter/PreferenceCenter;", "(Lcom/urbanairship/android/framework/proxy/ProxyStore;Lkotlin/jvm/functions/Function0;)V", "displayPreferenceCenter", "", "preferenceCenterId", "", "getPreferenceCenterConfig", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAutoLaunchPreferenceCenter", "preferenceID", "autoLaunch", "", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferenceCenterProxy {
    private final Function0 preferenceCenterProvider;
    private final ProxyStore proxyStore;

    public PreferenceCenterProxy(@NotNull ProxyStore proxyStore, @NotNull Function0<PreferenceCenter> preferenceCenterProvider) {
        Intrinsics.checkNotNullParameter(proxyStore, "proxyStore");
        Intrinsics.checkNotNullParameter(preferenceCenterProvider, "preferenceCenterProvider");
        this.proxyStore = proxyStore;
        this.preferenceCenterProvider = preferenceCenterProvider;
    }

    public final void displayPreferenceCenter(@NotNull String preferenceCenterId) {
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        ((PreferenceCenter) this.preferenceCenterProvider.invoke()).open(preferenceCenterId);
    }

    @Nullable
    public final Object getPreferenceCenterConfig(@NotNull String str, @NotNull Continuation<? super JsonValue> continuation) {
        return ((PreferenceCenter) this.preferenceCenterProvider.invoke()).getJsonConfig(str, continuation);
    }

    public final void setAutoLaunchPreferenceCenter(@NotNull String preferenceID, boolean autoLaunch) {
        Intrinsics.checkNotNullParameter(preferenceID, "preferenceID");
        this.proxyStore.setAutoLaunchPreferenceCenter(preferenceID, autoLaunch);
    }
}

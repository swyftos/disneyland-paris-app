package com.urbanairship.config;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.remoteconfig.RemoteConfig;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0007R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/config/RemoteConfigObserver;", "", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "(Lcom/urbanairship/PreferenceDataStore;)V", "remoteConfig", "Lcom/urbanairship/remoteconfig/RemoteConfig;", "getRemoteConfig", "()Lcom/urbanairship/remoteconfig/RemoteConfig;", "remoteConfigCache", "Lcom/urbanairship/config/RemoteConfigCache;", "remoteConfigListeners", "", "Lcom/urbanairship/config/AirshipRuntimeConfig$ConfigChangeListener;", "addConfigListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeRemoteConfigListener", "updateRemoteConfig", "config", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nAirshipRuntimeConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirshipRuntimeConfig.kt\ncom/urbanairship/config/RemoteConfigObserver\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n1855#2,2:219\n*S KotlinDebug\n*F\n+ 1 AirshipRuntimeConfig.kt\ncom/urbanairship/config/RemoteConfigObserver\n*L\n214#1:219,2\n*E\n"})
/* loaded from: classes5.dex */
public final class RemoteConfigObserver {
    private final RemoteConfigCache remoteConfigCache;
    private final List remoteConfigListeners;

    public RemoteConfigObserver(@NotNull PreferenceDataStore dataStore) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.remoteConfigListeners = new CopyOnWriteArrayList();
        this.remoteConfigCache = new RemoteConfigCache(dataStore);
    }

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        return this.remoteConfigCache.getConfig$urbanairship_core_release();
    }

    public final void addConfigListener(@NotNull AirshipRuntimeConfig.ConfigChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.remoteConfigListeners.add(listener);
    }

    public final void removeRemoteConfigListener(@NotNull AirshipRuntimeConfig.ConfigChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.remoteConfigListeners.remove(listener);
    }

    @VisibleForTesting
    public final void updateRemoteConfig(@NotNull RemoteConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.remoteConfigCache.updateConfig$urbanairship_core_release(config)) {
            Iterator it = this.remoteConfigListeners.iterator();
            while (it.hasNext()) {
                ((AirshipRuntimeConfig.ConfigChangeListener) it.next()).onConfigUpdated();
            }
        }
    }
}

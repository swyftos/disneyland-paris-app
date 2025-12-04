package com.urbanairship.config;

import androidx.annotation.RestrictTo;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.json.JsonValue;
import com.urbanairship.preferencecenter.PreferenceCenter;
import com.urbanairship.remoteconfig.RemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/config/RemoteConfigCache;", "", PreferenceCenter.DEEP_LINK_HOST, "Lcom/urbanairship/PreferenceDataStore;", "(Lcom/urbanairship/PreferenceDataStore;)V", "_remoteConfig", "Lcom/urbanairship/remoteconfig/RemoteConfig;", "config", "getConfig$urbanairship_core_release", "()Lcom/urbanairship/remoteconfig/RemoteConfig;", "lock", "updateConfig", "", "updateConfig$urbanairship_core_release", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nRemoteConfigCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteConfigCache.kt\ncom/urbanairship/config/RemoteConfigCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n1#2:45\n*E\n"})
/* loaded from: classes5.dex */
public final class RemoteConfigCache {
    private static final Companion Companion = new Companion(null);
    private RemoteConfig _remoteConfig;
    private final Object lock;
    private final PreferenceDataStore preferences;

    public RemoteConfigCache(@NotNull PreferenceDataStore preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.preferences = preferences;
        this.lock = new Object();
    }

    @NotNull
    public final RemoteConfig getConfig$urbanairship_core_release() {
        RemoteConfig remoteConfigFromJson;
        synchronized (this.lock) {
            remoteConfigFromJson = this._remoteConfig;
            if (remoteConfigFromJson == null) {
                RemoteConfig.Companion companion = RemoteConfig.INSTANCE;
                JsonValue jsonValue = this.preferences.getJsonValue("com.urbanairship.config.REMOTE_CONFIG_KEY");
                Intrinsics.checkNotNullExpressionValue(jsonValue, "getJsonValue(...)");
                remoteConfigFromJson = companion.fromJson(jsonValue);
                this._remoteConfig = remoteConfigFromJson;
            }
        }
        return remoteConfigFromJson;
    }

    public final boolean updateConfig$urbanairship_core_release(@NotNull RemoteConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this.lock) {
            if (Intrinsics.areEqual(config, this._remoteConfig)) {
                return false;
            }
            this._remoteConfig = config;
            this.preferences.put("com.urbanairship.config.REMOTE_CONFIG_KEY", config);
            return true;
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

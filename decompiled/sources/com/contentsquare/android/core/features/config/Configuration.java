package com.contentsquare.android.core.features.config;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.BuildConfigInstantiable;
import com.contentsquare.android.core.utils.VersionMatcher;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\bJ\n\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/contentsquare/android/core/features/config/Configuration;", "Lcom/contentsquare/android/core/features/preferences/PreferencesStore$PreferencesStoreListener;", "preferencesStore", "Lcom/contentsquare/android/core/features/preferences/PreferencesStore;", "buildInstantiable", "Lcom/contentsquare/android/core/utils/BuildConfigInstantiable;", "(Lcom/contentsquare/android/core/features/preferences/PreferencesStore;Lcom/contentsquare/android/core/utils/BuildConfigInstantiable;)V", "lastETag", "", "getLastETag", "()Ljava/lang/String;", "setLastETag", "(Ljava/lang/String;)V", "projectConfig", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;", "getProjectConfig", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;", "rootConfig", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$RootConfig;", "hasConfigChanged", "", "config", "isFeatureFlagEnabled", "name", "load", "loadFromStorage", "onPreferenceChanged", "", "key", "Lcom/contentsquare/android/core/features/preferences/PreferencesKey;", "saveToStorage", "jsonConfiguration", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConfiguration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Configuration.kt\ncom/contentsquare/android/core/features/config/Configuration\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,121:1\n288#2,2:122\n*S KotlinDebug\n*F\n+ 1 Configuration.kt\ncom/contentsquare/android/core/features/config/Configuration\n*L\n115#1:122,2\n*E\n"})
/* loaded from: classes2.dex */
public final class Configuration implements PreferencesStore.PreferencesStoreListener {

    @NotNull
    private static final Logger logger = new Logger("Configuration");

    @NotNull
    private final BuildConfigInstantiable buildInstantiable;

    @NotNull
    private String lastETag;

    @NotNull
    private final PreferencesStore preferencesStore;

    @Nullable
    private JsonConfig.RootConfig rootConfig;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Configuration(PreferencesStore preferencesStore) {
        this(preferencesStore, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
    }

    private final JsonConfig.RootConfig load() {
        String strLoadFromStorage = loadFromStorage();
        if (strLoadFromStorage == null) {
            return null;
        }
        return JsonConfig.INSTANCE.decodeFromString(strLoadFromStorage);
    }

    @NotNull
    public final String getLastETag() {
        return this.lastETag;
    }

    @Nullable
    public final JsonConfig.ProjectConfiguration getProjectConfig() {
        JsonConfig.ProjectConfigurations projectConfigurations;
        JsonConfig.RootConfig rootConfig = this.rootConfig;
        if (rootConfig == null || (projectConfigurations = rootConfig.getProjectConfigurations()) == null) {
            return null;
        }
        return projectConfigurations.getProjectConfig();
    }

    public final boolean hasConfigChanged(JsonConfig.RootConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return !Intrinsics.areEqual(config, this.rootConfig);
    }

    public final boolean isFeatureFlagEnabled(String name) {
        List<JsonConfig.FeatureFlag> featureFlags;
        Object next;
        Intrinsics.checkNotNullParameter(name, "name");
        JsonConfig.ProjectConfiguration projectConfig = getProjectConfig();
        if (projectConfig != null && (featureFlags = projectConfig.getFeatureFlags()) != null) {
            Iterator<T> it = featureFlags.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((JsonConfig.FeatureFlag) next).getName(), name)) {
                    break;
                }
            }
            JsonConfig.FeatureFlag featureFlag = (JsonConfig.FeatureFlag) next;
            if (featureFlag != null && featureFlag.getEnabled()) {
                if (VersionMatcher.match(">=" + featureFlag.getMinVersion(), this.buildInstantiable.getCsSdkVersion())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public final String loadFromStorage() {
        Logger logger2 = logger;
        logger2.d("retrieving last config from preferences...");
        String string = this.preferencesStore.getString(PreferencesKey.RAW_CONFIGURATION_AS_JSON, null);
        if (string == null || string.length() == 0) {
            logger2.d("No configuration saved.");
            return null;
        }
        logger2.d("config is: " + string);
        return string;
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public void onPreferenceChanged(PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key == PreferencesKey.RAW_CONFIGURATION_AS_JSON) {
            this.rootConfig = load();
        }
    }

    public final void saveToStorage(String jsonConfiguration) {
        Intrinsics.checkNotNullParameter(jsonConfiguration, "jsonConfiguration");
        JsonConfig.RootConfig rootConfigDecodeFromString = JsonConfig.INSTANCE.decodeFromString(jsonConfiguration);
        if (Intrinsics.areEqual(rootConfigDecodeFromString, this.rootConfig)) {
            return;
        }
        this.rootConfig = rootConfigDecodeFromString;
        this.preferencesStore.putString(PreferencesKey.RAW_CONFIGURATION_AS_JSON, jsonConfiguration);
    }

    public final void setLastETag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastETag = str;
    }

    @JvmOverloads
    public Configuration(PreferencesStore preferencesStore, BuildConfigInstantiable buildInstantiable) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(buildInstantiable, "buildInstantiable");
        this.preferencesStore = preferencesStore;
        this.buildInstantiable = buildInstantiable;
        this.rootConfig = load();
        this.lastETag = "";
        preferencesStore.registerOnChangedListener(this);
    }

    public /* synthetic */ Configuration(PreferencesStore preferencesStore, BuildConfigInstantiable buildConfigInstantiable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(preferencesStore, (i & 2) != 0 ? new BuildConfigInstantiable() : buildConfigInstantiable);
    }
}

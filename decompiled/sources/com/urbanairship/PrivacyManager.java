package com.urbanairship;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.config.RemoteConfigObserver;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0010\u0018\u0000 .2\u00020\u0001:\u0003./0B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0007J\u001f\u0010\u001f\u001a\u00020\u001d2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050!\"\u00020\u0005¢\u0006\u0002\u0010\"J\u001f\u0010#\u001a\u00020\u001d2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050!\"\u00020\u0005¢\u0006\u0002\u0010\"J\b\u0010$\u001a\u00020\u0005H\u0002J\u001f\u0010%\u001a\u00020\t2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050!\"\u00020\u0005¢\u0006\u0002\u0010&J\u0015\u0010\u0011\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0000¢\u0006\u0002\b(J\u001f\u0010)\u001a\u00020\t2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050!\"\u00020\u0005¢\u0006\u0002\u0010&J\r\u0010*\u001a\u00020\u001dH\u0001¢\u0006\u0002\b+J\b\u0010,\u001a\u00020\u001dH\u0002J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0007J\u001f\u0010\u000f\u001a\u00020\u001d2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050!\"\u00020\u0005¢\u0006\u0002\u0010\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/urbanairship/PrivacyManager;", "", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "defaultEnabledFeatures", "Lcom/urbanairship/PrivacyManager$Feature;", "configObserver", "Lcom/urbanairship/config/RemoteConfigObserver;", "resetEnabledFeatures", "", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/PrivacyManager$Feature;Lcom/urbanairship/config/RemoteConfigObserver;Z)V", "value", "enabledFeatures", "getEnabledFeatures", "()Lcom/urbanairship/PrivacyManager$Feature;", "setEnabledFeatures", "(Lcom/urbanairship/PrivacyManager$Feature;)V", "isAnyFeatureEnabled", "()Z", "lastUpdated", "listeners", "", "Lcom/urbanairship/PrivacyManager$Listener;", "localEnabledFeature", "getLocalEnabledFeature", "setLocalEnabledFeature", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "disable", "features", "", "([Lcom/urbanairship/PrivacyManager$Feature;)V", "enable", "getDisabledFeatures", "isAnyEnabled", "([Lcom/urbanairship/PrivacyManager$Feature;)Z", "ignoringRemoteConfig", "isAnyFeatureEnabled$urbanairship_core_release", "isEnabled", "migrateData", "migrateData$urbanairship_core_release", "notifyUpdate", "removeListener", "Companion", "Feature", "Listener", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PrivacyManager {
    private final RemoteConfigObserver configObserver;
    private final PreferenceDataStore dataStore;
    private final Feature defaultEnabledFeatures;
    private Feature lastUpdated;
    private final List listeners;
    private final ReentrantLock lock;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String DATA_COLLECTION_ENABLED_KEY = "com.urbanairship.DATA_COLLECTION_ENABLED";
    private static final String ANALYTICS_ENABLED_KEY = "com.urbanairship.analytics.ANALYTICS_ENABLED";
    private static final String PUSH_TOKEN_REGISTRATION_ENABLED_KEY = "com.urbanairship.push.PUSH_TOKEN_REGISTRATION_ENABLED";
    private static final String PUSH_ENABLED_KEY = "com.urbanairship.push.PUSH_ENABLED";
    private static final String IAA_ENABLED_KEY = "com.urbanairship.iam.enabled";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/urbanairship/PrivacyManager$Listener;", "", "onEnabledFeaturesChanged", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface Listener {
        void onEnabledFeaturesChanged();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PrivacyManager(@NotNull PreferenceDataStore dataStore, @NotNull Feature defaultEnabledFeatures) {
        this(dataStore, defaultEnabledFeatures, null, false, 12, null);
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(defaultEnabledFeatures, "defaultEnabledFeatures");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PrivacyManager(@NotNull PreferenceDataStore dataStore, @NotNull Feature defaultEnabledFeatures, @NotNull RemoteConfigObserver configObserver) {
        this(dataStore, defaultEnabledFeatures, configObserver, false, 8, null);
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(defaultEnabledFeatures, "defaultEnabledFeatures");
        Intrinsics.checkNotNullParameter(configObserver, "configObserver");
    }

    @JvmOverloads
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PrivacyManager(@NotNull PreferenceDataStore dataStore, @NotNull Feature defaultEnabledFeatures, @NotNull RemoteConfigObserver configObserver, boolean z) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(defaultEnabledFeatures, "defaultEnabledFeatures");
        Intrinsics.checkNotNullParameter(configObserver, "configObserver");
        this.dataStore = dataStore;
        this.defaultEnabledFeatures = defaultEnabledFeatures;
        this.configObserver = configObserver;
        this.lock = new ReentrantLock();
        this.listeners = new CopyOnWriteArrayList();
        this.lastUpdated = Feature.NONE;
        if (z) {
            dataStore.remove("com.urbanairship.PrivacyManager.enabledFeatures");
        }
        this.lastUpdated = getEnabledFeatures();
        migrateData$urbanairship_core_release();
        configObserver.addConfigListener(new AnonymousClass1());
    }

    public /* synthetic */ PrivacyManager(PreferenceDataStore preferenceDataStore, Feature feature, RemoteConfigObserver remoteConfigObserver, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(preferenceDataStore, feature, (i & 4) != 0 ? new RemoteConfigObserver(preferenceDataStore) : remoteConfigObserver, (i & 8) != 0 ? false : z);
    }

    /* renamed from: com.urbanairship.PrivacyManager$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 implements AirshipRuntimeConfig.ConfigChangeListener, FunctionAdapter {
        AnonymousClass1() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof AirshipRuntimeConfig.ConfigChangeListener) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return new FunctionReferenceImpl(0, PrivacyManager.this, PrivacyManager.class, "notifyUpdate", "notifyUpdate()V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.urbanairship.config.AirshipRuntimeConfig.ConfigChangeListener
        public final void onConfigUpdated() {
            PrivacyManager.this.notifyUpdate();
        }
    }

    private final Feature getDisabledFeatures() {
        Feature disabledFeatures = this.configObserver.getRemoteConfig().getDisabledFeatures();
        return disabledFeatures == null ? Feature.NONE : disabledFeatures;
    }

    private final Feature getLocalEnabledFeature() {
        return new Feature(this.dataStore.getInt("com.urbanairship.PrivacyManager.enabledFeatures", this.defaultEnabledFeatures.getRawValue())).and$urbanairship_core_release(Feature.ALL);
    }

    private final void setLocalEnabledFeature(Feature feature) {
        this.dataStore.put("com.urbanairship.PrivacyManager.enabledFeatures", feature.getRawValue());
    }

    @NotNull
    public final Feature getEnabledFeatures() {
        return getLocalEnabledFeature().subtracting$urbanairship_core_release(getDisabledFeatures());
    }

    public final void setEnabledFeatures(@NotNull Feature value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            setLocalEnabledFeature(value);
            notifyUpdate();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyUpdate() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Feature enabledFeatures = getEnabledFeatures();
            if (!Intrinsics.areEqual(this.lastUpdated, enabledFeatures)) {
                this.lastUpdated = enabledFeatures;
                Iterator it = this.listeners.iterator();
                while (it.hasNext()) {
                    ((Listener) it.next()).onEnabledFeaturesChanged();
                }
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void setEnabledFeatures(@NotNull Feature... features) {
        Intrinsics.checkNotNullParameter(features, "features");
        setEnabledFeatures(Feature.INSTANCE.combined((Feature[]) Arrays.copyOf(features, features.length)));
    }

    public final void enable(@NotNull Feature... features) {
        Intrinsics.checkNotNullParameter(features, "features");
        setEnabledFeatures(getEnabledFeatures().combining$urbanairship_core_release(ArraysKt.toList(features)));
    }

    public final void disable(@NotNull Feature... features) {
        Intrinsics.checkNotNullParameter(features, "features");
        setEnabledFeatures(getEnabledFeatures().subtracting$urbanairship_core_release(ArraysKt.toList(features)));
    }

    public final boolean isEnabled(@NotNull Feature... features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return getEnabledFeatures().contains$urbanairship_core_release(ArraysKt.toList(features));
    }

    public final boolean isAnyEnabled(@NotNull Feature... features) {
        Intrinsics.checkNotNullParameter(features, "features");
        Feature enabledFeatures = getEnabledFeatures();
        for (Feature feature : features) {
            if (enabledFeatures.contains$urbanairship_core_release(feature)) {
                return true;
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isAnyFeatureEnabled() {
        return isAnyFeatureEnabled$urbanairship_core_release(false);
    }

    public final boolean isAnyFeatureEnabled$urbanairship_core_release(boolean ignoringRemoteConfig) {
        Feature enabledFeatures;
        if (ignoringRemoteConfig) {
            enabledFeatures = getLocalEnabledFeature();
        } else {
            enabledFeatures = getEnabledFeatures();
        }
        return !Intrinsics.areEqual(enabledFeatures.and$urbanairship_core_release(Feature.ALL), Feature.NONE);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void addListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void removeListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @VisibleForTesting
    public final void migrateData$urbanairship_core_release() {
        PreferenceDataStore preferenceDataStore = this.dataStore;
        String str = DATA_COLLECTION_ENABLED_KEY;
        if (preferenceDataStore.isSet(str)) {
            if (this.dataStore.getBoolean(str, false)) {
                setEnabledFeatures(Feature.ALL);
            } else {
                setEnabledFeatures(Feature.NONE);
            }
            this.dataStore.remove(str);
        }
        PreferenceDataStore preferenceDataStore2 = this.dataStore;
        String str2 = ANALYTICS_ENABLED_KEY;
        if (preferenceDataStore2.isSet(str2)) {
            if (!this.dataStore.getBoolean(str2, true)) {
                disable(Feature.ANALYTICS);
            }
            this.dataStore.remove(str2);
        }
        PreferenceDataStore preferenceDataStore3 = this.dataStore;
        String str3 = PUSH_TOKEN_REGISTRATION_ENABLED_KEY;
        if (preferenceDataStore3.isSet(str3)) {
            if (!this.dataStore.getBoolean(str3, true)) {
                disable(Feature.PUSH);
            }
            this.dataStore.remove(str3);
        }
        PreferenceDataStore preferenceDataStore4 = this.dataStore;
        String str4 = PUSH_ENABLED_KEY;
        if (preferenceDataStore4.isSet(str4)) {
            if (!this.dataStore.getBoolean(str4, true)) {
                disable(Feature.PUSH);
            }
            this.dataStore.remove(str4);
        }
        PreferenceDataStore preferenceDataStore5 = this.dataStore;
        String str5 = IAA_ENABLED_KEY;
        if (preferenceDataStore5.isSet(str5)) {
            if (!this.dataStore.getBoolean(str5, true)) {
                disable(Feature.IN_APP_AUTOMATION);
            }
            this.dataStore.remove(str5);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R\u001c\u0010\u0012\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/PrivacyManager$Companion;", "", "()V", "ANALYTICS_ENABLED_KEY", "", "getANALYTICS_ENABLED_KEY$annotations", "getANALYTICS_ENABLED_KEY", "()Ljava/lang/String;", "DATA_COLLECTION_ENABLED_KEY", "getDATA_COLLECTION_ENABLED_KEY$annotations", "getDATA_COLLECTION_ENABLED_KEY", "ENABLED_FEATURES_KEY", "IAA_ENABLED_KEY", "getIAA_ENABLED_KEY$annotations", "getIAA_ENABLED_KEY", "PUSH_ENABLED_KEY", "getPUSH_ENABLED_KEY$annotations", "getPUSH_ENABLED_KEY", "PUSH_TOKEN_REGISTRATION_ENABLED_KEY", "getPUSH_TOKEN_REGISTRATION_ENABLED_KEY$annotations", "getPUSH_TOKEN_REGISTRATION_ENABLED_KEY", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getANALYTICS_ENABLED_KEY$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getDATA_COLLECTION_ENABLED_KEY$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getIAA_ENABLED_KEY$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPUSH_ENABLED_KEY$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPUSH_TOKEN_REGISTRATION_ENABLED_KEY$annotations() {
        }

        private Companion() {
        }

        @NotNull
        public final String getDATA_COLLECTION_ENABLED_KEY() {
            return PrivacyManager.DATA_COLLECTION_ENABLED_KEY;
        }

        @NotNull
        public final String getANALYTICS_ENABLED_KEY() {
            return PrivacyManager.ANALYTICS_ENABLED_KEY;
        }

        @NotNull
        public final String getPUSH_TOKEN_REGISTRATION_ENABLED_KEY() {
            return PrivacyManager.PUSH_TOKEN_REGISTRATION_ENABLED_KEY;
        }

        @NotNull
        public final String getPUSH_ENABLED_KEY() {
            return PrivacyManager.PUSH_ENABLED_KEY;
        }

        @NotNull
        public final String getIAA_ENABLED_KEY() {
            return PrivacyManager.IAA_ENABLED_KEY;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0080\u0004¢\u0006\u0002\b\tJ\u001b\u0010\n\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fH\u0000¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0011J\u001b\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fH\u0000¢\u0006\u0002\b\u0011J\u0013\u0010\u0012\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\fH\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0000H\u0002J\u0016\u0010\u0018\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0080\u0004¢\u0006\u0002\b\u0019J\u0016\u0010\u001a\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fH\u0002J\u0017\u0010\u001b\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0002\b\u001cJ\u001b\u0010\u001b\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fH\u0000¢\u0006\u0002\b\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006!"}, d2 = {"Lcom/urbanairship/PrivacyManager$Feature;", "Lcom/urbanairship/json/JsonSerializable;", "rawValue", "", "(I)V", "getRawValue$urbanairship_core_release", "()I", JsonPredicate.AND_PREDICATE_TYPE, ETCPaymentMethod.OTHER, "and$urbanairship_core_release", "combining", "features", "", "combining$urbanairship_core_release", "contains", "", "feature", "contains$urbanairship_core_release", ExactValueMatcher.EQUALS_VALUE_KEY, "", "getNames", "", "hashCode", "inv", JsonPredicate.OR_PREDICATE_TYPE, "or$urbanairship_core_release", "reduce", "subtracting", "subtracting$urbanairship_core_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPrivacyManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrivacyManager.kt\ncom/urbanairship/PrivacyManager$Feature\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,522:1\n2730#2,7:523\n766#2:530\n857#2,2:531\n526#3:533\n511#3,6:534\n526#3:540\n511#3,6:541\n125#4:547\n152#4,3:548\n*S KotlinDebug\n*F\n+ 1 PrivacyManager.kt\ncom/urbanairship/PrivacyManager$Feature\n*L\n317#1:523,7\n350#1:530\n350#1:531,2\n358#1:533\n358#1:534,6\n359#1:540\n359#1:541,6\n360#1:547\n360#1:548,3\n*E\n"})
    public static final class Feature implements JsonSerializable {

        @JvmField
        @NotNull
        public static final Feature ALL;

        @JvmField
        @NotNull
        public static final Feature ANALYTICS;

        @JvmField
        @NotNull
        public static final Feature CONTACTS;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @JvmField
        @NotNull
        public static final Feature FEATURE_FLAGS;

        @JvmField
        @NotNull
        public static final Feature IN_APP_AUTOMATION;

        @JvmField
        @NotNull
        public static final Feature MESSAGE_CENTER;

        @JvmField
        @NotNull
        public static final Feature NONE;

        @JvmField
        @NotNull
        public static final Feature PUSH;

        @JvmField
        @NotNull
        public static final Feature TAGS_AND_ATTRIBUTES;
        private static final Map nameMap;
        private final int rawValue;

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public static final Feature combined(@NotNull Feature... featureArr) {
            return INSTANCE.combined(featureArr);
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Nullable
        public static final Feature fromJson(@NotNull JsonValue jsonValue) {
            return INSTANCE.fromJson(jsonValue);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Feature(int i) {
            this.rawValue = i;
        }

        /* renamed from: getRawValue$urbanairship_core_release, reason: from getter */
        public final int getRawValue() {
            return this.rawValue;
        }

        @NotNull
        public final Feature subtracting$urbanairship_core_release(@NotNull List<Feature> features) {
            Intrinsics.checkNotNullParameter(features, "features");
            return and$urbanairship_core_release(reduce(features).inv());
        }

        @NotNull
        public final Feature subtracting$urbanairship_core_release(@Nullable Feature feature) {
            return feature == null ? this : and$urbanairship_core_release(feature.inv());
        }

        @NotNull
        public final Feature combining$urbanairship_core_release(@NotNull List<Feature> features) {
            Intrinsics.checkNotNullParameter(features, "features");
            return or$urbanairship_core_release(reduce(features));
        }

        public final boolean contains$urbanairship_core_release(@NotNull List<Feature> features) {
            Intrinsics.checkNotNullParameter(features, "features");
            Feature feature = NONE;
            Feature featureCombining$urbanairship_core_release = feature.combining$urbanairship_core_release(features);
            if (Intrinsics.areEqual(featureCombining$urbanairship_core_release, feature)) {
                return Intrinsics.areEqual(this, feature);
            }
            return contains$urbanairship_core_release(featureCombining$urbanairship_core_release);
        }

        public final boolean contains$urbanairship_core_release(@NotNull Feature feature) {
            Intrinsics.checkNotNullParameter(feature, "feature");
            return Intrinsics.areEqual(and$urbanairship_core_release(feature), feature);
        }

        @NotNull
        public String toString() {
            ArrayList arrayList = new ArrayList();
            if (contains$urbanairship_core_release(IN_APP_AUTOMATION)) {
                arrayList.add("In-App Automation");
            }
            if (contains$urbanairship_core_release(MESSAGE_CENTER)) {
                arrayList.add("Message Center");
            }
            if (contains$urbanairship_core_release(PUSH)) {
                arrayList.add("Push");
            }
            if (contains$urbanairship_core_release(ANALYTICS)) {
                arrayList.add("Analytics");
            }
            if (contains$urbanairship_core_release(TAGS_AND_ATTRIBUTES)) {
                arrayList.add("Tags and Attributes");
            }
            if (contains$urbanairship_core_release(CONTACTS)) {
                arrayList.add("Contacts");
            }
            if (contains$urbanairship_core_release(FEATURE_FLAGS)) {
                arrayList.add("Feature Flags");
            }
            return "AirshipFeature: [" + CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null) + AbstractJsonLexerKt.END_LIST;
        }

        private final List getNames() {
            if (Intrinsics.areEqual(this, ALL)) {
                Set setKeySet = nameMap.keySet();
                ArrayList arrayList = new ArrayList();
                for (Object obj : setKeySet) {
                    String str = (String) obj;
                    if (!Intrinsics.areEqual(str, "none") && !Intrinsics.areEqual(str, AirshipConfigOptions.FEATURE_ALL)) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
            if (Intrinsics.areEqual(this, NONE)) {
                return CollectionsKt.emptyList();
            }
            Map map = nameMap;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (!Intrinsics.areEqual(entry.getValue(), NONE) && !Intrinsics.areEqual(entry.getValue(), ALL)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                if (contains$urbanairship_core_release((Feature) entry2.getValue())) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            ArrayList arrayList2 = new ArrayList(linkedHashMap2.size());
            Iterator it = linkedHashMap2.entrySet().iterator();
            while (it.hasNext()) {
                arrayList2.add((String) ((Map.Entry) it.next()).getKey());
            }
            return arrayList2;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() throws JsonException {
            JsonValue jsonValueWrap = JsonValue.wrap(getNames());
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0012\"\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0015H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/PrivacyManager$Feature$Companion;", "", "()V", "ALL", "Lcom/urbanairship/PrivacyManager$Feature;", "ANALYTICS", "CONTACTS", "FEATURE_FLAGS", "IN_APP_AUTOMATION", "MESSAGE_CENTER", "NONE", "PUSH", "TAGS_AND_ATTRIBUTES", "nameMap", "", "", "combined", "value", "", "([Lcom/urbanairship/PrivacyManager$Feature;)Lcom/urbanairship/PrivacyManager$Feature;", "fromJson", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nPrivacyManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrivacyManager.kt\ncom/urbanairship/PrivacyManager$Feature$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,522:1\n1549#2:523\n1620#2,3:524\n1549#2:527\n1620#2,3:528\n*S KotlinDebug\n*F\n+ 1 PrivacyManager.kt\ncom/urbanairship/PrivacyManager$Feature$Companion\n*L\n478#1:523\n478#1:524,3\n479#1:527\n479#1:528,3\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            @Nullable
            public final Feature fromJson(@NotNull JsonValue value) {
                Intrinsics.checkNotNullParameter(value, "value");
                try {
                    JsonList jsonListRequireList = value.requireList();
                    Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
                    ArrayList<String> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                    Iterator<JsonValue> it = jsonListRequireList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().requireString());
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                    for (String str : arrayList) {
                        Map map = Feature.nameMap;
                        Intrinsics.checkNotNull(str);
                        String lowerCase = str.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        Feature feature = (Feature) map.get(lowerCase);
                        if (feature == null) {
                            throw new IllegalArgumentException("Invalid feature " + str);
                        }
                        arrayList2.add(feature);
                    }
                    return Feature.NONE.combining$urbanairship_core_release(arrayList2);
                } catch (Exception e) {
                    UALog.e(e, new Function0() { // from class: com.urbanairship.PrivacyManager$Feature$Companion$fromJson$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to parse features";
                        }
                    });
                    return null;
                }
            }

            @JvmStatic
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            @NotNull
            public final Feature combined(@NotNull Feature... value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Feature.NONE.combining$urbanairship_core_release(ArraysKt.toList(value));
            }
        }

        static {
            Feature feature = new Feature(1);
            IN_APP_AUTOMATION = feature;
            Feature feature2 = new Feature(2);
            MESSAGE_CENTER = feature2;
            Feature feature3 = new Feature(4);
            PUSH = feature3;
            Feature feature4 = new Feature(16);
            ANALYTICS = feature4;
            Feature feature5 = new Feature(32);
            TAGS_AND_ATTRIBUTES = feature5;
            Feature feature6 = new Feature(64);
            CONTACTS = feature6;
            Feature feature7 = new Feature(256);
            FEATURE_FLAGS = feature7;
            Feature feature8 = new Feature(0);
            NONE = feature8;
            Feature featureOr$urbanairship_core_release = feature.or$urbanairship_core_release(feature4).or$urbanairship_core_release(feature2).or$urbanairship_core_release(feature3).or$urbanairship_core_release(feature4).or$urbanairship_core_release(feature5).or$urbanairship_core_release(feature6).or$urbanairship_core_release(feature7);
            ALL = featureOr$urbanairship_core_release;
            nameMap = MapsKt.mapOf(TuplesKt.to(AirshipConfigOptions.FEATURE_PUSH, feature3), TuplesKt.to(AirshipConfigOptions.FEATURE_CONTACTS, feature6), TuplesKt.to(AirshipConfigOptions.FEATURE_MESSAGE_CENTER, feature2), TuplesKt.to(AirshipConfigOptions.FEATURE_ANALYTICS, feature4), TuplesKt.to(AirshipConfigOptions.FEATURE_TAGS_AND_ATTRIBUTES, feature5), TuplesKt.to(AirshipConfigOptions.FEATURE_IN_APP_AUTOMATION, feature), TuplesKt.to(AirshipConfigOptions.FEATURE_FEATURE_FLAGS, feature7), TuplesKt.to(AirshipConfigOptions.FEATURE_ALL, featureOr$urbanairship_core_release), TuplesKt.to("none", feature8));
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Feature.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.PrivacyManager.Feature");
            return this.rawValue == ((Feature) other).rawValue;
        }

        public int hashCode() {
            return this.rawValue;
        }

        @NotNull
        public final Feature and$urbanairship_core_release(@NotNull Feature other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return new Feature(this.rawValue & other.rawValue);
        }

        @NotNull
        public final Feature or$urbanairship_core_release(@NotNull Feature other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return new Feature(this.rawValue | other.rawValue);
        }

        private final Feature inv() {
            return new Feature(~this.rawValue);
        }

        private final Feature reduce(List features) {
            Object obj;
            Iterator it = features.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    next = ((Feature) next).or$urbanairship_core_release((Feature) it.next());
                }
                obj = next;
            } else {
                obj = null;
            }
            Feature feature = (Feature) obj;
            return feature == null ? NONE : feature;
        }
    }
}

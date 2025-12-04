package com.contentsquare.android.core.features.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.features.logging.Logger;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.channel.AttributeMutation;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u0003234B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u001bJ\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u001dJ(\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001fJ\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001dH\u0016J\u0016\u0010#\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000bJ\u0016\u0010%\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0017J\u0016\u0010&\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0019J\u0016\u0010'\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u001bJ\u0018\u0010(\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u001dJ \u0010)\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001fJ\u000e\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\nJ\u001f\u0010,\u001a\u00020!2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130.\"\u00020\u0013¢\u0006\u0002\u0010/J\u0006\u00100\u001a\u00020!J\u000e\u00101\u001a\u00020!2\u0006\u0010+\u001a\u00020\nR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/contentsquare/android/core/features/preferences/PreferencesStore;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "oldPrefsMigration", "Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration;", "(Landroid/content/Context;Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration;)V", "listeners", "", "Lcom/contentsquare/android/core/features/preferences/PreferencesStore$PreferencesStoreListener;", "", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "contains", "key", "Lcom/contentsquare/android/core/features/preferences/PreferencesKey;", "getBoolean", "defValue", "getFloat", "", "getInt", "", "getLong", "", "getString", "", "getStringSet", "", "onSharedPreferenceChanged", "", "sharedPreferences", "putBoolean", "value", "putFloat", "putInt", "putLong", "putString", "putStringSet", "registerOnChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "keys", "", "([Lcom/contentsquare/android/core/features/preferences/PreferencesKey;)V", "removeGdprKeys", "unregisterOnChangedListener", "Companion", "DefaultValue", "PreferencesStoreListener", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPreferencesStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferencesStore.kt\ncom/contentsquare/android/core/features/preferences/PreferencesStore\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,275:1\n1#2:276\n3792#3:277\n4307#3,2:278\n1855#4,2:280\n1855#4,2:282\n*S KotlinDebug\n*F\n+ 1 PreferencesStore.kt\ncom/contentsquare/android/core/features/preferences/PreferencesStore\n*L\n245#1:277\n245#1:278,2\n246#1:280,2\n260#1:282,2\n*E\n"})
/* loaded from: classes2.dex */
public final class PreferencesStore implements SharedPreferences.OnSharedPreferenceChangeListener {

    @NotNull
    public static final String CS_SHARED_PREFS_FILE_NAME = "CONTENTSQUARE_SHARED_PREFS";

    @NotNull
    private final Map<PreferencesStoreListener, Boolean> listeners;

    @NotNull
    private final Logger logger;
    private final SharedPreferences sharedPref;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/contentsquare/android/core/features/preferences/PreferencesStore$DefaultValue;", "", "()V", "SCREEN_NUMBER", "", "SCREEN_TIMESTAMP", "", "SESSION_ID", "SR_URL_PRESET_FROM_CONFIG", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultValue {

        @NotNull
        public static final DefaultValue INSTANCE = new DefaultValue();
        public static final int SCREEN_NUMBER = 0;
        public static final long SCREEN_TIMESTAMP = 0;
        public static final int SESSION_ID = 1;

        @NotNull
        public static final String SR_URL_PRESET_FROM_CONFIG = "from_configuration";

        private DefaultValue() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/preferences/PreferencesStore$PreferencesStoreListener;", "", "onPreferenceChanged", "", "key", "Lcom/contentsquare/android/core/features/preferences/PreferencesKey;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PreferencesStoreListener {
        void onPreferenceChanged(PreferencesKey key);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreferencesStore(Context applicationContext) {
        this(applicationContext, new OldPrefsMigration());
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
    }

    public final boolean contains(PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPref.contains(key.name());
    }

    public final boolean getBoolean(PreferencesKey key, boolean defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPref.getBoolean(key.name(), defValue);
    }

    public final float getFloat(PreferencesKey key, float defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPref.getFloat(key.name(), defValue);
    }

    public final int getInt(PreferencesKey key, int defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPref.getInt(key.name(), defValue);
    }

    public final long getLong(PreferencesKey key, long defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPref.getLong(key.name(), defValue);
    }

    @Nullable
    public final String getString(PreferencesKey key, String defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPref.getString(key.name(), defValue);
    }

    @Nullable
    public final Set<String> getStringSet(PreferencesKey key, Set<String> defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPref.getStringSet(key.name(), defValue);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Logger logger;
        String str;
        HashSet hashSet;
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        if (key != null) {
            try {
                PreferencesKey preferencesKeyValueOf = PreferencesKey.valueOf(key);
                synchronized (this.listeners) {
                    hashSet = CollectionsKt.toHashSet(this.listeners.keySet());
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((PreferencesStoreListener) it.next()).onPreferenceChanged(preferencesKeyValueOf);
                }
            } catch (IllegalArgumentException e) {
                e = e;
                logger = this.logger;
                str = "Key '" + key + "' is not a preference store entry";
                logger.w(e, str);
            } catch (ConcurrentModificationException e2) {
                e = e2;
                logger = this.logger;
                str = "ConcurrentModificationException during PreferenceStore listener call";
                logger.w(e, str);
            }
        }
    }

    public final void putBoolean(PreferencesKey key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPref.edit().putBoolean(key.name(), value).apply();
    }

    public final void putFloat(PreferencesKey key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPref.edit().putFloat(key.name(), value).apply();
    }

    public final void putInt(PreferencesKey key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPref.edit().putInt(key.name(), value).apply();
    }

    public final void putLong(PreferencesKey key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPref.edit().putLong(key.name(), value).apply();
    }

    public final void putString(PreferencesKey key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPref.edit().putString(key.name(), value).apply();
    }

    public final void putStringSet(PreferencesKey key, Set<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPref.edit().putStringSet(key.name(), value).apply();
    }

    public final void registerOnChangedListener(PreferencesStoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            this.listeners.put(listener, Boolean.TRUE);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void remove(PreferencesKey... keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        SharedPreferences.Editor editorEdit = this.sharedPref.edit();
        for (PreferencesKey preferencesKey : keys) {
            editorEdit.remove(preferencesKey.name());
        }
        editorEdit.apply();
    }

    public final void removeGdprKeys() {
        SharedPreferences.Editor editorEdit = this.sharedPref.edit();
        PreferencesKey[] preferencesKeyArrValues = PreferencesKey.values();
        ArrayList arrayList = new ArrayList();
        for (PreferencesKey preferencesKey : preferencesKeyArrValues) {
            if (preferencesKey.getIsGdpr()) {
                arrayList.add(preferencesKey);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove(((PreferencesKey) it.next()).name());
        }
        editorEdit.apply();
    }

    public final void unregisterOnChangedListener(PreferencesStoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            this.listeners.remove(listener);
        }
    }

    @VisibleForTesting
    public PreferencesStore(Context applicationContext, OldPrefsMigration oldPrefsMigration) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(oldPrefsMigration, "oldPrefsMigration");
        SharedPreferences sharedPref = applicationContext.getSharedPreferences(CS_SHARED_PREFS_FILE_NAME, 0);
        this.sharedPref = sharedPref;
        this.listeners = new WeakHashMap();
        this.logger = new Logger("PreferencesStore");
        Intrinsics.checkNotNullExpressionValue(sharedPref, "sharedPref");
        oldPrefsMigration.migrateIfNeeded(applicationContext, sharedPref);
        sharedPref.registerOnSharedPreferenceChangeListener(this);
    }
}

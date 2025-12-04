package com.disney.id.android.localdata;

import android.content.Context;
import android.content.SharedPreferences;
import com.disney.id.android.dagger.OneIDDagger;
import com.urbanairship.channel.AttributeMutation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u00030\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016J!\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/disney/id/android/localdata/OneIDExposedStorage;", "Lcom/disney/id/android/localdata/ExposedStorage;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPrefs", "Landroid/content/SharedPreferences;", "contains", "", "key", "", "getAll", "", "getBoolean", "defValue", "getLong", "", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getOptionalBoolean", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getString", "putBoolean", "", "value", "putLong", "putString", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDExposedStorage implements ExposedStorage {
    private SharedPreferences sharedPrefs;

    public OneIDExposedStorage(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        OneIDDagger.getComponent().inject(this);
        SharedPreferences sharedPreferences = appContext.getSharedPreferences("oneid_shared_prefs", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPrefs = sharedPreferences;
    }

    @Override // com.disney.id.android.localdata.ExposedStorage
    public boolean contains(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPrefs.contains(key);
    }

    @Override // com.disney.id.android.localdata.ExposedStorage
    public boolean getBoolean(@NotNull String key, boolean defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPrefs.getBoolean(key, defValue);
    }

    @Override // com.disney.id.android.localdata.ExposedStorage
    @Nullable
    public Boolean getOptionalBoolean(@NotNull String key, @Nullable Boolean defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return this.sharedPrefs.contains(key) ? Boolean.valueOf(this.sharedPrefs.getBoolean(key, Intrinsics.areEqual(defValue, Boolean.TRUE))) : defValue;
        } catch (ClassCastException unused) {
            return defValue;
        }
    }

    @Override // com.disney.id.android.localdata.ExposedStorage
    public void putBoolean(@NotNull String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPrefs.edit().putBoolean(key, value).apply();
    }

    @Override // com.disney.id.android.localdata.ExposedStorage
    @Nullable
    public String getString(@NotNull String key, @Nullable String defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPrefs.getString(key, defValue);
    }

    @Override // com.disney.id.android.localdata.ExposedStorage
    public void putString(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.sharedPrefs.edit().putString(key, value).apply();
    }

    @Override // com.disney.id.android.localdata.ExposedStorage
    @Nullable
    public Long getLong(@NotNull String key, @Nullable Long defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPrefs.contains(key) ? Long.valueOf(this.sharedPrefs.getLong(key, 0L)) : defValue;
    }

    @Override // com.disney.id.android.localdata.ExposedStorage
    public void putLong(@NotNull String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPrefs.edit().putLong(key, value).apply();
    }

    @Override // com.disney.id.android.localdata.ExposedStorage
    public void remove(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPrefs.edit().remove(key).apply();
    }

    @Override // com.disney.id.android.localdata.ExposedStorage
    @NotNull
    public Map<String, ?> getAll() {
        Map<String, ?> all = this.sharedPrefs.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        return all;
    }
}

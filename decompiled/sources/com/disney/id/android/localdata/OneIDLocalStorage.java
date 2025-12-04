package com.disney.id.android.localdata;

import android.content.Context;
import android.content.SharedPreferences;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.urbanairship.channel.AttributeMutation;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u000e\u0012\u0002\b\u00030\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/disney/id/android/localdata/OneIDLocalStorage;", "Lcom/disney/id/android/localdata/LocalStorage;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "sharedPrefs", "Landroid/content/SharedPreferences;", "get", "", "key", "getAll", "", "put", "", "value", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDLocalStorage implements LocalStorage {
    private static final String TAG = OneIDLocalStorage.class.getSimpleName();

    @Inject
    public Logger logger;
    private SharedPreferences sharedPrefs;

    public OneIDLocalStorage(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        OneIDDagger.getComponent().inject(this);
        this.sharedPrefs = EncryptedSharedPreferences.INSTANCE.getSharedPreferences(appContext, "oneid_storage");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Local storage initialized", null, 4, null);
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @Override // com.disney.id.android.localdata.LocalStorage
    @Nullable
    public String get(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Retrieve value // " + key, null, 4, null);
        return this.sharedPrefs.getString(key, null);
    }

    @Override // com.disney.id.android.localdata.LocalStorage
    public void put(@NotNull String key, @Nullable String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Store value // " + key, null, 4, null);
        this.sharedPrefs.edit().putString(key, value).apply();
    }

    @Override // com.disney.id.android.localdata.LocalStorage
    public void remove(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Remove value // " + key, null, 4, null);
        this.sharedPrefs.edit().remove(key).apply();
    }

    @Override // com.disney.id.android.localdata.LocalStorage
    @NotNull
    public Map<String, ?> getAll() {
        Map<String, ?> all = this.sharedPrefs.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        return all;
    }
}

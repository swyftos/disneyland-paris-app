package com.urbanairship.modules.debug;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.modules.Module;
import com.urbanairship.remotedata.RemoteData;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface DebugModuleFactory extends AirshipVersionInfo {
    @NonNull
    Module build(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull RemoteData remoteData);
}

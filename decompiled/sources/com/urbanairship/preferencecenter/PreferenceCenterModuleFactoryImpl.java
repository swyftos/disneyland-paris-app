package com.urbanairship.preferencecenter;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.inputvalidation.AirshipInputValidation;
import com.urbanairship.modules.Module;
import com.urbanairship.modules.preferencecenter.PreferenceCenterModuleFactory;
import com.urbanairship.remotedata.RemoteData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/preferencecenter/PreferenceCenterModuleFactoryImpl;", "Lcom/urbanairship/modules/preferencecenter/PreferenceCenterModuleFactory;", "()V", "airshipVersion", "", "getAirshipVersion", "()Ljava/lang/String;", "packageVersion", "getPackageVersion", "build", "Lcom/urbanairship/modules/Module;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "remoteData", "Lcom/urbanairship/remotedata/RemoteData;", "inputValidator", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class PreferenceCenterModuleFactoryImpl implements PreferenceCenterModuleFactory {
    @Override // com.urbanairship.modules.preferencecenter.PreferenceCenterModuleFactory
    @NotNull
    public Module build(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull PrivacyManager privacyManager, @NotNull RemoteData remoteData, @NotNull AirshipInputValidation.Validator inputValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        Intrinsics.checkNotNullParameter(inputValidator, "inputValidator");
        Module moduleSingleComponent = Module.singleComponent(new PreferenceCenter(context, dataStore, privacyManager, remoteData, inputValidator), R.xml.ua_preference_center_actions);
        Intrinsics.checkNotNullExpressionValue(moduleSingleComponent, "singleComponent(...)");
        return moduleSingleComponent;
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NotNull
    public String getAirshipVersion() {
        return "19.9.1";
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NotNull
    public String getPackageVersion() {
        return com.urbanairship.BuildConfig.SDK_VERSION;
    }
}

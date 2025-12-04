package com.allegion.accesssdk.enums;

import com.allegion.accesshub.interfaces.IAlMAHEnvironment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;", "Lcom/allegion/accesshub/interfaces/IAlMAHEnvironment;", "", "getAppCenterAppId", "()Ljava/lang/String;", "appCenterAppId", "", "getTrackCrashes", "()Z", "trackCrashes", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IAlSdkEnvironment extends IAlMAHEnvironment {
    @NotNull
    String getAppCenterAppId();

    boolean getTrackCrashes();
}

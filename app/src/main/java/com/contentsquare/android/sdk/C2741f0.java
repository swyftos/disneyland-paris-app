package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.utils.BuildInformation;
import com.contentsquare.android.core.utils.ExtensionsKt;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.f0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2741f0 extends Lambda implements Function0<EnumC2551L4> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2472D5 f2590a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ BuildInformation f2591b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2741f0(C2472D5 c2472d5, BuildInformation buildInformation) {
        super(0);
        this.f2590a = c2472d5;
        this.f2591b = buildInformation;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EnumC2551L4 invoke() {
        JsonConfig.SessionReplay sessionReplay;
        JsonConfig.ProjectConfiguration projectConfig = this.f2590a.f1520b.getProjectConfig();
        List<String> blockedAppVersions = (projectConfig == null || (sessionReplay = projectConfig.getSessionReplay()) == null) ? null : sessionReplay.getBlockedAppVersions();
        return (blockedAppVersions == null || ExtensionsKt.isVersionBlocked(this.f2591b.getApplicationVersion(), blockedAppVersions)) ? EnumC2551L4.PROPAGATE_STOP : EnumC2551L4.EVALUATE;
    }
}

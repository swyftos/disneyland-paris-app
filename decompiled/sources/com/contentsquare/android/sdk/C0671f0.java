package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.utils.BuildInformation;
import com.contentsquare.android.core.utils.ExtensionsKt;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.f0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0671f0 extends Lambda implements Function0<L4> {
    public final /* synthetic */ D5 a;
    public final /* synthetic */ BuildInformation b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0671f0(D5 d5, BuildInformation buildInformation) {
        super(0);
        this.a = d5;
        this.b = buildInformation;
    }

    @Override // kotlin.jvm.functions.Function0
    public final L4 invoke() {
        JsonConfig.SessionReplay sessionReplay;
        JsonConfig.ProjectConfiguration projectConfig = this.a.b.getProjectConfig();
        List<String> blockedAppVersions = (projectConfig == null || (sessionReplay = projectConfig.getSessionReplay()) == null) ? null : sessionReplay.getBlockedAppVersions();
        return (blockedAppVersions == null || ExtensionsKt.isVersionBlocked(this.b.getApplicationVersion(), blockedAppVersions)) ? L4.PROPAGATE_STOP : L4.EVALUATE;
    }
}

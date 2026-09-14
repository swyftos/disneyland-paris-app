package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.w8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2919w8 extends Lambda implements Function0<EnumC2551L4> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2472D5 f3217a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2919w8(C2472D5 c2472d5) {
        super(0);
        this.f3217a = c2472d5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EnumC2551L4 invoke() {
        JsonConfig.SessionReplay sessionReplay;
        JsonConfig.ProjectConfiguration projectConfig = this.f3217a.f1520b.getProjectConfig();
        if ((projectConfig != null ? projectConfig.getCsProjectId() : 0) != 0) {
            JsonConfig.ProjectConfiguration projectConfig2 = this.f3217a.f1520b.getProjectConfig();
            String endpoint = (projectConfig2 == null || (sessionReplay = projectConfig2.getSessionReplay()) == null) ? null : sessionReplay.getEndpoint();
            if (endpoint == null) {
                endpoint = "";
            }
            if (endpoint.length() > 0) {
                return EnumC2551L4.EVALUATE;
            }
        }
        return EnumC2551L4.BREAK;
    }
}

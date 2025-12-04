package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class w8 extends Lambda implements Function0<L4> {
    public final /* synthetic */ D5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w8(D5 d5) {
        super(0);
        this.a = d5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final L4 invoke() {
        JsonConfig.SessionReplay sessionReplay;
        JsonConfig.ProjectConfiguration projectConfig = this.a.b.getProjectConfig();
        if ((projectConfig != null ? projectConfig.getCsProjectId() : 0) != 0) {
            JsonConfig.ProjectConfiguration projectConfig2 = this.a.b.getProjectConfig();
            String endpoint = (projectConfig2 == null || (sessionReplay = projectConfig2.getSessionReplay()) == null) ? null : sessionReplay.getEndpoint();
            if (endpoint == null) {
                endpoint = "";
            }
            if (endpoint.length() > 0) {
                return L4.EVALUATE;
            }
        }
        return L4.BREAK;
    }
}

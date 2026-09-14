package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.A6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2443A6 extends Lambda implements Function0<String> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2453B6 f1413a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2443A6(C2453B6 c2453b6) {
        super(0);
        this.f1413a = c2453b6;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        JsonConfig.StaticResourceManager staticResourceManager;
        JsonConfig.ProjectConfiguration projectConfig = this.f1413a.f1446b.getProjectConfig();
        String endpoint = (projectConfig == null || (staticResourceManager = projectConfig.getStaticResourceManager()) == null) ? null : staticResourceManager.getEndpoint();
        return endpoint == null ? "" : endpoint;
    }
}

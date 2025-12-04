package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class A6 extends Lambda implements Function0<String> {
    public final /* synthetic */ B6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A6(B6 b6) {
        super(0);
        this.a = b6;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        JsonConfig.StaticResourceManager staticResourceManager;
        JsonConfig.ProjectConfiguration projectConfig = this.a.b.getProjectConfig();
        String endpoint = (projectConfig == null || (staticResourceManager = projectConfig.getStaticResourceManager()) == null) ? null : staticResourceManager.getEndpoint();
        return endpoint == null ? "" : endpoint;
    }
}

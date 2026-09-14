package com.contentsquare.android.sdk;

import android.app.Application;
import android.content.Context;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.J6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2533J6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final DeviceInfo f1758a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final JsonConfig.ProjectConfiguration f1759b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2702b1 f1760c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Context f1761d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final HashMap<String, Object> f1762e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final Logger f1763f;

    public C2533J6(@NotNull DeviceInfo deviceInfo, @Nullable JsonConfig.ProjectConfiguration projectConfiguration, @NotNull C2702b1 dependenciesScanner, @NotNull Application context) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(dependenciesScanner, "dependenciesScanner");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1758a = deviceInfo;
        this.f1759b = projectConfiguration;
        this.f1760c = dependenciesScanner;
        this.f1761d = context;
        this.f1762e = new HashMap<>();
        this.f1763f = new Logger("StaticCollector");
    }
}

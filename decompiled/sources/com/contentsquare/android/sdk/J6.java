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

/* loaded from: classes2.dex */
public final class J6 {

    @NotNull
    public final DeviceInfo a;

    @Nullable
    public final JsonConfig.ProjectConfiguration b;

    @NotNull
    public final C0632b1 c;

    @NotNull
    public final Context d;

    @NotNull
    public final HashMap<String, Object> e;

    @NotNull
    public final Logger f;

    public J6(@NotNull DeviceInfo deviceInfo, @Nullable JsonConfig.ProjectConfiguration projectConfiguration, @NotNull C0632b1 dependenciesScanner, @NotNull Application context) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(dependenciesScanner, "dependenciesScanner");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = deviceInfo;
        this.b = projectConfiguration;
        this.c = dependenciesScanner;
        this.d = context;
        this.e = new HashMap<>();
        this.f = new Logger("StaticCollector");
    }
}

package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.BuildInformation;
import com.contentsquare.android.internal.features.srm.SrmKeysCache;
import java.util.LinkedHashSet;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nStaticResourceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaticResourceManager.kt\ncom/contentsquare/android/internal/features/srm/StaticResourceManager\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,133:1\n1295#2,2:134\n*S KotlinDebug\n*F\n+ 1 StaticResourceManager.kt\ncom/contentsquare/android/internal/features/srm/StaticResourceManager\n*L\n91#1:134,2\n*E\n"})
/* loaded from: classes2.dex */
public final class M6 {

    @NotNull
    public final B6 a;

    @NotNull
    public final SrmKeysCache b;

    @NotNull
    public final C0872z6 c;
    public final int d;

    @NotNull
    public final Configuration e;

    @NotNull
    public final Logger f;

    @NotNull
    public final F6 g;

    @NotNull
    public final CoroutineScope h;

    @NotNull
    public final LinkedHashSet i;

    @JvmOverloads
    public M6(@NotNull B6 srmHttpClient, @NotNull SrmKeysCache srmKeysCache, @NotNull C0872z6 srmFileStorage, @NotNull Configuration configuration, @NotNull BuildInformation buildInformation) {
        Intrinsics.checkNotNullParameter(srmHttpClient, "srmHttpClient");
        Intrinsics.checkNotNullParameter(srmKeysCache, "srmKeysCache");
        Intrinsics.checkNotNullParameter(srmFileStorage, "srmFileStorage");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        Logger logger = new Logger("StaticResourceManager");
        F6 splitter = new F6(buildInformation.getApplicationVersion());
        Intrinsics.checkNotNullParameter(srmHttpClient, "srmHttpClient");
        Intrinsics.checkNotNullParameter(srmKeysCache, "srmKeysCache");
        Intrinsics.checkNotNullParameter(srmFileStorage, "srmFileStorage");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(splitter, "splitter");
        this.a = srmHttpClient;
        this.b = srmKeysCache;
        this.c = srmFileStorage;
        this.d = 1;
        this.e = configuration;
        this.f = logger;
        this.g = splitter;
        this.h = CoroutineScopeKt.CoroutineScope(ThreadPoolDispatcherKt.newSingleThreadContext("StaticResourceManager-BackgroundThread"));
        this.i = new LinkedHashSet();
        BuildersKt__Builders_commonKt.launch$default(srmKeysCache.h, null, null, new C6(srmKeysCache, null), 3, null);
    }
}

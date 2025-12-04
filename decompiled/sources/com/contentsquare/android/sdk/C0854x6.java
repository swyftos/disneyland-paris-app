package com.contentsquare.android.sdk;

import android.net.Uri;
import com.contentsquare.android.core.communication.HeapInterface;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.utils.BuildInformation;
import com.contentsquare.android.core.utils.ConstantsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSrUrlGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SrUrlGenerator.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/SrUrlGenerator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,93:1\n1855#2,2:94\n*S KotlinDebug\n*F\n+ 1 SrUrlGenerator.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/SrUrlGenerator\n*L\n68#1:94,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.x6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0854x6 {

    @NotNull
    public final D5 a;

    @NotNull
    public final C0742m1 b;

    @NotNull
    public final L7 c;

    @NotNull
    public final List<J7> d;

    @Nullable
    public final HeapInterface e;

    @NotNull
    public final BuildInformation f;

    @NotNull
    public String g;
    public int h;

    /* JADX WARN: Multi-variable type inference failed */
    public C0854x6(@NotNull D5 configuration, @NotNull C0742m1 endpointResolver, @NotNull L7 userId, @NotNull List<? extends J7> urlParameterProviders, @Nullable HeapInterface heapInterface, @NotNull BuildInformation buildInformation) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(endpointResolver, "endpointResolver");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(urlParameterProviders, "urlParameterProviders");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        this.a = configuration;
        this.b = endpointResolver;
        this.c = userId;
        this.d = urlParameterProviders;
        this.e = heapInterface;
        this.f = buildInformation;
        this.g = userId.a();
        this.h = 1;
    }

    @NotNull
    public final synchronized String a(@NotNull N5 sessionState) {
        String string;
        HeapInterface.HeapMetadata heapMetadata;
        try {
            Intrinsics.checkNotNullParameter(sessionState, "sessionState");
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            mapCreateMapBuilder.put("uu", this.g);
            mapCreateMapBuilder.put("rt", "5");
            mapCreateMapBuilder.put("v", this.f.getSdkVersion());
            mapCreateMapBuilder.put("av", this.f.getApplicationVersion());
            mapCreateMapBuilder.put("ri", String.valueOf(this.h));
            mapCreateMapBuilder.put(ConstantsKt.QUERY_PARAM_HAS_LAST_MESSAGE, String.valueOf(sessionState.c == 1));
            JsonConfig.ProjectConfiguration projectConfig = this.a.b.getProjectConfig();
            mapCreateMapBuilder.put("pid", String.valueOf(projectConfig != null ? projectConfig.getCsProjectId() : 0));
            mapCreateMapBuilder.put("sn", String.valueOf(sessionState.a));
            mapCreateMapBuilder.put("pn", String.valueOf(sessionState.b));
            HeapInterface heapInterface = this.e;
            if (heapInterface != null && (heapMetadata = heapInterface.getHeapMetadata()) != null) {
                mapCreateMapBuilder.put(HeapInterface.HEAP_APP_ID, String.valueOf(heapMetadata.getAppId()));
                mapCreateMapBuilder.put(HeapInterface.HEAP_SESSION_ID, String.valueOf(heapMetadata.getSessionId()));
            }
            Iterator<T> it = this.d.iterator();
            while (it.hasNext()) {
                Pair<String, String> pairA = ((J7) it.next()).a();
                mapCreateMapBuilder.put(pairA.component1(), pairA.component2());
            }
            Map mapBuild = MapsKt.build(mapCreateMapBuilder);
            this.h++;
            this.g = this.c.a();
            if (sessionState.c == 1) {
                this.h = 1;
            }
            Uri.Builder builderBuildUpon = Uri.parse(this.b.a).buildUpon();
            for (Map.Entry entry : mapBuild.entrySet()) {
                builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            string = builderBuildUpon.toString();
            Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        } catch (Throwable th) {
            throw th;
        }
        return string;
    }
}

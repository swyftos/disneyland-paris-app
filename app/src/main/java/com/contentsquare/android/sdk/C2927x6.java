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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.x6 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSrUrlGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SrUrlGenerator.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/SrUrlGenerator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,93:1\n1855#2,2:94\n*S KotlinDebug\n*F\n+ 1 SrUrlGenerator.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/SrUrlGenerator\n*L\n68#1:94,2\n*E\n"})
public final class C2927x6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2472D5 f3235a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2812m1 f3236b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2554L7 f3237c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final List<InterfaceC2534J7> f3238d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final HeapInterface f3239e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final BuildInformation f3240f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public String f3241g;

    /* JADX INFO: renamed from: h */
    public int f3242h;

    /* JADX WARN: Multi-variable type inference failed */
    public C2927x6(@NotNull C2472D5 configuration, @NotNull C2812m1 endpointResolver, @NotNull C2554L7 userId, @NotNull List<? extends InterfaceC2534J7> urlParameterProviders, @Nullable HeapInterface heapInterface, @NotNull BuildInformation buildInformation) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(endpointResolver, "endpointResolver");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(urlParameterProviders, "urlParameterProviders");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        this.f3235a = configuration;
        this.f3236b = endpointResolver;
        this.f3237c = userId;
        this.f3238d = urlParameterProviders;
        this.f3239e = heapInterface;
        this.f3240f = buildInformation;
        this.f3241g = userId.m979a();
        this.f3242h = 1;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final synchronized String m1234a(@NotNull C2572N5 sessionState) {
        String string;
        HeapInterface.HeapMetadata heapMetadata;
        try {
            Intrinsics.checkNotNullParameter(sessionState, "sessionState");
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            mapCreateMapBuilder.put("uu", this.f3241g);
            mapCreateMapBuilder.put("rt", "5");
            mapCreateMapBuilder.put("v", this.f3240f.getSdkVersion());
            mapCreateMapBuilder.put("av", this.f3240f.getApplicationVersion());
            mapCreateMapBuilder.put("ri", String.valueOf(this.f3242h));
            mapCreateMapBuilder.put(ConstantsKt.QUERY_PARAM_HAS_LAST_MESSAGE, String.valueOf(sessionState.f1889c == 1));
            JsonConfig.ProjectConfiguration projectConfig = this.f3235a.f1520b.getProjectConfig();
            mapCreateMapBuilder.put("pid", String.valueOf(projectConfig != null ? projectConfig.getCsProjectId() : 0));
            mapCreateMapBuilder.put("sn", String.valueOf(sessionState.f1887a));
            mapCreateMapBuilder.put("pn", String.valueOf(sessionState.f1888b));
            HeapInterface heapInterface = this.f3239e;
            if (heapInterface != null && (heapMetadata = heapInterface.getHeapMetadata()) != null) {
                mapCreateMapBuilder.put(HeapInterface.HEAP_APP_ID, String.valueOf(heapMetadata.getAppId()));
                mapCreateMapBuilder.put(HeapInterface.HEAP_SESSION_ID, String.valueOf(heapMetadata.getSessionId()));
            }
            Iterator<T> it = this.f3238d.iterator();
            while (it.hasNext()) {
                Pair<String, String> pairMo938a = ((InterfaceC2534J7) it.next()).mo938a();
                mapCreateMapBuilder.put(pairMo938a.component1(), pairMo938a.component2());
            }
            Map mapBuild = MapsKt.build(mapCreateMapBuilder);
            this.f3242h++;
            this.f3241g = this.f3237c.m979a();
            if (sessionState.f1889c == 1) {
                this.f3242h = 1;
            }
            Uri.Builder builderBuildUpon = Uri.parse(this.f3236b.f2872a).buildUpon();
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

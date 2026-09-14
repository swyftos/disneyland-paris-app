package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.proto.replayproperties.p022v1.ReplayPropertiesKt;
import com.contentsquare.proto.replayproperties.p022v1.ReplayPropertiesV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.G5 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSessionReplayProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionReplayProperties.kt\ncom/contentsquare/android/internal/features/sessionreplay/SessionReplayProperties\n+ 2 ReplayPropertiesKt.kt\ncom/contentsquare/proto/replayproperties/v1/ReplayPropertiesKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n11#2:49\n1#3:50\n*S KotlinDebug\n*F\n+ 1 SessionReplayProperties.kt\ncom/contentsquare/android/internal/features/sessionreplay/SessionReplayProperties\n*L\n23#1:49\n23#1:50\n*E\n"})
public final class C2502G5 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f1653a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Configuration f1654b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2554L7 f1655c;

    public C2502G5(@NotNull Configuration configuration, @NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f1653a = preferencesStore;
        this.f1654b = configuration;
        this.f1655c = new C2554L7(preferencesStore);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final ReplayPropertiesV1.ReplayProperties m925a(long j) {
        ReplayPropertiesKt.Dsl.Companion companion = ReplayPropertiesKt.Dsl.INSTANCE;
        ReplayPropertiesV1.ReplayProperties.Builder builderNewBuilder = ReplayPropertiesV1.ReplayProperties.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ReplayPropertiesKt.Dsl dsl_create = companion._create(builderNewBuilder);
        JsonConfig.ProjectConfiguration projectConfig = this.f1654b.getProjectConfig();
        dsl_create.setProjectId(projectConfig != null ? projectConfig.getCsProjectId() : 0);
        dsl_create.setVisitorId(this.f1655c.m979a());
        dsl_create.setSessionNumber(this.f1653a.getInt(PreferencesKey.SESSION_ID, 1));
        dsl_create.setPageviewNumber(this.f1653a.getInt(PreferencesKey.SCREEN_NUMBER, 0));
        long j2 = this.f1653a.getLong(PreferencesKey.SCREEN_TIMESTAMP, 0L);
        dsl_create.setRelativeTimeMs(j2 != 0 ? j - j2 : 0L);
        return dsl_create._build();
    }
}

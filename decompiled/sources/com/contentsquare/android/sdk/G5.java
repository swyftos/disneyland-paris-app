package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.proto.replayproperties.v1.ReplayPropertiesKt;
import com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSessionReplayProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionReplayProperties.kt\ncom/contentsquare/android/internal/features/sessionreplay/SessionReplayProperties\n+ 2 ReplayPropertiesKt.kt\ncom/contentsquare/proto/replayproperties/v1/ReplayPropertiesKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n11#2:49\n1#3:50\n*S KotlinDebug\n*F\n+ 1 SessionReplayProperties.kt\ncom/contentsquare/android/internal/features/sessionreplay/SessionReplayProperties\n*L\n23#1:49\n23#1:50\n*E\n"})
/* loaded from: classes2.dex */
public final class G5 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final Configuration b;

    @NotNull
    public final L7 c;

    public G5(@NotNull Configuration configuration, @NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.a = preferencesStore;
        this.b = configuration;
        this.c = new L7(preferencesStore);
    }

    @NotNull
    public final ReplayPropertiesV1.ReplayProperties a(long j) {
        ReplayPropertiesKt.Dsl.Companion companion = ReplayPropertiesKt.Dsl.INSTANCE;
        ReplayPropertiesV1.ReplayProperties.Builder builderNewBuilder = ReplayPropertiesV1.ReplayProperties.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ReplayPropertiesKt.Dsl dsl_create = companion._create(builderNewBuilder);
        JsonConfig.ProjectConfiguration projectConfig = this.b.getProjectConfig();
        dsl_create.setProjectId(projectConfig != null ? projectConfig.getCsProjectId() : 0);
        dsl_create.setVisitorId(this.c.a());
        dsl_create.setSessionNumber(this.a.getInt(PreferencesKey.SESSION_ID, 1));
        dsl_create.setPageviewNumber(this.a.getInt(PreferencesKey.SCREEN_NUMBER, 0));
        long j2 = this.a.getLong(PreferencesKey.SCREEN_TIMESTAMP, 0L);
        dsl_create.setRelativeTimeMs(j2 != 0 ? j - j2 : 0L);
        return dsl_create._build();
    }
}

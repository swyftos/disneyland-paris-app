package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.BuildInformation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.D5 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSessionReplayConfiguration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionReplayConfiguration.kt\ncom/contentsquare/android/internal/features/sessionreplay/SessionReplayConfiguration\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,90:1\n1747#2,3:91\n1747#2,3:94\n*S KotlinDebug\n*F\n+ 1 SessionReplayConfiguration.kt\ncom/contentsquare/android/internal/features/sessionreplay/SessionReplayConfiguration\n*L\n85#1:91,3\n87#1:94,3\n*E\n"})
public final class C2472D5 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f1519a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Configuration f1520b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final BuildInformation f1521c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public a f1522d;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.D5$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final boolean f1523a;

        /* JADX INFO: renamed from: b */
        public final int f1524b;

        public a(int i, boolean z) {
            this.f1523a = z;
            this.f1524b = i;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1523a == aVar.f1523a && this.f1524b == aVar.f1524b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        public final int hashCode() {
            boolean z = this.f1523a;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return Integer.hashCode(this.f1524b) + (r0 * 31);
        }

        @NotNull
        public final String toString() {
            return "RemoteForceMaskingCache(isRemoteForceMaskEnabled=" + this.f1523a + ", hash=" + this.f1524b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public C2472D5(@NotNull PreferencesStore preferenceStore, @NotNull Configuration configuration, @NotNull BuildInformation buildInformation) {
        Intrinsics.checkNotNullParameter(preferenceStore, "preferenceStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        this.f1519a = preferenceStore;
        this.f1520b = configuration;
        this.f1521c = buildInformation;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m898a() {
        JsonConfig.SessionReplay sessionReplay;
        JsonConfig.ProjectConfiguration projectConfig = this.f1520b.getProjectConfig();
        if (projectConfig == null || (sessionReplay = projectConfig.getSessionReplay()) == null) {
            return false;
        }
        return sessionReplay.getEtrEnabled();
    }
}

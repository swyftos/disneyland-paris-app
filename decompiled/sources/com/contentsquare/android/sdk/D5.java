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

@SourceDebugExtension({"SMAP\nSessionReplayConfiguration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionReplayConfiguration.kt\ncom/contentsquare/android/internal/features/sessionreplay/SessionReplayConfiguration\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,90:1\n1747#2,3:91\n1747#2,3:94\n*S KotlinDebug\n*F\n+ 1 SessionReplayConfiguration.kt\ncom/contentsquare/android/internal/features/sessionreplay/SessionReplayConfiguration\n*L\n85#1:91,3\n87#1:94,3\n*E\n"})
/* loaded from: classes2.dex */
public final class D5 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final Configuration b;

    @NotNull
    public final BuildInformation c;

    @Nullable
    public a d;

    public static final class a {
        public final boolean a;
        public final int b;

        public a(int i, boolean z) {
            this.a = z;
            this.b = i;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        public final int hashCode() {
            boolean z = this.a;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return Integer.hashCode(this.b) + (r0 * 31);
        }

        @NotNull
        public final String toString() {
            return "RemoteForceMaskingCache(isRemoteForceMaskEnabled=" + this.a + ", hash=" + this.b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public D5(@NotNull PreferencesStore preferenceStore, @NotNull Configuration configuration, @NotNull BuildInformation buildInformation) {
        Intrinsics.checkNotNullParameter(preferenceStore, "preferenceStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        this.a = preferenceStore;
        this.b = configuration;
        this.c = buildInformation;
    }

    public final boolean a() {
        JsonConfig.SessionReplay sessionReplay;
        JsonConfig.ProjectConfiguration projectConfig = this.b.getProjectConfig();
        if (projectConfig == null || (sessionReplay = projectConfig.getSessionReplay()) == null) {
            return false;
        }
        return sessionReplay.getEtrEnabled();
    }
}

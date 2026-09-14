package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2686Z4 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$a */
    public static final class a extends AbstractC2686Z4 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final b f2328a;

        /* JADX INFO: renamed from: b */
        @NotNull
        public final String f2329b;

        public a(@NotNull b failureReason, @NotNull String screenName) {
            Intrinsics.checkNotNullParameter(failureReason, "failureReason");
            Intrinsics.checkNotNullParameter(screenName, "screenName");
            this.f2328a = failureReason;
            this.f2329b = screenName;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f2328a, aVar.f2328a) && Intrinsics.areEqual(this.f2329b, aVar.f2329b);
        }

        public final int hashCode() {
            return this.f2329b.hashCode() + (this.f2328a.hashCode() * 31);
        }

        @NotNull
        public final String toString() {
            return "Failed(failureReason=" + this.f2328a + ", screenName=" + this.f2329b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$b */
    public static abstract class b {

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$b$a */
        public static final class a extends b {

            /* JADX INFO: renamed from: a */
            @NotNull
            public static final a f2330a = new a();
        }

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$b$b, reason: collision with other inner class name */
        public static final class C8141b extends b {

            /* JADX INFO: renamed from: a */
            @NotNull
            public static final C8141b f2331a = new C8141b();
        }

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$b$c */
        public static final class c extends b {

            /* JADX INFO: renamed from: a */
            @NotNull
            public static final c f2332a = new c();
        }

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$b$d */
        public static final class d extends b {

            /* JADX INFO: renamed from: a */
            @NotNull
            public static final d f2333a = new d();
        }

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$b$e */
        public static final class e extends b {

            /* JADX INFO: renamed from: a */
            @NotNull
            public static final e f2334a = new e();
        }

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$b$f */
        public static final class f extends b {

            /* JADX INFO: renamed from: a */
            @NotNull
            public static final f f2335a = new f();
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$c */
    public static final class c extends AbstractC2686Z4 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public static final c f2336a = new c();
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$d */
    public static final class d extends AbstractC2686Z4 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public static final d f2337a = new d();
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$e */
    public static final class e extends AbstractC2686Z4 {

        /* JADX INFO: renamed from: a */
        public final int f2338a;

        /* JADX INFO: renamed from: b */
        public final int f2339b;

        /* JADX INFO: renamed from: c */
        public final int f2340c;

        public e(int i, int i2) {
            this.f2338a = i;
            this.f2339b = i2;
            this.f2340c = (int) ((100.0f / i2) * (i + 1));
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f2338a == eVar.f2338a && this.f2339b == eVar.f2339b;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f2339b) + (Integer.hashCode(this.f2338a) * 31);
        }

        @NotNull
        public final String toString() {
            return "LongSnapshotProgress(snapshotIndex=" + this.f2338a + ", numberOfSnapshots=" + this.f2339b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$f */
    public static final class f extends AbstractC2686Z4 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public static final f f2341a = new f();
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$g */
    public static final class g extends AbstractC2686Z4 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public static final g f2342a = new g();
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z4$h */
    public static final class h extends AbstractC2686Z4 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final String f2343a;

        public h(@NotNull String screenName) {
            Intrinsics.checkNotNullParameter(screenName, "screenName");
            this.f2343a = screenName;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && Intrinsics.areEqual(this.f2343a, ((h) obj).f2343a);
        }

        public final int hashCode() {
            return this.f2343a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "Success(screenName=" + this.f2343a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}

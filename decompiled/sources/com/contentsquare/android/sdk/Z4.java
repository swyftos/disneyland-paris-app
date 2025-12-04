package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class Z4 {

    public static final class a extends Z4 {

        @NotNull
        public final b a;

        @NotNull
        public final String b;

        public a(@NotNull b failureReason, @NotNull String screenName) {
            Intrinsics.checkNotNullParameter(failureReason, "failureReason");
            Intrinsics.checkNotNullParameter(screenName, "screenName");
            this.a = failureReason;
            this.b = screenName;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.a.hashCode() * 31);
        }

        @NotNull
        public final String toString() {
            return "Failed(failureReason=" + this.a + ", screenName=" + this.b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            @NotNull
            public static final a a = new a();
        }

        /* renamed from: com.contentsquare.android.sdk.Z4$b$b, reason: collision with other inner class name */
        public static final class C0045b extends b {

            @NotNull
            public static final C0045b a = new C0045b();
        }

        public static final class c extends b {

            @NotNull
            public static final c a = new c();
        }

        public static final class d extends b {

            @NotNull
            public static final d a = new d();
        }

        public static final class e extends b {

            @NotNull
            public static final e a = new e();
        }

        public static final class f extends b {

            @NotNull
            public static final f a = new f();
        }
    }

    public static final class c extends Z4 {

        @NotNull
        public static final c a = new c();
    }

    public static final class d extends Z4 {

        @NotNull
        public static final d a = new d();
    }

    public static final class e extends Z4 {
        public final int a;
        public final int b;
        public final int c;

        public e(int i, int i2) {
            this.a = i;
            this.b = i2;
            this.c = (int) ((100.0f / i2) * (i + 1));
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.a == eVar.a && this.b == eVar.b;
        }

        public final int hashCode() {
            return Integer.hashCode(this.b) + (Integer.hashCode(this.a) * 31);
        }

        @NotNull
        public final String toString() {
            return "LongSnapshotProgress(snapshotIndex=" + this.a + ", numberOfSnapshots=" + this.b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public static final class f extends Z4 {

        @NotNull
        public static final f a = new f();
    }

    public static final class g extends Z4 {

        @NotNull
        public static final g a = new g();
    }

    public static final class h extends Z4 {

        @NotNull
        public final String a;

        public h(@NotNull String screenName) {
            Intrinsics.checkNotNullParameter(screenName, "screenName");
            this.a = screenName;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && Intrinsics.areEqual(this.a, ((h) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "Success(screenName=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}

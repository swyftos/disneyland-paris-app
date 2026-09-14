package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.y */
/* JADX INFO: loaded from: classes2.dex */
public final class C2930y {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2787j6 f3252a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final SystemInstantiable f3253b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public a f3254c;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.y$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final long f3255a;

        /* JADX INFO: renamed from: b */
        public boolean f3256b = false;

        public a(long j) {
            this.f3255a = j;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3255a == aVar.f3255a && this.f3256b == aVar.f3256b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public final int hashCode() {
            int iHashCode = Long.hashCode(this.f3255a) * 31;
            boolean z = this.f3256b;
            ?? r2 = z;
            if (z) {
                r2 = 1;
            }
            return iHashCode + r2;
        }

        @NotNull
        public final String toString() {
            return "AnimationState(startedAt=" + this.f3255a + ", hasTelemetryBeenSent=" + this.f3256b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public C2930y(@NotNull C2787j6 srQuickLink, @NotNull SystemInstantiable systemInstantiable) {
        Intrinsics.checkNotNullParameter(srQuickLink, "srQuickLink");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        this.f3252a = srQuickLink;
        this.f3253b = systemInstantiable;
    }
}

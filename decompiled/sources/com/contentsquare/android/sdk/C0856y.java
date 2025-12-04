package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0856y {

    @NotNull
    public final C0717j6 a;

    @NotNull
    public final SystemInstantiable b;

    @Nullable
    public a c;

    /* renamed from: com.contentsquare.android.sdk.y$a */
    public static final class a {
        public final long a;
        public boolean b = false;

        public a(long j) {
            this.a = j;
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
        public final int hashCode() {
            int iHashCode = Long.hashCode(this.a) * 31;
            boolean z = this.b;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        @NotNull
        public final String toString() {
            return "AnimationState(startedAt=" + this.a + ", hasTelemetryBeenSent=" + this.b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public C0856y(@NotNull C0717j6 srQuickLink, @NotNull SystemInstantiable systemInstantiable) {
        Intrinsics.checkNotNullParameter(srQuickLink, "srQuickLink");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        this.a = srQuickLink;
        this.b = systemInstantiable;
    }
}

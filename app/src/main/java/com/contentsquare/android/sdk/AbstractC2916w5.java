package com.contentsquare.android.sdk;

import android.view.View;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.w5 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2916w5 extends AbstractC2707b6 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.w5$a */
    public static final class a extends AbstractC2916w5 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final View f3211a;

        public a(@NotNull View scrollContainer) {
            Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
            this.f3211a = scrollContainer;
        }

        @Override // com.contentsquare.android.sdk.AbstractC2916w5
        @NotNull
        /* JADX INFO: renamed from: a */
        public final View mo1226a() {
            return this.f3211a;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f3211a, ((a) obj).f3211a);
        }

        public final int hashCode() {
            return this.f3211a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "LongHorizontal(scrollContainer=" + this.f3211a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.w5$b */
    public static final class b extends AbstractC2916w5 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final View f3212a;

        public b(@NotNull View scrollContainer) {
            Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
            this.f3212a = scrollContainer;
        }

        @Override // com.contentsquare.android.sdk.AbstractC2916w5
        @NotNull
        /* JADX INFO: renamed from: a */
        public final View mo1226a() {
            return this.f3212a;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f3212a, ((b) obj).f3212a);
        }

        public final int hashCode() {
            return this.f3212a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "LongVertical(scrollContainer=" + this.f3212a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.w5$c */
    public static final class c extends AbstractC2916w5 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final View f3213a;

        public c(@NotNull View scrollContainer) {
            Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
            this.f3213a = scrollContainer;
        }

        @Override // com.contentsquare.android.sdk.AbstractC2916w5
        @NotNull
        /* JADX INFO: renamed from: a */
        public final View mo1226a() {
            return this.f3213a;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.areEqual(this.f3213a, ((c) obj).f3213a);
        }

        public final int hashCode() {
            return this.f3213a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "LongVerticalHorizontal(scrollContainer=" + this.f3213a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract View mo1226a();
}

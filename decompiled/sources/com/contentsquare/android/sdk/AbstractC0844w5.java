package com.contentsquare.android.sdk;

import android.view.View;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.w5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0844w5 extends AbstractC0637b6 {

    /* renamed from: com.contentsquare.android.sdk.w5$a */
    public static final class a extends AbstractC0844w5 {

        @NotNull
        public final View a;

        public a(@NotNull View scrollContainer) {
            Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
            this.a = scrollContainer;
        }

        @Override // com.contentsquare.android.sdk.AbstractC0844w5
        @NotNull
        public final View a() {
            return this.a;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "LongHorizontal(scrollContainer=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.w5$b */
    public static final class b extends AbstractC0844w5 {

        @NotNull
        public final View a;

        public b(@NotNull View scrollContainer) {
            Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
            this.a = scrollContainer;
        }

        @Override // com.contentsquare.android.sdk.AbstractC0844w5
        @NotNull
        public final View a() {
            return this.a;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.a, ((b) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "LongVertical(scrollContainer=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.w5$c */
    public static final class c extends AbstractC0844w5 {

        @NotNull
        public final View a;

        public c(@NotNull View scrollContainer) {
            Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
            this.a = scrollContainer;
        }

        @Override // com.contentsquare.android.sdk.AbstractC0844w5
        @NotNull
        public final View a() {
            return this.a;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.areEqual(this.a, ((c) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "LongVerticalHorizontal(scrollContainer=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @NotNull
    public abstract View a();
}

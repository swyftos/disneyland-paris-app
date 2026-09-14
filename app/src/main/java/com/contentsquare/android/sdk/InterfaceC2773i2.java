package com.contentsquare.android.sdk;

import android.view.View;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.i2 */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2773i2 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.i2$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final C2929x8<View> f2739a;

        /* JADX INFO: renamed from: b */
        public final int f2740b;

        /* JADX INFO: renamed from: c */
        public final int f2741c;

        public a(@NotNull C2929x8<View> capturedTargetsList, int i, int i2) {
            Intrinsics.checkNotNullParameter(capturedTargetsList, "capturedTargetsList");
            this.f2739a = capturedTargetsList;
            this.f2740b = i;
            this.f2741c = i2;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f2739a, aVar.f2739a) && this.f2740b == aVar.f2740b && this.f2741c == aVar.f2741c;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f2741c) + ((Integer.hashCode(this.f2740b) + (this.f2739a.hashCode() * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "Request(capturedTargetsList=" + this.f2739a + ", touchX=" + this.f2740b + ", touchY=" + this.f2741c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    C2763h2 mo1155a(@NotNull a aVar);
}

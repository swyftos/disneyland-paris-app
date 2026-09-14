package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.I7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2524I7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final b f1710a = b.f1712a;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.I7$a */
    public static final class a extends Lambda implements Function2<View, InterfaceC2749f8, AbstractC2715c4.a> {

        /* JADX INFO: renamed from: a */
        public static final a f1711a = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final AbstractC2715c4.a invoke(View view, InterfaceC2749f8 interfaceC2749f8) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(interfaceC2749f8, "<anonymous parameter 1>");
            return AbstractC2715c4.a.f2444a;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.I7$b */
    public static final class b extends Lambda implements Function2<View, C2499G2, Unit> {

        /* JADX INFO: renamed from: a */
        public static final b f1712a = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(View view, C2499G2 c2499g2) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(c2499g2, "<anonymous parameter 1>");
            return Unit.INSTANCE;
        }
    }

    static {
        a aVar = a.f1711a;
    }
}

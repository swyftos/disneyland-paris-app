package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.sdk.AbstractC0645c4;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class I7 {

    @NotNull
    public static final b a = b.a;

    public static final class a extends Lambda implements Function2<View, InterfaceC0679f8, AbstractC0645c4.a> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final AbstractC0645c4.a invoke(View view, InterfaceC0679f8 interfaceC0679f8) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(interfaceC0679f8, "<anonymous parameter 1>");
            return AbstractC0645c4.a.a;
        }
    }

    public static final class b extends Lambda implements Function2<View, G2, Unit> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(View view, G2 g2) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(g2, "<anonymous parameter 1>");
            return Unit.INSTANCE;
        }
    }

    static {
        a aVar = a.a;
    }
}

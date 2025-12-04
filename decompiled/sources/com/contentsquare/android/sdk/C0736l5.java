package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0660e;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.l5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0736l5 extends AbstractC0660e {
    public final int m;
    public final int n;
    public final long o;

    /* renamed from: com.contentsquare.android.sdk.l5$a */
    public static final class a extends AbstractC0660e.a<C0736l5> {
        public int k;
        public int l;
        public long m;

        public a() {
            super(23);
            this.m = 250L;
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new C0736l5(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0736l5(@NotNull a builder) {
        super(builder);
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.m = builder.k;
        this.n = builder.l;
        this.o = builder.m;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        AbstractC0660e.l.i("Scroll - deltaX: " + this.m + " - deltaY: " + this.n + " - Duration: " + this.o);
    }
}

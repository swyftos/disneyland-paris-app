package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0660e;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class H4 extends AbstractC0660e {
    public final int m;
    public final int n;
    public final int o;

    public static final class a extends AbstractC0660e.a<H4> {
        public int k;
        public int l;
        public final int m;

        public a() {
            super(5);
            this.m = 250;
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new H4(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H4(@NotNull a builder) {
        super(builder);
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.m = builder.k;
        this.n = builder.l;
        this.o = builder.m;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        AbstractC0660e.l.i("Resize - Screen width: " + this.m + " - Screen height: " + this.n + " - Duration: " + this.o);
    }
}

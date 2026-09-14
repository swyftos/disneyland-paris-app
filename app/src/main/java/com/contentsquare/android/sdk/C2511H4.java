package com.contentsquare.android.sdk;

import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.H4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2511H4 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    public final int f1676m;

    /* JADX INFO: renamed from: n */
    public final int f1677n;

    /* JADX INFO: renamed from: o */
    public final int f1678o;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.H4$a */
    public static final class a extends AbstractC2730e.a<C2511H4> {

        /* JADX INFO: renamed from: k */
        public int f1679k;

        /* JADX INFO: renamed from: l */
        public int f1680l;

        /* JADX INFO: renamed from: m */
        public final int f1681m;

        public a() {
            super(5);
            this.f1681m = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2511H4(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2511H4(@NotNull a builder) {
        super(builder);
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f1676m = builder.f1679k;
        this.f1677n = builder.f1680l;
        this.f1678o = builder.f1681m;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        AbstractC2730e.f2545l.m831i("Resize - Screen width: " + this.f1676m + " - Screen height: " + this.f1677n + " - Duration: " + this.f1678o);
    }
}

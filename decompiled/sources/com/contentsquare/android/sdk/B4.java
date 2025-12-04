package com.contentsquare.android.sdk;

import androidx.recyclerview.widget.RecyclerView;
import com.contentsquare.android.core.utils.Debouncer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class B4 extends AbstractC0650d<RecyclerView> {

    @NotNull
    public final b g;
    public int h;
    public int i;

    public static final class a extends Lambda implements Function1<RecyclerView, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(RecyclerView recyclerView) {
            RecyclerView forView = recyclerView;
            Intrinsics.checkNotNullParameter(forView, "$this$forView");
            forView.removeOnScrollListener(B4.this.g);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            B4 b4 = B4.this;
            b4.h += i;
            b4.i += i2;
            b4.a(new C0640c(b4));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B4(@NotNull final RecyclerView recyclerView, @NotNull Debouncer debouncer) {
        super(recyclerView, debouncer);
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(debouncer, "debouncer");
        this.g = new b();
        recyclerView.post(new Runnable() { // from class: com.contentsquare.android.sdk.B4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                B4.a(recyclerView, this);
            }
        });
    }

    public static final void a(RecyclerView recyclerView, B4 this$0) {
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        recyclerView.addOnScrollListener(this$0.g);
        this$0.a(new C0640c(this$0));
    }

    @Override // com.contentsquare.android.sdk.AbstractC0650d
    public final int b() {
        return this.i;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0795r5
    public final void clear() {
        a(new a());
    }

    @Override // com.contentsquare.android.sdk.AbstractC0650d
    public final int a() {
        return this.h;
    }
}

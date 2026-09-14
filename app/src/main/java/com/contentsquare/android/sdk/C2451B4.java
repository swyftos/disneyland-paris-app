package com.contentsquare.android.sdk;

import androidx.recyclerview.widget.RecyclerView;
import com.contentsquare.android.core.utils.Debouncer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.B4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2451B4 extends AbstractC2720d<RecyclerView> {

    /* JADX INFO: renamed from: g */
    @NotNull
    public final b f1440g;

    /* JADX INFO: renamed from: h */
    public int f1441h;

    /* JADX INFO: renamed from: i */
    public int f1442i;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.B4$a */
    public static final class a extends Lambda implements Function1<RecyclerView, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(RecyclerView recyclerView) {
            RecyclerView forView = recyclerView;
            Intrinsics.checkNotNullParameter(forView, "$this$forView");
            forView.removeOnScrollListener(C2451B4.this.f1440g);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.B4$b */
    public static final class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            C2451B4 c2451b4 = C2451B4.this;
            c2451b4.f1441h += i;
            c2451b4.f1442i += i2;
            c2451b4.m1113a(new C2710c(c2451b4));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2451B4(@NotNull final RecyclerView recyclerView, @NotNull Debouncer debouncer) {
        super(recyclerView, debouncer);
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(debouncer, "debouncer");
        this.f1440g = new b();
        recyclerView.post(new Runnable() { // from class: com.contentsquare.android.sdk.B4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2451B4.m878a(recyclerView, this);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static final void m878a(RecyclerView recyclerView, C2451B4 this$0) {
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        recyclerView.addOnScrollListener(this$0.f1440g);
        this$0.m1113a(new C2710c(this$0));
    }

    @Override // com.contentsquare.android.sdk.AbstractC2720d
    /* JADX INFO: renamed from: b */
    public final int mo880b() {
        return this.f1442i;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2866r5
    public final void clear() {
        m1113a(new a());
    }

    @Override // com.contentsquare.android.sdk.AbstractC2720d
    /* JADX INFO: renamed from: a */
    public final int mo879a() {
        return this.f1441h;
    }
}

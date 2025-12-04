package com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay;

import android.app.Application;
import android.content.Intent;
import android.view.View;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity;
import com.contentsquare.android.sdk.AbstractC0637b6;
import com.contentsquare.android.sdk.C0667e6;
import com.contentsquare.android.sdk.C0724k3;
import com.contentsquare.android.sdk.C0746m5;
import com.contentsquare.android.sdk.C0766o5;
import com.contentsquare.android.sdk.F3;
import com.contentsquare.android.sdk.G3;
import com.contentsquare.android.sdk.H3;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.sync.Mutex;

/* loaded from: classes2.dex */
public final class d implements a.InterfaceC0038a {
    public final /* synthetic */ OverlayService a;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function2<AbstractC0637b6, Continuation<? super Boolean>, Object>, SuspendFunction {
        public a(com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a aVar) {
            super(2, aVar, com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a.class, "showSnapshotDialog", "showSnapshotDialog(Lcom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/SnapshotConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AbstractC0637b6 abstractC0637b6, Continuation<? super Boolean> continuation) {
            return ((com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a) this.receiver).a(abstractC0637b6, continuation);
        }
    }

    public d(OverlayService overlayService) {
        this.a = overlayService;
    }

    @Override // com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a.InterfaceC0038a
    public final void a() {
        H3 h3 = this.a.b;
        if (h3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            h3 = null;
        }
        Mutex.DefaultImpls.tryLock$default(h3.j.a, null, 1, null);
        h3.b.c.a.set(true);
    }

    @Override // com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a.InterfaceC0038a
    public final void b() {
        H3 h3 = this.a.b;
        if (h3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            h3 = null;
        }
        C0724k3 c0724k3 = h3.h;
        c0724k3.getClass();
        int i = SettingsActivity.g;
        Application context = c0724k3.a;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.content.Context");
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) SettingsActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a.InterfaceC0038a
    public final void c() {
        H3 h3 = this.a.b;
        if (h3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            h3 = null;
        }
        com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a aVar = this.a.c;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayLayoutManager");
            aVar = null;
        }
        a setUp = new a(aVar);
        h3.getClass();
        Intrinsics.checkNotNullParameter(setUp, "setUp");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(h3.k.plus(Dispatchers.getMain())), null, null, new F3(h3, setUp, null), 3, null);
    }

    @Override // com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a.InterfaceC0038a
    public final void d() {
        H3 h3 = this.a.b;
        com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a aVar = null;
        if (h3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            h3 = null;
        }
        JobKt__JobKt.cancelChildren$default(h3.k, (CancellationException) null, 1, (Object) null);
        C0766o5 c0766o5 = h3.b;
        c0766o5.c.a.set(false);
        c0766o5.e = null;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C0746m5(c0766o5, null), 3, null);
        com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a aVar2 = this.a.c;
        if (aVar2 != null) {
            aVar = aVar2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("overlayLayoutManager");
        }
        View viewA = aVar.a();
        if (viewA == null) {
            return;
        }
        viewA.setVisibility(0);
    }

    @Override // com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a.InterfaceC0038a
    public final void e() {
        H3 h3 = this.a.b;
        if (h3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            h3 = null;
        }
        C0667e6 c0667e6 = h3.j;
        c0667e6.getClass();
        try {
            Mutex.DefaultImpls.unlock$default(c0667e6.a, null, 1, null);
        } catch (IllegalStateException unused) {
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(h3.k), null, null, new G3(h3, null), 3, null);
    }
}

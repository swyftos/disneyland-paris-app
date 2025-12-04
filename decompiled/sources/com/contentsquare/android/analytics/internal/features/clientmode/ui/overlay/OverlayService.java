package com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.DialogFragmentC0642c1;
import com.contentsquare.android.sdk.H3;
import com.contentsquare.android.sdk.K0;
import com.contentsquare.android.sdk.N6;
import com.contentsquare.android.sdk.W2;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/OverlayService;", "Landroid/app/Service;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nOverlayService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OverlayService.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/OverlayService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
/* loaded from: classes2.dex */
public final class OverlayService extends Service {

    @NotNull
    public final Logger a = new Logger("OverlayService");
    public H3 b;
    public a c;

    public final void a() {
        DialogFragmentC0642c1 dialogFragmentC0642c1;
        DialogFragmentC0642c1 dialogFragmentC0642c12;
        a aVar = this.c;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayLayoutManager");
            aVar = null;
        }
        if (aVar.a().getWindowToken() != null) {
            aVar.c.removeView(aVar.a());
        }
        W2 w2 = aVar.i;
        if (w2 != null && (dialogFragmentC0642c12 = w2.d) != null) {
            dialogFragmentC0642c12.dismiss();
        }
        aVar.i = null;
        N6 n6 = aVar.h;
        if (n6 != null && (dialogFragmentC0642c1 = n6.c) != null) {
            dialogFragmentC0642c1.dismiss();
        }
        aVar.h = null;
        a aVar2 = this.c;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayLayoutManager");
            aVar2 = null;
        }
        aVar2.l = null;
        Job job = aVar2.m;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        aVar2.m = null;
        H3 h3 = this.b;
        if (h3 != null) {
            JobKt__JobKt.cancelChildren$default(h3.k, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Object systemService = getApplication().getSystemService("window");
        if ((systemService instanceof WindowManager ? (WindowManager) systemService : null) == null) {
            stopSelf();
            return;
        }
        Logger logger = K0.e;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "this.application");
        this.b = K0.a.a(application).d;
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "application");
        a aVar = K0.a.a(application2).a;
        aVar.b();
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.c = aVar;
        View viewA = aVar.a();
        if (viewA != null) {
            viewA.setVisibility(0);
        }
        aVar.l = new d(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.a.w("OnDestroy : ClientModeService is being destroyed");
        a();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onTaskRemoved(@NotNull Intent rootIntent) {
        Intrinsics.checkNotNullParameter(rootIntent, "rootIntent");
        a();
        stopSelf();
        super.onTaskRemoved(rootIntent);
    }
}

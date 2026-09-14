package com.contentsquare.android.sdk;

import android.os.Build;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.overlay.OverlayViewModel$currentSnapshotActivityLifecycleObserver$1;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.C2510H3;
import com.contentsquare.android.sdk.C2816m5;
import com.contentsquare.android.sdk.C2836o5;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.H3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2510H3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2501G4 f1662a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2836o5 f1663b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2905v4 f1664c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2680Y7 f1665d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final C2633T7 f1666e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final InterfaceC2903v2 f1667f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final C2717c6 f1668g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final C2794k3 f1669h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final MutableStateFlow<AbstractC2686Z4> f1670i;

    /* JADX INFO: renamed from: j */
    @NotNull
    public final C2737e6 f1671j;

    /* JADX INFO: renamed from: k */
    @NotNull
    public final CoroutineContext f1672k;

    /* JADX INFO: renamed from: l */
    @NotNull
    public final Logger f1673l;

    /* JADX INFO: renamed from: m */
    public final int f1674m;

    /* JADX INFO: renamed from: n */
    @NotNull
    public final OverlayViewModel$currentSnapshotActivityLifecycleObserver$1 f1675n;

    /* JADX WARN: Type inference failed for: r3v3, types: [com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayViewModel$currentSnapshotActivityLifecycleObserver$1] */
    public C2510H3(C2501G4 regularSnapshotCaptureUseCase, C2836o5 scrollViewCaptureUseCase, C2905v4 recyclerViewCaptureUseCase, C2680Y7 composeScrollUseCase, C2633T7 verticalComposeLazyUseCase, InterfaceC2903v2 glassPane, C2717c6 snapshotConfigCreator, C2794k3 navigator, MutableStateFlow snapshotStateFlow, C2737e6 snapshotPausingController) {
        CoroutineContext coroutineContext = JobKt__JobKt.Job$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault());
        Intrinsics.checkNotNullParameter(regularSnapshotCaptureUseCase, "regularSnapshotCaptureUseCase");
        Intrinsics.checkNotNullParameter(scrollViewCaptureUseCase, "scrollViewCaptureUseCase");
        Intrinsics.checkNotNullParameter(recyclerViewCaptureUseCase, "recyclerViewCaptureUseCase");
        Intrinsics.checkNotNullParameter(composeScrollUseCase, "composeScrollUseCase");
        Intrinsics.checkNotNullParameter(verticalComposeLazyUseCase, "verticalComposeLazyUseCase");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        Intrinsics.checkNotNullParameter(snapshotConfigCreator, "snapshotConfigCreator");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(snapshotPausingController, "snapshotPausingController");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f1662a = regularSnapshotCaptureUseCase;
        this.f1663b = scrollViewCaptureUseCase;
        this.f1664c = recyclerViewCaptureUseCase;
        this.f1665d = composeScrollUseCase;
        this.f1666e = verticalComposeLazyUseCase;
        this.f1667f = glassPane;
        this.f1668g = snapshotConfigCreator;
        this.f1669h = navigator;
        this.f1670i = snapshotStateFlow;
        this.f1671j = snapshotPausingController;
        this.f1672k = coroutineContext;
        this.f1673l = new Logger("OverlayViewModel");
        this.f1674m = Build.VERSION.SDK_INT;
        this.f1675n = new DefaultLifecycleObserver() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayViewModel$currentSnapshotActivityLifecycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStop(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                owner.getLifecycle().removeObserver(this);
                C2510H3 c2510h3 = this.f1140a;
                JobKt__JobKt.cancelChildren$default(c2510h3.f1672k, (CancellationException) null, 1, (Object) null);
                C2836o5 c2836o5 = c2510h3.f1663b;
                c2836o5.f2941c.f2295a.set(false);
                c2836o5.f2943e = null;
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C2816m5(c2836o5, null), 3, null);
            }
        };
    }
}

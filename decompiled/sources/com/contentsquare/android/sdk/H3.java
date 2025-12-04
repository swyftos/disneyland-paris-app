package com.contentsquare.android.sdk;

import android.os.Build;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayViewModel$currentSnapshotActivityLifecycleObserver$1;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.C0746m5;
import com.contentsquare.android.sdk.C0766o5;
import com.contentsquare.android.sdk.H3;
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

/* loaded from: classes2.dex */
public final class H3 {

    @NotNull
    public final G4 a;

    @NotNull
    public final C0766o5 b;

    @NotNull
    public final C0834v4 c;

    @NotNull
    public final Y7 d;

    @NotNull
    public final T7 e;

    @NotNull
    public final InterfaceC0832v2 f;

    @NotNull
    public final C0647c6 g;

    @NotNull
    public final C0724k3 h;

    @NotNull
    public final MutableStateFlow<Z4> i;

    @NotNull
    public final C0667e6 j;

    @NotNull
    public final CoroutineContext k;

    @NotNull
    public final Logger l;
    public final int m;

    @NotNull
    public final OverlayViewModel$currentSnapshotActivityLifecycleObserver$1 n;

    /* JADX WARN: Type inference failed for: r3v3, types: [com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayViewModel$currentSnapshotActivityLifecycleObserver$1] */
    public H3(G4 regularSnapshotCaptureUseCase, C0766o5 scrollViewCaptureUseCase, C0834v4 recyclerViewCaptureUseCase, Y7 composeScrollUseCase, T7 verticalComposeLazyUseCase, InterfaceC0832v2 glassPane, C0647c6 snapshotConfigCreator, C0724k3 navigator, MutableStateFlow snapshotStateFlow, C0667e6 snapshotPausingController) {
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
        this.a = regularSnapshotCaptureUseCase;
        this.b = scrollViewCaptureUseCase;
        this.c = recyclerViewCaptureUseCase;
        this.d = composeScrollUseCase;
        this.e = verticalComposeLazyUseCase;
        this.f = glassPane;
        this.g = snapshotConfigCreator;
        this.h = navigator;
        this.i = snapshotStateFlow;
        this.j = snapshotPausingController;
        this.k = coroutineContext;
        this.l = new Logger("OverlayViewModel");
        this.m = Build.VERSION.SDK_INT;
        this.n = new DefaultLifecycleObserver() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayViewModel$currentSnapshotActivityLifecycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStop(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                owner.getLifecycle().removeObserver(this);
                H3 h3 = this.a;
                JobKt__JobKt.cancelChildren$default(h3.k, (CancellationException) null, 1, (Object) null);
                C0766o5 c0766o5 = h3.b;
                c0766o5.c.a.set(false);
                c0766o5.e = null;
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C0746m5(c0766o5, null), 3, null);
            }
        };
    }
}

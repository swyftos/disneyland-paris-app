package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.contentsquare.android.api.bridge.flutter.FlutterSrEventListener;
import com.contentsquare.android.api.bridge.xpf.ExternalBridgeSessionReplayCapture;
import com.contentsquare.android.api.bridge.xpf.XpfMasker;
import com.contentsquare.android.core.features.logging.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.v3 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nOnDrawObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnDrawObserver.kt\ncom/contentsquare/android/internal/features/sessionreplay/viewtreeobserver/OnDrawObserver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,143:1\n1#2:144\n1855#3,2:145\n*S KotlinDebug\n*F\n+ 1 OnDrawObserver.kt\ncom/contentsquare/android/internal/features/sessionreplay/viewtreeobserver/OnDrawObserver\n*L\n127#1:145,2\n*E\n"})
public final class ViewTreeObserverOnPreDrawListenerC2904v3 implements ViewTreeObserver.OnPreDrawListener, FlutterSrEventListener, ExternalBridgeSessionReplayCapture {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Logger f3168a;

    /* JADX INFO: renamed from: b */
    public C2928x7 f3169b;

    /* JADX INFO: renamed from: c */
    public AbstractRunnableC2894u3 f3170c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final ArrayList f3171d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public WeakReference<Window> f3172e;

    public ViewTreeObserverOnPreDrawListenerC2904v3() {
        Logger logger = new Logger("OnDrawObserver");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f3168a = logger;
        this.f3171d = new ArrayList();
        this.f3172e = new WeakReference<>(null);
    }

    /* JADX INFO: renamed from: a */
    public final ViewTreeObserver m1215a() {
        View decorView;
        ViewTreeObserver viewTreeObserver;
        Window window = this.f3172e.get();
        if (window != null) {
            decorView = window.getDecorView();
            if (!(decorView instanceof ViewGroup)) {
                this.f3168a.m827d("Cannot get decor view from activity.");
                decorView = null;
            }
        } else {
            decorView = null;
        }
        if (decorView == null || (viewTreeObserver = decorView.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    @Override // com.contentsquare.android.api.bridge.xpf.ExternalBridgeSessionReplayCapture
    public final void captureFrame() {
        if (XpfMasker.INSTANCE.isForceMaskEnabled()) {
            return;
        }
        try {
            AbstractRunnableC2894u3 abstractRunnableC2894u3 = this.f3170c;
            AbstractRunnableC2894u3 runnable = null;
            if (abstractRunnableC2894u3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onDrawListener");
                abstractRunnableC2894u3 = null;
            }
            abstractRunnableC2894u3.setWindow(this.f3172e);
            C2928x7 c2928x7 = this.f3169b;
            if (c2928x7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("throttleOperator");
                c2928x7 = null;
            }
            AbstractRunnableC2894u3 abstractRunnableC2894u4 = this.f3170c;
            if (abstractRunnableC2894u4 != null) {
                runnable = abstractRunnableC2894u4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("onDrawListener");
            }
            c2928x7.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            c2928x7.m1235a(runnable, -1L);
            Window window = this.f3172e.get();
            if (window != null) {
                Iterator it = this.f3171d.iterator();
                while (it.hasNext()) {
                    ((InterfaceC2924x3) it.next()).mo1214a(window);
                }
            }
        } catch (Exception e) {
            C2599Q2.m1011a(this.f3168a, "Something went wrong with captureFrame.", e);
        }
    }

    @Override // com.contentsquare.android.api.bridge.flutter.FlutterSrEventListener
    public final void onFlutterSrEvent() {
        onPreDraw();
        this.f3168a.m827d("onFlutterSrEvent called.");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        try {
            AbstractRunnableC2894u3 abstractRunnableC2894u3 = this.f3170c;
            AbstractRunnableC2894u3 runnable = null;
            if (abstractRunnableC2894u3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onDrawListener");
                abstractRunnableC2894u3 = null;
            }
            abstractRunnableC2894u3.setWindow(this.f3172e);
            C2928x7 c2928x7 = this.f3169b;
            if (c2928x7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("throttleOperator");
                c2928x7 = null;
            }
            AbstractRunnableC2894u3 abstractRunnableC2894u4 = this.f3170c;
            if (abstractRunnableC2894u4 != null) {
                runnable = abstractRunnableC2894u4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("onDrawListener");
            }
            c2928x7.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            c2928x7.m1235a(runnable, c2928x7.f3245c);
            Window window = this.f3172e.get();
            if (window == null) {
                return true;
            }
            Iterator it = this.f3171d.iterator();
            while (it.hasNext()) {
                ((InterfaceC2924x3) it.next()).mo1214a(window);
            }
            return true;
        } catch (Exception e) {
            C2599Q2.m1011a(this.f3168a, "Something went wrong with onPreDraw.", e);
            return true;
        }
    }
}

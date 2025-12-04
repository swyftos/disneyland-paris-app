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

@SourceDebugExtension({"SMAP\nOnDrawObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnDrawObserver.kt\ncom/contentsquare/android/internal/features/sessionreplay/viewtreeobserver/OnDrawObserver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,143:1\n1#2:144\n1855#3,2:145\n*S KotlinDebug\n*F\n+ 1 OnDrawObserver.kt\ncom/contentsquare/android/internal/features/sessionreplay/viewtreeobserver/OnDrawObserver\n*L\n127#1:145,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.v3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewTreeObserverOnPreDrawListenerC0833v3 implements ViewTreeObserver.OnPreDrawListener, FlutterSrEventListener, ExternalBridgeSessionReplayCapture {

    @NotNull
    public final Logger a;
    public C0855x7 b;
    public AbstractRunnableC0823u3 c;

    @NotNull
    public final ArrayList d;

    @NotNull
    public WeakReference<Window> e;

    public ViewTreeObserverOnPreDrawListenerC0833v3() {
        Logger logger = new Logger("OnDrawObserver");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = logger;
        this.d = new ArrayList();
        this.e = new WeakReference<>(null);
    }

    public final ViewTreeObserver a() {
        View decorView;
        ViewTreeObserver viewTreeObserver;
        Window window = this.e.get();
        if (window != null) {
            decorView = window.getDecorView();
            if (!(decorView instanceof ViewGroup)) {
                this.a.d("Cannot get decor view from activity.");
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
            AbstractRunnableC0823u3 abstractRunnableC0823u3 = this.c;
            AbstractRunnableC0823u3 runnable = null;
            if (abstractRunnableC0823u3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onDrawListener");
                abstractRunnableC0823u3 = null;
            }
            abstractRunnableC0823u3.setWindow(this.e);
            C0855x7 c0855x7 = this.b;
            if (c0855x7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("throttleOperator");
                c0855x7 = null;
            }
            AbstractRunnableC0823u3 abstractRunnableC0823u32 = this.c;
            if (abstractRunnableC0823u32 != null) {
                runnable = abstractRunnableC0823u32;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("onDrawListener");
            }
            c0855x7.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            c0855x7.a(runnable, -1L);
            Window window = this.e.get();
            if (window != null) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0851x3) it.next()).a(window);
                }
            }
        } catch (Exception e) {
            Q2.a(this.a, "Something went wrong with captureFrame.", e);
        }
    }

    @Override // com.contentsquare.android.api.bridge.flutter.FlutterSrEventListener
    public final void onFlutterSrEvent() {
        onPreDraw();
        this.a.d("onFlutterSrEvent called.");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        try {
            AbstractRunnableC0823u3 abstractRunnableC0823u3 = this.c;
            AbstractRunnableC0823u3 runnable = null;
            if (abstractRunnableC0823u3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onDrawListener");
                abstractRunnableC0823u3 = null;
            }
            abstractRunnableC0823u3.setWindow(this.e);
            C0855x7 c0855x7 = this.b;
            if (c0855x7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("throttleOperator");
                c0855x7 = null;
            }
            AbstractRunnableC0823u3 abstractRunnableC0823u32 = this.c;
            if (abstractRunnableC0823u32 != null) {
                runnable = abstractRunnableC0823u32;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("onDrawListener");
            }
            c0855x7.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            c0855x7.a(runnable, c0855x7.c);
            Window window = this.e.get();
            if (window == null) {
                return true;
            }
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((InterfaceC0851x3) it.next()).a(window);
            }
            return true;
        } catch (Exception e) {
            Q2.a(this.a, "Something went wrong with onPreDraw.", e);
            return true;
        }
    }
}

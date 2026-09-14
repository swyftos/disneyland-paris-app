package com.contentsquare.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.contentsquare.android.core.utils.SystemInstantiable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.C7 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nTouchEventProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TouchEventProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/TouchEventProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n1855#2,2:90\n1855#2,2:92\n*S KotlinDebug\n*F\n+ 1 TouchEventProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/TouchEventProvider\n*L\n41#1:90,2\n52#1:92,2\n*E\n"})
public final class RunnableC2464C7 implements InterfaceC2934y3, Runnable, InterfaceC2612R6, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Application f1484a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final SystemInstantiable f1485b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2928x7 f1486c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2841p0 f1487d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final C2474D7 f1488e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final C2508H1 f1489f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public ArrayList f1490g;

    public RunnableC2464C7(@NotNull Application application, @NotNull SystemInstantiable systemInstantiable, @NotNull C2928x7 throttleOperator, @NotNull C2841p0 captureTouchEvent, @NotNull C2474D7 touchProcessor, @NotNull C2508H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(throttleOperator, "throttleOperator");
        Intrinsics.checkNotNullParameter(captureTouchEvent, "captureTouchEvent");
        Intrinsics.checkNotNullParameter(touchProcessor, "touchProcessor");
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.f1484a = application;
        this.f1485b = systemInstantiable;
        this.f1486c = throttleOperator;
        this.f1487d = captureTouchEvent;
        this.f1488e = touchProcessor;
        this.f1489f = eventsProvidersManager;
        application.registerActivityLifecycleCallbacks(this);
        captureTouchEvent.getClass();
        Intrinsics.checkNotNullParameter(this, "onTouchListener");
        captureTouchEvent.f2995c.add(new WeakReference<>(this));
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2934y3
    /* JADX INFO: renamed from: a */
    public final synchronized void mo889a(@NotNull MotionEvent motionEvent) {
        try {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            long jCurrentTimeMillis = this.f1485b.currentTimeMillis();
            C2474D7 c2474d7 = this.f1488e;
            c2474d7.getClass();
            Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            if (motionEvent.getPointerCount() > 1) {
                motionEvent.offsetLocation(motionEvent.getRawX() - motionEvent.getX(), motionEvent.getRawY() - motionEvent.getY());
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    c2474d7.m899a(motionEvent.getPointerId(i), jCurrentTimeMillis, (int) motionEvent.getX(i), (int) motionEvent.getY(i));
                }
            } else {
                c2474d7.m899a(motionEvent.getPointerId(0), jCurrentTimeMillis, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
            ArrayList arrayList = new ArrayList();
            if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
                int size = c2474d7.f1527b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(c2474d7.f1527b.valueAt(i2));
                }
                c2474d7.f1527b = new SparseArray<>();
            }
            if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f1489f.m930a((AbstractC2777i6) it.next());
                }
            } else {
                this.f1490g = arrayList;
                C2928x7 c2928x7 = this.f1486c;
                c2928x7.getClass();
                Intrinsics.checkNotNullParameter(this, "runnable");
                c2928x7.m1235a(this, c2928x7.f3245c);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f1487d.m1191a(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        C2841p0 c2841p0 = this.f1487d;
        c2841p0.getClass();
        Intrinsics.checkNotNullParameter(this, "onTouchListener");
        c2841p0.f2995c.add(new WeakReference<>(this));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        ArrayList arrayList = this.f1490g;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f1489f.m930a((AbstractC2777i6) it.next());
            }
        }
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2612R6
    /* JADX INFO: renamed from: a */
    public final void mo888a() {
        this.f1484a.unregisterActivityLifecycleCallbacks(this);
        this.f1487d.m1191a(this);
    }
}

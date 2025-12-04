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

@SourceDebugExtension({"SMAP\nTouchEventProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TouchEventProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/TouchEventProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n1855#2,2:90\n1855#2,2:92\n*S KotlinDebug\n*F\n+ 1 TouchEventProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/TouchEventProvider\n*L\n41#1:90,2\n52#1:92,2\n*E\n"})
/* loaded from: classes2.dex */
public final class C7 implements InterfaceC0860y3, Runnable, R6, Application.ActivityLifecycleCallbacks {

    @NotNull
    public final Application a;

    @NotNull
    public final SystemInstantiable b;

    @NotNull
    public final C0855x7 c;

    @NotNull
    public final C0771p0 d;

    @NotNull
    public final D7 e;

    @NotNull
    public final H1 f;

    @Nullable
    public ArrayList g;

    public C7(@NotNull Application application, @NotNull SystemInstantiable systemInstantiable, @NotNull C0855x7 throttleOperator, @NotNull C0771p0 captureTouchEvent, @NotNull D7 touchProcessor, @NotNull H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(throttleOperator, "throttleOperator");
        Intrinsics.checkNotNullParameter(captureTouchEvent, "captureTouchEvent");
        Intrinsics.checkNotNullParameter(touchProcessor, "touchProcessor");
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.a = application;
        this.b = systemInstantiable;
        this.c = throttleOperator;
        this.d = captureTouchEvent;
        this.e = touchProcessor;
        this.f = eventsProvidersManager;
        application.registerActivityLifecycleCallbacks(this);
        captureTouchEvent.getClass();
        Intrinsics.checkNotNullParameter(this, "onTouchListener");
        captureTouchEvent.c.add(new WeakReference<>(this));
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0860y3
    public final synchronized void a(@NotNull MotionEvent motionEvent) {
        try {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            long jCurrentTimeMillis = this.b.currentTimeMillis();
            D7 d7 = this.e;
            d7.getClass();
            Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            if (motionEvent.getPointerCount() > 1) {
                motionEvent.offsetLocation(motionEvent.getRawX() - motionEvent.getX(), motionEvent.getRawY() - motionEvent.getY());
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    d7.a(motionEvent.getPointerId(i), jCurrentTimeMillis, (int) motionEvent.getX(i), (int) motionEvent.getY(i));
                }
            } else {
                d7.a(motionEvent.getPointerId(0), jCurrentTimeMillis, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
            ArrayList arrayList = new ArrayList();
            if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
                int size = d7.b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(d7.b.valueAt(i2));
                }
                d7.b = new SparseArray<>();
            }
            if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f.a((AbstractC0707i6) it.next());
                }
            } else {
                this.g = arrayList;
                C0855x7 c0855x7 = this.c;
                c0855x7.getClass();
                Intrinsics.checkNotNullParameter(this, "runnable");
                c0855x7.a(this, c0855x7.c);
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
        this.d.a(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        C0771p0 c0771p0 = this.d;
        c0771p0.getClass();
        Intrinsics.checkNotNullParameter(this, "onTouchListener");
        c0771p0.c.add(new WeakReference<>(this));
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
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f.a((AbstractC0707i6) it.next());
            }
        }
    }

    @Override // com.contentsquare.android.sdk.R6
    public final void a() {
        this.a.unregisterActivityLifecycleCallbacks(this);
        this.d.a(this);
    }
}

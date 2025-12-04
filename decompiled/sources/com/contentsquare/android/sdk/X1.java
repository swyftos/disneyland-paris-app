package com.contentsquare.android.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.CallSuper;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.sdk.v8;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class X1 {

    @Nullable
    public final Context a;

    @NotNull
    public final SystemInstantiable b;

    @Nullable
    public VelocityTracker c;
    public double d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public long m;
    public double n;
    public long o;

    @Nullable
    public a p;

    public interface a {
        void a(@NotNull C0673f2 c0673f2);
    }

    public X1(@Nullable Context context, @NotNull SystemInstantiable systemInstantiable) {
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        this.a = context;
        this.b = systemInstantiable;
        this.m = Long.MIN_VALUE;
    }

    @CallSuper
    public void a() {
        VelocityTracker velocityTracker = this.c;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        this.m = Long.MIN_VALUE;
    }

    @CallSuper
    public final void b(@NotNull MotionEvent event) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Resources resources2;
        DisplayMetrics displayMetrics2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.m == Long.MIN_VALUE) {
            return;
        }
        int pointerId = event.getPointerId(event.getActionIndex());
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        VelocityTracker velocityTracker = this.c;
        if (velocityTracker != null) {
            velocityTracker.addMovement(event);
        }
        VelocityTracker velocityTracker2 = this.c;
        if (velocityTracker2 != null) {
            velocityTracker2.computeCurrentVelocity(1000);
            VelocityTracker velocityTracker3 = this.c;
            int xVelocity = (int) ((velocityTracker3 != null ? velocityTracker3.getXVelocity(pointerId) : 0.0f) + 0.5f);
            VelocityTracker velocityTracker4 = this.c;
            int yVelocity = (int) ((velocityTracker4 != null ? velocityTracker4.getYVelocity(pointerId) : 0.0f) + 0.5f);
            Context context = this.a;
            int i = 160;
            int i2 = (int) ((xVelocity / (((context == null || (resources2 = context.getResources()) == null || (displayMetrics2 = resources2.getDisplayMetrics()) == null) ? 160 : displayMetrics2.densityDpi) / 160)) + 0.5f);
            Context context2 = this.a;
            if (context2 != null && (resources = context2.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                i = displayMetrics.densityDpi;
            }
            this.d = Math.sqrt(Math.pow((int) ((yVelocity / (i / r7)) + 0.5f), 2.0d) + Math.pow(i2, 2.0d));
        }
        this.i = v8.a.a(rawX, this.a);
        int iA = v8.a.a(rawY, this.a);
        this.j = iA;
        this.k = rawX;
        this.l = rawY;
        float f = this.g;
        float f2 = this.i - f;
        float f3 = iA - this.h;
        this.n = Math.sqrt((f3 * f3) + (f2 * f2));
        this.o = this.b.currentTimeMillis() - this.m;
        C0673f2 c0673f2 = new C0673f2();
        c0673f2.e = this.n;
        c0673f2.f = this.d;
        double d = this.k;
        c0673f2.g = d;
        c0673f2.h = this.l;
        c0673f2.i = v8.a.a((int) d, this.a);
        c0673f2.j = v8.a.a((int) c0673f2.h, this.a);
        if (this.n > 24.0d) {
            c0673f2.b = this.d > 1000.0d ? 10 : 9;
            float f4 = this.i - this.g;
            float f5 = this.j - this.h;
            c0673f2.d = Math.abs(f4) > Math.abs(f5) ? f4 > BitmapDescriptorFactory.HUE_RED ? 4 : 3 : f5 > BitmapDescriptorFactory.HUE_RED ? 2 : 1;
        } else {
            c0673f2.b = this.o < 500 ? 6 : 8;
        }
        a(c0673f2);
        a aVar = this.p;
        if (aVar != null) {
            aVar.a(c0673f2);
        }
        a();
    }

    @CallSuper
    public final void a(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(event, "event");
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        this.e = rawX;
        this.f = rawY;
        this.g = v8.a.a(rawX, this.a);
        this.h = v8.a.a(rawY, this.a);
        this.m = this.b.currentTimeMillis();
        VelocityTracker velocityTracker = this.c;
        if (velocityTracker == null) {
            this.c = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        VelocityTracker velocityTracker2 = this.c;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(event);
        }
    }

    public void a(@NotNull C0673f2 gestureResult) {
        Intrinsics.checkNotNullParameter(gestureResult, "gestureResult");
    }
}

package com.contentsquare.android.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.CallSuper;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.X1 */
/* JADX INFO: loaded from: classes2.dex */
public class C2665X1 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final Context f2235a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final SystemInstantiable f2236b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public VelocityTracker f2237c;

    /* JADX INFO: renamed from: d */
    public double f2238d;

    /* JADX INFO: renamed from: e */
    public int f2239e;

    /* JADX INFO: renamed from: f */
    public int f2240f;

    /* JADX INFO: renamed from: g */
    public int f2241g;

    /* JADX INFO: renamed from: h */
    public int f2242h;

    /* JADX INFO: renamed from: i */
    public int f2243i;

    /* JADX INFO: renamed from: j */
    public int f2244j;

    /* JADX INFO: renamed from: k */
    public int f2245k;

    /* JADX INFO: renamed from: l */
    public int f2246l;

    /* JADX INFO: renamed from: m */
    public long f2247m;

    /* JADX INFO: renamed from: n */
    public double f2248n;

    /* JADX INFO: renamed from: o */
    public long f2249o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public a f2250p;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.X1$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo1070a(@NotNull C2743f2 c2743f2);
    }

    public C2665X1(@Nullable Context context, @NotNull SystemInstantiable systemInstantiable) {
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        this.f2235a = context;
        this.f2236b = systemInstantiable;
        this.f2247m = Long.MIN_VALUE;
    }

    @CallSuper
    /* JADX INFO: renamed from: a */
    public void mo1066a() {
        VelocityTracker velocityTracker = this.f2237c;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        this.f2247m = Long.MIN_VALUE;
    }

    @CallSuper
    /* JADX INFO: renamed from: b */
    public final void m1069b(@NotNull MotionEvent event) {
        int i;
        Resources resources;
        DisplayMetrics displayMetrics;
        Resources resources2;
        DisplayMetrics displayMetrics2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.f2247m == Long.MIN_VALUE) {
            return;
        }
        int pointerId = event.getPointerId(event.getActionIndex());
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        VelocityTracker velocityTracker = this.f2237c;
        if (velocityTracker != null) {
            velocityTracker.addMovement(event);
        }
        VelocityTracker velocityTracker2 = this.f2237c;
        if (velocityTracker2 != null) {
            velocityTracker2.computeCurrentVelocity(1000);
            VelocityTracker velocityTracker3 = this.f2237c;
            int xVelocity = (int) ((velocityTracker3 != null ? velocityTracker3.getXVelocity(pointerId) : 0.0f) + 0.5f);
            VelocityTracker velocityTracker4 = this.f2237c;
            int yVelocity = (int) ((velocityTracker4 != null ? velocityTracker4.getYVelocity(pointerId) : 0.0f) + 0.5f);
            Context context = this.f2235a;
            int i2 = 160;
            float f = 160;
            int i3 = (int) ((xVelocity / (((context == null || (resources2 = context.getResources()) == null || (displayMetrics2 = resources2.getDisplayMetrics()) == null) ? 160 : displayMetrics2.densityDpi) / f)) + 0.5f);
            Context context2 = this.f2235a;
            if (context2 != null && (resources = context2.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                i2 = displayMetrics.densityDpi;
            }
            this.f2238d = Math.sqrt(Math.pow((int) ((yVelocity / (i2 / f)) + 0.5f), 2.0d) + Math.pow(i3, 2.0d));
        }
        this.f2243i = C2909v8.a.m1224a(rawX, this.f2235a);
        int iM1224a = C2909v8.a.m1224a(rawY, this.f2235a);
        this.f2244j = iM1224a;
        this.f2245k = rawX;
        this.f2246l = rawY;
        float f2 = this.f2241g;
        float f3 = this.f2242h;
        float f4 = this.f2243i - f2;
        float f5 = iM1224a - f3;
        this.f2248n = Math.sqrt((f5 * f5) + (f4 * f4));
        this.f2249o = this.f2236b.currentTimeMillis() - this.f2247m;
        C2743f2 c2743f2 = new C2743f2();
        c2743f2.f2604e = this.f2248n;
        c2743f2.f2605f = this.f2238d;
        double d = this.f2245k;
        c2743f2.f2606g = d;
        c2743f2.f2607h = this.f2246l;
        c2743f2.f2608i = C2909v8.a.m1224a((int) d, this.f2235a);
        c2743f2.f2609j = C2909v8.a.m1224a((int) c2743f2.f2607h, this.f2235a);
        if (this.f2248n > 24.0d) {
            c2743f2.f2601b = this.f2238d > 1000.0d ? 10 : 9;
            float f6 = this.f2243i - this.f2241g;
            float f7 = this.f2244j - this.f2242h;
            if (Math.abs(f6) > Math.abs(f7)) {
                i = f6 > BitmapDescriptorFactory.HUE_RED ? 4 : 3;
            } else {
                i = f7 > BitmapDescriptorFactory.HUE_RED ? 2 : 1;
            }
            c2743f2.f2603d = i;
        } else {
            c2743f2.f2601b = this.f2249o < 500 ? 6 : 8;
        }
        mo1068a(c2743f2);
        a aVar = this.f2250p;
        if (aVar != null) {
            aVar.mo1070a(c2743f2);
        }
        mo1066a();
    }

    @CallSuper
    /* JADX INFO: renamed from: a */
    public final void m1067a(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(event, "event");
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        this.f2239e = rawX;
        this.f2240f = rawY;
        this.f2241g = C2909v8.a.m1224a(rawX, this.f2235a);
        this.f2242h = C2909v8.a.m1224a(rawY, this.f2235a);
        this.f2247m = this.f2236b.currentTimeMillis();
        VelocityTracker velocityTracker = this.f2237c;
        if (velocityTracker == null) {
            this.f2237c = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        VelocityTracker velocityTracker2 = this.f2237c;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(event);
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo1068a(@NotNull C2743f2 gestureResult) {
        Intrinsics.checkNotNullParameter(gestureResult, "gestureResult");
    }
}

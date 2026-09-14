package com.contentsquare.android.sdk;

import android.app.Application;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.d2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2723d2 implements C2665X1.a {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final SystemInstantiable f2491a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2665X1 f2492b;

    /* JADX INFO: renamed from: c */
    public long f2493c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public InterfaceC2914w3 f2494d;

    public C2723d2(Application application, SystemInstantiable systemInstantiable) {
        C2665X1 genericGestureDetector = new C2665X1(application, systemInstantiable);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(genericGestureDetector, "genericGestureDetector");
        this.f2491a = systemInstantiable;
        this.f2492b = genericGestureDetector;
        genericGestureDetector.f2250p = this;
    }

    @Override // com.contentsquare.android.sdk.C2665X1.a
    /* JADX INFO: renamed from: a */
    public final void mo1070a(@NotNull C2743f2 result) {
        C2683Z1 c2683z1;
        InterfaceC2914w3 interfaceC2914w3;
        Intrinsics.checkNotNullParameter(result, "result");
        switch (result.f2601b) {
            case 6:
            case 8:
            case 9:
            case 10:
                c2683z1 = new C2683Z1(this.f2493c, result);
                break;
            case 7:
            default:
                c2683z1 = null;
                break;
        }
        if (c2683z1 == null || (interfaceC2914w3 = this.f2494d) == null) {
            return;
        }
        interfaceC2914w3.mo1084a(c2683z1);
    }

    /* JADX INFO: renamed from: a */
    public final void m1114a(@NotNull MotionEvent event) {
        VelocityTracker velocityTracker;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPointerCount() > 1) {
            return;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.f2493c = this.f2491a.currentTimeMillis();
            this.f2492b.mo1066a();
            this.f2492b.m1067a(event);
        } else {
            if (actionMasked == 1) {
                this.f2492b.m1069b(event);
                return;
            }
            C2665X1 c2665x1 = this.f2492b;
            if (actionMasked != 2) {
                c2665x1.mo1066a();
                return;
            }
            c2665x1.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            if (c2665x1.f2247m == Long.MIN_VALUE || (velocityTracker = c2665x1.f2237c) == null) {
                return;
            }
            velocityTracker.addMovement(event);
        }
    }
}

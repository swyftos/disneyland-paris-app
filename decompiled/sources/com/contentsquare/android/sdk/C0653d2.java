package com.contentsquare.android.sdk;

import android.app.Application;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.sdk.X1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.d2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0653d2 implements X1.a {

    @NotNull
    public final SystemInstantiable a;

    @NotNull
    public final X1 b;
    public long c;

    @Nullable
    public InterfaceC0842w3 d;

    public C0653d2(Application application, SystemInstantiable systemInstantiable) {
        X1 genericGestureDetector = new X1(application, systemInstantiable);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(genericGestureDetector, "genericGestureDetector");
        this.a = systemInstantiable;
        this.b = genericGestureDetector;
        genericGestureDetector.p = this;
    }

    @Override // com.contentsquare.android.sdk.X1.a
    public final void a(@NotNull C0673f2 result) {
        Z1 z1;
        InterfaceC0842w3 interfaceC0842w3;
        Intrinsics.checkNotNullParameter(result, "result");
        switch (result.b) {
            case 6:
            case 8:
            case 9:
            case 10:
                z1 = new Z1(this.c, result);
                break;
            case 7:
            default:
                z1 = null;
                break;
        }
        if (z1 == null || (interfaceC0842w3 = this.d) == null) {
            return;
        }
        interfaceC0842w3.a(z1);
    }

    public final void a(@NotNull MotionEvent event) {
        VelocityTracker velocityTracker;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPointerCount() > 1) {
            return;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.c = this.a.currentTimeMillis();
            this.b.a();
            this.b.a(event);
        } else {
            if (actionMasked == 1) {
                this.b.b(event);
                return;
            }
            X1 x1 = this.b;
            if (actionMasked != 2) {
                x1.a();
                return;
            }
            x1.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            if (x1.m == Long.MIN_VALUE || (velocityTracker = x1.c) == null) {
                return;
            }
            velocityTracker.addMovement(event);
        }
    }
}

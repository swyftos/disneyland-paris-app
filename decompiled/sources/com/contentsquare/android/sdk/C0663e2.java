package com.contentsquare.android.sdk;

import android.app.Application;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Predicate;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.C0673f2;
import com.contentsquare.android.sdk.X1;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.e2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0663e2 implements X1.a {

    @NotNull
    public final F7 a;

    @NotNull
    public final Application b;

    @NotNull
    public Y1 c;

    @NotNull
    public final E1 d;

    @NotNull
    public final C0710j e;

    @NotNull
    public final C0683g2 f;

    @NotNull
    public final Logger g;

    @JvmOverloads
    public C0663e2() {
        this(null, 63);
    }

    public static final boolean a(View view) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(@org.jetbrains.annotations.Nullable com.contentsquare.android.sdk.C0673f2 r10) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0663e2.b(com.contentsquare.android.sdk.f2):void");
    }

    public /* synthetic */ C0663e2(F7 f7, int i) {
        F7 f72 = (i & 1) != 0 ? new F7(new Predicate() { // from class: com.contentsquare.android.sdk.e2$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return C0663e2.a((View) obj);
            }
        }) : f7;
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        Intrinsics.checkNotNull(csApplicationModule);
        Application application = csApplicationModule.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getInstance()!!.application");
        CsApplicationModule csApplicationModule2 = CsApplicationModule.getInstance();
        Intrinsics.checkNotNull(csApplicationModule2);
        Application application2 = csApplicationModule2.getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getInstance()!!.application");
        Y1 y1 = new Y1(application2, f72, new SystemInstantiable(), new C0627a6());
        CsApplicationModule csApplicationModule3 = CsApplicationModule.getInstance();
        Intrinsics.checkNotNull(csApplicationModule3);
        E1 eventsBuildersFactory = csApplicationModule3.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "getInstance()!!.eventsBuildersFactory");
        CsApplicationModule csApplicationModule4 = CsApplicationModule.getInstance();
        Intrinsics.checkNotNull(csApplicationModule4);
        C0710j analyticsPipeline = csApplicationModule4.getAnalyticsPipeline();
        Intrinsics.checkNotNullExpressionValue(analyticsPipeline, "getInstance()!!.analyticsPipeline");
        this(f72, application, y1, eventsBuildersFactory, analyticsPipeline, new C0683g2());
    }

    @Override // com.contentsquare.android.sdk.X1.a
    public final void a(@NotNull C0673f2 result) {
        String path;
        Intrinsics.checkNotNullParameter(result, "result");
        this.g.d("onGestureDetected() called with result [" + result + AbstractJsonLexerKt.END_LIST);
        Y6 y6 = result.c;
        if (y6 != null && (path = y6.a()) != null) {
            if (C0673f2.a.a(path)) {
                return;
            }
            Intrinsics.checkNotNullParameter(path, "path");
            if (StringsKt.contains$default((CharSequence) path, (CharSequence) ">FlutterView", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) path, (CharSequence) ">PlatformViewWrapper", false, 2, (Object) null)) {
                return;
            }
        }
        b(result);
    }

    @JvmOverloads
    public C0663e2(@NotNull F7 touchTargetDetector, @NotNull Application application, @NotNull Y1 gestureDetector, @NotNull E1 eventsBuildersFactory, @NotNull C0710j analyticsPipeline, @NotNull C0683g2 gestureStorage) {
        Intrinsics.checkNotNullParameter(touchTargetDetector, "touchTargetDetector");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(gestureDetector, "gestureDetector");
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(gestureStorage, "gestureStorage");
        this.a = touchTargetDetector;
        this.b = application;
        this.c = gestureDetector;
        this.d = eventsBuildersFactory;
        this.e = analyticsPipeline;
        this.f = gestureStorage;
        this.g = new Logger("GestureProcessor");
        this.c.p = this;
    }

    public final void a(@NotNull MotionEvent event, @NotNull ViewGroup parent) {
        VelocityTracker velocityTracker;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(parent, "decorView");
        if (event.getPointerCount() > 1) {
            this.g.d("event with multiple pointers skipped");
            return;
        }
        int action = event.getAction();
        if (action == 0) {
            this.c.a();
            Y1 y1 = this.c;
            y1.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(parent, "decorView");
            y1.a(event);
            F7 f7 = y1.q;
            int i = y1.e;
            int i2 = y1.f;
            f7.getClass();
            Intrinsics.checkNotNullParameter(parent, "parent");
            x8<View> x8Var = new x8<>();
            E7 processor = new E7(x8Var, i, i2);
            Predicate<View> viewFilter = f7.a;
            Intrinsics.checkNotNullParameter(processor, "processor");
            Intrinsics.checkNotNullParameter(viewFilter, "viewFilter");
            new K2(processor, viewFilter).a(parent);
            y1.r = x8Var;
            this.g.d("processed MotionEvent.ACTION_DOWN event type");
            return;
        }
        if (action == 1) {
            this.c.b(event);
            Y1 y12 = new Y1(this.b, this.a, new SystemInstantiable(), new C0627a6());
            this.c = y12;
            y12.p = this;
            this.g.d("processed MotionEvent.ACTION_UP event type");
            return;
        }
        if (action != 2) {
            Y1 y13 = new Y1(this.b, this.a, new SystemInstantiable(), new C0627a6());
            this.c = y13;
            y13.p = this;
            this.g.w("received unhandled event type: " + event);
            return;
        }
        Y1 y14 = this.c;
        y14.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        if (y14.m != Long.MIN_VALUE && (velocityTracker = y14.c) != null) {
            velocityTracker.addMovement(event);
        }
        this.g.d("processed MotionEvent.ACTION_MOVE event type");
    }
}

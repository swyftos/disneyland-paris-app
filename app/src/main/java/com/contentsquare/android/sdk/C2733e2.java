package com.contentsquare.android.sdk;

import android.app.Application;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Predicate;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.e2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2733e2 implements C2665X1.a {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2494F7 f2570a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Application f2571b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public C2674Y1 f2572c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2478E1 f2573d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final C2780j f2574e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final C2753g2 f2575f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final Logger f2576g;

    @JvmOverloads
    public C2733e2() {
        this(null, 63);
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m1118a(View view) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: b */
    public final void m1120b(@Nullable C2743f2 gestureResult) {
        int i;
        IBinder windowToken;
        Logger logger;
        String str;
        Object obj;
        String touchPath;
        AbstractC2730e.a<?> aVar;
        this.f2576g.m827d("processGestureResult() called with result [" + gestureResult + AbstractJsonLexerKt.END_LIST);
        if (gestureResult.f2602c == null) {
            return;
        }
        C2753g2 c2753g2 = this.f2575f;
        c2753g2.getClass();
        Intrinsics.checkNotNullParameter(gestureResult, "gestureResult");
        int i2 = gestureResult.f2601b;
        AbstractC2730e.a<?> aVar2 = null;
        aVar2 = null;
        if ((i2 == 9 || i2 == 10) && ((i = gestureResult.f2603d) == 1 || i == 2)) {
            C2929x8<View> c2929x8 = gestureResult.f2610k;
            if (c2929x8 != null) {
                C2929x8.a aVar3 = c2929x8.f3247a;
                while (true) {
                    if (aVar3 == null) {
                        obj = null;
                        break;
                    }
                    obj = aVar3.f3249a.get();
                    if (obj != null) {
                        break;
                    } else {
                        aVar3 = aVar3.f3250b;
                    }
                }
                View view = (View) obj;
                if (view != null) {
                    windowToken = view.getWindowToken();
                } else {
                    windowToken = null;
                }
            } else {
                windowToken = null;
            }
            if (windowToken != null) {
                c2753g2.f2660b = new C2753g2.a(windowToken, (int) gestureResult.f2606g, (int) gestureResult.f2607h);
                logger = c2753g2.f2659a;
                str = "vertical scroll gesture target saved";
            } else {
                logger = c2753g2.f2659a;
                str = "vertical scroll gesture skipped, target not found";
            }
            logger.m827d(str);
        } else {
            c2753g2.f2659a.m827d("gesture skipped, not vertical scroll: gesture=" + gestureResult.f2601b);
        }
        int i3 = gestureResult.f2601b;
        if (i3 != -1) {
            if (i3 != 6) {
                switch (i3) {
                    case 8:
                        C2618S2.a aVar4 = (C2618S2.a) C2478E1.m901a(this.f2573d, 8);
                        InterfaceC2679Y6 interfaceC2679Y6 = gestureResult.f2602c;
                        String strMo1022a = interfaceC2679Y6 != null ? interfaceC2679Y6.mo1022a() : null;
                        touchPath = strMo1022a != null ? strMo1022a : "";
                        Intrinsics.checkNotNullParameter(touchPath, "touchPath");
                        aVar4.f2084k = touchPath;
                        aVar = aVar4;
                        break;
                    case 9:
                        C2742f1.a aVar5 = (C2742f1.a) C2478E1.m901a(this.f2573d, 9);
                        InterfaceC2679Y6 interfaceC2679Y7 = gestureResult.f2602c;
                        String strMo1022a2 = interfaceC2679Y7 != null ? interfaceC2679Y7.mo1022a() : null;
                        touchPath = strMo1022a2 != null ? strMo1022a2 : "";
                        Intrinsics.checkNotNullParameter(touchPath, "touchPath");
                        aVar5.f2596k = touchPath;
                        aVar5.f2597l = gestureResult.f2603d;
                        aVar5.f2598m = (int) gestureResult.f2604e;
                        aVar5.f2599n = (int) gestureResult.f2605f;
                        aVar = aVar5;
                        break;
                    case 10:
                        C2607R1.a aVar6 = (C2607R1.a) C2478E1.m901a(this.f2573d, 10);
                        InterfaceC2679Y6 interfaceC2679Y8 = gestureResult.f2602c;
                        String strMo1022a3 = interfaceC2679Y8 != null ? interfaceC2679Y8.mo1022a() : null;
                        touchPath = strMo1022a3 != null ? strMo1022a3 : "";
                        Intrinsics.checkNotNullParameter(touchPath, "touchPath");
                        aVar6.f2055k = touchPath;
                        aVar6.f2056l = gestureResult.f2603d;
                        aVar6.f2057m = (int) gestureResult.f2604e;
                        aVar6.f2058n = (int) gestureResult.f2605f;
                        aVar = aVar6;
                        break;
                    default:
                        this.f2576g.m827d("GestureProcessor: Failed to get event for type: " + gestureResult.f2601b);
                        break;
                }
            } else {
                C2670X6.a aVar7 = (C2670X6.a) C2478E1.m901a(this.f2573d, 6);
                InterfaceC2679Y6 interfaceC2679Y9 = gestureResult.f2602c;
                String strMo1022a4 = interfaceC2679Y9 != null ? interfaceC2679Y9.mo1022a() : null;
                touchPath = strMo1022a4 != null ? strMo1022a4 : "";
                Intrinsics.checkNotNullParameter(touchPath, "touchPath");
                aVar7.f2277k = touchPath;
                aVar7.f2278l = gestureResult.f2600a;
                aVar = aVar7;
            }
            aVar2 = aVar;
        }
        if (aVar2 != null) {
            this.f2574e.m1159a(aVar2);
            this.f2576g.m827d("message sent to the reservoir: [ " + aVar2 + " ]");
        }
    }

    public /* synthetic */ C2733e2(C2494F7 c2494f7, int i) {
        C2494F7 c2494f8 = (i & 1) != 0 ? new C2494F7(new Predicate() { // from class: com.contentsquare.android.sdk.e2$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return C2733e2.m1118a((View) obj);
            }
        }) : c2494f7;
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        Intrinsics.checkNotNull(csApplicationModule);
        Application application = csApplicationModule.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getInstance()!!.application");
        CsApplicationModule csApplicationModule2 = CsApplicationModule.getInstance();
        Intrinsics.checkNotNull(csApplicationModule2);
        Application application2 = csApplicationModule2.getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getInstance()!!.application");
        C2674Y1 c2674y1 = new C2674Y1(application2, c2494f8, new SystemInstantiable(), new C2697a6());
        CsApplicationModule csApplicationModule3 = CsApplicationModule.getInstance();
        Intrinsics.checkNotNull(csApplicationModule3);
        C2478E1 eventsBuildersFactory = csApplicationModule3.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "getInstance()!!.eventsBuildersFactory");
        CsApplicationModule csApplicationModule4 = CsApplicationModule.getInstance();
        Intrinsics.checkNotNull(csApplicationModule4);
        C2780j analyticsPipeline = csApplicationModule4.getAnalyticsPipeline();
        Intrinsics.checkNotNullExpressionValue(analyticsPipeline, "getInstance()!!.analyticsPipeline");
        this(c2494f8, application, c2674y1, eventsBuildersFactory, analyticsPipeline, new C2753g2());
    }

    @Override // com.contentsquare.android.sdk.C2665X1.a
    /* JADX INFO: renamed from: a */
    public final void mo1070a(@NotNull C2743f2 result) {
        String path;
        Intrinsics.checkNotNullParameter(result, "result");
        this.f2576g.m827d("onGestureDetected() called with result [" + result + AbstractJsonLexerKt.END_LIST);
        InterfaceC2679Y6 interfaceC2679Y6 = result.f2602c;
        if (interfaceC2679Y6 != null && (path = interfaceC2679Y6.mo1022a()) != null) {
            if (C2743f2.a.m1126a(path)) {
                return;
            }
            Intrinsics.checkNotNullParameter(path, "path");
            if (StringsKt.contains$default((CharSequence) path, (CharSequence) ">FlutterView", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) path, (CharSequence) ">PlatformViewWrapper", false, 2, (Object) null)) {
                return;
            }
        }
        m1120b(result);
    }

    @JvmOverloads
    public C2733e2(@NotNull C2494F7 touchTargetDetector, @NotNull Application application, @NotNull C2674Y1 gestureDetector, @NotNull C2478E1 eventsBuildersFactory, @NotNull C2780j analyticsPipeline, @NotNull C2753g2 gestureStorage) {
        Intrinsics.checkNotNullParameter(touchTargetDetector, "touchTargetDetector");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(gestureDetector, "gestureDetector");
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(gestureStorage, "gestureStorage");
        this.f2570a = touchTargetDetector;
        this.f2571b = application;
        this.f2572c = gestureDetector;
        this.f2573d = eventsBuildersFactory;
        this.f2574e = analyticsPipeline;
        this.f2575f = gestureStorage;
        this.f2576g = new Logger("GestureProcessor");
        this.f2572c.f2250p = this;
    }

    /* JADX INFO: renamed from: a */
    public final void m1119a(@NotNull MotionEvent event, @NotNull ViewGroup parent) {
        VelocityTracker velocityTracker;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(parent, "decorView");
        if (event.getPointerCount() > 1) {
            this.f2576g.m827d("event with multiple pointers skipped");
            return;
        }
        int action = event.getAction();
        if (action == 0) {
            this.f2572c.mo1066a();
            C2674Y1 c2674y1 = this.f2572c;
            c2674y1.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(parent, "decorView");
            c2674y1.m1067a(event);
            C2494F7 c2494f7 = c2674y1.f2291q;
            int i = c2674y1.f2239e;
            int i2 = c2674y1.f2240f;
            c2494f7.getClass();
            Intrinsics.checkNotNullParameter(parent, "parent");
            C2929x8<View> c2929x8 = new C2929x8<>();
            C2484E7 processor = new C2484E7(c2929x8, i, i2);
            Predicate<View> viewFilter = c2494f7.f1621a;
            Intrinsics.checkNotNullParameter(processor, "processor");
            Intrinsics.checkNotNullParameter(viewFilter, "viewFilter");
            new C2539K2(processor, viewFilter).m964a(parent);
            c2674y1.f2292r = c2929x8;
            this.f2576g.m827d("processed MotionEvent.ACTION_DOWN event type");
            return;
        }
        if (action == 1) {
            this.f2572c.m1069b(event);
            C2674Y1 c2674y2 = new C2674Y1(this.f2571b, this.f2570a, new SystemInstantiable(), new C2697a6());
            this.f2572c = c2674y2;
            c2674y2.f2250p = this;
            this.f2576g.m827d("processed MotionEvent.ACTION_UP event type");
            return;
        }
        if (action != 2) {
            C2674Y1 c2674y3 = new C2674Y1(this.f2571b, this.f2570a, new SystemInstantiable(), new C2697a6());
            this.f2572c = c2674y3;
            c2674y3.f2250p = this;
            this.f2576g.m834w("received unhandled event type: " + event);
            return;
        }
        C2674Y1 c2674y4 = this.f2572c;
        c2674y4.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        if (c2674y4.f2247m != Long.MIN_VALUE && (velocityTracker = c2674y4.f2237c) != null) {
            velocityTracker.addMovement(event);
        }
        this.f2576g.m827d("processed MotionEvent.ACTION_MOVE event type");
    }
}

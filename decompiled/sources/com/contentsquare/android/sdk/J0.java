package com.contentsquare.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.core.util.Predicate;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.sdk.C;
import com.contentsquare.android.sdk.C0680g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nCsActivityCallbacks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CsActivityCallbacks.kt\ncom/contentsquare/android/analytics/internal/listeners/CsActivityCallbacks\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,307:1\n1#2:308\n*E\n"})
/* loaded from: classes2.dex */
public final class J0 implements Application.ActivityLifecycleCallbacks {

    @VisibleForTesting
    @NotNull
    public final L2 a;

    @NotNull
    public final I1 b;

    @NotNull
    public final C0710j c;

    @NotNull
    public final List<Predicate<Activity>> d;

    @NotNull
    public final C0676f5 e;

    @NotNull
    public final E1 f;

    @NotNull
    public final InterfaceC0832v2 g;

    @NotNull
    public final C0696h5 h;

    @NotNull
    public final M2 i;

    @NotNull
    public final DeviceInfo j;

    @NotNull
    public final ViewTreeObserverOnGlobalLayoutListenerC0825u5 k;

    @NotNull
    public final Logger l;

    @Nullable
    public Activity m;

    @NotNull
    public final Handler n;

    @Nullable
    public Runnable o;

    @NotNull
    public final Consumer<Activity> p;

    @NotNull
    public final I0 q;

    @NotNull
    public final Consumer<Activity> r;

    @JvmOverloads
    public J0() {
        throw null;
    }

    @JvmOverloads
    public J0(@NotNull L2 legacyComponentsHolder, @NotNull I1 eventsStatusPrefsHelper, @NotNull C0710j analyticsPipeline, @NotNull List notToBeTrackedActivityFilters, @NotNull E1 eventsBuildersFactory, @NotNull InterfaceC0832v2 gesturesInterceptor, @NotNull C0696h5 screenViewHandler, @NotNull M2 liveActivityProvider, @NotNull DeviceInfo deviceInfo, @NotNull ViewTreeObserverOnGlobalLayoutListenerC0825u5 scrollWatcherController) {
        C0676f5 screenViewEventsHandler = C0676f5.a;
        Intrinsics.checkNotNullParameter(legacyComponentsHolder, "legacyComponentsHolder");
        Intrinsics.checkNotNullParameter(eventsStatusPrefsHelper, "eventsStatusPrefsHelper");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(notToBeTrackedActivityFilters, "notToBeTrackedActivityFilters");
        Intrinsics.checkNotNullParameter(screenViewEventsHandler, "screenViewEventsHandler");
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(gesturesInterceptor, "gesturesInterceptor");
        Intrinsics.checkNotNullParameter(screenViewHandler, "screenViewHandler");
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(scrollWatcherController, "scrollWatcherController");
        this.a = legacyComponentsHolder;
        this.b = eventsStatusPrefsHelper;
        this.c = analyticsPipeline;
        this.d = notToBeTrackedActivityFilters;
        this.e = screenViewEventsHandler;
        this.f = eventsBuildersFactory;
        this.g = gesturesInterceptor;
        this.h = screenViewHandler;
        this.i = liveActivityProvider;
        this.j = deviceInfo;
        this.k = scrollWatcherController;
        this.l = new Logger("CsActivityCallbacks");
        this.n = new Handler(Looper.getMainLooper());
        H0 h0 = new H0(this);
        scrollWatcherController.getClass();
        Intrinsics.checkNotNullParameter(h0, "<set-?>");
        scrollWatcherController.b = h0;
        this.p = new Consumer() { // from class: com.contentsquare.android.sdk.J0$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                J0.b(this.f$0, (Activity) obj);
            }
        };
        this.q = new I0(this);
        this.r = new Consumer() { // from class: com.contentsquare.android.sdk.J0$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                J0.a(this.f$0, (Activity) obj);
            }
        };
    }

    public static void a(Activity activity, Consumer consumer, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Predicate) it.next()).test(activity)) {
                return;
            }
        }
        consumer.accept(activity);
    }

    public static final void b(J0 this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activity != null) {
            ((C0723k2) this$0.g).b(activity);
            ViewTreeObserverOnGlobalLayoutListenerC0825u5 viewTreeObserverOnGlobalLayoutListenerC0825u5 = this$0.k;
            viewTreeObserverOnGlobalLayoutListenerC0825u5.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            WeakHashMap<View, InterfaceC0795r5> weakHashMap = viewTreeObserverOnGlobalLayoutListenerC0825u5.c.get(activity);
            if (weakHashMap != null) {
                Iterator<Map.Entry<View, InterfaceC0795r5>> it = weakHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().clear();
                }
                weakHashMap.clear();
            }
        } else {
            this$0.l.d("[onActivityPaused]: the activity was null when trying to detach interceptors");
        }
        this$0.m = null;
        this$0.a();
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
        a(activity, this.p, this.d);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        a(activity, this.q, this.d);
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

    public static final void a(J0 this$0, Activity target) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m = target;
        C0696h5 c0696h5 = this$0.h;
        this$0.e.getClass();
        c0696h5.b(C0676f5.b);
        InterfaceC0832v2 interfaceC0832v2 = this$0.g;
        Intrinsics.checkNotNullExpressionValue(target, "target");
        ((C0723k2) interfaceC0832v2).a(target);
        this$0.k.a(target);
        String name = target.getClass().getCanonicalName();
        if (name != null) {
            L2 l2 = this$0.a;
            l2.getClass();
            Intrinsics.checkNotNullParameter(name, "name");
            E1 eventsBuildersFactory = l2.k.getEventsBuildersFactory();
            Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
            C0680g.a aVar = (C0680g.a) E1.a(eventsBuildersFactory, 30);
            aVar.k = name;
            l2.c.a(aVar);
        }
    }

    @VisibleForTesting
    public final void a() {
        final C.a aVar = (C.a) E1.a(this.f, 2);
        C event = new C(aVar);
        Logger logger = E2.a;
        Intrinsics.checkNotNullParameter(event, "event");
        String serializedJson = E2.c(event).toString();
        Intrinsics.checkNotNullExpressionValue(serializedJson, "serializedHideEvent.toString()");
        this.b.a.putBoolean(PreferencesKey.IS_HIDE_EVENT_PENDING, true);
        I1 i1 = this.b;
        i1.getClass();
        Intrinsics.checkNotNullParameter(serializedJson, "serializedJson");
        i1.a.putString(PreferencesKey.SCHEDULED_APP_HIDE_EVENT, serializedJson);
        Runnable runnable = new Runnable() { // from class: com.contentsquare.android.sdk.J0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                J0.a(this.f$0, aVar);
            }
        };
        this.o = runnable;
        this.l.d("scheduling hide");
        this.n.postDelayed(runnable, 700L);
    }

    public static final void a(J0 this$0, C.a builder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(builder, "$builder");
        this$0.c.a(builder);
        this$0.b.a.remove(PreferencesKey.IS_HIDE_EVENT_PENDING);
        this$0.a.e.a();
        this$0.h.d.d = true;
        this$0.o = null;
    }
}

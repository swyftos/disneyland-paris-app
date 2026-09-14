package com.contentsquare.android.sdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.contentsquare.android.C2362R;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.u5 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nScrollWatcherController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScrollWatcherController.kt\ncom/contentsquare/android/analytics/internal/exposuremetrics/scroll/ScrollWatcherController\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,149:1\n215#2,2:150\n361#3,7:152\n361#3,7:161\n1#4:159\n1855#5:160\n1856#5:168\n1295#6,2:169\n*S KotlinDebug\n*F\n+ 1 ScrollWatcherController.kt\ncom/contentsquare/android/analytics/internal/exposuremetrics/scroll/ScrollWatcherController\n*L\n47#1:150,2\n53#1:152,7\n74#1:161,7\n73#1:160\n73#1:168\n139#1:169,2\n*E\n"})
public final class ViewTreeObserverOnGlobalLayoutListenerC2896u5 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final Logger f3151e = new Logger("ScrollWatcherController");

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2906v5 f3152a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public Function3<? super Integer, ? super Integer, ? super Long, Unit> f3153b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final WeakHashMap<Activity, WeakHashMap<View, InterfaceC2866r5>> f3154c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public Activity f3155d;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.u5$a */
    public static final class a extends Lambda implements Function3<Integer, Integer, Long, Unit> {

        /* JADX INFO: renamed from: a */
        public static final a f3156a = new a();

        public a() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public final /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Long l) {
            num.intValue();
            num2.intValue();
            l.longValue();
            return Unit.INSTANCE;
        }
    }

    public ViewTreeObserverOnGlobalLayoutListenerC2896u5(@NotNull C2906v5 scrollWatcherFactory) {
        Intrinsics.checkNotNullParameter(scrollWatcherFactory, "scrollWatcherFactory");
        this.f3152a = scrollWatcherFactory;
        this.f3153b = a.f3156a;
        this.f3154c = new WeakHashMap<>();
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: c */
    public static boolean m1211c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (view instanceof RecyclerView) || (view instanceof ScrollView) || (view instanceof HorizontalScrollView) || (view instanceof NestedScrollView);
    }

    /* JADX INFO: renamed from: a */
    public final void m1212a(@NotNull Activity activity) {
        View decorView;
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(activity, "activity");
        WeakHashMap<Activity, WeakHashMap<View, InterfaceC2866r5>> weakHashMap = this.f3154c;
        if (weakHashMap.get(activity) == null) {
            weakHashMap.put(activity, new WeakHashMap<>());
        }
        m1213b(activity);
        Window window = activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        Activity activity2 = this.f3155d;
        if (activity2 != null) {
            View decorView2 = activity2.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView2, "activity.window.decorView");
            decorView2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        this.f3155d = activity;
    }

    /* JADX INFO: renamed from: b */
    public final void m1213b(Activity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        m1209a(decorView, new C2876s5(arrayList), new C2886t5(this));
        View view = (View) CollectionsKt.firstOrNull((List) arrayList);
        if (view != null) {
            ArrayList<View> arrayList2 = new ArrayList();
            m1209a(view, new C2876s5(arrayList2), new C2886t5(this));
            for (View view2 : arrayList2) {
                WeakHashMap weakHashMap = this.f3154c.get(activity);
                if (weakHashMap != null) {
                    Intrinsics.checkNotNullExpressionValue(weakHashMap, "activitiesWatchers[activity]");
                    Object obj = weakHashMap.get(view2);
                    Object obj2 = obj;
                    if (obj == null) {
                        C2906v5 c2906v5 = this.f3152a;
                        c2906v5.getClass();
                        Intrinsics.checkNotNullParameter(view2, "view");
                        AbstractC2720d c2451b4 = view2 instanceof RecyclerView ? new C2451B4((RecyclerView) view2, c2906v5.f3192a) : new ViewTreeObserverOnScrollChangedListenerC2856q5(view2, c2906v5.f3192a);
                        Function3<? super Integer, ? super Integer, ? super Long, Unit> listener = this.f3153b;
                        Intrinsics.checkNotNullParameter(listener, "listener");
                        c2451b4.f2485f = listener;
                        c2451b4.m1113a(new C2710c(c2451b4));
                        weakHashMap.put(view2, c2451b4);
                        obj2 = c2451b4;
                    }
                }
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Activity activity = this.f3155d;
        if (activity != null) {
            m1213b(activity);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1208a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.EXPOSURE_METRICS)) {
            f3151e.m834w("View is not excluded from Exposure Metric: feature is not enabled.");
            return;
        }
        if (m1211c(view)) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!(view instanceof WebView) && !ExtensionsKt.isDerivedInstanceOf(view, "NavigationMenuView") && !StringsKt.startsWith$default("javaClass", "androidx.viewpager2.widget.ViewPager2", false, 2, (Object) null)) {
                view.setTag(C2362R.id.contentsquare_exclude_from_exposure_metric, Boolean.TRUE);
                f3151e.m831i("View excluded from Exposure Metric: " + view);
                return;
            }
        }
        f3151e.m834w("View is not excluded from Exposure Metric: view is not supported: " + view);
    }

    /* JADX INFO: renamed from: a */
    public static void m1209a(View view, C2876s5 c2876s5, C2886t5 c2886t5) {
        if (((Boolean) c2886t5.invoke(view)).booleanValue()) {
            c2876s5.invoke(view);
        }
        if (view instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                m1209a(it.next(), c2876s5, c2886t5);
            }
        }
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: b */
    public static boolean m1210b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.getTag(C2362R.id.contentsquare_exclude_from_exposure_metric) != null;
    }
}

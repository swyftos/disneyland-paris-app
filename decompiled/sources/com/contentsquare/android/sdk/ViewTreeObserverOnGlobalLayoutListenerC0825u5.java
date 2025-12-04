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
import com.contentsquare.android.R;
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

@SourceDebugExtension({"SMAP\nScrollWatcherController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScrollWatcherController.kt\ncom/contentsquare/android/analytics/internal/exposuremetrics/scroll/ScrollWatcherController\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,149:1\n215#2,2:150\n361#3,7:152\n361#3,7:161\n1#4:159\n1855#5:160\n1856#5:168\n1295#6,2:169\n*S KotlinDebug\n*F\n+ 1 ScrollWatcherController.kt\ncom/contentsquare/android/analytics/internal/exposuremetrics/scroll/ScrollWatcherController\n*L\n47#1:150,2\n53#1:152,7\n74#1:161,7\n73#1:160\n73#1:168\n139#1:169,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.u5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC0825u5 implements ViewTreeObserver.OnGlobalLayoutListener {

    @NotNull
    public static final Logger e = new Logger("ScrollWatcherController");

    @NotNull
    public final C0835v5 a;

    @NotNull
    public Function3<? super Integer, ? super Integer, ? super Long, Unit> b;

    @NotNull
    public final WeakHashMap<Activity, WeakHashMap<View, InterfaceC0795r5>> c;

    @Nullable
    public Activity d;

    /* renamed from: com.contentsquare.android.sdk.u5$a */
    public static final class a extends Lambda implements Function3<Integer, Integer, Long, Unit> {
        public static final a a = new a();

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

    public ViewTreeObserverOnGlobalLayoutListenerC0825u5(@NotNull C0835v5 scrollWatcherFactory) {
        Intrinsics.checkNotNullParameter(scrollWatcherFactory, "scrollWatcherFactory");
        this.a = scrollWatcherFactory;
        this.b = a.a;
        this.c = new WeakHashMap<>();
    }

    @VisibleForTesting
    public static boolean c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (view instanceof RecyclerView) || (view instanceof ScrollView) || (view instanceof HorizontalScrollView) || (view instanceof NestedScrollView);
    }

    public final void a(@NotNull Activity activity) {
        View decorView;
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(activity, "activity");
        WeakHashMap<Activity, WeakHashMap<View, InterfaceC0795r5>> weakHashMap = this.c;
        if (weakHashMap.get(activity) == null) {
            weakHashMap.put(activity, new WeakHashMap<>());
        }
        b(activity);
        Window window = activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        Activity activity2 = this.d;
        if (activity2 != null) {
            View decorView2 = activity2.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView2, "activity.window.decorView");
            decorView2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        this.d = activity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.contentsquare.android.sdk.B4] */
    public final void b(Activity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        a(decorView, new C0805s5(arrayList), new C0815t5(this));
        View view = (View) CollectionsKt.firstOrNull((List) arrayList);
        if (view != null) {
            ArrayList arrayList2 = new ArrayList();
            a(view, new C0805s5(arrayList2), new C0815t5(this));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                WeakHashMap weakHashMap = this.c.get(activity);
                if (weakHashMap != null) {
                    Intrinsics.checkNotNullExpressionValue(weakHashMap, "activitiesWatchers[activity]");
                    Object obj = weakHashMap.get(view2);
                    Object obj2 = obj;
                    if (obj == null) {
                        C0835v5 c0835v5 = this.a;
                        c0835v5.getClass();
                        Intrinsics.checkNotNullParameter(view2, "view");
                        ViewTreeObserverOnScrollChangedListenerC0786q5 b4 = view2 instanceof RecyclerView ? new B4((RecyclerView) view2, c0835v5.a) : new ViewTreeObserverOnScrollChangedListenerC0786q5(view2, c0835v5.a);
                        Function3<? super Integer, ? super Integer, ? super Long, Unit> listener = this.b;
                        Intrinsics.checkNotNullParameter(listener, "listener");
                        b4.f = listener;
                        b4.a(new C0640c(b4));
                        weakHashMap.put(view2, b4);
                        obj2 = b4;
                    }
                }
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Activity activity = this.d;
        if (activity != null) {
            b(activity);
        }
    }

    public static void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.EXPOSURE_METRICS)) {
            e.w("View is not excluded from Exposure Metric: feature is not enabled.");
            return;
        }
        if (c(view)) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!(view instanceof WebView) && !ExtensionsKt.isDerivedInstanceOf(view, "NavigationMenuView") && !StringsKt.startsWith$default("javaClass", "androidx.viewpager2.widget.ViewPager2", false, 2, (Object) null)) {
                view.setTag(R.id.contentsquare_exclude_from_exposure_metric, Boolean.TRUE);
                e.i("View excluded from Exposure Metric: " + view);
                return;
            }
        }
        e.w("View is not excluded from Exposure Metric: view is not supported: " + view);
    }

    public static void a(View view, C0805s5 c0805s5, C0815t5 c0815t5) {
        if (((Boolean) c0815t5.invoke(view)).booleanValue()) {
            c0805s5.invoke(view);
        }
        if (view instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                a(it.next(), c0805s5, c0815t5);
            }
        }
    }

    @VisibleForTesting
    public static boolean b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.getTag(R.id.contentsquare_exclude_from_exposure_metric) != null;
    }
}

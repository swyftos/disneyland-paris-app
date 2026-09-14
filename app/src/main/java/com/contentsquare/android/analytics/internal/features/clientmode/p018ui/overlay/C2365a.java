package com.contentsquare.android.analytics.internal.features.clientmode.p018ui.overlay;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.C2362R;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.sdk.AbstractC2686Z4;
import com.contentsquare.android.sdk.AbstractC2707b6;
import com.contentsquare.android.sdk.AbstractC2725d4;
import com.contentsquare.android.sdk.AbstractC2898u7;
import com.contentsquare.android.sdk.AbstractC2911w0;
import com.contentsquare.android.sdk.AbstractC2916w5;
import com.contentsquare.android.sdk.C2559M2;
import com.contentsquare.android.sdk.C2573N6;
import com.contentsquare.android.sdk.C2583O6;
import com.contentsquare.android.sdk.C2593P6;
import com.contentsquare.android.sdk.C2603Q6;
import com.contentsquare.android.sdk.C2638U2;
import com.contentsquare.android.sdk.C2657W2;
import com.contentsquare.android.sdk.C2722d1;
import com.contentsquare.android.sdk.C2801l0;
import com.contentsquare.android.sdk.DialogFragmentC2712c1;
import com.contentsquare.android.sdk.ViewTreeObserverOnGlobalLayoutListenerC2944z3;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a */
/* JADX INFO: loaded from: classes2.dex */
public final class C2365a {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final StateFlow<AbstractC2686Z4> f1141a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Context f1142b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final WindowManager f1143c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2559M2 f1144d;

    /* JADX INFO: renamed from: e */
    public View f1145e;

    /* JADX INFO: renamed from: f */
    public WindowManager.LayoutParams f1146f;

    /* JADX INFO: renamed from: g */
    public ValueAnimator f1147g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public C2573N6 f1148h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public C2657W2 f1149i;

    /* JADX INFO: renamed from: j */
    public int f1150j;

    /* JADX INFO: renamed from: k */
    public int f1151k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public a f1152l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public Job f1153m;

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo777a();

        /* JADX INFO: renamed from: b */
        void mo778b();

        /* JADX INFO: renamed from: c */
        void mo779c();

        /* JADX INFO: renamed from: d */
        void mo780d();

        /* JADX INFO: renamed from: e */
        void mo781e();
    }

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$b */
    public final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final d f1154a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C2365a f1155b;

        public b(@NotNull C2365a c2365a, d fabTouchedListener) {
            Intrinsics.checkNotNullParameter(fabTouchedListener, "fabTouchedListener");
            this.f1155b = c2365a;
            this.f1154a = fabTouchedListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(@NotNull View view) {
            a aVar;
            Intrinsics.checkNotNullParameter(view, "view");
            if (!this.f1154a.f1162e || (aVar = this.f1155b.f1152l) == null) {
                return;
            }
            aVar.mo779c();
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$c */
    public final class c implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final d f1156a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C2365a f1157b;

        public c(@NotNull C2365a c2365a, d fabTouchedListener) {
            Intrinsics.checkNotNullParameter(fabTouchedListener, "fabTouchedListener");
            this.f1157b = c2365a;
            this.f1156a = fabTouchedListener;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(@NotNull View view) {
            a aVar;
            Intrinsics.checkNotNullParameter(view, "view");
            if (!this.f1156a.f1162e || (aVar = this.f1157b.f1152l) == null) {
                return true;
            }
            aVar.mo778b();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$e */
    public final class e implements FlowCollector<AbstractC2686Z4> {
        public e() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(AbstractC2686Z4 abstractC2686Z4, Continuation continuation) {
            C2365a c2365a;
            int i;
            C2573N6 c2573n6;
            Function1<? super C2722d1, Unit> function1;
            AbstractC2898u7.b bVar;
            int i2;
            AbstractC2686Z4 value = C2365a.this.f1141a.getValue();
            if (!(value instanceof AbstractC2686Z4.c)) {
                if (value instanceof AbstractC2686Z4.a) {
                    C2573N6 c2573n7 = C2365a.this.f1148h;
                    if (c2573n7 != null) {
                        AbstractC2686Z4.a failureState = (AbstractC2686Z4.a) value;
                        Intrinsics.checkNotNullParameter(failureState, "failureState");
                        Function1<? super C2722d1, Unit> function2 = c2573n7.f1893d;
                        if (function2 != null) {
                            AbstractC2686Z4.b bVar2 = failureState.f2328a;
                            if (bVar2 instanceof AbstractC2686Z4.b.d) {
                                i2 = C2362R.string.contentsquare_snapshot_status_failed_no_screenview;
                            } else if (bVar2 instanceof AbstractC2686Z4.b.c) {
                                i2 = C2362R.string.contentsquare_snapshot_status_failed_network;
                            } else {
                                i2 = bVar2 instanceof AbstractC2686Z4.b.C8141b ? C2362R.string.contentsquare_snapshot_status_failed_min_api_level : C2362R.string.contentsquare_snapshot_status_failed;
                            }
                            function2.invoke(new C2722d1(new AbstractC2898u7.a(i2), new AbstractC2898u7.a(C2362R.string.contentsquare_snapshot_cancel_summary), new AbstractC2725d4.b(C2362R.drawable.contentsquare_img_snapshot_failure), null, new C2801l0(C2362R.string.contentsquare_snapshot_status_cancel, new C2583O6(c2573n7)), 8));
                        }
                    }
                } else {
                    boolean z = true;
                    if (value instanceof AbstractC2686Z4.h) {
                        C2573N6 c2573n8 = C2365a.this.f1148h;
                        if (c2573n8 != null) {
                            AbstractC2686Z4.h successState = (AbstractC2686Z4.h) value;
                            Intrinsics.checkNotNullParameter(successState, "successState");
                            Activity activity = c2573n8.f1890a.f1856a.get();
                            if (activity != null) {
                                String string = activity.getString(C2362R.string.contentsquare_snapshot_screenname_prefix, successState.f2343a);
                                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri… successState.screenName)");
                                SpannableString spannableString = new SpannableString(string);
                                spannableString.setSpan(new StyleSpan(1), string.length() - successState.f2343a.length(), string.length(), 33);
                                bVar = new AbstractC2898u7.b(spannableString);
                            } else {
                                bVar = null;
                            }
                            AbstractC2898u7.b bVar3 = bVar;
                            Function1<? super C2722d1, Unit> function3 = c2573n8.f1893d;
                            if (function3 != null) {
                                function3.invoke(new C2722d1(new AbstractC2898u7.a(C2362R.string.contentsquare_snapshot_status_saved), bVar3, new AbstractC2725d4.b(C2362R.drawable.contentsquare_img_snapshot_success), null, null, 24));
                            }
                            DialogFragmentC2712c1 dialogFragmentC2712c1 = c2573n8.f1892c;
                            if (dialogFragmentC2712c1 != null) {
                                dialogFragmentC2712c1.m1106a();
                            }
                        }
                    } else if (value instanceof AbstractC2686Z4.g) {
                        C2573N6 c2573n9 = C2365a.this.f1148h;
                        if (c2573n9 != null && (function1 = c2573n9.f1893d) != null) {
                            function1.invoke(new C2722d1(new AbstractC2898u7.a(C2362R.string.contentsquare_snapshot_status_sending_title), new AbstractC2898u7.a(C2362R.string.contentsquare_snapshot_status_sending_summary), AbstractC2725d4.a.f2496a, null, null, 24));
                        }
                    } else if (value instanceof AbstractC2686Z4.d) {
                        C2365a c2365a2 = C2365a.this;
                        a aVar = c2365a2.f1152l;
                        if (aVar != null && (c2573n6 = c2365a2.f1148h) != null) {
                            C2366b onResume = new C2366b(aVar);
                            C2367c onCancel = new C2367c(aVar);
                            Intrinsics.checkNotNullParameter(onResume, "onResume");
                            Intrinsics.checkNotNullParameter(onCancel, "onCancel");
                            Function1<? super C2722d1, Unit> function4 = c2573n6.f1893d;
                            if (function4 != null) {
                                function4.invoke(new C2722d1(new AbstractC2898u7.a(C2362R.string.contentsquare_snapshot_cancel_title), new AbstractC2898u7.a(C2362R.string.contentsquare_snapshot_cancel_summary), null, new C2801l0(C2362R.string.contentsquare_snapshot_cancel_yes, new C2593P6(c2573n6, onCancel)), new C2801l0(C2362R.string.contentsquare_snapshot_cancel_no, new C2603Q6(onResume)), 4));
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    } else {
                        if (value instanceof AbstractC2686Z4.e) {
                            c2365a = C2365a.this;
                            i = ((AbstractC2686Z4.e) value).f2340c;
                        } else if (value instanceof AbstractC2686Z4.f) {
                            c2365a = C2365a.this;
                            i = 100;
                            z = false;
                        }
                        c2365a.m775a(i, z);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$f */
    public static final class f extends Lambda implements Function0<Unit> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            View viewM773a = C2365a.this.m773a();
            if (viewM773a != null) {
                viewM773a.setVisibility(0);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$g */
    public static final class g extends Lambda implements Function0<Unit> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            View viewM773a = C2365a.this.m773a();
            if (viewM773a != null) {
                viewM773a.setVisibility(0);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$h */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayLayoutManager$initViews$4", m1845f = "OverlayLayoutManager.kt", m1846i = {}, m1847l = {200}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f1167a;

        public h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C2365a.this.new h(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C2365a.this.new h(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1167a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C2365a c2365a = C2365a.this;
                StateFlow<AbstractC2686Z4> stateFlow = c2365a.f1141a;
                e eVar = c2365a.new e();
                this.f1167a = 1;
                if (stateFlow.collect(eVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$i */
    public static final class i extends Lambda implements Function0<Unit> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            a aVar = C2365a.this.f1152l;
            if (aVar != null) {
                aVar.mo777a();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$j */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayLayoutManager", m1845f = "OverlayLayoutManager.kt", m1846i = {0, 0}, m1847l = {219}, m1848m = "showSnapshotDialog", m1849n = {"this", "config"}, m1850s = {"L$0", "L$1"})
    public static final class j extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2365a f1170a;

        /* JADX INFO: renamed from: b */
        public AbstractC2707b6 f1171b;

        /* JADX INFO: renamed from: c */
        public /* synthetic */ Object f1172c;

        /* JADX INFO: renamed from: e */
        public int f1174e;

        public j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f1172c = obj;
            this.f1174e |= Integer.MIN_VALUE;
            return C2365a.this.m774a((AbstractC2707b6) null, this);
        }
    }

    public C2365a(@NotNull MutableStateFlow snapshotStateFlow, @NotNull Context context, @NotNull WindowManager windowManager, @NotNull C2559M2 liveActivityProvider) {
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        this.f1141a = snapshotStateFlow;
        this.f1142b = context;
        this.f1143c = windowManager;
        this.f1144d = liveActivityProvider;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final View m773a() {
        View view = this.f1145e;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fabLayout");
        return null;
    }

    @SuppressLint({"InflateParams"})
    /* JADX INFO: renamed from: b */
    public final void m776b() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.setDuration(250L);
        this.f1147g = valueAnimator;
        LayoutInflater layoutInflater = LayoutInflater.from(this.f1142b);
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
        View floatingButtonLayout = layoutInflater.inflate(C2362R.layout.contentsquare_floating_widget_layout, (ViewGroup) null, false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2038, 262184, -3);
        layoutParams.windowAnimations = R.style.Animation.Translucent;
        layoutParams.gravity = 8388629;
        this.f1146f = layoutParams;
        this.f1143c.addView(floatingButtonLayout, layoutParams);
        d dVar = new d();
        View viewFindViewById = floatingButtonLayout.findViewById(C2362R.id.client_mode_icon_id);
        ImageView imageView = (ImageView) viewFindViewById;
        imageView.setOnTouchListener(dVar);
        InstrumentationCallbacks.setOnClickListenerCalled(imageView, new b(this, dVar));
        imageView.setOnLongClickListener(new c(this, dVar));
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "floatingButtonLayout.fin…uchedListener))\n        }");
        Intrinsics.checkNotNullExpressionValue(floatingButtonLayout, "floatingButtonLayout");
        floatingButtonLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC2944z3(this));
        Intrinsics.checkNotNullParameter(floatingButtonLayout, "<set-?>");
        this.f1145e = floatingButtonLayout;
        this.f1149i = new C2657W2(this.f1144d, CoreModule.INSTANCE.safeInstance(this.f1142b).getPreferencesStore(), new f());
        this.f1148h = new C2573N6(this.f1144d, new g());
        this.f1153m = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new h(null), 3, null);
    }

    /* JADX INFO: renamed from: a */
    public final void m775a(int i2, boolean z) {
        C2573N6 c2573n6 = this.f1148h;
        if (c2573n6 != null) {
            i iVar = z ? new i() : null;
            Function1<? super C2722d1, Unit> function1 = c2573n6.f1893d;
            if (function1 != null) {
                function1.invoke(new C2722d1(new AbstractC2898u7.a(C2362R.string.contentsquare_snapshot_status_in_progress), new AbstractC2898u7.a(C2362R.string.contentsquare_snapshot_status_in_progress_summary), new AbstractC2725d4.c(i2), iVar != null ? new C2801l0(C2362R.string.contentsquare_snapshot_status_cancel, iVar) : null, null, 16));
            }
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$d */
    public final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a */
        public int f1158a;

        /* JADX INFO: renamed from: b */
        public int f1159b;

        /* JADX INFO: renamed from: c */
        public float f1160c;

        /* JADX INFO: renamed from: d */
        public float f1161d;

        /* JADX INFO: renamed from: e */
        public boolean f1162e = true;

        public d() {
        }

        /* JADX INFO: renamed from: a */
        public final void m783a(final View view, final WindowManager.LayoutParams layoutParams, int i) {
            C2365a.this.getClass();
            Intrinsics.checkNotNullParameter(view, "view");
            int width = view.getWidth();
            int i2 = i - width;
            if ((width / 2) + layoutParams.x < i / 2) {
                i2 = 0;
            }
            ValueAnimator valueAnimator = C2365a.this.f1147g;
            if (valueAnimator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fabAnimator");
                valueAnimator = null;
            }
            final C2365a c2365a = C2365a.this;
            valueAnimator.setFloatValues(layoutParams.x, i2);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$d$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    C2365a.d.m782a(layoutParams, c2365a, view, valueAnimator2);
                }
            });
            valueAnimator.start();
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public final boolean onTouch(@NotNull View view, @NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(event, "event");
            int action = event.getAction();
            WindowManager.LayoutParams layoutParams = null;
            if (action == 0) {
                this.f1162e = true;
                WindowManager.LayoutParams layoutParams2 = C2365a.this.f1146f;
                if (layoutParams2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fabParams");
                } else {
                    layoutParams = layoutParams2;
                }
                this.f1158a = layoutParams.x;
                this.f1159b = layoutParams.y;
                this.f1160c = event.getRawX();
                this.f1161d = event.getRawY();
            } else if (action == 1) {
                View viewM773a = C2365a.this.m773a();
                WindowManager.LayoutParams layoutParams3 = C2365a.this.f1146f;
                if (layoutParams3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fabParams");
                } else {
                    layoutParams = layoutParams3;
                }
                m783a(viewM773a, layoutParams, C2365a.this.f1151k);
            } else if (action == 2) {
                int iCoerceAtLeast = RangesKt.coerceAtLeast(this.f1158a - ((int) (event.getRawX() - this.f1160c)), 0);
                C2365a c2365a = C2365a.this;
                int i = c2365a.f1151k;
                View view2 = c2365a.m773a();
                Intrinsics.checkNotNullParameter(view2, "view");
                int iCoerceAtMost = RangesKt.coerceAtMost(i - view2.getWidth(), iCoerceAtLeast);
                int i2 = C2365a.this.f1150j / 2;
                Pair pair = new Pair(Integer.valueOf(iCoerceAtMost), Integer.valueOf(RangesKt.coerceAtMost(i2, RangesKt.coerceAtLeast(this.f1159b + ((int) (event.getRawY() - this.f1161d)), -i2))));
                WindowManager.LayoutParams layoutParams4 = C2365a.this.f1146f;
                if (layoutParams4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fabParams");
                    layoutParams4 = null;
                }
                layoutParams4.x = ((Number) pair.getFirst()).intValue();
                WindowManager.LayoutParams layoutParams5 = C2365a.this.f1146f;
                if (layoutParams5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fabParams");
                    layoutParams5 = null;
                }
                layoutParams5.y = ((Number) pair.getSecond()).intValue();
                C2365a c2365a2 = C2365a.this;
                WindowManager windowManager = c2365a2.f1143c;
                View viewM773a2 = c2365a2.m773a();
                WindowManager.LayoutParams layoutParams6 = C2365a.this.f1146f;
                if (layoutParams6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fabParams");
                } else {
                    layoutParams = layoutParams6;
                }
                windowManager.updateViewLayout(viewM773a2, layoutParams);
                if (this.f1162e) {
                    this.f1162e = Math.abs(this.f1160c - event.getRawX()) < 70.0f && Math.abs(this.f1161d - event.getRawY()) < 70.0f;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public static final void m782a(WindowManager.LayoutParams fabParams, C2365a this$0, View fabLayout, ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(fabParams, "$fabParams");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(fabLayout, "$fabLayout");
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            fabParams.x = (int) ((Float) animatedValue).floatValue();
            this$0.f1143c.updateViewLayout(fabLayout, fabParams);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m774a(@NotNull AbstractC2707b6 abstractC2707b6, @NotNull Continuation<? super Boolean> continuation) {
        j jVar;
        C2657W2 c2657w2;
        if (continuation instanceof j) {
            jVar = (j) continuation;
            int i2 = jVar.f1174e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                jVar.f1174e = i2 - Integer.MIN_VALUE;
            } else {
                jVar = new j(continuation);
            }
        } else {
            jVar = new j(continuation);
        }
        Object obj = jVar.f1172c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = jVar.f1174e;
        boolean z = false;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            View viewM773a = m773a();
            if (viewM773a != null) {
                viewM773a.setVisibility(8);
            }
            if (((abstractC2707b6 instanceof AbstractC2916w5.b) || (abstractC2707b6 instanceof AbstractC2911w0.a)) && (c2657w2 = this.f1149i) != null) {
                PreferencesStore preferencesStore = c2657w2.f2206b;
                PreferencesKey preferencesKey = PreferencesKey.LONG_SNAPSHOT_EXPLANATION_SHOWN;
                if (!preferencesStore.getBoolean(preferencesKey, false)) {
                    C2657W2 c2657w3 = this.f1149i;
                    if (c2657w3 != null) {
                        c2657w3.f2206b.putBoolean(preferencesKey, true);
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C2638U2(c2657w3, null), 3, null);
                    }
                }
                return Boxing.boxBoolean(z);
            }
            C2573N6 c2573n6 = this.f1148h;
            if (c2573n6 != null) {
                jVar.f1170a = this;
                jVar.f1171b = abstractC2707b6;
                jVar.f1174e = 1;
                if (c2573n6.m991a(jVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            abstractC2707b6 = jVar.f1171b;
            this = jVar.f1170a;
            ResultKt.throwOnFailure(obj);
        }
        this.m775a(0, !(abstractC2707b6 instanceof AbstractC2707b6.a));
        z = true;
        return Boxing.boxBoolean(z);
    }
}

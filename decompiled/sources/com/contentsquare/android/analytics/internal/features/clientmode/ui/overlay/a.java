package com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay;

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
import com.contentsquare.android.R;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.sdk.AbstractC0637b6;
import com.contentsquare.android.sdk.AbstractC0655d4;
import com.contentsquare.android.sdk.AbstractC0827u7;
import com.contentsquare.android.sdk.C0652d1;
import com.contentsquare.android.sdk.C0731l0;
import com.contentsquare.android.sdk.DialogFragmentC0642c1;
import com.contentsquare.android.sdk.M2;
import com.contentsquare.android.sdk.N6;
import com.contentsquare.android.sdk.O6;
import com.contentsquare.android.sdk.P6;
import com.contentsquare.android.sdk.Q6;
import com.contentsquare.android.sdk.ViewTreeObserverOnGlobalLayoutListenerC0869z3;
import com.contentsquare.android.sdk.W2;
import com.contentsquare.android.sdk.Z4;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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

/* loaded from: classes2.dex */
public final class a {

    @NotNull
    public final StateFlow<Z4> a;

    @NotNull
    public final Context b;

    @NotNull
    public final WindowManager c;

    @NotNull
    public final M2 d;
    public View e;
    public WindowManager.LayoutParams f;
    public ValueAnimator g;

    @Nullable
    public N6 h;

    @Nullable
    public W2 i;
    public int j;
    public int k;

    @Nullable
    public InterfaceC0038a l;

    @Nullable
    public Job m;

    /* renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$a, reason: collision with other inner class name */
    public interface InterfaceC0038a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public final class b implements View.OnClickListener {

        @NotNull
        public final d a;
        public final /* synthetic */ a b;

        public b(@NotNull a aVar, d fabTouchedListener) {
            Intrinsics.checkNotNullParameter(fabTouchedListener, "fabTouchedListener");
            this.b = aVar;
            this.a = fabTouchedListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(@NotNull View view) {
            InterfaceC0038a interfaceC0038a;
            Intrinsics.checkNotNullParameter(view, "view");
            if (!this.a.e || (interfaceC0038a = this.b.l) == null) {
                return;
            }
            interfaceC0038a.c();
        }
    }

    public final class c implements View.OnLongClickListener {

        @NotNull
        public final d a;
        public final /* synthetic */ a b;

        public c(@NotNull a aVar, d fabTouchedListener) {
            Intrinsics.checkNotNullParameter(fabTouchedListener, "fabTouchedListener");
            this.b = aVar;
            this.a = fabTouchedListener;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(@NotNull View view) {
            InterfaceC0038a interfaceC0038a;
            Intrinsics.checkNotNullParameter(view, "view");
            if (!this.a.e || (interfaceC0038a = this.b.l) == null) {
                return true;
            }
            interfaceC0038a.b();
            return true;
        }
    }

    public final class e implements FlowCollector<Z4> {
        public e() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Z4 z4, Continuation continuation) {
            a aVar;
            int i;
            N6 n6;
            Function1<? super C0652d1, Unit> function1;
            AbstractC0827u7.b bVar;
            Z4 value = a.this.a.getValue();
            if (!(value instanceof Z4.c)) {
                if (value instanceof Z4.a) {
                    N6 n62 = a.this.h;
                    if (n62 != null) {
                        Z4.a failureState = (Z4.a) value;
                        Intrinsics.checkNotNullParameter(failureState, "failureState");
                        Function1<? super C0652d1, Unit> function12 = n62.d;
                        if (function12 != null) {
                            Z4.b bVar2 = failureState.a;
                            function12.invoke(new C0652d1(new AbstractC0827u7.a(bVar2 instanceof Z4.b.d ? R.string.contentsquare_snapshot_status_failed_no_screenview : bVar2 instanceof Z4.b.c ? R.string.contentsquare_snapshot_status_failed_network : bVar2 instanceof Z4.b.C0045b ? R.string.contentsquare_snapshot_status_failed_min_api_level : R.string.contentsquare_snapshot_status_failed), new AbstractC0827u7.a(R.string.contentsquare_snapshot_cancel_summary), new AbstractC0655d4.b(R.drawable.contentsquare_img_snapshot_failure), null, new C0731l0(R.string.contentsquare_snapshot_status_cancel, new O6(n62)), 8));
                        }
                    }
                } else {
                    boolean z = true;
                    if (value instanceof Z4.h) {
                        N6 n63 = a.this.h;
                        if (n63 != null) {
                            Z4.h successState = (Z4.h) value;
                            Intrinsics.checkNotNullParameter(successState, "successState");
                            Activity activity = n63.a.a.get();
                            if (activity != null) {
                                String string = activity.getString(R.string.contentsquare_snapshot_screenname_prefix, successState.a);
                                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri… successState.screenName)");
                                SpannableString spannableString = new SpannableString(string);
                                spannableString.setSpan(new StyleSpan(1), string.length() - successState.a.length(), string.length(), 33);
                                bVar = new AbstractC0827u7.b(spannableString);
                            } else {
                                bVar = null;
                            }
                            AbstractC0827u7.b bVar3 = bVar;
                            Function1<? super C0652d1, Unit> function13 = n63.d;
                            if (function13 != null) {
                                function13.invoke(new C0652d1(new AbstractC0827u7.a(R.string.contentsquare_snapshot_status_saved), bVar3, new AbstractC0655d4.b(R.drawable.contentsquare_img_snapshot_success), null, null, 24));
                            }
                            DialogFragmentC0642c1 dialogFragmentC0642c1 = n63.c;
                            if (dialogFragmentC0642c1 != null) {
                                dialogFragmentC0642c1.a();
                            }
                        }
                    } else if (value instanceof Z4.g) {
                        N6 n64 = a.this.h;
                        if (n64 != null && (function1 = n64.d) != null) {
                            function1.invoke(new C0652d1(new AbstractC0827u7.a(R.string.contentsquare_snapshot_status_sending_title), new AbstractC0827u7.a(R.string.contentsquare_snapshot_status_sending_summary), AbstractC0655d4.a.a, null, null, 24));
                        }
                    } else if (value instanceof Z4.d) {
                        a aVar2 = a.this;
                        InterfaceC0038a interfaceC0038a = aVar2.l;
                        if (interfaceC0038a != null && (n6 = aVar2.h) != null) {
                            com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.b onResume = new com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.b(interfaceC0038a);
                            com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.c onCancel = new com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.c(interfaceC0038a);
                            Intrinsics.checkNotNullParameter(onResume, "onResume");
                            Intrinsics.checkNotNullParameter(onCancel, "onCancel");
                            Function1<? super C0652d1, Unit> function14 = n6.d;
                            if (function14 != null) {
                                function14.invoke(new C0652d1(new AbstractC0827u7.a(R.string.contentsquare_snapshot_cancel_title), new AbstractC0827u7.a(R.string.contentsquare_snapshot_cancel_summary), null, new C0731l0(R.string.contentsquare_snapshot_cancel_yes, new P6(n6, onCancel)), new C0731l0(R.string.contentsquare_snapshot_cancel_no, new Q6(onResume)), 4));
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    } else {
                        if (value instanceof Z4.e) {
                            aVar = a.this;
                            i = ((Z4.e) value).c;
                        } else if (value instanceof Z4.f) {
                            aVar = a.this;
                            i = 100;
                            z = false;
                        }
                        aVar.a(i, z);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<Unit> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            View viewA = a.this.a();
            if (viewA != null) {
                viewA.setVisibility(0);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<Unit> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            View viewA = a.this.a();
            if (viewA != null) {
                viewA.setVisibility(0);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayLayoutManager$initViews$4", f = "OverlayLayoutManager.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return a.this.new h(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return a.this.new h(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                a aVar = a.this;
                StateFlow<Z4> stateFlow = aVar.a;
                e eVar = aVar.new e();
                this.a = 1;
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

    public static final class i extends Lambda implements Function0<Unit> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            InterfaceC0038a interfaceC0038a = a.this.l;
            if (interfaceC0038a != null) {
                interfaceC0038a.a();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayLayoutManager", f = "OverlayLayoutManager.kt", i = {0, 0}, l = {219}, m = "showSnapshotDialog", n = {"this", "config"}, s = {"L$0", "L$1"})
    public static final class j extends ContinuationImpl {
        public a a;
        public AbstractC0637b6 b;
        public /* synthetic */ Object c;
        public int e;

        public j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return a.this.a((AbstractC0637b6) null, this);
        }
    }

    public a(@NotNull MutableStateFlow snapshotStateFlow, @NotNull Context context, @NotNull WindowManager windowManager, @NotNull M2 liveActivityProvider) {
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        this.a = snapshotStateFlow;
        this.b = context;
        this.c = windowManager;
        this.d = liveActivityProvider;
    }

    @NotNull
    public final View a() {
        View view = this.e;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fabLayout");
        return null;
    }

    @SuppressLint({"InflateParams"})
    public final void b() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.setDuration(250L);
        this.g = valueAnimator;
        LayoutInflater layoutInflater = LayoutInflater.from(this.b);
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
        View floatingButtonLayout = layoutInflater.inflate(R.layout.contentsquare_floating_widget_layout, (ViewGroup) null, false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2038, 262184, -3);
        layoutParams.windowAnimations = android.R.style.Animation.Translucent;
        layoutParams.gravity = 8388629;
        this.f = layoutParams;
        this.c.addView(floatingButtonLayout, layoutParams);
        d dVar = new d();
        View viewFindViewById = floatingButtonLayout.findViewById(R.id.client_mode_icon_id);
        ImageView imageView = (ImageView) viewFindViewById;
        imageView.setOnTouchListener(dVar);
        InstrumentationCallbacks.setOnClickListenerCalled(imageView, new b(this, dVar));
        imageView.setOnLongClickListener(new c(this, dVar));
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "floatingButtonLayout.fin…uchedListener))\n        }");
        Intrinsics.checkNotNullExpressionValue(floatingButtonLayout, "floatingButtonLayout");
        floatingButtonLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0869z3(this));
        Intrinsics.checkNotNullParameter(floatingButtonLayout, "<set-?>");
        this.e = floatingButtonLayout;
        this.i = new W2(this.d, CoreModule.INSTANCE.safeInstance(this.b).getPreferencesStore(), new f());
        this.h = new N6(this.d, new g());
        this.m = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new h(null), 3, null);
    }

    public final void a(int i2, boolean z) {
        N6 n6 = this.h;
        if (n6 != null) {
            i iVar = z ? new i() : null;
            Function1<? super C0652d1, Unit> function1 = n6.d;
            if (function1 != null) {
                function1.invoke(new C0652d1(new AbstractC0827u7.a(R.string.contentsquare_snapshot_status_in_progress), new AbstractC0827u7.a(R.string.contentsquare_snapshot_status_in_progress_summary), new AbstractC0655d4.c(i2), iVar != null ? new C0731l0(R.string.contentsquare_snapshot_status_cancel, iVar) : null, null, 16));
            }
        }
    }

    public final class d implements View.OnTouchListener {
        public int a;
        public int b;
        public float c;
        public float d;
        public boolean e = true;

        public d() {
        }

        public final void a(final View view, final WindowManager.LayoutParams layoutParams, int i) {
            a.this.getClass();
            Intrinsics.checkNotNullParameter(view, "view");
            int width = view.getWidth();
            int i2 = i - width;
            if ((width / 2) + layoutParams.x < i / 2) {
                i2 = 0;
            }
            ValueAnimator valueAnimator = a.this.g;
            if (valueAnimator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fabAnimator");
                valueAnimator = null;
            }
            final a aVar = a.this;
            valueAnimator.setFloatValues(layoutParams.x, i2);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$d$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    a.d.a(layoutParams, aVar, view, valueAnimator2);
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
                this.e = true;
                WindowManager.LayoutParams layoutParams2 = a.this.f;
                if (layoutParams2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fabParams");
                } else {
                    layoutParams = layoutParams2;
                }
                this.a = layoutParams.x;
                this.b = layoutParams.y;
                this.c = event.getRawX();
                this.d = event.getRawY();
            } else if (action == 1) {
                View viewA = a.this.a();
                WindowManager.LayoutParams layoutParams3 = a.this.f;
                if (layoutParams3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fabParams");
                } else {
                    layoutParams = layoutParams3;
                }
                a(viewA, layoutParams, a.this.k);
            } else if (action == 2) {
                int iCoerceAtLeast = RangesKt.coerceAtLeast(this.a - ((int) (event.getRawX() - this.c)), 0);
                a aVar = a.this;
                int i = aVar.k;
                View view2 = aVar.a();
                Intrinsics.checkNotNullParameter(view2, "view");
                int iCoerceAtMost = RangesKt.coerceAtMost(i - view2.getWidth(), iCoerceAtLeast);
                int i2 = a.this.j / 2;
                Pair pair = new Pair(Integer.valueOf(iCoerceAtMost), Integer.valueOf(RangesKt.coerceAtMost(i2, RangesKt.coerceAtLeast(this.b + ((int) (event.getRawY() - this.d)), -i2))));
                WindowManager.LayoutParams layoutParams4 = a.this.f;
                if (layoutParams4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fabParams");
                    layoutParams4 = null;
                }
                layoutParams4.x = ((Number) pair.getFirst()).intValue();
                WindowManager.LayoutParams layoutParams5 = a.this.f;
                if (layoutParams5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fabParams");
                    layoutParams5 = null;
                }
                layoutParams5.y = ((Number) pair.getSecond()).intValue();
                a aVar2 = a.this;
                WindowManager windowManager = aVar2.c;
                View viewA2 = aVar2.a();
                WindowManager.LayoutParams layoutParams6 = a.this.f;
                if (layoutParams6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fabParams");
                } else {
                    layoutParams = layoutParams6;
                }
                windowManager.updateViewLayout(viewA2, layoutParams);
                if (this.e) {
                    this.e = Math.abs(this.c - event.getRawX()) < 70.0f && Math.abs(this.d - event.getRawY()) < 70.0f;
                }
            }
            return false;
        }

        public static final void a(WindowManager.LayoutParams fabParams, a this$0, View fabLayout, ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(fabParams, "$fabParams");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(fabLayout, "$fabLayout");
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            fabParams.x = (int) ((Float) animatedValue).floatValue();
            this$0.c.updateViewLayout(fabLayout, fabParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.AbstractC0637b6 r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a.j
            if (r0 == 0) goto L13
            r0 = r12
            com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$j r0 = (com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a.j) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$j r0 = new com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a$j
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            com.contentsquare.android.sdk.b6 r11 = r0.b
            com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a r10 = r0.a
            kotlin.ResultKt.throwOnFailure(r12)
            goto L8c
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            kotlin.ResultKt.throwOnFailure(r12)
            android.view.View r12 = r10.a()
            if (r12 != 0) goto L40
            goto L45
        L40:
            r2 = 8
            r12.setVisibility(r2)
        L45:
            boolean r12 = r11 instanceof com.contentsquare.android.sdk.AbstractC0844w5.b
            if (r12 != 0) goto L4d
            boolean r12 = r11 instanceof com.contentsquare.android.sdk.AbstractC0839w0.a
            if (r12 == 0) goto L7b
        L4d:
            com.contentsquare.android.sdk.W2 r12 = r10.i
            if (r12 == 0) goto L7b
            com.contentsquare.android.core.features.preferences.PreferencesStore r12 = r12.b
            com.contentsquare.android.core.features.preferences.PreferencesKey r2 = com.contentsquare.android.core.features.preferences.PreferencesKey.LONG_SNAPSHOT_EXPLANATION_SHOWN
            boolean r12 = r12.getBoolean(r2, r3)
            r12 = r12 ^ r4
            if (r12 != r4) goto L7b
            com.contentsquare.android.sdk.W2 r10 = r10.i
            if (r10 == 0) goto L93
            com.contentsquare.android.core.features.preferences.PreferencesStore r11 = r10.b
            r11.putBoolean(r2, r4)
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)
            com.contentsquare.android.sdk.U2 r7 = new com.contentsquare.android.sdk.U2
            r11 = 0
            r7.<init>(r10, r11)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
            goto L93
        L7b:
            com.contentsquare.android.sdk.N6 r12 = r10.h
            if (r12 == 0) goto L8c
            r0.a = r10
            r0.b = r11
            r0.e = r4
            java.lang.Object r12 = r12.a(r0)
            if (r12 != r1) goto L8c
            return r1
        L8c:
            boolean r11 = r11 instanceof com.contentsquare.android.sdk.AbstractC0637b6.a
            r11 = r11 ^ r4
            r10.a(r3, r11)
            r3 = r4
        L93:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a.a(com.contentsquare.android.sdk.b6, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

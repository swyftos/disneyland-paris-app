package com.urbanairship.android.layout.ui;

import android.R;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.IntentCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.core.utils.UriBuilder;
import com.dlp.BluetoothManager;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.BasePresentation;
import com.urbanairship.android.layout.ModalPresentation;
import com.urbanairship.android.layout.ModelFactoryException;
import com.urbanairship.android.layout.ThomasListenerInterface;
import com.urbanairship.android.layout.display.DisplayArgs;
import com.urbanairship.android.layout.display.DisplayArgsLoader;
import com.urbanairship.android.layout.environment.DefaultViewEnvironment;
import com.urbanairship.android.layout.environment.ExternalReporter;
import com.urbanairship.android.layout.environment.LayoutEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.Reporter;
import com.urbanairship.android.layout.environment.ThomasActionRunner;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.ModalPlacement;
import com.urbanairship.android.layout.property.Orientation;
import com.urbanairship.android.layout.reporting.DisplayTimer;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.android.layout.util.FullScreenAdjustResizeWorkaround;
import com.urbanairship.android.layout.view.ModalView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001cH\u0014J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001fH\u0014J\u0012\u0010#\u001a\u00020\u001c2\b\b\u0002\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006,"}, d2 = {"Lcom/urbanairship/android/layout/ui/ModalActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "disableBackButton", "", "displayTimer", "Lcom/urbanairship/android/layout/reporting/DisplayTimer;", "externalListener", "Lcom/urbanairship/android/layout/ThomasListenerInterface;", "isAtLeastApi35", "loader", "Lcom/urbanairship/android/layout/display/DisplayArgsLoader;", "reporter", "Lcom/urbanairship/android/layout/environment/Reporter;", "viewModel", "Lcom/urbanairship/android/layout/ui/LayoutViewModel;", "getViewModel", "()Lcom/urbanairship/android/layout/ui/LayoutViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "handleIgnoreSafeAreas", "shouldIgnoreSafeArea", "observeLayoutEvents", "Lkotlinx/coroutines/Job;", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSaveInstanceState", "outState", "reportDismissFromOutside", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/reporting/LayoutData;", "reportStateChange", "setOrientationLock", "placement", "Lcom/urbanairship/android/layout/property/ModalPlacement;", "transparentSystemBars", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nModalActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModalActivity.kt\ncom/urbanairship/android/layout/ui/ModalActivity\n+ 2 ActivityExtensions.kt\ncom/urbanairship/util/ActivityExtensionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,267:1\n15#2:268\n163#3,2:269\n*S KotlinDebug\n*F\n+ 1 ModalActivity.kt\ncom/urbanairship/android/layout/ui/ModalActivity\n*L\n67#1:268\n131#1:269,2\n*E\n"})
/* loaded from: classes5.dex */
public final class ModalActivity extends AppCompatActivity {

    @NotNull
    public static final String EXTRA_DISPLAY_ARGS_LOADER = "com.urbanairship.android.layout.ui.EXTRA_DISPLAY_ARGS_LOADER";
    private boolean disableBackButton;
    private DisplayTimer displayTimer;
    private ThomasListenerInterface externalListener;
    private final boolean isAtLeastApi35;
    private DisplayArgsLoader loader;
    private Reporter reporter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.urbanairship.android.layout.ui.ModalActivity$viewModel$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final LayoutViewModel invoke() {
            return (LayoutViewModel) new ViewModelProvider(this.this$0).get(LayoutViewModel.class);
        }
    });

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InstrumentationCallbacks.dispatchTouchEventCalled(this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        InstrumentationCallbacks.onConfigurationChangedCalled(this, configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        InstrumentationCallbacks.onRestartCalled(this);
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    public ModalActivity() {
        this.isAtLeastApi35 = Build.VERSION.SDK_INT >= 35;
    }

    private final LayoutViewModel getViewModel() {
        return (LayoutViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Reporter reporter;
        DisplayTimer displayTimer;
        InstrumentationCallbacks.onCreateCalled(this, savedInstanceState);
        super.onCreate(savedInstanceState);
        DisplayArgsLoader displayArgsLoader = (DisplayArgsLoader) IntentCompat.getParcelableExtra(getIntent(), EXTRA_DISPLAY_ARGS_LOADER, DisplayArgsLoader.class);
        if (displayArgsLoader == null) {
            UALog.e("Missing layout args loader", new Object[0]);
            finish();
            return;
        }
        this.loader = displayArgsLoader;
        this.displayTimer = new DisplayTimer(this, savedInstanceState != null ? savedInstanceState.getLong("display_time") : 0L);
        try {
            DisplayArgsLoader displayArgsLoader2 = this.loader;
            if (displayArgsLoader2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loader");
                displayArgsLoader2 = null;
            }
            DisplayArgs displayArgs = displayArgsLoader2.getDisplayArgs();
            Intrinsics.checkNotNullExpressionValue(displayArgs, "getDisplayArgs(...)");
            ThomasListenerInterface listener = displayArgs.getListener();
            this.externalListener = listener;
            if (listener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("externalListener");
                listener = null;
            }
            this.reporter = new ExternalReporter(listener);
            BasePresentation presentation = displayArgs.getPayload().getPresentation();
            ModalPresentation modalPresentation = presentation instanceof ModalPresentation ? (ModalPresentation) presentation : null;
            if (modalPresentation == null) {
                UALog.e("Not a modal presentation", new Object[0]);
                finish();
                return;
            }
            this.disableBackButton = modalPresentation.isDisableBackButton();
            ModalPlacement resolvedPlacement = modalPresentation.getResolvedPlacement(this);
            Intrinsics.checkNotNullExpressionValue(resolvedPlacement, "getResolvedPlacement(...)");
            setOrientationLock(resolvedPlacement);
            boolean zHandleIgnoreSafeAreas = handleIgnoreSafeAreas(resolvedPlacement.getIgnoreSafeArea());
            LayoutViewModel viewModel = getViewModel();
            Reporter reporter2 = this.reporter;
            if (reporter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reporter");
                reporter = null;
            } else {
                reporter = reporter2;
            }
            ThomasActionRunner actionRunner = displayArgs.getActionRunner();
            DisplayTimer displayTimer2 = this.displayTimer;
            if (displayTimer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("displayTimer");
                displayTimer = null;
            } else {
                displayTimer = displayTimer2;
            }
            ModelEnvironment orCreateEnvironment$default = LayoutViewModel.getOrCreateEnvironment$default(viewModel, reporter, displayTimer, actionRunner, null, 8, null);
            BaseModel orCreateModel$default = LayoutViewModel.getOrCreateModel$default(getViewModel(), displayArgs.getPayload().getView(), orCreateEnvironment$default, null, 4, null);
            observeLayoutEvents(orCreateEnvironment$default.getLayoutEvents());
            reportStateChange(orCreateEnvironment$default.getLayoutEvents());
            ModalView modalView = new ModalView(this, orCreateModel$default, modalPresentation, new DefaultViewEnvironment(this, displayArgs.getInAppActivityMonitor(), displayArgs.getWebViewClientFactory(), displayArgs.getImageCache(), resolvedPlacement.getIgnoreSafeArea()));
            modalView.setId(getViewModel().getRootViewId());
            modalView.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
            if (modalPresentation.isDismissOnTouchOutside()) {
                modalView.setOnClickOutsideListener(new View.OnClickListener() { // from class: com.urbanairship.android.layout.ui.ModalActivity$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ModalActivity.onCreate$lambda$3$lambda$2(this.f$0, view);
                    }
                });
            }
            setContentView(modalView);
            if (zHandleIgnoreSafeAreas) {
                ViewCompat.setOnApplyWindowInsetsListener(modalView, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.android.layout.ui.ModalActivity$$ExternalSyntheticLambda1
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        return ModalActivity.onCreate$lambda$4(view, windowInsetsCompat);
                    }
                });
                ViewCompat.requestApplyInsets(modalView);
            }
            if (resolvedPlacement.getIgnoreSafeArea()) {
                FullScreenAdjustResizeWorkaround.INSTANCE.applyAdjustResizeWorkaround(this);
            }
        } catch (ModelFactoryException e) {
            UALog.e(e, "Failed to load model!", new Object[0]);
            finish();
        } catch (DisplayArgsLoader.LoadException e2) {
            UALog.e(e2, "Failed to load model!", new Object[0]);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$2(ModalActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        reportDismissFromOutside$default(this$0, null, 1, null);
        this$0.finishAfterTransition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$4(View v, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        v.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        DisplayArgsLoader displayArgsLoader;
        InstrumentationCallbacks.onDestroyCalled(this);
        super.onDestroy();
        if (!isFinishing() || (displayArgsLoader = this.loader) == null) {
            return;
        }
        if (displayArgsLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loader");
            displayArgsLoader = null;
        }
        displayArgsLoader.dispose();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        DisplayTimer displayTimer = this.displayTimer;
        if (displayTimer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayTimer");
            displayTimer = null;
        }
        outState.putLong("display_time", displayTimer.getTime());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.disableBackButton) {
            return;
        }
        super.onBackPressed();
        reportDismissFromOutside$default(this, null, 1, null);
    }

    /* renamed from: com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Flow $events;
        int label;
        final /* synthetic */ ModalActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Flow flow, ModalActivity modalActivity, Continuation continuation) {
            super(2, continuation);
            this.$events = flow;
            this.this$0 = modalActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$events, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow flow = this.$events;
                Flow<Object> flow2 = new Flow<Object>() { // from class: com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2", f = "ModalActivity.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L43
                            L29:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L31:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                                boolean r6 = r5 instanceof com.urbanairship.android.layout.environment.LayoutEvent.Finish
                                if (r6 == 0) goto L43
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L43
                                return r1
                            L43:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.ui.ModalActivity$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final ModalActivity modalActivity = this.this$0;
                FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.ui.ModalActivity.observeLayoutEvents.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(LayoutEvent.Finish finish, Continuation continuation) {
                        modalActivity.finishAfterTransition();
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow2.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final Job observeLayoutEvents(Flow events) {
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(events, this, null), 3, null);
    }

    /* renamed from: com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1, reason: invalid class name and case insensitive filesystem */
    static final class C09591 extends SuspendLambda implements Function2 {
        final /* synthetic */ Flow $events;
        int label;
        final /* synthetic */ ModalActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09591(Flow flow, ModalActivity modalActivity, Continuation continuation) {
            super(2, continuation);
            this.$events = flow;
            this.this$0 = modalActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09591(this.$events, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow flow = this.$events;
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Object>() { // from class: com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2", f = "ModalActivity.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L43
                            L29:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L31:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                                boolean r6 = r5 instanceof com.urbanairship.android.layout.environment.LayoutEvent.StateUpdate
                                if (r6 == 0) goto L43
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L43
                                return r1
                            L43:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.ui.ModalActivity$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
                final ModalActivity modalActivity = this.this$0;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.ui.ModalActivity.reportStateChange.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(LayoutEvent.StateUpdate stateUpdate, Continuation continuation) {
                        ThomasListenerInterface thomasListenerInterface = modalActivity.externalListener;
                        if (thomasListenerInterface == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("externalListener");
                            thomasListenerInterface = null;
                        }
                        thomasListenerInterface.onStateChanged(stateUpdate.getState());
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowDistinctUntilChanged.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final Job reportStateChange(Flow events) {
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09591(events, this, null), 3, null);
    }

    static /* synthetic */ void reportDismissFromOutside$default(ModalActivity modalActivity, LayoutData layoutData, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutData = LayoutData.empty();
            Intrinsics.checkNotNullExpressionValue(layoutData, "empty(...)");
        }
        modalActivity.reportDismissFromOutside(layoutData);
    }

    private final void reportDismissFromOutside(LayoutData state) {
        Reporter reporter = this.reporter;
        DisplayTimer displayTimer = null;
        if (reporter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporter");
            reporter = null;
        }
        ReportingEvent.DismissData.UserDismissed userDismissed = ReportingEvent.DismissData.UserDismissed.INSTANCE;
        Duration.Companion companion = Duration.INSTANCE;
        DisplayTimer displayTimer2 = this.displayTimer;
        if (displayTimer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayTimer");
        } else {
            displayTimer = displayTimer2;
        }
        reporter.report(new ReportingEvent.Dismiss(userDismissed, DurationKt.toDuration(displayTimer.getTime(), DurationUnit.MILLISECONDS), state, null));
    }

    private final boolean handleIgnoreSafeAreas(boolean shouldIgnoreSafeArea) {
        if (this.isAtLeastApi35 || shouldIgnoreSafeArea) {
            EdgeToEdge.enable$default(this, null, null, 3, null);
            if (!this.isAtLeastApi35) {
                if (Build.VERSION.SDK_INT > 29) {
                    getWindow().addFlags(-2147482880);
                }
                transparentSystemBars();
            }
        }
        return this.isAtLeastApi35 && !shouldIgnoreSafeArea;
    }

    private final void transparentSystemBars() {
        getWindow().setStatusBarColor(R.color.transparent);
        getWindow().setNavigationBarColor(R.color.transparent);
    }

    private final void setOrientationLock(ModalPlacement placement) {
        try {
            if (placement.getOrientationLock() != null) {
                Orientation orientationLock = placement.getOrientationLock();
                int i = orientationLock == null ? -1 : WhenMappings.$EnumSwitchMapping$0[orientationLock.ordinal()];
                if (i == 1) {
                    setRequestedOrientation(1);
                } else {
                    if (i != 2) {
                        return;
                    }
                    setRequestedOrientation(0);
                }
            }
        } catch (Exception e) {
            UALog.e(e, "Unable to set orientation lock.", new Object[0]);
        }
    }
}

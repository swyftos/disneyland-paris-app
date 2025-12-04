package com.urbanairship.android.layout.ui;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.contentsquare.android.core.utils.UriBuilder;
import com.dlp.BluetoothManager;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.AirshipEmbeddedViewManager;
import com.urbanairship.android.layout.BasePresentation;
import com.urbanairship.android.layout.EmbeddedPresentation;
import com.urbanairship.android.layout.ModelFactoryException;
import com.urbanairship.android.layout.R;
import com.urbanairship.android.layout.ThomasListenerInterface;
import com.urbanairship.android.layout.display.DisplayArgs;
import com.urbanairship.android.layout.environment.DefaultViewEnvironment;
import com.urbanairship.android.layout.environment.ExternalReporter;
import com.urbanairship.android.layout.environment.LayoutEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.Reporter;
import com.urbanairship.android.layout.environment.ThomasActionRunner;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.info.LayoutInfo;
import com.urbanairship.android.layout.property.EmbeddedPlacement;
import com.urbanairship.android.layout.reporting.DisplayTimer;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.android.layout.ui.ThomasEmbeddedView;
import com.urbanairship.android.layout.util.ContextExtensionsKt;
import com.urbanairship.android.layout.util.Factory;
import com.urbanairship.android.layout.util.ImageCache;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.SimpleApplicationListener;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010/\u001a\u000200H\u0002J\u0013\u00101\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u001c\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\u000eJ\n\u00107\u001a\u0004\u0018\u000108H\u0007J\b\u00109\u001a\u00020:H\u0016J\u001e\u0010;\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\u000eH\u0007J\u0016\u0010<\u001a\u00020!2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0002J\b\u0010@\u001a\u000200H\u0003J\u0012\u0010A\u001a\u0002002\b\b\u0002\u0010B\u001a\u00020CH\u0002J\u0016\u0010D\u001a\u00020!2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/urbanairship/android/layout/ui/EmbeddedLayout;", "", "context", "Landroid/content/Context;", "embeddedViewId", "", "viewInstanceId", "args", "Lcom/urbanairship/android/layout/display/DisplayArgs;", "embeddedViewManager", "Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/android/layout/display/DisplayArgs;Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;)V", "_isVisible", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "actionRunner", "Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "currentView", "Ljava/lang/ref/WeakReference;", "Lcom/urbanairship/android/layout/ui/ThomasEmbeddedView;", "displayTimer", "Lcom/urbanairship/android/layout/reporting/DisplayTimer;", "getEmbeddedViewId", "()Ljava/lang/String;", "externalListener", "Lcom/urbanairship/android/layout/ThomasListenerInterface;", "imageCache", "Lcom/urbanairship/android/layout/util/ImageCache;", "isVisible", "Lkotlinx/coroutines/flow/StateFlow;", "layoutEventsJob", "Lkotlinx/coroutines/Job;", "layoutScope", "Lkotlinx/coroutines/CoroutineScope;", "payload", "Lcom/urbanairship/android/layout/info/LayoutInfo;", "reporter", "Lcom/urbanairship/android/layout/environment/Reporter;", "stateUpdateReportJob", "getViewInstanceId", "viewJob", "Lkotlinx/coroutines/CompletableJob;", "webViewClientFactory", "Lcom/urbanairship/android/layout/util/Factory;", "Lcom/urbanairship/webkit/AirshipWebViewClient;", "dismiss", "", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "getOrCreateView", "Landroid/view/View;", "fillWidth", "fillHeight", "getPlacement", "Lcom/urbanairship/android/layout/property/EmbeddedPlacement;", "hashCode", "", "makeView", "observeLayoutEvents", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "onDisplayFinished", "reportDismissFromOutside", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/reporting/LayoutData;", "reportStateChange", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class EmbeddedLayout {
    private final MutableStateFlow _isVisible;
    private final ThomasActionRunner actionRunner;
    private final ActivityMonitor activityMonitor;
    private final Context context;
    private WeakReference currentView;
    private DisplayTimer displayTimer;
    private final String embeddedViewId;
    private final AirshipEmbeddedViewManager embeddedViewManager;
    private final ThomasListenerInterface externalListener;
    private final ImageCache imageCache;
    private final StateFlow isVisible;
    private Job layoutEventsJob;
    private final CoroutineScope layoutScope;
    private final LayoutInfo payload;
    private final Reporter reporter;
    private Job stateUpdateReportJob;
    private final String viewInstanceId;
    private final CompletableJob viewJob;
    private final Factory webViewClientFactory;

    public EmbeddedLayout(@NotNull Context context, @NotNull String embeddedViewId, @NotNull String viewInstanceId, @NotNull DisplayArgs args, @NotNull AirshipEmbeddedViewManager embeddedViewManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(embeddedViewId, "embeddedViewId");
        Intrinsics.checkNotNullParameter(viewInstanceId, "viewInstanceId");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(embeddedViewManager, "embeddedViewManager");
        this.context = context;
        this.embeddedViewId = embeddedViewId;
        this.viewInstanceId = viewInstanceId;
        this.embeddedViewManager = embeddedViewManager;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.viewJob = completableJobSupervisorJob$default;
        this.layoutScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(completableJobSupervisorJob$default));
        this.payload = args.getPayload();
        this.activityMonitor = args.getInAppActivityMonitor();
        this.webViewClientFactory = args.getWebViewClientFactory();
        ThomasListenerInterface listener = args.getListener();
        this.externalListener = listener;
        this.imageCache = args.getImageCache();
        this.actionRunner = args.getActionRunner();
        this.reporter = new ExternalReporter(listener);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._isVisible = MutableStateFlow;
        this.isVisible = FlowKt.asStateFlow(MutableStateFlow);
    }

    @NotNull
    public final String getEmbeddedViewId() {
        return this.embeddedViewId;
    }

    @NotNull
    public final String getViewInstanceId() {
        return this.viewInstanceId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final EmbeddedPlacement getPlacement() {
        BasePresentation presentation = this.payload.getPresentation();
        EmbeddedPresentation embeddedPresentation = presentation instanceof EmbeddedPresentation ? (EmbeddedPresentation) presentation : null;
        if (embeddedPresentation != null) {
            return embeddedPresentation.getResolvedPlacement(this.context);
        }
        return null;
    }

    public static /* synthetic */ View getOrCreateView$default(EmbeddedLayout embeddedLayout, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return embeddedLayout.getOrCreateView(z, z2);
    }

    @Nullable
    public final View getOrCreateView(boolean fillWidth, boolean fillHeight) {
        ThomasEmbeddedView thomasEmbeddedView;
        WeakReference weakReference = this.currentView;
        return (weakReference == null || (thomasEmbeddedView = (ThomasEmbeddedView) weakReference.get()) == null) ? makeView(fillWidth, fillHeight) : thomasEmbeddedView;
    }

    public static /* synthetic */ View makeView$default(EmbeddedLayout embeddedLayout, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return embeddedLayout.makeView(z, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final View makeView(boolean fillWidth, boolean fillHeight) {
        final Activity activity = ContextExtensionsKt.getActivity(this.context);
        if (activity == 0) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout.makeView.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Airship Embedded Views must be hosted by an Activity! Current Activity is null.";
                }
            }, 1, null);
            return null;
        }
        if (!(activity instanceof LifecycleOwner)) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout.makeView.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Airship Embedded Views must be hosted by an Activity that implements LifecycleOwner!";
                }
            }, 1, null);
            return null;
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) activity;
        DisplayTimer displayTimer = new DisplayTimer(lifecycleOwner, 0L);
        BasePresentation presentation = this.payload.getPresentation();
        EmbeddedPresentation embeddedPresentation = presentation instanceof EmbeddedPresentation ? (EmbeddedPresentation) presentation : null;
        if (embeddedPresentation == null) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout.makeView.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "EmbeddedLayout requires an EmbeddedPresentation!";
                }
            }, 1, null);
            return null;
        }
        lifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout.makeView.4
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                EmbeddedLayout.this.onDisplayFinished();
                ((LifecycleOwner) activity).getLifecycle().removeObserver(this);
            }
        });
        this.activityMonitor.addApplicationListener(new SimpleApplicationListener() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout.makeView.5
            @Override // com.urbanairship.app.SimpleApplicationListener, com.urbanairship.app.ApplicationListener
            public void onForeground(long time) {
                super.onForeground(time);
                EmbeddedLayout.this.reporter.onVisibilityChanged(((Boolean) EmbeddedLayout.this.isVisible.getValue()).booleanValue(), true);
            }

            @Override // com.urbanairship.app.SimpleApplicationListener, com.urbanairship.app.ApplicationListener
            public void onBackground(long time) {
                super.onBackground(time);
                EmbeddedLayout.this.reporter.onVisibilityChanged(((Boolean) EmbeddedLayout.this.isVisible.getValue()).booleanValue(), false);
            }
        });
        DefaultViewEnvironment defaultViewEnvironment = new DefaultViewEnvironment(activity, this.activityMonitor, this.webViewClientFactory, this.imageCache, false);
        LayoutViewModel layoutViewModel = (LayoutViewModel) new ViewModelProvider(EmbeddedViewModelStoreOwner.INSTANCE).get(this.viewInstanceId, LayoutViewModel.class);
        this.displayTimer = displayTimer;
        try {
            ModelEnvironment orCreateEnvironment$default = LayoutViewModel.getOrCreateEnvironment$default(layoutViewModel, this.reporter, displayTimer, this.actionRunner, null, 8, null);
            ThomasEmbeddedView thomasEmbeddedView = new ThomasEmbeddedView(new ContextThemeWrapper(this.context, R.style.UrbanAirship_Layout), LayoutViewModel.getOrCreateModel$default(layoutViewModel, this.payload.getView(), orCreateEnvironment$default, null, 4, null), embeddedPresentation, defaultViewEnvironment, fillHeight, fillWidth);
            thomasEmbeddedView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout.makeView.6
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    EmbeddedLayout.this.reporter.onVisibilityChanged(true, EmbeddedLayout.this.activityMonitor.getIsAppForegrounded());
                    EmbeddedLayout.this._isVisible.setValue(Boolean.TRUE);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    EmbeddedLayout.this.reporter.onVisibilityChanged(false, EmbeddedLayout.this.activityMonitor.getIsAppForegrounded());
                    EmbeddedLayout.this._isVisible.setValue(Boolean.FALSE);
                }
            });
            Job job = this.layoutEventsJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.layoutEventsJob = observeLayoutEvents(orCreateEnvironment$default.getLayoutEvents());
            Job job2 = this.stateUpdateReportJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.stateUpdateReportJob = reportStateChange(orCreateEnvironment$default.getLayoutEvents());
            thomasEmbeddedView.setListener$urbanairship_layout_release(new ThomasEmbeddedView.Listener() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout.makeView.7
                @Override // com.urbanairship.android.layout.ui.ThomasEmbeddedView.Listener
                public void onDismissed() {
                    EmbeddedLayout.this.dismiss();
                    EmbeddedLayout.reportDismissFromOutside$default(EmbeddedLayout.this, null, 1, null);
                }
            });
            this.currentView = new WeakReference(thomasEmbeddedView);
            return thomasEmbeddedView;
        } catch (ModelFactoryException e) {
            UALog.e("Failed to load model!", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss() {
        this.embeddedViewManager.dismiss(this.embeddedViewId, this.viewInstanceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDisplayFinished() {
        UALog.v("Embedded content finished displaying! " + this.embeddedViewId + ", " + this.viewInstanceId, new Object[0]);
        CoroutineScopeKt.cancel$default(this.layoutScope, null, 1, null);
        EmbeddedViewModelStore.INSTANCE.clear();
    }

    /* renamed from: com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1, reason: invalid class name and case insensitive filesystem */
    static final class C09571 extends SuspendLambda implements Function2 {
        final /* synthetic */ Flow $events;
        int label;
        final /* synthetic */ EmbeddedLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09571(Flow flow, EmbeddedLayout embeddedLayout, Continuation continuation) {
            super(2, continuation);
            this.$events = flow;
            this.this$0 = embeddedLayout;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09571(this.$events, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow flow = this.$events;
                Flow<Object> flow2 = new Flow<Object>() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2", f = "EmbeddedLayout.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1
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
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.ui.EmbeddedLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final EmbeddedLayout embeddedLayout = this.this$0;
                FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout.observeLayoutEvents.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(LayoutEvent.Finish finish, Continuation continuation) {
                        embeddedLayout.dismiss();
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
        return BuildersKt__Builders_commonKt.launch$default(this.layoutScope, null, null, new C09571(events, this, null), 3, null);
    }

    /* renamed from: com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1, reason: invalid class name and case insensitive filesystem */
    static final class C09581 extends SuspendLambda implements Function2 {
        final /* synthetic */ Flow $events;
        int label;
        final /* synthetic */ EmbeddedLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09581(Flow flow, EmbeddedLayout embeddedLayout, Continuation continuation) {
            super(2, continuation);
            this.$events = flow;
            this.this$0 = embeddedLayout;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09581(this.$events, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow flow = this.$events;
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Object>() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2", f = "EmbeddedLayout.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1
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
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.ui.EmbeddedLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
                final EmbeddedLayout embeddedLayout = this.this$0;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.ui.EmbeddedLayout.reportStateChange.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(LayoutEvent.StateUpdate stateUpdate, Continuation continuation) {
                        embeddedLayout.externalListener.onStateChanged(stateUpdate.getState());
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
        return BuildersKt__Builders_commonKt.launch$default(this.layoutScope, null, null, new C09581(events, this, null), 3, null);
    }

    static /* synthetic */ void reportDismissFromOutside$default(EmbeddedLayout embeddedLayout, LayoutData layoutData, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutData = LayoutData.empty();
            Intrinsics.checkNotNullExpressionValue(layoutData, "empty(...)");
        }
        embeddedLayout.reportDismissFromOutside(layoutData);
    }

    private final void reportDismissFromOutside(LayoutData state) {
        Reporter reporter = this.reporter;
        ReportingEvent.DismissData.UserDismissed userDismissed = ReportingEvent.DismissData.UserDismissed.INSTANCE;
        Duration.Companion companion = Duration.INSTANCE;
        DisplayTimer displayTimer = this.displayTimer;
        reporter.report(new ReportingEvent.Dismiss(userDismissed, DurationKt.toDuration(displayTimer != null ? displayTimer.getTime() : 0L, DurationUnit.MILLISECONDS), state, null));
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(EmbeddedLayout.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.android.layout.ui.EmbeddedLayout");
        EmbeddedLayout embeddedLayout = (EmbeddedLayout) other;
        return Intrinsics.areEqual(this.embeddedViewId, embeddedLayout.embeddedViewId) && Intrinsics.areEqual(this.viewInstanceId, embeddedLayout.viewInstanceId);
    }

    public int hashCode() {
        return Objects.hash(this.embeddedViewId, this.viewInstanceId);
    }
}

package com.urbanairship.android.layout.ui;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelProvider;
import com.contentsquare.android.core.utils.UriBuilder;
import com.dlp.BluetoothManager;
import com.urbanairship.Predicate;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.BannerPresentation;
import com.urbanairship.android.layout.BasePresentation;
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
import com.urbanairship.android.layout.property.BannerPlacement;
import com.urbanairship.android.layout.property.Position;
import com.urbanairship.android.layout.property.VerticalPosition;
import com.urbanairship.android.layout.reporting.DisplayTimer;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.android.layout.ui.ThomasBannerView;
import com.urbanairship.android.layout.util.Factory;
import com.urbanairship.android.layout.util.ImageCache;
import com.urbanairship.app.ActivityListener;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.SimpleActivityListener;
import com.urbanairship.util.ManifestUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020(J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000fH\u0002J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u0010/\u001a\u00020\u000fH\u0002J\u0016\u00102\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002J\u0010\u00107\u001a\u00020(2\u0006\u0010/\u001a\u00020\u000fH\u0003J\u0010\u00108\u001a\u00020(2\u0006\u0010/\u001a\u00020\u000fH\u0003J\u0010\u00109\u001a\u00020(2\u0006\u0010/\u001a\u00020\u000fH\u0003J\b\u0010:\u001a\u00020(H\u0003J\u0012\u0010;\u001a\u00020(2\b\b\u0002\u0010<\u001a\u00020=H\u0002J\u0016\u0010>\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/urbanairship/android/layout/ui/BannerLayout;", "", "context", "Landroid/content/Context;", "args", "Lcom/urbanairship/android/layout/display/DisplayArgs;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/display/DisplayArgs;)V", "actionRunner", "Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", "activityListener", "Lcom/urbanairship/app/ActivityListener;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "activityPredicate", "Lcom/urbanairship/Predicate;", "Landroid/app/Activity;", "bannerScope", "Lkotlinx/coroutines/CoroutineScope;", "currentView", "Ljava/lang/ref/WeakReference;", "Lcom/urbanairship/android/layout/ui/ThomasBannerView;", "displayTimer", "Lcom/urbanairship/android/layout/reporting/DisplayTimer;", "externalListener", "Lcom/urbanairship/android/layout/ThomasListenerInterface;", "imageCache", "Lcom/urbanairship/android/layout/util/ImageCache;", "lastActivity", "payload", "Lcom/urbanairship/android/layout/info/LayoutInfo;", "reporter", "Lcom/urbanairship/android/layout/environment/Reporter;", "viewJob", "Lkotlinx/coroutines/CompletableJob;", "viewModelKey", "", "webViewClientFactory", "Lcom/urbanairship/android/layout/util/Factory;", "Lcom/urbanairship/webkit/AirshipWebViewClient;", "dismiss", "", "animate", "", "isInternal", "display", "getContainerId", "", "activity", "getContainerView", "Landroid/view/ViewGroup;", "observeLayoutEvents", "Lkotlinx/coroutines/Job;", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "onActivityPaused", "onActivityResumed", "onActivityStopped", "onDisplayFinished", "reportDismissFromOutside", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/reporting/LayoutData;", "reportStateChange", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerLayout {

    @NotNull
    public static final String BANNER_CONTAINER_ID = "com.urbanairship.iam.banner.BANNER_CONTAINER_ID";
    private static final Map cachedContainerIds = new HashMap();
    private final ThomasActionRunner actionRunner;
    private final ActivityListener activityListener;
    private final ActivityMonitor activityMonitor;
    private final Predicate activityPredicate;
    private final CoroutineScope bannerScope;
    private final Context context;
    private WeakReference currentView;
    private final DisplayTimer displayTimer;
    private final ThomasListenerInterface externalListener;
    private final ImageCache imageCache;
    private WeakReference lastActivity;
    private final LayoutInfo payload;
    private final Reporter reporter;
    private final CompletableJob viewJob;
    private final String viewModelKey;
    private final Factory webViewClientFactory;

    public BannerLayout(@NotNull Context context, @NotNull DisplayArgs args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, "args");
        this.context = context;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.viewJob = completableJobSupervisorJob$default;
        this.bannerScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(completableJobSupervisorJob$default));
        ActivityMonitor inAppActivityMonitor = args.getInAppActivityMonitor();
        this.activityMonitor = inAppActivityMonitor;
        this.webViewClientFactory = args.getWebViewClientFactory();
        this.imageCache = args.getImageCache();
        this.payload = args.getPayload();
        ThomasListenerInterface listener = args.getListener();
        this.externalListener = listener;
        this.viewModelKey = String.valueOf(args.hashCode());
        this.reporter = new ExternalReporter(listener);
        this.actionRunner = args.getActionRunner();
        Predicate predicate = new Predicate() { // from class: com.urbanairship.android.layout.ui.BannerLayout$$ExternalSyntheticLambda0
            @Override // com.urbanairship.Predicate
            public final boolean apply(Object obj) {
                return BannerLayout.activityPredicate$lambda$0(this.f$0, (Activity) obj);
            }
        };
        this.activityPredicate = predicate;
        this.displayTimer = new DisplayTimer(inAppActivityMonitor, predicate, 0L);
        SimpleActivityListener simpleActivityListener = new SimpleActivityListener() { // from class: com.urbanairship.android.layout.ui.BannerLayout$activityListener$1
            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (this.this$0.activityPredicate.apply(activity)) {
                    this.this$0.onActivityStopped(activity);
                }
            }

            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (this.this$0.activityPredicate.apply(activity)) {
                    this.this$0.onActivityResumed(activity);
                }
            }

            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (this.this$0.activityPredicate.apply(activity)) {
                    this.this$0.onActivityPaused(activity);
                }
            }
        };
        this.activityListener = simpleActivityListener;
        inAppActivityMonitor.addActivityListener(simpleActivityListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean activityPredicate$lambda$0(BannerLayout this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            if (this$0.getContainerView(activity) != null) {
                return true;
            }
            UALog.e("BannerAdapter - Unable to display in-app message. No view group found.", new Object[0]);
            return false;
        } catch (Exception e) {
            UALog.e("Failed to find container view.", e);
            return false;
        }
    }

    public final void display() {
        Activity activity = (Activity) CollectionsKt.firstOrNull((List) this.activityMonitor.getResumedActivities(this.activityPredicate));
        if (activity == null) {
            return;
        }
        BasePresentation presentation = this.payload.getPresentation();
        BannerPresentation bannerPresentation = presentation instanceof BannerPresentation ? (BannerPresentation) presentation : null;
        if (bannerPresentation == null) {
            return;
        }
        BannerPlacement resolvedPlacement = bannerPresentation.getResolvedPlacement(this.context);
        Intrinsics.checkNotNullExpressionValue(resolvedPlacement, "getResolvedPlacement(...)");
        if (resolvedPlacement.getIgnoreSafeArea()) {
            WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), false);
        }
        DefaultViewEnvironment defaultViewEnvironment = new DefaultViewEnvironment(activity, this.activityMonitor, this.webViewClientFactory, this.imageCache, resolvedPlacement.getIgnoreSafeArea());
        ViewGroup containerView = getContainerView(activity);
        if (containerView == null) {
            return;
        }
        LayoutViewModel layoutViewModel = (LayoutViewModel) new ViewModelProvider(BannerViewModelStoreOwner.INSTANCE).get(this.viewModelKey, LayoutViewModel.class);
        try {
            ModelEnvironment orCreateEnvironment$default = LayoutViewModel.getOrCreateEnvironment$default(layoutViewModel, this.reporter, this.displayTimer, this.actionRunner, null, 8, null);
            final ThomasBannerView thomasBannerView = new ThomasBannerView(this.context, LayoutViewModel.getOrCreateModel$default(layoutViewModel, this.payload.getView(), orCreateEnvironment$default, null, 4, null), bannerPresentation, defaultViewEnvironment);
            thomasBannerView.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
            WeakReference weakReference = this.lastActivity;
            if ((weakReference != null ? (Activity) weakReference.get() : null) != activity) {
                VerticalPosition verticalPosition = VerticalPosition.BOTTOM;
                Position position = resolvedPlacement.getPosition();
                if (verticalPosition == (position != null ? position.getVertical() : null)) {
                    thomasBannerView.setAnimations(R.animator.ua_layout_slide_in_bottom, R.animator.ua_layout_slide_out_bottom);
                } else {
                    thomasBannerView.setAnimations(R.animator.ua_layout_slide_in_top, R.animator.ua_layout_slide_out_top);
                }
            }
            observeLayoutEvents(orCreateEnvironment$default.getLayoutEvents());
            reportStateChange(orCreateEnvironment$default.getLayoutEvents());
            thomasBannerView.setListener(new ThomasBannerView.Listener() { // from class: com.urbanairship.android.layout.ui.BannerLayout.display.1
                @Override // com.urbanairship.android.layout.ui.ThomasBannerView.Listener
                public void onTimedOut() {
                    BannerLayout.this.onDisplayFinished();
                }

                @Override // com.urbanairship.android.layout.ui.ThomasBannerView.Listener
                public void onDismissed() {
                    BannerLayout.reportDismissFromOutside$default(BannerLayout.this, null, 1, null);
                    BannerLayout.this.onDisplayFinished();
                }

                @Override // com.urbanairship.android.layout.ui.ThomasBannerView.Listener
                public void onDragStateChanged(int state) {
                    if (state != 0) {
                        if (state != 1) {
                            return;
                        }
                        thomasBannerView.getDisplayTimer().stop();
                    } else if (thomasBannerView.getIsResumed()) {
                        thomasBannerView.getDisplayTimer().start();
                    }
                }
            });
            if (thomasBannerView.getParent() == null) {
                containerView.addView(thomasBannerView);
            }
            this.lastActivity = new WeakReference(activity);
            this.currentView = new WeakReference(thomasBannerView);
        } catch (ModelFactoryException e) {
            UALog.e("Failed to load model!", e);
        }
    }

    public static /* synthetic */ void dismiss$default(BannerLayout bannerLayout, boolean z, boolean z2, int i, Object obj) throws Resources.NotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        bannerLayout.dismiss(z, z2);
    }

    public final void dismiss(boolean animate, boolean isInternal) throws Resources.NotFoundException {
        ThomasBannerView thomasBannerView;
        WeakReference weakReference = this.currentView;
        if (weakReference == null || (thomasBannerView = (ThomasBannerView) weakReference.get()) == null) {
            return;
        }
        thomasBannerView.dismiss(animate, isInternal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDisplayFinished() {
        this.activityMonitor.removeActivityListener(this.activityListener);
        JobKt__JobKt.cancelChildren$default((Job) this.viewJob, (CancellationException) null, 1, (Object) null);
        BannerViewModelStore.INSTANCE.clear();
    }

    private final ViewGroup getContainerView(Activity activity) {
        int containerId = getContainerId(activity);
        View viewFindViewById = containerId != 0 ? activity.findViewById(containerId) : null;
        if (viewFindViewById == null) {
            viewFindViewById = activity.findViewById(android.R.id.content);
        }
        if (viewFindViewById instanceof ViewGroup) {
            return (ViewGroup) viewFindViewById;
        }
        return null;
    }

    private final int getContainerId(Activity activity) {
        Map map = cachedContainerIds;
        synchronized (map) {
            Integer num = (Integer) map.get(activity.getClass());
            if (num != null) {
                return num.intValue();
            }
            ActivityInfo activityInfo = ManifestUtils.getActivityInfo(activity.getClass());
            int i = (activityInfo != null ? activityInfo.metaData : null) != null ? activityInfo.metaData.getInt("com.urbanairship.iam.banner.BANNER_CONTAINER_ID", 0) : 0;
            map.put(activity.getClass(), Integer.valueOf(i));
            return i;
        }
    }

    /* renamed from: com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1, reason: invalid class name and case insensitive filesystem */
    static final class C09551 extends SuspendLambda implements Function2 {
        final /* synthetic */ Flow $events;
        int label;
        final /* synthetic */ BannerLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09551(Flow flow, BannerLayout bannerLayout, Continuation continuation) {
            super(2, continuation);
            this.$events = flow;
            this.this$0 = bannerLayout;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09551(this.$events, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow flow = this.$events;
                Flow<Object> flow2 = new Flow<Object>() { // from class: com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2", f = "BannerLayout.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1$2$1
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
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.ui.BannerLayout$observeLayoutEvents$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final BannerLayout bannerLayout = this.this$0;
                FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.ui.BannerLayout.observeLayoutEvents.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(LayoutEvent.Finish finish, Continuation continuation) throws Resources.NotFoundException {
                        BannerLayout.dismiss$default(bannerLayout, false, false, 3, null);
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
        return BuildersKt__Builders_commonKt.launch$default(this.bannerScope, null, null, new C09551(events, this, null), 3, null);
    }

    /* renamed from: com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1, reason: invalid class name and case insensitive filesystem */
    static final class C09561 extends SuspendLambda implements Function2 {
        final /* synthetic */ Flow $events;
        int label;
        final /* synthetic */ BannerLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09561(Flow flow, BannerLayout bannerLayout, Continuation continuation) {
            super(2, continuation);
            this.$events = flow;
            this.this$0 = bannerLayout;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09561(this.$events, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow flow = this.$events;
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Object>() { // from class: com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2", f = "BannerLayout.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1$2$1
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
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.ui.BannerLayout$reportStateChange$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
                final BannerLayout bannerLayout = this.this$0;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.ui.BannerLayout.reportStateChange.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(LayoutEvent.StateUpdate stateUpdate, Continuation continuation) {
                        bannerLayout.externalListener.onStateChanged(stateUpdate.getState());
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
        return BuildersKt__Builders_commonKt.launch$default(this.bannerScope, null, null, new C09561(events, this, null), 3, null);
    }

    static /* synthetic */ void reportDismissFromOutside$default(BannerLayout bannerLayout, LayoutData layoutData, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutData = LayoutData.empty();
            Intrinsics.checkNotNullExpressionValue(layoutData, "empty(...)");
        }
        bannerLayout.reportDismissFromOutside(layoutData);
    }

    private final void reportDismissFromOutside(LayoutData state) {
        Reporter reporter = this.reporter;
        ReportingEvent.DismissData.UserDismissed userDismissed = ReportingEvent.DismissData.UserDismissed.INSTANCE;
        Duration.Companion companion = Duration.INSTANCE;
        reporter.report(new ReportingEvent.Dismiss(userDismissed, DurationKt.toDuration(this.displayTimer.getTime(), DurationUnit.MILLISECONDS), state, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityResumed(Activity activity) {
        WeakReference weakReference = this.currentView;
        ThomasBannerView thomasBannerView = weakReference != null ? (ThomasBannerView) weakReference.get() : null;
        if (thomasBannerView == null || !thomasBannerView.isAttachedToWindow()) {
            display();
            return;
        }
        WeakReference weakReference2 = this.lastActivity;
        if (activity == (weakReference2 != null ? (Activity) weakReference2.get() : null)) {
            thomasBannerView.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityStopped(Activity activity) throws Resources.NotFoundException {
        WeakReference weakReference = this.lastActivity;
        if (activity != (weakReference != null ? (Activity) weakReference.get() : null)) {
            return;
        }
        WeakReference weakReference2 = this.currentView;
        ThomasBannerView thomasBannerView = weakReference2 != null ? (ThomasBannerView) weakReference2.get() : null;
        if (thomasBannerView != null) {
            this.currentView = null;
            this.lastActivity = null;
            thomasBannerView.dismiss(false, true);
            display();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityPaused(Activity activity) {
        WeakReference weakReference;
        ThomasBannerView thomasBannerView;
        WeakReference weakReference2 = this.lastActivity;
        if (activity != (weakReference2 != null ? (Activity) weakReference2.get() : null) || (weakReference = this.currentView) == null || (thomasBannerView = (ThomasBannerView) weakReference.get()) == null) {
            return;
        }
        thomasBannerView.onPause();
    }
}

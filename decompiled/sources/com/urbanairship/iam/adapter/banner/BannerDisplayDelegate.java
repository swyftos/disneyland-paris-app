package com.urbanairship.iam.adapter.banner;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Predicate;
import com.urbanairship.UALog;
import com.urbanairship.actions.ActionRunner;
import com.urbanairship.actions.ActionRunnerKt;
import com.urbanairship.app.ActivityListener;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.SimpleActivityListener;
import com.urbanairship.automation.R;
import com.urbanairship.iam.adapter.DelegatingDisplayAdapter;
import com.urbanairship.iam.adapter.DisplayResult;
import com.urbanairship.iam.adapter.InAppMessageDisplayListener;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import com.urbanairship.iam.content.Banner;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.iam.view.BannerView;
import com.urbanairship.iam.view.InAppViewUtils;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.ManifestUtils;
import com.urbanairship.util.timer.ActiveTimer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 22\u00020\u0001:\u00012B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\rH\u0002J\u0017\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020\rH\u0000¢\u0006\u0002\b'J\n\u0010(\u001a\u0004\u0018\u00010\u0017H\u0003J\n\u0010)\u001a\u0004\u0018\u00010\rH\u0003J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\rH\u0003J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\rH\u0003J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\rH\u0003J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\u001cH\u0002J\u001d\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\rH\u0000¢\u0006\u0002\b1R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/urbanairship/iam/adapter/banner/BannerDisplayDelegate;", "Lcom/urbanairship/iam/adapter/DelegatingDisplayAdapter$Delegate;", "displayContent", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$BannerContent;", "assets", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "actionRunner", "Lcom/urbanairship/actions/ActionRunner;", "(Lcom/urbanairship/iam/content/InAppMessageDisplayContent$BannerContent;Lcom/urbanairship/iam/assets/AirshipCachedAssets;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/actions/ActionRunner;)V", "activityPredicate", "Lcom/urbanairship/Predicate;", "Landroid/app/Activity;", "getActivityPredicate", "()Lcom/urbanairship/Predicate;", "analyticsListener", "Lcom/urbanairship/iam/adapter/InAppMessageDisplayListener;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/urbanairship/iam/adapter/DisplayResult;", "currentView", "Ljava/lang/ref/WeakReference;", "Lcom/urbanairship/iam/view/BannerView;", "lastActivity", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/app/ActivityListener;", "display", "", "context", "Landroid/content/Context;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "(Landroid/content/Context;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContainerId", "", "activity", "getContainerView", "Landroid/view/ViewGroup;", "getContainerView$urbanairship_automation_release", "getCurrentView", "getLastActivity", "onActivityPaused", "onActivityResumed", "onActivityStopped", "onCreateView", "onDisplayFinished", "onViewCreated", "view", "onViewCreated$urbanairship_automation_release", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerDisplayDelegate implements DelegatingDisplayAdapter.Delegate {

    @NotNull
    public static final String BANNER_CONTAINER_ID = "com.urbanairship.iam.banner.BANNER_CONTAINER_ID";
    private static final Map cachedContainerIds = new HashMap();
    private final ActionRunner actionRunner;
    private final ActivityMonitor activityMonitor;
    private final Predicate activityPredicate;
    private InAppMessageDisplayListener analyticsListener;
    private final AirshipCachedAssets assets;
    private CancellableContinuation continuation;
    private WeakReference currentView;
    private final InAppMessageDisplayContent.BannerContent displayContent;
    private WeakReference lastActivity;
    private final ActivityListener listener;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Banner.Placement.values().length];
            try {
                iArr[Banner.Placement.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Banner.Placement.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BannerDisplayDelegate(@NotNull InAppMessageDisplayContent.BannerContent displayContent, @Nullable AirshipCachedAssets airshipCachedAssets, @NotNull ActivityMonitor activityMonitor, @NotNull ActionRunner actionRunner) {
        Intrinsics.checkNotNullParameter(displayContent, "displayContent");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        this.displayContent = displayContent;
        this.assets = airshipCachedAssets;
        this.activityMonitor = activityMonitor;
        this.actionRunner = actionRunner;
        this.activityPredicate = new Predicate<Activity>() { // from class: com.urbanairship.iam.adapter.banner.BannerDisplayDelegate$activityPredicate$1
            @Override // com.urbanairship.Predicate
            public boolean apply(@NotNull Activity value) {
                Intrinsics.checkNotNullParameter(value, "value");
                try {
                    if (this.this$0.getContainerView$urbanairship_automation_release(value) != null) {
                        return true;
                    }
                    UALog.e("BannerAdapter - Unable to display in-app message. No view group found.", new Object[0]);
                    return false;
                } catch (Exception e) {
                    UALog.e("Failed to find container view.", e);
                    return false;
                }
            }
        };
        this.listener = new SimpleActivityListener() { // from class: com.urbanairship.iam.adapter.banner.BannerDisplayDelegate$listener$1
            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (this.this$0.getActivityPredicate().apply(activity)) {
                    this.this$0.onActivityStopped(activity);
                }
            }

            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (this.this$0.getActivityPredicate().apply(activity)) {
                    this.this$0.onActivityResumed(activity);
                }
            }

            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (this.this$0.getActivityPredicate().apply(activity)) {
                    this.this$0.onActivityPaused(activity);
                }
            }
        };
    }

    @Override // com.urbanairship.iam.adapter.DelegatingDisplayAdapter.Delegate
    @NotNull
    public Predicate<Activity> getActivityPredicate() {
        return this.activityPredicate;
    }

    @Override // com.urbanairship.iam.adapter.DelegatingDisplayAdapter.Delegate
    @Nullable
    public Object display(@NotNull Context context, @NotNull InAppMessageAnalyticsInterface inAppMessageAnalyticsInterface, @NotNull Continuation<? super DisplayResult> continuation) {
        this.analyticsListener = new InAppMessageDisplayListener(inAppMessageAnalyticsInterface, new ActiveTimer(this.activityMonitor, null, 2, null), new Function1() { // from class: com.urbanairship.iam.adapter.banner.BannerDisplayDelegate.display.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DisplayResult) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DisplayResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuation cancellableContinuation = BannerDisplayDelegate.this.continuation;
                if (cancellableContinuation != null) {
                    cancellableContinuation.resumeWith(Result.m2968constructorimpl(it));
                }
            }
        });
        this.activityMonitor.addActivityListener(this.listener);
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new AnonymousClass3(null), continuation);
    }

    /* renamed from: com.urbanairship.iam.adapter.banner.BannerDisplayDelegate$display$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BannerDisplayDelegate.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BannerDisplayDelegate bannerDisplayDelegate = BannerDisplayDelegate.this;
                this.L$0 = bannerDisplayDelegate;
                this.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                bannerDisplayDelegate.continuation = cancellableContinuationImpl;
                bannerDisplayDelegate.display();
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDisplayFinished() {
        this.activityMonitor.removeActivityListener(this.listener);
    }

    private final BannerView onCreateView(Activity activity) {
        return new BannerView(activity, this.displayContent.getBanner(), this.assets);
    }

    public final void onViewCreated$urbanairship_automation_release(@NotNull BannerView view, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (getLastActivity() != activity) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.displayContent.getBanner().getPlacement().ordinal()];
            if (i == 1) {
                view.setAnimations(R.animator.ua_iam_slide_in_bottom, R.animator.ua_iam_slide_out_bottom);
            } else if (i == 2) {
                view.setAnimations(R.animator.ua_iam_slide_in_top, R.animator.ua_iam_slide_out_top);
            }
        }
        view.setListener(new BannerView.Listener() { // from class: com.urbanairship.iam.adapter.banner.BannerDisplayDelegate$onViewCreated$1
            @Override // com.urbanairship.iam.view.BannerView.Listener
            public void onButtonClicked(@NotNull BannerView view2, @NotNull InAppMessageButtonInfo buttonInfo) {
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(buttonInfo, "buttonInfo");
                JsonMap actions = buttonInfo.getActions();
                if (actions != null) {
                    ActionRunner actionRunner = this.this$0.actionRunner;
                    Map<String, JsonValue> map = actions.getMap();
                    Intrinsics.checkNotNullExpressionValue(map, "getMap(...)");
                    ActionRunnerKt.run$default(actionRunner, map, null, null, 6, null);
                }
                InAppMessageDisplayListener inAppMessageDisplayListener = this.this$0.analyticsListener;
                if (inAppMessageDisplayListener != null) {
                    inAppMessageDisplayListener.onButtonDismissed(buttonInfo);
                }
                this.this$0.onDisplayFinished();
            }

            @Override // com.urbanairship.iam.view.BannerView.Listener
            public void onBannerClicked(@NotNull BannerView view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                JsonMap actions = this.this$0.displayContent.getBanner().getActions();
                if (actions != null && actions.isNotEmpty()) {
                    ActionRunner actionRunner = this.this$0.actionRunner;
                    Map<String, JsonValue> map = this.this$0.displayContent.getBanner().getActions().getMap();
                    Intrinsics.checkNotNullExpressionValue(map, "getMap(...)");
                    ActionRunnerKt.run$default(actionRunner, map, null, null, 6, null);
                    InAppMessageDisplayListener inAppMessageDisplayListener = this.this$0.analyticsListener;
                    if (inAppMessageDisplayListener != null) {
                        inAppMessageDisplayListener.onMessageTapDismissed();
                    }
                }
                this.this$0.onDisplayFinished();
            }

            @Override // com.urbanairship.iam.view.BannerView.Listener
            public void onTimedOut(@NotNull BannerView view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                InAppMessageDisplayListener inAppMessageDisplayListener = this.this$0.analyticsListener;
                if (inAppMessageDisplayListener != null) {
                    inAppMessageDisplayListener.onTimedOut();
                }
                this.this$0.onDisplayFinished();
            }

            @Override // com.urbanairship.iam.view.BannerView.Listener
            public void onUserDismissed(@NotNull BannerView view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                InAppMessageDisplayListener inAppMessageDisplayListener = this.this$0.analyticsListener;
                if (inAppMessageDisplayListener != null) {
                    inAppMessageDisplayListener.onUserDismissed();
                }
                this.this$0.onDisplayFinished();
            }
        });
        InAppMessageDisplayListener inAppMessageDisplayListener = this.analyticsListener;
        if (inAppMessageDisplayListener != null) {
            inAppMessageDisplayListener.onAppear();
        }
    }

    @Nullable
    public final ViewGroup getContainerView$urbanairship_automation_release(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void display() {
        ViewGroup containerView$urbanairship_automation_release;
        Activity activity = (Activity) CollectionsKt.firstOrNull((List) this.activityMonitor.getResumedActivities(getActivityPredicate()));
        if (activity == null || (containerView$urbanairship_automation_release = getContainerView$urbanairship_automation_release(activity)) == null) {
            return;
        }
        BannerView bannerViewOnCreateView = onCreateView(activity);
        onViewCreated$urbanairship_automation_release(bannerViewOnCreateView, activity);
        if (bannerViewOnCreateView.getParent() == null) {
            if (containerView$urbanairship_automation_release.getId() == 16908290) {
                bannerViewOnCreateView.setZ(InAppViewUtils.INSTANCE.getLargestChildZValue(containerView$urbanairship_automation_release) + 1);
                containerView$urbanairship_automation_release.addView(bannerViewOnCreateView, 0);
            } else {
                containerView$urbanairship_automation_release.addView(bannerViewOnCreateView);
            }
        }
        this.lastActivity = new WeakReference(activity);
        this.currentView = new WeakReference(bannerViewOnCreateView);
    }

    private final int getContainerId(Activity activity) {
        Bundle bundle;
        Map map = cachedContainerIds;
        synchronized (map) {
            Integer num = (Integer) map.get(activity.getClass());
            if (num != null) {
                return num.intValue();
            }
            ActivityInfo activityInfo = ManifestUtils.getActivityInfo(activity.getClass());
            int i = 0;
            if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                i = bundle.getInt("com.urbanairship.iam.banner.BANNER_CONTAINER_ID", 0);
            }
            map.put(activity.getClass(), Integer.valueOf(i));
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityResumed(Activity activity) {
        BannerView currentView = getCurrentView();
        if (currentView == null || !currentView.isAttachedToWindow()) {
            display();
        } else if (activity == getLastActivity()) {
            currentView.onResume$urbanairship_automation_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityStopped(Activity activity) throws Resources.NotFoundException {
        BannerView currentView;
        if (activity == getLastActivity() && (currentView = getCurrentView()) != null) {
            this.currentView = null;
            this.lastActivity = null;
            currentView.dismiss$urbanairship_automation_release(false);
            display();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityPaused(Activity activity) {
        BannerView currentView;
        if (activity == getLastActivity() && (currentView = getCurrentView()) != null) {
            currentView.onPause$urbanairship_automation_release();
        }
    }

    private final BannerView getCurrentView() {
        WeakReference weakReference = this.currentView;
        if (weakReference != null) {
            return (BannerView) weakReference.get();
        }
        return null;
    }

    private final Activity getLastActivity() {
        WeakReference weakReference = this.lastActivity;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }
}

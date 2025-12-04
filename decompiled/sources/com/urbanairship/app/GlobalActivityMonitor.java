package com.urbanairship.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020$H\u0016J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0%2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'H\u0017J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010+\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010,\u001a\u00020 2\u0006\u0010!\u001a\u00020$H\u0016J\u0010\u0010-\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/urbanairship/app/GlobalActivityMonitor;", "Lcom/urbanairship/app/ActivityMonitor;", "()V", "_foregroundState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_resumedActivities", "", "Landroid/app/Activity;", "backgroundRunnable", "Ljava/lang/Runnable;", "backgroundTime", "", "foregroundState", "Lkotlinx/coroutines/flow/StateFlow;", "getForegroundState", "()Lkotlinx/coroutines/flow/StateFlow;", "forwardingActivityListener", "Lcom/urbanairship/app/ForwardingActivityListener;", "forwardingApplicationListener", "Lcom/urbanairship/app/ForwardingApplicationListener;", "handler", "Landroid/os/Handler;", "<set-?>", "isAppForegrounded", "()Z", "resumedActivities", "getResumedActivities", "()Ljava/util/List;", "startedActivities", "", "addActivityListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/app/ActivityListener;", "addApplicationListener", "Lcom/urbanairship/app/ApplicationListener;", "", ViewProps.FILTER, "Lcom/urbanairship/Predicate;", "registerListener", "context", "Landroid/content/Context;", "removeActivityListener", "removeApplicationListener", "unregisterListener", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalActivityMonitor implements ActivityMonitor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static GlobalActivityMonitor singleton;
    private final MutableStateFlow _foregroundState;
    private final List _resumedActivities;
    private final Runnable backgroundRunnable;
    private long backgroundTime;
    private final StateFlow foregroundState;
    private final ForwardingActivityListener forwardingActivityListener;
    private final ForwardingApplicationListener forwardingApplicationListener;
    private final Handler handler;
    private boolean isAppForegrounded;
    private int startedActivities;

    @JvmStatic
    @NotNull
    public static final GlobalActivityMonitor shared(@NotNull Context context) {
        return INSTANCE.shared(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public GlobalActivityMonitor() {
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._foregroundState = MutableStateFlow;
        this.foregroundState = FlowKt.asStateFlow(MutableStateFlow);
        this.handler = new Handler(Looper.getMainLooper());
        this.backgroundRunnable = new Runnable() { // from class: com.urbanairship.app.GlobalActivityMonitor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GlobalActivityMonitor.backgroundRunnable$lambda$0(this.f$0);
            }
        };
        this._resumedActivities = new ArrayList();
        this.forwardingApplicationListener = new ForwardingApplicationListener();
        this.forwardingActivityListener = new ForwardingActivityListener() { // from class: com.urbanairship.app.GlobalActivityMonitor$forwardingActivityListener$1
            @Override // com.urbanairship.app.ForwardingActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.this$0._resumedActivities.add(activity);
                super.onActivityResumed(activity);
            }

            @Override // com.urbanairship.app.ForwardingActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.this$0._resumedActivities.remove(activity);
                super.onActivityPaused(activity);
            }

            @Override // com.urbanairship.app.ForwardingActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.this$0.handler.removeCallbacks(this.this$0.backgroundRunnable);
                this.this$0.startedActivities++;
                if (!this.this$0.getIsAppForegrounded()) {
                    this.this$0.isAppForegrounded = true;
                    this.this$0._foregroundState.setValue(Boolean.TRUE);
                    this.this$0.forwardingApplicationListener.onForeground(System.currentTimeMillis());
                }
                super.onActivityStarted(activity);
            }

            @Override // com.urbanairship.app.ForwardingActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (this.this$0.startedActivities > 0) {
                    GlobalActivityMonitor globalActivityMonitor = this.this$0;
                    globalActivityMonitor.startedActivities--;
                }
                if (this.this$0.startedActivities == 0 && this.this$0.getIsAppForegrounded()) {
                    this.this$0.backgroundTime = System.currentTimeMillis() + 200;
                    this.this$0.handler.postDelayed(this.this$0.backgroundRunnable, 200L);
                }
                super.onActivityStopped(activity);
            }
        };
    }

    @Override // com.urbanairship.app.ActivityMonitor
    @NotNull
    public StateFlow<Boolean> getForegroundState() {
        return this.foregroundState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void backgroundRunnable$lambda$0(GlobalActivityMonitor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isAppForegrounded = false;
        this$0._foregroundState.setValue(Boolean.FALSE);
        this$0.forwardingApplicationListener.onBackground(this$0.backgroundTime);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    /* renamed from: isAppForegrounded, reason: from getter */
    public boolean getIsAppForegrounded() {
        return this.isAppForegrounded;
    }

    @Override // com.urbanairship.app.ActivityMonitor
    @NotNull
    public List<Activity> getResumedActivities() {
        List<Activity> listUnmodifiableList = Collections.unmodifiableList(this._resumedActivities);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    @VisibleForTesting
    public final void registerListener(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(this.forwardingActivityListener);
    }

    @VisibleForTesting
    public final void unregisterListener(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this.forwardingActivityListener);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    public void addActivityListener(@NotNull ActivityListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.forwardingActivityListener.addListener(listener);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    public void removeActivityListener(@NotNull ActivityListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.forwardingActivityListener.removeListener(listener);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    public void addApplicationListener(@NotNull ApplicationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.forwardingApplicationListener.addListener(listener);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    public void removeApplicationListener(@NotNull ApplicationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.forwardingApplicationListener.removeListener(listener);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    @MainThread
    @NotNull
    public List<Activity> getResumedActivities(@Nullable Predicate<Activity> filter) {
        ArrayList arrayList = new ArrayList();
        for (Activity activity : this._resumedActivities) {
            if (filter == null || filter.apply(activity)) {
                arrayList.add(activity);
            }
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/app/GlobalActivityMonitor$Companion;", "", "()V", "BACKGROUND_DELAY_MS", "", "singleton", "Lcom/urbanairship/app/GlobalActivityMonitor;", "shared", "context", "Landroid/content/Context;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final GlobalActivityMonitor shared(@NotNull Context context) {
            GlobalActivityMonitor globalActivityMonitor;
            Intrinsics.checkNotNullParameter(context, "context");
            GlobalActivityMonitor globalActivityMonitor2 = GlobalActivityMonitor.singleton;
            if (globalActivityMonitor2 != null) {
                return globalActivityMonitor2;
            }
            synchronized (GlobalActivityMonitor.class) {
                globalActivityMonitor = GlobalActivityMonitor.singleton;
                if (globalActivityMonitor == null) {
                    globalActivityMonitor = new GlobalActivityMonitor();
                    globalActivityMonitor.registerListener(context);
                    GlobalActivityMonitor.singleton = globalActivityMonitor;
                }
            }
            return globalActivityMonitor;
        }
    }
}

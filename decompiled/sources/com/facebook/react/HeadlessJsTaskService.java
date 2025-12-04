package com.facebook.react;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0004J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/facebook/react/HeadlessJsTaskService;", "Landroid/app/Service;", "Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;", "<init>", "()V", "activeTasks", "", "", "onStartCommand", "intent", "Landroid/content/Intent;", "flags", "startId", "getTaskConfig", "Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;", "onBind", "Landroid/os/IBinder;", "startTask", "", "taskConfig", "invokeStartTask", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "onDestroy", "onHeadlessJsTaskStart", "taskId", "onHeadlessJsTaskFinish", "reactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "getReactNativeHost", "()Lcom/facebook/react/ReactNativeHost;", "reactHost", "Lcom/facebook/react/ReactHost;", "getReactHost", "()Lcom/facebook/react/ReactHost;", "getReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "createReactContextAndScheduleTask", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHeadlessJsTaskService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeadlessJsTaskService.kt\ncom/facebook/react/HeadlessJsTaskService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,186:1\n1#2:187\n*E\n"})
/* loaded from: classes3.dex */
public abstract class HeadlessJsTaskService extends Service implements HeadlessJsTaskEventListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static PowerManager.WakeLock wakeLock;

    @NotNull
    private final Set<Integer> activeTasks = new CopyOnWriteArraySet();

    @JvmStatic
    @SuppressLint({"WakelockTimeout"})
    public static final void acquireWakeLockNow(@NotNull Context context) {
        INSTANCE.acquireWakeLockNow(context);
    }

    @Nullable
    protected HeadlessJsTaskConfig getTaskConfig(@Nullable Intent intent) {
        return null;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskStart(int taskId) {
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        HeadlessJsTaskConfig taskConfig = getTaskConfig(intent);
        if (taskConfig == null) {
            return 2;
        }
        startTask(taskConfig);
        return 3;
    }

    protected final void startTask(@NotNull HeadlessJsTaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        UiThreadUtil.assertOnUiThread();
        INSTANCE.acquireWakeLockNow(this);
        ReactContext reactContext = getReactContext();
        if (reactContext == null) {
            createReactContextAndScheduleTask(taskConfig);
        } else {
            invokeStartTask(reactContext, taskConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeStartTask(ReactContext reactContext, final HeadlessJsTaskConfig taskConfig) {
        final HeadlessJsTaskContext companion = HeadlessJsTaskContext.INSTANCE.getInstance(reactContext);
        companion.addTaskEventListener(this);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.HeadlessJsTaskService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HeadlessJsTaskService.invokeStartTask$lambda$0(companion, taskConfig, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeStartTask$lambda$0(HeadlessJsTaskContext headlessJsTaskContext, HeadlessJsTaskConfig headlessJsTaskConfig, HeadlessJsTaskService headlessJsTaskService) {
        headlessJsTaskService.activeTasks.add(Integer.valueOf(headlessJsTaskContext.startTask(headlessJsTaskConfig)));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ReactContext reactContext = getReactContext();
        if (reactContext != null) {
            HeadlessJsTaskContext.INSTANCE.getInstance(reactContext).removeTaskEventListener(this);
        }
        PowerManager.WakeLock wakeLock2 = wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskFinish(int taskId) {
        this.activeTasks.remove(Integer.valueOf(taskId));
        if (this.activeTasks.isEmpty()) {
            stopSelf();
        }
    }

    @NotNull
    protected final ReactNativeHost getReactNativeHost() {
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
        return ((ReactApplication) application).getReactNativeHost();
    }

    @Nullable
    protected final ReactHost getReactHost() {
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
        return ((ReactApplication) application).getReactHost();
    }

    @Nullable
    protected final ReactContext getReactContext() {
        if (ReactNativeFeatureFlags.enableBridgelessArchitecture()) {
            ReactHost reactHost = getReactHost();
            if (reactHost == null) {
                throw new IllegalStateException("ReactHost is not initialized in New Architecture");
            }
            return reactHost.getCurrentReactContext();
        }
        return getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
    }

    private final void createReactContextAndScheduleTask(final HeadlessJsTaskConfig taskConfig) {
        if (ReactNativeFeatureFlags.enableBridgelessArchitecture()) {
            final ReactHost reactHost = getReactHost();
            if (reactHost == null) {
                throw new IllegalStateException("Required value was null.");
            }
            reactHost.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: com.facebook.react.HeadlessJsTaskService.createReactContextAndScheduleTask.1
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(ReactContext context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    HeadlessJsTaskService.this.invokeStartTask(context, taskConfig);
                    reactHost.removeReactInstanceEventListener(this);
                }
            });
            reactHost.start();
            return;
        }
        final ReactInstanceManager reactInstanceManager = getReactNativeHost().getReactInstanceManager();
        reactInstanceManager.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: com.facebook.react.HeadlessJsTaskService.createReactContextAndScheduleTask.2
            @Override // com.facebook.react.ReactInstanceEventListener
            public void onReactContextInitialized(ReactContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                HeadlessJsTaskService.this.invokeStartTask(context, taskConfig);
                reactInstanceManager.removeReactInstanceEventListener(this);
            }
        });
        reactInstanceManager.createReactContextInBackground();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/react/HeadlessJsTaskService$Companion;", "", "<init>", "()V", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "acquireWakeLockNow", "", "context", "Landroid/content/Context;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @SuppressLint({"WakelockTimeout"})
        public final void acquireWakeLockNow(@NotNull Context context) {
            PowerManager.WakeLock wakeLock;
            Intrinsics.checkNotNullParameter(context, "context");
            if (HeadlessJsTaskService.wakeLock == null || !((wakeLock = HeadlessJsTaskService.wakeLock) == null || wakeLock.isHeld())) {
                Object systemService = context.getSystemService("power");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, HeadlessJsTaskService.class.getCanonicalName());
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire();
                HeadlessJsTaskService.wakeLock = wakeLockNewWakeLock;
            }
        }
    }
}

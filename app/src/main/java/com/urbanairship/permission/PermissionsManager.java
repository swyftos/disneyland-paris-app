package com.urbanairship.permission;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PendingResult;
import com.urbanairship.ResultCallback;
import com.urbanairship.UALog;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.GlobalActivityMonitor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0015J\u0016\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190+2\u0006\u0010,\u001a\u00020\u000fJ\u001e\u0010*\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000f2\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u000eJ\u0012\u0010.\u001a\u0004\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020\u000fH\u0002J\u0010\u0010/\u001a\u0002002\u0006\u0010,\u001a\u00020\u000fH\u0003J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010,\u001a\u00020\u000fJ\u000e\u00102\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0015J,\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0+2\u0006\u0010,\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u0002002\b\b\u0002\u00105\u001a\u000206H\u0007J4\u00103\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u0002002\b\b\u0002\u00105\u001a\u0002062\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000eH\u0007J\u0018\u00107\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000f2\b\u00108\u001a\u0004\u0018\u00010\u001dJ\u0016\u00109\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010:J*\u0010;\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u0002002\b\b\u0002\u00105\u001a\u000206H\u0086@¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0019H\u0003J\u000e\u0010?\u001a\u00020&H\u0082@¢\u0006\u0002\u0010@R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, m1836d2 = {"Lcom/urbanairship/permission/PermissionsManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "systemSettingsLauncher", "Lcom/urbanairship/permission/SystemSettingsLauncher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/permission/SystemSettingsLauncher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "airshipEnablers", "", "Landroidx/core/util/Consumer;", "Lcom/urbanairship/permission/Permission;", "configuredPermissions", "", "getConfiguredPermissions", "()Ljava/util/Set;", "onPermissionStatusChangedListeners", "Lcom/urbanairship/permission/OnPermissionStatusChangedListener;", "pendingCheckResults", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/permission/PermissionStatus;", "pendingRequestResults", "Lcom/urbanairship/permission/PermissionRequestResult;", "permissionDelegateMap", "Lcom/urbanairship/permission/PermissionDelegate;", "permissionStatusMap", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "permissionsJob", "Lkotlinx/coroutines/CompletableJob;", "permissionsScope", "Lkotlinx/coroutines/CoroutineScope;", "addAirshipEnabler", "", "onEnable", "addOnPermissionStatusChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "checkPermissionStatus", "Lcom/urbanairship/PendingResult;", "permission", "callback", "getDelegate", "launchSettingsForPermission", "", "permissionsUpdate", "removeOnPermissionStatusChangedListener", "requestPermission", "enableAirshipUsageOnGrant", "fallback", "Lcom/urbanairship/permission/PermissionPromptFallback;", "setPermissionDelegate", "delegate", "suspendingCheckPermissionStatus", "(Lcom/urbanairship/permission/Permission;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendingRequestPermission", "(Lcom/urbanairship/permission/Permission;ZLcom/urbanairship/permission/PermissionPromptFallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePermissionStatus", "status", "waitForResume", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nPermissionsManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionsManager.kt\ncom/urbanairship/permission/PermissionsManager\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 5 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 6 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,411:1\n214#2,3:412\n217#2,2:416\n1#3:415\n53#4:418\n55#4:422\n50#5:419\n55#5:421\n106#6:420\n*S KotlinDebug\n*F\n+ 1 PermissionsManager.kt\ncom/urbanairship/permission/PermissionsManager\n*L\n84#1:412,3\n84#1:416,2\n182#1:418\n182#1:422\n182#1:419\n182#1:421\n182#1:420\n*E\n"})
public final class PermissionsManager {
    private final ActivityMonitor activityMonitor;
    private final List airshipEnablers;
    private final Context context;
    private final List onPermissionStatusChangedListeners;
    private final Map pendingCheckResults;
    private final Map pendingRequestResults;
    private final Map permissionDelegateMap;
    private final MutableStateFlow permissionStatusMap;
    private final CompletableJob permissionsJob;
    private final CoroutineScope permissionsScope;
    private final SystemSettingsLauncher systemSettingsLauncher;

    /* JADX INFO: renamed from: com.urbanairship.permission.PermissionsManager$suspendingRequestPermission$1 */
    static final class C56521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C56521(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PermissionsManager.this.suspendingRequestPermission(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.permission.PermissionsManager$waitForResume$1 */
    static final class C56551 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C56551(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PermissionsManager.this.waitForResume(this);
        }
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<PermissionRequestResult> requestPermission(@NotNull Permission permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return requestPermission$default(this, permission, false, null, 6, null);
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<PermissionRequestResult> requestPermission(@NotNull Permission permission, boolean z) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return requestPermission$default(this, permission, z, null, 4, null);
    }

    @JvmOverloads
    public final void requestPermission(@NotNull Permission permission, @NotNull Consumer<PermissionRequestResult> callback) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(callback, "callback");
        requestPermission$default(this, permission, false, null, callback, 6, null);
    }

    @JvmOverloads
    public final void requestPermission(@NotNull Permission permission, boolean z, @NotNull Consumer<PermissionRequestResult> callback) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(callback, "callback");
        requestPermission$default(this, permission, z, null, callback, 4, null);
    }

    public PermissionsManager(@NotNull Context context, @NotNull ActivityMonitor activityMonitor, @NotNull SystemSettingsLauncher systemSettingsLauncher, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(systemSettingsLauncher, "systemSettingsLauncher");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.context = context;
        this.activityMonitor = activityMonitor;
        this.systemSettingsLauncher = systemSettingsLauncher;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.permissionsJob = completableJobSupervisorJob$default;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(completableJobSupervisorJob$default));
        this.permissionsScope = CoroutineScope;
        this.permissionDelegateMap = new LinkedHashMap();
        this.airshipEnablers = new CopyOnWriteArrayList();
        this.onPermissionStatusChangedListeners = new CopyOnWriteArrayList();
        this.permissionStatusMap = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this.pendingRequestResults = new LinkedHashMap();
        this.pendingCheckResults = new LinkedHashMap();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C56461(null), 3, null);
    }

    public /* synthetic */ PermissionsManager(Context context, ActivityMonitor activityMonitor, SystemSettingsLauncher systemSettingsLauncher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, activityMonitor, systemSettingsLauncher, (i & 8) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PermissionsManager(@NotNull Context context) {
        this(context, GlobalActivityMonitor.INSTANCE.shared(context), new SystemSettingsLauncher(), null, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: renamed from: com.urbanairship.permission.PermissionsManager$1 */
    static final class C56461 extends SuspendLambda implements Function2 {
        int label;

        C56461(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PermissionsManager.this.new C56461(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C56461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.urbanairship.permission.PermissionsManager$1$1, reason: invalid class name */
        static final class AnonymousClass1 implements FlowCollector {
            final /* synthetic */ PermissionsManager this$0;

            AnonymousClass1(PermissionsManager permissionsManager) {
                this.this$0 = permissionsManager;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Activity activity, Continuation continuation) {
                PermissionsManager$1$1$emit$1 permissionsManager$1$1$emit$1;
                PermissionsManager permissionsManager;
                Iterator it;
                if (continuation instanceof PermissionsManager$1$1$emit$1) {
                    permissionsManager$1$1$emit$1 = (PermissionsManager$1$1$emit$1) continuation;
                    int i = permissionsManager$1$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        permissionsManager$1$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        permissionsManager$1$1$emit$1 = new PermissionsManager$1$1$emit$1(this, continuation);
                    }
                } else {
                    permissionsManager$1$1$emit$1 = new PermissionsManager$1$1$emit$1(this, continuation);
                }
                Object obj = permissionsManager$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = permissionsManager$1$1$emit$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!Intrinsics.areEqual(activity.getClass(), PermissionsActivity.class)) {
                        Set<Permission> configuredPermissions = this.this$0.getConfiguredPermissions();
                        PermissionsManager permissionsManager2 = this.this$0;
                        Iterator it2 = configuredPermissions.iterator();
                        permissionsManager = permissionsManager2;
                        it = it2;
                    }
                    return Unit.INSTANCE;
                }
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) permissionsManager$1$1$emit$1.L$1;
                permissionsManager = (PermissionsManager) permissionsManager$1$1$emit$1.L$0;
                ResultKt.throwOnFailure(obj);
                while (it.hasNext()) {
                    Permission permission = (Permission) it.next();
                    permissionsManager$1$1$emit$1.L$0 = permissionsManager;
                    permissionsManager$1$1$emit$1.L$1 = it;
                    permissionsManager$1$1$emit$1.label = 1;
                    if (permissionsManager.suspendingCheckPermissionStatus(permission, permissionsManager$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityMonitor activityMonitor = PermissionsManager.this.activityMonitor;
                this.label = 1;
                obj = PermissionsManagerKt.resumedActivities(activityMonitor, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(PermissionsManager.this);
            this.label = 2;
            if (((Flow) obj).collect(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePermissionStatus(Permission permission, PermissionStatus status) {
        Object value;
        Map map;
        Map mutableMap;
        MutableStateFlow mutableStateFlow = this.permissionStatusMap;
        do {
            value = mutableStateFlow.getValue();
            map = (Map) value;
            mutableMap = MapsKt.toMutableMap(map);
            mutableMap.put(permission, status);
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
        if (map.get(permission) == null || map.get(permission) == status) {
            return;
        }
        Iterator it = this.onPermissionStatusChangedListeners.iterator();
        while (it.hasNext()) {
            ((OnPermissionStatusChangedListener) it.next()).onPermissionStatusChanged(permission, status);
        }
    }

    @NotNull
    public final Set<Permission> getConfiguredPermissions() {
        Set<Permission> setKeySet;
        synchronized (this.permissionDelegateMap) {
            setKeySet = this.permissionDelegateMap.keySet();
        }
        return setKeySet;
    }

    public final void setPermissionDelegate(@NotNull Permission permission, @Nullable PermissionDelegate delegate) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        synchronized (this.permissionDelegateMap) {
            this.permissionDelegateMap.put(permission, delegate);
            checkPermissionStatus(permission);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void addAirshipEnabler(@NotNull Consumer<Permission> onEnable) {
        Intrinsics.checkNotNullParameter(onEnable, "onEnable");
        this.airshipEnablers.add(onEnable);
    }

    public final void addOnPermissionStatusChangedListener(@NotNull OnPermissionStatusChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onPermissionStatusChangedListeners.add(listener);
    }

    public final void removeOnPermissionStatusChangedListener(@NotNull OnPermissionStatusChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onPermissionStatusChangedListeners.remove(listener);
    }

    public final void checkPermissionStatus(@NotNull Permission permission, @NotNull final Consumer<PermissionStatus> callback) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(callback, "callback");
        checkPermissionStatus(permission).addResultCallback(new ResultCallback() { // from class: com.urbanairship.permission.PermissionsManager$$ExternalSyntheticLambda1
            @Override // com.urbanairship.ResultCallback
            public final void onResult(Object obj) {
                PermissionsManager.checkPermissionStatus$lambda$4(callback, (PermissionStatus) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkPermissionStatus$lambda$4(Consumer callback, PermissionStatus permissionStatus) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.accept(permissionStatus);
    }

    /* JADX INFO: renamed from: com.urbanairship.permission.PermissionsManager$checkPermissionStatus$2 */
    static final class C56472 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        final /* synthetic */ Permission $permission;
        Object L$0;
        int label;
        final /* synthetic */ PermissionsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C56472(PendingResult pendingResult, PermissionsManager permissionsManager, Permission permission, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = permissionsManager;
            this.$permission = permission;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C56472(this.$pendingResult, this.this$0, this.$permission, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C56472) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$pendingResult;
                PermissionsManager permissionsManager = this.this$0;
                Permission permission = this.$permission;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object objSuspendingCheckPermissionStatus = permissionsManager.suspendingCheckPermissionStatus(permission, this);
                if (objSuspendingCheckPermissionStatus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objSuspendingCheckPermissionStatus;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final PendingResult<PermissionStatus> checkPermissionStatus(@NotNull Permission permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        PendingResult<PermissionStatus> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.permissionsScope, null, null, new C56472(pendingResult, this, permission, null), 3, null);
        return pendingResult;
    }

    @NotNull
    public final Flow<PermissionStatus> permissionsUpdate(@NotNull final Permission permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        final MutableStateFlow mutableStateFlow = this.permissionStatusMap;
        return FlowKt.distinctUntilChanged(FlowKt.filterNotNull(new Flow<PermissionStatus>() { // from class: com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super PermissionStatus> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = mutableStateFlow.collect(new C56482(flowCollector, permission), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1$2 */
            @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PermissionsManager.kt\ncom/urbanairship/permission/PermissionsManager\n*L\n1#1,222:1\n54#2:223\n182#3:224\n*E\n"})
            public static final class C56482<T> implements FlowCollector {
                final /* synthetic */ Permission $permission$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @DebugMetadata(m1844c = "com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1$2", m1845f = "PermissionsManager.kt", m1846i = {}, m1847l = {223}, m1848m = "emit", m1849n = {}, m1850s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
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
                        return C56482.this.emit(null, this);
                    }
                }

                public C56482(FlowCollector flowCollector, Permission permission) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$permission$inlined = permission;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Object obj3 = ((Map) obj).get(this.$permission$inlined);
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(obj3, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        }));
    }

    public static /* synthetic */ void requestPermission$default(PermissionsManager permissionsManager, Permission permission, boolean z, PermissionPromptFallback permissionPromptFallback, Consumer consumer, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            permissionPromptFallback = PermissionPromptFallback.None.INSTANCE;
        }
        permissionsManager.requestPermission(permission, z, permissionPromptFallback, consumer);
    }

    /* JADX INFO: renamed from: com.urbanairship.permission.PermissionsManager$requestPermission$1 */
    static final class C56491 extends SuspendLambda implements Function2 {
        final /* synthetic */ boolean $enableAirshipUsageOnGrant;
        final /* synthetic */ Permission $permission;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C56491(Permission permission, boolean z, Continuation continuation) {
            super(2, continuation);
            this.$permission = permission;
            this.$enableAirshipUsageOnGrant = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PermissionsManager.this.new C56491(this.$permission, this.$enableAirshipUsageOnGrant, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C56491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PermissionsManager permissionsManager = PermissionsManager.this;
                Permission permission = this.$permission;
                boolean z = this.$enableAirshipUsageOnGrant;
                this.label = 1;
                if (PermissionsManager.suspendingRequestPermission$default(permissionsManager, permission, z, null, this, 4, null) == coroutine_suspended) {
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

    @JvmOverloads
    public final void requestPermission(@NotNull Permission permission, boolean enableAirshipUsageOnGrant, @NotNull PermissionPromptFallback fallback, @NotNull final Consumer<PermissionRequestResult> callback) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(this.permissionsScope, null, null, new C56491(permission, enableAirshipUsageOnGrant, null), 3, null);
        requestPermission(permission, enableAirshipUsageOnGrant, fallback).addResultCallback(new ResultCallback() { // from class: com.urbanairship.permission.PermissionsManager$$ExternalSyntheticLambda0
            @Override // com.urbanairship.ResultCallback
            public final void onResult(Object obj) {
                PermissionsManager.requestPermission$lambda$6(callback, (PermissionRequestResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$6(Consumer callback, PermissionRequestResult permissionRequestResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.accept(permissionRequestResult);
    }

    public static /* synthetic */ PendingResult requestPermission$default(PermissionsManager permissionsManager, Permission permission, boolean z, PermissionPromptFallback permissionPromptFallback, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            permissionPromptFallback = PermissionPromptFallback.None.INSTANCE;
        }
        return permissionsManager.requestPermission(permission, z, permissionPromptFallback);
    }

    /* JADX INFO: renamed from: com.urbanairship.permission.PermissionsManager$requestPermission$3 */
    static final class C56503 extends SuspendLambda implements Function2 {
        final /* synthetic */ boolean $enableAirshipUsageOnGrant;
        final /* synthetic */ PermissionPromptFallback $fallback;
        final /* synthetic */ PendingResult $pendingResult;
        final /* synthetic */ Permission $permission;
        Object L$0;
        int label;
        final /* synthetic */ PermissionsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C56503(PendingResult pendingResult, PermissionsManager permissionsManager, Permission permission, boolean z, PermissionPromptFallback permissionPromptFallback, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = permissionsManager;
            this.$permission = permission;
            this.$enableAirshipUsageOnGrant = z;
            this.$fallback = permissionPromptFallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C56503(this.$pendingResult, this.this$0, this.$permission, this.$enableAirshipUsageOnGrant, this.$fallback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C56503) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$pendingResult;
                PermissionsManager permissionsManager = this.this$0;
                Permission permission = this.$permission;
                boolean z = this.$enableAirshipUsageOnGrant;
                PermissionPromptFallback permissionPromptFallback = this.$fallback;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object objSuspendingRequestPermission = permissionsManager.suspendingRequestPermission(permission, z, permissionPromptFallback, this);
                if (objSuspendingRequestPermission == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objSuspendingRequestPermission;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<PermissionRequestResult> requestPermission(@NotNull Permission permission, boolean enableAirshipUsageOnGrant, @NotNull PermissionPromptFallback fallback) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        PendingResult<PermissionRequestResult> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.permissionsScope, null, null, new C56503(pendingResult, this, permission, enableAirshipUsageOnGrant, fallback, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:54:0x0114 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x0119  */
    /* JADX WARN: Code duplicated, block: B:58:0x011e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object suspendingRequestPermission(@NotNull Permission permission, boolean z, @NotNull PermissionPromptFallback permissionPromptFallback, @NotNull Continuation<? super PermissionRequestResult> continuation) {
        C56521 c56521;
        PermissionRequestResult permissionRequestResultGranted;
        PermissionsManager permissionsManager;
        PermissionRequestResult permissionRequestResult;
        PermissionsManager permissionsManager2;
        PermissionRequestResult permissionRequestResultGranted2;
        if (continuation instanceof C56521) {
            c56521 = (C56521) continuation;
            int i = c56521.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c56521.label = i - Integer.MIN_VALUE;
            } else {
                c56521 = new C56521(continuation);
            }
        } else {
            c56521 = new C56521(continuation);
        }
        Object objWithContext = c56521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c56521.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            PermissionsManager$suspendingRequestPermission$result$1 permissionsManager$suspendingRequestPermission$result$1 = new PermissionsManager$suspendingRequestPermission$result$1(this, permission, z, null);
            c56521.L$0 = this;
            c56521.L$1 = permission;
            c56521.L$2 = permissionPromptFallback;
            c56521.label = 1;
            objWithContext = BuildersKt.withContext(immediate, permissionsManager$suspendingRequestPermission$result$1, c56521);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    permissionRequestResultGranted2 = (PermissionRequestResult) c56521.L$2;
                    permission = (Permission) c56521.L$1;
                    permissionsManager2 = (PermissionsManager) c56521.L$0;
                    ResultKt.throwOnFailure(objWithContext);
                    c56521.L$0 = permissionRequestResultGranted2;
                    c56521.L$1 = null;
                    c56521.L$2 = null;
                    c56521.label = 3;
                    objWithContext = permissionsManager2.suspendingCheckPermissionStatus(permission, c56521);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            permissionRequestResult = (PermissionRequestResult) c56521.L$2;
                            permission = (Permission) c56521.L$1;
                            permissionsManager = (PermissionsManager) c56521.L$0;
                            ResultKt.throwOnFailure(objWithContext);
                            c56521.L$0 = permissionRequestResult;
                            c56521.L$1 = null;
                            c56521.L$2 = null;
                            c56521.label = 5;
                            objWithContext = permissionsManager.suspendingCheckPermissionStatus(permission, c56521);
                            if (objWithContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i2 != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            permissionRequestResult = (PermissionRequestResult) c56521.L$0;
                            ResultKt.throwOnFailure(objWithContext);
                        }
                        if (objWithContext == PermissionStatus.GRANTED) {
                            permissionRequestResultGranted = PermissionRequestResult.granted();
                        } else {
                            permissionRequestResultGranted = permissionRequestResult;
                        }
                        Intrinsics.checkNotNull(permissionRequestResultGranted);
                        return permissionRequestResultGranted;
                    }
                    permissionRequestResultGranted2 = (PermissionRequestResult) c56521.L$0;
                    ResultKt.throwOnFailure(objWithContext);
                }
                if (((PermissionStatus) objWithContext) == PermissionStatus.GRANTED) {
                    permissionRequestResultGranted2 = PermissionRequestResult.granted();
                }
                PermissionRequestResult permissionRequestResult2 = permissionRequestResultGranted2;
                Intrinsics.checkNotNull(permissionRequestResult2);
                return permissionRequestResult2;
            }
            permissionPromptFallback = (PermissionPromptFallback) c56521.L$2;
            permission = (Permission) c56521.L$1;
            this = (PermissionsManager) c56521.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        Intrinsics.checkNotNullExpressionValue(objWithContext, "withContext(...)");
        permissionRequestResultGranted = (PermissionRequestResult) objWithContext;
        if (!permissionRequestResultGranted.isSilentlyDenied() || (permissionPromptFallback instanceof PermissionPromptFallback.None)) {
            return permissionRequestResultGranted;
        }
        if (permissionPromptFallback instanceof PermissionPromptFallback.Callback) {
            Function1<Continuation<? super Unit>, Object> callback$urbanairship_core_release = ((PermissionPromptFallback.Callback) permissionPromptFallback).getCallback$urbanairship_core_release();
            c56521.L$0 = this;
            c56521.L$1 = permission;
            c56521.L$2 = permissionRequestResultGranted;
            c56521.label = 2;
            if (callback$urbanairship_core_release.invoke(c56521) == coroutine_suspended) {
                return coroutine_suspended;
            }
            permissionsManager2 = this;
            permissionRequestResultGranted2 = permissionRequestResultGranted;
            c56521.L$0 = permissionRequestResultGranted2;
            c56521.L$1 = null;
            c56521.L$2 = null;
            c56521.label = 3;
            objWithContext = permissionsManager2.suspendingCheckPermissionStatus(permission, c56521);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((PermissionStatus) objWithContext) == PermissionStatus.GRANTED) {
                permissionRequestResultGranted2 = PermissionRequestResult.granted();
            }
            PermissionRequestResult permissionRequestResult3 = permissionRequestResultGranted2;
            Intrinsics.checkNotNull(permissionRequestResult3);
            return permissionRequestResult3;
        }
        if (!(permissionPromptFallback instanceof PermissionPromptFallback.SystemSettings)) {
            throw new NoWhenBranchMatchedException();
        }
        if (this.launchSettingsForPermission(permission)) {
            c56521.L$0 = this;
            c56521.L$1 = permission;
            c56521.L$2 = permissionRequestResultGranted;
            c56521.label = 4;
            if (this.waitForResume(c56521) == coroutine_suspended) {
                return coroutine_suspended;
            }
            permissionsManager = this;
            permissionRequestResult = permissionRequestResultGranted;
            c56521.L$0 = permissionRequestResult;
            c56521.L$1 = null;
            c56521.L$2 = null;
            c56521.label = 5;
            objWithContext = permissionsManager.suspendingCheckPermissionStatus(permission, c56521);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (objWithContext == PermissionStatus.GRANTED) {
                permissionRequestResultGranted = PermissionRequestResult.granted();
            } else {
                permissionRequestResultGranted = permissionRequestResult;
            }
        }
        Intrinsics.checkNotNull(permissionRequestResultGranted);
        return permissionRequestResultGranted;
    }

    public static /* synthetic */ Object suspendingRequestPermission$default(PermissionsManager permissionsManager, Permission permission, boolean z, PermissionPromptFallback permissionPromptFallback, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            permissionPromptFallback = PermissionPromptFallback.None.INSTANCE;
        }
        return permissionsManager.suspendingRequestPermission(permission, z, permissionPromptFallback, continuation);
    }

    /* JADX INFO: renamed from: com.urbanairship.permission.PermissionsManager$suspendingCheckPermissionStatus$2 */
    static final class C56512 extends SuspendLambda implements Function2 {
        final /* synthetic */ Permission $permission;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C56512(Permission permission, Continuation continuation) {
            super(2, continuation);
            this.$permission = permission;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PermissionsManager.this.new C56512(this.$permission, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C56512) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x009a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Flow flow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flow = (Flow) this.L$0;
                ResultKt.throwOnFailure(obj);
                final PermissionStatus permissionStatus = (PermissionStatus) obj;
                PermissionsManager.this.updatePermissionStatus(this.$permission, permissionStatus);
                if (Intrinsics.areEqual(PermissionsManager.this.pendingCheckResults.get(this.$permission), flow)) {
                    PermissionsManager.this.pendingCheckResults.remove(this.$permission);
                }
                final Permission permission = this.$permission;
                UALog.d$default(null, new Function0() { // from class: com.urbanairship.permission.PermissionsManager.suspendingCheckPermissionStatus.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Permission " + permission + " request result: " + permissionStatus;
                    }
                }, 1, null);
                return permissionStatus;
            }
            ResultKt.throwOnFailure(obj);
            PermissionDelegate delegate = PermissionsManager.this.getDelegate(this.$permission);
            if (delegate != null) {
                Flow flow2 = (Flow) PermissionsManager.this.pendingCheckResults.get(this.$permission);
                if (flow2 != null) {
                    this.label = 1;
                    obj = FlowKt.first(flow2, this);
                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                }
                final Permission permission2 = this.$permission;
                UALog.d$default(null, new Function0() { // from class: com.urbanairship.permission.PermissionsManager.suspendingCheckPermissionStatus.2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Checking permission status for " + permission2;
                    }
                }, 1, null);
                Flow flowCheckPermissionFlow = PermissionsManagerKt.checkPermissionFlow(delegate, PermissionsManager.this.context, PermissionsManager.this.permissionsScope);
                PermissionsManager.this.pendingCheckResults.put(this.$permission, flowCheckPermissionFlow);
                this.L$0 = flowCheckPermissionFlow;
                this.label = 2;
                Object objFirst = FlowKt.first(flowCheckPermissionFlow, this);
                if (objFirst == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flow = flowCheckPermissionFlow;
                obj = objFirst;
                final PermissionStatus permissionStatus2 = (PermissionStatus) obj;
                PermissionsManager.this.updatePermissionStatus(this.$permission, permissionStatus2);
                if (Intrinsics.areEqual(PermissionsManager.this.pendingCheckResults.get(this.$permission), flow)) {
                    PermissionsManager.this.pendingCheckResults.remove(this.$permission);
                }
                final Permission permission3 = this.$permission;
                UALog.d$default(null, new Function0() { // from class: com.urbanairship.permission.PermissionsManager.suspendingCheckPermissionStatus.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Permission " + permission3 + " request result: " + permissionStatus2;
                    }
                }, 1, null);
                return permissionStatus2;
            }
            return PermissionStatus.NOT_DETERMINED;
        }
    }

    @Nullable
    public final Object suspendingCheckPermissionStatus(@NotNull Permission permission, @NotNull Continuation<? super PermissionStatus> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new C56512(permission, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PermissionDelegate getDelegate(Permission permission) {
        PermissionDelegate permissionDelegate;
        synchronized (this.permissionDelegateMap) {
            permissionDelegate = (PermissionDelegate) this.permissionDelegateMap.get(permission);
        }
        return permissionDelegate;
    }

    private final boolean launchSettingsForPermission(Permission permission) {
        if (permission == Permission.DISPLAY_NOTIFICATIONS) {
            return this.systemSettingsLauncher.openAppNotificationSettings(this.context);
        }
        return this.systemSettingsLauncher.openAppSettings(this.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object waitForResume(Continuation continuation) {
        C56551 c56551;
        if (continuation instanceof C56551) {
            c56551 = (C56551) continuation;
            int i = c56551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c56551.label = i - Integer.MIN_VALUE;
            } else {
                c56551 = new C56551(continuation);
            }
        } else {
            c56551 = new C56551(continuation);
        }
        Object objResumedActivities = c56551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c56551.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objResumedActivities);
            ActivityMonitor activityMonitor = this.activityMonitor;
            c56551.label = 1;
            objResumedActivities = PermissionsManagerKt.resumedActivities(activityMonitor, c56551);
            if (objResumedActivities == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objResumedActivities);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objResumedActivities);
            }
            return Unit.INSTANCE;
        }
        c56551.label = 2;
        if (FlowKt.first((Flow) objResumedActivities, c56551) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}

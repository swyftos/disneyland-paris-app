package com.urbanairship.permission;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PendingResult;
import com.urbanairship.ResultCallback;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.permission.PermissionPromptFallback;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
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
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0015J\u0016\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190+2\u0006\u0010,\u001a\u00020\u000fJ\u001e\u0010*\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000f2\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u000eJ\u0012\u0010.\u001a\u0004\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020\u000fH\u0002J\u0010\u0010/\u001a\u0002002\u0006\u0010,\u001a\u00020\u000fH\u0003J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010,\u001a\u00020\u000fJ\u000e\u00102\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0015J,\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0+2\u0006\u0010,\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u0002002\b\b\u0002\u00105\u001a\u000206H\u0007J4\u00103\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u0002002\b\b\u0002\u00105\u001a\u0002062\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000eH\u0007J\u0018\u00107\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000f2\b\u00108\u001a\u0004\u0018\u00010\u001dJ\u0016\u00109\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010:J*\u0010;\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u0002002\b\b\u0002\u00105\u001a\u000206H\u0086@¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0019H\u0003J\u000e\u0010?\u001a\u00020&H\u0082@¢\u0006\u0002\u0010@R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/urbanairship/permission/PermissionsManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "systemSettingsLauncher", "Lcom/urbanairship/permission/SystemSettingsLauncher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/permission/SystemSettingsLauncher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "airshipEnablers", "", "Landroidx/core/util/Consumer;", "Lcom/urbanairship/permission/Permission;", "configuredPermissions", "", "getConfiguredPermissions", "()Ljava/util/Set;", "onPermissionStatusChangedListeners", "Lcom/urbanairship/permission/OnPermissionStatusChangedListener;", "pendingCheckResults", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/permission/PermissionStatus;", "pendingRequestResults", "Lcom/urbanairship/permission/PermissionRequestResult;", "permissionDelegateMap", "Lcom/urbanairship/permission/PermissionDelegate;", "permissionStatusMap", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "permissionsJob", "Lkotlinx/coroutines/CompletableJob;", "permissionsScope", "Lkotlinx/coroutines/CoroutineScope;", "addAirshipEnabler", "", "onEnable", "addOnPermissionStatusChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "checkPermissionStatus", "Lcom/urbanairship/PendingResult;", "permission", "callback", "getDelegate", "launchSettingsForPermission", "", "permissionsUpdate", "removeOnPermissionStatusChangedListener", "requestPermission", "enableAirshipUsageOnGrant", "fallback", "Lcom/urbanairship/permission/PermissionPromptFallback;", "setPermissionDelegate", "delegate", "suspendingCheckPermissionStatus", "(Lcom/urbanairship/permission/Permission;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendingRequestPermission", "(Lcom/urbanairship/permission/Permission;ZLcom/urbanairship/permission/PermissionPromptFallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePermissionStatus", "status", "waitForResume", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPermissionsManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionsManager.kt\ncom/urbanairship/permission/PermissionsManager\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 5 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 6 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,411:1\n214#2,3:412\n217#2,2:416\n1#3:415\n53#4:418\n55#4:422\n50#5:419\n55#5:421\n106#6:420\n*S KotlinDebug\n*F\n+ 1 PermissionsManager.kt\ncom/urbanairship/permission/PermissionsManager\n*L\n84#1:412,3\n84#1:416,2\n182#1:418\n182#1:422\n182#1:419\n182#1:421\n182#1:420\n*E\n"})
/* loaded from: classes5.dex */
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

    /* renamed from: com.urbanairship.permission.PermissionsManager$suspendingRequestPermission$1, reason: invalid class name and case insensitive filesystem */
    static final class C12741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12741(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PermissionsManager.this.suspendingRequestPermission(null, false, null, this);
        }
    }

    /* renamed from: com.urbanairship.permission.PermissionsManager$waitForResume$1, reason: invalid class name and case insensitive filesystem */
    static final class C12751 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12751(Continuation continuation) {
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
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
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

    /* renamed from: com.urbanairship.permission.PermissionsManager$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PermissionsManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* renamed from: com.urbanairship.permission.PermissionsManager$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01551 implements FlowCollector {
            final /* synthetic */ PermissionsManager this$0;

            C01551(PermissionsManager permissionsManager) {
                this.this$0 = permissionsManager;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(android.app.Activity r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.urbanairship.permission.PermissionsManager$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    com.urbanairship.permission.PermissionsManager$1$1$emit$1 r0 = (com.urbanairship.permission.PermissionsManager$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    com.urbanairship.permission.PermissionsManager$1$1$emit$1 r0 = new com.urbanairship.permission.PermissionsManager$1$1$emit$1
                    r0.<init>(r5, r7)
                L18:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L39
                    if (r2 != r3) goto L31
                    java.lang.Object r5 = r0.L$1
                    java.util.Iterator r5 = (java.util.Iterator) r5
                    java.lang.Object r6 = r0.L$0
                    com.urbanairship.permission.PermissionsManager r6 = (com.urbanairship.permission.PermissionsManager) r6
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L57
                L31:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L39:
                    kotlin.ResultKt.throwOnFailure(r7)
                    java.lang.Class r6 = r6.getClass()
                    java.lang.Class<com.urbanairship.permission.PermissionsActivity> r7 = com.urbanairship.permission.PermissionsActivity.class
                    boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
                    if (r6 != 0) goto L70
                    com.urbanairship.permission.PermissionsManager r6 = r5.this$0
                    java.util.Set r6 = r6.getConfiguredPermissions()
                    com.urbanairship.permission.PermissionsManager r5 = r5.this$0
                    java.util.Iterator r6 = r6.iterator()
                    r4 = r6
                    r6 = r5
                    r5 = r4
                L57:
                    boolean r7 = r5.hasNext()
                    if (r7 == 0) goto L70
                    java.lang.Object r7 = r5.next()
                    com.urbanairship.permission.Permission r7 = (com.urbanairship.permission.Permission) r7
                    r0.L$0 = r6
                    r0.L$1 = r5
                    r0.label = r3
                    java.lang.Object r7 = r6.suspendingCheckPermissionStatus(r7, r0)
                    if (r7 != r1) goto L57
                    return r1
                L70:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.permission.PermissionsManager.AnonymousClass1.C01551.emit(android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
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
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            C01551 c01551 = new C01551(PermissionsManager.this);
            this.label = 2;
            if (((Flow) obj).collect(c01551, this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.permission.PermissionsManager$checkPermissionStatus$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        final /* synthetic */ Permission $permission;
        Object L$0;
        int label;
        final /* synthetic */ PermissionsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PendingResult pendingResult, PermissionsManager permissionsManager, Permission permission, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = permissionsManager;
            this.$permission = permission;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$pendingResult, this.this$0, this.$permission, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.permissionsScope, null, null, new AnonymousClass2(pendingResult, this, permission, null), 3, null);
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
                Object objCollect = mutableStateFlow.collect(new AnonymousClass2(flowCollector, permission), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PermissionsManager.kt\ncom/urbanairship/permission/PermissionsManager\n*L\n1#1,222:1\n54#2:223\n182#3:224\n*E\n"})
            /* renamed from: com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Permission $permission$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1$2", f = "PermissionsManager.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, Permission permission) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$permission$inlined = permission;
                }

                /* JADX WARN: Multi-variable type inference failed */
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
                        boolean r0 = r6 instanceof com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1$2$1 r0 = (com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1$2$1 r0 = new com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.util.Map r5 = (java.util.Map) r5
                        com.urbanairship.permission.Permission r4 = r4.$permission$inlined
                        java.lang.Object r4 = r5.get(r4)
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.permission.PermissionsManager$permissionsUpdate$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
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

    /* renamed from: com.urbanairship.permission.PermissionsManager$requestPermission$1, reason: invalid class name and case insensitive filesystem */
    static final class C12721 extends SuspendLambda implements Function2 {
        final /* synthetic */ boolean $enableAirshipUsageOnGrant;
        final /* synthetic */ Permission $permission;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12721(Permission permission, boolean z, Continuation continuation) {
            super(2, continuation);
            this.$permission = permission;
            this.$enableAirshipUsageOnGrant = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PermissionsManager.this.new C12721(this.$permission, this.$enableAirshipUsageOnGrant, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.permissionsScope, null, null, new C12721(permission, enableAirshipUsageOnGrant, null), 3, null);
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

    /* renamed from: com.urbanairship.permission.PermissionsManager$requestPermission$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        final /* synthetic */ boolean $enableAirshipUsageOnGrant;
        final /* synthetic */ PermissionPromptFallback $fallback;
        final /* synthetic */ PendingResult $pendingResult;
        final /* synthetic */ Permission $permission;
        Object L$0;
        int label;
        final /* synthetic */ PermissionsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PendingResult pendingResult, PermissionsManager permissionsManager, Permission permission, boolean z, PermissionPromptFallback permissionPromptFallback, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = permissionsManager;
            this.$permission = permission;
            this.$enableAirshipUsageOnGrant = z;
            this.$fallback = permissionPromptFallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.$pendingResult, this.this$0, this.$permission, this.$enableAirshipUsageOnGrant, this.$fallback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.permissionsScope, null, null, new AnonymousClass3(pendingResult, this, permission, enableAirshipUsageOnGrant, fallback, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0114 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object suspendingRequestPermission(@org.jetbrains.annotations.NotNull com.urbanairship.permission.Permission r10, boolean r11, @org.jetbrains.annotations.NotNull com.urbanairship.permission.PermissionPromptFallback r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.permission.PermissionRequestResult> r13) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.permission.PermissionsManager.suspendingRequestPermission(com.urbanairship.permission.Permission, boolean, com.urbanairship.permission.PermissionPromptFallback, kotlin.coroutines.Continuation):java.lang.Object");
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

    /* renamed from: com.urbanairship.permission.PermissionsManager$suspendingCheckPermissionStatus$2, reason: invalid class name and case insensitive filesystem */
    static final class C12732 extends SuspendLambda implements Function2 {
        final /* synthetic */ Permission $permission;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12732(Permission permission, Continuation continuation) {
            super(2, continuation);
            this.$permission = permission;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PermissionsManager.this.new C12732(this.$permission, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12732) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r6.L$0
                kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
                kotlin.ResultKt.throwOnFailure(r7)
                goto L7f
            L17:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L4c
            L23:
                kotlin.ResultKt.throwOnFailure(r7)
                com.urbanairship.permission.PermissionsManager r7 = com.urbanairship.permission.PermissionsManager.this
                com.urbanairship.permission.Permission r1 = r6.$permission
                com.urbanairship.permission.PermissionDelegate r7 = com.urbanairship.permission.PermissionsManager.access$getDelegate(r7, r1)
                if (r7 != 0) goto L33
                com.urbanairship.permission.PermissionStatus r6 = com.urbanairship.permission.PermissionStatus.NOT_DETERMINED
                return r6
            L33:
                com.urbanairship.permission.PermissionsManager r1 = com.urbanairship.permission.PermissionsManager.this
                java.util.Map r1 = com.urbanairship.permission.PermissionsManager.access$getPendingCheckResults$p(r1)
                com.urbanairship.permission.Permission r5 = r6.$permission
                java.lang.Object r1 = r1.get(r5)
                kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
                if (r1 == 0) goto L4d
                r6.label = r4
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.first(r1, r6)
                if (r7 != r0) goto L4c
                return r0
            L4c:
                return r7
            L4d:
                com.urbanairship.permission.PermissionsManager$suspendingCheckPermissionStatus$2$1 r1 = new com.urbanairship.permission.PermissionsManager$suspendingCheckPermissionStatus$2$1
                com.urbanairship.permission.Permission r5 = r6.$permission
                r1.<init>()
                com.urbanairship.UALog.d$default(r3, r1, r4, r3)
                com.urbanairship.permission.PermissionsManager r1 = com.urbanairship.permission.PermissionsManager.this
                android.content.Context r1 = com.urbanairship.permission.PermissionsManager.access$getContext$p(r1)
                com.urbanairship.permission.PermissionsManager r5 = com.urbanairship.permission.PermissionsManager.this
                kotlinx.coroutines.CoroutineScope r5 = com.urbanairship.permission.PermissionsManager.access$getPermissionsScope$p(r5)
                kotlinx.coroutines.flow.Flow r7 = com.urbanairship.permission.PermissionsManagerKt.access$checkPermissionFlow(r7, r1, r5)
                com.urbanairship.permission.PermissionsManager r1 = com.urbanairship.permission.PermissionsManager.this
                java.util.Map r1 = com.urbanairship.permission.PermissionsManager.access$getPendingCheckResults$p(r1)
                com.urbanairship.permission.Permission r5 = r6.$permission
                r1.put(r5, r7)
                r6.L$0 = r7
                r6.label = r2
                java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.first(r7, r6)
                if (r1 != r0) goto L7d
                return r0
            L7d:
                r0 = r7
                r7 = r1
            L7f:
                com.urbanairship.permission.PermissionStatus r7 = (com.urbanairship.permission.PermissionStatus) r7
                com.urbanairship.permission.PermissionsManager r1 = com.urbanairship.permission.PermissionsManager.this
                com.urbanairship.permission.Permission r2 = r6.$permission
                com.urbanairship.permission.PermissionsManager.access$updatePermissionStatus(r1, r2, r7)
                com.urbanairship.permission.PermissionsManager r1 = com.urbanairship.permission.PermissionsManager.this
                java.util.Map r1 = com.urbanairship.permission.PermissionsManager.access$getPendingCheckResults$p(r1)
                com.urbanairship.permission.Permission r2 = r6.$permission
                java.lang.Object r1 = r1.get(r2)
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
                if (r0 == 0) goto La5
                com.urbanairship.permission.PermissionsManager r0 = com.urbanairship.permission.PermissionsManager.this
                java.util.Map r0 = com.urbanairship.permission.PermissionsManager.access$getPendingCheckResults$p(r0)
                com.urbanairship.permission.Permission r1 = r6.$permission
                r0.remove(r1)
            La5:
                com.urbanairship.permission.PermissionsManager$suspendingCheckPermissionStatus$2$2 r0 = new com.urbanairship.permission.PermissionsManager$suspendingCheckPermissionStatus$2$2
                com.urbanairship.permission.Permission r6 = r6.$permission
                r0.<init>()
                com.urbanairship.UALog.d$default(r3, r0, r4, r3)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.permission.PermissionsManager.C12732.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Nullable
    public final Object suspendingCheckPermissionStatus(@NotNull Permission permission, @NotNull Continuation<? super PermissionStatus> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new C12732(permission, null), continuation);
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
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object waitForResume(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.urbanairship.permission.PermissionsManager.C12751
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.permission.PermissionsManager$waitForResume$1 r0 = (com.urbanairship.permission.PermissionsManager.C12751) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.permission.PermissionsManager$waitForResume$1 r0 = new com.urbanairship.permission.PermissionsManager$waitForResume$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L51
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.app.ActivityMonitor r5 = r5.activityMonitor
            r0.label = r4
            java.lang.Object r6 = com.urbanairship.permission.PermissionsManagerKt.access$resumedActivities(r5, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.first(r6, r0)
            if (r5 != r1) goto L51
            return r1
        L51:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.permission.PermissionsManager.waitForResume(kotlin.coroutines.Continuation):java.lang.Object");
    }
}

package com.urbanairship.android.framework.proxy;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Autopilot;
import com.urbanairship.Predicate;
import com.urbanairship.UAirship;
import com.urbanairship.android.framework.proxy.events.EventEmitter;
import com.urbanairship.android.framework.proxy.events.NotificationStatusEvent;
import com.urbanairship.android.framework.proxy.events.PendingEmbeddedUpdated;
import com.urbanairship.android.framework.proxy.proxies.AirshipProxy;
import com.urbanairship.embedded.AirshipEmbeddedInfo;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.permission.Permission;
import com.urbanairship.permission.PermissionStatus;
import com.urbanairship.preferencecenter.PreferenceCenter;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushManagerExtensions;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.PushNotificationStatus;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H$R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/android/framework/proxy/BaseAutopilot;", "Lcom/urbanairship/Autopilot;", "()V", "configOptions", "Lcom/urbanairship/AirshipConfigOptions;", "dispatcher", "Lkotlinx/coroutines/CoroutineScope;", "extenderProvider", "Lcom/urbanairship/android/framework/proxy/ExtenderProvider;", "firstReady", "", "createAirshipConfigOptions", "context", "Landroid/content/Context;", "createConfigBuilder", "Lcom/urbanairship/AirshipConfigOptions$Builder;", "isReady", "loadCustomNotificationButtonGroups", "", "airship", "Lcom/urbanairship/UAirship;", "loadCustomNotificationChannels", "onAirshipReady", "onMigrateData", "proxyStore", "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "onReady", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseAutopilot extends Autopilot {
    private AirshipConfigOptions configOptions;
    private boolean firstReady;
    private ExtenderProvider extenderProvider = new ExtenderProvider();
    private final CoroutineScope dispatcher = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    public abstract void onMigrateData(@NotNull Context context, @NotNull ProxyStore proxyStore);

    protected abstract void onReady(@NotNull Context context, @NotNull UAirship airship);

    @Override // com.urbanairship.Autopilot, com.urbanairship.UAirship.OnReadyCallback
    public final void onAirshipReady(@NotNull UAirship airship) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        super.onAirshipReady(airship);
        ProxyLogger.logLevel = airship.getAirshipConfigOptions().logLevel;
        final Context applicationContext = UAirship.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        AirshipProxy.Companion companion = AirshipProxy.INSTANCE;
        final ProxyStore proxyStore = companion.shared(applicationContext).getProxyStore();
        AirshipListener airshipListener = new AirshipListener(companion.shared(applicationContext).getProxyStore(), EventEmitter.INSTANCE.shared());
        PreferenceCenter.INSTANCE.shared().setOpenListener(airshipListener);
        MessageCenter.Companion companion2 = MessageCenter.INSTANCE;
        companion2.shared().setOnShowMessageCenterListener(airshipListener);
        companion2.shared().getInbox().addListener(airshipListener);
        airship.getChannel().addChannelListener(airshipListener);
        airship.getPushManager().addPushListener(airshipListener);
        airship.getPushManager().addPushTokenListener(airshipListener);
        airship.getPushManager().setNotificationListener(airshipListener);
        airship.setDeepLinkListener(airshipListener);
        BuildersKt__Builders_commonKt.launch$default(this.dispatcher, null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.dispatcher, null, null, new AnonymousClass2(airship, proxyStore, null), 3, null);
        AirshipConfigOptions airshipConfigOptions = airship.getAirshipConfigOptions();
        Intrinsics.checkNotNullExpressionValue(airshipConfigOptions, "getAirshipConfigOptions(...)");
        airship.getPushManager().setNotificationProvider(new BaseNotificationProvider(applicationContext, airshipConfigOptions));
        airship.getPushManager().setForegroundNotificationDisplayPredicate(new Predicate() { // from class: com.urbanairship.android.framework.proxy.BaseAutopilot$$ExternalSyntheticLambda0
            @Override // com.urbanairship.Predicate
            public final boolean apply(Object obj) {
                return BaseAutopilot.onAirshipReady$lambda$0(applicationContext, proxyStore, (PushMessage) obj);
            }
        });
        loadCustomNotificationChannels(applicationContext, airship);
        loadCustomNotificationButtonGroups(applicationContext, airship);
        onReady(applicationContext, airship);
        AirshipPluginExtender airshipPluginExtender = this.extenderProvider.get(applicationContext);
        if (airshipPluginExtender != null) {
            airshipPluginExtender.onAirshipReady(applicationContext, airship);
        }
        this.extenderProvider.reset();
    }

    /* renamed from: com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(continuation);
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
                StateFlow<List<AirshipEmbeddedInfo>> pending = PendingEmbedded.INSTANCE.getPending();
                C00891 c00891 = new FlowCollector() { // from class: com.urbanairship.android.framework.proxy.BaseAutopilot.onAirshipReady.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(List list, Continuation continuation) {
                        EventEmitter.INSTANCE.shared().addEvent(new PendingEmbeddedUpdated(list), true);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (pending.collect(c00891, this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ UAirship $airship;
        final /* synthetic */ ProxyStore $proxyStore;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(UAirship uAirship, ProxyStore proxyStore, Continuation continuation) {
            super(2, continuation);
            this.$airship = uAirship;
            this.$proxyStore = proxyStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$airship, this.$proxyStore, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PushManager pushManager = this.$airship.getPushManager();
                Intrinsics.checkNotNullExpressionValue(pushManager, "getPushManager(...)");
                final Flow flowCombine = FlowKt.combine(PushManagerExtensions.getPushNotificationStatusFlow(pushManager), this.$airship.getPermissionsManager().permissionsUpdate(Permission.DISPLAY_NOTIFICATIONS), new AnonymousClass1(null));
                final ProxyStore proxyStore = this.$proxyStore;
                Flow<NotificationStatus> flow = new Flow<NotificationStatus>() { // from class: com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$invokeSuspend$$inlined$filter$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BaseAutopilot.kt\ncom/urbanairship/android/framework/proxy/BaseAutopilot$onAirshipReady$2\n*L\n1#1,218:1\n18#2:219\n19#2:221\n82#3:220\n*E\n"})
                    /* renamed from: com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ ProxyStore $proxyStore$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$invokeSuspend$$inlined$filter$1$2", f = "BaseAutopilot.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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

                        public AnonymousClass2(FlowCollector flowCollector, ProxyStore proxyStore) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$proxyStore$inlined = proxyStore;
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
                                boolean r0 = r6 instanceof com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$invokeSuspend$$inlined$filter$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L4e
                            L29:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L31:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                r2 = r5
                                com.urbanairship.android.framework.proxy.NotificationStatus r2 = (com.urbanairship.android.framework.proxy.NotificationStatus) r2
                                com.urbanairship.android.framework.proxy.ProxyStore r4 = r4.$proxyStore$inlined
                                com.urbanairship.android.framework.proxy.NotificationStatus r4 = r4.getLastNotificationStatus()
                                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
                                if (r4 != 0) goto L4e
                                r0.label = r3
                                java.lang.Object r4 = r6.emit(r5, r0)
                                if (r4 != r1) goto L4e
                                return r1
                            L4e:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super NotificationStatus> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flowCombine.collect(new AnonymousClass2(flowCollector, proxyStore), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final ProxyStore proxyStore2 = this.$proxyStore;
                FlowCollector<? super NotificationStatus> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.framework.proxy.BaseAutopilot.onAirshipReady.2.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(NotificationStatus notificationStatus, Continuation continuation) {
                        proxyStore2.setLastNotificationStatus(notificationStatus);
                        EventEmitter.INSTANCE.shared().addEvent(new NotificationStatusEvent(notificationStatus), true);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
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

        /* renamed from: com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function3 {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(PushNotificationStatus pushNotificationStatus, PermissionStatus permissionStatus, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = pushNotificationStatus;
                anonymousClass1.L$1 = permissionStatus;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return new NotificationStatus((PushNotificationStatus) this.L$0, ((PermissionStatus) this.L$1).getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAirshipReady$lambda$0(Context context, ProxyStore proxyStore, PushMessage message) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(proxyStore, "$proxyStore");
        Intrinsics.checkNotNullParameter(message, "message");
        return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new BaseAutopilot$onAirshipReady$3$1(message, context, proxyStore, null), 1, null)).booleanValue();
    }

    private final void loadCustomNotificationChannels(Context context, UAirship airship) {
        int identifier = context.getResources().getIdentifier("ua_custom_notification_channels", "xml", UAirship.getPackageName());
        if (identifier != 0) {
            ProxyLogger.debug("Loading custom notification channels", new Object[0]);
            airship.getPushManager().getNotificationChannelRegistry().createNotificationChannels(identifier);
        }
    }

    private final void loadCustomNotificationButtonGroups(Context context, UAirship airship) {
        int identifier = context.getResources().getIdentifier("ua_custom_notification_buttons", "xml", UAirship.getPackageName());
        if (identifier != 0) {
            ProxyLogger.debug("Loading custom notification button groups", new Object[0]);
            airship.getPushManager().addNotificationActionButtonGroups(context, identifier);
        }
    }

    @Override // com.urbanairship.Autopilot
    public boolean isReady(@NotNull Context context) {
        AirshipConfigOptions.Builder builderExtendConfig;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.firstReady) {
            onMigrateData(context, AirshipProxy.INSTANCE.shared(context).getProxyStore());
            this.firstReady = true;
        }
        AirshipConfigOptions.Builder builderCreateConfigBuilder = createConfigBuilder(context);
        ProxyConfig airshipConfig = AirshipProxy.INSTANCE.shared(context).getProxyStore().getAirshipConfig();
        if (airshipConfig != null) {
            BaseAutopilotKt.applyProxyConfig(builderCreateConfigBuilder, context, airshipConfig);
        }
        AirshipPluginExtender airshipPluginExtender = this.extenderProvider.get(context);
        if (airshipPluginExtender != null && (builderExtendConfig = airshipPluginExtender.extendConfig(context, builderCreateConfigBuilder)) != null) {
            builderCreateConfigBuilder = builderExtendConfig;
        }
        AirshipConfigOptions airshipConfigOptionsBuild = builderCreateConfigBuilder.build();
        Intrinsics.checkNotNullExpressionValue(airshipConfigOptionsBuild, "build(...)");
        try {
            airshipConfigOptionsBuild.validate();
            this.configOptions = airshipConfigOptionsBuild;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @NotNull
    public AirshipConfigOptions.Builder createConfigBuilder(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AirshipConfigOptions.Builder builderNewBuilder = AirshipConfigOptions.newBuilder();
        try {
            builderNewBuilder.tryApplyDefaultProperties(context);
        } catch (Exception e) {
            ProxyLogger.verbose("Failed to load config from properties file: " + e.getMessage(), new Object[0]);
        }
        AirshipConfigOptions.Builder requireInitialRemoteConfigEnabled = builderNewBuilder.setRequireInitialRemoteConfigEnabled(true);
        Intrinsics.checkNotNullExpressionValue(requireInitialRemoteConfigEnabled, "setRequireInitialRemoteConfigEnabled(...)");
        return requireInitialRemoteConfigEnabled;
    }

    @Override // com.urbanairship.Autopilot
    @Nullable
    public AirshipConfigOptions createAirshipConfigOptions(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.configOptions;
    }
}

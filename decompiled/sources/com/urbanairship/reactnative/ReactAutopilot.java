package com.urbanairship.reactnative;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Extension;
import com.urbanairship.android.framework.proxy.BaseAutopilot;
import com.urbanairship.android.framework.proxy.Event;
import com.urbanairship.android.framework.proxy.ProxyLogger;
import com.urbanairship.android.framework.proxy.ProxyStore;
import com.urbanairship.android.framework.proxy.events.EventEmitter;
import com.urbanairship.embedded.AirshipEmbeddedInfo;
import com.urbanairship.embedded.AirshipEmbeddedObserver;
import com.urbanairship.reactnative.ReactAutopilot;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/reactnative/ReactAutopilot;", "Lcom/urbanairship/android/framework/proxy/BaseAutopilot;", "<init>", "()V", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "onReady", "", "context", "Landroid/content/Context;", "airship", "Lcom/urbanairship/UAirship;", "onMigrateData", "proxyStore", "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "createExtender", "Lcom/urbanairship/reactnative/AirshipExtender;", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactAutopilot extends BaseAutopilot {
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    @Override // com.urbanairship.android.framework.proxy.BaseAutopilot
    protected void onReady(@NotNull Context context, @NotNull UAirship airship) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(airship, "airship");
        ProxyLogger.info("Airship React Native version: %s, SDK version: %s", BuildConfig.AIRSHIP_MODULE_VERSION, UAirship.getVersion());
        boolean zIsHeadlessJSTaskEnabledOnStart = ManifestUtils.INSTANCE.isHeadlessJSTaskEnabledOnStart(context);
        ProxyLogger.debug("ALLOW_HEADLESS_JS_TASK_BEFORE_MODULE: " + zIsHeadlessJSTaskEnabledOnStart, new Object[0]);
        if (zIsHeadlessJSTaskEnabledOnStart) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(context, null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(null), 3, null);
        AirshipConfigOptions airshipConfigOptions = airship.getAirshipConfigOptions();
        Intrinsics.checkNotNullExpressionValue(airshipConfigOptions, "getAirshipConfigOptions(...)");
        airship.getPushManager().setNotificationProvider(new ReactNotificationProvider(context, airshipConfigOptions));
        airship.getAnalytics().registerSDKExtension(Extension.REACT_NATIVE, BuildConfig.AIRSHIP_MODULE_VERSION);
        AirshipExtender airshipExtenderCreateExtender = createExtender(context);
        if (airshipExtenderCreateExtender != null) {
            airshipExtenderCreateExtender.onAirshipReady(context, airship);
        }
    }

    /* renamed from: com.urbanairship.reactnative.ReactAutopilot$onReady$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, Continuation continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$context, continuation);
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
                final SharedFlow<Event> pendingEventListener = EventEmitter.INSTANCE.shared().getPendingEventListener();
                Flow<Event> flow = new Flow<Event>() { // from class: com.urbanairship.reactnative.ReactAutopilot$onReady$1$invokeSuspend$$inlined$filter$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 ReactAutopilot.kt\ncom/urbanairship/reactnative/ReactAutopilot$onReady$1\n*L\n1#1,218:1\n18#2:219\n19#2:221\n42#3:220\n*E\n"})
                    /* renamed from: com.urbanairship.reactnative.ReactAutopilot$onReady$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.reactnative.ReactAutopilot$onReady$1$invokeSuspend$$inlined$filter$1$2", f = "ReactAutopilot.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        /* renamed from: com.urbanairship.reactnative.ReactAutopilot$onReady$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.reactnative.ReactAutopilot$onReady$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.reactnative.ReactAutopilot$onReady$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.urbanairship.reactnative.ReactAutopilot$onReady$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.reactnative.ReactAutopilot$onReady$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.urbanairship.reactnative.ReactAutopilot$onReady$1$invokeSuspend$$inlined$filter$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L4c
                            L29:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L31:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                                r6 = r5
                                com.urbanairship.android.framework.proxy.Event r6 = (com.urbanairship.android.framework.proxy.Event) r6
                                com.urbanairship.android.framework.proxy.EventType r6 = r6.getType()
                                boolean r6 = com.urbanairship.reactnative.AirshipModuleKt.isForeground(r6)
                                if (r6 != 0) goto L4c
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L4c
                                return r1
                            L4c:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.reactnative.ReactAutopilot$onReady$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Event> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = pendingEventListener.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final Context context = this.$context;
                FlowCollector<? super Event> flowCollector = new FlowCollector() { // from class: com.urbanairship.reactnative.ReactAutopilot.onReady.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Event event, Continuation continuation) {
                        AirshipHeadlessEventService.INSTANCE.startService(context);
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
    }

    /* renamed from: com.urbanairship.reactnative.ReactAutopilot$onReady$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(AirshipEmbeddedInfo airshipEmbeddedInfo) {
            return true;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(continuation);
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
                Flow<List<AirshipEmbeddedInfo>> embeddedViewInfoFlow = new AirshipEmbeddedObserver((Function1<? super AirshipEmbeddedInfo, Boolean>) new Function1() { // from class: com.urbanairship.reactnative.ReactAutopilot$onReady$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(ReactAutopilot.AnonymousClass2.invokeSuspend$lambda$0((AirshipEmbeddedInfo) obj2));
                    }
                }).getEmbeddedViewInfoFlow();
                C01652 c01652 = new FlowCollector() { // from class: com.urbanairship.reactnative.ReactAutopilot.onReady.2.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(List list, Continuation continuation) {
                        EventEmitter.addEvent$default(EventEmitter.INSTANCE.shared(), new PendingEmbeddedUpdated(list), false, 2, null);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (embeddedViewInfoFlow.collect(c01652, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.android.framework.proxy.BaseAutopilot
    public void onMigrateData(@NotNull Context context, @NotNull ProxyStore proxyStore) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(proxyStore, "proxyStore");
        new DataMigrator(context).migrateData(proxyStore);
    }

    private final AirshipExtender createExtender(Context context) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        String strExtenderClassName = ManifestUtils.INSTANCE.extenderClassName(context);
        if (strExtenderClassName == null) {
            return null;
        }
        try {
            Object objNewInstance = Class.forName(strExtenderClassName).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.urbanairship.reactnative.AirshipExtender");
            return (AirshipExtender) objNewInstance;
        } catch (Exception e) {
            ProxyLogger.error(e, "Unable to create extender: " + strExtenderClassName, new Object[0]);
            return null;
        }
    }
}

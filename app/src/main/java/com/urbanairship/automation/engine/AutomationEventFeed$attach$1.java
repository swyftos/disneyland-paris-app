package com.urbanairship.automation.engine;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.analytics.AirshipEventFeed;
import com.urbanairship.automation.EventAutomationTriggerType;
import java.util.List;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
final class AutomationEventFeed$attach$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ AutomationEventFeed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationEventFeed$attach$1(AutomationEventFeed automationEventFeed, Continuation continuation) {
        super(2, continuation);
        this.this$0 = automationEventFeed;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AutomationEventFeed$attach$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AutomationEventFeed$attach$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00c3 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Flow flowMerge;
        C50585 c50585;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.hasAttachedBefore) {
                this.this$0.hasAttachedBefore = true;
                MutableSharedFlow mutableSharedFlow = this.this$0.stream;
                AutomationEvent.Event event = new AutomationEvent.Event(EventAutomationTriggerType.APP_INIT, null, AudioStats.AUDIO_AMPLITUDE_NONE, 6, null);
                this.label = 1;
                if (mutableSharedFlow.emit(event, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            final MutableStateFlow mutableStateFlow = this.this$0.appSessionState;
            Flow<List<? extends AutomationEvent.StateChanged>> flow = new Flow<List<? extends AutomationEvent.StateChanged>>() { // from class: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$1

                /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$1$2 */
                @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AutomationEventFeed.kt\ncom/urbanairship/automation/engine/AutomationEventFeed$attach$1\n*L\n1#1,218:1\n50#2:219\n118#3:220\n*E\n"})
                public static final class C50592<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @DebugMetadata(m1844c = "com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$1$2", m1845f = "AutomationEventFeed.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
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
                            return C50592.this.emit(null, this);
                        }
                    }

                    public C50592(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
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
                            List listListOf = CollectionsKt.listOf(new AutomationEvent.StateChanged((TriggerableState) obj));
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(listListOf, anonymousClass1) == coroutine_suspended) {
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

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super List<? extends AutomationEvent.StateChanged>> flowCollector, @NotNull Continuation continuation) {
                    Object objCollect = mutableStateFlow.collect(new C50592(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            final StateFlow<Boolean> foregroundState = this.this$0.activityMonitor.getForegroundState();
            Flow<List<? extends AutomationEvent.Event>> flow2 = new Flow<List<? extends AutomationEvent.Event>>() { // from class: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$2

                /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$2$2 */
                @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AutomationEventFeed.kt\ncom/urbanairship/automation/engine/AutomationEventFeed$attach$1\n*L\n1#1,218:1\n50#2:219\n121#3,6:220\n*E\n"})
                public static final class C50602<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$2$2$1, reason: invalid class name */
                    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @DebugMetadata(m1844c = "com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$2$2", m1845f = "AutomationEventFeed.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
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
                            return C50602.this.emit(null, this);
                        }
                    }

                    public C50602(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    public final Object emit(Object obj, @NotNull Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        AutomationEvent.Event event;
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
                            if (((Boolean) obj).booleanValue()) {
                                event = new AutomationEvent.Event(EventAutomationTriggerType.FOREGROUND, null, AudioStats.AUDIO_AMPLITUDE_NONE, 6, null);
                            } else {
                                event = new AutomationEvent.Event(EventAutomationTriggerType.BACKGROUND, null, AudioStats.AUDIO_AMPLITUDE_NONE, 6, null);
                            }
                            List listListOf = CollectionsKt.listOf(event);
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(listListOf, anonymousClass1) == coroutine_suspended) {
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

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super List<? extends AutomationEvent.Event>> flowCollector, @NotNull Continuation continuation) {
                    Object objCollect = foregroundState.collect(new C50602(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            final SharedFlow<AirshipEventFeed.Event> events = this.this$0.eventFeed.getEvents();
            flowMerge = FlowKt.merge(flow, flow2, new Flow<List<? extends AutomationEvent.Event>>() { // from class: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$3

                /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$3$2 */
                @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AutomationEventFeed.kt\ncom/urbanairship/automation/engine/AutomationEventFeed$attach$1\n*L\n1#1,218:1\n50#2:219\n130#3:220\n*E\n"})
                public static final class C50612<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$3$2$1, reason: invalid class name */
                    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @DebugMetadata(m1844c = "com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$3$2", m1845f = "AutomationEventFeed.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
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
                            return C50612.this.emit(null, this);
                        }
                    }

                    public C50612(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
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
                            List<AutomationEvent.Event> toAutomationEvents = AutomationEventFeedKt.getToAutomationEvents((AirshipEventFeed.Event) obj);
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(toAutomationEvents, anonymousClass1) == coroutine_suspended) {
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

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super List<? extends AutomationEvent.Event>> flowCollector, @NotNull Continuation continuation) {
                    Object objCollect = events.collect(new C50612(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            });
            c50585 = new C50585(this.this$0);
            this.label = 2;
            if (flowMerge.collect(c50585, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        if (this.this$0.applicationMetrics.getAppVersionUpdated()) {
            MutableStateFlow mutableStateFlow2 = this.this$0.appSessionState;
            AutomationEventFeed automationEventFeed = this.this$0;
            do {
                value = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value, TriggerableState.copy$default((TriggerableState) value, null, String.valueOf(automationEventFeed.applicationMetrics.getCurrentAppVersion()), 1, null)));
        }
        final Flow mutableStateFlow3 = this.this$0.appSessionState;
        Flow<List<? extends AutomationEvent.StateChanged>> flow3 = new Flow<List<? extends AutomationEvent.StateChanged>>() { // from class: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$1

            /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$1$2 */
            @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AutomationEventFeed.kt\ncom/urbanairship/automation/engine/AutomationEventFeed$attach$1\n*L\n1#1,218:1\n50#2:219\n118#3:220\n*E\n"})
            public static final class C50592<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @DebugMetadata(m1844c = "com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$1$2", m1845f = "AutomationEventFeed.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
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
                        return C50592.this.emit(null, this);
                    }
                }

                public C50592(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
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
                        List listListOf = CollectionsKt.listOf(new AutomationEvent.StateChanged((TriggerableState) obj));
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(listListOf, anonymousClass1) == coroutine_suspended) {
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

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends AutomationEvent.StateChanged>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = mutableStateFlow3.collect(new C50592(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow foregroundState2 = this.this$0.activityMonitor.getForegroundState();
        Flow<List<? extends AutomationEvent.Event>> flow4 = new Flow<List<? extends AutomationEvent.Event>>() { // from class: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$2

            /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$2$2 */
            @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AutomationEventFeed.kt\ncom/urbanairship/automation/engine/AutomationEventFeed$attach$1\n*L\n1#1,218:1\n50#2:219\n121#3,6:220\n*E\n"})
            public static final class C50602<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$2$2$1, reason: invalid class name */
                @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @DebugMetadata(m1844c = "com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$2$2", m1845f = "AutomationEventFeed.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
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
                        return C50602.this.emit(null, this);
                    }
                }

                public C50602(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0017  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    AutomationEvent.Event event;
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
                        if (((Boolean) obj).booleanValue()) {
                            event = new AutomationEvent.Event(EventAutomationTriggerType.FOREGROUND, null, AudioStats.AUDIO_AMPLITUDE_NONE, 6, null);
                        } else {
                            event = new AutomationEvent.Event(EventAutomationTriggerType.BACKGROUND, null, AudioStats.AUDIO_AMPLITUDE_NONE, 6, null);
                        }
                        List listListOf = CollectionsKt.listOf(event);
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(listListOf, anonymousClass1) == coroutine_suspended) {
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

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends AutomationEvent.Event>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = foregroundState2.collect(new C50602(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow events2 = this.this$0.eventFeed.getEvents();
        flowMerge = FlowKt.merge(flow3, flow4, new Flow<List<? extends AutomationEvent.Event>>() { // from class: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$3

            /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$3$2 */
            @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AutomationEventFeed.kt\ncom/urbanairship/automation/engine/AutomationEventFeed$attach$1\n*L\n1#1,218:1\n50#2:219\n130#3:220\n*E\n"})
            public static final class C50612<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$3$2$1, reason: invalid class name */
                @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @DebugMetadata(m1844c = "com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$3$2", m1845f = "AutomationEventFeed.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
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
                        return C50612.this.emit(null, this);
                    }
                }

                public C50612(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
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
                        List<AutomationEvent.Event> toAutomationEvents = AutomationEventFeedKt.getToAutomationEvents((AirshipEventFeed.Event) obj);
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(toAutomationEvents, anonymousClass1) == coroutine_suspended) {
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

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends AutomationEvent.Event>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = events2.collect(new C50612(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
        c50585 = new C50585(this.this$0);
        this.label = 2;
        if (flowMerge.collect(c50585, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5 */
    static final class C50585 implements FlowCollector {
        final /* synthetic */ AutomationEventFeed this$0;

        /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$WhenMappings */
        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[EventAutomationTriggerType.values().length];
                try {
                    iArr[EventAutomationTriggerType.FOREGROUND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EventAutomationTriggerType.BACKGROUND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        C50585(AutomationEventFeed automationEventFeed) {
            this.this$0 = automationEventFeed;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x004f  */
        /* JADX WARN: Code duplicated, block: B:21:0x0067 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x006c  */
        /* JADX WARN: Code duplicated, block: B:26:0x007e A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:28:0x0081  */
        /* JADX WARN: Code duplicated, block: B:32:0x0097  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:22:0x0068). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:32:0x0097
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final java.lang.Object emit(java.util.List r9, kotlin.coroutines.Continuation r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$emit$1
                if (r0 == 0) goto L13
                r0 = r10
                com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$emit$1 r0 = (com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$emit$1 r0 = new com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$emit$1
                r0.<init>(r8, r10)
            L18:
                java.lang.Object r10 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3d
                if (r2 != r3) goto L35
                java.lang.Object r8 = r0.L$2
                com.urbanairship.automation.engine.AutomationEvent r8 = (com.urbanairship.automation.engine.AutomationEvent) r8
                java.lang.Object r9 = r0.L$1
                java.util.Iterator r9 = (java.util.Iterator) r9
                java.lang.Object r2 = r0.L$0
                com.urbanairship.automation.engine.AutomationEventFeed r2 = (com.urbanairship.automation.engine.AutomationEventFeed) r2
                kotlin.ResultKt.throwOnFailure(r10)
                goto L68
            L35:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3d:
                kotlin.ResultKt.throwOnFailure(r10)
                if (r9 == 0) goto Lb5
                com.urbanairship.automation.engine.AutomationEventFeed r8 = r8.this$0
                java.util.Iterator r9 = r9.iterator()
                r2 = r8
            L49:
                boolean r8 = r9.hasNext()
                if (r8 == 0) goto Lb5
                java.lang.Object r8 = r9.next()
                com.urbanairship.automation.engine.AutomationEvent r8 = (com.urbanairship.automation.engine.AutomationEvent) r8
                kotlinx.coroutines.flow.MutableSharedFlow r10 = com.urbanairship.automation.engine.AutomationEventFeed.access$getStream$p(r2)
                r0.L$0 = r2
                r0.L$1 = r9
                r0.L$2 = r8
                r0.label = r3
                java.lang.Object r10 = r10.emit(r8, r0)
                if (r10 != r1) goto L68
                return r1
            L68:
                boolean r10 = r8 instanceof com.urbanairship.automation.engine.AutomationEvent.Event
                if (r10 == 0) goto L49
                com.urbanairship.automation.engine.AutomationEvent$Event r8 = (com.urbanairship.automation.engine.AutomationEvent.Event) r8
                com.urbanairship.automation.EventAutomationTriggerType r8 = r8.getTriggerType()
                int[] r10 = com.urbanairship.automation.engine.AutomationEventFeed$attach$1.C50585.WhenMappings.$EnumSwitchMapping$0
                int r8 = r8.ordinal()
                r8 = r10[r8]
                r10 = 2
                r4 = 0
                if (r8 == r3) goto L97
                if (r8 == r10) goto L81
                goto L49
            L81:
                kotlinx.coroutines.flow.MutableStateFlow r8 = com.urbanairship.automation.engine.AutomationEventFeed.access$getAppSessionState$p(r2)
            L85:
                java.lang.Object r5 = r8.getValue()
                r6 = r5
                com.urbanairship.automation.engine.TriggerableState r6 = (com.urbanairship.automation.engine.TriggerableState) r6
                com.urbanairship.automation.engine.TriggerableState r6 = com.urbanairship.automation.engine.TriggerableState.copy$default(r6, r4, r4, r10, r4)
                boolean r5 = r8.compareAndSet(r5, r6)
                if (r5 == 0) goto L85
                goto L49
            L97:
                kotlinx.coroutines.flow.MutableStateFlow r8 = com.urbanairship.automation.engine.AutomationEventFeed.access$getAppSessionState$p(r2)
            L9b:
                java.lang.Object r5 = r8.getValue()
                r6 = r5
                com.urbanairship.automation.engine.TriggerableState r6 = (com.urbanairship.automation.engine.TriggerableState) r6
                java.util.UUID r7 = java.util.UUID.randomUUID()
                java.lang.String r7 = r7.toString()
                com.urbanairship.automation.engine.TriggerableState r6 = com.urbanairship.automation.engine.TriggerableState.copy$default(r6, r7, r4, r10, r4)
                boolean r5 = r8.compareAndSet(r5, r6)
                if (r5 == 0) goto L9b
                goto L49
            Lb5:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEventFeed$attach$1.C50585.emit(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}

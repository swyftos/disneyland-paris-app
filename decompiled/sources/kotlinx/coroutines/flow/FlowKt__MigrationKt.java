package kotlinx.coroutines.flow;

import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlinx.coroutines.DelayKt;

/* loaded from: classes6.dex */
abstract /* synthetic */ class FlowKt__MigrationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onErrorReturn$lambda$0$FlowKt__MigrationKt(Throwable th) {
        return true;
    }

    public static final Void noImpl() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    public static final Flow observeOn(Flow flow, CoroutineContext coroutineContext) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow publishOn(Flow flow, CoroutineContext coroutineContext) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow subscribeOn(Flow flow, CoroutineContext coroutineContext) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow onErrorResume(Flow flow, Flow flow2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow onErrorResumeNext(Flow flow, Flow flow2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final void subscribe(Flow flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final void subscribe(Flow flow, Function2 function2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final void subscribe(Flow flow, Function2 function2, Function2 function22) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow flatMap(Flow flow, Function2 function2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow switchMap(Flow flow, Function2 function2) {
        return FlowKt.transformLatest(flow, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(function2, null));
    }

    public static final Flow concatMap(Flow flow, Function1 function1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow merge(Flow flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow flatten(Flow flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow compose(Flow flow, Function1 function1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow skip(Flow flow, int i) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final void forEach(Flow flow, Function2 function2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow scanFold(Flow flow, Object obj, Function3 function3) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow onErrorReturn(Flow flow, Object obj) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3 {
        final /* synthetic */ Object $fallback;
        final /* synthetic */ Function1 $predicate;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function1 function1, Object obj, Continuation continuation) {
            super(3, continuation);
            this.$predicate = function1;
            this.$fallback = obj;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector flowCollector, Throwable th, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$predicate, this.$fallback, continuation);
            anonymousClass2.L$0 = flowCollector;
            anonymousClass2.L$1 = th;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                if (!((Boolean) this.$predicate.invoke(th)).booleanValue()) {
                    throw th;
                }
                Object obj2 = this.$fallback;
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(obj2, this) == coroutine_suspended) {
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

    public static /* synthetic */ Flow onErrorReturn$default(Flow flow, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: kotlinx.coroutines.flow.FlowKt__MigrationKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return Boolean.valueOf(FlowKt__MigrationKt.onErrorReturn$lambda$0$FlowKt__MigrationKt((Throwable) obj3));
                }
            };
        }
        return FlowKt.onErrorReturn(flow, obj, function1);
    }

    public static final Flow onErrorReturn(Flow flow, Object obj, Function1 function1) {
        return FlowKt.m3656catch(flow, new AnonymousClass2(function1, obj, null));
    }

    public static final Flow startWith(Flow flow, Object obj) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow startWith(Flow flow, Flow flow2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow concatWith(Flow flow, Object obj) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow concatWith(Flow flow, Flow flow2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow combineLatest(Flow flow, Flow flow2, Function3 function3) {
        return FlowKt.combine(flow, flow2, function3);
    }

    public static final Flow combineLatest(Flow flow, Flow flow2, Flow flow3, Function4 function4) {
        return FlowKt.combine(flow, flow2, flow3, function4);
    }

    public static final Flow combineLatest(Flow flow, Flow flow2, Flow flow3, Flow flow4, Function5 function5) {
        return FlowKt.combine(flow, flow2, flow3, flow4, function5);
    }

    public static final Flow combineLatest(Flow flow, Flow flow2, Flow flow3, Flow flow4, Flow flow5, Function6 function6) {
        return FlowKt.combine(flow, flow2, flow3, flow4, flow5, function6);
    }

    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C15071 extends SuspendLambda implements Function2 {
        final /* synthetic */ long $timeMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15071(long j, Continuation continuation) {
            super(2, continuation);
            this.$timeMillis = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C15071(this.$timeMillis, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((C15071) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.$timeMillis;
                this.label = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
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

    public static final Flow delayFlow(Flow flow, long j) {
        return FlowKt.onStart(flow, new C15071(j, null));
    }

    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$delayEach$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ long $timeMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, Continuation continuation) {
            super(2, continuation);
            this.$timeMillis = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$timeMillis, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation continuation) {
            return ((AnonymousClass1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.$timeMillis;
                this.label = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
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

    public static final Flow delayEach(Flow flow, long j) {
        return FlowKt.onEach(flow, new AnonymousClass1(j, null));
    }

    public static final Flow scanReduce(Flow flow, Function3 function3) {
        return FlowKt.runningReduce(flow, function3);
    }

    public static final Flow publish(Flow flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow publish(Flow flow, int i) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow replay(Flow flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow replay(Flow flow, int i) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Flow cache(Flow flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }
}

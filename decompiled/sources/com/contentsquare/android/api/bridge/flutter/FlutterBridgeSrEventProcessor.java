package com.contentsquare.android.api.bridge.flutter;

import androidx.annotation.WorkerThread;
import ch.qos.logback.core.joran.action.Action;
import com.contentsquare.android.api.model.SrWrappedProtoEvent;
import com.contentsquare.android.sdk.C5;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/contentsquare/android/api/bridge/flutter/FlutterBridgeSrEventProcessor;", "", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "debounceJob", "Lkotlinx/coroutines/Job;", "debounceAction", "", Action.SCOPE_ATTRIBUTE, "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "processProtoEvents", "protoEvents", "", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event;", "flutterSrEventListener", "Lcom/contentsquare/android/api/bridge/flutter/FlutterSrEventListener;", "Companion", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlutterBridgeSrEventProcessor {
    private static final long INTERVAL_MILLI_SEC = 100;

    @NotNull
    private final CoroutineScope coroutineScope = CoroutineScopeKt.MainScope();

    @Nullable
    private Job debounceJob;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.contentsquare.android.api.bridge.flutter.FlutterBridgeSrEventProcessor$debounceAction$1", f = "FlutterBridgeSrEventProcessor.kt", i = {}, l = {35, 36}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.api.bridge.flutter.FlutterBridgeSrEventProcessor$debounceAction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$action = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$action, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
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
            Function1<Continuation<? super Unit>, Object> function1 = this.$action;
            this.label = 2;
            if (function1.invoke(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.contentsquare.android.api.bridge.flutter.FlutterBridgeSrEventProcessor$processProtoEvents$1", f = "FlutterBridgeSrEventProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.api.bridge.flutter.FlutterBridgeSrEventProcessor$processProtoEvents$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06161 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FlutterSrEventListener $flutterSrEventListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06161(FlutterSrEventListener flutterSrEventListener, Continuation<? super C06161> continuation) {
            super(1, continuation);
            this.$flutterSrEventListener = flutterSrEventListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new C06161(this.$flutterSrEventListener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$flutterSrEventListener.onFlutterSrEvent();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((C06161) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private final void debounceAction(CoroutineScope scope, Function1<? super Continuation<? super Unit>, ? extends Object> action) {
        Job job = this.debounceJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.debounceJob = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(action, null), 3, null);
    }

    @WorkerThread
    public final void processProtoEvents(@NotNull List<SessionRecordingV1.Event> protoEvents, @NotNull FlutterSrEventListener flutterSrEventListener) {
        Intrinsics.checkNotNullParameter(protoEvents, "protoEvents");
        Intrinsics.checkNotNullParameter(flutterSrEventListener, "flutterSrEventListener");
        C5 c5 = C5.k;
        if (c5 == null || protoEvents.isEmpty()) {
            return;
        }
        Iterator<SessionRecordingV1.Event> it = protoEvents.iterator();
        while (it.hasNext()) {
            SrWrappedProtoEvent event = new SrWrappedProtoEvent(it.next());
            Intrinsics.checkNotNullParameter(event, "event");
            c5.f.a(event);
        }
        FlutterInterface.setsIsFirstFlutterEventAdded(true);
        debounceAction(this.coroutineScope, new C06161(flutterSrEventListener, null));
    }
}

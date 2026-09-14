package com.urbanairship.actions;

import androidx.annotation.RestrictTo;
import com.urbanairship.json.JsonSerializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000b\u001a>\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0087@¢\u0006\u0002\u0010\u0010\u001a>\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0087@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m1836d2 = {"run", "", "Lcom/urbanairship/actions/ActionRunner;", "actions", "", "", "Lcom/urbanairship/json/JsonSerializable;", "situation", "", "extender", "Lcom/urbanairship/actions/ActionRunRequestExtender;", "(Lcom/urbanairship/actions/ActionRunner;Ljava/util/Map;Ljava/lang/Integer;Lcom/urbanairship/actions/ActionRunRequestExtender;)V", "runSuspending", "Lcom/urbanairship/actions/ActionResult;", "name", "value", "(Lcom/urbanairship/actions/ActionRunner;Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;Ljava/lang/Integer;Lcom/urbanairship/actions/ActionRunRequestExtender;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/urbanairship/actions/ActionRunner;Ljava/util/Map;Ljava/lang/Integer;Lcom/urbanairship/actions/ActionRunRequestExtender;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, m1837k = 2, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nActionRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionRunner.kt\ncom/urbanairship/actions/ActionRunnerKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,97:1\n314#2,11:98\n215#3,2:109\n215#3,2:111\n*S KotlinDebug\n*F\n+ 1 ActionRunner.kt\ncom/urbanairship/actions/ActionRunnerKt\n*L\n69#1:98,11\n83#1:109,2\n93#1:111,2\n*E\n"})
public final class ActionRunnerKt {

    /* JADX INFO: renamed from: com.urbanairship.actions.ActionRunnerKt$runSuspending$3 */
    static final class C46573 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C46573(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActionRunnerKt.runSuspending(null, null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final Object runSuspending(@NotNull ActionRunner actionRunner, @NotNull Map<String, ? extends JsonSerializable> map, @Nullable Integer num, @Nullable ActionRunRequestExtender actionRunRequestExtender, @NotNull Continuation<? super Unit> continuation) {
        C46573 c46573;
        ActionRunner actionRunner2;
        Iterator<Map.Entry<String, ? extends JsonSerializable>> it;
        if (continuation instanceof C46573) {
            c46573 = (C46573) continuation;
            int i = c46573.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c46573.label = i - Integer.MIN_VALUE;
            } else {
                c46573 = new C46573(continuation);
            }
        } else {
            c46573 = new C46573(continuation);
        }
        Object obj = c46573.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c46573.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Iterator<Map.Entry<String, ? extends JsonSerializable>> it2 = map.entrySet().iterator();
            actionRunner2 = actionRunner;
            it = it2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) c46573.L$3;
            ActionRunRequestExtender actionRunRequestExtender2 = (ActionRunRequestExtender) c46573.L$2;
            num = (Integer) c46573.L$1;
            ActionRunner actionRunner3 = (ActionRunner) c46573.L$0;
            ResultKt.throwOnFailure(obj);
            actionRunRequestExtender = actionRunRequestExtender2;
            actionRunner2 = actionRunner3;
        }
        while (it.hasNext()) {
            Map.Entry<String, ? extends JsonSerializable> next = it.next();
            String key = next.getKey();
            JsonSerializable value = next.getValue();
            c46573.L$0 = actionRunner2;
            c46573.L$1 = num;
            c46573.L$2 = actionRunRequestExtender;
            c46573.L$3 = it;
            c46573.label = 1;
            if (runSuspending(actionRunner2, key, value, num, actionRunRequestExtender, c46573) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object runSuspending$default(ActionRunner actionRunner, Map map, Integer num, ActionRunRequestExtender actionRunRequestExtender, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            actionRunRequestExtender = null;
        }
        return runSuspending(actionRunner, map, num, actionRunRequestExtender, continuation);
    }

    public static /* synthetic */ void run$default(ActionRunner actionRunner, Map map, Integer num, ActionRunRequestExtender actionRunRequestExtender, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            actionRunRequestExtender = null;
        }
        run(actionRunner, map, num, actionRunRequestExtender);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final Object runSuspending(@NotNull ActionRunner actionRunner, @NotNull String str, @Nullable JsonSerializable jsonSerializable, @Nullable Integer num, @Nullable ActionRunRequestExtender actionRunRequestExtender, @NotNull Continuation<? super ActionResult> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        actionRunner.run(str, jsonSerializable, num, actionRunRequestExtender, new ActionCompletionCallback() { // from class: com.urbanairship.actions.ActionRunnerKt$runSuspending$2$1
            @Override // com.urbanairship.actions.ActionCompletionCallback
            public final void onFinish(ActionArguments actionArguments, ActionResult result) {
                Intrinsics.checkNotNullParameter(actionArguments, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(result, "result");
                cancellableContinuationImpl.resumeWith(Result.m5277constructorimpl(result));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final void run(@NotNull ActionRunner actionRunner, @NotNull Map<String, ? extends JsonSerializable> actions, @Nullable Integer num, @Nullable ActionRunRequestExtender actionRunRequestExtender) {
        Intrinsics.checkNotNullParameter(actionRunner, "<this>");
        Intrinsics.checkNotNullParameter(actions, "actions");
        for (Map.Entry<String, ? extends JsonSerializable> entry : actions.entrySet()) {
            ActionRunner.run$default(actionRunner, entry.getKey(), entry.getValue(), num, actionRunRequestExtender, null, 16, null);
        }
    }
}

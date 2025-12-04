package com.urbanairship.actions;

import androidx.annotation.RestrictTo;
import com.urbanairship.json.JsonSerializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000b\u001a>\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0087@¢\u0006\u0002\u0010\u0010\u001a>\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0087@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"run", "", "Lcom/urbanairship/actions/ActionRunner;", "actions", "", "", "Lcom/urbanairship/json/JsonSerializable;", "situation", "", "extender", "Lcom/urbanairship/actions/ActionRunRequestExtender;", "(Lcom/urbanairship/actions/ActionRunner;Ljava/util/Map;Ljava/lang/Integer;Lcom/urbanairship/actions/ActionRunRequestExtender;)V", "runSuspending", "Lcom/urbanairship/actions/ActionResult;", "name", "value", "(Lcom/urbanairship/actions/ActionRunner;Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;Ljava/lang/Integer;Lcom/urbanairship/actions/ActionRunRequestExtender;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/urbanairship/actions/ActionRunner;Ljava/util/Map;Ljava/lang/Integer;Lcom/urbanairship/actions/ActionRunRequestExtender;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nActionRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionRunner.kt\ncom/urbanairship/actions/ActionRunnerKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,97:1\n314#2,11:98\n215#3,2:109\n215#3,2:111\n*S KotlinDebug\n*F\n+ 1 ActionRunner.kt\ncom/urbanairship/actions/ActionRunnerKt\n*L\n69#1:98,11\n83#1:109,2\n93#1:111,2\n*E\n"})
/* loaded from: classes4.dex */
public final class ActionRunnerKt {

    /* renamed from: com.urbanairship.actions.ActionRunnerKt$runSuspending$3, reason: invalid class name */
    static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActionRunnerKt.runSuspending(null, null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object runSuspending(@org.jetbrains.annotations.NotNull com.urbanairship.actions.ActionRunner r11, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, ? extends com.urbanairship.json.JsonSerializable> r12, @org.jetbrains.annotations.Nullable java.lang.Integer r13, @org.jetbrains.annotations.Nullable com.urbanairship.actions.ActionRunRequestExtender r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            boolean r0 = r15 instanceof com.urbanairship.actions.ActionRunnerKt.AnonymousClass3
            if (r0 == 0) goto L13
            r0 = r15
            com.urbanairship.actions.ActionRunnerKt$runSuspending$3 r0 = (com.urbanairship.actions.ActionRunnerKt.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.actions.ActionRunnerKt$runSuspending$3 r0 = new com.urbanairship.actions.ActionRunnerKt$runSuspending$3
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r11 = r0.L$3
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r0.L$2
            com.urbanairship.actions.ActionRunRequestExtender r12 = (com.urbanairship.actions.ActionRunRequestExtender) r12
            java.lang.Object r13 = r0.L$1
            java.lang.Integer r13 = (java.lang.Integer) r13
            java.lang.Object r14 = r0.L$0
            com.urbanairship.actions.ActionRunner r14 = (com.urbanairship.actions.ActionRunner) r14
            kotlin.ResultKt.throwOnFailure(r15)
            r10 = r14
            r14 = r12
            r12 = r10
            goto L52
        L3c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L44:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
            r10 = r12
            r12 = r11
            r11 = r10
        L52:
            boolean r15 = r11.hasNext()
            if (r15 == 0) goto L81
            java.lang.Object r15 = r11.next()
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15
            java.lang.Object r2 = r15.getKey()
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r15 = r15.getValue()
            r6 = r15
            com.urbanairship.json.JsonSerializable r6 = (com.urbanairship.json.JsonSerializable) r6
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.L$3 = r11
            r0.label = r3
            r4 = r12
            r7 = r13
            r8 = r14
            r9 = r0
            java.lang.Object r15 = runSuspending(r4, r5, r6, r7, r8, r9)
            if (r15 != r1) goto L52
            return r1
        L81:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.actions.ActionRunnerKt.runSuspending(com.urbanairship.actions.ActionRunner, java.util.Map, java.lang.Integer, com.urbanairship.actions.ActionRunRequestExtender, kotlin.coroutines.Continuation):java.lang.Object");
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
                cancellableContinuationImpl.resumeWith(Result.m2968constructorimpl(result));
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

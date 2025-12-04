package com.urbanairship.automation.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/automation/utils/ScheduleConditionsChangedNotifier;", "", "()V", "waitingList", "", "Lkotlin/coroutines/Continuation;", "", "notifyChanged", "notifyChanged$urbanairship_automation_release", "wait", "wait$urbanairship_automation_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nScheduleConditionsChangedNotifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleConditionsChangedNotifier.kt\ncom/urbanairship/automation/utils/ScheduleConditionsChangedNotifier\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,25:1\n1855#2,2:26\n1#3:28\n*S KotlinDebug\n*F\n+ 1 ScheduleConditionsChangedNotifier.kt\ncom/urbanairship/automation/utils/ScheduleConditionsChangedNotifier\n*L\n14#1:26,2\n*E\n"})
/* loaded from: classes5.dex */
public final class ScheduleConditionsChangedNotifier {
    private final List waitingList = new ArrayList();

    public final void notifyChanged$urbanairship_automation_release() {
        synchronized (this.waitingList) {
            try {
                for (Continuation continuation : this.waitingList) {
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m2968constructorimpl(Unit.INSTANCE));
                }
                this.waitingList.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final Object wait$urbanairship_automation_release(@NotNull Continuation<? super Unit> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        synchronized (this.waitingList) {
            this.waitingList.add(safeContinuation);
            Unit unit = Unit.INSTANCE;
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }
}

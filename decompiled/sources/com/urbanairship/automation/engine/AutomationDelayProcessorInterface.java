package com.urbanairship.automation.engine;

import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import com.urbanairship.automation.AutomationDelay;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J \u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationDelayProcessorInterface;", "", "areConditionsMet", "", "delay", "Lcom/urbanairship/automation/AutomationDelay;", "preprocess", "", "triggerDate", "", "(Lcom/urbanairship/automation/AutomationDelay;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "process", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface AutomationDelayProcessorInterface {
    @MainThread
    boolean areConditionsMet(@Nullable AutomationDelay delay);

    @Nullable
    Object preprocess(@Nullable AutomationDelay automationDelay, long j, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object process(@Nullable AutomationDelay automationDelay, long j, @NotNull Continuation<? super Unit> continuation);
}

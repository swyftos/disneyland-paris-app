package com.urbanairship.automation.engine;

import com.urbanairship.automation.engine.triggerprocessor.TriggerData;
import com.urbanairship.json.JsonException;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H¦@¢\u0006\u0002\u0010\bJ\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH¦@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH¦@¢\u0006\u0002\u0010\u000bJ \u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\nH¦@¢\u0006\u0002\u0010\u000b¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/urbanairship/automation/engine/TriggerStoreInterface;", "", "deleteTriggers", "", "scheduleID", "", "triggerIDs", "", "(Ljava/lang/String;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleIDs", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTriggersExcluding", "getTrigger", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "triggerID", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertTriggers", "triggers", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface TriggerStoreInterface {
    @Nullable
    Object deleteTriggers(@NotNull String str, @NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object deleteTriggers(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object deleteTriggersExcluding(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object getTrigger(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super TriggerData> continuation) throws JsonException;

    @Nullable
    Object upsertTriggers(@NotNull List<TriggerData> list, @NotNull Continuation<? super Unit> continuation);
}

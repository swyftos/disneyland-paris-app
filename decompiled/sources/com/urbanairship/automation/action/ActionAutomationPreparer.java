package com.urbanairship.automation.action;

import com.urbanairship.automation.engine.AutomationPreparerDelegate;
import com.urbanairship.automation.engine.PreparedScheduleInfo;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/automation/action/ActionAutomationPreparer;", "Lcom/urbanairship/automation/engine/AutomationPreparerDelegate;", "Lcom/urbanairship/json/JsonValue;", "()V", "cancelled", "", "scheduleID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepare", "Lkotlin/Result;", "data", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "prepare-0E7RQCE", "(Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActionAutomationPreparer implements AutomationPreparerDelegate<JsonValue, JsonValue> {
    @Override // com.urbanairship.automation.engine.AutomationPreparerDelegate
    @Nullable
    /* renamed from: prepare-0E7RQCE, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public Object mo2791prepare0E7RQCE(@NotNull JsonValue jsonValue, @NotNull PreparedScheduleInfo preparedScheduleInfo, @NotNull Continuation<? super Result<? extends JsonValue>> continuation) {
        return Result.m2968constructorimpl(jsonValue);
    }

    @Override // com.urbanairship.automation.engine.AutomationPreparerDelegate
    @Nullable
    public Object cancelled(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}

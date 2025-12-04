package com.urbanairship.iam.analytics;

import com.urbanairship.channel.AttributeMutation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistoryStoreInterface;", "", "get", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory;", "scheduleID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AttributeMutation.ATTRIBUTE_ACTION_SET, "", "history", "(Lcom/urbanairship/iam/analytics/MessageDisplayHistory;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MessageDisplayHistoryStoreInterface {
    @Nullable
    Object get(@NotNull String str, @NotNull Continuation<? super MessageDisplayHistory> continuation);

    @Nullable
    Object set(@NotNull MessageDisplayHistory messageDisplayHistory, @NotNull String str, @NotNull Continuation<? super Unit> continuation);
}

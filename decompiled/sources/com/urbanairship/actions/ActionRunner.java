package com.urbanairship.actions;

import com.urbanairship.json.JsonSerializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/actions/ActionRunner;", "", "run", "", "name", "", "value", "Lcom/urbanairship/json/JsonSerializable;", "situation", "", "extender", "Lcom/urbanairship/actions/ActionRunRequestExtender;", "callback", "Lcom/urbanairship/actions/ActionCompletionCallback;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;Ljava/lang/Integer;Lcom/urbanairship/actions/ActionRunRequestExtender;Lcom/urbanairship/actions/ActionCompletionCallback;)V", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ActionRunner {
    void run(@NotNull String name, @Nullable JsonSerializable value, @Nullable Integer situation, @Nullable ActionRunRequestExtender extender, @Nullable ActionCompletionCallback callback);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void run$default(ActionRunner actionRunner, String str, JsonSerializable jsonSerializable, Integer num, ActionRunRequestExtender actionRunRequestExtender, ActionCompletionCallback actionCompletionCallback, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: run");
        }
        actionRunner.run(str, jsonSerializable, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : actionRunRequestExtender, (i & 16) != 0 ? null : actionCompletionCallback);
    }
}

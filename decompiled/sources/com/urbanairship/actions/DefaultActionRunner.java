package com.urbanairship.actions;

import com.urbanairship.json.JsonSerializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/actions/DefaultActionRunner;", "Lcom/urbanairship/actions/ActionRunner;", "()V", "run", "", "name", "", "value", "Lcom/urbanairship/json/JsonSerializable;", "situation", "", "extender", "Lcom/urbanairship/actions/ActionRunRequestExtender;", "callback", "Lcom/urbanairship/actions/ActionCompletionCallback;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;Ljava/lang/Integer;Lcom/urbanairship/actions/ActionRunRequestExtender;Lcom/urbanairship/actions/ActionCompletionCallback;)V", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultActionRunner implements ActionRunner {

    @NotNull
    public static final DefaultActionRunner INSTANCE = new DefaultActionRunner();

    private DefaultActionRunner() {
    }

    @Override // com.urbanairship.actions.ActionRunner
    public void run(@NotNull String name, @Nullable JsonSerializable value, @Nullable Integer situation, @Nullable ActionRunRequestExtender extender, @Nullable ActionCompletionCallback callback) {
        ActionRunRequest actionRunRequestExtend;
        Intrinsics.checkNotNullParameter(name, "name");
        ActionRunRequest value2 = ActionRunRequest.createRequest(name).setValue(value);
        if (situation != null) {
            value2.setSituation(situation.intValue());
        }
        if (extender != null && (actionRunRequestExtend = extender.extend(value2)) != null) {
            value2 = actionRunRequestExtend;
        }
        value2.run(callback);
    }
}

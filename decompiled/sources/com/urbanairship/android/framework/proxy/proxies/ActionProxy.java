package com.urbanairship.android.framework.proxy.proxies;

import com.urbanairship.actions.ActionResult;
import com.urbanairship.actions.ActionRunner;
import com.urbanairship.actions.ActionRunnerKt;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/ActionProxy;", "", "actionRunner", "Lkotlin/Function0;", "Lcom/urbanairship/actions/ActionRunner;", "(Lkotlin/jvm/functions/Function0;)V", "runAction", "Lcom/urbanairship/actions/ActionResult;", "name", "", "value", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ActionProxy {
    private final Function0 actionRunner;

    public ActionProxy(@NotNull Function0<? extends ActionRunner> actionRunner) {
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        this.actionRunner = actionRunner;
    }

    @Nullable
    public final Object runAction(@NotNull String str, @Nullable JsonValue jsonValue, @NotNull Continuation<? super ActionResult> continuation) {
        return ActionRunnerKt.runSuspending((ActionRunner) this.actionRunner.invoke(), str, (12 & 2) != 0 ? null : jsonValue, (12 & 4) != 0 ? null : null, (12 & 8) != 0 ? null : null, continuation);
    }
}

package com.urbanairship.preferencecenter;

import com.urbanairship.actions.Action;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionResult;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.AirshipComponentUtils;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/preferencecenter/OpenPreferenceCenterAction;", "Lcom/urbanairship/actions/Action;", "preferenceCenterCallable", "Ljava/util/concurrent/Callable;", "Lcom/urbanairship/preferencecenter/PreferenceCenter;", "(Ljava/util/concurrent/Callable;)V", "acceptsArguments", "", "arguments", "Lcom/urbanairship/actions/ActionArguments;", "perform", "Lcom/urbanairship/actions/ActionResult;", "shouldRunOnMainThread", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OpenPreferenceCenterAction extends Action {
    private final Callable preferenceCenterCallable;

    public OpenPreferenceCenterAction() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.urbanairship.actions.Action
    public boolean shouldRunOnMainThread() {
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OpenPreferenceCenterAction(Callable callable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            callable = AirshipComponentUtils.callableForComponent(PreferenceCenter.class);
            Intrinsics.checkNotNullExpressionValue(callable, "callableForComponent(...)");
        }
        this(callable);
    }

    public OpenPreferenceCenterAction(@NotNull Callable<PreferenceCenter> preferenceCenterCallable) {
        Intrinsics.checkNotNullParameter(preferenceCenterCallable, "preferenceCenterCallable");
        this.preferenceCenterCallable = preferenceCenterCallable;
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NotNull ActionArguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        switch (arguments.getSituation()) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 6:
                return true;
            case 1:
            case 5:
            default:
                return false;
        }
    }

    @Override // com.urbanairship.actions.Action
    @NotNull
    public ActionResult perform(@NotNull ActionArguments arguments) {
        JsonValue jsonValueOpt;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        JsonMap map = arguments.getValue().getMap();
        String string = (map == null || (jsonValueOpt = map.opt("preference_center_id")) == null) ? null : jsonValueOpt.getString();
        if (string == null) {
            ActionResult actionResultNewErrorResult = ActionResult.newErrorResult(new IllegalArgumentException("Failed to perform OpenPreferenceCenterAction! Required argument 'preference_center_id' is null."));
            Intrinsics.checkNotNull(actionResultNewErrorResult);
            return actionResultNewErrorResult;
        }
        ((PreferenceCenter) this.preferenceCenterCallable.call()).open(string);
        ActionResult actionResultNewEmptyResult = ActionResult.newEmptyResult();
        Intrinsics.checkNotNull(actionResultNewEmptyResult);
        return actionResultNewEmptyResult;
    }
}

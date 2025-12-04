package com.urbanairship.messagecenter.actions;

import androidx.annotation.VisibleForTesting;
import com.urbanairship.actions.Action;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionResult;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.AirshipComponentUtils;
import com.urbanairship.util.UAStringUtil;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\b\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/messagecenter/actions/MessageCenterAction;", "Lcom/urbanairship/actions/Action;", "()V", "messageCenterCallable", "Ljava/util/concurrent/Callable;", "Lcom/urbanairship/messagecenter/MessageCenter;", "(Ljava/util/concurrent/Callable;)V", "acceptsArguments", "", "arguments", "Lcom/urbanairship/actions/ActionArguments;", "perform", "Lcom/urbanairship/actions/ActionResult;", "shouldRunOnMainThread", "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class MessageCenterAction extends Action {

    @NotNull
    public static final String DEFAULT_REGISTRY_NAME = "open_mc_action";

    @NotNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^mc";

    @NotNull
    public static final String MESSAGE_ID_PLACEHOLDER = "auto";
    private final Callable messageCenterCallable;

    @Override // com.urbanairship.actions.Action
    public boolean shouldRunOnMainThread() {
        return true;
    }

    @VisibleForTesting
    public MessageCenterAction(@NotNull Callable<MessageCenter> messageCenterCallable) {
        Intrinsics.checkNotNullParameter(messageCenterCallable, "messageCenterCallable");
        this.messageCenterCallable = messageCenterCallable;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MessageCenterAction() {
        Callable callableCallableForComponent = AirshipComponentUtils.callableForComponent(MessageCenter.class);
        Intrinsics.checkNotNullExpressionValue(callableCallableForComponent, "callableForComponent(...)");
        this(callableCallableForComponent);
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
    public ActionResult perform(@NotNull ActionArguments arguments) throws Exception {
        String string;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        try {
            Object objCall = this.messageCenterCallable.call();
            Intrinsics.checkNotNull(objCall);
            MessageCenter messageCenter = (MessageCenter) objCall;
            String string2 = arguments.getValue().getString();
            if (StringsKt.equals("auto", string2, true)) {
                PushMessage pushMessage = (PushMessage) arguments.getMetadata().getParcelable(ActionArguments.PUSH_MESSAGE_METADATA);
                if (pushMessage != null && pushMessage.getRichPushMessageId() != null) {
                    string = pushMessage.getRichPushMessageId();
                } else if (arguments.getMetadata().containsKey(ActionArguments.RICH_PUSH_ID_METADATA)) {
                    string = arguments.getMetadata().getString(ActionArguments.RICH_PUSH_ID_METADATA);
                } else {
                    string2 = null;
                }
                string2 = string;
            }
            if (UAStringUtil.isEmpty(string2)) {
                MessageCenter.showMessageCenter$default(messageCenter, null, 1, null);
            } else {
                messageCenter.showMessageCenter(string2);
            }
            ActionResult actionResultNewEmptyResult = ActionResult.newEmptyResult();
            Intrinsics.checkNotNullExpressionValue(actionResultNewEmptyResult, "newEmptyResult(...)");
            return actionResultNewEmptyResult;
        } catch (Exception e) {
            ActionResult actionResultNewErrorResult = ActionResult.newErrorResult(e);
            Intrinsics.checkNotNullExpressionValue(actionResultNewErrorResult, "newErrorResult(...)");
            return actionResultNewErrorResult;
        }
    }
}

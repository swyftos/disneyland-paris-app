package com.urbanairship.messagecenter.ui;

import com.urbanairship.UALog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0005"}, d2 = {"logNullListenerWarning", "", "interfaceName", "", "propertyName", "urbanairship-message-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageListFragmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void logNullListenerWarning(final String str, final String str2) {
        UALog.w$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageListFragmentKt.logNullListenerWarning.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "MessageListFragment." + str + " is not set! Implement " + str + " or set MessageListFragment." + str2 + " to handle message list events.";
            }
        }, 1, null);
    }
}

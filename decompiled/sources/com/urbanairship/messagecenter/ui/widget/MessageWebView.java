package com.urbanairship.messagecenter.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.urbanairship.UALog;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.messagecenter.User;
import com.urbanairship.webkit.NestedScrollAirshipWebView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageWebView;", "Lcom/urbanairship/webkit/NestedScrollAirshipWebView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "defResStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "loadMessage", "", "message", "Lcom/urbanairship/messagecenter/Message;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class MessageWebView extends NestedScrollAirshipWebView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageWebView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageWebView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageWebView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MessageWebView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageWebView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void loadMessage(@NotNull final Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageWebView.loadMessage.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Loading message: " + message.getId();
            }
        }, 1, null);
        User user = MessageCenter.INSTANCE.shared().getUser();
        HashMap map = new HashMap();
        Pair pair = TuplesKt.to(user.getId(), user.getPassword());
        String str = (String) pair.component1();
        String str2 = (String) pair.component2();
        if (str != null && str2 != null) {
            setClientAuthRequest(message.getBodyUrl(), str, str2);
            String strCreateBasicAuth = createBasicAuth(str, str2);
            Intrinsics.checkNotNullExpressionValue(strCreateBasicAuth, "createBasicAuth(...)");
            map.put("Authorization", strCreateBasicAuth);
        }
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageWebView.loadMessage.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Load URL: " + message.getBodyUrl();
            }
        }, 1, null);
        String bodyUrl = message.getBodyUrl();
        InstrumentationCallbacks.loadUrlCalled(this);
        loadUrl(bodyUrl, map);
    }
}

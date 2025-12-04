package com.urbanairship.messagecenter.ui.widget;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionRunRequest;
import com.urbanairship.javascript.JavaScriptEnvironment;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.messagecenter.Inbox;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.webkit.AirshipWebViewClient;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0015J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageWebViewClient;", "Lcom/urbanairship/webkit/AirshipWebViewClient;", "()V", "extendActionRequest", "Lcom/urbanairship/actions/ActionRunRequest;", "request", "webView", "Landroid/webkit/WebView;", "extendJavascriptEnvironment", "Lcom/urbanairship/javascript/JavaScriptEnvironment$Builder;", "builder", "getMessage", "Lcom/urbanairship/messagecenter/Message;", "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageWebView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageWebView.kt\ncom/urbanairship/messagecenter/ui/widget/MessageWebViewClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,113:1\n1#2:114\n*E\n"})
/* loaded from: classes5.dex */
public class MessageWebViewClient extends AirshipWebViewClient {
    private static final Companion Companion = new Companion(null);
    private static final SimpleDateFormat DATE_FORMATTER;

    @Override // com.urbanairship.webkit.AirshipWebViewClient
    @NotNull
    protected ActionRunRequest extendActionRequest(@NotNull ActionRunRequest request, @NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Bundle bundle = new Bundle();
        Message message = getMessage(webView);
        if (message != null) {
            bundle.putString(ActionArguments.RICH_PUSH_ID_METADATA, message.getId());
        }
        request.setMetadata(bundle);
        return request;
    }

    @Override // com.urbanairship.webkit.AirshipWebViewClient
    @CallSuper
    @NotNull
    protected JavaScriptEnvironment.Builder extendJavascriptEnvironment(@NotNull JavaScriptEnvironment.Builder builder, @NotNull WebView webView) {
        JsonMap jsonMapOptMap;
        Date sentDate;
        Date sentDate2;
        Map<String, String> extras;
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Message message = getMessage(webView);
        if (message == null || (extras = message.getExtras()) == null || (jsonMapOptMap = JsonValue.wrapOpt(extras).optMap()) == null) {
            jsonMapOptMap = JsonMap.EMPTY_MAP;
        }
        Intrinsics.checkNotNull(jsonMapOptMap);
        JavaScriptEnvironment.Builder builderAddGetter = super.extendJavascriptEnvironment(builder, webView).addGetter("getMessageSentDateMS", (message == null || (sentDate = message.getSentDate()) == null) ? -1L : sentDate.getTime()).addGetter("getMessageId", message != null ? message.getId() : null).addGetter("getMessageTitle", message != null ? message.getTitle() : null).addGetter("getMessageSentDate", (message == null || (sentDate2 = message.getSentDate()) == null) ? null : DATE_FORMATTER.format(sentDate2)).addGetter("getUserId", MessageCenter.INSTANCE.shared().getUser().getId()).addGetter("getMessageExtras", jsonMapOptMap);
        Intrinsics.checkNotNullExpressionValue(builderAddGetter, "addGetter(...)");
        return builderAddGetter;
    }

    /* renamed from: com.urbanairship.messagecenter.ui.widget.MessageWebViewClient$getMessage$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ WebView $webView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WebView webView, Continuation continuation) {
            super(2, continuation);
            this.$webView = webView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$webView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String url = this.$webView.getUrl();
                Inbox inbox = MessageCenter.INSTANCE.shared().getInbox();
                this.label = 1;
                obj = inbox.getMessageByUrl(url, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    private final Message getMessage(WebView webView) {
        return (Message) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(webView, null), 1, null);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        DATE_FORMATTER = simpleDateFormat;
    }
}

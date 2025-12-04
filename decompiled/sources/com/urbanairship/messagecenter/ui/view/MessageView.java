package com.urbanairship.messagecenter.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.dlp.BluetoothManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UALog;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.R;
import com.urbanairship.messagecenter.ui.view.MessageView;
import com.urbanairship.messagecenter.ui.view.MessageViewState;
import com.urbanairship.messagecenter.ui.widget.MessageWebView;
import com.urbanairship.messagecenter.ui.widget.MessageWebViewClient;
import com.urbanairship.messagecenter.util.ContextExtensionsKt;
import com.urbanairship.webkit.AirshipWebChromeClient;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002,-B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020!J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0007J\u000e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020!J\u000e\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020(R\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "defResStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Ljava/lang/Integer;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/messagecenter/ui/view/MessageView$Listener;", "getListener", "()Lcom/urbanairship/messagecenter/ui/view/MessageView$Listener;", "setListener", "(Lcom/urbanairship/messagecenter/ui/view/MessageView$Listener;)V", "message", "Lcom/urbanairship/messagecenter/Message;", "showEmptyView", "", "getShowEmptyView", "()Z", "setShowEmptyView", "(Z)V", "views", "Lcom/urbanairship/messagecenter/ui/view/MessageView$Views;", "getViews", "()Lcom/urbanairship/messagecenter/ui/view/MessageView$Views;", "views$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "pauseWebView", "render", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/messagecenter/ui/view/MessageViewState;", "restoreWebViewState", "inState", "Landroid/os/Bundle;", "resumeWebView", "saveWebViewState", "outState", "Listener", "Views", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageView extends FrameLayout {
    private Integer error;
    private Listener listener;
    private Message message;
    private boolean showEmptyView;

    /* renamed from: views$delegate, reason: from kotlin metadata */
    private final Lazy views;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageView$Listener;", "", "onMessageLoadError", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/urbanairship/messagecenter/ui/view/MessageViewState$Error$Type;", "onMessageLoaded", "message", "Lcom/urbanairship/messagecenter/Message;", "onRetryClicked", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onMessageLoadError(@NotNull MessageViewState.Error.Type error);

        void onMessageLoaded(@NotNull Message message);

        void onRetryClicked();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MessageView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.views = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageView$views$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MessageView.Views invoke() {
                final MessageView messageView = this.this$0;
                return new MessageView.Views(messageView, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageView$views$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(messageView.getShowEmptyView());
                    }
                }, null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
            }
        });
        View.inflate(context, R.layout.ua_view_message, this);
        onViewCreated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Views getViews() {
        return (Views) this.views.getValue();
    }

    @Nullable
    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener(@Nullable Listener listener) {
        this.listener = listener;
    }

    public final boolean getShowEmptyView() {
        return this.showEmptyView;
    }

    public final void setShowEmptyView(boolean z) {
        this.showEmptyView = z;
    }

    private final void onViewCreated() {
        MessageWebView webView = getViews().getWebView();
        webView.setWebViewClient(new MessageWebViewClient() { // from class: com.urbanairship.messagecenter.ui.view.MessageView$onViewCreated$1$1
            @Override // com.urbanairship.webkit.AirshipWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(@Nullable WebView view, @Nullable final String url) {
                InstrumentationCallbacks.onPageFinishedCalled(this, view, url);
                super.onPageFinished(view, url);
                if (this.this$0.error == null) {
                    Message message = this.this$0.message;
                    if (message != null) {
                        MessageView messageView = this.this$0;
                        UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageView$onViewCreated$1$1$onPageFinished$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Mark read and show message! " + url;
                            }
                        }, 1, null);
                        messageView.getViews().showMessage();
                        MessageView.Listener listener = messageView.getListener();
                        if (listener != null) {
                            listener.onMessageLoaded(message);
                            return;
                        }
                        return;
                    }
                    return;
                }
                UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageView$onViewCreated$1$1$onPageFinished$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Showing error! " + url;
                    }
                }, 1, null);
                MessageView.Views views = this.this$0.getViews();
                MessageViewState.Error.Type type = MessageViewState.Error.Type.LOAD_FAILED;
                views.showError(type);
                MessageView.Listener listener2 = this.this$0.getListener();
                if (listener2 != null) {
                    listener2.onMessageLoadError(type);
                }
            }

            @Override // android.webkit.WebViewClient
            @Deprecated(message = "Deprecated in Java")
            public void onReceivedError(@NotNull WebView view, final int errorCode, @NotNull final String description, @Nullable final String failingUrl) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(description, "description");
                UALog.w$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageView$onViewCreated$1$1$onReceivedError$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onReceivedError! " + errorCode + ' ' + description + ' ' + failingUrl;
                    }
                }, 1, null);
                if (this.this$0.message == null || failingUrl == null) {
                    return;
                }
                Message message = this.this$0.message;
                if (Intrinsics.areEqual(failingUrl, message != null ? message.getBodyUrl() : null)) {
                    this.this$0.error = Integer.valueOf(errorCode);
                }
            }
        });
        webView.getSettings().setSupportMultipleWindows(true);
        Context context = webView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        webView.setWebChromeClient(new AirshipWebChromeClient(ContextExtensionsKt.getActivity(context)));
        InstrumentationCallbacks.setOnClickListenerCalled(getViews().getErrorRetryButton(), new View.OnClickListener() { // from class: com.urbanairship.messagecenter.ui.view.MessageView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageView.onViewCreated$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(MessageView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Listener listener = this$0.listener;
        if (listener != null) {
            listener.onRetryClicked();
        }
    }

    @MainThread
    public final void render(@NotNull MessageViewState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof MessageViewState.Content) {
            MessageViewState.Content content = (MessageViewState.Content) state;
            if (!Intrinsics.areEqual(this.message, content.getMessage())) {
                this.message = content.getMessage();
                getViews().getWebView().loadMessage(content.getMessage());
                return;
            } else {
                UALog.v("Message already displayed: " + content.getMessage().getId(), new Object[0]);
                return;
            }
        }
        if (state instanceof MessageViewState.Empty) {
            this.message = null;
            getViews().showEmpty();
        } else if (state instanceof MessageViewState.Error) {
            this.message = null;
            getViews().showError(((MessageViewState.Error) state).getError());
        } else if (state instanceof MessageViewState.Loading) {
            this.message = null;
            getViews().showProgress();
        }
    }

    public final void pauseWebView() {
        MessageWebView webView = getViews().getWebView();
        webView.onPause();
        webView.pauseTimers();
    }

    public final void resumeWebView() {
        MessageWebView webView = getViews().getWebView();
        webView.onResume();
        webView.resumeTimers();
    }

    public final void saveWebViewState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        getViews().getWebView().saveState(outState);
    }

    public final void restoreWebViewState(@NotNull Bundle inState) {
        Intrinsics.checkNotNullParameter(inState, "inState");
        getViews().getWebView().restoreState(inState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Views {
        private final TextView emptyMessage;
        private final View emptyPage;
        private final TextView errorMessage;
        private final View errorPage;
        private final View errorRetryButton;
        private final View progressBar;
        private final View root;
        private final Function0 shouldShowEmptyView;
        private final MessageWebView webView;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MessageViewState.Error.Type.values().length];
                try {
                    iArr[MessageViewState.Error.Type.UNAVAILABLE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MessageViewState.Error.Type.LOAD_FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Views)) {
                return false;
            }
            Views views = (Views) obj;
            return Intrinsics.areEqual(this.root, views.root) && Intrinsics.areEqual(this.shouldShowEmptyView, views.shouldShowEmptyView) && Intrinsics.areEqual(this.webView, views.webView) && Intrinsics.areEqual(this.progressBar, views.progressBar) && Intrinsics.areEqual(this.errorPage, views.errorPage) && Intrinsics.areEqual(this.errorMessage, views.errorMessage) && Intrinsics.areEqual(this.errorRetryButton, views.errorRetryButton) && Intrinsics.areEqual(this.emptyPage, views.emptyPage) && Intrinsics.areEqual(this.emptyMessage, views.emptyMessage);
        }

        public int hashCode() {
            return (((((((((((((((this.root.hashCode() * 31) + this.shouldShowEmptyView.hashCode()) * 31) + this.webView.hashCode()) * 31) + this.progressBar.hashCode()) * 31) + this.errorPage.hashCode()) * 31) + this.errorMessage.hashCode()) * 31) + this.errorRetryButton.hashCode()) * 31) + this.emptyPage.hashCode()) * 31) + this.emptyMessage.hashCode();
        }

        public String toString() {
            return "Views(root=" + this.root + ", shouldShowEmptyView=" + this.shouldShowEmptyView + ", webView=" + this.webView + ", progressBar=" + this.progressBar + ", errorPage=" + this.errorPage + ", errorMessage=" + this.errorMessage + ", errorRetryButton=" + this.errorRetryButton + ", emptyPage=" + this.emptyPage + ", emptyMessage=" + this.emptyMessage + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Views(View root, Function0 shouldShowEmptyView, MessageWebView webView, View progressBar, View errorPage, TextView errorMessage, View errorRetryButton, View emptyPage, TextView emptyMessage) {
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(shouldShowEmptyView, "shouldShowEmptyView");
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(progressBar, "progressBar");
            Intrinsics.checkNotNullParameter(errorPage, "errorPage");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            Intrinsics.checkNotNullParameter(errorRetryButton, "errorRetryButton");
            Intrinsics.checkNotNullParameter(emptyPage, "emptyPage");
            Intrinsics.checkNotNullParameter(emptyMessage, "emptyMessage");
            this.root = root;
            this.shouldShowEmptyView = shouldShowEmptyView;
            this.webView = webView;
            this.progressBar = progressBar;
            this.errorPage = errorPage;
            this.errorMessage = errorMessage;
            this.errorRetryButton = errorRetryButton;
            this.emptyPage = emptyPage;
            this.emptyMessage = emptyMessage;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Views(View view, Function0 function0, MessageWebView messageWebView, View view2, View view3, TextView textView, View view4, View view5, TextView textView2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            MessageWebView messageWebView2;
            View view6;
            View view7;
            TextView textView3;
            View view8;
            View view9;
            TextView textView4;
            if ((i & 4) != 0) {
                View viewFindViewById = view.findViewById(R.id.message);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                messageWebView2 = (MessageWebView) viewFindViewById;
            } else {
                messageWebView2 = messageWebView;
            }
            if ((i & 8) != 0) {
                View viewFindViewById2 = view.findViewById(R.id.progress);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                view6 = viewFindViewById2;
            } else {
                view6 = view2;
            }
            if ((i & 16) != 0) {
                View viewFindViewById3 = view.findViewById(R.id.error);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                view7 = viewFindViewById3;
            } else {
                view7 = view3;
            }
            if ((i & 32) != 0) {
                View viewFindViewById4 = view.findViewById(R.id.error_text);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                textView3 = (TextView) viewFindViewById4;
            } else {
                textView3 = textView;
            }
            if ((i & 64) != 0) {
                View viewFindViewById5 = view.findViewById(R.id.error_button);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                view8 = viewFindViewById5;
            } else {
                view8 = view4;
            }
            if ((i & 128) != 0) {
                View viewFindViewById6 = view.findViewById(R.id.empty);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
                view9 = viewFindViewById6;
            } else {
                view9 = view5;
            }
            if ((i & 256) != 0) {
                View viewFindViewById7 = view.findViewById(R.id.empty_message);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
                textView4 = (TextView) viewFindViewById7;
            } else {
                textView4 = textView2;
            }
            this(view, function0, messageWebView2, view6, view7, textView3, view8, view9, textView4);
        }

        public final MessageWebView getWebView() {
            return this.webView;
        }

        public final View getErrorRetryButton() {
            return this.errorRetryButton;
        }

        public final void showProgress() {
            this.progressBar.setVisibility(0);
            this.errorPage.setVisibility(8);
            this.webView.setVisibility(8);
            this.emptyPage.setVisibility(8);
        }

        public final void showMessage() {
            this.webView.setVisibility(0);
            this.progressBar.setVisibility(8);
            this.errorPage.setVisibility(8);
            this.emptyPage.setVisibility(8);
        }

        public final void showEmpty() {
            this.emptyPage.setVisibility(0);
            this.errorPage.setVisibility(8);
            this.webView.setVisibility(8);
            this.progressBar.setVisibility(8);
        }

        public final void showError(MessageViewState.Error.Type error) {
            Intrinsics.checkNotNullParameter(error, "error");
            int i = WhenMappings.$EnumSwitchMapping$0[error.ordinal()];
            if (i == 1) {
                this.errorRetryButton.setVisibility(8);
                this.errorMessage.setText(com.urbanairship.R.string.ua_mc_no_longer_available);
            } else if (i == 2) {
                this.errorRetryButton.setVisibility(0);
                this.errorMessage.setText(com.urbanairship.R.string.ua_mc_failed_to_load);
            }
            this.errorPage.setVisibility(0);
            this.webView.setVisibility(8);
            this.progressBar.setVisibility(8);
            this.emptyPage.setVisibility(8);
        }
    }
}

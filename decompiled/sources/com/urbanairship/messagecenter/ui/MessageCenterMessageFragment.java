package com.urbanairship.messagecenter.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UALog;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.R;
import com.urbanairship.messagecenter.ui.view.MessageViewState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 62\u00020\u0001:\u000267B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0014J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-H\u0014J\u001a\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u00101\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u00010\u000eJ\u0010\u00103\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u001dH\u0004J\u0012\u00104\u001a\u00020(2\b\b\u0002\u00105\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00068"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageCenterMessageFragment;", "Lcom/urbanairship/messagecenter/ui/MessageFragment;", "contentLayoutId", "", "(I)V", "collapseToolbar", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "value", "", "isToolbarNavIconVisible", "()Z", "setToolbarNavIconVisible", "(Z)V", "messageTitle", "", "getMessageTitle", "()Ljava/lang/String;", "messageTitle$delegate", "Lkotlin/Lazy;", "onMessageDeletedListener", "Lcom/urbanairship/messagecenter/ui/MessageCenterMessageFragment$OnMessageDeletedListener;", "getOnMessageDeletedListener", "()Lcom/urbanairship/messagecenter/ui/MessageCenterMessageFragment$OnMessageDeletedListener;", "setOnMessageDeletedListener", "(Lcom/urbanairship/messagecenter/ui/MessageCenterMessageFragment$OnMessageDeletedListener;)V", "showNavIcon", "getShowNavIcon", "()Ljava/lang/Boolean;", "showNavIcon$delegate", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "onGetLayoutInflater", "Landroid/view/LayoutInflater;", "savedInstanceState", "Landroid/os/Bundle;", "onMessageLoadError", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/urbanairship/messagecenter/ui/view/MessageViewState$Error$Type;", "onMessageLoaded", "message", "Lcom/urbanairship/messagecenter/Message;", "onViewCreated", "view", "Landroid/view/View;", "setToolbarTitle", "title", "setupToolbar", "updateToolbarNavIcon", "isVisible", "Companion", "OnMessageDeletedListener", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageCenterMessageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageCenterMessageFragment.kt\ncom/urbanairship/messagecenter/ui/MessageCenterMessageFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n1#2:168\n*E\n"})
/* loaded from: classes5.dex */
public class MessageCenterMessageFragment extends MessageFragment {

    @NotNull
    public static final String ARG_MESSAGE_ID = "message_id";

    @NotNull
    public static final String ARG_MESSAGE_TITLE = "message_title";

    @NotNull
    public static final String ARG_SHOW_NAV_ICON = "show_nav_icon";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private CollapsingToolbarLayout collapseToolbar;
    private boolean isToolbarNavIconVisible;

    /* renamed from: messageTitle$delegate, reason: from kotlin metadata */
    private final Lazy messageTitle;
    private OnMessageDeletedListener onMessageDeletedListener;

    /* renamed from: showNavIcon$delegate, reason: from kotlin metadata */
    private final Lazy showNavIcon;
    private Toolbar toolbar;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageCenterMessageFragment$OnMessageDeletedListener;", "", "onDeleteMessage", "", "message", "Lcom/urbanairship/messagecenter/Message;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnMessageDeletedListener {
        void onDeleteMessage(@NotNull Message message);
    }

    public MessageCenterMessageFragment() {
        this(0, 1, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MessageCenterMessageFragment newInstance(@NotNull String str) {
        return INSTANCE.newInstance(str);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MessageCenterMessageFragment newInstance(@NotNull String str, @Nullable String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final MessageCenterMessageFragment newInstance(@NotNull String str, @Nullable String str2, @Nullable Boolean bool) {
        return INSTANCE.newInstance(str, str2, bool);
    }

    public /* synthetic */ MessageCenterMessageFragment(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.ua_fragment_message_center_message : i);
    }

    public MessageCenterMessageFragment(@LayoutRes int i) {
        super(i);
        this.messageTitle = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageCenterMessageFragment$messageTitle$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString(MessageCenterMessageFragment.ARG_MESSAGE_TITLE);
                }
                return null;
            }
        });
        this.showNavIcon = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageCenterMessageFragment$showNavIcon$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return Boolean.valueOf(arguments.getBoolean(MessageCenterMessageFragment.ARG_SHOW_NAV_ICON));
                }
                return null;
            }
        });
        Boolean showNavIcon = getShowNavIcon();
        this.isToolbarNavIconVisible = showNavIcon != null ? showNavIcon.booleanValue() : true;
    }

    private final String getMessageTitle() {
        return (String) this.messageTitle.getValue();
    }

    private final Boolean getShowNavIcon() {
        return (Boolean) this.showNavIcon.getValue();
    }

    @Nullable
    public final Toolbar getToolbar() {
        return this.toolbar;
    }

    public final void setToolbar(@Nullable Toolbar toolbar) {
        this.toolbar = toolbar;
        updateToolbarNavIcon$default(this, false, 1, null);
    }

    public final void setToolbarNavIconVisible(boolean z) {
        this.isToolbarNavIconVisible = z;
        updateToolbarNavIcon(z);
    }

    public final boolean isToolbarNavIconVisible() {
        Toolbar toolbar = this.toolbar;
        return toolbar != null ? toolbar.getNavigationIcon() != null : this.isToolbarNavIconVisible;
    }

    @Nullable
    public final OnMessageDeletedListener getOnMessageDeletedListener() {
        return this.onMessageDeletedListener;
    }

    public final void setOnMessageDeletedListener(@Nullable OnMessageDeletedListener onMessageDeletedListener) {
        this.onMessageDeletedListener = onMessageDeletedListener;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(layoutInflaterOnGetLayoutInflater, "onGetLayoutInflater(...)");
        LayoutInflater layoutInflaterCloneInContext = layoutInflaterOnGetLayoutInflater.cloneInContext(new ContextThemeWrapper(layoutInflaterOnGetLayoutInflater.getContext(), R.style.UrbanAirship_MessageCenter));
        Intrinsics.checkNotNullExpressionValue(layoutInflaterCloneInContext, "cloneInContext(...)");
        return layoutInflaterCloneInContext;
    }

    @Override // com.urbanairship.messagecenter.ui.MessageFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.collapseToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapse_toolbar);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNull(toolbar);
        setupToolbar(toolbar);
        setToolbar(toolbar);
        String messageTitle = getMessageTitle();
        if (messageTitle != null) {
            setToolbarTitle(messageTitle);
        }
        updateToolbarNavIcon$default(this, false, 1, null);
    }

    @Override // com.urbanairship.messagecenter.ui.MessageFragment
    protected void onMessageLoaded(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        setToolbarTitle(message.getTitle());
    }

    @Override // com.urbanairship.messagecenter.ui.MessageFragment
    protected void onMessageLoadError(@NotNull MessageViewState.Error.Type error) {
        Intrinsics.checkNotNullParameter(error, "error");
        setToolbarTitle(null);
    }

    public final void setToolbarTitle(@Nullable String title) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.collapseToolbar;
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(title);
        }
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            return;
        }
        toolbar.setTitle(title);
    }

    protected final void setupToolbar(@NotNull Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.urbanairship.messagecenter.ui.MessageCenterMessageFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageCenterMessageFragment.setupToolbar$lambda$2(this.f$0, view);
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.urbanairship.messagecenter.ui.MessageCenterMessageFragment$$ExternalSyntheticLambda1
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MessageCenterMessageFragment.setupToolbar$lambda$4(this.f$0, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupToolbar$lambda$2(MessageCenterMessageFragment this$0, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupToolbar$lambda$4(MessageCenterMessageFragment this$0, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (menuItem.getItemId() != R.id.delete) {
            return false;
        }
        Message currentMessage = this$0.getCurrentMessage();
        if (currentMessage != null) {
            OnMessageDeletedListener onMessageDeletedListener = this$0.onMessageDeletedListener;
            if (onMessageDeletedListener != null) {
                onMessageDeletedListener.onDeleteMessage(currentMessage);
            }
            this$0.deleteMessage(currentMessage);
        }
        return true;
    }

    static /* synthetic */ void updateToolbarNavIcon$default(MessageCenterMessageFragment messageCenterMessageFragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateToolbarNavIcon");
        }
        if ((i & 1) != 0) {
            z = messageCenterMessageFragment.isToolbarNavIconVisible();
        }
        messageCenterMessageFragment.updateToolbarNavIcon(z);
    }

    private final void updateToolbarNavIcon(final boolean isVisible) {
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageCenterMessageFragment.updateToolbarNavIcon.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Updating toolbar nav icon visibility: " + isVisible;
            }
        }, 1, null);
        if (isVisible) {
            Toolbar toolbar = this.toolbar;
            if (toolbar != null) {
                toolbar.setNavigationIcon(R.drawable.ua_ic_message_center_arrow_back);
                return;
            }
            return;
        }
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            return;
        }
        toolbar2.setNavigationIcon((Drawable) null);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageCenterMessageFragment$Companion;", "", "()V", "ARG_MESSAGE_ID", "", "ARG_MESSAGE_TITLE", "ARG_SHOW_NAV_ICON", "newInstance", "Lcom/urbanairship/messagecenter/ui/MessageCenterMessageFragment;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "messageTitle", "showNavIcon", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/urbanairship/messagecenter/ui/MessageCenterMessageFragment;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMessageCenterMessageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageCenterMessageFragment.kt\ncom/urbanairship/messagecenter/ui/MessageCenterMessageFragment$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n1#2:168\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MessageCenterMessageFragment newInstance(@NotNull String messageId) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            return newInstance$default(this, messageId, null, null, 6, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MessageCenterMessageFragment newInstance(@NotNull String messageId, @Nullable String str) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            return newInstance$default(this, messageId, str, null, 4, null);
        }

        private Companion() {
        }

        public static /* synthetic */ MessageCenterMessageFragment newInstance$default(Companion companion, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                bool = null;
            }
            return companion.newInstance(str, str2, bool);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final MessageCenterMessageFragment newInstance(@NotNull String messageId, @Nullable String messageTitle, @Nullable Boolean showNavIcon) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            MessageCenterMessageFragment messageCenterMessageFragment = new MessageCenterMessageFragment(0, 1, null);
            Bundle bundle = new Bundle();
            bundle.putString("message_id", messageId);
            if (messageTitle != null) {
                bundle.putString(MessageCenterMessageFragment.ARG_MESSAGE_TITLE, messageTitle);
            }
            if (showNavIcon != null) {
                bundle.putBoolean(MessageCenterMessageFragment.ARG_SHOW_NAV_ICON, showNavIcon.booleanValue());
            }
            messageCenterMessageFragment.setArguments(bundle);
            return messageCenterMessageFragment;
        }
    }
}

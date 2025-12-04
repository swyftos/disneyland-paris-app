package com.urbanairship.messagecenter.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.messaging.Constants;
import com.urbanairship.Predicate;
import com.urbanairship.UALog;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.R;
import com.urbanairship.messagecenter.ui.MessageCenterFragment;
import com.urbanairship.messagecenter.ui.MessageCenterMessageFragment;
import com.urbanairship.messagecenter.ui.MessageListFragment;
import com.urbanairship.messagecenter.ui.view.MessageViewState;
import com.urbanairship.messagecenter.util.FragmentExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u0000 C2\u00020\u0001:\u0003CDEB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u0002012\u0006\u00103\u001a\u000204H\u0016J\u001a\u00105\u001a\u0002012\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020<H\u0002J\u000e\u0010=\u001a\u0002012\u0006\u0010;\u001a\u00020\u0004J\u001c\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020<2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010<H\u0007J\u0010\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020\bH\u0002J\b\u0010B\u001a\u000201H\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R&\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R6\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00162\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\"\u001a\u0004\u0018\u00010#8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001f\u0010*\u001a\u00060+R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-¨\u0006F"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageCenterFragment;", "Landroidx/fragment/app/Fragment;", "()V", "displayedMessage", "Lcom/urbanairship/messagecenter/Message;", "getDisplayedMessage", "()Lcom/urbanairship/messagecenter/Message;", "value", "", "isListEditing", "()Z", "setListEditing", "(Z)V", "isTwoPane", "listFragment", "Lcom/urbanairship/messagecenter/ui/MessageCenterListFragment;", "getListFragment", "()Lcom/urbanairship/messagecenter/ui/MessageCenterListFragment;", "listPaneContainer", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "getListPaneContainer", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Lcom/urbanairship/Predicate;", "listPredicate", "getListPredicate", "()Lcom/urbanairship/Predicate;", "setListPredicate", "(Lcom/urbanairship/Predicate;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/messagecenter/ui/MessageCenterFragment$Listener;", "getListener", "()Lcom/urbanairship/messagecenter/ui/MessageCenterFragment$Listener;", "setListener", "(Lcom/urbanairship/messagecenter/ui/MessageCenterFragment$Listener;)V", "messageFragment", "Lcom/urbanairship/messagecenter/ui/MessageCenterMessageFragment;", "getMessageFragment", "()Lcom/urbanairship/messagecenter/ui/MessageCenterMessageFragment;", "slidingPaneLayout", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "getSlidingPaneLayout", "()Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "slidingPaneLayoutListener", "Lcom/urbanairship/messagecenter/ui/MessageCenterFragment$SlidingPaneLayoutListener;", "getSlidingPaneLayoutListener", "()Lcom/urbanairship/messagecenter/ui/MessageCenterFragment$SlidingPaneLayoutListener;", "slidingPaneLayoutListener$delegate", "Lkotlin/Lazy;", "closeMessage", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showListSnackbar", "message", "", "showMessage", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "messageTitle", "updatePaneAccessibility", "isShowingMessage", "updateTwoPaneLayout", "Companion", "Listener", "SlidingPaneLayoutListener", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageCenterFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageCenterFragment.kt\ncom/urbanairship/messagecenter/ui/MessageCenterFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,279:1\n1#2:280\n37#3:281\n53#3:282\n37#3:283\n53#3:284\n*S KotlinDebug\n*F\n+ 1 MessageCenterFragment.kt\ncom/urbanairship/messagecenter/ui/MessageCenterFragment\n*L\n152#1:281\n152#1:282\n164#1:283\n164#1:284\n*E\n"})
/* loaded from: classes5.dex */
public class MessageCenterFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String MESSAGE_ID = "message_id";
    private boolean isListEditing;
    private Predicate listPredicate;
    private Listener listener;

    /* renamed from: slidingPaneLayoutListener$delegate, reason: from kotlin metadata */
    private final Lazy slidingPaneLayoutListener;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageCenterFragment$Listener;", "", "onCloseMessage", "", "onListEditModeChanged", "isEditing", "", "onMessageLoadError", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/urbanairship/messagecenter/ui/view/MessageViewState$Error$Type;", "onMessageLoaded", "message", "Lcom/urbanairship/messagecenter/Message;", "onShowMessage", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onCloseMessage();

        void onListEditModeChanged(boolean isEditing);

        void onMessageLoadError(@NotNull MessageViewState.Error.Type error);

        void onMessageLoaded(@NotNull Message message);

        boolean onShowMessage(@NotNull Message message);
    }

    @JvmStatic
    @NotNull
    public static final MessageCenterFragment newInstance(@Nullable String str) {
        return INSTANCE.newInstance(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    @JvmOverloads
    public final void showMessage(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        showMessage$default(this, messageId, null, 2, null);
    }

    public MessageCenterFragment() {
        super(R.layout.ua_fragment_message_center);
        this.slidingPaneLayoutListener = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageCenterFragment$slidingPaneLayoutListener$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MessageCenterFragment.SlidingPaneLayoutListener invoke() {
                MessageCenterFragment messageCenterFragment = this.this$0;
                return new MessageCenterFragment.SlidingPaneLayoutListener(messageCenterFragment, messageCenterFragment.getSlidingPaneLayout(), false, 2, null);
            }
        });
    }

    public final void setListEditing(boolean z) {
        this.isListEditing = z;
        MessageCenterListFragment listFragment = getListFragment();
        if (listFragment == null) {
            return;
        }
        listFragment.setEditing(z);
    }

    public final boolean isListEditing() {
        MessageCenterListFragment listFragment = getListFragment();
        return listFragment != null ? listFragment.isEditing() : this.isListEditing;
    }

    public final void setListPredicate(@Nullable Predicate<Message> predicate) {
        this.listPredicate = predicate;
        MessageCenterListFragment listFragment = getListFragment();
        if (listFragment == null) {
            return;
        }
        listFragment.setPredicate(predicate);
    }

    @Nullable
    public final Predicate<Message> getListPredicate() {
        Predicate<Message> predicate;
        MessageCenterListFragment listFragment = getListFragment();
        return (listFragment == null || (predicate = listFragment.getPredicate()) == null) ? this.listPredicate : predicate;
    }

    public final boolean isTwoPane() {
        return !getSlidingPaneLayout().isSlideable();
    }

    @Nullable
    public final Message getDisplayedMessage() {
        MessageCenterMessageFragment messageFragment = getMessageFragment();
        if (messageFragment != null) {
            return messageFragment.getCurrentMessage();
        }
        return null;
    }

    @Nullable
    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener(@Nullable Listener listener) {
        this.listener = listener;
    }

    @Nullable
    protected final MessageCenterListFragment getListFragment() {
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("message_list");
        if (fragmentFindFragmentByTag instanceof MessageCenterListFragment) {
            return (MessageCenterListFragment) fragmentFindFragmentByTag;
        }
        return null;
    }

    @Nullable
    protected final MessageCenterMessageFragment getMessageFragment() {
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("message_view");
        if (fragmentFindFragmentByTag instanceof MessageCenterMessageFragment) {
            return (MessageCenterMessageFragment) fragmentFindFragmentByTag;
        }
        return null;
    }

    @NotNull
    protected final SlidingPaneLayout getSlidingPaneLayout() {
        try {
            View viewFindViewById = requireView().findViewById(R.id.message_center_sliding_pane_layout);
            Intrinsics.checkNotNull(viewFindViewById);
            return (SlidingPaneLayout) viewFindViewById;
        } catch (Exception e) {
            throw new IllegalStateException("MessageCenterFragment requires a SlidingPaneLayout with ID R.id.message_center_sliding_pane_layout", e);
        }
    }

    private final CoordinatorLayout getListPaneContainer() {
        View view = getView();
        if (view != null) {
            return (CoordinatorLayout) view.findViewById(R.id.message_list_pane_container);
        }
        return null;
    }

    private final SlidingPaneLayoutListener getSlidingPaneLayoutListener() {
        return (SlidingPaneLayoutListener) this.slidingPaneLayoutListener.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getSlidingPaneLayout().setLockMode(3);
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("message_id")) != null) {
            showMessage$default(this, string, null, 2, null);
        }
        final MessageCenterListFragment listFragment = getListFragment();
        if (listFragment != null) {
            listFragment.setOnEditListener(new MessageListFragment.OnEditListener() { // from class: com.urbanairship.messagecenter.ui.MessageCenterFragment$onViewCreated$2$1
                @Override // com.urbanairship.messagecenter.ui.MessageListFragment.OnEditListener
                public void onEditModeChanged(boolean isEditing) {
                    MessageCenterFragment.Listener listener = this.this$0.getListener();
                    if (listener != null) {
                        listener.onListEditModeChanged(isEditing);
                    }
                }

                @Override // com.urbanairship.messagecenter.ui.MessageListFragment.OnEditListener
                public void onDeleteMessages(int count) throws Resources.NotFoundException {
                    MessageCenterFragment messageCenterFragment = this.this$0;
                    String quantityString = listFragment.getResources().getQuantityString(R.plurals.ua_mc_description_deleted, count, Integer.valueOf(count));
                    Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                    messageCenterFragment.showListSnackbar(quantityString);
                }

                @Override // com.urbanairship.messagecenter.ui.MessageListFragment.OnEditListener
                public void onMarkMessagesRead(int count) throws Resources.NotFoundException {
                    MessageCenterFragment messageCenterFragment = this.this$0;
                    String quantityString = listFragment.getResources().getQuantityString(R.plurals.ua_mc_description_marked_read, count, Integer.valueOf(count));
                    Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                    messageCenterFragment.showListSnackbar(quantityString);
                }
            });
            listFragment.setOnMessageClickListener(new MessageListFragment.OnMessageClickListener() { // from class: com.urbanairship.messagecenter.ui.MessageCenterFragment$$ExternalSyntheticLambda0
                @Override // com.urbanairship.messagecenter.ui.MessageListFragment.OnMessageClickListener
                public final void onMessageClick(Message message) {
                    MessageCenterFragment.onViewCreated$lambda$1$lambda$0(this.f$0, message);
                }
            });
        }
        final MessageCenterMessageFragment messageFragment = getMessageFragment();
        if (messageFragment != null) {
            messageFragment.setOnMessageDeletedListener(new MessageCenterMessageFragment.OnMessageDeletedListener() { // from class: com.urbanairship.messagecenter.ui.MessageCenterFragment$$ExternalSyntheticLambda1
                @Override // com.urbanairship.messagecenter.ui.MessageCenterMessageFragment.OnMessageDeletedListener
                public final void onDeleteMessage(Message message) throws Resources.NotFoundException {
                    MessageCenterFragment.onViewCreated$lambda$3$lambda$2(this.f$0, messageFragment, message);
                }
            });
        }
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, getSlidingPaneLayoutListener());
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.urbanairship.messagecenter.ui.MessageCenterFragment$onViewCreated$$inlined$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@NotNull View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                view2.removeOnLayoutChangeListener(this);
                this.this$0.updateTwoPaneLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$lambda$0(MessageCenterFragment this$0, Message it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Listener listener = this$0.listener;
        if (listener == null || !listener.onShowMessage(it)) {
            this$0.showMessage(it);
        } else {
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageCenterFragment$onViewCreated$2$2$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "MessageCenterFragment - Message display handled by listener!";
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$2(MessageCenterFragment this$0, MessageCenterMessageFragment this_run, Message it) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(it, "it");
        String quantityString = this_run.getResources().getQuantityString(R.plurals.ua_mc_description_deleted, 1, 1);
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        this$0.showListSnackbar(quantityString);
        this$0.closeMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showListSnackbar(String message) {
        View listPaneContainer = getListPaneContainer();
        if (listPaneContainer == null) {
            MessageCenterListFragment listFragment = getListFragment();
            listPaneContainer = listFragment != null ? listFragment.getView() : null;
            if (listPaneContainer == null && (listPaneContainer = getView()) == null) {
                return;
            }
        }
        Snackbar.make(listPaneContainer, message, 0).show();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        View view = getView();
        if (view != null) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.urbanairship.messagecenter.ui.MessageCenterFragment$onConfigurationChanged$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view2.removeOnLayoutChangeListener(this);
                    this.this$0.updateTwoPaneLayout();
                }
            });
        }
    }

    public final void showMessage(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        showMessage(message.getId(), message.getTitle());
    }

    public static /* synthetic */ void showMessage$default(MessageCenterFragment messageCenterFragment, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMessage");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        messageCenterFragment.showMessage(str, str2);
    }

    @JvmOverloads
    public final void showMessage(@NotNull String messageId, @Nullable String messageTitle) {
        MessageCenterListFragment listFragment;
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (isTwoPane() && (listFragment = getListFragment()) != null) {
            listFragment.setHighlighted(messageId);
        }
        MessageCenterMessageFragment messageFragment = getMessageFragment();
        if (messageFragment != null) {
            messageFragment.setToolbarTitle(messageTitle);
            messageFragment.loadMessage(messageId);
            messageFragment.setToolbarNavIconVisible(!isTwoPane());
            updatePaneAccessibility(true);
            getSlidingPaneLayout().open();
        }
    }

    public final void closeMessage() {
        if (isTwoPane()) {
            MessageCenterMessageFragment messageFragment = getMessageFragment();
            if (messageFragment != null) {
                messageFragment.setToolbarTitle(null);
            }
            MessageCenterMessageFragment messageFragment2 = getMessageFragment();
            if (messageFragment2 != null) {
                messageFragment2.clearMessage();
            }
            MessageCenterListFragment listFragment = getListFragment();
            if (listFragment != null) {
                listFragment.clearHighlighted();
            }
        } else {
            updatePaneAccessibility(false);
            getSlidingPaneLayout().close();
        }
        Listener listener = this.listener;
        if (listener != null) {
            listener.onCloseMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTwoPaneLayout() {
        MessageCenterListFragment listFragment;
        MessageCenterMessageFragment messageFragment = getMessageFragment();
        if (messageFragment != null) {
            messageFragment.setToolbarNavIconVisible(!isTwoPane());
        }
        SlidingPaneLayoutListener slidingPaneLayoutListener = getSlidingPaneLayoutListener();
        SlidingPaneLayout slidingPaneLayout = getSlidingPaneLayout();
        slidingPaneLayoutListener.setEnabled(slidingPaneLayout.isSlideable() && slidingPaneLayout.isOpen());
        if (!isTwoPane() && (listFragment = getListFragment()) != null) {
            listFragment.clearHighlighted();
        }
        MessageCenterListFragment listFragment2 = getListFragment();
        if (listFragment2 == null) {
            return;
        }
        listFragment2.setVerticalDividerVisible(isTwoPane());
    }

    private final void updatePaneAccessibility(boolean isShowingMessage) {
        if (!isTwoPane()) {
            MessageCenterListFragment listFragment = getListFragment();
            if (listFragment != null) {
                FragmentExtensionsKt.setImportantForAccessibility(listFragment, !isShowingMessage);
            }
            MessageCenterMessageFragment messageFragment = getMessageFragment();
            if (messageFragment != null) {
                FragmentExtensionsKt.setImportantForAccessibility(messageFragment, isShowingMessage);
                return;
            }
            return;
        }
        MessageCenterListFragment listFragment2 = getListFragment();
        if (listFragment2 != null) {
            FragmentExtensionsKt.setImportantForAccessibility(listFragment2, true);
        }
        MessageCenterMessageFragment messageFragment2 = getMessageFragment();
        if (messageFragment2 != null) {
            FragmentExtensionsKt.setImportantForAccessibility(messageFragment2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class SlidingPaneLayoutListener extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {
        final /* synthetic */ MessageCenterFragment this$0;

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View panel, float f) {
            Intrinsics.checkNotNullParameter(panel, "panel");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SlidingPaneLayoutListener(MessageCenterFragment messageCenterFragment, SlidingPaneLayout layout, boolean z) {
            super(z);
            Intrinsics.checkNotNullParameter(layout, "layout");
            this.this$0 = messageCenterFragment;
            layout.addPanelSlideListener(this);
        }

        public /* synthetic */ SlidingPaneLayoutListener(MessageCenterFragment messageCenterFragment, SlidingPaneLayout slidingPaneLayout, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(messageCenterFragment, slidingPaneLayout, (i & 2) != 0 ? slidingPaneLayout.isSlideable() && slidingPaneLayout.isOpen() : z);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            this.this$0.closeMessage();
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View panel) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            setEnabled(true);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View panel) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            setEnabled(false);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageCenterFragment$Companion;", "", "()V", "MESSAGE_ID", "", "newInstance", "Lcom/urbanairship/messagecenter/ui/MessageCenterFragment;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final MessageCenterFragment newInstance(@Nullable String messageId) {
            MessageCenterFragment messageCenterFragment = new MessageCenterFragment();
            messageCenterFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("message_id", messageId)));
            return messageCenterFragment;
        }
    }
}

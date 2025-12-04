package com.urbanairship.messagecenter.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.urbanairship.messagecenter.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0014J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J\u001a\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0004J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\fH\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\fH\u0002J\u0012\u0010'\u001a\u00020\u001a2\b\b\u0002\u0010(\u001a\u00020\fH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageCenterListFragment;", "Lcom/urbanairship/messagecenter/ui/MessageListFragment;", "contentLayoutId", "", "(I)V", "a11yManager", "Landroid/view/accessibility/AccessibilityManager;", "getA11yManager", "()Landroid/view/accessibility/AccessibilityManager;", "a11yManager$delegate", "Lkotlin/Lazy;", "value", "", "isVerticalDividerVisible", "()Z", "setVerticalDividerVisible", "(Z)V", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "verticalDivider", "Landroid/view/View;", "onEditModeChanged", "", "isEditing", "onGetLayoutInflater", "Landroid/view/LayoutInflater;", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "onViewCreated", "view", "setupToolbar", "updateEditMode", "editing", "updateEditModeToggle", "updateTouchExplorationEnabled", "isEnabled", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageCenterListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageCenterListFragment.kt\ncom/urbanairship/messagecenter/ui/MessageCenterListFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,172:1\n254#2:173\n256#2,2:174\n256#2,2:178\n59#3,2:176\n*S KotlinDebug\n*F\n+ 1 MessageCenterListFragment.kt\ncom/urbanairship/messagecenter/ui/MessageCenterListFragment\n*L\n32#1:173\n30#1:174,2\n71#1:178,2\n53#1:176,2\n*E\n"})
/* loaded from: classes5.dex */
public class MessageCenterListFragment extends MessageListFragment {

    /* renamed from: a11yManager$delegate, reason: from kotlin metadata */
    private final Lazy a11yManager;
    private boolean isVerticalDividerVisible;
    private Toolbar toolbar;
    private View verticalDivider;

    @JvmOverloads
    public MessageCenterListFragment() {
        this(0, 1, null);
    }

    public /* synthetic */ MessageCenterListFragment(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.ua_fragment_message_center_list : i);
    }

    @JvmOverloads
    public MessageCenterListFragment(@LayoutRes int i) {
        super(i);
        this.a11yManager = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageCenterListFragment$a11yManager$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AccessibilityManager invoke() {
                Object systemService = this.this$0.requireContext().getSystemService("accessibility");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
                return (AccessibilityManager) systemService;
            }
        });
    }

    private final AccessibilityManager getA11yManager() {
        return (AccessibilityManager) this.a11yManager.getValue();
    }

    public final void setVerticalDividerVisible(boolean z) {
        this.isVerticalDividerVisible = z;
        View view = this.verticalDivider;
        if (view == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public final boolean isVerticalDividerVisible() {
        View view = this.verticalDivider;
        if (view != null) {
            return view.getVisibility() == 0;
        }
        return this.isVerticalDividerVisible;
    }

    @Nullable
    public final Toolbar getToolbar() {
        return this.toolbar;
    }

    public final void setToolbar(@Nullable Toolbar toolbar) {
        this.toolbar = toolbar;
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

    @Override // com.urbanairship.messagecenter.ui.MessageListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String string = getString(com.urbanairship.R.string.ua_message_center_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int[] UrbanAirship_MessageCenter = R.styleable.UrbanAirship_MessageCenter;
        Intrinsics.checkNotNullExpressionValue(UrbanAirship_MessageCenter, "UrbanAirship_MessageCenter");
        TypedArray typedArrayObtainStyledAttributes = contextRequireContext.obtainStyledAttributes(null, UrbanAirship_MessageCenter, 0, R.style.UrbanAirship_MessageCenter);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.UrbanAirship_MessageCenter_messageCenterToolbarTitle);
        if (string2 != null) {
            Intrinsics.checkNotNull(string2);
            string = string2;
        }
        typedArrayObtainStyledAttributes.recycle();
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNull(toolbar);
        setupToolbar(toolbar);
        toolbar.setTitle(string);
        this.toolbar = toolbar;
        View viewFindViewById = view.findViewById(R.id.list_vertical_divider);
        Intrinsics.checkNotNull(viewFindViewById);
        viewFindViewById.setVisibility(isVerticalDividerVisible() ? 0 : 8);
        this.verticalDivider = viewFindViewById;
        getA11yManager().addTouchExplorationStateChangeListener(new MessageCenterListFragment$$ExternalSyntheticLambda0(this));
        updateTouchExplorationEnabled$default(this, false, 1, null);
    }

    @Override // com.urbanairship.messagecenter.ui.MessageListFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getA11yManager().removeTouchExplorationStateChangeListener(new MessageCenterListFragment$$ExternalSyntheticLambda0(this));
    }

    @Override // com.urbanairship.messagecenter.ui.MessageListFragment
    protected void onEditModeChanged(boolean isEditing) {
        updateEditModeToggle(isEditing);
    }

    protected final void setupToolbar(@NotNull Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.urbanairship.messagecenter.ui.MessageCenterListFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageCenterListFragment.setupToolbar$lambda$6$lambda$4(this.f$0, view);
            }
        });
        updateTouchExplorationEnabled$default(this, false, 1, null);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.urbanairship.messagecenter.ui.MessageCenterListFragment$$ExternalSyntheticLambda2
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MessageCenterListFragment.setupToolbar$lambda$6$lambda$5(this.f$0, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupToolbar$lambda$6$lambda$4(MessageCenterListFragment this$0, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupToolbar$lambda$6$lambda$5(MessageCenterListFragment this$0, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.enter_edit_mode) {
            this$0.updateEditMode(true);
            return true;
        }
        if (itemId == R.id.leave_edit_mode) {
            this$0.updateEditMode(false);
            return true;
        }
        if (itemId == R.id.mark_all_read) {
            this$0.markAllMessagesRead();
            return true;
        }
        if (itemId == R.id.delete_all) {
            this$0.deleteAllMessages();
            return true;
        }
        if (itemId != R.id.refresh) {
            return false;
        }
        MessageListFragment.refresh$default(this$0, null, 1, null);
        return true;
    }

    static /* synthetic */ void updateTouchExplorationEnabled$default(MessageCenterListFragment messageCenterListFragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTouchExplorationEnabled");
        }
        if ((i & 1) != 0) {
            z = messageCenterListFragment.getA11yManager().isTouchExplorationEnabled();
        }
        messageCenterListFragment.updateTouchExplorationEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTouchExplorationEnabled(boolean isEnabled) {
        Menu menu;
        Menu menu2;
        Menu menu3;
        Toolbar toolbar = this.toolbar;
        MenuItem menuItemFindItem = null;
        MenuItem menuItemFindItem2 = (toolbar == null || (menu3 = toolbar.getMenu()) == null) ? null : menu3.findItem(R.id.mark_all_read);
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null && (menu2 = toolbar2.getMenu()) != null) {
            menuItemFindItem = menu2.findItem(R.id.delete_all);
        }
        if (isEnabled) {
            Toolbar toolbar3 = this.toolbar;
            if (toolbar3 != null && (menu = toolbar3.getMenu()) != null) {
                MenuItem menuItemFindItem3 = menu.findItem(R.id.enter_edit_mode);
                if (menuItemFindItem3 != null) {
                    menuItemFindItem3.setVisible(false);
                }
                MenuItem menuItemFindItem4 = menu.findItem(R.id.leave_edit_mode);
                if (menuItemFindItem4 != null) {
                    menuItemFindItem4.setVisible(false);
                }
            }
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setVisible(true);
            }
            if (menuItemFindItem == null) {
                return;
            }
            menuItemFindItem.setVisible(true);
            return;
        }
        updateEditModeToggle(isEditing());
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(false);
        }
        if (menuItemFindItem == null) {
            return;
        }
        menuItemFindItem.setVisible(false);
    }

    private final void updateEditMode(boolean editing) {
        int i;
        setEditing(editing);
        if (editing) {
            i = R.string.ua_announce_enter_edit_mode;
        } else {
            i = R.string.ua_announce_leave_edit_mode;
        }
        String string = getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        View view = getView();
        if (view != null) {
            view.announceForAccessibility(string);
        }
    }

    private final void updateEditModeToggle(boolean editing) {
        Menu menu;
        Toolbar toolbar = this.toolbar;
        if (toolbar == null || (menu = toolbar.getMenu()) == null) {
            return;
        }
        MenuItem menuItemFindItem = menu.findItem(R.id.enter_edit_mode);
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(!editing);
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.leave_edit_mode);
        if (menuItemFindItem2 == null) {
            return;
        }
        menuItemFindItem2.setVisible(editing);
    }
}

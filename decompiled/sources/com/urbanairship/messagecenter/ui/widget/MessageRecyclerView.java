package com.urbanairship.messagecenter.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import com.google.firebase.messaging.Constants;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.R;
import com.urbanairship.messagecenter.ui.widget.EditableListAdapter;
import com.urbanairship.messagecenter.ui.widget.EditableRecyclerView;
import com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter;
import java.util.List;
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

@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0018\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B/\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 J\f\u0010!\u001a\u00020\u001b*\u00020\"H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006#"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerView;", "Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView;", "Lcom/urbanairship/messagecenter/Message;", "Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$ViewHolder;", "Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$AccessibilityAction;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "accessibilityListener", "Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$AccessibilityActionListener;", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "getAccessibilityManager", "()Landroid/view/accessibility/AccessibilityManager;", "accessibilityManager$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter;", "adapterListener", "com/urbanairship/messagecenter/ui/widget/MessageRecyclerView$adapterListener$1", "Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerView$adapterListener$1;", "setHighlightedMessageId", "", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "submitList", "messages", "", "applyDividerStyles", "Landroid/content/res/TypedArray;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageRecyclerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageRecyclerView.kt\ncom/urbanairship/messagecenter/ui/widget/MessageRecyclerView\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,272:1\n59#2,2:273\n*S KotlinDebug\n*F\n+ 1 MessageRecyclerView.kt\ncom/urbanairship/messagecenter/ui/widget/MessageRecyclerView\n*L\n73#1:273,2\n*E\n"})
/* loaded from: classes5.dex */
public final class MessageRecyclerView extends EditableRecyclerView<Message, MessageRecyclerAdapter.ViewHolder, MessageRecyclerAdapter.AccessibilityAction> {
    private final MessageRecyclerAdapter.AccessibilityActionListener accessibilityListener;

    /* renamed from: accessibilityManager$delegate, reason: from kotlin metadata */
    private final Lazy accessibilityManager;
    private final MessageRecyclerAdapter adapter;
    private final MessageRecyclerView$adapterListener$1 adapterListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageRecyclerView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MessageRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? R.style.UrbanAirship_MessageCenter_List : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.urbanairship.messagecenter.ui.widget.EditableListAdapter$Listener, com.urbanairship.messagecenter.ui.widget.MessageRecyclerView$adapterListener$1] */
    @JvmOverloads
    public MessageRecyclerView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i, int i2) throws IllegalArgumentException {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.accessibilityManager = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageRecyclerView$accessibilityManager$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AccessibilityManager invoke() {
                Object systemService = context.getSystemService("accessibility");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
                return (AccessibilityManager) systemService;
            }
        });
        ?? r6 = new EditableListAdapter.Listener<Message>() { // from class: com.urbanairship.messagecenter.ui.widget.MessageRecyclerView$adapterListener$1
            @Override // com.urbanairship.messagecenter.ui.widget.EditableListAdapter.Listener
            public void onItemClicked(@NotNull Message item) {
                Intrinsics.checkNotNullParameter(item, "item");
                if (this.this$0.getIsEditing()) {
                    EditableListAdapter<Message, MessageRecyclerAdapter.ViewHolder> editableAdapter = this.this$0.getEditableAdapter();
                    if (editableAdapter != null) {
                        editableAdapter.toggleSelected(item);
                        return;
                    }
                    return;
                }
                EditableRecyclerView.Listener<Message, MessageRecyclerAdapter.AccessibilityAction> listener = this.this$0.getListener();
                if (listener != null) {
                    listener.onItemClicked(item);
                }
            }

            @Override // com.urbanairship.messagecenter.ui.widget.EditableListAdapter.Listener
            public void onItemLongClicked(@NotNull Message item) {
                Intrinsics.checkNotNullParameter(item, "item");
                if (this.this$0.getIsEditing()) {
                    return;
                }
                this.this$0.setEditing(true);
            }

            @Override // com.urbanairship.messagecenter.ui.widget.EditableListAdapter.Listener
            public void onSelectionChanged(@NotNull List<? extends Message> selectedItems, boolean isAllSelected) {
                Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
                EditableRecyclerView.Listener<Message, MessageRecyclerAdapter.AccessibilityAction> listener = this.this$0.getListener();
                if (listener != null) {
                    listener.onSelectionChanged(selectedItems, isAllSelected);
                }
            }
        };
        this.adapterListener = r6;
        MessageRecyclerAdapter.AccessibilityActionListener accessibilityActionListener = new MessageRecyclerAdapter.AccessibilityActionListener() { // from class: com.urbanairship.messagecenter.ui.widget.MessageRecyclerView$$ExternalSyntheticLambda0
            @Override // com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter.AccessibilityActionListener
            public final void onAccessibilityAction(MessageRecyclerAdapter.AccessibilityAction accessibilityAction, Message message) {
                MessageRecyclerView.accessibilityListener$lambda$0(this.f$0, accessibilityAction, message);
            }
        };
        this.accessibilityListener = accessibilityActionListener;
        MessageRecyclerAdapter messageRecyclerAdapter = new MessageRecyclerAdapter(r6, accessibilityActionListener, new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageRecyclerView$adapter$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.getIsEditing());
            }
        }, new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageRecyclerView$adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.getAccessibilityManager().isTouchExplorationEnabled());
            }
        });
        this.adapter = messageRecyclerAdapter;
        int[] UrbanAirship_MessageCenter = R.styleable.UrbanAirship_MessageCenter;
        Intrinsics.checkNotNullExpressionValue(UrbanAirship_MessageCenter, "UrbanAirship_MessageCenter");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, UrbanAirship_MessageCenter, 0, R.style.UrbanAirship_MessageCenter);
        applyDividerStyles(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        addItemDecoration(new VerticalSpacingItemDecoration(getResources().getDimensionPixelSize(R.dimen.message_list_item_spacing_top), getResources().getDimensionPixelSize(R.dimen.message_list_item_spacing_middle), getResources().getDimensionPixelSize(R.dimen.message_list_item_spacing_bottom)));
        setAdapter(messageRecyclerAdapter);
        setLayoutManager(new LinearLayoutManager(context));
        getAccessibilityManager().addTouchExplorationStateChangeListener(new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.urbanairship.messagecenter.ui.widget.MessageRecyclerView$$ExternalSyntheticLambda1
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                MessageRecyclerView._init_$lambda$2(this.f$0, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessibilityManager getAccessibilityManager() {
        return (AccessibilityManager) this.accessibilityManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accessibilityListener$lambda$0(MessageRecyclerView this$0, MessageRecyclerAdapter.AccessibilityAction action, Message message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(message, "message");
        EditableRecyclerView.Listener<Message, MessageRecyclerAdapter.AccessibilityAction> listener = this$0.getListener();
        if (listener != null) {
            listener.onAction(action, message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(MessageRecyclerView this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adapter.notifyDataSetChanged();
    }

    public final void submitList(@NotNull List<Message> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.adapter.submitList(messages);
    }

    public final void setHighlightedMessageId(@Nullable String messageId) {
        this.adapter.setHighlightedItemId(messageId);
    }

    private final void applyDividerStyles(TypedArray typedArray) {
        if (typedArray.getBoolean(R.styleable.UrbanAirship_MessageCenter_messageCenterItemDividersEnabled, false)) {
            MaterialDividerItemDecoration materialDividerItemDecoration = new MaterialDividerItemDecoration(getContext(), 1);
            materialDividerItemDecoration.setDividerInsetStart(typedArray.getDimensionPixelSize(R.styleable.UrbanAirship_MessageCenter_messageCenterItemDividerInsetStart, getContext().getResources().getDimensionPixelSize(R.dimen.message_item_divider_inset_start)));
            materialDividerItemDecoration.setDividerInsetEnd(typedArray.getDimensionPixelSize(R.styleable.UrbanAirship_MessageCenter_messageCenterItemDividerInsetEnd, getContext().getResources().getDimensionPixelSize(R.dimen.message_item_divider_inset_end)));
            addItemDecoration(materialDividerItemDecoration);
        }
    }
}

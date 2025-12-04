package com.urbanairship.messagecenter.ui.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.R;
import com.urbanairship.messagecenter.ui.widget.EditableListAdapter;
import com.urbanairship.messagecenter.ui.widget.EditableRecyclerView;
import com.urbanairship.messagecenter.ui.widget.MessageListItem;
import com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\"#$%B7\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\fJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\u0012\u0010\u001e\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00132\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter;", "Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter;", "Lcom/urbanairship/messagecenter/Message;", "Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$ViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter$Listener;", "accessibilityActionListener", "Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$AccessibilityActionListener;", "isEditingProvider", "Lkotlin/Function0;", "", "isTouchExplorationEnabledProvider", "(Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter$Listener;Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$AccessibilityActionListener;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "highlightedItemId", "", "positionMap", "", "", "clearHighlightedItemId", "", "getHighlightedItemId", "getItemId", "", ViewProps.POSITION, "isHighlighted", "itemId", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setHighlightedItemId", "submitList", "list", "", "AccessibilityAction", "AccessibilityActionListener", "Companion", "ViewHolder", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageRecyclerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageRecyclerView.kt\ncom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,272:1\n1864#2,3:273\n*S KotlinDebug\n*F\n+ 1 MessageRecyclerView.kt\ncom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter\n*L\n151#1:273,3\n*E\n"})
/* loaded from: classes5.dex */
public final class MessageRecyclerAdapter extends EditableListAdapter<Message, ViewHolder> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final DiffUtil.ItemCallback DIFF_CALLBACK = new DiffUtil.ItemCallback<Message>() { // from class: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$Companion$DIFF_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull Message oldItem, @NotNull Message newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull Message oldItem, @NotNull Message newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };
    private final AccessibilityActionListener accessibilityActionListener;
    private String highlightedItemId;
    private final Map positionMap;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$AccessibilityActionListener;", "", "onAccessibilityAction", "", "action", "Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$AccessibilityAction;", "message", "Lcom/urbanairship/messagecenter/Message;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AccessibilityActionListener {
        void onAccessibilityAction(@NotNull AccessibilityAction action, @NotNull Message message);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRecyclerAdapter(@NotNull EditableListAdapter.Listener<Message> listener, @NotNull AccessibilityActionListener accessibilityActionListener, @NotNull Function0<Boolean> isEditingProvider, @NotNull Function0<Boolean> isTouchExplorationEnabledProvider) {
        super(listener, isEditingProvider, isTouchExplorationEnabledProvider, DIFF_CALLBACK);
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(accessibilityActionListener, "accessibilityActionListener");
        Intrinsics.checkNotNullParameter(isEditingProvider, "isEditingProvider");
        Intrinsics.checkNotNullParameter(isTouchExplorationEnabledProvider, "isTouchExplorationEnabledProvider");
        this.accessibilityActionListener = accessibilityActionListener;
        setHasStableIds(true);
        this.positionMap = new LinkedHashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return getItem(position).getId().hashCode();
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<Message> list) {
        super.submitList(list);
        this.positionMap.clear();
        if (list != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                this.positionMap.put(((Message) obj).getId(), Integer.valueOf(i));
                i = i2;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$AccessibilityAction;", "", "(Ljava/lang/String;I)V", "MARK_READ", "DELETE", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AccessibilityAction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AccessibilityAction[] $VALUES;
        public static final AccessibilityAction MARK_READ = new AccessibilityAction("MARK_READ", 0);
        public static final AccessibilityAction DELETE = new AccessibilityAction("DELETE", 1);

        private static final /* synthetic */ AccessibilityAction[] $values() {
            return new AccessibilityAction[]{MARK_READ, DELETE};
        }

        @NotNull
        public static EnumEntries<AccessibilityAction> getEntries() {
            return $ENTRIES;
        }

        public static AccessibilityAction valueOf(String str) {
            return (AccessibilityAction) Enum.valueOf(AccessibilityAction.class, str);
        }

        public static AccessibilityAction[] values() {
            return (AccessibilityAction[]) $VALUES.clone();
        }

        private AccessibilityAction(String str, int i) {
        }

        static {
            AccessibilityAction[] accessibilityActionArr$values = $values();
            $VALUES = accessibilityActionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(accessibilityActionArr$values);
        }
    }

    @Override // com.urbanairship.messagecenter.ui.widget.EditableListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new ViewHolder(parent, null, new AnonymousClass1(this), new AnonymousClass2(isEditing()), new AnonymousClass3(isTouchExplorationEnabledProvider()), new AnonymousClass4(this), new AnonymousClass5(this), new AnonymousClass6(this), new AnonymousClass7(this.accessibilityActionListener), 2, null);
    }

    /* renamed from: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$onCreateViewHolder$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass1(Object obj) {
            super(1, obj, MessageRecyclerAdapter.class, "isSelected", "isSelected(Ljava/lang/Object;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Message p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return Boolean.valueOf(((MessageRecyclerAdapter) this.receiver).isSelected(p0));
        }
    }

    /* renamed from: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$onCreateViewHolder$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0 {
        AnonymousClass2(Object obj) {
            super(0, obj, Function0.class, "invoke", "invoke()Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return (Boolean) ((Function0) this.receiver).invoke();
        }
    }

    /* renamed from: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$onCreateViewHolder$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0 {
        AnonymousClass3(Object obj) {
            super(0, obj, Function0.class, "invoke", "invoke()Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return (Boolean) ((Function0) this.receiver).invoke();
        }
    }

    /* renamed from: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$onCreateViewHolder$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass4(Object obj) {
            super(1, obj, MessageRecyclerAdapter.class, "isHighlighted", "isHighlighted(Ljava/lang/String;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return Boolean.valueOf(((MessageRecyclerAdapter) this.receiver).isHighlighted(p0));
        }
    }

    /* renamed from: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$onCreateViewHolder$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass5(Object obj) {
            super(1, obj, MessageRecyclerAdapter.class, "onItemClicked", "onItemClicked(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Message) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(Message p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MessageRecyclerAdapter) this.receiver).onItemClicked(p0);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$onCreateViewHolder$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass6(Object obj) {
            super(1, obj, MessageRecyclerAdapter.class, "onItemLongClicked", "onItemLongClicked(Ljava/lang/Object;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Message p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return Boolean.valueOf(((MessageRecyclerAdapter) this.receiver).onItemLongClicked(p0));
        }
    }

    /* renamed from: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$onCreateViewHolder$7, reason: invalid class name */
    /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function2 {
        AnonymousClass7(Object obj) {
            super(2, obj, AccessibilityActionListener.class, "onAccessibilityAction", "onAccessibilityAction(Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$AccessibilityAction;Lcom/urbanairship/messagecenter/Message;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((AccessibilityAction) obj, (Message) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(AccessibilityAction p0, Message p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((AccessibilityActionListener) this.receiver).onAccessibilityAction(p0, p1);
        }
    }

    @Override // com.urbanairship.messagecenter.ui.widget.EditableListAdapter
    public void setHighlightedItemId(@Nullable String itemId) {
        if (Intrinsics.areEqual(this.highlightedItemId, itemId)) {
            return;
        }
        this.highlightedItemId = itemId;
        notifyItemRangeChanged(0, getCurrentList().size(), new EditableRecyclerView.Payload.UpdateHighlighted(false));
        Integer num = (Integer) this.positionMap.get(itemId);
        int iIntValue = num != null ? num.intValue() : -1;
        if (iIntValue != -1) {
            notifyItemChanged(iIntValue, new EditableRecyclerView.Payload.UpdateHighlighted(true));
        }
    }

    @Override // com.urbanairship.messagecenter.ui.widget.EditableListAdapter
    @Nullable
    public String getHighlightedItemId() {
        return this.highlightedItemId;
    }

    @Override // com.urbanairship.messagecenter.ui.widget.EditableListAdapter
    public void clearHighlightedItemId() {
        this.highlightedItemId = null;
        notifyItemRangeChanged(0, getCurrentList().size(), new EditableRecyclerView.Payload.UpdateHighlighted(false));
    }

    @Override // com.urbanairship.messagecenter.ui.widget.EditableListAdapter
    public boolean isHighlighted(@NotNull String itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return Intrinsics.areEqual(this.highlightedItemId, itemId);
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u009d\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\t\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0002H\u0010¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\nH\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$ViewHolder;", "Lcom/urbanairship/messagecenter/ui/widget/EditableViewHolder;", "Lcom/urbanairship/messagecenter/Message;", "Lcom/urbanairship/messagecenter/ui/widget/MessageListItem;", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "isSelected", "Lkotlin/Function1;", "", "isEditing", "Lkotlin/Function0;", "isTouchExplorationEnabled", "isHighlighted", "", "onItemClicked", "", "onItemLongClicked", "onAccessibilityAction", "Lkotlin/Function2;", "Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$AccessibilityAction;", "(Landroid/view/ViewGroup;Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "bind$urbanairship_message_center_release", "updateEditing", "updateHighlighted", "updateSelected", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends EditableViewHolder<Message, MessageListItem> {
        private final Function0 isEditing;
        private final Function1 isHighlighted;
        private final Function1 isSelected;
        private final Function0 isTouchExplorationEnabled;
        private final Function2 onAccessibilityAction;
        private final Function1 onItemClicked;
        private final Function1 onItemLongClicked;

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ ViewHolder(ViewGroup viewGroup, View view, Function1 function1, Function0 function0, Function0 function02, Function1 function12, Function1 function13, Function1 function14, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            View view2;
            if ((i & 2) != 0) {
                View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ua_view_message_list_item, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
                view2 = viewInflate;
            } else {
                view2 = view;
            }
            this(viewGroup, view2, function1, function0, function02, function12, function13, function14, function2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ViewGroup parent, @NotNull View view, @NotNull Function1<? super Message, Boolean> isSelected, @NotNull Function0<Boolean> isEditing, @NotNull Function0<Boolean> isTouchExplorationEnabled, @NotNull Function1<? super String, Boolean> isHighlighted, @NotNull Function1<? super Message, Unit> onItemClicked, @NotNull Function1<? super Message, Boolean> onItemLongClicked, @NotNull Function2<? super AccessibilityAction, ? super Message, Unit> onAccessibilityAction) {
            super((MessageListItem) view);
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(isSelected, "isSelected");
            Intrinsics.checkNotNullParameter(isEditing, "isEditing");
            Intrinsics.checkNotNullParameter(isTouchExplorationEnabled, "isTouchExplorationEnabled");
            Intrinsics.checkNotNullParameter(isHighlighted, "isHighlighted");
            Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
            Intrinsics.checkNotNullParameter(onItemLongClicked, "onItemLongClicked");
            Intrinsics.checkNotNullParameter(onAccessibilityAction, "onAccessibilityAction");
            this.isSelected = isSelected;
            this.isEditing = isEditing;
            this.isTouchExplorationEnabled = isTouchExplorationEnabled;
            this.isHighlighted = isHighlighted;
            this.onItemClicked = onItemClicked;
            this.onItemLongClicked = onItemLongClicked;
            this.onAccessibilityAction = onAccessibilityAction;
        }

        @Override // com.urbanairship.messagecenter.ui.widget.EditableViewHolder
        public void bind$urbanairship_message_center_release(@NotNull final Message item) {
            Intrinsics.checkNotNullParameter(item, "item");
            MessageListItem editableItemView$urbanairship_message_center_release = getEditableItemView$urbanairship_message_center_release();
            editableItemView$urbanairship_message_center_release.bind(item);
            editableItemView$urbanairship_message_center_release.updateEditing$urbanairship_message_center_release(((Boolean) this.isEditing.invoke()).booleanValue(), false);
            editableItemView$urbanairship_message_center_release.updateSelected$urbanairship_message_center_release(((Boolean) this.isSelected.invoke(item)).booleanValue());
            editableItemView$urbanairship_message_center_release.updateHighlighted$urbanairship_message_center_release(((Boolean) this.isHighlighted.invoke(item.getId())).booleanValue());
            InstrumentationCallbacks.setOnClickListenerCalled(editableItemView$urbanairship_message_center_release, new View.OnClickListener() { // from class: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MessageRecyclerAdapter.ViewHolder.bind$lambda$2$lambda$0(this.f$0, item, view);
                }
            });
            if (!((Boolean) this.isTouchExplorationEnabled.invoke()).booleanValue()) {
                editableItemView$urbanairship_message_center_release.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return MessageRecyclerAdapter.ViewHolder.bind$lambda$2$lambda$1(this.f$0, item, view);
                    }
                });
            }
            editableItemView$urbanairship_message_center_release.setAccessibilityActionListener(new MessageListItem.AccessibilityActionListener() { // from class: com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter$ViewHolder$bind$1$3
                @Override // com.urbanairship.messagecenter.ui.widget.MessageListItem.AccessibilityActionListener
                public void onMarkRead(@NotNull Message message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    this.this$0.onAccessibilityAction.invoke(MessageRecyclerAdapter.AccessibilityAction.MARK_READ, message);
                }

                @Override // com.urbanairship.messagecenter.ui.widget.MessageListItem.AccessibilityActionListener
                public void onDelete(@NotNull Message message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    this.this$0.onAccessibilityAction.invoke(MessageRecyclerAdapter.AccessibilityAction.DELETE, message);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2$lambda$0(ViewHolder this$0, Message item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onItemClicked.invoke(item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean bind$lambda$2$lambda$1(ViewHolder this$0, Message item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            return ((Boolean) this$0.onItemLongClicked.invoke(item)).booleanValue();
        }

        @Override // com.urbanairship.messagecenter.ui.widget.EditableViewHolder
        public void updateEditing(boolean isEditing) {
            getEditableItemView$urbanairship_message_center_release().updateEditing$urbanairship_message_center_release(isEditing, true);
        }

        @Override // com.urbanairship.messagecenter.ui.widget.EditableViewHolder
        public void updateSelected(boolean isSelected) {
            getEditableItemView$urbanairship_message_center_release().updateSelected$urbanairship_message_center_release(isSelected);
        }

        @Override // com.urbanairship.messagecenter.ui.widget.EditableViewHolder
        public void updateHighlighted(boolean isHighlighted) {
            getEditableItemView$urbanairship_message_center_release().updateHighlighted$urbanairship_message_center_release(isHighlighted);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageRecyclerAdapter$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/urbanairship/messagecenter/Message;", "getDIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final DiffUtil.ItemCallback<Message> getDIFF_CALLBACK() {
            return MessageRecyclerAdapter.DIFF_CALLBACK;
        }
    }
}

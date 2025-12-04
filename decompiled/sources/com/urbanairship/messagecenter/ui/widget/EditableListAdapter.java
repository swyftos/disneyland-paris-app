package com.urbanairship.messagecenter.ui.widget;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.messagecenter.ui.widget.EditableRecyclerView;
import com.urbanairship.messagecenter.ui.widget.EditableViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0012\b\u0001\u0010\u0002*\f\u0012\u0004\u0012\u0002H\u0001\u0012\u0002\b\u00030\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u00018B=\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0002\u0010\rJ\b\u0010\u0015\u001a\u00020\u0016H&J\u0006\u0010\u0017\u001a\u00020\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0019H&J\u0013\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u001d\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00028\u00012\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J+\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00028\u00012\u0006\u0010#\u001a\u00020$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001bH\u0016¢\u0006\u0002\u0010(J\u001d\u0010)\u001a\u00028\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020$H&¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u0014\u00101\u001a\u00020\u00162\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ\u0006\u00103\u001a\u00020\u0016J\u0012\u00104\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H&J\u001b\u00105\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\t¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010/R\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "VH", "Lcom/urbanairship/messagecenter/ui/widget/EditableViewHolder;", "Landroidx/recyclerview/widget/ListAdapter;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter$Listener;", "isEditing", "Lkotlin/Function0;", "", "isTouchExplorationEnabledProvider", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter$Listener;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "isAllSelected", "()Z", "()Lkotlin/jvm/functions/Function0;", "getListener", "()Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter$Listener;", "selected", "", "clearHighlightedItemId", "", "clearSelected", "getHighlightedItemId", "", "getSelected", "", "isHighlighted", "itemId", "isSelected", "item", "(Ljava/lang/Object;)Z", "onBindViewHolder", "holder", ViewProps.POSITION, "", "(Lcom/urbanairship/messagecenter/ui/widget/EditableViewHolder;I)V", "payloads", "", "(Lcom/urbanairship/messagecenter/ui/widget/EditableViewHolder;ILjava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "(Landroid/view/ViewGroup;I)Lcom/urbanairship/messagecenter/ui/widget/EditableViewHolder;", "onItemClicked", "(Ljava/lang/Object;)V", "onItemLongClicked", "restoreSelected", "selectedItems", "selectAll", "setHighlightedItemId", "setSelected", "(Ljava/lang/Object;Z)V", "toggleSelected", "Listener", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEditableRecyclerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditableRecyclerView.kt\ncom/urbanairship/messagecenter/ui/widget/EditableListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,317:1\n800#2,11:318\n1855#2,2:329\n*S KotlinDebug\n*F\n+ 1 EditableRecyclerView.kt\ncom/urbanairship/messagecenter/ui/widget/EditableListAdapter\n*L\n255#1:318,11\n255#1:329,2\n*E\n"})
/* loaded from: classes5.dex */
public abstract class EditableListAdapter<T, VH extends EditableViewHolder<T, ?>> extends ListAdapter<T, VH> {
    private final Function0 isEditing;
    private final Function0 isTouchExplorationEnabledProvider;
    private final Listener listener;
    private final Set selected;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u0006J\u001e\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter$Listener;", ExifInterface.GPS_DIRECTION_TRUE, "", "onItemClicked", "", "item", "(Ljava/lang/Object;)V", "onItemLongClicked", "onSelectionChanged", "selectedItems", "", "isAllSelected", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener<T> {
        void onItemClicked(T item);

        void onItemLongClicked(T item);

        void onSelectionChanged(@NotNull List<? extends T> selectedItems, boolean isAllSelected);
    }

    public abstract void clearHighlightedItemId();

    @Nullable
    public abstract String getHighlightedItemId();

    public abstract boolean isHighlighted(@NotNull String itemId);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public abstract VH onCreateViewHolder(@NotNull ViewGroup parent, int viewType);

    public abstract void setHighlightedItemId(@Nullable String itemId);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((EditableListAdapter<T, VH>) viewHolder, i, (List<? extends Object>) list);
    }

    @NotNull
    protected final Listener<T> getListener() {
        return this.listener;
    }

    @NotNull
    protected final Function0<Boolean> isEditing() {
        return this.isEditing;
    }

    @NotNull
    protected final Function0<Boolean> isTouchExplorationEnabledProvider() {
        return this.isTouchExplorationEnabledProvider;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditableListAdapter(@NotNull Listener<T> listener, @NotNull Function0<Boolean> isEditing, @NotNull Function0<Boolean> isTouchExplorationEnabledProvider, @NotNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(isEditing, "isEditing");
        Intrinsics.checkNotNullParameter(isTouchExplorationEnabledProvider, "isTouchExplorationEnabledProvider");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        this.listener = listener;
        this.isEditing = isEditing;
        this.isTouchExplorationEnabledProvider = isTouchExplorationEnabledProvider;
        this.selected = new LinkedHashSet();
    }

    public final boolean isAllSelected() {
        return this.selected.size() == getItemCount();
    }

    @NotNull
    public final List<T> getSelected() {
        return CollectionsKt.toList(this.selected);
    }

    public final void restoreSelected(@NotNull List<? extends T> selectedItems) {
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        this.selected.clear();
        this.selected.addAll(selectedItems);
        Iterator<? extends T> it = selectedItems.iterator();
        while (it.hasNext()) {
            notifyItemChanged(getCurrentList().indexOf(it.next()), new EditableRecyclerView.Payload.UpdateSelected(true));
        }
        this.listener.onSelectionChanged(selectedItems, isAllSelected());
    }

    public final boolean isSelected(T item) {
        return this.selected.contains(item);
    }

    public final void setSelected(T item, boolean isSelected) {
        Set set = this.selected;
        if (isSelected) {
            set.add(item);
        } else {
            set.remove(item);
        }
        notifyItemChanged(getCurrentList().indexOf(item), new EditableRecyclerView.Payload.UpdateSelected(isSelected(item)));
        this.listener.onSelectionChanged(CollectionsKt.toList(this.selected), isAllSelected());
    }

    public final void toggleSelected(T item) {
        setSelected(item, !isSelected(item));
    }

    public final void clearSelected() {
        this.selected.clear();
        notifyItemRangeChanged(0, getItemCount(), new EditableRecyclerView.Payload.UpdateSelected(false));
        this.listener.onSelectionChanged(CollectionsKt.emptyList(), isAllSelected());
    }

    public final void selectAll() {
        this.selected.clear();
        Set set = this.selected;
        List<T> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        set.addAll(currentList);
        notifyItemRangeChanged(0, getItemCount(), new EditableRecyclerView.Payload.UpdateSelected(true));
        this.listener.onSelectionChanged(CollectionsKt.toList(this.selected), isAllSelected());
    }

    public final void onItemClicked(T item) {
        if (((Boolean) this.isEditing.invoke()).booleanValue()) {
            toggleSelected(item);
        } else {
            this.listener.onItemClicked(item);
        }
    }

    public final boolean onItemLongClicked(T item) {
        if (((Boolean) this.isEditing.invoke()).booleanValue()) {
            return false;
        }
        setSelected(item, true);
        this.listener.onItemLongClicked(item);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull VH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        onBindViewHolder((EditableListAdapter<T, VH>) holder, position, CollectionsKt.emptyList());
    }

    public void onBindViewHolder(@NotNull VH holder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        T item = getItem(position);
        if (payloads.isEmpty()) {
            holder.bind$urbanairship_message_center_release(item);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : payloads) {
            if (t instanceof EditableRecyclerView.Payload) {
                arrayList.add(t);
            }
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            holder.bind$urbanairship_message_center_release(item, (EditableRecyclerView.Payload) it.next());
        }
    }
}

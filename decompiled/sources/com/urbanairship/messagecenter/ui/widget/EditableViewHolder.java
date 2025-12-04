package com.urbanairship.messagecenter.ui.widget;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.urbanairship.messagecenter.ui.widget.EditableRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H ¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u000e\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0015H&J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0015H&R\u0016\u0010\u0007\u001a\u00028\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/EditableViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "(Landroid/view/View;)V", "editableItemView", "getEditableItemView$urbanairship_message_center_release", "()Landroid/view/View;", "Landroid/view/View;", "bind", "", "item", "bind$urbanairship_message_center_release", "(Ljava/lang/Object;)V", "payload", "Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload;", "(Ljava/lang/Object;Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload;)V", "updateEditing", "isEditing", "", "updateHighlighted", "isHighlighted", "updateSelected", "isSelected", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class EditableViewHolder<T, V extends View> extends RecyclerView.ViewHolder {
    private final View editableItemView;

    public abstract void bind$urbanairship_message_center_release(T item);

    public abstract void updateEditing(boolean isEditing);

    public abstract void updateHighlighted(boolean isHighlighted);

    public abstract void updateSelected(boolean isSelected);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditableViewHolder(@NotNull V itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.editableItemView = itemView;
    }

    @NotNull
    public final V getEditableItemView$urbanairship_message_center_release() {
        return (V) this.editableItemView;
    }

    public final void bind$urbanairship_message_center_release(T item, @NotNull EditableRecyclerView.Payload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (payload instanceof EditableRecyclerView.Payload.UpdateEditing) {
            updateEditing(((EditableRecyclerView.Payload.UpdateEditing) payload).isEditing());
        } else if (payload instanceof EditableRecyclerView.Payload.UpdateSelected) {
            updateSelected(((EditableRecyclerView.Payload.UpdateSelected) payload).isSelected());
        } else if (payload instanceof EditableRecyclerView.Payload.UpdateHighlighted) {
            updateHighlighted(((EditableRecyclerView.Payload.UpdateHighlighted) payload).isHighlighted());
        }
    }
}

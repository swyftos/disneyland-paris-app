package com.urbanairship.messagecenter.ui.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.dlp.BluetoothManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.messagecenter.ui.widget.EditableViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0012\b\u0001\u0010\u0003*\f\u0012\u0004\u0012\u0002H\u0001\u0012\u0002\b\u00030\u0004*\u0004\b\u0002\u0010\u00052\u00020\u0006:\u0003./0B%\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0006\u0010%\u001a\u00020&J\u0012\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0002H\u0014J\n\u0010)\u001a\u0004\u0018\u00010\u0002H\u0014J\u0006\u0010*\u001a\u00020&J\u0016\u0010+\u001a\u00020&2\f\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010-H\u0016R(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R$\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u00061"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "VH", "Lcom/urbanairship/messagecenter/ui/widget/EditableViewHolder;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "editableAdapter", "Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter;", "getEditableAdapter", "()Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter;", "setEditableAdapter", "(Lcom/urbanairship/messagecenter/ui/widget/EditableListAdapter;)V", "isAllSelected", "", "()Z", "value", "isEditing", "setEditing", "(Z)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Listener;", "getListener", "()Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Listener;", "setListener", "(Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Listener;)V", "selectedItems", "", "getSelectedItems", "()Ljava/util/List;", "clearSelected", "", "onRestoreInstanceState", BluetoothManager.BLE_STATUS_PARAM, "onSaveInstanceState", "selectAll", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Listener", "Payload", "SavedState", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEditableRecyclerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditableRecyclerView.kt\ncom/urbanairship/messagecenter/ui/widget/EditableRecyclerView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,317:1\n1603#2,9:318\n1855#2:327\n1856#2:329\n1612#2:330\n1#3:328\n*S KotlinDebug\n*F\n+ 1 EditableRecyclerView.kt\ncom/urbanairship/messagecenter/ui/widget/EditableRecyclerView\n*L\n86#1:318,9\n86#1:327\n86#1:329\n86#1:330\n86#1:328\n*E\n"})
/* loaded from: classes5.dex */
public abstract class EditableRecyclerView<T extends Parcelable, VH extends EditableViewHolder<T, ?>, A> extends RecyclerView {
    private EditableListAdapter editableAdapter;
    private boolean isEditing;
    private Listener listener;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00042\u0006\u0010\u0007\u001a\u00028\u0003H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0003H&¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u000bH&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Listener;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "onAction", "", "action", "item", "(Ljava/lang/Object;Ljava/lang/Object;)V", "onEditModeChanged", "isEditing", "", "onItemClicked", "(Ljava/lang/Object;)V", "onSelectionChanged", "selectedItems", "", "isAllSelected", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener<T, A> {
        void onAction(A action, T item);

        void onEditModeChanged(boolean isEditing);

        void onItemClicked(T item);

        void onSelectionChanged(@NotNull List<? extends T> selectedItems, boolean isAllSelected);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EditableRecyclerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EditableRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ EditableRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EditableRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Nullable
    public final Listener<T, A> getListener() {
        return this.listener;
    }

    public final void setListener(@Nullable Listener<T, A> listener) {
        this.listener = listener;
    }

    /* renamed from: isEditing, reason: from getter */
    public final boolean getIsEditing() {
        return this.isEditing;
    }

    public final void setEditing(boolean z) {
        Unit unit;
        if (this.isEditing != z) {
            this.isEditing = z;
            Listener listener = this.listener;
            if (listener != null) {
                listener.onEditModeChanged(z);
            }
            EditableListAdapter editableListAdapter = this.editableAdapter;
            if (editableListAdapter != null) {
                if (!z) {
                    editableListAdapter.clearSelected();
                }
                editableListAdapter.notifyItemRangeChanged(0, editableListAdapter.getItemCount(), new Payload.UpdateEditing(z));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                UALog.w$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.EditableRecyclerView.isEditing.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Adapter is not set!";
                    }
                }, 1, null);
            }
        }
    }

    @Nullable
    protected final EditableListAdapter<T, VH> getEditableAdapter() {
        return this.editableAdapter;
    }

    protected final void setEditableAdapter(@Nullable EditableListAdapter<T, VH> editableListAdapter) {
        this.editableAdapter = editableListAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) throws IllegalArgumentException {
        if (isInEditMode()) {
            super.setAdapter(adapter);
            return;
        }
        EditableListAdapter editableListAdapter = adapter instanceof EditableListAdapter ? (EditableListAdapter) adapter : null;
        if (editableListAdapter == null) {
            throw new IllegalArgumentException("EditableRecyclerView requires an Adapter that extends from EditableListAdapter!");
        }
        super.setAdapter(editableListAdapter);
        this.editableAdapter = editableListAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        List listEmptyList;
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        boolean z = this.isEditing;
        EditableListAdapter editableListAdapter = this.editableAdapter;
        if (editableListAdapter == null || (listEmptyList = editableListAdapter.getSelected()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        EditableListAdapter editableListAdapter2 = this.editableAdapter;
        return new SavedState(parcelableOnSaveInstanceState, z, listEmptyList, editableListAdapter2 != null ? editableListAdapter2.getHighlightedItemId() : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable state) {
        Parcelable superState = null;
        if (state instanceof SavedState) {
            SavedState savedState = (SavedState) state;
            setEditing(savedState.isEditing());
            EditableListAdapter editableListAdapter = this.editableAdapter;
            if (editableListAdapter != null) {
                List<Parcelable> selectedItems = savedState.getSelectedItems();
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : selectedItems) {
                    if (parcelable == null) {
                        parcelable = null;
                    }
                    if (parcelable != null) {
                        arrayList.add(parcelable);
                    }
                }
                editableListAdapter.restoreSelected(arrayList);
            }
            EditableListAdapter editableListAdapter2 = this.editableAdapter;
            if (editableListAdapter2 != null) {
                editableListAdapter2.setHighlightedItemId(savedState.getHighlightedItemId());
            }
            superState = savedState.getSuperState();
        }
        super.onRestoreInstanceState(superState);
    }

    @NotNull
    public final List<T> getSelectedItems() {
        List<T> selected;
        EditableListAdapter editableListAdapter = this.editableAdapter;
        return (editableListAdapter == null || (selected = editableListAdapter.getSelected()) == null) ? CollectionsKt.emptyList() : selected;
    }

    public final boolean isAllSelected() {
        EditableListAdapter editableListAdapter = this.editableAdapter;
        if (editableListAdapter != null) {
            return editableListAdapter.isAllSelected();
        }
        return false;
    }

    public final void selectAll() {
        EditableListAdapter editableListAdapter = this.editableAdapter;
        if (editableListAdapter != null) {
            editableListAdapter.selectAll();
        }
    }

    public final void clearSelected() {
        EditableListAdapter editableListAdapter = this.editableAdapter;
        if (editableListAdapter != null) {
            editableListAdapter.clearSelected();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload;", "", "()V", "UpdateEditing", "UpdateHighlighted", "UpdateSelected", "Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload$UpdateEditing;", "Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload$UpdateHighlighted;", "Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload$UpdateSelected;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Payload {
        public /* synthetic */ Payload(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Payload() {
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload$UpdateEditing;", "Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload;", "isEditing", "", "(Z)V", "()Z", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpdateEditing extends Payload {
            private final boolean isEditing;

            public static /* synthetic */ UpdateEditing copy$default(UpdateEditing updateEditing, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = updateEditing.isEditing;
                }
                return updateEditing.copy(z);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsEditing() {
                return this.isEditing;
            }

            @NotNull
            public final UpdateEditing copy(boolean isEditing) {
                return new UpdateEditing(isEditing);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateEditing) && this.isEditing == ((UpdateEditing) other).isEditing;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isEditing);
            }

            @NotNull
            public String toString() {
                return "UpdateEditing(isEditing=" + this.isEditing + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public UpdateEditing(boolean z) {
                super(null);
                this.isEditing = z;
            }

            public final boolean isEditing() {
                return this.isEditing;
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload$UpdateSelected;", "Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload;", "isSelected", "", "(Z)V", "()Z", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpdateSelected extends Payload {
            private final boolean isSelected;

            public static /* synthetic */ UpdateSelected copy$default(UpdateSelected updateSelected, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = updateSelected.isSelected;
                }
                return updateSelected.copy(z);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsSelected() {
                return this.isSelected;
            }

            @NotNull
            public final UpdateSelected copy(boolean isSelected) {
                return new UpdateSelected(isSelected);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateSelected) && this.isSelected == ((UpdateSelected) other).isSelected;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isSelected);
            }

            @NotNull
            public String toString() {
                return "UpdateSelected(isSelected=" + this.isSelected + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public UpdateSelected(boolean z) {
                super(null);
                this.isSelected = z;
            }

            public final boolean isSelected() {
                return this.isSelected;
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload$UpdateHighlighted;", "Lcom/urbanairship/messagecenter/ui/widget/EditableRecyclerView$Payload;", "isHighlighted", "", "(Z)V", "()Z", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpdateHighlighted extends Payload {
            private final boolean isHighlighted;

            public static /* synthetic */ UpdateHighlighted copy$default(UpdateHighlighted updateHighlighted, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = updateHighlighted.isHighlighted;
                }
                return updateHighlighted.copy(z);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsHighlighted() {
                return this.isHighlighted;
            }

            @NotNull
            public final UpdateHighlighted copy(boolean isHighlighted) {
                return new UpdateHighlighted(isHighlighted);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateHighlighted) && this.isHighlighted == ((UpdateHighlighted) other).isHighlighted;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isHighlighted);
            }

            @NotNull
            public String toString() {
                return "UpdateHighlighted(isHighlighted=" + this.isHighlighted + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public UpdateHighlighted(boolean z) {
                super(null);
                this.isHighlighted = z;
            }

            public final boolean isHighlighted() {
                return this.isHighlighted;
            }
        }
    }

    private static final class SavedState implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();
        private final String highlightedItemId;
        private final boolean isEditing;
        private final List selectedItems;
        private final Parcelable superState;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SavedState createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Parcelable parcelable = parcel.readParcelable(SavedState.class.getClassLoader());
                boolean z = parcel.readInt() != 0;
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(parcel.readParcelable(SavedState.class.getClassLoader()));
                }
                return new SavedState(parcelable, z, arrayList, parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SavedState)) {
                return false;
            }
            SavedState savedState = (SavedState) obj;
            return Intrinsics.areEqual(this.superState, savedState.superState) && this.isEditing == savedState.isEditing && Intrinsics.areEqual(this.selectedItems, savedState.selectedItems) && Intrinsics.areEqual(this.highlightedItemId, savedState.highlightedItemId);
        }

        public int hashCode() {
            Parcelable parcelable = this.superState;
            int iHashCode = (((((parcelable == null ? 0 : parcelable.hashCode()) * 31) + Boolean.hashCode(this.isEditing)) * 31) + this.selectedItems.hashCode()) * 31;
            String str = this.highlightedItemId;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "SavedState(superState=" + this.superState + ", isEditing=" + this.isEditing + ", selectedItems=" + this.selectedItems + ", highlightedItemId=" + this.highlightedItemId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeParcelable(this.superState, i);
            out.writeInt(this.isEditing ? 1 : 0);
            List list = this.selectedItems;
            out.writeInt(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                out.writeParcelable((Parcelable) it.next(), i);
            }
            out.writeString(this.highlightedItemId);
        }

        public SavedState(Parcelable parcelable, boolean z, List selectedItems, String str) {
            Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
            this.superState = parcelable;
            this.isEditing = z;
            this.selectedItems = selectedItems;
            this.highlightedItemId = str;
        }

        public final Parcelable getSuperState() {
            return this.superState;
        }

        public final boolean isEditing() {
            return this.isEditing;
        }

        public final List getSelectedItems() {
            return this.selectedItems;
        }

        public final String getHighlightedItemId() {
            return this.highlightedItemId;
        }
    }
}

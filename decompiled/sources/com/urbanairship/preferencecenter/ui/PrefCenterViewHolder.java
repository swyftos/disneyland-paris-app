package com.urbanairship.preferencecenter.ui;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.urbanairship.preferencecenter.ui.item.PrefCenterItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PrefCenterViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "(Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;)V", "bindItem", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PrefCenterViewHolder<T extends PrefCenterItem> extends RecyclerView.ViewHolder {
    public abstract void bind(@NotNull T item);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrefCenterViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public final void bindItem(@NotNull PrefCenterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        bind(item);
    }
}
